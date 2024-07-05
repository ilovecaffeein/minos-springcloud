package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 存储还款账号，包括户名、证件类型、证件号等等信息。

 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmAcctInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 还款帐号银行代码
	 */
	private String acctBankCde;
	/**
	 * 还款帐号机构代码
	 */
	private String acctBchCde;
	/**
	 * 系统账户类型
	 */
	private String loanAcctTyp;
	/**
	 * 还款账号:对应核心内部账号,批处理交易时使用
	 */
	private String acctNo;
	/**
	 * 户名
	 */
	private String acctName;
	/**
	 * 生效日期
	 */
	private String acctValDt;
	/**
	 * 创建日期
	 */
	private String acctCreateDt;
	/**
	 * 有效日期
	 */
	private String acctExpiryDt;
	/**
	 * 备注
	 */
	private String acctRmk;
	/**
	 * 自动扣款状态
	 */
	private String atpySts;
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
	private Integer acctPriNo;
	/**
	 * 代偿标记
	 */
	private String acctCompstInd;
	/**
	 * 合同号
	 */
	private String contrNo;
	/**
	 * 原保证金金额
	 */
	private BigDecimal issueAmt;
	/**
	 * 是否本行
	 */
	private String accountSelf;
	/**
	 * 银行地址
	 */
	private String acctBankAdd;
	/**
	 * 银行名称
	 */
	private String acctBankNam;
	/**
	 * 保证金余额
	 */
	private BigDecimal actvAmt;
	/**
	 * 保证金比例
	 */
	private BigDecimal actvAmtPct;
	/**
	 * 最后更新用户
	 */
	private String lastChgUsr;
	/**
	 * 最后更新日期
	 */
	private String lastChgDt;
	/**
	 * 委托人出资比例
	 */
	private BigDecimal fundRatio;
	/**
	 * ${column.comments}
	 */
	private BigDecimal fundAmt;
	/**
	 * 预留手机号
	 */
	private String bindMobile;

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
	 * 设置：还款帐号银行代码
	 */
	public void setAcctBankCde(String acctBankCde) {
		this.acctBankCde = acctBankCde;
	}
	/**
	 * 获取：还款帐号银行代码
	 */
	public String getAcctBankCde() {
		return acctBankCde;
	}
	/**
	 * 设置：还款帐号机构代码
	 */
	public void setAcctBchCde(String acctBchCde) {
		this.acctBchCde = acctBchCde;
	}
	/**
	 * 获取：还款帐号机构代码
	 */
	public String getAcctBchCde() {
		return acctBchCde;
	}
	/**
	 * 设置：系统账户类型
	 */
	public void setLoanAcctTyp(String loanAcctTyp) {
		this.loanAcctTyp = loanAcctTyp;
	}
	/**
	 * 获取：系统账户类型
	 */
	public String getLoanAcctTyp() {
		return loanAcctTyp;
	}
	/**
	 * 设置：还款账号:对应核心内部账号,批处理交易时使用
	 */
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	/**
	 * 获取：还款账号:对应核心内部账号,批处理交易时使用
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
	 * 设置：生效日期
	 */
	public void setAcctValDt(String acctValDt) {
		this.acctValDt = acctValDt;
	}
	/**
	 * 获取：生效日期
	 */
	public String getAcctValDt() {
		return acctValDt;
	}
	/**
	 * 设置：创建日期
	 */
	public void setAcctCreateDt(String acctCreateDt) {
		this.acctCreateDt = acctCreateDt;
	}
	/**
	 * 获取：创建日期
	 */
	public String getAcctCreateDt() {
		return acctCreateDt;
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
	 * 设置：自动扣款状态
	 */
	public void setAtpySts(String atpySts) {
		this.atpySts = atpySts;
	}
	/**
	 * 获取：自动扣款状态
	 */
	public String getAtpySts() {
		return atpySts;
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
	public void setAcctPriNo(Integer acctPriNo) {
		this.acctPriNo = acctPriNo;
	}
	/**
	 * 获取：优先级别
	 */
	public Integer getAcctPriNo() {
		return acctPriNo;
	}
	/**
	 * 设置：代偿标记
	 */
	public void setAcctCompstInd(String acctCompstInd) {
		this.acctCompstInd = acctCompstInd;
	}
	/**
	 * 获取：代偿标记
	 */
	public String getAcctCompstInd() {
		return acctCompstInd;
	}
	/**
	 * 设置：合同号
	 */
	public void setContrNo(String contrNo) {
		this.contrNo = contrNo;
	}
	/**
	 * 获取：合同号
	 */
	public String getContrNo() {
		return contrNo;
	}
	/**
	 * 设置：原保证金金额
	 */
	public void setIssueAmt(BigDecimal issueAmt) {
		this.issueAmt = issueAmt;
	}
	/**
	 * 获取：原保证金金额
	 */
	public BigDecimal getIssueAmt() {
		return issueAmt;
	}
	/**
	 * 设置：是否本行
	 */
	public void setAccountSelf(String accountSelf) {
		this.accountSelf = accountSelf;
	}
	/**
	 * 获取：是否本行
	 */
	public String getAccountSelf() {
		return accountSelf;
	}
	/**
	 * 设置：银行地址
	 */
	public void setAcctBankAdd(String acctBankAdd) {
		this.acctBankAdd = acctBankAdd;
	}
	/**
	 * 获取：银行地址
	 */
	public String getAcctBankAdd() {
		return acctBankAdd;
	}
	/**
	 * 设置：银行名称
	 */
	public void setAcctBankNam(String acctBankNam) {
		this.acctBankNam = acctBankNam;
	}
	/**
	 * 获取：银行名称
	 */
	public String getAcctBankNam() {
		return acctBankNam;
	}
	/**
	 * 设置：保证金余额
	 */
	public void setActvAmt(BigDecimal actvAmt) {
		this.actvAmt = actvAmt;
	}
	/**
	 * 获取：保证金余额
	 */
	public BigDecimal getActvAmt() {
		return actvAmt;
	}
	/**
	 * 设置：保证金比例
	 */
	public void setActvAmtPct(BigDecimal actvAmtPct) {
		this.actvAmtPct = actvAmtPct;
	}
	/**
	 * 获取：保证金比例
	 */
	public BigDecimal getActvAmtPct() {
		return actvAmtPct;
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
	 * 设置：委托人出资比例
	 */
	public void setFundRatio(BigDecimal fundRatio) {
		this.fundRatio = fundRatio;
	}
	/**
	 * 获取：委托人出资比例
	 */
	public BigDecimal getFundRatio() {
		return fundRatio;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setFundAmt(BigDecimal fundAmt) {
		this.fundAmt = fundAmt;
	}
	/**
	 * 获取：${column.comments}
	 */
	public BigDecimal getFundAmt() {
		return fundAmt;
	}
	/**
	 * 设置：预留手机号
	 */
	public void setBindMobile(String bindMobile) {
		this.bindMobile = bindMobile;
	}
	/**
	 * 获取：预留手机号
	 */
	public String getBindMobile() {
		return bindMobile;
	}

	public LmAcctInfo() {

	}

	public LmAcctInfo(String loanNo ,String loanAcctTyp ) {
		this.loanAcctTyp = loanAcctTyp;
		this.loanNo = loanNo;
	}
}
