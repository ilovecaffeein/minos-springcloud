package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * LM_GLNO_LOG(融资贷款流水表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmFinanMarLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 签约授权号
	 */
	private String genGlNo;
	/**
	 * 创建日期
	 */
	private String crtDate;
	/**
	 * 交易码
	 */
	private String txCode;
	/**
	 * 客户编号
	 */
	private String marCustId;
	/**
	 * 客户名称
	 */
	private String marCustName;
	/**
	 * 合同号
	 */
	private String loanContNo;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 收款开户行行号
	 */
	private String marAcctBankCde;
	/**
	 * 收款开户行名称
	 */
	private String marAcctBankName;
	/**
	 * 收款账户类型
	 */
	private String marAcctType;
	/**
	 * 收款户名
	 */
	private String marAcctName;
	/**
	 * 收款账户
	 */
	private String marAcctNo;
	/**
	 * 收款金额
	 */
	private BigDecimal marTxAmt;
	/**
	 * 处理标志 R：发送成功，S：处理成功，F：处理失败，N：未处理
	 */
	private String marFlag;
	/**
	 * 清算状态：Y:线上放开，N：线下放款
	 */
	private String marOlInd;
	/**
	 * 核心交易流水
	 */
	private String lttssq;
	/**
	 * 备注
	 */
	private String memo;

	/**
	 * 设置：签约授权号
	 */
	public void setGenGlNo(String genGlNo) {
		this.genGlNo = genGlNo;
	}
	/**
	 * 获取：签约授权号
	 */
	public String getGenGlNo() {
		return genGlNo;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}
	/**
	 * 获取：创建日期
	 */
	public String getCrtDate() {
		return crtDate;
	}
	/**
	 * 设置：交易码
	 */
	public void setTxCode(String txCode) {
		this.txCode = txCode;
	}
	/**
	 * 获取：交易码
	 */
	public String getTxCode() {
		return txCode;
	}
	/**
	 * 设置：客户编号
	 */
	public void setMarCustId(String marCustId) {
		this.marCustId = marCustId;
	}
	/**
	 * 获取：客户编号
	 */
	public String getMarCustId() {
		return marCustId;
	}
	/**
	 * 设置：客户名称
	 */
	public void setMarCustName(String marCustName) {
		this.marCustName = marCustName;
	}
	/**
	 * 获取：客户名称
	 */
	public String getMarCustName() {
		return marCustName;
	}
	/**
	 * 设置：合同号
	 */
	public void setLoanContNo(String loanContNo) {
		this.loanContNo = loanContNo;
	}
	/**
	 * 获取：合同号
	 */
	public String getLoanContNo() {
		return loanContNo;
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
	 * 设置：收款开户行行号
	 */
	public void setMarAcctBankCde(String marAcctBankCde) {
		this.marAcctBankCde = marAcctBankCde;
	}
	/**
	 * 获取：收款开户行行号
	 */
	public String getMarAcctBankCde() {
		return marAcctBankCde;
	}
	/**
	 * 设置：收款开户行名称
	 */
	public void setMarAcctBankName(String marAcctBankName) {
		this.marAcctBankName = marAcctBankName;
	}
	/**
	 * 获取：收款开户行名称
	 */
	public String getMarAcctBankName() {
		return marAcctBankName;
	}
	/**
	 * 设置：收款账户类型
	 */
	public void setMarAcctType(String marAcctType) {
		this.marAcctType = marAcctType;
	}
	/**
	 * 获取：收款账户类型
	 */
	public String getMarAcctType() {
		return marAcctType;
	}
	/**
	 * 设置：收款户名
	 */
	public void setMarAcctName(String marAcctName) {
		this.marAcctName = marAcctName;
	}
	/**
	 * 获取：收款户名
	 */
	public String getMarAcctName() {
		return marAcctName;
	}
	/**
	 * 设置：收款账户
	 */
	public void setMarAcctNo(String marAcctNo) {
		this.marAcctNo = marAcctNo;
	}
	/**
	 * 获取：收款账户
	 */
	public String getMarAcctNo() {
		return marAcctNo;
	}
	/**
	 * 设置：收款金额
	 */
	public void setMarTxAmt(BigDecimal marTxAmt) {
		this.marTxAmt = marTxAmt;
	}
	/**
	 * 获取：收款金额
	 */
	public BigDecimal getMarTxAmt() {
		return marTxAmt;
	}
	/**
	 * 设置：处理标志 R：发送成功，S：处理成功，F：处理失败，N：未处理
	 */
	public void setMarFlag(String marFlag) {
		this.marFlag = marFlag;
	}
	/**
	 * 获取：处理标志 R：发送成功，S：处理成功，F：处理失败，N：未处理
	 */
	public String getMarFlag() {
		return marFlag;
	}
	/**
	 * 设置：清算状态：Y:线上放开，N：线下放款
	 */
	public void setMarOlInd(String marOlInd) {
		this.marOlInd = marOlInd;
	}
	/**
	 * 获取：清算状态：Y:线上放开，N：线下放款
	 */
	public String getMarOlInd() {
		return marOlInd;
	}
	/**
	 * 设置：核心交易流水
	 */
	public void setLttssq(String lttssq) {
		this.lttssq = lttssq;
	}
	/**
	 * 获取：核心交易流水
	 */
	public String getLttssq() {
		return lttssq;
	}
	/**
	 * 设置：备注
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 获取：备注
	 */
	public String getMemo() {
		return memo;
	}
}
