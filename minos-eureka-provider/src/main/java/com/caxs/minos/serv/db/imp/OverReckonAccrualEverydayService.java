package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.*;
import com.caxs.minos.date.DateOperation;
import com.caxs.minos.def.DBConst;
import com.caxs.minos.def.ErrorCode;
import com.caxs.minos.def.LoanVarDef;
import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.*;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.domain.trans.PunishIntFieldsTrans;
import com.caxs.minos.enums.*;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.*;
import com.caxs.minos.utils.*;
import com.yuchengtech.ycloans.common.enumeration.PaymentFreq;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
/***
 * @ClassName(类名) : OverReckonAccrualEverydayService
 * @Description(描述) : 罚息及复利结息
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class OverReckonAccrualEverydayService implements IOverReckonAccrualEverydayService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());
    /**批量锁*/
    private Object lockbatch = new Object();

    @Reference
    ILoanEndOfDayDataFlowService loanEndOfDayDataFlowService;

    @Reference
    ILmChgStatRuleService lmChgStatRuleService;

    @Reference
    IBatchJoErrorLogService batchJoErrorLogService;

    @Reference
    ISystemInfoService systemInfoService;

    @Reference
    IPunishCalorService punishCalorService;

    @Reference
    LmAtpyDetlDao  lmAtpyDetlDao;

    @Reference
    LmLoanContDao lmLoanContDao;

    @Reference
    LmLoanDao lmLoanDao;

    @Reference
    LmPmShdDao  lmPmShdDao;

    @Reference
    LmOdIntLogDao lmOdIntLogDao;

    @Reference
    SCcyDao sCcyDao;



    /**
     * 批量结息调用主函数:
     * 1.委托贷款在每月20号时将利息结入表外。
     * 2.逾期后的罚息在每月20号结息入表外 2.逾期90天后的正常利息直接结入表外
     * @param jobContext
     * @param sbch
     */
    @Override
    public void listtransReckonAccrual(BatchJobContextTrans jobContext, SBch sbch) {
        LmLoanCont lmLoanCont = null;
        List<LmLoan> lmLoanList = null;
        // 批处理之前先把满足条件的数据标识设置为未处理 （N）
        lmLoanDao.executeUpdatePrcsPageDtInd(jobContext.getThreadCntStr());
        do {
            synchronized (lockbatch) {
                lmLoanList = lmLoanDao.findLoanInfoToKnotInstOrRollingPlot(jobContext.getThreadCntStr());
            }
            // 如果没有查询到数据，那么退出
            if (lmLoanList.size() == 0)
                return;
            for (LmLoan  lmloan : lmLoanList) {
                try {
                    lmloan.setPrcsPageDtInd("Y");
                    lmLoanDao.update(lmloan);
                    lmLoanCont = lmLoanContDao.selectOneByLoanContNo(lmloan.getLoanContNo());
                    LoanRelateUtils loanRelateTrans = new LoanRelateUtils(lmloan, lmLoanCont);
                    // 如果当前业务业务日期是该借据的结息日则对该借据做结息处理
                    if (penaltyOnTheNextNode(loanRelateTrans,jobContext)) {
                        saveKnotInterest(jobContext,loanRelateTrans);
                    }
                } catch (RuntimeException re) {
                    batchJoErrorLogService.saveErrLogNoIncCount(lmloan.getLoanNo(),jobContext.getBuzDate(),
                            jobContext.getJobExe(),"处理错误借据号 [" + lmloan.getLoanNo() +
                                    " ] 错误, 错误信息 [ " + re.getMessage() + " ]", ErrorCode.ERROR00009);
                    re.printStackTrace();
                    log.error("处理错误借据号 [" + lmloan.getLoanNo() +
                            " ] 错误, 错误信息 [ " + re.getMessage() + " ]");
                } catch (Exception e) {
                    batchJoErrorLogService.saveErrLogNoIncCount(lmloan.getLoanNo(),jobContext.getBuzDate(),
                            jobContext.getJobExe(),"处理错误借据号 [" + lmloan.getLoanNo() +
                                    " ] 错误, 错误信息 [ " + e.getMessage() + " ]", ErrorCode.ERROR00009);
                    e.printStackTrace();
                    log.error("处理错误借据号 [" + lmloan.getLoanNo() +
                            " ] 错误, 错误信息 [ " + e.getMessage() + " ]");
                }
            }
        } while (lmLoanList.size() == DBConst.PAGE_RECORD);
    }

    /**
     *
     *结息处理,委托贷款只更新还款计划表，且委托贷款都没有做过减值处理
     * @param jobContext
     * @param lr
     */
    public void saveKnotInterest(BatchJobContextTrans jobContext,LoanRelateUtils lr)
            throws Exception{
        // 通过借据号取借据对应的一年的天数
        SCcy sCcy =new SCcy();
        sCcy.setCcyCde(lr.getLoan().getLoanCcy());
        sCcy = sCcyDao.selectOneByObject(sCcy);
        if (sCcy == null)
            throw new MinosException("not found ccyCde");
        /* 新罚息利率 */
        LoanRateUtils loanRate = new LoanRateUtils(lr.getLoan(), lr.getLoanCont(),sCcy.getCcyBase());
        // 根据借据号查询需要做结息处理的期数
        List<LmPmShd> lmPmShdList = null;
        if (PaymentFreq.NULL.equals(lr.getPaymentFreq())) {
            lmPmShdList = lmPmShdDao.findOneTimePay(lr.getLoan().getLoanNo());
        } else {
            lmPmShdList = lmPmShdDao.findShapeTrans(lr.getLoan().getLoanNo(),
                    DateOperation.dateStringAddDay(jobContext.getBuzDate(), 1), jobContext.getBuzDate());
        }
        // 没有符合条件的记录该借据不作处理
        if (lmPmShdList == null || lmPmShdList.isEmpty()) {
            batchJoErrorLogService.saveErrLogNoIncCount(lr.getLoan().getLoanNo(),jobContext.getBuzDate(),
                    jobContext.getJobExe(),"数据出错，该借据没有可结息的还款计划，请检查", ErrorCode.ERROR00009);
            return;
        }
        // 构造PunisCal对象
        // 执行PunisCal对象主方法 execute()
        Map<Integer, PunishIntFieldsTrans> punishIntFieldsList = punishCalorService.execute(
                lmPmShdList,jobContext.getBuzDate(),true,true,true);
        List<LmOdIntLog> lmOdIntLogList = new ArrayList<LmOdIntLog>();
        BigDecimal transAmt = new BigDecimal(0);
        // 未减值贷款 处理A05 ,泰安商行委托结息发核心记账，逾期贷款罚息结息和逾期90天后正常利息结息)
        if ( lr.getLoan().getLoanDevaInd() == null
                || "".equals(lr.getLoan().getLoanDevaInd())
                        || "N".equals(lr.getLoan().getLoanDevaInd())) {
            BigDecimal accountNormInt = new BigDecimal(0);
            BigDecimal accountOdInt =new BigDecimal(0);
            BigDecimal odInt = new BigDecimal(0);
            BigDecimal commInt = new BigDecimal(0);
            BigDecimal appendOdInt = new BigDecimal(0);
            BigDecimal suspCommInt = new BigDecimal(0);
            BigDecimal suspOdInt = new BigDecimal(0);
            int index = 1;
            PunishIntFieldsTrans punishIntFields = null;
            for ( LmPmShd shd : lmPmShdList ) {
                punishIntFields = punishIntFieldsList.get(shd.getPsPerdNo());
                odInt = odInt.add(SystemUtils.getDoubleToBigDecimal(punishIntFields.getOdInt()));
                odInt = odInt.add(shd.getSetlOdIncTaken());
                commInt = commInt.add(SystemUtils.getDoubleToBigDecimal(punishIntFields.getCommInt()));
                transAmt = commInt.add(odInt).add(transAmt);
                // 正常利息补结息
                accountNormInt =shd.getPsNormIntAmt().add(shd.getPsIncTaken());
                appendOdInt = shd.getPsIncTaken().add(shd.getSetlIncTaken());
                // 有转表外时，将正常未转表外利息转表外
                if (SystemUtils.isAmtGreatThanZero(accountNormInt.doubleValue())
                        || SystemUtils.isAmtGreatThanZero(appendOdInt.doubleValue())) {
                    odInt = odInt.add(accountNormInt);
                    shd.setPsIncTaken(shd.getPsNormIntAmt());
                    shd.setSetlIncTaken(shd.getPsNormIntAmt());
                    transAmt = transAmt.add(accountNormInt);
                    transAmt = transAmt.add(appendOdInt);
                }
                /**************************************************
                if (lmChgStatRuleService.isPartSusp()) {
                    if (PrcpAndIntStateEnum.getEnum(shd.getIntState()) == PrcpAndIntStateEnum.NONACCRUAL) {
                        suspOdInt = suspOdInt.add(SystemUtils.getDoubleToBigDecimal(punishIntFields.getOdInt()));
                        suspOdInt = suspOdInt.add(shd.getPsCurOdIncTaken());
                        suspCommInt = suspCommInt.add(commInt);
                    }
                }
                // 记录罚息日志表
                if (SystemUtils
                        .isAmtGreatThanZero(punishIntFields.getCommInt())) {
                    // 计算基数
                    BigDecimal odOsAmt =shd.getPsOdIntAmt().add(shd.getPsCommOdInt());
                    // ID赋值
                    String fromDt = (shd.getCommOdGenDt() == null || ""
                            .equals(shd.getCommOdGenDt())) ? shd.getPsDueDt() : DateOperation.dateStringAddDay(shd.getCommOdGenDt(), 1);
                    Integer txLogSeq= Integer.valueOf(systemInfoService.getNextValDual());

                    LmOdIntLog lmOdIntLog = new LmOdIntLog(txLogSeq, index++, lr.getLoan().getLoanNo(),
                            shd.getPsPerdNo(), jobContext.getBuzDate(), lr.getLoan().getLoanOdIntRate(), odOsAmt,
                            fromDt, jobContext.getBuzDate(), SystemUtils.getDoubleToBigDecimal(punishIntFields.getCommInt()),
                            CommPartEnum.INTEREST.getCodeInDb(), "II", new BigDecimal(0D), "Y", fromDt,
                            new BigDecimal(0.00),SystemUtils.getDoubleToBigDecimal(punishIntFields.getProdPrcpAmt()),
                            SystemUtils.getDoubleToBigDecimal(punishIntFields.getProdCommAmt()));
                    lmOdIntLogList.add(lmOdIntLog);
                }
                if (SystemUtils.isAmtGreatThanZero(punishIntFields.getOdInt())) {
                    // 不提罚息
                    accountOdInt =accountOdInt.add(SystemUtils.getDoubleToBigDecimal(punishIntFields.getOdInt()));
                    accountOdInt = accountOdInt.add(shd.getPsCurOdIncTaken());
                    transAmt = transAmt.add(odInt);
                    // ID赋值
                    // 本期结罚息开始日期
                    String fromDt = (shd.getCommOdGenDt() == null || ""
                            .equals(shd.getCommOdGenDt())) ? shd.getPsDueDt() : DateOperation.dateStringAddDay(shd.getCommOdGenDt(), 1);
                    Integer txLogSeq= Integer.valueOf(systemInfoService.getNextValDual());
                    // 计算基数
                    BigDecimal odOsAmt = shd.getPsPrcpAmt();

                    LmOdIntLog lmOdIntLog = new LmOdIntLog(txLogSeq, index++, lr.getLoan().getLoanNo(),
                            shd.getPsPerdNo(), jobContext.getBuzDate(), lr.getLoan().getLoanOdIntRate(), odOsAmt,
                            fromDt, jobContext.getBuzDate(), SystemUtils.getDoubleToBigDecimal(punishIntFields.getOdInt()),
                            CommPartEnum.PROP.getCodeInDb(), "II", new BigDecimal(0D), "Y", fromDt,
                            shd.getProdPrcpAmt(),SystemUtils.getDoubleToBigDecimal(punishIntFields.getProdOdAmt()),
                            SystemUtils.getDoubleToBigDecimal(punishIntFields.getProdCommAmt()));
                    lmOdIntLogList.add(lmOdIntLog);
                }*********************************/
                this.updateLmPmShd(shd, punishIntFields, jobContext.getBuzDate(), "true", lr);
            }
            if (!CollectionUtils.isEmpty(lmOdIntLogList)) {
                lmOdIntLogDao.saveList(lmOdIntLogList);
            }
            // 更新借据表的上一次结罚息日
            lr.getLoan().setLnCostProd(new BigDecimal(MinosConst.ZERO_DOUBLE));
            lr.getLoan().setLastGenOdIntDt(jobContext.getBuzDate());
            lmLoanDao.update(lr.getLoan());
            // 正常已减值，处理A08,A06
        } else if ("Y".equals(lr.getLoan().getLoanDevaInd())
                && "NORM".equals(lr.getLoan().getLoanDebtSts())) {
            BigDecimal devNormInt = new BigDecimal(0);
            BigDecimal devOdInt =new BigDecimal(0);
            BigDecimal commInt = new BigDecimal(0);
            PunishIntFieldsTrans punishIntFields = null;
            Integer index = 1;
            for ( LmPmShd shd : lmPmShdList ) {
                punishIntFields = punishIntFieldsList.get(shd.getPsPerdNo());
                commInt = commInt.add(SystemUtils.getDoubleToBigDecimal(punishIntFields.getCommInt()));
                devOdInt = devOdInt.add(SystemUtils.getDoubleToBigDecimal(punishIntFields.getOdInt()));
                devOdInt = devOdInt.add(shd.getSetlOdIncTaken());
                /*************************************************
                devNormInt = shd.getPsNormIntAmt().add(shd.getSetlIncTaken()).add(devNormInt);
                transAmt = commInt.add(transAmt);
                transAmt = devNormInt.add(devOdInt).add(transAmt);
                if (SystemUtils.isAmtGreatThanZero(devNormInt.doubleValue())) {
                    // insert 罚息日志表,结出减值后表外应收正常利息
                    // 本期结罚息开始日期
                    BigDecimal odOsAmt = shd.getPsRemPrcp();
                    String fromDt = lr.getLoan().getLoanDevaDt();
                    Integer txLogSeq= Integer.valueOf(systemInfoService.getNextValDual());
                    LmOdIntLog lmOdIntLog = new LmOdIntLog(txLogSeq, index, lr.getLoan().getLoanNo(),
                            shd.getPsPerdNo(), jobContext.getBuzDate(), lr.getLoan().getLoanOdIntRate(), odOsAmt,
                            fromDt, jobContext.getBuzDate(), SystemUtils.getDoubleToBigDecimal(punishIntFields.getCommInt()),
                            CommPartEnum.PROP.getCodeInDb(), "PI", new BigDecimal(0D), "Y", fromDt,
                            SystemUtils.getDoubleToBigDecimal(punishIntFields.getProdPrcpAmt()),new BigDecimal(0.00),new BigDecimal(0.00));
                    lmOdIntLogList.add(lmOdIntLog);
                }
                if (SystemUtils.isAmtGreatThanZero(punishIntFields.getOdInt())) {
                    // ID赋值
                    String fromDt = (shd.getCommOdGenDt() == null || ""
                            .equals(shd.getCommOdGenDt())) ? shd.getPsDueDt() : DateOperation.dateStringAddDay(shd.getCommOdGenDt(), 1);

                    // 计算基数
                    BigDecimal odOsAmt =SystemUtils.getBigDecimalWhenEvenUp(shd.getPsPrcpAmt().add(shd.getSetlPrcp()));
                    // 本期结罚息开始日期
                    Integer txLogSeq= Integer.valueOf(systemInfoService.getNextValDual());
                    LmOdIntLog lmOdIntLog = new LmOdIntLog(txLogSeq, index, lr.getLoan().getLoanNo(),
                            shd.getPsPerdNo(), jobContext.getBuzDate(), lr.getLoan().getLoanOdIntRate(), odOsAmt,
                            fromDt, jobContext.getBuzDate(), SystemUtils.getDoubleToBigDecimal(punishIntFields.getCommInt()),
                            CommPartEnum.PROP.getCodeInDb(), "OI", new BigDecimal(0D), "N", fromDt,
                            shd.getProdPrcpAmt(),new BigDecimal(0.00),new BigDecimal(0.00));
                    lmOdIntLogList.add(lmOdIntLog);
                }
                // 记录罚息日志表
                if (SystemUtils
                        .isAmtGreatThanZero(punishIntFields.getCommInt())) {
                    BigDecimal odOsAmt =SystemUtils.getBigDecimalWhenEvenUp(shd.getPsOdIntAmt().add(shd.getPsCommOdInt()));
                    // 本期结罚息开始日期
                    // ID赋值
                    String fromDt = (shd.getCommOdGenDt() == null || ""
                            .equals(shd.getCommOdGenDt())) ? shd.getPsDueDt() : DateOperation.dateStringAddDay(shd.getCommOdGenDt(), 1);
                    Integer txLogSeq= Integer.valueOf(systemInfoService.getNextValDual());
                    LmOdIntLog lmOdIntLog = new LmOdIntLog(txLogSeq, index, lr.getLoan().getLoanNo(),
                            shd.getPsPerdNo(), jobContext.getBuzDate(), lr.getLoan().getLoanOdIntRate(), odOsAmt,
                            fromDt, jobContext.getBuzDate(), SystemUtils.getDoubleToBigDecimal(punishIntFields.getCommInt()),
                            CommPartEnum.INTEREST.getCodeInDb(), "II", new BigDecimal(0D), "Y", fromDt,
                            new BigDecimal(0.00),SystemUtils.getDoubleToBigDecimal(punishIntFields.getProdOdAmt()),
                            SystemUtils.getDoubleToBigDecimal(punishIntFields.getProdCommAmt()));
                    lmOdIntLogList.add(lmOdIntLog);
                }*******************************************/
                this.updateLmPmShd(shd, punishIntFields, jobContext.getBuzDate(), "true", lr);
            }
            if ( lmOdIntLogList.size() != 0 ) {
                lmOdIntLogDao.saveList(lmOdIntLogList);
                // 更新借据表的上一次结罚息日
                lr.getLoan().setLastGenOdIntDt(jobContext.getBuzDate());
                lmLoanDao.update(lr.getLoan());
            }
            // 逾期已减值，处理A08和A07
        } else if ("Y".equals(lr.getLoan().getLoanDevaInd())
                && "OVER".equals(lr.getLoan().getLoanDebtSts())) {
            String buzDate = jobContext.getBuzDate();
            BigDecimal odIntIn = new BigDecimal(0); // 表内的罚息
            BigDecimal devOdInt = new BigDecimal(0); // 表外的罚息
            BigDecimal commInt = new BigDecimal(0);// 复利
            int index = 1;
            String fromDate = null;
            Date firstOverDueDate = null; // 逾期后的第一个结息日(Date型)
            String firstOverDueDateStr = null; // 逾期后的第一个结息日(String型)
            // 计算逾期之后第一次结息日
            firstOverDueDate = DateOperation.getFirstPayDateByPaymentFreq(
                    lr.getLoan().getLastDueDt(), lr.getLoan().getDueDay(), PaymentFreq
                            .getEnum(lr.getLoan().getPaymFreqUnit()), lr.getLoan().getPaymFreqFreq(),
                    isFirstPerdOverOnePaymentFreq(lr));
            // 选中记录中的最大期数
            int maxTermNo = lmPmShdList.get(0).getPsPerdNo();
            for (int i = 0; i < lmPmShdList.size(); i++) {
                if (maxTermNo < lmPmShdList.get(i).getPsPerdNo()) {
                    maxTermNo = lmPmShdList.get(i).getPsPerdNo();
                }
            }
            for (LmPmShd shd : lmPmShdList ) {
                PunishIntFieldsTrans punishIntFields = punishIntFieldsList.get(shd.getPsPerdNo());
                odIntIn = SystemUtils.getBigDecimalf(shd.getSetlOdIncTaken());
                /*
				 * 逾期后的第一个结息日，需要用结出的罚息-已经计提的表内罚息
				 * (当减值日期发生在到期日于到期后的第一个扣款日之间时出现这样的情况
				 * ) 如果是在逾期以前做的减值，也满足上面的表达式，此时已计提的表内罚息是0
				 */
                /*************************************************************
                if (shd.getPsPerdNo() == maxTermNo
                        && buzDate.equals(firstOverDueDateStr)
                        && lr.getLoan().getLoanDevaDt().compareTo(lr.getLoan().getLastDueDt()) >= 0
                        && lr.getLoan().getLoanDevaDt().compareTo(firstOverDueDateStr) < 0) {
                    devOdInt =  devOdInt.add(SystemUtils.getDoubleToBigDecimal(punishIntFields.getOdInt()));
                    devOdInt = devOdInt.add(odIntIn);
                    BigDecimal privousodInt = new BigDecimal(0);
                    fromDate = shd.getPsDueDt();

                }else if (shd.getPsPerdNo() == maxTermNo
                        && buzDate.compareTo(firstOverDueDateStr) > 0
                        && lr.getLoan().getLoanDevaDt().compareTo(firstOverDueDateStr) > 0
                        && lr.getLoan().getLoanDevaDt().compareTo(shd.getCommOdGenDt()) > 0) {

                    devOdInt =  devOdInt.add(SystemUtils.getDoubleToBigDecimal(punishIntFields.getOdInt()));
                    devOdInt = devOdInt.add(odIntIn);
                    fromDate = shd.getCommOdGenDt();
                }else if (shd.getPsPerdNo() == maxTermNo) {
                    devOdInt =  devOdInt.add(SystemUtils.getDoubleToBigDecimal(punishIntFields.getOdInt()));
                    devOdInt = devOdInt.add(odIntIn);
                    fromDate = shd.getCommOdGenDt();
                } else {// 结未还期的罚息
                    devOdInt = devOdInt.add(SystemUtils.getDoubleToBigDecimal(punishIntFields.getOdInt()));
                    devOdInt = devOdInt.add(odIntIn);
                }
                // 复利始终为当期新结出的复利
                commInt = commInt.add(SystemUtils.getDoubleToBigDecimal(punishIntFields.getCommInt()));
                fromDate = fromDate == null ? lr.getLoan().getLastDueDt() : fromDate;
                // 记录罚息日志表,减值前表内,表外的罚息
                if (SystemUtils.isAmtGreatThanZero(odIntIn.doubleValue())) {
                    // 计算基数
                    BigDecimal odOsAmt = shd.getPsOdIntAmt().add(shd.getPsCommOdInt()).add(shd.getPsCurOdIncTaken());
                    Integer txLogSeq= Integer.valueOf(systemInfoService.getNextValDual());
                    LmOdIntLog lmOdIntLog = new LmOdIntLog(txLogSeq, index, lr.getLoan().getLoanNo(),
                            shd.getPsPerdNo(), jobContext.getBuzDate(), lr.getLoan().getLoanOdIntRate(), odOsAmt,
                            fromDate, jobContext.getBuzDate(), SystemUtils.getDoubleToBigDecimal(punishIntFields.getCommInt()),
                            CommPartEnum.INTEREST.getCodeInDb(), "OI", new BigDecimal(0D), "N", fromDate,
                            new BigDecimal(0.00),new BigDecimal(0.00),new BigDecimal(0.00));
                    lmOdIntLogList.add(lmOdIntLog);
                }
                // 记录罚息日志表,减值后表外的罚息
                if (SystemUtils.isAmtGreatThanZero(devOdInt.doubleValue())) {
                    transAmt = transAmt.add(devOdInt);
                    // 计算基数
                    BigDecimal odOsAmt = shd.getPsCommOdInt().add(shd.getPsCommOdInt()).add(shd.getPsOdIncTaken());
                    Integer txLogSeq= Integer.valueOf(systemInfoService.getNextValDual());

                    LmOdIntLog lmOdIntLog = new LmOdIntLog(txLogSeq, index, lr.getLoan().getLoanNo(),
                            shd.getPsPerdNo(), jobContext.getBuzDate(), lr.getLoan().getLoanOdIntRate(), odOsAmt,
                            fromDate, jobContext.getBuzDate(), SystemUtils.getDoubleToBigDecimal(punishIntFields.getCommInt()),
                            CommPartEnum.INTEREST.getCodeInDb(), "OI", new BigDecimal(0D), "Y", lr.getLoan().getLoanDevaDt(),
                            SystemUtils.getDoubleToBigDecimal(punishIntFields.getProdPrcpAmt()),new BigDecimal(0.00),new BigDecimal(0.00));
                    lmOdIntLogList.add(lmOdIntLog);
                }
                // 记录罚息日志表,复利
                if (SystemUtils
                        .isAmtGreatThanZero(punishIntFields.getCommInt())) {
                    transAmt =  transAmt.add(SystemUtils.getDoubleToBigDecimal(punishIntFields.getCommInt()));
                    // 计算基数
                    BigDecimal odOsAmt =  shd.getPsOdIntAmt().add(shd.getPsCommOdInt());
                    Integer txLogSeq= Integer.valueOf(systemInfoService.getNextValDual());
                    // 本期结罚息开始日期
                    String fromDt = (shd.getCommOdGenDt() == null || ""
                            .equals(shd.getCommOdGenDt())) ? shd.getPsDueDt() : DateOperation.dateStringAddDay(shd.getCommOdGenDt(), 1);

                    LmOdIntLog lmOdIntLog = new LmOdIntLog(txLogSeq, index, lr.getLoan().getLoanNo(),
                            shd.getPsPerdNo(), jobContext.getBuzDate(), lr.getLoan().getLoanOdIntRate(), odOsAmt,
                            fromDt, jobContext.getBuzDate(), SystemUtils.getDoubleToBigDecimal(punishIntFields.getCommInt()),
                            CommPartEnum.INTEREST.getCodeInDb(), "II", new BigDecimal(0D), "Y", shd.getCommOdGenDt(),
                            new BigDecimal(0.00),SystemUtils.getDoubleToBigDecimal(punishIntFields.getProdOdAmt()),
                            SystemUtils.getDoubleToBigDecimal(punishIntFields.getProdCommAmt()));
                    lmOdIntLogList.add(lmOdIntLog);
                }*****************/
                this.updateLmPmShd(shd, punishIntFields, jobContext.getBuzDate(), "true", lr);
            }
            if ( lmOdIntLogList.size() != 0 ) {
                lmOdIntLogDao.saveList(lmOdIntLogList); // 更新借据表的上一次结罚息日
                lr.getLoan().setLastGenOdIntDt(jobContext.getBuzDate());
                lmLoanDao.update(lr.getLoan());
            }
        }
    }


    /**
     * 更新还款信息表 涉及金额字段需要修约
     * @param shd
     * @param punishIntFields
     * @param buzDate
     */
    private void updateLmPmShd(LmPmShd shd, PunishIntFieldsTrans punishIntFields,
                               String buzDate, String flag, LoanRelateUtils lr)
            throws Exception {
        if ("true".equals(flag)) {
            shd.setPsOdIntAmt(RoundingUtil.roundingBigDecimal(
                    shd.getPsOdIntAmt().add(new BigDecimal(punishIntFields.getOdInt()))));
            shd.setPsCommOdInt(RoundingUtil.roundingBigDecimal(
                    shd.getPsCommOdInt().add(new BigDecimal(punishIntFields.getCommInt()))));
            if ("Y".equals(lr.getLoanCont().getLoanOdCpdInd())) {
                if ("P".equals(lr.getLoanCont().getLoanOdCommPart())) {
                    shd.setProdPrcpAmt(new BigDecimal(MinosConst.ZERO_DOUBLE));
                } else {
                    shd.setProdPrcpAmt(new BigDecimal(MinosConst.ZERO_DOUBLE));
                    shd.setProdIntAmt(new BigDecimal(MinosConst.ZERO_DOUBLE));
                    shd.setProdCommIntAmt(new BigDecimal(MinosConst.ZERO_DOUBLE));
                }
            }
            shd.setCommOdGenDt(buzDate);
            shd.setPsOdIncTaken(new BigDecimal(punishIntFields.getOdInt()));
            if (lr.getLoanDevaInd() == YnFlagEnum.YES) {
                shd.setSetlIncTaken(shd.getPsIncTaken());
            }
            // 已结罚息
            shd.setSetlOdIncTaken(new BigDecimal(MinosConst.ZERO_DOUBLE));
            shd.setPsCurOdIncTaken(new BigDecimal(MinosConst.ZERO_DOUBLE));
        } else if ("false".equals(flag)) {
            shd.setProdPrcpAmt(RoundingUtil.getBigDecimal(punishIntFields
                    .getProdPrcpAmt(),2));
            shd.setProdIntAmt(RoundingUtil.getBigDecimal(punishIntFields
                    .getProdOdAmt(),2));
            shd.setProdCommIntAmt(RoundingUtil.getBigDecimal(punishIntFields
                    .getProdCommAmt(),2));
            shd.setPsGenProdDt(buzDate);
        }
        //判断是否计算逾期利息
        if (!YnFlagEnum.isTrue( lr.getLoanCont().getLoanOdGraceInd())) {
            shd.setProdPrcpAmt(new BigDecimal(MinosConst.ZERO_DOUBLE));
        }
        //判断是否计算复利
        if (!YnFlagEnum.isTrue( lr.getLoanCont().getLoanOdIntGraceInd())) {
            shd.setProdIntAmt(new BigDecimal(MinosConst.ZERO_DOUBLE));
            shd.setProdCommIntAmt(new BigDecimal(MinosConst.ZERO_DOUBLE));
        }
        lmPmShdDao.update(shd);
    }

    /**
     * 判断是不是该借据的下一个结罚息日
     */
    private boolean penaltyOnTheNextNode(LoanRelateUtils loanRelateTrans , BatchJobContextTrans jobContext){
        boolean flag = false;
        String currentDueDate = null;
        String nextDueDate = null;

        // 计算当前应还的是哪期
        LmPmShd lmPmShd = null;
        if ( LoanStateEnum.NORMAL.getCodeInDb().equals(
                    loanRelateTrans.getLoan().getLoanDebtSts())
                || LoanStateEnum.DELQ.getCodeInDb().equals(
                        loanRelateTrans.getLoan().getLoanDebtSts())) {
            boolean isGenOdInt = false;

            if (CalcOdTimeTypEnum.C.getCodeInDb().equals(
                    LoanVarDef.calcOdTimeTyp)) {
                lmPmShd = loanEndOfDayDataFlowService.findByPsDueDt(
                        loanRelateTrans.getLoanNo(),jobContext.getBuzDate());
                isGenOdInt = (lmPmShd != null);
                if (!isGenOdInt) {
                    lmPmShd = loanEndOfDayDataFlowService.findCurrDueDtShd(
                            loanRelateTrans.getLoanNo(),jobContext.getBuzDate());
                }
            } else {
                lmPmShd = loanEndOfDayDataFlowService.findCurrDueDtShd(
                            loanRelateTrans.getLoanNo(),jobContext.getBuzDate());
                isGenOdInt = DateOperation.dateStringAddDay(jobContext.getBuzDate(), 1).compareTo(
                        lmPmShd.getPsDueDt()) == 0;
            }
            if (!isGenOdInt) {
                // 可能存在本金全部归还，利息还未归还的情况
                if (jobContext.getBuzDate().equals(loanRelateTrans.getLoan().getCurGenOdIntDt())) {
                    isGenOdInt = true;
                }
                if (!isGenOdInt) {
                    if (lmPmShd.getPsDueDt().compareTo(jobContext.getBuzDate()) < 0) {
                        if (StringUtils.isNullOrEmpty(loanRelateTrans.getLoan().getCurGenOdIntDt())) {
                            if (loanRelateTrans.getLoan().getCurGenOdIntDt().compareTo(jobContext.getBuzDate()) > 0) {
                                return false;
                            }
                        }
                        getCurGenOdIntDt(loanRelateTrans, jobContext, lmPmShd
                                .getPsDueDt());
                        return false;
                    }
                }
            }
            if ( isGenOdInt ) {// 本金没有逾期时，取到期日前一天
                flag = true;
            } else if (LoanDevaIndEnum.YES.getCodeInDb().equals(loanRelateTrans.getLoan().getLoanDevaInd())
                    && ("".equals(loanRelateTrans.getLoan().getLastGenOdIntDt()) || loanRelateTrans.getLoan().getLastGenOdIntDt() == null)
                    && ( PaymentFreq.NULL.equals(loanRelateTrans.getPaymentFreq()))) {// 如果没有结过罚息，并且已做减值的利随本清，应当月结息
                nextDueDate = loanRelateTrans.getLoan().getLastDeviIntAccDt();// 取减值日期推算当月结息日
                currentDueDate = DateOperation.getDateStringToDb(DateOperation
                        .getFirstPayDateByPaymentFreq(DateOperation.dateStringAddDay(nextDueDate, 1), loanRelateTrans.getDueDay(),
                                loanRelateTrans.getPaymentFreq(),
                                loanRelateTrans.getFreqenceRange(),isFirstPerdOverOnePaymentFreq(loanRelateTrans)));
                if (currentDueDate.compareTo(DateOperation.dateStringAddDay(jobContext.getBuzDate(), 1)) == 0) {
                    flag = true;
                }
            }
        }else if (LoanStateEnum.OVER.getCodeInDb().equals(loanRelateTrans.getLoan().getLoanDebtSts())) {
            if (jobContext.getBuzDate().compareTo(loanRelateTrans.getLoan().getCurGenOdIntDt()) == 0) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 首期天数模式， 返回true表示按照期+天
     *
     * @return
     */
    public boolean isFirstPerdOverOnePaymentFreq(LoanRelateUtils loanRelateTrans ) {
        if (org.springframework.util.StringUtils.hasText(loanRelateTrans.getLoan().getInstmInd())) {
            return "Y".equals(loanRelateTrans.getLoan().getInstmInd());
        } else
            return loanRelateTrans.isFirstPerdOverOnePaymentFreq(systemInfoService.getPLoanTypGl());
    }

    /**
     * 获取当前结罚息日期
     *
     * @param lr
     * @param jobContext
     * @param lastShdPsDutDt
     */
    private void getCurGenOdIntDt(LoanRelateUtils lr, BatchJobContextTrans jobContext,
                                  String lastShdPsDutDt){
        String nextOdIntDt = lr.getLoan().getCurGenOdIntDt();
        Date nextDueDay;
        Date today = DateOperation.parseStringToDate(jobContext.getBuzDate());
        if (lmChgStatRuleService.getLoanOverToCalcOdTyp().equals(
                        LoanOverToCalcOdTypEnum.P.getCodeInDb())) {
            Calendar newResult = Calendar.getInstance();
            if (nextOdIntDt == null) {
                nextOdIntDt = lastShdPsDutDt;
            }
            Date nextDate = DateOperation.getDateByDayCount(nextOdIntDt, 20);
            while (true) {
                newResult.setTime(nextDate);
                newResult.add(Calendar.MONTH, 1);
                nextDate = DateOperation.parseStringToDate(DateOperation
                        .getDateStringToDb(newResult.getTime()));
                if (!nextDate.before(DateOperation.parseStringToDate(nextOdIntDt))) {
                    nextOdIntDt = DateOperation.getDateStringToDb(nextDate);
                    break;
                }
            }
        } else if (lmChgStatRuleService.getLoanOverToCalcOdTyp().equals(
                        LoanOverToCalcOdTypEnum.F.getCodeInDb())) {
            PaymentFreq freq = PaymentFreq.getEnum(lr.getPaymFreqUnit());
            int freqUnit = Double.valueOf(lr.getPaymFreqFreq()).intValue();

            Date fstDt = null;
            if (nextOdIntDt == null) {
                fstDt = DateOperation.getFirstPayDateByPaymentFreq(
                        lastShdPsDutDt, lr.getDueDay(), freq, freqUnit,isFirstPerdOverOnePaymentFreq(lr));
                nextOdIntDt = DateOperation.getDateIncDayCount(DateOperation
                        .getDateStringToDb(fstDt), -1);
            } else {
                fstDt = DateOperation.parseStringToDate(nextOdIntDt);
            }
            if (nextOdIntDt.compareTo(jobContext.getBuzDate()) < 0) {
                nextDueDay = DateOperation.parseStringToDate(nextOdIntDt);
                while (true) {
                    nextDueDay = DateOperation.getDayByPaymentFreq(nextDueDay,
                            freq, freqUnit, lr.getDueDay());
                    if (!nextDueDay.before(today)) {
                        nextOdIntDt = DateOperation
                                .getDateStringToDb(nextDueDay);
                        break;
                    }
                }
            }
        } else if (lmChgStatRuleService.getLoanOverToCalcOdTyp().equals(
                        LoanOverToCalcOdTypEnum.M.getCodeInDb())) {
            if (nextOdIntDt == null) {
                nextOdIntDt = lastShdPsDutDt;
            }
            Calendar newResult = Calendar.getInstance();
            newResult.setTime(DateOperation.parseStringToDate(nextOdIntDt));
            newResult.add(Calendar.MONTH, 1);
            newResult = DateOperation.adjustByDueDay(newResult, newResult
                    .get(Calendar.DAY_OF_MONTH));
            nextOdIntDt = DateOperation.getDateStringToDb(newResult.getTime());
        }
        lr.getLoan().setCurGenOdIntDt(nextOdIntDt);
        lmLoanDao.update(lr.getLoan());
    }
}
