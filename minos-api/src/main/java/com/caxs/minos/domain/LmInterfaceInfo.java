package com.caxs.minos.domain;

import java.io.Serializable;


/**
 * 01.lm_interface_info(信托计划参数信息表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmInterfaceInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 信托计划代码
	 */
	private String trstplnNo;
	/**
	 * 信托计划名称
	 */
	private String trstplnName;
	/**
	 * 机构代码
	 */
	private String bankCde;
	/**
	 * 机构名称
	 */
	private String bchName;
	/**
	 * 操作员号
	 */
	private String userId;
	/**
	 * 客户号
	 */
	private String custId;
	/**
	 * 密码
	 */
	private String telpassword;
	/**
	 * 本行代扣代付编号
	 */
	private String billCodeBh;
	/**
	 * 本行用途编号
	 */
	private String useofCodeBh;
	/**
	 * 他行代扣代付编号
	 */
	private String billCodeTh;
	/**
	 * 他行用途编号
	 */
	private String useofCodeTh;
	/**
	 * 付款账户类型
	 */
	private String acctDfTyp;
	/**
	 * 付款账号
	 */
	private String acctDfNo;
	/**
	 * 付款账号名
	 */
	private String acctDfName;
	/**
	 * 付款帐号银行代码
	 */
	private String acctBankCdeDf;
	/**
	 * 付款帐号银行代码名称
	 */
	private String acctBankNameDf;
	/**
	 * 收款账户类型
	 */
	private String acctDsTyp;
	/**
	 * 收款账号
	 */
	private String acctDsNo;
	/**
	 * 收款款账号名
	 */
	private String acctDsName;
	/**
	 * 收款帐号银行代码
	 */
	private String acctBankCdeDs;
	/**
	 * 收款帐号银行代码名称
	 */
	private String acctBankNameDs;
	/**
	 * 生效标志：A：生效，I：失效
	 */
	private String actv;
	/**
	 * 创建时间
	 */
	private String txDate;
	/**
	 * 本行代码:用于区别扣款时哪些是本行账户，哪些是他行账户
	 */
	private String defBankCde;
	/**
	 * 备注1
	 */
	private String rem1;

	/**
	 * 设置：信托计划代码
	 */
	public void setTrstplnNo(String trstplnNo) {
		this.trstplnNo = trstplnNo;
	}
	/**
	 * 获取：信托计划代码
	 */
	public String getTrstplnNo() {
		return trstplnNo;
	}
	/**
	 * 设置：信托计划名称
	 */
	public void setTrstplnName(String trstplnName) {
		this.trstplnName = trstplnName;
	}
	/**
	 * 获取：信托计划名称
	 */
	public String getTrstplnName() {
		return trstplnName;
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
	 * 设置：机构名称
	 */
	public void setBchName(String bchName) {
		this.bchName = bchName;
	}
	/**
	 * 获取：机构名称
	 */
	public String getBchName() {
		return bchName;
	}
	/**
	 * 设置：操作员号
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：操作员号
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：客户号
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}
	/**
	 * 获取：客户号
	 */
	public String getCustId() {
		return custId;
	}
	/**
	 * 设置：密码
	 */
	public void setTelpassword(String telpassword) {
		this.telpassword = telpassword;
	}
	/**
	 * 获取：密码
	 */
	public String getTelpassword() {
		return telpassword;
	}
	/**
	 * 设置：本行代扣代付编号
	 */
	public void setBillCodeBh(String billCodeBh) {
		this.billCodeBh = billCodeBh;
	}
	/**
	 * 获取：本行代扣代付编号
	 */
	public String getBillCodeBh() {
		return billCodeBh;
	}
	/**
	 * 设置：本行用途编号
	 */
	public void setUseofCodeBh(String useofCodeBh) {
		this.useofCodeBh = useofCodeBh;
	}
	/**
	 * 获取：本行用途编号
	 */
	public String getUseofCodeBh() {
		return useofCodeBh;
	}
	/**
	 * 设置：他行代扣代付编号
	 */
	public void setBillCodeTh(String billCodeTh) {
		this.billCodeTh = billCodeTh;
	}
	/**
	 * 获取：他行代扣代付编号
	 */
	public String getBillCodeTh() {
		return billCodeTh;
	}
	/**
	 * 设置：他行用途编号
	 */
	public void setUseofCodeTh(String useofCodeTh) {
		this.useofCodeTh = useofCodeTh;
	}
	/**
	 * 获取：他行用途编号
	 */
	public String getUseofCodeTh() {
		return useofCodeTh;
	}
	/**
	 * 设置：付款账户类型
	 */
	public void setAcctDfTyp(String acctDfTyp) {
		this.acctDfTyp = acctDfTyp;
	}
	/**
	 * 获取：付款账户类型
	 */
	public String getAcctDfTyp() {
		return acctDfTyp;
	}
	/**
	 * 设置：付款账号
	 */
	public void setAcctDfNo(String acctDfNo) {
		this.acctDfNo = acctDfNo;
	}
	/**
	 * 获取：付款账号
	 */
	public String getAcctDfNo() {
		return acctDfNo;
	}
	/**
	 * 设置：付款账号名
	 */
	public void setAcctDfName(String acctDfName) {
		this.acctDfName = acctDfName;
	}
	/**
	 * 获取：付款账号名
	 */
	public String getAcctDfName() {
		return acctDfName;
	}
	/**
	 * 设置：付款帐号银行代码
	 */
	public void setAcctBankCdeDf(String acctBankCdeDf) {
		this.acctBankCdeDf = acctBankCdeDf;
	}
	/**
	 * 获取：付款帐号银行代码
	 */
	public String getAcctBankCdeDf() {
		return acctBankCdeDf;
	}
	/**
	 * 设置：付款帐号银行代码名称
	 */
	public void setAcctBankNameDf(String acctBankNameDf) {
		this.acctBankNameDf = acctBankNameDf;
	}
	/**
	 * 获取：付款帐号银行代码名称
	 */
	public String getAcctBankNameDf() {
		return acctBankNameDf;
	}
	/**
	 * 设置：收款账户类型
	 */
	public void setAcctDsTyp(String acctDsTyp) {
		this.acctDsTyp = acctDsTyp;
	}
	/**
	 * 获取：收款账户类型
	 */
	public String getAcctDsTyp() {
		return acctDsTyp;
	}
	/**
	 * 设置：收款账号
	 */
	public void setAcctDsNo(String acctDsNo) {
		this.acctDsNo = acctDsNo;
	}
	/**
	 * 获取：收款账号
	 */
	public String getAcctDsNo() {
		return acctDsNo;
	}
	/**
	 * 设置：收款款账号名
	 */
	public void setAcctDsName(String acctDsName) {
		this.acctDsName = acctDsName;
	}
	/**
	 * 获取：收款款账号名
	 */
	public String getAcctDsName() {
		return acctDsName;
	}
	/**
	 * 设置：收款帐号银行代码
	 */
	public void setAcctBankCdeDs(String acctBankCdeDs) {
		this.acctBankCdeDs = acctBankCdeDs;
	}
	/**
	 * 获取：收款帐号银行代码
	 */
	public String getAcctBankCdeDs() {
		return acctBankCdeDs;
	}
	/**
	 * 设置：收款帐号银行代码名称
	 */
	public void setAcctBankNameDs(String acctBankNameDs) {
		this.acctBankNameDs = acctBankNameDs;
	}
	/**
	 * 获取：收款帐号银行代码名称
	 */
	public String getAcctBankNameDs() {
		return acctBankNameDs;
	}
	/**
	 * 设置：生效标志：A：生效，I：失效
	 */
	public void setActv(String actv) {
		this.actv = actv;
	}
	/**
	 * 获取：生效标志：A：生效，I：失效
	 */
	public String getActv() {
		return actv;
	}
	/**
	 * 设置：创建时间
	 */
	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}
	/**
	 * 获取：创建时间
	 */
	public String getTxDate() {
		return txDate;
	}
	/**
	 * 设置：本行代码:用于区别扣款时哪些是本行账户，哪些是他行账户
	 */
	public void setDefBankCde(String defBankCde) {
		this.defBankCde = defBankCde;
	}
	/**
	 * 获取：本行代码:用于区别扣款时哪些是本行账户，哪些是他行账户
	 */
	public String getDefBankCde() {
		return defBankCde;
	}
	/**
	 * 设置：备注1
	 */
	public void setRem1(String rem1) {
		this.rem1 = rem1;
	}
	/**
	 * 获取：备注1
	 */
	public String getRem1() {
		return rem1;
	}

	public  LmInterfaceInfo() {
	}

	public  LmInterfaceInfo(String trstplnNo, String bankCde) {
		this.bankCde = bankCde;
		this.trstplnNo = trstplnNo;
	}
}
