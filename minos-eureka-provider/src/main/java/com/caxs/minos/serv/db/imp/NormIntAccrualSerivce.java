package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.*;
import com.caxs.minos.date.DateOperation;
import com.caxs.minos.def.DBConst;
import com.caxs.minos.def.ErrorCode;
import com.caxs.minos.domain.*;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.*;
import com.caxs.minos.utils.LoanRelateUtils;
import com.caxs.minos.utils.RoundingUtil;
import com.caxs.minos.utils.SystemUtils;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
/***
 * @ClassName(类名) : NormIntAccrualSerivce
 * @Description(描述) : 正常利息计提：本金或利息逾期90天后，正常利息不再计提，在贷款日时结息。
 * 已计提部分在90天形态转移时全部转表外，剩余当期未计提部分在结息时转表外
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class NormIntAccrualSerivce implements INormIntAccrualSerivce {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());
    /**
     * 扣款日结息
     */
    private final boolean DUEDAY_SETL_NORM_INT = true;

    @Reference
    ILoanRelateInterestCalcService loanRelateInterestCalcService;

    @Reference
    ILoanEndOfDayDataFlowService loanEndOfDayDataFlowService;

    @Reference
    ILmChgStatRuleService lmChgStatRuleService;

    @Reference
    IBatchJoErrorLogService batchJoErrorLogService;

    @Resource
    LmAtpyDetlDao lmAtpyDetlDao;

    @Resource
    LmLoanContDao lmLoanContDao;

    @Resource
    LmLoanDao lmLoanDao;

    @Resource
    LmPmShdDao lmPmShdDao;

    @Resource
    LmOdIntLogDao lmOdIntLogDao;

    @Resource
    SCcyDao sCcyDao;


    /**
     *  正常利息计提：本金或利息逾期90天后，正常利息不再计提，在贷款日时结息。
     *  已计提部分在90天形态转移时全部转表外，剩余当期未计提部分在结息时转表外
     * @param jobContext
     * @return
     */
    @Override
    public void listtransAccrueDBTrans(BatchJobContextTrans jobContext,SBch sbch) {
        if (log.isDebugEnabled()) {
            log.debug("batch save AccIntLog with accrue!");
        }
        List<LmLoan> loanList = null;
        LoanRelateUtils loanRelate = null;
        boolean hasAcc = false;
        try {
            StringBuffer bchCdes = new StringBuffer("");
            List<SCcy> sccyList = sCcyDao.selectListByObject(new SCcy());
            if (StringUtils.hasText(jobContext.getThreadCntStr())) {
                lmLoanDao.updateForFindAccrualThdCnt(jobContext.getThreadCntStr(),jobContext.getBuzDate());
            }else{
                lmLoanDao.updateForFindAccrual(jobContext.getBuzDate());
            }
            do {
                if (StringUtils.hasText(jobContext.getThreadCntStr())) {
                    loanList = lmLoanDao.findByForIntAccCntStr(jobContext.getThreadCntStr(),jobContext.getBuzDate());
                }else{
                    loanList = lmLoanDao.findByForIntAcc(jobContext.getBuzDate());
                }
                if (log.isDebugEnabled())
                    log.debug("待计提处理借据" + loanList.size() + "条");
                for (LmLoan loan : loanList) {
                    try {
                        LmLoanCont lmLoanCont = lmLoanContDao.selectOneByLoanContNo(loan.getLoanContNo());
                        loanRelate = new LoanRelateUtils(loan, lmLoanCont);
                        loanRelate.getLoan().setPrcsPageDtInd(YnFlagEnum.YES.getCodeInDb());
                        lmLoanDao.update(loanRelate.getLoan());
                        if (!isNeedIntAcc(loanRelate, jobContext.getBuzDate())) {
                            continue;
                        }
                        jobContext.setLoanNo(loan.getLoanNo());
                        if (saveAccrual(jobContext, loanRelate,sccyList)) {
                            if (!hasAcc) {
                                hasAcc = true;
                            }
                        }
                    } catch (Exception re) {
                        re.printStackTrace();
                        batchJoErrorLogService.saveErrLogNoIncCount(loan.getLoanNo(),jobContext.getBuzDate(),
                                jobContext.getJobExe(),"处理错误借据号 [" + loan.getLoanNo() +
                                        " ] 错误, 错误信息 [ " + re.getMessage() + " ]", ErrorCode.ERROR00009);
                        log.error("处理错误借据号 [" + loan.getLoanNo() + " ] 错误, 错误信息 [ " + re.getMessage() + " ]");
                    }
                }
            } while (loanList.size() == DBConst.PAGE_RECORD);
        } catch (RuntimeException re) {
            batchJoErrorLogService.saveErrLogNoIncCount(jobContext.getLoanNo(),jobContext.getBuzDate(),
                    jobContext.getJobExe(),"计提信息失败,借据号 [" + jobContext.getLoanNo() +
                            " ] , 错误信息 [ " + re.getMessage() + " ]", ErrorCode.ERROR00009);
            re.printStackTrace();
            throw new MinosException("批量记录计提信息失败！", re);
        }
    }


    /**
     * 将计提信息存入计提日志
     */
    public boolean saveAccrual(BatchJobContextTrans jobContext,
                               LoanRelateUtils loanRelate,List<SCcy> sccyList){
        /*查询指定借据的小于等于当前业务日志的最大期号*/
        LmPmShd starShd = loanEndOfDayDataFlowService.getInterestDatePmShdEqualToday(
                loanRelate.getLoanNo(),jobContext.getBuzDate());
        if ( starShd == null) {
            throw new MinosException("没有找到计提的参照还款计划信息", ErrorCode.ERROR00019);
        }
        /*查询指定借据的大于等于当前业务日志的最小期号*/
        LmPmShd endShd = loanEndOfDayDataFlowService.findCurrDueDtShd(loanRelate.getLoanNo(),
                jobContext.getBuzDate());
        if ( endShd == null) {
            throw new MinosException("没有找到当前计提期", ErrorCode.ERROR00019);
        }
        boolean processed = saveOnePmShd(jobContext, endShd, loanRelate, starShd);
        // 计提金额 ,计提利息=当期利息-累计计提金额//结息日
        loanRelate.getLoan().setLastIntAccDt(jobContext.getBuzDate());
        lmLoanDao.update(loanRelate.getLoan());
        return processed;
    }


    /**
     * 保存单个借据情况。 如果有计提记账返回真，否则假
     *
     * @param jobContext
     * @param endShd
     * @param loanRelate
     * @param starShd
     * @return
     */
    private boolean saveOnePmShd(BatchJobContextTrans jobContext, LmPmShd endShd,
                                 LoanRelateUtils loanRelate, LmPmShd starShd){
        // 查询在当期计提天数中存在的利率调整
        loanRelateInterestCalcService.getLoanRelateInterestCalc(
                loanRelate.getLoanCont(),loanRelate.getLoan(),starShd,endShd,jobContext.getBuzDate() ,true);
        BigDecimal accAmt =loanRelateInterestCalcService.cal();// 计提金额

        // 如果不是根据期+天来计算利息
        String endDay = DateOperation.getDateIncDayCount(jobContext.getBuzDate(), 1);
        boolean isLastDayInThisMonth = endDay.equals(endShd.getPsDueDt());
        boolean isTLoan = loanRelate.isTLoan();
        if ( (isTLoan) && (!isLastDayInThisMonth) ) {
            return true;
        }
        boolean isAppendAcc = !loanEndOfDayDataFlowService.isCaculateAccordingActualDay(endShd.getLoanNo(),
                endShd.getPsPerdNo().intValue());
        if ( isAppendAcc ) {
            if ( isLastDayInThisMonth || accAmt.compareTo(endShd.getPsNormIntAmt())==1 ) {
                accAmt = endShd.getPsNormIntAmt();
            }

        }
        BigDecimal priorTaken = endShd.getPsIncTaken();
        BigDecimal addedTaken = accAmt.subtract(priorTaken);
        addedTaken = RoundingUtil.roundingBigDecimal(addedTaken);

        //最后一天计提，应该相等。
        if ( isLastDayInThisMonth ) {
            if (!checkAccIsValidAndModify(accAmt, endShd, jobContext)) {
                if (!SystemUtils.isAmtEqual(accAmt.doubleValue(), endShd.getPsNormIntAmt().doubleValue())) {
                    if ( !SystemUtils.isRateEqual(
                            loanRelate.getLoan().getLoanIntRate().doubleValue(),endShd.getPsIntRate().doubleValue())) {
                        throw new MinosException("可能还款计划的利率未同步到借据，两者不等");
                    }
                    throw new MinosException("借据" + loanRelate.getLoanNo()
                            + "计提金额:" + accAmt + "必须等于还款计划正常利息:"
                            + endShd.getPsNormIntAmt());
                }
            }
        }
        /* 普通应收利息计提 */
        boolean hasNormAcc = true;
        if (SystemUtils.isAmtGreatThanZero(addedTaken.doubleValue()) || isLastDayInThisMonth){
            if (hasNormAcc) {
                if ( SystemUtils.isAmtGreat(accAmt.doubleValue(),endShd.getPsNormIntAmt().doubleValue()) ){
                    if (!checkAccIsValidAndModify(accAmt, endShd, jobContext))
                        if (!SystemUtils.isRateEqual(SystemUtils.getBigDecimalfNull(loanRelate.getLoan().getLoanIntRate()),
                                SystemUtils.getBigDecimalfNull(endShd.getPsIntRate()))) {
                            throw new MinosException("可能还款计划的利率未同步到借据，两者不等");
                        }
                    throw new MinosException("借据" + loanRelate.getLoanNo()
                            + "当期计算的正常利息金额:" + accAmt + "不能大于还款计划正常利息:"
                            + endShd.getPsNormIntAmt());
                }
                endShd.setPsIncTaken(accAmt);
            }
            if (!DUEDAY_SETL_NORM_INT) {
                if (endShd.getPsDueDt()
                        .equals(DateOperation.getDateIncDayCount(jobContext.getBuzDate(), 1))) {
                    if ( hasNormAcc ) {
                        endShd.setSetlIncTaken(endShd.getPsNormIntAmt());
                    }
                }
            }
            endShd.setPsIncTaken(accAmt);
        }
        lmPmShdDao.update(endShd);
        return  true;
    }



    /**
     * 是否需要利息计提
     * @param loanRelate
     * @param buzDate
     * @return
     */
    private boolean isNeedIntAcc(LoanRelateUtils loanRelate, String buzDate) {
        if (!loanRelate.isLoanOverDate()) {
            if (buzDate.equals(loanRelate.getLastDueDt())) {
                return false;
            }
        }
        if (loanRelate.isWTLoan()) {
            return true;
        }
        if (loanRelate.getLoanDevaInd() == YnFlagEnum.NO) {
            if (SystemUtils.isAmtEqualZero(SystemUtils.getBigDecimalfNull(
                    loanRelate.getLoanOsPrcp()))) {
                LmPmShd curDueShd = loanEndOfDayDataFlowService.findCurrDueDtShd(loanRelate.getLoanNo(), buzDate);
                if (SystemUtils.isAmtGreat(SystemUtils.getBigDecimalfNull(curDueShd.getPsIncTaken()),
                        SystemUtils.getBigDecimalfNull(curDueShd.getSetlIncTaken()))) {
                    return true;
                }
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    /**
     * 是否可以修正
     *
     * @param accAmt
     * @param shd
     * @return
     */
    private boolean checkAccIsValidAndModify(BigDecimal accAmt, LmPmShd shd,BatchJobContextTrans jobContext) {
        BigDecimal subs = shd.getPsNormIntAmt().subtract(accAmt);
        subs = SystemUtils.getBigDecimalWhenEvenUp(subs);
        boolean isValid = (Math.abs(subs.doubleValue()) == 0.01);
        if (isValid) {
            shd.setPsNormIntAmt(accAmt);
            batchJoErrorLogService.saveErrLogNoIncCount(shd.getLoanNo(),jobContext.getBuzDate(),
                    jobContext.getJobExe(),"误差一分钱，忽略[" + shd.getLoanNo() +
                            " ]  " + "" + " ]", ErrorCode.ERROR10023);
        }
        return isValid;
    }
}
