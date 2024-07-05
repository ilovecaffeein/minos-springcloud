package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * DE_TRANS_LOG(日终交易日志)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class DeTransLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 交易流水
	 */
	private Integer txLogSeq;
	/**
	 * 机构号
	 */
	private String bchCde;
	/**
	 * 业务日期
	 */
	private String buzDt;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 交易金额
	 */
	private BigDecimal transAmt;
	/**
	 * 交易码
	 */
	private String transCode;

	/**
	 * 设置：交易流水
	 */
	public void setTxLogSeq(Integer txLogSeq) {
		this.txLogSeq = txLogSeq;
	}
	/**
	 * 获取：交易流水
	 */
	public Integer getTxLogSeq() {
		return txLogSeq;
	}
	/**
	 * 设置：机构号
	 */
	public void setBchCde(String bchCde) {
		this.bchCde = bchCde;
	}
	/**
	 * 获取：机构号
	 */
	public String getBchCde() {
		return bchCde;
	}
	/**
	 * 设置：业务日期
	 */
	public void setBuzDt(String buzDt) {
		this.buzDt = buzDt;
	}
	/**
	 * 获取：业务日期
	 */
	public String getBuzDt() {
		return buzDt;
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
	 * 设置：交易金额
	 */
	public void setTransAmt(BigDecimal transAmt) {
		this.transAmt = transAmt;
	}
	/**
	 * 获取：交易金额
	 */
	public BigDecimal getTransAmt() {
		return transAmt;
	}
	/**
	 * 设置：交易码
	 */
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}
	/**
	 * 获取：交易码
	 */
	public String getTransCode() {
		return transCode;
	}
}
