package com.caxs.minos.domain.trans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2020/8/13.
 */
public class PaymentTryCalculationTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;
    /**
     * 归还总金额
     */
    static double toPayMoney = 0;
    /**
     * 应归还本金
     */
    private double arrearPrincipal = 0;
    /**
     * 应归还费用
     */
    private double arrearFeeAmt = 0;
    /**
     * 应归还利息
     */
    private double arrearInterest = 0;
    /**
     * 应归还逾期利息
     */
    private double arrearLateInterest = 0;
    /**
     * 应归还复利
     */
    private double arrearCompoundInterest = 0;
    /**
     * 归还本金
     */
    private double returnPrincipal = 0;
    /**
     * 归还利息
     */
    private double returnInterest = 0;
    /**
     *归还费用
     */
    private double returnFeeAmt=0;

    public double getReturnFeeAmt() {
        return returnFeeAmt;
    }

    public void setReturnFeeAmt(double returnFeeAmt) {
        this.returnFeeAmt = returnFeeAmt;
    }

    /**
     * 归还逾期利息
     */
    private double returnLateInterest = 0;
    /**
     * 归还复利
     */
    private double returnCompoundInterest = 0;

    /**
     * 保留原期供金额的相对缩期期数
     */
    private int shortenPerdCnt;

    /**
     * 获取保留原期供金额的相对缩期期数
     *
     * @return
     */
    public int getShortenPerdCnt() {
        return shortenPerdCnt;
    }

    /**
     * 设置保留原期供金额的相对缩期期数
     *
     * @param shortenPerdCnt
     */
    public void setShortenPerdCnt(int shortenPerdCnt) {
        this.shortenPerdCnt = shortenPerdCnt;
    }

    /**
     * 主动还款本金
     */
    private double remainingPrincipal = 0;

    /**
     * 主动还款利息
     */
    private double remainingInterest = 0;
    /**
     * 主动还款逾期利息
     */
    private double remainingLateInterest = 0;
    /**
     * 主动还款复利
     */
    private double remainingCompoundInterest = 0;
    /**
     * 期号
     */
    private short perdno = 0;

    /**
     * 待收费
     */
    private List<LmFeeTxTrans> holdFeeList;

    public List<LmFeeTxTrans> getHoldFeeList() {
        return holdFeeList;
    }

    public void setHoldFeeList(List<LmFeeTxTrans> holdFeeList) {
        this.holdFeeList = holdFeeList;
    }

    /**
     * 提前还款后还款计划
     */
    private List<ShdTrans> actvPayShdList;

    /**
     * 获取提前还款后还款计划
     *
     * @return
     */
    public List<ShdTrans> getActvPayShdList() {
        return actvPayShdList;
    }

    /**
     * 获取期号
     *
     * @return
     */
    public short getPerdno() {
        return perdno;
    }

    /**
     * 设置期号
     *
     * @param perdno
     */
    public void setPerdno(short perdno) {
        this.perdno = perdno;
    }

    /**
     * 设置提前还款后还款计划
     *
     * @param actvPayShdList
     */
    public void setActvPayShdList(List<ShdTrans> actvPayShdList) {
        this.actvPayShdList = actvPayShdList;
    }

    /**
     * 还款试算
     *
     * @param arrearPrincipal
     * @param arrearInterest
     * @param arrearLateInterest
     * @param arrearCompoundInterest
     */
    public PaymentTryCalculationTrans(double arrearPrincipal, double arrearInterest,
                                      double arrearLateInterest, double arrearCompoundInterest,
                                      short perdno) {
        this.arrearPrincipal = arrearPrincipal;
        this.arrearInterest = arrearInterest;
        this.arrearLateInterest = arrearLateInterest;
        this.arrearCompoundInterest = arrearCompoundInterest;
        this.returnInterest = arrearInterest;
        this.returnPrincipal = arrearPrincipal;
        this.returnLateInterest = arrearLateInterest;
        this.returnCompoundInterest = arrearCompoundInterest;
        this.perdno = perdno;
    }

    /**
     * 还款试算
     *
     * @param arrearPrincipal
     * @param arrearInterest
     * @param arrearLateInterest
     * @param arrearCompoundInterest
     */
    public PaymentTryCalculationTrans(double arrearPrincipal, double arrearInterest,
                                      double arrearLateInterest, double arrearCompoundInterest,
                                      double arrearFeeAmt) {
        this.arrearPrincipal = arrearPrincipal;
        this.arrearInterest = arrearInterest;
        this.arrearLateInterest = arrearLateInterest;
        this.arrearCompoundInterest = arrearCompoundInterest;
        this.arrearFeeAmt = arrearFeeAmt;
        this.returnInterest = arrearInterest;
        this.returnPrincipal = arrearPrincipal;
        this.returnLateInterest = arrearLateInterest;
        this.returnCompoundInterest = arrearCompoundInterest;
    }

    /**
     * 还款试算
     *
     * @param arrearPrincipal
     * @param arrearInterest
     * @param arrearLateInterest
     * @param arrearCompoundInterest
     * @param remainingPrincipal
     * @param remainingInterest
     * @param remainingLateInterest
     * @param remainingCompoundInterest
     */
    public PaymentTryCalculationTrans(double arrearPrincipal, double arrearInterest,
                                      double arrearLateInterest, double arrearCompoundInterest,
                                      double remainingPrincipal, double remainingInterest,
                                      double remainingLateInterest, double remainingCompoundInterest) {
        this.arrearPrincipal = arrearPrincipal;
        this.arrearInterest = arrearInterest;
        this.arrearLateInterest = arrearLateInterest;
        this.arrearCompoundInterest = arrearCompoundInterest;
        this.remainingPrincipal = remainingPrincipal;
        this.remainingInterest = remainingInterest;
        this.remainingLateInterest = remainingLateInterest;
        this.remainingCompoundInterest = remainingCompoundInterest;
    }

    /**
     * 还款试算
     *
     * @param arrearPrincipal
     * @param arrearInterest
     * @param arrearLateInterest
     * @param arrearCompoundInterest
     * @param returnPrincipal
     * @param returnInterest
     * @param returnLateInterest
     * @param returnCompoundInterest
     * @param remainingPrincipal
     * @param remainingInterest
     * @param remainingLateInterest
     * @param remainingCompoundInterest
     */
    public PaymentTryCalculationTrans(double arrearPrincipal, double arrearInterest,
                                      double arrearLateInterest, double arrearCompoundInterest,
                                      double returnPrincipal, double returnInterest,
                                      double returnLateInterest, double returnCompoundInterest,
                                      double remainingPrincipal, double remainingInterest,
                                      double remainingLateInterest, double remainingCompoundInterest) {
        this.arrearPrincipal = arrearPrincipal;
        this.arrearInterest = arrearInterest;
        this.arrearLateInterest = arrearLateInterest;
        this.arrearCompoundInterest = arrearCompoundInterest;
        this.returnPrincipal = returnPrincipal;
        this.returnInterest = returnInterest;
        this.returnLateInterest = returnLateInterest;
        this.returnCompoundInterest = returnCompoundInterest;
        this.remainingPrincipal = remainingPrincipal;
        this.remainingInterest = remainingInterest;
        this.remainingLateInterest = remainingLateInterest;
        this.remainingCompoundInterest = remainingCompoundInterest;
    }
    /**
     * 实际还款金额
     *
     * @return the arrearPrincipal
     */
    public double getToPayMoney() {
        return toPayMoney;
    }

    public void setToPayMoney(double toPayMoney) {
        this.toPayMoney = toPayMoney;
    }

    /**
     * 获取应归还本金
     *
     * @return the arrearPrincipal
     */
    public double getArrearPrincipal() {
        return arrearPrincipal;
    }

    /**
     * 设置应归还本金
     *
     * @param arrearPrincipal
     */
    public void setArrearPrincipal(double arrearPrincipal) {
        this.arrearPrincipal = arrearPrincipal;
    }

    /**
     * 获取应归还利息
     *
     * @return the arrearInterest
     */
    public double getArrearInterest() {
        return arrearInterest;
    }

    /**
     * 设置应归还利息
     *
     * @param arrearInterest
     */
    public void setArrearInterest(double arrearInterest) {
        this.arrearInterest = arrearInterest;
    }

    /**
     * 获取应归还逾期利息
     *
     * @return the arrearLateInterest
     */
    public double getArrearLateInterest() {
        return arrearLateInterest;
    }

    /**
     * 设置应归还逾期利息
     *
     * @param arrearLateInterest
     */
    public void setArrearLateInterest(double arrearLateInterest) {
        this.arrearLateInterest = arrearLateInterest;
    }

    /**
     * 获取应归还复利
     *
     * @return the arrearCompoundInterest
     */
    public double getArrearCompoundInterest() {
        return arrearCompoundInterest;
    }

    /**
     * 设置应归还复利
     *
     * @param arrearCompoundInterest
     */
    public void setArrearCompoundInterest(double arrearCompoundInterest) {
        this.arrearCompoundInterest = arrearCompoundInterest;
    }

    /**
     * 获取归还本金
     *
     * @return the returnPrincipal
     */
    public double getReturnPrincipal() {
        return returnPrincipal;
    }

    /**
     * 获取归还利息
     *
     * @return the returnInterest
     */
    public double getReturnInterest() {
        return returnInterest;
    }

    /**
     * 获取归还逾期利息
     *
     * @return the returnLateInterest
     */
    public double getReturnLateInterest() {
        return returnLateInterest;
    }

    /**
     * 获取归还复利
     *
     * @return the returnCompoundInterest
     */
    public double getReturnCompoundInterest() {
        return returnCompoundInterest;
    }

    /**
     * 获取主动还款本金
     *
     * @return the remainingPrincipal
     */
    public double getRemainingPrincipal() {
        return remainingPrincipal;
    }

    /**
     * 获取主动还款利息
     *
     * @return the remainingInterest
     */
    public double getRemainingInterest() {
        return remainingInterest;
    }

    /**
     * 获取主动还款逾期利息
     *
     * @return the remainingLateInterest
     */
    public double getRemainingLateInterest() {
        return remainingLateInterest;
    }

    /**
     * 获取主动还款复利
     *
     * @return the remainingCompoundInterest
     */
    public double getRemainingCompoundInterest() {
        return remainingCompoundInterest;
    }

    /**
     * 设置归还本金
     *
     * @param returnPrincipal
     *            the returnPrincipal to set
     */
    public void setReturnPrincipal(double returnPrincipal) {
        this.returnPrincipal = returnPrincipal;
    }

    /**
     * 设置归还利息
     *
     * @param returnInterest
     *            the returnInterest to set
     */
    public void setReturnInterest(double returnInterest) {
        this.returnInterest = returnInterest;
    }

    /**
     * 设置归还逾期利息
     *
     * @param returnLateInterest
     *            the returnLateInterest to set
     */
    public void setReturnLateInterest(double returnLateInterest) {
        this.returnLateInterest = returnLateInterest;
    }

    /**
     * 设置归还复利
     *
     * @param returnCompoundInterest
     *            the returnCompoundInterest to set
     */
    public void setReturnCompoundInterest(double returnCompoundInterest) {
        this.returnCompoundInterest = returnCompoundInterest;
    }

    /**
     * 设置主动还款本金
     *
     * @param remainingPrincipal
     *            the remainingPrincipal to set
     */
    public void setRemainingPrincipal(double remainingPrincipal) {
        this.remainingPrincipal = remainingPrincipal;
    }

    /**
     * 设置主动还款利息
     *
     * @param remainingInterest
     *            the remainingInterest to set
     */
    public void setRemainingInterest(double remainingInterest) {
        this.remainingInterest = remainingInterest;
    }

    /**
     * 设置主动还款逾期利息
     *
     * @param remainingLateInterest
     *            the remainingLateInterest to set
     */
    public void setRemainingLateInterest(double remainingLateInterest) {
        this.remainingLateInterest = remainingLateInterest;
    }

    /**
     * 设置主动还款复利
     *
     * @param remainingCompoundInterest
     *            the remainingCompoundInterest to set
     */
    public void setRemainingCompoundInterest(double remainingCompoundInterest) {
        this.remainingCompoundInterest = remainingCompoundInterest;
    }

    public double getArrearFeeAmt() {
        return arrearFeeAmt;
    }

    public void setArrearFeeAmt(double arrearFeeAmt) {
        this.arrearFeeAmt = arrearFeeAmt;
    }

    // 还款计划表列表属性
    private List<PaymentShdTrans> paymentShdList;

    public List<PaymentShdTrans> getPaymentShdList() {
        return paymentShdList;
    }

    public void setPaymentShdList(List<PaymentShdTrans> paymentShdList) {
        this.paymentShdList = paymentShdList;
    }

}
