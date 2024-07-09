package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.*;
import com.caxs.minos.domain.*;
import com.caxs.minos.domain.trans.AdvPayOptTrans;
import com.caxs.minos.domain.trans.PaymentResultTrans;
import com.caxs.minos.domain.trans.PaymentTryCalculationTrans;
import com.caxs.minos.domain.trans.PunishIntFieldsTrans;
import com.caxs.minos.enums.CommPartEnum;
import com.caxs.minos.enums.PaymentModeEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.buz.AccountUtils;
import com.caxs.minos.serv.buz.InterestCal;
import com.caxs.minos.serv.db.IEntryRuleConfiguraService;
import com.caxs.minos.serv.db.IPunishCalorService;
import com.caxs.minos.serv.db.ISplitPaymentExampleService;
import com.caxs.minos.utils.*;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/***
 * @ClassName(类名) : SplitPaymentExampleService
 * @Description(描述) : 主动还款计算
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class SplitPaymentExampleService implements ISplitPaymentExampleService {
    // 打印日志属性
    private Log log = LogFactory.getLog(getClass());

    @Reference
    IEntryRuleConfiguraService iEntryRuleConfiguraService;

    @Resource
    private LmLoanDao lmLoanDao;

    @Resource
    private LmLoanContDao lmLoanContDao;

    @Resource
    private LmPmShdDao lmPmShdDao;

    @Resource
    PLoanTypGlDao pLoanTypGlDao;

    @Resource
    SCcyDao sCcyDao;


    /***
     * @Description(描述) :取到还款日时客户归还欠款
     * @param receiptNumber
     * @param paymentTime
     * @param repaymentAmount
     * @param paymentMode
     * @param paymentTyp
     * @param advPayOpt
     * @return PaymentTryCalculationTrans
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
    @Override
    public PaymentTryCalculationTrans getSplitPaymentExample(String receiptNumber, String paymentTime,
                           double repaymentAmount, String paymentMode, String paymentTyp, AdvPayOptTrans advPayOpt){
        PaymentTryCalculationTrans paymentTryCal = new PaymentTryCalculationTrans(
                0.00,0.00, 0.00, 0.00, 0.00,0.00,0.00,0.00,0.00,0.00,0.00,
                0.00, 0.00, 0.00,0.00,0.00,0.00,0.00,0.00,0.00, 0.00, 0.00,
                0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00);

        try {

            LmLoan lmLoan = lmLoanDao.findByLoanNo(receiptNumber);
            if (lmLoan == null) {
                throw new MinosException("此借据无借据主表信息！");
            }
            LmLoanCont lmLoanCont = lmLoanContDao.selectOneByLoanContNo(lmLoan.getLoanContNo());
            if (lmLoanCont == null) {
                throw new MinosException("此借据无合同主表信息！");
            }
            SCcy sCcy = sCcyDao.selectOneBySCcy(lmLoan.getLoanCcy());
            if (sCcy == null)
                throw new MinosException("not found ccyCde");
            LoanRelateUtils loanRelate = new LoanRelateUtils(lmLoan, lmLoanCont);

			/* 取贷款参数 是否计算复利 */
			/* 新罚息利率 */
            LoanRateUtils loanRate = new LoanRateUtils(lmLoan, lmLoanCont,sCcy.getCcyBase());
			/* 计算到还款日的利息及罚息 */
            List<LmPmShd> lmPmShdList = new ArrayList<LmPmShd>();
            lmPmShdList = lmPmShdDao.findByLoanNoBeforePsDueDtWithoutSetl(receiptNumber,paymentTime);
            if (lmPmShdList.size() < 0) {
                throw new MinosException("还款计划表无数据");
            }

            PLoanTypGl pLoanTypGl = iEntryRuleConfiguraService.findBytypGlId(lmLoan.getBankCde(),lmLoan.getLoanTyp());
            if ( pLoanTypGl == null) {
                throw new MinosException("贷款品种表不存在与该贷款品种代码对应的记录！");
            }

            /* 取当前还款计划表 并复制PayShchedueCal结构 */
            /* 获取当前总的应还本金，利息，罚息，复利 */
            List<PayShchedueCalUtils> payShchedueCalList = new ArrayList<PayShchedueCalUtils>();
            for (int index = 0; index < lmPmShdList.size(); index++) {
                PayShchedueCalUtils payShchedueCal = new PayShchedueCalUtils(lmPmShdList
                        .get(index), DateOperation.parseStringToDate(paymentTime));
                payShchedueCal.setDaylyRate(loanRate.getLendOdIntRateDayly());
                payShchedueCal.setCheckDayCount(true);
                payShchedueCalList.add(payShchedueCal);

                double principal = paymentTryCal.getArrearPrincipal(); //应归还本金
                double interest = paymentTryCal.getArrearInterest();//应归还利息
                double lateInterest = paymentTryCal.getArrearLateInterest();//应归还逾期利息
                double CompoundInterest = paymentTryCal.getArrearCompoundInterest();//应归还复利
                double arrearFeeAmt = paymentTryCal.getArrearFeeAmt(); //应归还费用
                double arrearOdFeeAmt = paymentTryCal.getArrearOdFeeAmt();//应归逾期费用

                paymentTryCal.setArrearPrincipal(principal
                        + payShchedueCal.getPrcp());
                paymentTryCal.setArrearInterest(interest
                        + payShchedueCal.getNormInt());
                paymentTryCal.setArrearLateInterest(lateInterest
                        + payShchedueCal.getOdInt());
                paymentTryCal.setArrearCompoundInterest(CompoundInterest
                        + payShchedueCal.getCommInt());
                paymentTryCal.setArrearFeeAmt(arrearFeeAmt
                        + payShchedueCal.getFeeAmt());
                paymentTryCal.setArrearOdFeeAmt(arrearOdFeeAmt
                        + payShchedueCal.getOdFeeAmt());
            }
            double lateInterest = paymentTryCal.getArrearLateInterest(); //应归还逾期利息
            double CompoundInterest = paymentTryCal.getArrearCompoundInterest(); //应归还复利

            //计算宽限期概念
            PunishConfigUtils punishConfig = new PunishConfigUtils();
            CommPartEnum odCommPart = CommPartEnum.getEnum(loanRelate.getLoanOdCommPart());
            punishConfig.setCommPart(odCommPart);
            YnFlagEnum ynFlagEnum = YnFlagEnum.getEnum(lmLoanCont.getLoanOdCpdInd());
            punishConfig.setIsCalCommAndOdInt(ynFlagEnum); //设置是否计算罚息复利
            punishConfig.setLoanOdGraceInd(YnFlagEnum.isTrue(lmLoanCont.getLoanOdGraceInd()));//是否停止罚息
            punishConfig.setLoanOdIntGraceInd(YnFlagEnum.isTrue(lmLoanCont.getLoanOdIntGraceInd())); //是否停止复利

            PunishCalorService punishCalorImp = new PunishCalorService();
            IPunishCalorService punishCalor = punishCalorImp.buildPunishCal(payShchedueCalList,punishConfig,loanRelate,paymentTime,true,true);
            Map<Integer, PunishIntFieldsTrans> map = punishCalor.execute(loanRate.getDayCountYearly(), true);
            PunishIntFieldsTrans punishIntFields = punishCalor.sumAllIntByMap(map);

            /* 本次应还金额赋值总的逾期利息和复利 */
            paymentTryCal.setArrearLateInterest(lateInterest
                    + punishIntFields.getOdInt());
            paymentTryCal.setArrearCompoundInterest(CompoundInterest
                    + punishIntFields.getCommInt());

            double totalAmt = 0.00;// 还款总金额
            double advanceInterest = 0.00;
			/* 判断还款模式 NM:正常 ER: 提前 FS:全部 */
            if ( paymentMode.equals(PaymentModeEnum.ALL.getCodeInDb())) {

                //获取剩余本金
                LmPmShd shd1 = lmPmShdDao.findMaxPerdNoBeforePsDueDt(receiptNumber,paymentTime);
                //起止时间
                int dayCount = new Long(DateOperation.DateCal(paymentTime, shd1.getPsDueDt()))
                        .intValue();
                /* 如果提前或者剩余本金的正常利息 */
                advanceInterest = SystemUtils.getDoubleWhenEvenUp(InterestCal.decimalAmtForInterestCal(
                        loanRate.getLendingRateDayly(), shd1.getPsRemPrcp(),dayCount,0));

                totalAmt = SystemUtils.getBigDecimalfNull(shd1.getPsRemPrcp()) ;

            } else if (paymentMode.equals(PaymentModeEnum.ADVANCE.getCodeInDb()) ) {
                //获取剩余本金
                LmPmShd shd1 = lmPmShdDao.findMaxPerdNoBeforePsDueDt(receiptNumber,paymentTime);
                //起止时间
                int dayCount = new Long(DateOperation.DateCal(paymentTime, shd1.getPsDueDt()))
                        .intValue();
                /* 如果提前或者剩余本金的正常利息 */
                advanceInterest = SystemUtils.getDoubleWhenEvenUp(InterestCal.decimalAmtForInterestCal(
                        loanRate.getLendingRateDayly(), shd1.getPsRemPrcp(),dayCount,0));

                totalAmt =  repaymentAmount ;
            }else {
                totalAmt = SystemUtils.getDoubleWhenEvenUp(repaymentAmount);
            }

			/* 金额拆分实还金额赋值 */
            PaymentResultTrans paymentResult = AccountUtils.tryCalPayMoney(lmPmShdList, map);
            if( paymentResult.getPaymentShdList() ==null)
                throw new MinosException("金额拆分实还金额赋值计算失败 :" + receiptNumber);

            //还款结构赋值
            paymentTryCal.setPaymentShdList(paymentResult.getPaymentShdList());
            //提前部分或者提前前部还款应还利息
            paymentTryCal.setRemainingInterest(advanceInterest);
            if (PaymentModeEnum.NORMAL.getCodeInDb().equals(paymentMode)) {
                paymentTryCal.setRemainingPrincipal(0D);
            } else
                paymentTryCal.setRemainingPrincipal(totalAmt); //提前部分或者提前前部还款本金

            paymentTryCal.setReturnPrincipal(paymentResult.getPayPrcpAmt());//总应还本金
            paymentTryCal.setReturnInterest(paymentResult.getPayNormInt());//总应还利息
            paymentTryCal.setReturnLateInterest(paymentResult.getPayOdInt());//总应还罚息
            paymentTryCal.setReturnCompoundInterest(paymentResult.getPayCommInt());//总应还复利
            paymentTryCal.setReturnFeeAmt(paymentResult.getPayFeeAmt());//总应还手续费
            paymentTryCal.setReturnOdFeeAmt(paymentResult.getPayOdFeeAmt());//总应还逾期费用
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return paymentTryCal;
    };
}
