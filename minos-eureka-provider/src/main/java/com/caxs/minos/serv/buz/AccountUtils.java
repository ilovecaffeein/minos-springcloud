package com.caxs.minos.serv.buz;

import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.LmAcctInfo;
import com.caxs.minos.domain.LmFeeTx;
import com.caxs.minos.domain.LmPmShd;
import com.caxs.minos.domain.LmSetlmtLog;
import com.caxs.minos.domain.trans.AccountTrans;
import com.caxs.minos.domain.trans.PaymentResultTrans;
import com.caxs.minos.domain.trans.PaymentShdTrans;
import com.caxs.minos.domain.trans.PunishIntFieldsTrans;
import com.caxs.minos.enums.PrcpAndIntStateEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.utils.DigitalUtils;
import com.caxs.minos.utils.SystemUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * @ClassName: AccountUtils
 * 金额汇总工具
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class AccountUtils {
    // 打印日志属性
    private static final Log log = LogFactory.getLog(AccountUtils.class);//打印日志属性

    public final static String PAY_IND_PAY = "P"; // 付方属性
    public final static String PAY_IND_RECEIVE = "R"; // 收方属性
    public final static String PAYMCDE_CHECK = "02";// 支票
    public final static String PAYMCDE_CASH = "03"; // 现金
    public final static String PAYMCDE_DEPOSIT = "01"; // 存款

    public static List<PaymentShdTrans> tempPayShdList = null;
    public List<PaymentShdTrans> getTempPayShdList() {
        return tempPayShdList;
    }

    /**
     * 还算结果合并
     * @param lmPmShdList
     *            :还款计划表 ,需提供新生成的罚息
     * @param punishIntMap
     *            :罚息计算
     * @return
     */
    public static PaymentResultTrans tryCalPayMoney(List<LmPmShd> lmPmShdList,
                                                    Map<Integer, PunishIntFieldsTrans> punishIntMap) {
        PaymentResultTrans paymentResult = new PaymentResultTrans();
        paymentResult.setPaymentShdList(buildShdList(lmPmShdList,punishIntMap));
        for (PaymentShdTrans shd : paymentResult.getPaymentShdList()) {
            paymentResult.setPayPrcpAmt(paymentResult.getPayPrcpAmt()
                    + SystemUtils.getBigDecimalfNull(shd.getPayedPrcp()));
            paymentResult.setPayNormInt(paymentResult.getPayNormInt()
                    + SystemUtils.getBigDecimalfNull(shd.getPayedNormInt()));
            paymentResult.setPayOdInt(paymentResult.getPayOdInt()
                    + SystemUtils.getBigDecimalfNull(shd.getPayedOdInt()));
            paymentResult.setPayCommInt(paymentResult.getPayCommInt()
                    + SystemUtils.getBigDecimalfNull(shd.getPayedCommInt()));
            paymentResult.setPayFeeAmt(paymentResult.getPayFeeAmt()
                    + SystemUtils.getBigDecimalfNull(shd.getPsFeeAmt()));
            paymentResult.setPayOdFeeAmt(paymentResult.getPayOdFeeAmt()
                    + SystemUtils.getBigDecimalfNull(shd.getPsOdIntFeeAmt()));
        }
        return paymentResult;
    }

    /**
     * 保存临时还款计划表结构
     * @param lmPmShdList
     * @param punishIntMap
     * @return buildShdList
     */
    public static List<PaymentShdTrans> buildShdList(
            List<LmPmShd> lmPmShdList, Map<Integer, PunishIntFieldsTrans> punishIntMap) {
        log.info("试算借据号 =" + lmPmShdList.get(0).getLoanNo());
        tempPayShdList = new ArrayList<PaymentShdTrans>(lmPmShdList.size());
        for (LmPmShd shd : lmPmShdList) {
            PaymentShdTrans dest = new PaymentShdTrans(shd);
            SystemUtils.copyProperties(shd, dest);
            dest.setConfirmCommInt(SystemUtils.getBigDecimalf(shd.getGrcProdComm()));
            dest.setConfirmOdInt(SystemUtils.getBigDecimalf(shd.getGrcProdInt()));
            dest.setPsPerdNo(shd.getPsPerdNo());
            PunishIntFieldsTrans fields = punishIntMap.get(shd.getPsPerdNo());
            if ( fields != null ) {
                BigDecimal psOdIntAmt = SystemUtils.getBigDecimalWhenEvenUp(
                        shd.getPsOdIntAmt().add(new BigDecimal(fields.getOdInt())));
                BigDecimal psCommOdInt = SystemUtils.getBigDecimalWhenEvenUp(
                        shd.getPsCommOdInt().add(new BigDecimal(fields.getCommInt())));
                dest.setPsOdIntAmt(psOdIntAmt);
                dest.setPsCommOdInt(psCommOdInt);
                dest.setProdPrcpAmt(DigitalUtils.getBigDecimal(fields.getProdPrcpAmt()));
                dest.setProdIntAmt(DigitalUtils.getBigDecimal(fields.getProdOdAmt()));
                dest.setProdCommIntAmt(DigitalUtils.getBigDecimal(fields.getProdCommAmt()));
            }
            dest.setPsRemPrcp(dest.getPsRemPrcp().add(
                    dest.getPsPrcpAmt().subtract(dest.getSetlPrcp())));
            dest.setPayedPrcp(shd.getPsPrcpAmt().subtract(shd.getSetlPrcp()));
            dest.setPayedNormInt(shd.getPsNormIntAmt().subtract(shd.getSetlNormInt()));
            dest.setPayedOdInt(dest.getPsOdIntAmt().subtract(shd.getSetlOdIntAmt()));
            dest.setPayedCommInt(dest.getPsCommOdInt().subtract(shd.getSetlCommOdInt()));
            dest.setPayedFeeAmt(dest.getPsFeeAmt().subtract(shd.getSetlFeeAmt()));
            dest.setPayedOdFeeAmt(dest.getPsOdIntFeeAmt().subtract(shd.getSetlOdIntFeeAmt()));
            if ( log.isInfoEnabled() ) {
                log.info("试算期数  =" + dest.getPsPerdNo());
                log.info("归还正常本金=" + dest.getPayedPrcp());
                log.info("归还正常利息=" + dest.getPayedNormInt());
                log.info("归还逾期利息=" + dest.getPayedOdInt());
                log.info("归还复利    =" + dest.getPayedCommInt());
                log.info("归还手续费  =" + dest.getPayedFeeAmt());
                log.info("归还逾期手续费  =" + dest.getPayedOdFeeAmt());
            }
            tempPayShdList.add(dest);
        }
        return tempPayShdList;
    }

    /**
     * 计算手续费总和
     *
     * @param lmFeeTxList
     * @return
     */
    public static double sumFeeTx(List<LmFeeTx> lmFeeTxList) {
        if (CollectionUtils.isEmpty(lmFeeTxList)) {
            return 0;
        }
        BigDecimal totalFeeAmt = new BigDecimal(0);
        for (LmFeeTx lmFeeTx : lmFeeTxList) {
            if ("R".equals(lmFeeTx.getRecvPayInd())) {
                totalFeeAmt = totalFeeAmt.add(lmFeeTx.getFeeAmt());
            } else {
                totalFeeAmt = totalFeeAmt.subtract(lmFeeTx.getFeeAmt());
            }
        }
        totalFeeAmt = SystemUtils.getBigDecimalWhenEvenUp(totalFeeAmt);
        if (SystemUtils.isAmtLessThanZero(totalFeeAmt.doubleValue())) {
            throw new MinosException("手续费总和：" + totalFeeAmt + "不能小于0");
        }
        return totalFeeAmt.doubleValue();
    }


    /**
     * 保存到还款计划表
     *
     * @param tempPayShdList
     * @param
     */
    public static List<LmPmShd>  mergeLmShd(List<LmPmShd> tempPayShdList, LmSetlmtLog logg) {
        List<LmPmShd> lmPmShdList = new ArrayList<LmPmShd>();
        for (LmPmShd lmPmShd : tempPayShdList) {
            if (lmPmShd.getPsPerdNo().intValue() == 0) {
                continue;
            }
            lmPmShd.setSetlOdIncTaken(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
            lmPmShd.setPsCurOdIncTaken(SystemUtils.getDoubleToBigDecimal(MinosConst.ZERO_DOUBLE));
            if ( ! "Y".equals(lmPmShd.getSetlInd())) {
                if ( PrcpAndIntStateEnum.NORMAL.getCodeInDb().equals(lmPmShd.getPrcpState())) {
                    if (logg.getSetlValDt().compareTo(lmPmShd.getPsDueDt()) >= 0) {
                        if ( lmPmShd.getPsPrcpAmt().doubleValue()> lmPmShd.getSetlPrcp().doubleValue()) {
                            lmPmShd.setPrcpState(PrcpAndIntStateEnum.LATE.getCodeInDb());
                        }
                        if ( lmPmShd.getPsNormIntAmt().doubleValue()> lmPmShd.getSetlNormInt().doubleValue()) {
                            lmPmShd.setIntState(PrcpAndIntStateEnum.LATE.getCodeInDb());
                        }
                    }
                }
            }
            lmPmShd.setPsIncTaken(lmPmShd.getSetlNormInt());
            lmPmShd.setSetlIncTaken(lmPmShd.getSetlNormInt());
            lmPmShdList.add(lmPmShd);
        }
        return lmPmShdList;
    }

    /**
     * 保存到还款计划表
     *
     * @param paymentShdTrans
     * @param lmPmShdList
     * @param
     */
    public static void genPmShd(PaymentShdTrans paymentShdTrans, LmPmShd lmPmShdList,String lastSetlDt) {
        if( Integer.valueOf(paymentShdTrans.getPsPerdNo()) == lmPmShdList.getPsPerdNo()){
            lmPmShdList.setPsOdIntAmt(paymentShdTrans.getPsOdIntAmt());
            lmPmShdList.setPsCommOdInt(paymentShdTrans.getPsCommOdInt());
            lmPmShdList.setSetlPrcp(paymentShdTrans.getSetlPrcp());
            lmPmShdList.setSetlNormInt(paymentShdTrans.getSetlNormInt());
            lmPmShdList.setSetlOdIntAmt(paymentShdTrans.getSetlOdIntAmt());
            lmPmShdList.setSetlCommOdInt(paymentShdTrans.getSetlCommOdInt());
            lmPmShdList.setSetlFeeAmt(paymentShdTrans.getSetlFeeAmt());
            lmPmShdList.setProdPrcpAmt(MinosConst.ZERO_BIGDECIMAL);
            lmPmShdList.setProdIntAmt(MinosConst.ZERO_BIGDECIMAL);
            lmPmShdList.setProdCommIntAmt(MinosConst.ZERO_BIGDECIMAL);
            lmPmShdList.setSetlInd(paymentShdTrans.getSetlInd());
            if( SystemUtils.isAmtGreatThanZero(SystemUtils.getBigDecimalfNull(lmPmShdList.getSetlCommOdInt())) ||
                    SystemUtils.isAmtGreatThanZero(SystemUtils.getBigDecimalfNull(lmPmShdList.getSetlNormInt()))  ||
                    SystemUtils.isAmtGreatThanZero(SystemUtils.getBigDecimalfNull(lmPmShdList.getSetlNormInt())) ||
                    SystemUtils.isAmtGreatThanZero(SystemUtils.getBigDecimalfNull(lmPmShdList.getSetlPrcp()))){
                lmPmShdList.setLastSetlDt(lastSetlDt);
            }
        }
    }

    /**
     * 根据账户信息产生AccountAndPay
     * @param lmAcctInfo
     * @return
     */
    public static AccountTrans buildAccount(LmAcctInfo lmAcctInfo) {
        if (lmAcctInfo == null) {
            throw new MinosException("账户信息不能为空");
        }
        AccountTrans ap = new AccountTrans();
        if (!StringUtils.isEmpty(lmAcctInfo.getLoanAcctTyp())) {
            ap.setLoanAccountTyp(lmAcctInfo.getLoanAcctTyp());
        }
        ap.setAcctCde(lmAcctInfo.getAcctCde());
        ap.setAcctName(lmAcctInfo.getAcctName());
        ap.setAcctNo(lmAcctInfo.getAcctNo());
        ap.setAcctTyp(lmAcctInfo.getAcctTyp());
        ap.setBankCde(lmAcctInfo.getAcctBankCde());
        ap.setBchCde(lmAcctInfo.getAcctBchCde());
        ap.setCardNo(lmAcctInfo.getAcctCardNo());
        ap.setCcyCde(lmAcctInfo.getAcctCcyCde());
        ap.setIdNo(lmAcctInfo.getAcctIdNo());
        ap.setIdType(lmAcctInfo.getAcctIdType());
        ap.setIssCtry(lmAcctInfo.getAcctIssCtry());
        ap.setLdgrCde(lmAcctInfo.getAcctLdgrCde());
        ap.setNttInd(lmAcctInfo.getAcctNttInd());
        ap.setAccountSelf(YnFlagEnum.YES.getCodeInDb().equals(lmAcctInfo.getAccountSelf()));
        ap.setBankName(lmAcctInfo.getAcctBankNam());
        ap.setBindMobile(lmAcctInfo.getBindMobile());
        //委托人出资比例
        //ap.setFundRatio(lmAcctInfo.getFundRatio().doubleValue());
        return ap;
    }
}
