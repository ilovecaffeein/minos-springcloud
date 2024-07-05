package com.caxs.minos.domain.trans;

import java.io.Serializable;

/**
 * LmLnShdMtd 对应交互类
 *
 * --还款方式
 */
public class LmLnShdMtdTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;

    private Integer termNo;	//阶段号
    private String loanNo;	//借据号
    private String intStartDt;	//起息日
    private Integer frmPerd;	//从第几期
    private Integer toPerd;	//到第几期
    private String paymTyp;	//还款类型
    private String paymOpt;		//还款方式
    private Double termPrcpAmt;	//阶段本金额(拟还本金)
    private Double pgsPrcpPct;	//等比递增还款增加额
    private Double pgsPrcpAmt;	//等额递增还款增加额
    private Integer pgsPrcpFreq;	//递增还款周期
    private Integer calTotInstm;	//实际计算期数

    private String rateTyp;		 //基准类型类型
    private Double baseRate;	//基准利率
    private Double sprd;		//浮动利率
    private Double loanIntRate;	//贷款执行利率
    private Double loanOdIntRate;	//罚息执行利率
    private Double intAdjPct;		//利率浮动比例
    private String intBase;			//利息计算基础
    private Double prcpPct;			//本金比例
    private String loanRateMode;	//利率模式
    private String ratBase;			//计算类型
    private String paymFreqUnit="M";	//还款间隔单位
    private Short paymFreqFreq=1;		//还款间隔

    // Constructors
    /**
     * 获取起息日
     * @return
     */
    public String getIntStartDt() {
        return this.intStartDt;
    }
    /**
     * 设置起息日
     * @param intStartDt
     */
    public void setIntStartDt(String intStartDt) {
        this.intStartDt = intStartDt;
    }

    /**
     * 获取还款间隔单位
     * @return
     */
    public String getRateTyp() {
        return rateTyp;
    }
    /**
     * 基准类型类型
     * @param rateTyp
     */
    public void  setRateTyp(String rateTyp) {
        this.rateTyp = rateTyp;
    }

    /**
     * 获取还款间隔单位
     * @return
     */
    public String getPaymFreqUnit() {
        return paymFreqUnit;
    }
    /**
     * 设置还款间隔单位
     * @param paymFreqUnit
     */
    public void setPaymFreqUnit(String paymFreqUnit) {
        this.paymFreqUnit = paymFreqUnit;
    }
    /**
     * 获取还款间隔
     * @return
     */
    public Short getPaymFreqFreq() {
        return paymFreqFreq;
    }
    /**
     * 设置还款间隔
     * @param paymFreqFreq
     */
    public void setPaymFreqFreq(Short paymFreqFreq) {
        this.paymFreqFreq = paymFreqFreq;
    }
    /**
     * 获取计算类型
     * @return
     */
    public String getRatBase() {
        return ratBase;
    }
    /**
     * 设置计算类型
     * @param ratBase
     */
    public void setRatBase(String ratBase) {
        this.ratBase = ratBase;
    }

    /**
     * 还款方式交互对象默认构造函数
     *  default constructor
     *  */
    public LmLnShdMtdTrans() {
    }

    /**
     * 还款方式交互对象构造函数
     * full constructor
     * */
    public LmLnShdMtdTrans(Integer termNo,String loanNo,Integer frmPerd,
                           Integer toPerd, String paymTyp,String paymOpt,
                           Double termPrcpAmt,Double pgsPrcpPct, Double pgsPrcpAmt,
                           Integer pgsPrcpFreq,Integer calTotInstm, Double baseRate, Double sprd,
                           Double intAdjPct, String intBase, Double prcpPct, String loanRateMode) {
        this.termNo=termNo;
        this.loanNo=loanNo;
        this.frmPerd = frmPerd;
        this.toPerd = toPerd;
        this.paymTyp = paymTyp;
        this.paymOpt = paymOpt;
        this.termPrcpAmt = termPrcpAmt;
        this.pgsPrcpPct = pgsPrcpPct;
        this.pgsPrcpAmt = pgsPrcpAmt;
        this.pgsPrcpFreq = pgsPrcpFreq;
        this.calTotInstm = calTotInstm;
        this.baseRate = baseRate;
        this.sprd = sprd;
        this.intAdjPct = intAdjPct;
        this.intBase = intBase;
        this.prcpPct = prcpPct;
        this.loanRateMode = loanRateMode;
    }

    // Property accessors
    /**
     * 获取从第几期
     * @return
     */
    public Integer getFrmPerd() {
        return this.frmPerd;
    }
    /**
     * 设置从第几期
     * @param frmPerd
     */
    public void setFrmPerd(Integer frmPerd) {
        this.frmPerd = frmPerd;
    }
    /**
     * 获取到第几期
     * @return
     */
    public Integer getToPerd() {
        return toPerd;
    }
    /**
     * 设置到第几期
     * @param toPerd
     */
    public void setToPerd(Integer toPerd) {
        this.toPerd = toPerd;
    }
    /**
     * 获取还款类型
     * @return
     */
    public String getPaymTyp() {
        return paymTyp;
    }
    /**
     * 设置还款类型
     * @param paymTyp
     */
    public void setPaymTyp(String paymTyp) {
        this.paymTyp = paymTyp;
    }
    /**
     * 获取还款方式
     * @return
     */
    public String getPaymOpt() {
        return paymOpt;
    }
    /**
     * 设置还款方式
     * @param paymOpt
     */
    public void setPaymOpt(String paymOpt) {
        this.paymOpt = paymOpt;
    }
    /**
     * 获取阶段本金额(拟还本金)
     * @return
     */
    public Double getTermPrcpAmt() {
        return this.termPrcpAmt;
    }
    /**
     * 设置阶段本金额(拟还本金)
     * @param termPrcpAmt
     */
    public void setTermPrcpAmt(Double termPrcpAmt) {
        this.termPrcpAmt = termPrcpAmt;
    }
    /**
     * 获取等比递增还款增加额
     * @return
     */
    public Double getPgsPrcpPct() {
        return this.pgsPrcpPct;
    }
    /**
     * 设置等比递增还款增加额
     * @param pgsPrcpPct
     */
    public void setPgsPrcpPct(Double pgsPrcpPct) {
        this.pgsPrcpPct = pgsPrcpPct;
    }
    /**
     * 获取等额递增还款增加额
     * @return
     */
    public Double getPgsPrcpAmt() {
        return this.pgsPrcpAmt;
    }
    /**
     * 设置等额递增还款增加额
     * @param pgsPrcpAmt
     */
    public void setPgsPrcpAmt(Double pgsPrcpAmt) {
        this.pgsPrcpAmt = pgsPrcpAmt;
    }
    /**
     * 获取递增还款周期
     * @return
     */
    public Integer getPgsPrcpFreq() {
        return this.pgsPrcpFreq;
    }
    /**
     * 设置递增还款周期
     * @param pgsPrcpFreq
     */
    public void setPgsPrcpFreq(Integer pgsPrcpFreq) {
        this.pgsPrcpFreq = pgsPrcpFreq;
    }
    /**
     * 获取实际计算期数
     * @return
     */
    public Integer getCalTotInstm() {
        return this.calTotInstm;
    }
    /**
     * 设置实际计算期数
     * @param calTotInstm
     */
    public void setCalTotInstm(Integer calTotInstm) {
        this.calTotInstm = calTotInstm;
    }
    /**
     * 获取阶段号
     * @return
     */
    public Integer getTermNo() {
        return termNo;
    }
    /**
     * 设置阶段号
     * @param termNo
     */
    public void setTermNo(Integer termNo) {
        this.termNo = termNo;
    }
    /**
     * 获取借据号
     * @return
     */
    public String getLoanNo() {
        return loanNo;
    }
    /**
     * 设置借据号
     * @param loanNo
     */
    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }
    /**
     * 两对象比较方法
     */
    public int compare(LmLnShdMtdTrans lsmt1, LmLnShdMtdTrans lsmt2) {

        int termNo1=lsmt1.getTermNo();
        int termNo2=lsmt2.getTermNo();
        if(termNo1<termNo2){
            return -1;
        }else if(termNo1>termNo2){
            return 1;
        }else{
            return 0;
        }
    }
    /**
     * 获取基准利率
     * @return
     */
    public Double getBaseRate() {
        return baseRate;
    }
    /**
     * 设置基准利率
     * @param baseRate
     */
    public void setBaseRate(Double baseRate) {
        this.baseRate = baseRate;
    }
    /**
     * 获取浮动利率
     * @return
     */
    public Double getSprd() {
        return sprd;
    }
    /**
     * 设置浮动利率
     * @param sprd
     */
    public void setSprd(Double sprd) {
        this.sprd = sprd;
    }
    /**
     * 获取利率浮动比例
     * @return
     */
    public Double getIntAdjPct() {
        return intAdjPct;
    }
    /**
     * 设置利率浮动比例
     * @param intAdjPct
     */
    public void setIntAdjPct(Double intAdjPct) {
        this.intAdjPct = intAdjPct;
    }
    /**
     * 获取利息计算基础
     * @return
     */
    public String getIntBase() {
        return intBase;
    }
    /**
     * 设置利息计算基础
     * @param intBase
     */
    public void setIntBase(String intBase) {
        this.intBase = intBase;
    }
    /**
     * 获取本金比例
     * @return
     */
    public Double getPrcpPct() {
        return prcpPct;
    }
    /**
     * 设置本金比例
     */
    public void setPrcpPct(Double prcpPct) {
        this.prcpPct = prcpPct;
    }
    /**
     * 获取利率模式
     * @return
     */
    public String getLoanRateMode() {
        return loanRateMode;
    }
    /**
     * 设置利率模式
     * @param loanRateMode
     */
    public void setLoanRateMode(String loanRateMode) {
        this.loanRateMode = loanRateMode;
    }
    /**
     * 获取贷款执行利率
     * @return
     */
    public Double getLoanIntRate() {
        return loanIntRate;
    }
    /**
     * 设置贷款执行利率
     * @param loanIntRate
     */
    public void setLoanIntRate(Double loanIntRate) {
        this.loanIntRate = loanIntRate;
    }
    /**
     * 获取罚息执行利率
     * @return
     */
    public Double getLoanOdIntRate() {
        return loanOdIntRate;
    }
    /**
     * 设置罚息执行利率
     * @param loanOdIntRate
     */
    public void setLoanOdIntRate(Double loanOdIntRate) {
        this.loanOdIntRate = loanOdIntRate;
    }
}
