package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.*;
import com.caxs.minos.def.DBConst;
import com.caxs.minos.def.ErrorCode;
import com.caxs.minos.domain.*;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.domain.trans.PunishIntFieldsTrans;
import com.caxs.minos.enums.LoanOpCodeEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.IBatchJoErrorLogService;
import com.caxs.minos.serv.db.IOverdueIntAccrualService;
import com.caxs.minos.serv.db.IPunishCalorService;
import com.caxs.minos.utils.LoanRelateUtils;
import com.caxs.minos.utils.PayShchedueCalUtils;
import com.caxs.minos.utils.SystemUtils;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/***
 * @ClassName(类名) : OverdueIntAccrualService
 * @Description(描述) : 逾期利息计提
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class OverdueIntAccrualService implements IOverdueIntAccrualService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());
    private Boolean isLoanStpInt = null;


    @Reference
    IPunishCalorService punishCalorService;

    @Reference
    IBatchJoErrorLogService batchJoErrorLogService;

    @Reference
    LmLoanDao lmLoanDao;

    @Reference
    LmLoanContDao lmLoanContDao;

    @Reference
    LmPmShdDao lmPmShdDao;

    @Reference
    LmLoanSuspFuncDao lmLoanSuspFuncDao;

    @Reference
    SCcyDao sCcyDao;

    /**
     * 逾期利息计提
     * @param jobContext
     * @param sbch
     * @return
     * @throws MinosException
     */
    @Override
    public void listtransOdIntDBTrans(BatchJobContextTrans jobContext, SBch sbch)
            throws MinosException {

        try {
            List<LmLoan> loanList = null;
            lmLoanDao.updateForOverdueAccrual(
                    sbch.getBchCde(),YnFlagEnum.NO.getCodeInDb(),YnFlagEnum.YES.getCodeInDb());
            boolean hasAcc = false;
            do {
                loanList = lmLoanDao.findForOverdueAccrual(sbch.getBchCde(),
                        jobContext.getBuzDate(),YnFlagEnum.NO.getCodeInDb(),YnFlagEnum.YES.getCodeInDb());
                if (log.isDebugEnabled())
                    log.debug("待处理" + loanList.size() + "条");
                for ( LmLoan loan : loanList) {
                    try {
                        LmLoanCont lmLoanCont = lmLoanContDao.selectOneByLoanContNo(loan.getLoanContNo());
                        LoanRelateUtils  loanRelate = new LoanRelateUtils(loan, lmLoanCont);
                        loanRelate.getLoan().setPrcsPageDtInd(YnFlagEnum.YES.getCodeInDb());
                        lmLoanDao.update(loanRelate.getLoan());
                        if (isLoanStopInt(null, jobContext.getBuzDate())) {
                            continue;
                        }
                        if ( saveOdIntAccrual(jobContext, loanRelate) ) {
                            if (!hasAcc) {
                                hasAcc = true;
                            }
                        }
                    } catch (Exception e) {
                        if (e instanceof RuntimeException) {
                            batchJoErrorLogService.saveErrLogNoIncCount(loan.getLoanNo(),jobContext.getBuzDate(),
                                    jobContext.getJobExe(),"逾期利息计提批量处理失败,借据号 [" + loan.getLoanNo() +
                                            " ] , 错误信息 [ " + e.getMessage() + " ]", ErrorCode.ERROR00009);
                        } else {
                            batchJoErrorLogService.saveErrLogNoIncCount(loan.getLoanNo(),jobContext.getBuzDate(),
                                    jobContext.getJobExe(),"逾期利息计提批量处理失败,借据号 [" + loan.getLoanNo() +
                                            " ] , 错误信息 [ " + e.getMessage() + " ]", ErrorCode.ERROR00009);
                            throw (MinosException) e;
                        }
                        if (log.isDebugEnabled()) {
                            log.error("逾期利息批量处理失败，异常loan_no=" + loan.getLoanNo(), e);
                        }
                    }
                }
            } while (loanList.size() == DBConst.PAGE_RECORD);
        } catch (RuntimeException re) {
            re.printStackTrace();
            throw new MinosException("批量记录计提信息失败！");
        }
    }

    /**
     * 罚息计提。
     * @param jobContext
     * @param loanRelate
     */
    public boolean saveOdIntAccrual(BatchJobContextTrans jobContext,
                                    LoanRelateUtils loanRelate){
        boolean isBackuped = false;
        boolean hasNormAcc = true;
        BigDecimal totalNormOdInt = new BigDecimal(0);
        BigDecimal totalSuspOdInt = new BigDecimal(0);/* 非应计罚息 */

        List<LmPmShd> lmPmShdList = lmPmShdDao.findAllNotReturnForOdInt(loanRelate.getLoanNo(),
                        jobContext.getBuzDate());
        if ( CollectionUtils.isEmpty(lmPmShdList) ) {
            return false;
        }
        // 构造PunisCal对象
        // 执行PunisCal对象主方法 execute()
        Map<Integer, PunishIntFieldsTrans> punishIntFieldsList = punishCalorService.execute(
                lmPmShdList,jobContext.getBuzDate(),true,true,true);
        if ( hasNormAcc ) {
            for (LmPmShd shd : lmPmShdList) {
                PunishIntFieldsTrans fields = punishIntFieldsList.get(shd.getPsPerdNo());
                BigDecimal oldOdIncTaken = SystemUtils.getBigDecimalf(shd.getPsCurOdIncTaken());
                BigDecimal thisOdIntTaken = oldOdIncTaken.subtract(SystemUtils.getDoubleToBigDecimal(fields.getOdInt()));
                thisOdIntTaken = SystemUtils.getBigDecimalWhenEvenUp(thisOdIntTaken);
                /***一个金额是否<=0***/
                if (SystemUtils.isAmtLessThanOrEqualZero(thisOdIntTaken.doubleValue())) {
                    shd.setPsCurOdIncTaken(SystemUtils.getDoubleToBigDecimal(fields.getOdInt()));
                    lmPmShdDao.update(shd);
                }
            }
        }
        /*************************************
        *** 记账逻辑暂时不写***********/
        // 更新上次计提日期。
        loanRelate.getLoan().setLastOdIntAccDt(jobContext.getBuzDate());
        lmLoanDao.update(loanRelate.getLoan());
        return true;
    }


    /**
     * 通过引用改变payShchedueCalList
     *
     * @param lmpmshdList
     * @param payShchedueCalList
     * @param dBuzDate
     * @return
     * @throws Exception
     */
    private Integer[] setListValue(List<LmPmShd> lmpmshdList,
                                   List<PayShchedueCalUtils> payShchedueCalList, Date dBuzDate)
            throws Exception {
        int i = 0;
        Integer[] perdNos = new Integer[lmpmshdList.size()];
        PayShchedueCalUtils payShchedueCal = null;
        for (Iterator<LmPmShd> it = lmpmshdList.iterator(); it.hasNext(); payShchedueCalList
                .add(payShchedueCal)) {
            LmPmShd lmpmshd = (LmPmShd) it.next();
            payShchedueCal = new PayShchedueCalUtils(lmpmshd, dBuzDate);
            perdNos[i] = lmpmshd.getPsPerdNo();
            i++;
        }
        return perdNos;
    }

    /**
     * 贷款是否停息
     *
     * @return
     */
    public boolean isLoanStopInt(String loanNo,String buzDt) {
        if (isLoanStpInt == null) {
            LmLoanSuspFunc loanSuspFunc = lmLoanSuspFuncDao.findById(
                                loanNo,LoanOpCodeEnum.STOP_OD_INT.getCodeInDb());
            if (loanSuspFunc != null) {
                isLoanStpInt = buzDt.compareTo(loanSuspFunc.getSuspDt()) >= 0;
            } else {
                isLoanStpInt = Boolean.FALSE;
            }
        }
        return isLoanStpInt;

    }
}
