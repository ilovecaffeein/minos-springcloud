package com.caxs.minos.domain.trans;

import java.io.Serializable;

/**
 * 账户信息和付款信息
 * coffee
 * @author hb
 */
public final class AccountTrans implements Serializable {
	
	/**
	 *是否保证金 
	 */
	private boolean gutrAmt=false;
	
	public boolean isGutrAmt() {
		return gutrAmt;
	}
	public void setGutrAmt(boolean gutrAmt) {
		this.gutrAmt = gutrAmt;
	}

	private boolean isAccountSelf=true;		//本行他行标志
	/**
	 * 账户信息类型
	 */
	private String loanAccountTyp;
	/**
	 * 获取账户信息类型
	 * @return
	 */
	public String getLoanAccountTyp() {
		return loanAccountTyp;
	}
	/**
	 * 设置账户信息类型
	 * @param loanAccountTyp
	 */
	public void setLoanAccountTyp(String loanAccountTyp) {
		this.loanAccountTyp = loanAccountTyp;
	}

	/**
	 *还款帐号银行代码
	 */
	private String bankCde;
	/**
	 * 还款帐号机构代码
	 */
	private String bchCde;

	/**
	 * 银行名称
	 */
	private String bankName;
	/**
	 * 获取银行名称
	 * @return
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * 设置银行名称
	 * @param bankName
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * 还款账号:对应核心内部账号,批处理交易时使用
	 */
	private String acctNo;
	/**
	 * 户名
	 */
	private String acctName;
	/**
	 * 还款卡号
	 */
	private String cardNo;
	/**
	 * 钞汇标志
	 */
	private String nttInd;
	/**
	 * 账户类型:内部户、结算户等
	 */
	private String acctTyp;
	/**
	 * 账户代码,活期等
	 */
	private String acctCde;
	/**
	 * 账户币种
	 */
	private String ccyCde;
	/**
	 * 证件类型
	 */
	private String idType;
	/**
	 * 证件号码
	 */
	private String idNo;
	/**
	 * 发证国家
	 */
	private String issCtry;
	/**
	 * 账号科目代码,如不明确，可不填写
	 */
	private String ldgrCde;
	/**
	 * 账户余额,-1表示无穷大
	 */
	private double accountOsAmt = 99999999999999.99;

	/**
	 * 交易子流水
	 */
	private Short txlogSeqNo;
	
	/**
	 * 委托人出资比例
	 */
	private Double fundRatio;
	
	/**
	 * 获取交易子流水
	 * @return
	 */
	public Short getTxlogSeqNo() {
		return txlogSeqNo;
	}
	/**
	 * 设置设置交易子流水
	 * @param txlogSeqNo
	 */
	public void setTxlogSeqNo(Short txlogSeqNo) {
		this.txlogSeqNo = txlogSeqNo;
	}
	/**
	 * 获取银行编号
	 * @return
	 */
	public String getBankCde() {
		return bankCde;
	}
	/**
	 * 设置银行编号
	 * @param bankCde
	 */
	public void setBankCde(String bankCde) {
		this.bankCde = bankCde;
	}
	/**
	 * 获取机构编码
	 * @return
	 */
	public String getBchCde() {
		return bchCde;
	}
	/**
	 * 设置机构编码
	 * @param bchCde
	 */
	public void setBchCde(String bchCde) {
		this.bchCde = bchCde;
	}
	/**
	 * 获取还款账号信息
	 * @return
	 */
	public String getAcctNo() {
		return acctNo;
	}
	/**
	 * 设置还款账号信息
	 * @param acctNo
	 */
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	/**
	 * 获取户名信息
	 * @return
	 */
	public String getAcctName() {
		return acctName;
	}
	/**
	 * 设置户名信息
	 * @param acctName
	 */
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	/**
	 * 获取卡号
	 * @return
	 */
	public String getCardNo() {
		return cardNo;
	}
	/**
	 * 设置卡号
	 * @param cardNo
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	/**
	 * 获取钞汇标志
	 * @return
	 */
	public String getNttInd() {
		return nttInd;
	}
	/**
	 * 设置钞汇标志
	 * @param nttInd
	 */
	public void setNttInd(String nttInd) {
		this.nttInd = nttInd;
	}
	/**
	 * 获取账户类型
	 * @return
	 */
	public String getAcctTyp() {
		return acctTyp;
	}
	/**
	 * 设置账户类型
	 * @param acctTyp
	 */
	public void setAcctTyp(String acctTyp) {
		this.acctTyp = acctTyp;
	}
	/**
	 * 获取账户代码
	 * @return
	 */
	public String getAcctCde() {
		return acctCde;
	}
	/**
	 * 设置账户代码
	 * @param acctCde
	 */
	public void setAcctCde(String acctCde) {
		this.acctCde = acctCde;
	}
	/**
	 * 获取币种信息
	 * @return
	 */
	public String getCcyCde() {
		return ccyCde;
	}
	/**
	 * 设置币种信息
	 * @param ccyCde
	 */
	public void setCcyCde(String ccyCde) {
		this.ccyCde = ccyCde;
	}
	/**
	 * 获取证件类型
	 * @return
	 */
	public String getIdType() {
		return idType;
	}
	/**
	 * 设置证件类型
	 * @param idType
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}
	/**
	 * 获取证件号码
	 * @return
	 */
	public String getIdNo() {
		return idNo;
	}
	/**
	 * 设置证件号码
	 * @param idNo
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	/**
	 * 获取发证国家
	 * @return
	 */
	public String getIssCtry() {
		return issCtry;
	}
	/**
	 * 设置发证国家
	 * @param issCtry
	 */
	public void setIssCtry(String issCtry) {
		this.issCtry = issCtry;
	}
	/**
	 * 获取账号科目代码
	 * @return
	 */
	public String getLdgrCde() {
		return ldgrCde;
	}
	/**
	 * 设置账号科目代码
	 * @param ldgrCde
	 */
	public void setLdgrCde(String ldgrCde) {
		this.ldgrCde = ldgrCde;
	}
	/**
	 * 获取账户余额
	 * @return
	 */
	public double getAccountOsAmt() {
		return accountOsAmt;
	}
	/**
	 * 设置账户余额
	 * @param accountOsAmt
	 */
	public void setAccountOsAmt(double accountOsAmt) {
		this.accountOsAmt = accountOsAmt;
	}
	
	/**
	 * 获取本行他行标志
	 * @return
	 */
	public boolean isAccountSelf() {
		return isAccountSelf;
	}
	/**
	 * 设置本行他行标志
	 * @param isAccountSelf
	 */
	public void setAccountSelf(boolean isAccountSelf) {
		this.isAccountSelf = isAccountSelf;
	}

	public Double getFundRatio() {
		return fundRatio;
	}
	public void setFundRatio(Double fundRatio) {
		this.fundRatio = fundRatio;
	}

	private String bindMobile; //预留手机号

	public String getBindMobile() {
		return bindMobile;
	}

	public void setBindMobile(String bindMobile) {
		this.bindMobile = bindMobile;
	}
}
