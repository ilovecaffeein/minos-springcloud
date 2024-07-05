package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-18 13:55:38
 */
public class LmHoldShdHist implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 流水系列号
	 */
	private Integer seqNo;
	/**
	 * 流水
	 */
	private Long txNo;
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
	 * 剩余本金
	 */
	private BigDecimal psRemPrcp;
	/**
	 * ${column.comments}
	 */
	private BigDecimal setlPrcp;
	/**
	 * 已付利息
	 */
	private BigDecimal setlNormInt;
	/**
	 * 预期 收益率
	 */
	private BigDecimal incPct;
	/**
	 * 收益
	 */
	private BigDecimal incAmt;
	/**
	 * 该期最后是什么时候才结清的
	 */
	private String lastSetlDt;
	/**
	 * Y:已结清N:未结清
	 */
	private String setlInd;

	/**
	 * 设置：流水系列号
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	/**
	 * 获取：流水系列号
	 */
	public Integer getSeqNo() {
		return seqNo;
	}
	/**
	 * 设置：流水
	 */
	public void setTxNo(Long txNo) {
		this.txNo = txNo;
	}
	/**
	 * 获取：流水
	 */
	public Long getTxNo() {
		return txNo;
	}
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
	 * 设置：${column.comments}
	 */
	public void setSetlPrcp(BigDecimal setlPrcp) {
		this.setlPrcp = setlPrcp;
	}
	/**
	 * 获取：${column.comments}
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
	 * 设置：Y:已结清N:未结清
	 */
	public void setSetlInd(String setlInd) {
		this.setlInd = setlInd;
	}
	/**
	 * 获取：Y:已结清N:未结清
	 */
	public String getSetlInd() {
		return setlInd;
	}
}
