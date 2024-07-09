package com.caxs.minos.domain.trans;

import java.io.Serializable;
import java.util.List;
/**
 * Created by lenovo on 2024/8/13.
 */
public class PaymentTryCalculationTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;
    /**
     * 应归总金额
     */
    private double arrearTotalAmt = 0;
    /**
     * 应归违约金率（留购价）
     */
    private double svcChargeRate = 0;
    /**
     * 应归提前终止损失金
     */
    private double actvLossAmt = 0;
    /**
     * 应归催收违约金
     */
    private double recallAmt = 0;

    /**
     * 应归还本金
     */
    private double arrearPrincipal = 0;
    /**
     * 应归还利息
     */
    private double arrearInterest = 0;
    /**
     * 应归还罚息
     */
    private double arrearLateInterest = 0;
    /**
     * 应归还复利
     */
    private double arrearCompoundInterest = 0;
    /**
     * 应归还贴息
     */
    private double arrearSbsyIntAmt = 0;
    /**
     * 应归还费用
     */
    private double arrearFeeAmt = 0;
    /**
     * 应归还逾期费用
     */
    private double arrearOdFeeAmt = 0;

    /**
     * 获取应归还总金额
     *
     * @return the arrearTotalAmt
     */
    public double getArrearTotalAmt() {
        return arrearTotalAmt;
    }
    /**
     * 设置应归还总金额
     *
     * @return the arrearTotalAmt
     */
    public void setArrearTotalAmt(double arrearTotalAmt) {
        this.arrearTotalAmt = arrearTotalAmt;
    }


    /**
     * 获取应归提前终止损失金
     *
     * @return the actvLossAmt
     */
    public double getActvLossAmt() {
        return actvLossAmt;
    }
    /**
     * 设置应归提前终止损失金
     *
     * @return the actvLossAmt
     */
    public void setActvLossAmt(double actvLossAmt) {
        this.actvLossAmt = actvLossAmt;
    }

    /**
     * 获取应归催收违约金
     *
     * @return the recallAmt
     */
    public double getRecallAmt() {
        return recallAmt;
    }
    /**
     * 设置应归催收违约金
     *
     * @return the recallAmt
     */
    public void setRecallAmt(double recallAmt) {
        this.recallAmt = recallAmt;
    }

    /**
     * 获取应归违约金率（留购价）
     *
     * @return the svcChargeRate
     */
    public double getSvcChargeRate() {
        return svcChargeRate;
    }
    /**
     * 设置应归违约金率（留购价）
     *
     * @return the svcChargeRate
     */
    public void setSvcChargeRate(double svcChargeRate) {
        this.svcChargeRate = svcChargeRate;
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
     * 获取应归还贴息
     *
     * @return the arrearSbsyIntAmt
     */
    public double getArrearSbsyIntAmt() {
        return arrearSbsyIntAmt;
    }
    /**
     * 设置应归还贴息
     *
     * @param arrearSbsyIntAmt
     */
    public void setArrearSbsyIntAmt(double arrearSbsyIntAmt) {
        this.arrearSbsyIntAmt = arrearSbsyIntAmt;
    }

    /**
     * 获取应归还费用
     *
     * @return the arrearFeeAmt
     */
    public double getArrearFeeAmt() {
        return arrearFeeAmt;
    }
    /**
     * 设置应归还费用
     *
     * @param arrearFeeAmt
     */
    public void setArrearFeeAmt(double arrearFeeAmt) {
        this.arrearFeeAmt = arrearFeeAmt;
    }

    /**
     * 获取应归还逾期费用
     *
     * @return the arrearOdFeeAmt
     */
    public double getArrearOdFeeAmt() {
        return arrearOdFeeAmt;
    }

    /**
     * 获取应归还逾期费用
     */
    public void setArrearOdFeeAmt(double arrearOdFeeAmt) {
        this.arrearOdFeeAmt = arrearOdFeeAmt;
    }


    /**
     * 外部应归本金
     */
    private double arrearOutPrincipal = 0;
    /**
     * 外部应归利息
     */
    private double arrearOutInterest = 0;
    /**
     * 外部应归罚息
     */
    private double arrearOutOdInt = 0;
    /**
     * 外部应归复利
     */
    private double arrearOutcommInt = 0;
    /**
     * 外部应归费用
     */
    private double arrearOutFeeAmt = 0;

    /**
     * 获取外部应归本金
     */
    public double getArrearOutPrincipal() {
        return arrearOutPrincipal;
    }

    /**
     * 设置外部应归本金
     * @param arrearOutPrincipal
     */
    public void setArrearOutPrincipal(double arrearOutPrincipal) {
        this.arrearOutPrincipal = arrearOutPrincipal;
    }

    /**
     * 获取外部应归利息
     */
    public double getArrearOutInterest() {
        return arrearOutInterest;
    }

    /**
     * 设置外部应归罚息
     * @param arrearOutInterest
     */
    public void setArrearOutInterest(double arrearOutInterest) {
        this.arrearOutInterest = arrearOutInterest;
    }

    /**
     * 获取外部应归罚息
     */
    public double getArrearOutOdInt() {
        return arrearOutOdInt;
    }
    /**
     * 设置外部应归利息
     *
     * @param arrearOutOdInt
     */
    public void setArrearOutOdInt(double arrearOutOdInt) {
        this.arrearOutOdInt = arrearOutOdInt;
    }

    /**
     * 获取外部应归复利
     */
    public double getArrearOutcommInt() {
        return arrearOutcommInt;
    }

    /**
     * 设置外部应归复利
     * @param arrearOutcommInt
     */
    public void setArrearOutcommInt(double arrearOutcommInt) {
        this.arrearOutcommInt = arrearOutcommInt;
    }

    /**
     * 获取外部应归费用
     */
    public double getArrearOutFeeAmt() {
        return arrearOutFeeAmt;
    }

    /**
     * 设置外部应归费用
     * @param arrearOutFeeAmt
     */
    public void setArrearOutFeeAmt(double arrearOutFeeAmt) {
        this.arrearOutFeeAmt = arrearOutFeeAmt;
    }

    /**
     * 期号
     */
    private short perdno = 0;
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
     * 保留原期供金额的相对缩期期数
     */
    private int shortenPerdCnt;

    /**
     * 获取保留原期供金额的相对缩期期数
     * @return
     */
    public int getShortenPerdCnt() {
        return shortenPerdCnt;
    }

    /**
     * 设置保留原期供金额的相对缩期期数
     * @param shortenPerdCnt
     */
    public void setShortenPerdCnt(int shortenPerdCnt) {
        this.shortenPerdCnt = shortenPerdCnt;
    }


    /**
     * 提前还款后还款计划
     */
    private List<ShdTrans> actvPayShdList = null;
    /**
     * 获取提前还款后还款计划
     * @return
     */
    public List<ShdTrans> getActvPayShdList() {
        return actvPayShdList;
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
     * 待收费
     */
    private List<LmFeeTxTrans> holdFeeList;

    /**
     * 获取待收费
     */
    public List<LmFeeTxTrans> getHoldFeeList() {
        return holdFeeList;
    }
    /**
     * 设置待收费
     *
     * @param holdFeeList
     */
    public void setHoldFeeList(List<LmFeeTxTrans> holdFeeList) {
        this.holdFeeList = holdFeeList;
    }


    // 还款计划表列表属性
    private List<PaymentShdTrans> paymentShdList;
    /**
     * 获取还款计划表列表属性
     */
    public List<PaymentShdTrans> getPaymentShdList() {
        return paymentShdList;
    }
    /**
     * 设置还款计划表列表属性
     *
     * @param paymentShdList
     */
    public void setPaymentShdList(List<PaymentShdTrans> paymentShdList) {
        this.paymentShdList = paymentShdList;
    }



    /**
     * 提前还款后还款计划
     */
    private List<ShdViewTrans> actvLhyhShdList = null;
    /**
     * 获取提前还款后还款计划
     *
     * @return
     */
    public List<ShdViewTrans> getActvLhyhShdList() {
        return actvLhyhShdList;
    }
    /**
     * 获取提前还款后还款计划
     */
    public void setActvLhyhShdList(List<ShdViewTrans> actvLhyhShdList) {
        this.actvLhyhShdList = actvLhyhShdList;
    }




    /**
     * 归还本金
     */
    private double returnPrincipal = 0;
    /**
     * 归还利息
     */
    private double returnInterest = 0;
    /**
     * 归还逾期利息
     */
    private double returnLateInterest = 0;
    /**
     * 归还复利
     */
    private double returnCompoundInterest = 0;
    /**
     * 归还贴息
     */
    private double returnSbsyIntAmt = 0;
    /**
     *归还费用
     */
    private double returnFeeAmt=0;
    /**
     *归还逾期费用
     */
    private double returnOdFeeAmt=0;

    /**
     * 获取归还本金
     * @return the returnPrincipal
     */
    public double getReturnPrincipal() {
        return returnPrincipal;
    }

    /**
     * 设置归还本金
     * @param returnPrincipal
     */
    public void setReturnPrincipal(double returnPrincipal) {
        this.returnPrincipal = returnPrincipal;
    }

    /**
     * 获取归还利息
     * @return the returnInterest
     */
    public double getReturnInterest() {
        return returnInterest;
    }

    /**
     *设置归还利息
     * @return the returnInterest
     */
    public void setReturnInterest(double returnInterest) {
        this.returnInterest = returnInterest;
    }

    /**
     * 获取归还逾期利息
     * @return the returnLateInterest
     */
    public double getReturnLateInterest() {
        return returnLateInterest;
    }

    /**
     * 设置归还逾期利息
     * @param returnLateInterest
     */
    public void setReturnLateInterest(double returnLateInterest) {
        this.returnLateInterest = returnLateInterest;
    }

    /**
     * 获取归还复利
     * @return the returnCompoundInterest
     */
    public double getReturnCompoundInterest() {
        return returnCompoundInterest;
    }

    /**
     * 设置归还复利
     * @param returnCompoundInterest
     */
    public void setReturnCompoundInterest(double returnCompoundInterest) {
        this.returnCompoundInterest = returnCompoundInterest;
    }

    /**
     * 获取归还贴息
     * @return the returnSbsyIntAmt
     */
    public double getReturnSbsyIntAmt() {
        return returnSbsyIntAmt;
    }

    /**
     * 设置归还贴息
     * @param returnSbsyIntAmt
     */
    public void setReturnSbsyIntAmt(double returnSbsyIntAmt) {
        this.returnSbsyIntAmt = returnSbsyIntAmt;
    }

    /**
     * 获取归还费用
     * @return the returnFeeAmt
     */
    public double getReturnFeeAmt() {
        return returnFeeAmt;
    }

    /**
     * 设置归还费用
     * @return the returnFeeAmt
     */
    public void setReturnFeeAmt(double returnFeeAmt) {
        this.returnFeeAmt = returnFeeAmt;
    }

    /**
     * 获取归还逾期费用
     * @return the returnOdFeeAmt
     */
    public double setReturnOdFeeAmt() {
        return returnOdFeeAmt;
    }

    /**
     * 设置逾期费用
     * @return the returnOdFeeAmt
     */
    public void setReturnOdFeeAmt(double returnOdFeeAmt) {
        this.returnOdFeeAmt = returnOdFeeAmt;
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
     * 主动还款贴息
     */
    private double remainingSbsyAmt = 0;
    /**
     * 主动还款违约金
     */
    private double remainingFeeAmt = 0;
    /**
     * 主动还款服务费
     */
    private double remainingSerAmt = 0;

    /**
     * 获取主动还款本金
     * @return the remainingPrincipal
     */
    public double getRemainingPrincipal() {
        return remainingPrincipal;
    }

    /**
     * 设置主动还款本金
     * @param remainingPrincipal
     */
    public void setRemainingPrincipal(double remainingPrincipal) {
        this.remainingPrincipal = remainingPrincipal;
    }

    /**
     * 获取主动还款利息
     * @return the remainingInterest
     */
    public double getRemainingInterest() {
        return remainingInterest;
    }

    /**
     * 设置主动还款利息
     * @param remainingInterest
     */
    public void setRemainingInterest(double remainingInterest) {
        this.remainingInterest = remainingInterest;
    }

    /**
     * 获取主动还款逾期利息
     * @return the remainingLateInterest
     */
    public double getRemainingLateInterest() {
        return remainingLateInterest;
    }

    /**
     * 设置主动还款逾期利息
     * @param remainingLateInterest
     */
    public void setRemainingLateInterest(double remainingLateInterest) {
        this.remainingLateInterest = remainingLateInterest;
    }

    /**
     * 获取主动还款复利
     * @return the remainingCompoundInterest
     */
    public double getRemainingCompoundInterest() {
        return remainingCompoundInterest;
    }

    /**
     * 设置主动还款复利
     * @param remainingCompoundInterest
     *            the remainingCompoundInterest to set
     */
    public void setRemainingCompoundInterest(double remainingCompoundInterest) {
        this.remainingCompoundInterest = remainingCompoundInterest;
    }

    /**
     * 获取主动还款违约金
     * @return the remainingFeeAmt
     */
    public double getRemainingFeeAmt() {
        return remainingFeeAmt;
    }

    /**
     * 设置主动还款违约金
     * @param remainingFeeAmt
     */
    public void setRemainingFeeAmt(double remainingFeeAmt) {
        this.remainingFeeAmt = remainingFeeAmt;
    }

    /**
     * 获取主动还款贴息
     * @return the remainingSbsyAmt
     */
    public double getRemainingSbsyAmt() {
        return remainingSbsyAmt;
    }

    /**
     * 设置主动还款贴息
     * @param remainingSbsyAmt
     *            the remainingSbsyAmt to set
     */
    public void setRemainingSbsyAmt(double remainingSbsyAmt) {
        this.remainingSbsyAmt = remainingSbsyAmt;
    }

    /**
     * 获取主动还款服务费
     * @return the remainingSerAmt
     */
    public double getRemainingSerAmt() {
        return remainingSerAmt;
    }

    /**
     * 设置主动还款服务费
     * @param remainingSerAmt
     */
    public void setRemainingSerAmt(double remainingSerAmt) {
        this.remainingSerAmt = remainingSerAmt;
    }

    String tPsPerdNo ="" ;
    /**
     * 获取多期次传数组
     * @return the tPsPerdNo
     */
    public String getTPsPerdNo() {
        return tPsPerdNo;
    }
    /**
     * 设置返回交易码
     *
     * @param tPsPerdNo
     *            the errorCode to set
     */
    public void setTPsPerdNo(String tPsPerdNo) {
        this.tPsPerdNo = tPsPerdNo;
    }


    String errorCode ="00000" ;
    /**
     * 获取返回交易码
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 设置返回交易码
     * @param errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    String errorMsg ="成功" ;
    /**
     * 获取返回交易信息
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * 设置返回交易信息
     * @param errorMsg
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


    /**
     * 还款试算
     */
    public PaymentTryCalculationTrans() {
    }


    /**
     * 还款试算
     *
     * @param arrearPrincipal
     * @param arrearInterest
     * @param arrearLateInterest
     * @param arrearCompoundInterest
     */
    public PaymentTryCalculationTrans(double arrearTotalAmt ,double arrearPrincipal, double arrearInterest,
                                 double arrearLateInterest, double arrearCompoundInterest,double arrearSbsyIntAmt, double arrearFeeAmt,
                                 double arrearOdFeeAmt,double arrearOutPrincipal,double arrearOutInterest,
                                 double arrearOutOdInt,double arrearOutcommInt,double arrearOutFeeAmt,double returnPrincipal,
                                 double returnInterest,double returnLateInterest,double returnCompoundInterest,double returnSbsyIntAmt,
                                 double returnFeeAmt,double returnOdFeeAmt,double remainingPrincipal,double remainingInterest,
                                 double remainingLateInterest,double remainingCompoundInterest,double remainingSbsyAmt,double remainingFeeAmt,
                                 double remainingSerAmt,double svcChargeRate,double actvLossAmt,double recallAmt) {
        this.arrearTotalAmt = arrearTotalAmt;
        this.arrearPrincipal = arrearPrincipal;
        this.arrearInterest = arrearInterest;
        this.arrearLateInterest = arrearLateInterest;
        this.arrearCompoundInterest = arrearCompoundInterest;
        this.arrearSbsyIntAmt = arrearSbsyIntAmt;
        this.arrearFeeAmt = arrearFeeAmt;
        this.arrearOdFeeAmt = arrearOdFeeAmt;
        this.arrearOutPrincipal = arrearOutPrincipal;
        this.arrearOutInterest = arrearOutInterest;
        this.arrearOutOdInt = arrearOutOdInt;
        this.arrearOutcommInt = arrearOutcommInt;
        this.arrearOutFeeAmt = arrearOutFeeAmt;
        this.returnPrincipal = returnPrincipal;
        this.returnInterest = returnInterest;
        this.returnLateInterest = returnLateInterest;
        this.returnCompoundInterest = returnCompoundInterest;
        this.returnSbsyIntAmt = returnSbsyIntAmt;
        this.returnFeeAmt = returnFeeAmt;
        this.returnOdFeeAmt = returnOdFeeAmt;
        this.remainingPrincipal = remainingPrincipal;
        this.remainingInterest = remainingInterest;
        this.remainingLateInterest = remainingLateInterest;
        this.remainingCompoundInterest = remainingCompoundInterest;
        this.remainingSbsyAmt = remainingSbsyAmt;
        this.remainingFeeAmt = remainingFeeAmt;
        this.remainingSerAmt = remainingSerAmt;
        this.svcChargeRate = svcChargeRate;
        this.actvLossAmt = actvLossAmt;
        this.recallAmt = recallAmt;
    }
}
