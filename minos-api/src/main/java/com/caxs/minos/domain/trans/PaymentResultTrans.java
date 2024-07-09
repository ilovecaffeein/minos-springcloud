package com.caxs.minos.domain.trans;


import com.caxs.minos.domain.LmPmShd;

import java.io.Serializable;
import java.util.List;

/**
 * Created by coffee on 2020/8/19.
 */
public class PaymentResultTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;

    // 还款计划列表属性
    private List<LmPmShd> lmPmShdList;
    // 还款计划表列表属性
    private List<PaymentShdTrans> paymentShdList;

    // 交易序列号
    private long txNo;
    /**
     * 是否还清欠款
     */
    private boolean isPayUpOwed;
    /**
     * 1未结清 0已结清
     */
    private String payUpInd;
    /**
     * 是否全部结清
     */
    private boolean isPayUpAll;
    /**
     *归还费用
     */
    private double payFeeAmt = 0;

    public double getPayFeeAmt() {
        return payFeeAmt;
    }

    public void setPayFeeAmt(double payFeeAmt) {
        this.payFeeAmt = payFeeAmt;
    }
    /**
     *归还逾期费用
     */
    private double payOdFeeAmt = 0;

    public double getPayOdFeeAmt() {
        return payOdFeeAmt;
    }

    public void setPayOdFeeAmt(double payOdFeeAmt) {
        this.payOdFeeAmt = payOdFeeAmt;
    }

    /**
     * 是否贷款置换add by fanyl on 2014-12-01
     */
    private boolean isDisp = false;
    // 还款本金
    private double payPrcpAmt = 0;
    // 还款逾期本金
    private double payOdPrcpAmt = 0;
    // 还款正常本金
    private double payNormPrcpAmt = 0;
    // 还款正常利息金额
    private double payNormInt = 0;
    // 还款罚息金额
    private double payOdInt = 0;
    // 还款复利金额
    private double payCommInt = 0;
    // 剩余本金金额
    private double remPrcpAmt = 0;

    /**
     * 是否全部结清
     *
     * @return
     */
    public boolean isPayUpAll() {
        return isPayUpAll;
    }

    // 赋值是否全部结清
    public void setPayUpAll(boolean isPayUpAll) {
        this.isPayUpAll = isPayUpAll;
        if (isPayUpAll) {
            isPayUpOwed = true;
        }
    }

    /**
     * 是否还清欠款
     *
     * @return
     */
    public boolean isPayUpOwed() {
        return isPayUpOwed;
    }

    // 赋值是否结清欠款
    public void setPayUpOwed(boolean isPayUpOwed) {
        this.isPayUpOwed = isPayUpOwed;
    }

    // 获取还款计划列表信息
    public List<PaymentShdTrans> getPaymentShdList() {
        return paymentShdList;
    }

    // 赋值还款计划列表信息
    public void setPaymentShdList(List<PaymentShdTrans> paymentShdList) {
        this.paymentShdList = paymentShdList;
    }

    // 获取还款正常利息
    public double getPayNormInt() {
        return payNormInt;
    }

    // 赋值还款正常利息
    public void setPayNormInt(double payNormInt) {
        this.payNormInt = payNormInt;
    }

    // 获取还款罚息金额
    public double getPayOdInt() {
        return payOdInt;
    }

    // 赋值还款罚息金额
    public void setPayOdInt(double payOdInt) {
        this.payOdInt = payOdInt;
    }

    // 获取还款复利金额
    public double getPayCommInt() {
        return payCommInt;
    }

    // 赋值还款复利金额
    public void setPayCommInt(double payCommInt) {
        this.payCommInt = payCommInt;
    }

    // 获取还款逾期本金金额
    public double getPayOdPrcpAmt() {
        return payOdPrcpAmt;
    }

    // 赋值还款逾期本金金额
    public void setPayOdPrcpAmt(double payOdPrcpAmt) {
        this.payOdPrcpAmt = payOdPrcpAmt;
    }

    // 获取还款正常本金金额
    public double getPayNormPrcpAmt() {
        return payNormPrcpAmt;
    }

    // 赋值还款正常本金金额
    public void setPayNormPrcpAmt(double payNormPrcpAmt) {
        this.payNormPrcpAmt = payNormPrcpAmt;
    }

    /**
     * 获取剩余本金
     *
     * @return the remPrcpAmt
     */
    public double getRemPrcpAmt() {
        return remPrcpAmt;
    }

    /**
     * 赋值剩余本金
     *
     * @param remPrcpAmt
     *            the remPrcpAmt to set
     */
    public void setRemPrcpAmt(double remPrcpAmt) {
        this.remPrcpAmt = remPrcpAmt;
    }

    /**
     * 获取是否结清标志 1未结清 0已结清
     *
     * @return the payUpInd
     */
    public String getPayUpInd() {
        return payUpInd;
    }

    /**
     * 获取还款本金金额
     *
     * @return the payPrcpAmt
     */
    public double getPayPrcpAmt() {
        return payPrcpAmt;
    }

    /**
     * 赋值结清标志
     *
     * @param payUpInd
     *            the payUpInd to set
     */
    public void setPayUpInd(String payUpInd) {
        this.payUpInd = payUpInd;
    }

    /**
     * 赋值还款本金金额
     *
     * @param payPrcpAmt
     *            the payPrcpAmt to set
     */
    public void setPayPrcpAmt(double payPrcpAmt) {
        this.payPrcpAmt = payPrcpAmt;
    }

    /**
     * 获取还款计划列表
     *
     * @return the lmPmShdList
     */
    public List<LmPmShd> getLmPmShdList() {
        return lmPmShdList;
    }

    /**
     * 获取交易序号
     *
     * @return the txNo
     */
    public long getTxNo() {
        return txNo;
    }

    /**
     * 赋值还款计划列表信息
     *
     * @param lmPmShdList
     *            the lmPmShdList to set
     */
    public void setLmPmShdList(List<LmPmShd> lmPmShdList) {
        this.lmPmShdList = lmPmShdList;
    }

    /**
     * 赋值交易序号
     *
     * @param txNo
     *            the txNo to set
     */
    public void setTxNo(long txNo) {
        this.txNo = txNo;
    }

    public boolean isDisp() {
        return isDisp;
    }

    public void setIsDisp(boolean isDisp) {
        this.isDisp = isDisp;
    }

}

