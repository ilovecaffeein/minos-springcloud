package com.caxs.minos.serv.buz;

import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.LmSetlmtLog;
import com.caxs.minos.enums.YnFlagEnum;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @ClassName: AdvPaymentLmSetlmtLog
 * 入账流水构造方法
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class AdvPayMentSetlmtLog {
    //主动还款信息
    LmSetlmtLog logg;
    //借据号信息
    private LmLoan lmLoan;

    /**
     * 应归还费用
     */
    private double arrear90overDay = 90;

    /**
     * 应归还费用
     */
    private double arrearAmtPrcp = 0;
    /**
     * 应归还本金
     */
    private double arrearPrincipal = 0;
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
     * 已归还本金
     */
    private double returnPrincipal = 0;
    /**
     * 已归还利息
     */
    private double returnInterest = 0;
    /**
     * 已归还逾期利息
     */
    private double returnLateInterest = 0;
    /**
     * 已归还复利
     */
    private double returnCompoundInterest = 0;

    public double getArrearAmtPrcp() {
        return arrearAmtPrcp;
    }
    public void setArrearAmtPrcp(double arrearAmtPrcp) {
        this.arrearAmtPrcp = arrearAmtPrcp;
    }
    public double getArrearPrincipal() {
        return arrearPrincipal;
    }
    public void setArrearPrincipal(double arrearPrincipal) {
        this.arrearPrincipal = arrearPrincipal;
    }
    public double getArrearInterest() {
        return arrearInterest;
    }
    public void setArrearInterest(double arrearInterest) {
        this.arrearInterest = arrearInterest;
    }
    public double getArrearLateInterest() {
        return arrearLateInterest;
    }
    public void setArrearLateInterest(double arrearLateInterest) {
        this.arrearLateInterest = arrearLateInterest;
    }
    public double getArrearCompoundInterest() {
        return arrearCompoundInterest;
    }
    public void setArrearCompoundInterest(double arrearCompoundInterest) {
        this.arrearCompoundInterest = arrearCompoundInterest;
    }
    public double getReturnPrincipal() {
        return returnPrincipal;
    }
    public void setReturnPrincipal(double returnPrincipal) {
        this.returnPrincipal = returnPrincipal;
    }
    public double getReturnInterest() {
        return returnInterest;
    }
    public void setReturnInterest(double returnInterest) {
        this.returnInterest = returnInterest;
    }
    public double getReturnLateInterest() {
        return returnLateInterest;
    }
    public void setReturnLateInterest(double returnLateInterest) {
        this.returnLateInterest = returnLateInterest;
    }
    public double getReturnCompoundInterest() {
        return returnCompoundInterest;
    }
    public void setReturnCompoundInterest(double returnCompoundInterest) {
        this.returnCompoundInterest = returnCompoundInterest;
    }

    /**
     * 还款试算
     *
     */
    public AdvPayMentSetlmtLog(){}

    /**
     * 还款试算
     *
     * @param logg
     * @param lmLoan
     */
    public AdvPayMentSetlmtLog(LmSetlmtLog logg,
                               LmLoan lmLoan){
        this.logg = logg;
        this.lmLoan = lmLoan;
    }


    /**
     * 生成新添加的入账流水表
     * @param
     * @return
     */
    public LmSetlmtLog buildAppendLmSetlmtLog(LmSetlmtLog lmSetlmtLogg) {
        LmSetlmtLog lmSetlmtLog =new LmSetlmtLog();
        lmSetlmtLog.setBussTyp("NLOAN");
        lmSetlmtLog.setTxNo(Long.valueOf(0));
        lmSetlmtLog.setTxlogNo(logg.getTxLogSeq());
        lmSetlmtLog.setLoanNo(logg.getLoanNo());
        lmSetlmtLog.setSetlMode(logg.getSetlMode());
        lmSetlmtLog.setSetlTyp(logg.getSetlTyp());
        lmSetlmtLog.setSetlRecvAmt(logg.getSetlRecvAmt());
        lmSetlmtLog.setSetlValDt(logg.getSetlValDt());
        lmSetlmtLog.setSetlRevseInd(YnFlagEnum.NO.getCodeInDb());
        lmSetlmtLog.setSetlCreateDt(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        lmSetlmtLog.setSetlCreateUsr(logg.getSetlCreateUsr());
        lmSetlmtLog.setPaymPerdCnt(Integer.valueOf(0));
        lmSetlmtLog.setSetlFeeAmt(new BigDecimal(MinosConst.ZERO_DOUBLE));
        lmSetlmtLog.setSetlRemPrcpPaym(lmSetlmtLogg.getSetlRemPrcpPaym());
        lmSetlmtLog.setSetlOdPrcpAmt(lmSetlmtLogg.getSetlOdIntAmt());
        lmSetlmtLog.setSetlIntAmt(lmSetlmtLogg.getSetlIntAmt());
        lmSetlmtLog.setSetlOdIntAmt(new BigDecimal(MinosConst.ZERO_DOUBLE));
        lmSetlmtLog.setSetlOdCommInt(new BigDecimal(MinosConst.ZERO_DOUBLE));
        lmSetlmtLog.setPpRatBase("OSP");
        lmSetlmtLog.setGenGlInd(YnFlagEnum.YES.getCodeInDb());
        lmSetlmtLog.setLastPayDt(lmLoan.getLastDueDt());
        lmSetlmtLog.setLoanIntRate(lmLoan.getLoanIntRate());
        lmSetlmtLog.setPsBillDt(logg.getPsBillDt());
        lmSetlmtLog.setPsPerdNo(Integer.valueOf(0));
        lmSetlmtLog.setPsMode(logg.getSetlMode());
        lmSetlmtLog.setSetlFpaidIntOpt(logg.getSetlFpaidIntOpt());
        lmSetlmtLog.setSetlAccInt(logg.getSetlAccInt());
        lmSetlmtLog.setOlInd(logg.getOlInd());
        lmSetlmtLog.setPchCde(logg.getPchCde());
        return  lmSetlmtLog;
    }
}
