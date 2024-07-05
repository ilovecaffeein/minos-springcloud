package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 07.LM_LN_SHD_MTD(还款方式表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmLnShdMtd implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 阶段号
	 */
	private Integer termNo;
	/**
	 * 该阶段本金
	 */
	private BigDecimal prcpAmt;
	/**
	 * 起息日
	 */
	private String intStartDt;
	/**
	 * 利率模式
	 */
	private String loanRateMode;
	/**
	 * 还款间隔单位
	 */
	private String paymFreqUnit;
	/**
	 * 还款间隔
	 */
	private Integer paymFreqFreq;
	/**
	 * 从第几期
	 */
	private Integer frmPerd;
	/**
	 * 到第几期
	 */
	private Integer toPerd;
	/**
	 * 利率代码
	 */
	private String rateTyp;
	/**
	 * 基准利率
	 */
	private BigDecimal baseRate;
	/**
	 * 浮动利率
	 */
	private BigDecimal sprd;
	/**
	 * 贷款执行利率
	 */
	private BigDecimal loanIntRate;
	/**
	 * 还款类型
	 */
	private String paymTyp;
	/**
	 * 还款方式
	 */
	private String paymOpt;
	/**
	 * 期供金额
	 */
	private BigDecimal instmAmt;
	/**
	 * 固定本金
	 */
	private BigDecimal fxPrcpAmt;
	/**
	 * 利率浮动比例
	 */
	private BigDecimal intAdjPct;
	/**
	 * 阶段本金额(拟还本金)
	 */
	private BigDecimal termPrcpAmt;
	/**
	 * 等比递增还款增加额
	 */
	private BigDecimal pgsPrcpPct;
	/**
	 * 等额递增还款增加额
	 */
	private BigDecimal pgsPrcpAmt;
	/**
	 * 递增还款周期
	 */
	private Integer pgsPrcpFreq;
	/**
	 * 实际计算期数
	 */
	private Integer calTotInstm;
	/**
	 * 本金比例
	 */
	private BigDecimal prcpPct;
	/**
	 * 利息计算基础
	 */
	private String intBase;
	/**
	 * 计算类型
	 */
	private String ratBase;
	/**
	 * 罚息执行利率
	 */
	private BigDecimal loanOdIntRate;


	/**
	 * 设置：借据号
	 */
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	/**
	 * 获取：借据号
	 */
	public String getLoanNo() {
		return loanNo;
	}
	/**
	 * 设置：阶段号
	 */
	public void setTermNo(Integer termNo) {
		this.termNo = termNo;
	}
	/**
	 * 获取：阶段号
	 */
	public Integer getTermNo() {
		return termNo;
	}
	/**
	 * 设置：该阶段本金
	 */
	public void setPrcpAmt(BigDecimal prcpAmt) {
		this.prcpAmt = prcpAmt;
	}
	/**
	 * 获取：该阶段本金
	 */
	public BigDecimal getPrcpAmt() {
		return prcpAmt;
	}
	/**
	 * 设置：起息日
	 */
	public void setIntStartDt(String intStartDt) {
		this.intStartDt = intStartDt;
	}
	/**
	 * 获取：起息日
	 */
	public String getIntStartDt() {
		return intStartDt;
	}
	/**
	 * 设置：利率模式
	 */
	public void setLoanRateMode(String loanRateMode) {
		this.loanRateMode = loanRateMode;
	}
	/**
	 * 获取：利率模式
	 */
	public String getLoanRateMode() {
		return loanRateMode;
	}
	/**
	 * 设置：还款间隔单位
	 */
	public void setPaymFreqUnit(String paymFreqUnit) {
		this.paymFreqUnit = paymFreqUnit;
	}
	/**
	 * 获取：还款间隔单位
	 */
	public String getPaymFreqUnit() {
		return paymFreqUnit;
	}
	/**
	 * 设置：还款间隔
	 */
	public void setPaymFreqFreq(Integer paymFreqFreq) {
		this.paymFreqFreq = paymFreqFreq;
	}
	/**
	 * 获取：还款间隔
	 */
	public Integer getPaymFreqFreq() {
		return paymFreqFreq;
	}
	/**
	 * 设置：从第几期
	 */
	public void setFrmPerd(Integer frmPerd) {
		this.frmPerd = frmPerd;
	}
	/**
	 * 获取：从第几期
	 */
	public Integer getFrmPerd() {
		return frmPerd;
	}
	/**
	 * 设置：到第几期
	 */
	public void setToPerd(Integer toPerd) {
		this.toPerd = toPerd;
	}
	/**
	 * 获取：到第几期
	 */
	public Integer getToPerd() {
		return toPerd;
	}
	/**
	 * 设置：利率代码
	 */
	public void setRateTyp(String rateTyp) {
		this.rateTyp = rateTyp;
	}
	/**
	 * 获取：利率代码
	 */
	public String getRateTyp() {
		return rateTyp;
	}
	/**
	 * 设置：基准利率
	 */
	public void setBaseRate(BigDecimal baseRate) {
		this.baseRate = baseRate;
	}
	/**
	 * 获取：基准利率
	 */
	public BigDecimal getBaseRate() {
		return baseRate;
	}
	/**
	 * 设置：浮动利率
	 */
	public void setSprd(BigDecimal sprd) {
		this.sprd = sprd;
	}
	/**
	 * 获取：浮动利率
	 */
	public BigDecimal getSprd() {
		return sprd;
	}
	/**
	 * 设置：贷款执行利率
	 */
	public void setLoanIntRate(BigDecimal loanIntRate) {
		this.loanIntRate = loanIntRate;
	}
	/**
	 * 获取：贷款执行利率
	 */
	public BigDecimal getLoanIntRate() {
		return loanIntRate;
	}
	/**
	 * 设置：还款类型
	 */
	public void setPaymTyp(String paymTyp) {
		this.paymTyp = paymTyp;
	}
	/**
	 * 获取：还款类型
	 */
	public String getPaymTyp() {
		return paymTyp;
	}
	/**
	 * 设置：还款方式
	 */
	public void setPaymOpt(String paymOpt) {
		this.paymOpt = paymOpt;
	}
	/**
	 * 获取：还款方式
	 */
	public String getPaymOpt() {
		return paymOpt;
	}
	/**
	 * 设置：期供金额
	 */
	public void setInstmAmt(BigDecimal instmAmt) {
		this.instmAmt = instmAmt;
	}
	/**
	 * 获取：期供金额
	 */
	public BigDecimal getInstmAmt() {
		return instmAmt;
	}
	/**
	 * 设置：固定本金
	 */
	public void setFxPrcpAmt(BigDecimal fxPrcpAmt) {
		this.fxPrcpAmt = fxPrcpAmt;
	}
	/**
	 * 获取：固定本金
	 */
	public BigDecimal getFxPrcpAmt() {
		return fxPrcpAmt;
	}
	/**
	 * 设置：利率浮动比例
	 */
	public void setIntAdjPct(BigDecimal intAdjPct) {
		this.intAdjPct = intAdjPct;
	}
	/**
	 * 获取：利率浮动比例
	 */
	public BigDecimal getIntAdjPct() {
		return intAdjPct;
	}
	/**
	 * 设置：阶段本金额(拟还本金)
	 */
	public void setTermPrcpAmt(BigDecimal termPrcpAmt) {
		this.termPrcpAmt = termPrcpAmt;
	}
	/**
	 * 获取：阶段本金额(拟还本金)
	 */
	public BigDecimal getTermPrcpAmt() {
		return termPrcpAmt;
	}
	/**
	 * 设置：等比递增还款增加额
	 */
	public void setPgsPrcpPct(BigDecimal pgsPrcpPct) {
		this.pgsPrcpPct = pgsPrcpPct;
	}
	/**
	 * 获取：等比递增还款增加额
	 */
	public BigDecimal getPgsPrcpPct() {
		return pgsPrcpPct;
	}
	/**
	 * 设置：等额递增还款增加额
	 */
	public void setPgsPrcpAmt(BigDecimal pgsPrcpAmt) {
		this.pgsPrcpAmt = pgsPrcpAmt;
	}
	/**
	 * 获取：等额递增还款增加额
	 */
	public BigDecimal getPgsPrcpAmt() {
		return pgsPrcpAmt;
	}
	/**
	 * 设置：递增还款周期
	 */
	public void setPgsPrcpFreq(Integer pgsPrcpFreq) {
		this.pgsPrcpFreq = pgsPrcpFreq;
	}
	/**
	 * 获取：递增还款周期
	 */
	public Integer getPgsPrcpFreq() {
		return pgsPrcpFreq;
	}
	/**
	 * 设置：实际计算期数
	 */
	public void setCalTotInstm(Integer calTotInstm) {
		this.calTotInstm = calTotInstm;
	}
	/**
	 * 获取：实际计算期数
	 */
	public Integer getCalTotInstm() {
		return calTotInstm;
	}
	/**
	 * 设置：本金比例
	 */
	public void setPrcpPct(BigDecimal prcpPct) {
		this.prcpPct = prcpPct;
	}
	/**
	 * 获取：本金比例
	 */
	public BigDecimal getPrcpPct() {
		return prcpPct;
	}
	/**
	 * 设置：利息计算基础
	 */
	public void setIntBase(String intBase) {
		this.intBase = intBase;
	}
	/**
	 * 获取：利息计算基础
	 */
	public String getIntBase() {
		return intBase;
	}
	/**
	 * 设置：计算类型
	 */
	public void setRatBase(String ratBase) {
		this.ratBase = ratBase;
	}
	/**
	 * 获取：计算类型
	 */
	public String getRatBase() {
		return ratBase;
	}
	/**
	 * 设置：罚息执行利率
	 */
	public void setLoanOdIntRate(BigDecimal loanOdIntRate) {
		this.loanOdIntRate = loanOdIntRate;
	}
	/**
	 * 获取：罚息执行利率
	 */
	public BigDecimal getLoanOdIntRate() {
		return loanOdIntRate;
	}

	public LmLnShdMtd(){};

	public LmLnShdMtd(String loanNo){
		this.loanNo = loanNo;
	}
}
