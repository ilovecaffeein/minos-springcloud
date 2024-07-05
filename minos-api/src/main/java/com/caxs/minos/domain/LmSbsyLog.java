package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * LM_GLNO_LOG(贴息贷款流水表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmSbsyLog implements Serializable {
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
	 * 机构代码
	 */
	private String bankCde;
	/**
	 * 机构号
	 */
	private String bchCde;
	/**
	 * 客户编号
	 */
	private String sbsyCustId;
	/**
	 * 客户名称
	 */
	private String sbsyCustName;
	/**
	 * 合同号
	 */
	private String loanContNo;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 开户行行号
	 */
	private String sbsyAcctBankCde;
	/**
	 * 开户行名称
	 */
	private String sbsyAcctBankName;
	/**
	 * 贴息放开账户
	 */
	private String sbsyAcctNo;
	/**
	 * 贴息放款户名
	 */
	private String sbsyAcctName;
	/**
	 * 贴息利率
	 */
	private BigDecimal sbsyIntRate;
	/**
	 * 贴息金额
	 */
	private BigDecimal sbsyAmt;
	/**
	 * 贴息处理标志 R：发送成功，S：处理成功，F：处理失败，N：未处理
	 */
	private String sbsyFlag;
	/**
	 * 申请用户
	 */
	private String appUserName;
	/**
	 * 申请用户编号
	 */
	private String appUserId;
	/**
	 * 申请用户机构号
	 */
	private String appUserOrgNo;
	/**
	 * 贴息清算状态：Y:线上放开，N：线下放款
	 */
	private String sbsyOlInd;
	/**
	 * 备注：保留扣款授权编号提供守护进程使用
	 */
	private String memo;
	/**
	 * 信托编号
	 */
	private String sbsyTrstplnNo;
	/**
	 * 信托计划名称
	 */
	private String sbsyTrstplnName;

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
	 * 设置：机构代码
	 */
	public void setBankCde(String bankCde) {
		this.bankCde = bankCde;
	}
	/**
	 * 获取：机构代码
	 */
	public String getBankCde() {
		return bankCde;
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
	 * 设置：客户编号
	 */
	public void setSbsyCustId(String sbsyCustId) {
		this.sbsyCustId = sbsyCustId;
	}
	/**
	 * 获取：客户编号
	 */
	public String getSbsyCustId() {
		return sbsyCustId;
	}
	/**
	 * 设置：客户名称
	 */
	public void setSbsyCustName(String sbsyCustName) {
		this.sbsyCustName = sbsyCustName;
	}
	/**
	 * 获取：客户名称
	 */
	public String getSbsyCustName() {
		return sbsyCustName;
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
	 * 设置：开户行行号
	 */
	public void setSbsyAcctBankCde(String sbsyAcctBankCde) {
		this.sbsyAcctBankCde = sbsyAcctBankCde;
	}
	/**
	 * 获取：开户行行号
	 */
	public String getSbsyAcctBankCde() {
		return sbsyAcctBankCde;
	}
	/**
	 * 设置：开户行名称
	 */
	public void setSbsyAcctBankName(String sbsyAcctBankName) {
		this.sbsyAcctBankName = sbsyAcctBankName;
	}
	/**
	 * 获取：开户行名称
	 */
	public String getSbsyAcctBankName() {
		return sbsyAcctBankName;
	}
	/**
	 * 设置：贴息放开账户
	 */
	public void setSbsyAcctNo(String sbsyAcctNo) {
		this.sbsyAcctNo = sbsyAcctNo;
	}
	/**
	 * 获取：贴息放开账户
	 */
	public String getSbsyAcctNo() {
		return sbsyAcctNo;
	}
	/**
	 * 设置：贴息放款户名
	 */
	public void setSbsyAcctName(String sbsyAcctName) {
		this.sbsyAcctName = sbsyAcctName;
	}
	/**
	 * 获取：贴息放款户名
	 */
	public String getSbsyAcctName() {
		return sbsyAcctName;
	}
	/**
	 * 设置：贴息利率
	 */
	public void setSbsyIntRate(BigDecimal sbsyIntRate) {
		this.sbsyIntRate = sbsyIntRate;
	}
	/**
	 * 获取：贴息利率
	 */
	public BigDecimal getSbsyIntRate() {
		return sbsyIntRate;
	}
	/**
	 * 设置：贴息金额
	 */
	public void setSbsyAmt(BigDecimal sbsyAmt) {
		this.sbsyAmt = sbsyAmt;
	}
	/**
	 * 获取：贴息金额
	 */
	public BigDecimal getSbsyAmt() {
		return sbsyAmt;
	}
	/**
	 * 设置：贴息处理标志 R：发送成功，S：处理成功，F：处理失败，N：未处理
	 */
	public void setSbsyFlag(String sbsyFlag) {
		this.sbsyFlag = sbsyFlag;
	}
	/**
	 * 获取：贴息处理标志 R：发送成功，S：处理成功，F：处理失败，N：未处理
	 */
	public String getSbsyFlag() {
		return sbsyFlag;
	}
	/**
	 * 设置：申请用户
	 */
	public void setAppUserName(String appUserName) {
		this.appUserName = appUserName;
	}
	/**
	 * 获取：申请用户
	 */
	public String getAppUserName() {
		return appUserName;
	}
	/**
	 * 设置：申请用户编号
	 */
	public void setAppUserId(String appUserId) {
		this.appUserId = appUserId;
	}
	/**
	 * 获取：申请用户编号
	 */
	public String getAppUserId() {
		return appUserId;
	}
	/**
	 * 设置：申请用户机构号
	 */
	public void setAppUserOrgNo(String appUserOrgNo) {
		this.appUserOrgNo = appUserOrgNo;
	}
	/**
	 * 获取：申请用户机构号
	 */
	public String getAppUserOrgNo() {
		return appUserOrgNo;
	}
	/**
	 * 设置：贴息清算状态：Y:线上放开，N：线下放款
	 */
	public void setSbsyOlInd(String sbsyOlInd) {
		this.sbsyOlInd = sbsyOlInd;
	}
	/**
	 * 获取：贴息清算状态：Y:线上放开，N：线下放款
	 */
	public String getSbsyOlInd() {
		return sbsyOlInd;
	}
	/**
	 * 设置：备注：保留扣款授权编号提供守护进程使用
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 获取：备注：保留扣款授权编号提供守护进程使用
	 */
	public String getMemo() {
		return memo;
	}
	/**
	 * 设置：信托编号
	 */
	public void setSbsyTrstplnNo(String sbsyTrstplnNo) {
		this.sbsyTrstplnNo = sbsyTrstplnNo;
	}
	/**
	 * 获取：信托编号
	 */
	public String getSbsyTrstplnNo() {
		return sbsyTrstplnNo;
	}
	/**
	 * 设置：信托计划名称
	 */
	public void setSbsyTrstplnName(String sbsyTrstplnName) {
		this.sbsyTrstplnName = sbsyTrstplnName;
	}
	/**
	 * 获取：信托计划名称
	 */
	public String getSbsyTrstplnName() {
		return sbsyTrstplnName;
	}

	/**
	 * 获取：信托计划名称
	 */
	public LmSbsyLog() {
	}
	/**
	 * 获取：信托计划名称
	 */
	public LmSbsyLog(String loanContNo) {
		this.loanContNo = loanContNo;
	}

}
