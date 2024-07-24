package com.caxs.minos.serv.buz.payment;

import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.PRpymOrdDtl;
import com.caxs.minos.domain.trans.MoneyPayTrans;
import com.caxs.minos.domain.trans.PaymentShdTrans;
import com.caxs.minos.enums.PaymentTypeEnum;
import com.caxs.minos.utils.RoundingUtil;
import com.caxs.minos.utils.SystemUtils;
import java.math.BigDecimal;
import java.util.List;
/***
 * @ClassName(类名) : PaymentThisPeriodMoney
 * @Description(描述) : 当期计算应付
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/5 10:56
 */
public class PaymentThisPeriodMoney {
    /**
     * 归还总金额
     */
    static public  BigDecimal  toPayMoney = new BigDecimal(0.0);

    private MoneyPayTrans money;

    public MoneyPayTrans getMoney() {
        return money;
    }

    public void setMoney(MoneyPayTrans money) {
        this.money = money;
    }

    public PaymentThisPeriodMoney(MoneyPayTrans money, BigDecimal  toPayMoney) {
        super();
        this.money = money;
        this.toPayMoney= toPayMoney;
    }

    public BigDecimal getToPayMoney() {
        return toPayMoney;
    }

    public void setToPayMoney(BigDecimal toPayMoney) {
        this.toPayMoney = toPayMoney;
    }

    /**
     * 是否结出新的罚息
     */
    private boolean isSetlPunish = true;

    // 还款结果内部类
    public static class ShdPayResult {
        // 是否还清所有
        private boolean setlAll;
        /**
         * 还清积数
         */
        private boolean setlProd = false;
        /**
         * 还清积数以外的
         */
        private boolean setlOther = false;

        // 获取是否还清积数
        public boolean isSetlProd() {
            return setlProd;
        }

        // 获取是否还清积数以外的
        public boolean isSetlOther() {
            return setlOther;
        }

        // 获取是否还清所有
        public boolean isSetlAll() {
            return setlAll;
        }
    }

    /***
     * @ClassName(类名) : decidePaymentMoney
     * @Description(描述) : 决定付款顺序
     * @param detlList
     * @author(作者) ： coffee
     * @return返回本次循环要扣除的钱
     */
    public void decidePaymentMoney(List<PRpymOrdDtl> detlList) {
        PaymentTypeEnum pt;
        for (PRpymOrdDtl detl : detlList) {
            pt = PaymentTypeEnum.getEnum(detl.getRpymOrdTyp());
            switch (pt) {
                case NOW_PROP:
                    if (SystemUtils.isAmtGreatThanZero(this.toPayMoney.doubleValue())) {
                        BigDecimal psPayPrcpAmount = money.getPsPayPrcpAmount().subtract(money.getPrcp());
                        if ( SystemUtils.isAmtGreatAndEqual(
                                this.toPayMoney.doubleValue(),psPayPrcpAmount.doubleValue())) {
                            money.setPrcp(money.getPsPayPrcpAmount()); //已经本金
                            money.setDevOdPrcpAmount(psPayPrcpAmount);//减值还款本金
                            this.setToPayMoney(this.toPayMoney.subtract(psPayPrcpAmount));//剩余金额
                        }else{
                            money.setDevOdPrcpAmount(this.toPayMoney);
                            money.setPrcp(money.getPrcp().add(this.toPayMoney));
                            this.setToPayMoney(MinosConst.ZERO_BIGDECIMAL);
                        }
                    }
                    break;
                case NOW_INT:
                    if (SystemUtils.isAmtGreatThanZero(this.toPayMoney.doubleValue())) {
                        BigDecimal psPayNormPrcpAmount = money.getPsPayNormPrcpAmount().subtract(money.getNormInt());
                        if (SystemUtils.isAmtGreatAndEqual(
                                this.toPayMoney.doubleValue(),psPayNormPrcpAmount.doubleValue())) {
                            money.setNormInt(money.getPsPayNormPrcpAmount());//已经利息
                            money.setDevNormPrcpAmount(psPayNormPrcpAmount);//减值还款利息
                            this.setToPayMoney(this.toPayMoney.subtract(psPayNormPrcpAmount));
                        }else{
                            money.setDevNormPrcpAmount(this.toPayMoney);
                            money.setNormInt(money.getNormInt().add(this.toPayMoney));
                            this.setToPayMoney(MinosConst.ZERO_BIGDECIMAL);
                        }
                    }
                    break;
                case NOW_LATE_INT:
                    if (SystemUtils.isAmtGreatThanZero(this.toPayMoney.doubleValue())) {
                        BigDecimal psPayOdIntAmount = money.getPsPayOdIntAmount().subtract(money.getOdInt());
                        if (SystemUtils.isAmtGreatAndEqual(
                                this.toPayMoney.doubleValue(),psPayOdIntAmount.doubleValue())) {
                            money.setOdInt(money.getPsPayOdIntAmount());//已经逾期利息
                            money.setDevOdIntAmount(psPayOdIntAmount);//减值还款逾期利息
                            this.setToPayMoney(this.toPayMoney.subtract(psPayOdIntAmount));
                        }else{
                            money.setDevOdIntAmount(this.toPayMoney);
                            money.setOdInt(money.getOdInt().add(this.toPayMoney));
                            this.setToPayMoney(MinosConst.ZERO_BIGDECIMAL);
                        }
                    }
                    break;
                case NOW_COMM:
                    if (SystemUtils.isAmtGreatThanZero(this.toPayMoney.doubleValue())) {
                        BigDecimal psPayCommIntAmount = money.getPsPayCommIntAmount().subtract(money.getCommInt());
                        if (SystemUtils.isAmtGreatAndEqual(
                                this.toPayMoney.doubleValue(),psPayCommIntAmount.doubleValue())) {
                            money.setCommInt(money.getPsPayCommIntAmount());//已还款复利
                            money.setDevCommIntAmount(psPayCommIntAmount);//减值还款复利
                            this.setToPayMoney(this.toPayMoney.subtract(psPayCommIntAmount));
                        }else{
                            money.setDevOdPrcpAmount(this.toPayMoney);//减值还款复利
                            money.setCommInt(money.getCommInt().add(this.toPayMoney));
                            this.setToPayMoney((MinosConst.ZERO_BIGDECIMAL));
                        }
                    }
                    break;
                case FEE: {
                    if (SystemUtils.isAmtGreatThanZero(this.toPayMoney.doubleValue())) {
                        BigDecimal psPayPayedFee = money.getPsPayPayedFee().subtract(money.getFeeAmt());
                        if (SystemUtils.isAmtGreatAndEqual(
                                this.toPayMoney.doubleValue(),psPayPayedFee.doubleValue())) {
                            money.setFeeAmt(money.getPsPayPayedFee());//已还款手续费
                            money.setDevPayedFee(psPayPayedFee);//减值还款手续费
                            this.setToPayMoney(this.toPayMoney.subtract(psPayPayedFee));
                        }else{
                            money.setDevPayedFee(this.toPayMoney); //减值还款手续费
                            money.setFeeAmt(money.getFeeAmt().add(this.toPayMoney));
                            this.setToPayMoney(MinosConst.ZERO_BIGDECIMAL);
                        }
                    }
                    break;
                }
            }
        }
    }

    /*
     * 计算期数利率,返回数据未修约
    * (non-Javadoc)
    *
    */
    public BigDecimal getRetlRecvAmt() {
        BigDecimal retlRecvAmt = money.getDevOdPrcpAmount().add(money.getDevNormPrcpAmount());
        retlRecvAmt = retlRecvAmt.add(money.getDevOdIntAmount().add(money.getDevCommIntAmount()));
        return RoundingUtil.roundingBigDecimal(retlRecvAmt);
    }

    /**
     * 判断是否金额已经扣完
     * @return
     */
    public  boolean runOver() {
        boolean isSetl = false ;
        if( this.toPayMoney.doubleValue() <= 0 )
            isSetl = true;
        return isSetl;
    }

    /**
     * 该期是否结清
     * @return
     */
    public boolean isShdSetlAll() {
        boolean isSetl = isPaymentShdSetlAll().isSetlAll();
        if (!isSetl) {
            return false;
        }
        return  isSetlPunish;
    }

    /**
     * 获取还款计划是否结清
     * @return
     */
    public ShdPayResult isPaymentShdSetlAll() {

        BigDecimal temp = RoundingUtil.roundingBigDecimal(
                money.getPsPayPrcpAmount().subtract(money.getPrcp()));

        ShdPayResult spr = new ShdPayResult();
        if (SystemUtils.isAmtGreatThanZero(temp.doubleValue())) {
            return spr;
        }
        temp = RoundingUtil.roundingBigDecimal(
                money.getPsPayNormPrcpAmount().subtract(money.getNormInt()));

        if (SystemUtils.isAmtGreatThanZero(temp.doubleValue())) {
            return spr;
        }
        temp = RoundingUtil.roundingBigDecimal(money
                .getPsPayOdIntAmount().subtract(money.getOdInt()));
        if (SystemUtils.isAmtGreatThanZero(temp.doubleValue())) {
            return spr;
        }
        temp = RoundingUtil.roundingBigDecimal(money
                .getPsPayCommIntAmount().subtract(money.getCommInt()));
        if (SystemUtils.isAmtGreatThanZero(temp.doubleValue())) {
            return spr;
        }
        temp = RoundingUtil.roundingBigDecimal(
                money.getPsPayPayedFee().subtract(money.getFeeAmt()));
        if (SystemUtils.isAmtGreatThanZero(temp.doubleValue())) {
            return spr;
        }
        spr.setlOther = true;
        spr.setlProd = true;
        spr.setlAll = true;
        return spr;
    }



    /**
     * 该期是否结清
     *
     * @param paymentShdTrans
     * @return
     */
    public boolean isShdSetlNm(PaymentShdTrans paymentShdTrans) {
        boolean isSetl = isPaymentShdSetl(paymentShdTrans, true).isSetlAll();
        if (!isSetl) {
            return false;
        }
        return paymentShdTrans.isSetlPunish();
    }

    /**
     * 获取还款计划是否结清
     *
     * @param paymentShdTrans
     * @param isCheckProd
     * @return
     */
    public ShdPayResult isPaymentShdSetl(PaymentShdTrans paymentShdTrans, boolean isCheckProd) {

        BigDecimal temp = RoundingUtil.roundingBigDecimal(
                paymentShdTrans.getPsPrcpAmt().subtract(paymentShdTrans.getSetlPrcp()));

        ShdPayResult spr = new ShdPayResult();
        if (SystemUtils.isAmtGreatThanZero(temp.doubleValue())) {
            return spr;
        }
        temp = RoundingUtil.roundingBigDecimal(paymentShdTrans
                .getPsNormIntAmt().subtract(paymentShdTrans.getSetlNormInt()));

        if (SystemUtils.isAmtGreatThanZero(temp.doubleValue())) {
            return spr;
        }
        temp = RoundingUtil.roundingBigDecimal(paymentShdTrans
                .getPsOdIntAmt().subtract(paymentShdTrans.getSetlOdIntAmt()));
        if (SystemUtils.isAmtGreatThanZero(temp.doubleValue())) {
            return spr;
        }
        temp = RoundingUtil.roundingBigDecimal(paymentShdTrans
                .getPsCommOdInt().subtract(paymentShdTrans.getSetlCommOdInt()));
        if (SystemUtils.isAmtGreatThanZero(temp.doubleValue())) {
            return spr;
        }
        temp = RoundingUtil.roundingBigDecimal(paymentShdTrans
                .getPsFeeAmt().subtract(paymentShdTrans.getSetlFeeAmt()));
        if (SystemUtils.isAmtGreatThanZero(temp.doubleValue())) {
            return spr;
        }
        spr.setlOther = true;
        spr.setlProd = true;
        spr.setlAll = true;
        return spr;
    }
}
