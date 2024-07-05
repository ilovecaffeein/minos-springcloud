package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmFundInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ${column.comments}
	 */
	private String loanNo;
	/**
	 * ${column.comments}
	 */
	private String fundTyp;
	/**
	 * ${column.comments}
	 */
	private String fundChgDt;
	/**
	 * ${column.comments}
	 */
	private BigDecimal holdAmt;

	/**
	 * 设置：${column.comments}
	 */
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getLoanNo() {
		return loanNo;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setFundTyp(String fundTyp) {
		this.fundTyp = fundTyp;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getFundTyp() {
		return fundTyp;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setFundChgDt(String fundChgDt) {
		this.fundChgDt = fundChgDt;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getFundChgDt() {
		return fundChgDt;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setHoldAmt(BigDecimal holdAmt) {
		this.holdAmt = holdAmt;
	}
	/**
	 * 获取：${column.comments}
	 */
	public BigDecimal getHoldAmt() {
		return holdAmt;
	}

	/**
	 */
	public LmFundInfo() {
	}
	/**
	 */
	public LmFundInfo (String loanNo) {
		this.loanNo = loanNo;
	}
	/**
	 */
	public LmFundInfo (String loanNo,String fundTyp ,String  fundChgDt) {
		this.loanNo = loanNo;
		this.fundTyp = fundTyp;
		this.fundChgDt = fundChgDt;
	}
}
