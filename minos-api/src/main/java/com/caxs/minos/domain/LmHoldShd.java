package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * LM_HOLD_SHD(出资人收益计划表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmHoldShd implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 客户编号
	 */
	private String custId;
	/**
	 * 期号
	 */
	private Integer psPerdNo;
	/**
	 * 当期应该在哪一天归还
	 */
	private String psDueDt;
	/**
	 * 期供金额
	 */
	private BigDecimal psInstmAmt;
	/**
	 * 本金
	 */
	private BigDecimal psPrcpAmt;
	/**
	 * 正常利息
	 */
	private BigDecimal psNormIntAmt;
	/**
	 * 逾期利息
	 */
	private BigDecimal psOdIntAmt;
	/**
	 * 复利
	 */
	private BigDecimal psCommOdInt;
	/**
	 * 剩余本金
	 */
	private BigDecimal psRemPrcp;
	/**
	 * 已付本金
	 */
	private BigDecimal setlPrcp;
	/**
	 * 已付利息
	 */
	private BigDecimal setlNormInt;
	/**
	 * 已还逾期利息
	 */
	private BigDecimal setlOdIntAmt;
	/**
	 * 已还复利
	 */
	private BigDecimal setlCommOdInt;
	/**
	 * 该期最后是什么时候才结清的
	 */
	private String lastSetlDt;
	/**
	 * Y:已结清
N:未结清
	 */
	private String setlInd;
	/**
	 * 预期 收益率
	 */
	private BigDecimal incPct;
	/**
	 * 收益
	 */
	private BigDecimal incAmt;
	/**
	 * 是否代偿标志
	 */
	private String dcInd;

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
	 * 设置：客户编号
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}
	/**
	 * 获取：客户编号
	 */
	public String getCustId() {
		return custId;
	}
	/**
	 * 设置：期号
	 */
	public void setPsPerdNo(Integer psPerdNo) {
		this.psPerdNo = psPerdNo;
	}
	/**
	 * 获取：期号
	 */
	public Integer getPsPerdNo() {
		return psPerdNo;
	}
	/**
	 * 设置：当期应该在哪一天归还
	 */
	public void setPsDueDt(String psDueDt) {
		this.psDueDt = psDueDt;
	}
	/**
	 * 获取：当期应该在哪一天归还
	 */
	public String getPsDueDt() {
		return psDueDt;
	}
	/**
	 * 设置：期供金额
	 */
	public void setPsInstmAmt(BigDecimal psInstmAmt) {
		this.psInstmAmt = psInstmAmt;
	}
	/**
	 * 获取：期供金额
	 */
	public BigDecimal getPsInstmAmt() {
		return psInstmAmt;
	}
	/**
	 * 设置：本金
	 */
	public void setPsPrcpAmt(BigDecimal psPrcpAmt) {
		this.psPrcpAmt = psPrcpAmt;
	}
	/**
	 * 获取：本金
	 */
	public BigDecimal getPsPrcpAmt() {
		return psPrcpAmt;
	}
	/**
	 * 设置：正常利息
	 */
	public void setPsNormIntAmt(BigDecimal psNormIntAmt) {
		this.psNormIntAmt = psNormIntAmt;
	}
	/**
	 * 获取：正常利息
	 */
	public BigDecimal getPsNormIntAmt() {
		return psNormIntAmt;
	}
	/**
	 * 设置：逾期利息
	 */
	public void setPsOdIntAmt(BigDecimal psOdIntAmt) {
		this.psOdIntAmt = psOdIntAmt;
	}
	/**
	 * 获取：逾期利息
	 */
	public BigDecimal getPsOdIntAmt() {
		return psOdIntAmt;
	}
	/**
	 * 设置：复利
	 */
	public void setPsCommOdInt(BigDecimal psCommOdInt) {
		this.psCommOdInt = psCommOdInt;
	}
	/**
	 * 获取：复利
	 */
	public BigDecimal getPsCommOdInt() {
		return psCommOdInt;
	}
	/**
	 * 设置：剩余本金
	 */
	public void setPsRemPrcp(BigDecimal psRemPrcp) {
		this.psRemPrcp = psRemPrcp;
	}
	/**
	 * 获取：剩余本金
	 */
	public BigDecimal getPsRemPrcp() {
		return psRemPrcp;
	}
	/**
	 * 设置：已付本金
	 */
	public void setSetlPrcp(BigDecimal setlPrcp) {
		this.setlPrcp = setlPrcp;
	}
	/**
	 * 获取：已付本金
	 */
	public BigDecimal getSetlPrcp() {
		return setlPrcp;
	}
	/**
	 * 设置：已付利息
	 */
	public void setSetlNormInt(BigDecimal setlNormInt) {
		this.setlNormInt = setlNormInt;
	}
	/**
	 * 获取：已付利息
	 */
	public BigDecimal getSetlNormInt() {
		return setlNormInt;
	}
	/**
	 * 设置：已还逾期利息
	 */
	public void setSetlOdIntAmt(BigDecimal setlOdIntAmt) {
		this.setlOdIntAmt = setlOdIntAmt;
	}
	/**
	 * 获取：已还逾期利息
	 */
	public BigDecimal getSetlOdIntAmt() {
		return setlOdIntAmt;
	}
	/**
	 * 设置：已还复利
	 */
	public void setSetlCommOdInt(BigDecimal setlCommOdInt) {
		this.setlCommOdInt = setlCommOdInt;
	}
	/**
	 * 获取：已还复利
	 */
	public BigDecimal getSetlCommOdInt() {
		return setlCommOdInt;
	}
	/**
	 * 设置：该期最后是什么时候才结清的
	 */
	public void setLastSetlDt(String lastSetlDt) {
		this.lastSetlDt = lastSetlDt;
	}
	/**
	 * 获取：该期最后是什么时候才结清的
	 */
	public String getLastSetlDt() {
		return lastSetlDt;
	}
	/**
	 * 设置：Y:已结清
N:未结清
	 */
	public void setSetlInd(String setlInd) {
		this.setlInd = setlInd;
	}
	/**
	 * 获取：Y:已结清
N:未结清
	 */
	public String getSetlInd() {
		return setlInd;
	}
	/**
	 * 设置：预期 收益率
	 */
	public void setIncPct(BigDecimal incPct) {
		this.incPct = incPct;
	}
	/**
	 * 获取：预期 收益率
	 */
	public BigDecimal getIncPct() {
		return incPct;
	}
	/**
	 * 设置：收益
	 */
	public void setIncAmt(BigDecimal incAmt) {
		this.incAmt = incAmt;
	}
	/**
	 * 获取：收益
	 */
	public BigDecimal getIncAmt() {
		return incAmt;
	}
	/**
	 * 设置：是否代偿标志
	 */
	public void setDcInd(String dcInd) {
		this.dcInd = dcInd;
	}
	/**
	 * 获取：是否代偿标志
	 */
	public String getDcInd() {
		return dcInd;
	}

	public LmHoldShd() {
	}

	public LmHoldShd(String loanNo, String custId,Integer psPerdNo ) {
		this.loanNo  = loanNo;
		this.custId  = custId;
		this.psPerdNo = psPerdNo;
	}
}
