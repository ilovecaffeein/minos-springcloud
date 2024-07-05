package com.caxs.minos.domain.trans;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * @ClassName: MoneyPayTrans
 * 入账赋值金额
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class MoneyPayTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;
    /**
     * 应还款总金额
     */
    BigDecimal psPaymentAmount = new BigDecimal(0);
    /**
     * 应还本金
     */
    BigDecimal psPayPrcpAmount = new BigDecimal(0);
    /**
     * 应还利息
     */
    BigDecimal psPayNormPrcpAmount =new BigDecimal(0);
    /**
     * 应还逾期利息
     */
    BigDecimal psPayOdIntAmount = new BigDecimal(0);
    /**
     * 应还复利
     */
    BigDecimal psPayCommIntAmount= new BigDecimal(0);
    /**
     * 应还费用
     */
    BigDecimal psPayPayedFee =new BigDecimal(0);
    /**
     * 要还得减值还款总金额
     */
    BigDecimal dePaymentAmount = new BigDecimal(0);
    /**
     * 要还得减值逾期本金
     */
    BigDecimal devOdPrcpAmount = new BigDecimal(0);
    /**
     * 要还得减值正常本金
     */
    BigDecimal devNormPrcpAmount =new BigDecimal(0);
    /**
     * 要还得减值逾期利息
     */
    BigDecimal devOdIntAmount = new BigDecimal(0);
    /**
     * 要还得减值复利
     */
    BigDecimal devCommIntAmount= new BigDecimal(0);
    /**
     * 要还得减值费用
     */
    BigDecimal devPayedFee =new BigDecimal(0);
    /**
     * 已归本金
     */
    BigDecimal prcp = new BigDecimal(0);
    /**
     * 已归正常利息
     */
    BigDecimal normInt = new BigDecimal(0);

    /**
     * 已归逾期利息
     */
    BigDecimal odInt = new BigDecimal(0);
    /**
     * 已归复利
     */
    BigDecimal commInt = new BigDecimal(0);
    /**
     * 已还费用
     */
    BigDecimal feeAmt =new BigDecimal(0);

    public BigDecimal getPsPaymentAmount() {
        return psPaymentAmount;
    }

    public BigDecimal getpsPaymentAmountAll() {
        return psPayPrcpAmount.add(psPayNormPrcpAmount).add(
                psPayOdIntAmount).add(psPayCommIntAmount).add(psPayPayedFee);
    }

    public void setPsPaymentAmount(BigDecimal psPaymentAmount) {
        this.psPaymentAmount = psPaymentAmount;
    }
    public BigDecimal getPsPayPrcpAmount() {
        return psPayPrcpAmount;
    }
    public void setPsPayPrcpAmount(BigDecimal psPayPrcpAmount) {
        this.psPayPrcpAmount = psPayPrcpAmount;
    }
    public BigDecimal getPsPayNormPrcpAmount() {
        return psPayNormPrcpAmount;
    }
    public void setPsPayNormPrcpAmount(BigDecimal psPayNormPrcpAmount) {
        this.psPayNormPrcpAmount = psPayNormPrcpAmount;
    }
    public BigDecimal getPsPayOdIntAmount() {
        return psPayOdIntAmount;
    }
    public void setPsPayOdIntAmount(BigDecimal psPayOdIntAmount) {
        this.psPayOdIntAmount = psPayOdIntAmount;
    }
    public BigDecimal getPsPayCommIntAmount() {
        return psPayCommIntAmount;
    }
    public void setPsPayCommIntAmount(BigDecimal psPayCommIntAmount) {
        this.psPayCommIntAmount = psPayCommIntAmount;
    }
    public BigDecimal getPsPayPayedFee() {
        return psPayPayedFee;
    }
    public void setPsPayPayedFee(BigDecimal psPayPayedFee) {
        this.psPayPayedFee = psPayPayedFee;
    }
    public BigDecimal getDevPayedFee() {
        return devPayedFee;
    }
    public void setDevPayedFee(BigDecimal devPayedFee) {
        this.devPayedFee = devPayedFee;
    }

    public BigDecimal getFeeAmt() {
        return feeAmt;
    }
    public void setFeeAmt(BigDecimal feeAmt) {
        this.feeAmt = feeAmt;
    }

    public BigDecimal getDePaymentAmount() {
        return dePaymentAmount;
    }
    public void getDePaymentAmount(BigDecimal dePaymentAmount) {
        this.dePaymentAmount = dePaymentAmount;
    }
    public BigDecimal getDevOdPrcpAmount() {
        return devOdPrcpAmount;
    }
    public void setDevOdPrcpAmount(BigDecimal devOdPrcpAmount) {
        this.devOdPrcpAmount = devOdPrcpAmount;
    }
    public BigDecimal getDevNormPrcpAmount() {
        return devNormPrcpAmount;
    }
    public void setDevNormPrcpAmount(BigDecimal devNormPrcpAmount) {
        this.devNormPrcpAmount = devNormPrcpAmount;
    }
    public BigDecimal getDevOdIntAmount() {
        return devOdIntAmount;
    }
    public void setDevOdIntAmount(BigDecimal devOdIntAmount) {
        this.devOdIntAmount = devOdIntAmount;
    }
    public BigDecimal getDevCommIntAmount() {
        return devCommIntAmount;
    }
    public void setDevCommIntAmount(BigDecimal devCommIntAmount) {
        this.devCommIntAmount = devCommIntAmount;
    }
    public BigDecimal getPrcp() {
        return prcp;
    }
    public void setPrcp(BigDecimal prcp) {
        this.prcp = prcp;
    }
    public BigDecimal getNormInt() {
        return normInt;
    }
    public void setNormInt(BigDecimal normInt) {
        this.normInt = normInt;
    }
    public BigDecimal getOdInt() {
        return odInt;
    }
    public void setOdInt(BigDecimal odInt) {
        this.odInt = odInt;
    }
    public BigDecimal getCommInt() {
        return commInt;
    }
    public void setCommInt(BigDecimal commInt) {
        this.commInt = commInt;
    }
    //还款金额对象构造方法
    public MoneyPayTrans(BigDecimal psPayPrcpAmount, BigDecimal psPayNormPrcpAmount,
                         BigDecimal psPayOdIntAmount, BigDecimal psPayCommIntAmount,
                         BigDecimal psPayPayedFee,BigDecimal  prcp, BigDecimal normInt,
                         BigDecimal odInt,BigDecimal commInt,BigDecimal feeAmt) {
        super();
        this.psPayPrcpAmount = psPayPrcpAmount;
        this.psPayNormPrcpAmount = psPayNormPrcpAmount;
        this.psPayOdIntAmount = psPayOdIntAmount;
        this.psPayCommIntAmount = psPayCommIntAmount;
        this.psPayPayedFee = psPayPayedFee;
        this.prcp = prcp;
        this.normInt = normInt;
        this.odInt = odInt;
        this.commInt = commInt;
        this.feeAmt= feeAmt;
    }
}