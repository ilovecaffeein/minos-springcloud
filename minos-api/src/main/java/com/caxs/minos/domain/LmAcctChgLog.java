package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 保存还款账号变更情况
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-10-13 16:11:35
 */
public class LmAcctChgLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 交易流水
	 */
	private String txLogSeq;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 原还款帐号银行代码
	 */
	private String oldAcctBankCde;
	/**
	 * 原还款帐号机构代码
	 */
	private String oldAcctBchCde;
	/**
	 * 原还款账号
	 */
	private String oldAcctNo;
	/**
	 * 变更后还款帐号银行代码
	 */
	private String acctBankCde;
	/**
	 * 变更后还款帐号机构代码
	 */
	private String acctBchCde;
	/**
	 * 新还款账号
	 */
	private String acctNo;
	/**
	 * 户名
	 */
	private String acctName;
	/**
	 * 有效日期
	 */
	private String acctExpiryDt;
	/**
	 * 备注
	 */
	private String acctRmk;
	/**
	 * 还款卡号
	 */
	private String acctCardNo;
	/**
	 * 钞汇标志
	 */
	private String acctNttInd;
	/**
	 * 账户类型
	 */
	private String acctTyp;
	/**
	 * 账户代码
	 */
	private String acctCde;
	/**
	 * 账户币种
	 */
	private String acctCcyCde;
	/**
	 * 证件类型
	 */
	private String acctIdType;
	/**
	 * 证件号码
	 */
	private String acctIdNo;
	/**
	 * 发证国家
	 */
	private String acctIssCtry;
	/**
	 * 账号科目代码
	 */
	private String acctLdgrCde;
	/**
	 * 优先级别
	 */
	private BigDecimal acctPriNo;
	/**
	 * 最后更新用户
	 */
	private String lastChgUsr;
	/**
	 * 最后更新日期
	 */
	private String lastChgDt;
	/**
	 * ${column.comments}
	 */
	private String bindMobile;

	/**
	 * 设置：交易流水
	 */
	public void setTxLogSeq(String txLogSeq) {
		this.txLogSeq = txLogSeq;
	}
	/**
	 * 获取：交易流水
	 */
	public String getTxLogSeq() {
		return txLogSeq;
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
	 * 设置：原还款帐号银行代码
	 */
	public void setOldAcctBankCde(String oldAcctBankCde) {
		this.oldAcctBankCde = oldAcctBankCde;
	}
	/**
	 * 获取：原还款帐号银行代码
	 */
	public String getOldAcctBankCde() {
		return oldAcctBankCde;
	}
	/**
	 * 设置：原还款帐号机构代码
	 */
	public void setOldAcctBchCde(String oldAcctBchCde) {
		this.oldAcctBchCde = oldAcctBchCde;
	}
	/**
	 * 获取：原还款帐号机构代码
	 */
	public String getOldAcctBchCde() {
		return oldAcctBchCde;
	}
	/**
	 * 设置：原还款账号
	 */
	public void setOldAcctNo(String oldAcctNo) {
		this.oldAcctNo = oldAcctNo;
	}
	/**
	 * 获取：原还款账号
	 */
	public String getOldAcctNo() {
		return oldAcctNo;
	}
	/**
	 * 设置：变更后还款帐号银行代码
	 */
	public void setAcctBankCde(String acctBankCde) {
		this.acctBankCde = acctBankCde;
	}
	/**
	 * 获取：变更后还款帐号银行代码
	 */
	public String getAcctBankCde() {
		return acctBankCde;
	}
	/**
	 * 设置：变更后还款帐号机构代码
	 */
	public void setAcctBchCde(String acctBchCde) {
		this.acctBchCde = acctBchCde;
	}
	/**
	 * 获取：变更后还款帐号机构代码
	 */
	public String getAcctBchCde() {
		return acctBchCde;
	}
	/**
	 * 设置：新还款账号
	 */
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	/**
	 * 获取：新还款账号
	 */
	public String getAcctNo() {
		return acctNo;
	}
	/**
	 * 设置：户名
	 */
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	/**
	 * 获取：户名
	 */
	public String getAcctName() {
		return acctName;
	}
	/**
	 * 设置：有效日期
	 */
	public void setAcctExpiryDt(String acctExpiryDt) {
		this.acctExpiryDt = acctExpiryDt;
	}
	/**
	 * 获取：有效日期
	 */
	public String getAcctExpiryDt() {
		return acctExpiryDt;
	}
	/**
	 * 设置：备注
	 */
	public void setAcctRmk(String acctRmk) {
		this.acctRmk = acctRmk;
	}
	/**
	 * 获取：备注
	 */
	public String getAcctRmk() {
		return acctRmk;
	}
	/**
	 * 设置：还款卡号
	 */
	public void setAcctCardNo(String acctCardNo) {
		this.acctCardNo = acctCardNo;
	}
	/**
	 * 获取：还款卡号
	 */
	public String getAcctCardNo() {
		return acctCardNo;
	}
	/**
	 * 设置：钞汇标志
	 */
	public void setAcctNttInd(String acctNttInd) {
		this.acctNttInd = acctNttInd;
	}
	/**
	 * 获取：钞汇标志
	 */
	public String getAcctNttInd() {
		return acctNttInd;
	}
	/**
	 * 设置：账户类型
	 */
	public void setAcctTyp(String acctTyp) {
		this.acctTyp = acctTyp;
	}
	/**
	 * 获取：账户类型
	 */
	public String getAcctTyp() {
		return acctTyp;
	}
	/**
	 * 设置：账户代码
	 */
	public void setAcctCde(String acctCde) {
		this.acctCde = acctCde;
	}
	/**
	 * 获取：账户代码
	 */
	public String getAcctCde() {
		return acctCde;
	}
	/**
	 * 设置：账户币种
	 */
	public void setAcctCcyCde(String acctCcyCde) {
		this.acctCcyCde = acctCcyCde;
	}
	/**
	 * 获取：账户币种
	 */
	public String getAcctCcyCde() {
		return acctCcyCde;
	}
	/**
	 * 设置：证件类型
	 */
	public void setAcctIdType(String acctIdType) {
		this.acctIdType = acctIdType;
	}
	/**
	 * 获取：证件类型
	 */
	public String getAcctIdType() {
		return acctIdType;
	}
	/**
	 * 设置：证件号码
	 */
	public void setAcctIdNo(String acctIdNo) {
		this.acctIdNo = acctIdNo;
	}
	/**
	 * 获取：证件号码
	 */
	public String getAcctIdNo() {
		return acctIdNo;
	}
	/**
	 * 设置：发证国家
	 */
	public void setAcctIssCtry(String acctIssCtry) {
		this.acctIssCtry = acctIssCtry;
	}
	/**
	 * 获取：发证国家
	 */
	public String getAcctIssCtry() {
		return acctIssCtry;
	}
	/**
	 * 设置：账号科目代码
	 */
	public void setAcctLdgrCde(String acctLdgrCde) {
		this.acctLdgrCde = acctLdgrCde;
	}
	/**
	 * 获取：账号科目代码
	 */
	public String getAcctLdgrCde() {
		return acctLdgrCde;
	}
	/**
	 * 设置：优先级别
	 */
	public void setAcctPriNo(BigDecimal acctPriNo) {
		this.acctPriNo = acctPriNo;
	}
	/**
	 * 获取：优先级别
	 */
	public BigDecimal getAcctPriNo() {
		return acctPriNo;
	}
	/**
	 * 设置：最后更新用户
	 */
	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr;
	}
	/**
	 * 获取：最后更新用户
	 */
	public String getLastChgUsr() {
		return lastChgUsr;
	}
	/**
	 * 设置：最后更新日期
	 */
	public void setLastChgDt(String lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	/**
	 * 获取：最后更新日期
	 */
	public String getLastChgDt() {
		return lastChgDt;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setBindMobile(String bindMobile) {
		this.bindMobile = bindMobile;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getBindMobile() {
		return bindMobile;
	}
}
