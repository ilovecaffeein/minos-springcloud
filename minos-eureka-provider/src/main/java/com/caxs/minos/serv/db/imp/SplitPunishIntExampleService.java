package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.*;
import com.caxs.minos.domain.*;
import com.caxs.minos.domain.trans.AdvPayOptTrans;
import com.caxs.minos.domain.trans.PaymentTryCalculationTrans;
import com.caxs.minos.domain.trans.PunishIntFieldsTrans;
import com.caxs.minos.enums.CommPartEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.IEntryRuleConfiguraService;
import com.caxs.minos.serv.db.IPunishCalorService;
import com.caxs.minos.serv.db.ISplitPunishIntExampleService;
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
 * @ClassName(类名) : SplitPunishIntExampleService
 * @Description(描述) : 获取试算取罚息复利
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class SplitPunishIntExampleService implements ISplitPunishIntExampleService {
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
     * @Description(描述) :获取试算取罚息复利
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
    public Map<Integer, PunishIntFieldsTrans> getSplitPunishIntExample(String receiptNumber, String paymentTime,
                           double repaymentAmount, String paymentMode, String paymentTyp, AdvPayOptTrans advPayOpt){
        PaymentTryCalculationTrans paymentTryCal = new PaymentTryCalculationTrans(
                0.00,0.00, 0.00, 0.00, 0.00,0.00,0.00,0.00,0.00,0.00,0.00,
                0.00, 0.00, 0.00,0.00,0.00,0.00,0.00,0.00,0.00, 0.00, 0.00, 0.00,0.00,0.00,0.00,0.00,0.00,0.00,0.00);
        Map<Integer, PunishIntFieldsTrans> punishIntMap = null;

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
                payShchedueCal.setDaylyRate(loanRate.getLendingRateDayly());
                payShchedueCalList.add(payShchedueCal);
                double principal = paymentTryCal.getArrearPrincipal(); //应归还本金
                double interest = paymentTryCal.getArrearInterest();//应归还利息
                double lateInterest = paymentTryCal.getArrearLateInterest();//应归还逾期利息
                double CompoundInterest = paymentTryCal.getArrearCompoundInterest();//应归还复利
                paymentTryCal.setArrearPrincipal(principal
                        + payShchedueCal.getPrcp());
                paymentTryCal.setArrearInterest(interest
                        + payShchedueCal.getNormInt());
                paymentTryCal.setArrearLateInterest(lateInterest
                        + payShchedueCal.getOdInt());
                paymentTryCal.setArrearCompoundInterest(CompoundInterest
                        + payShchedueCal.getCommInt());
            }
            double lateInterest = paymentTryCal.getArrearLateInterest(); //应归还逾期利息
            double CompoundInterest = paymentTryCal.getArrearCompoundInterest(); //应归还复利

            //计算宽限期概念
            CommPartEnum odCommPart = CommPartEnum.getEnum(loanRelate.getLoanOdCommPart());
            PunishConfigUtils punishConfig = new PunishConfigUtils();
            punishConfig.setCommPart(odCommPart);
            YnFlagEnum ynFlagEnum = YnFlagEnum.getEnum(lmLoanCont.getLoanOdCpdInd());
            punishConfig.setIsCalCommAndOdInt(ynFlagEnum); //设置是否计算罚息复利
            punishConfig.setLoanOdGraceInd(YnFlagEnum.isTrue(lmLoanCont.getLoanOdGraceInd()));//是否停止罚息
            punishConfig.setLoanOdIntGraceInd(YnFlagEnum.isTrue(lmLoanCont.getLoanOdIntGraceInd())); //是否停止复利

            PunishCalorService punishCalorImp = new PunishCalorService();
            IPunishCalorService punishCalor = punishCalorImp.buildPunishCal(
                    payShchedueCalList,punishConfig,loanRelate,paymentTime,true,true);
            punishIntMap = punishCalor.execute(loanRate.getDayCountYearly(), true);

        }catch (Exception e) {
            e.printStackTrace();
            throw new MinosException("还款失败:" + e.getMessage());
        }
        return punishIntMap;
    };
}
