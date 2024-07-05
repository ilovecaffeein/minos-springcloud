package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 中原银行提前还款清算流水表
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
public class LmEarlyPayment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 授权流水号
	 */
	private String genGlNo;
	/**
	 * 机构号
	 */
	private String orgId;
	/**
	 * 合同号
	 */
	private String contNo;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 币种
	 */
	private String loanCcy;
	/**
	 * 收到总金额
	 */
	private BigDecimal setlTotalAmt;
	/**
	 * 收到金额
	 */
	private BigDecimal setlRecvAmt;
	/**
	 * 收到手续费
	 */
	private BigDecimal setlFeeAmt;
	/**
	 * 还款模式
	 */
	private String setlMode;
	/**
	 * 还款类型
	 */
	private String setlTyp;
	/**
	 * 还款日期
	 */
	private String setlValDt;
	/**
	 * 银行代码
	 */
	private String bankCde;
	/**
	 * 分支机构代码
	 */
	private String bchCde;
	/**
	 * 账户机构代码
	 */
	private String paymCcyCde;
	/**
	 * 还款账户名称
	 */
	private String paymAcctNam;
	/**
	 * 发证国家
	 */
	private String issCtry;
	/**
	 * 证件类型
	 */
	private String idType;
	/**
	 * 证件号
	 */
	private String idNo;
	/**
	 * 账户类型
	 */
	private String paymAcctCcy;
	/**
	 * 还款账户卡号
	 */
	private String paymAcctCardNo;
	/**
	 * SU: 未发送
SP: 处理中
CP: 已处理
	 */
	private String sendSts;
	/**
	 * 失败原因
	 */
	private String failReason;
	/**
	 * CP: 资金清算已完成清算
SU: 待发送到清算系统
NR: 待资金清算系统处理
	 */
	private String txAmtSts;
	/**
	 * 贷款归属机构
	 */
	private String dkGsjg;
	/**
	 * 贷款号
	 */
	private String applyNo;
	/**
	 * 借款人
	 */
	private String borRower;
	/**
	 * 备注
	 */
	private String meMo;
	/**
	 * 交易识别码：SJSF:资金清算，SJFS:提前结清
	 */
	private String txCode;
	/**
	 * 处理分页数据标志
	 */
	private String prcsPageDtInd;
	/**
	 * 本金
	 */
	private BigDecimal setlPrcpAmt;
	/**
	 * 正常利息
	 */
	private BigDecimal setlIntAmt;
	/**
	 * 逾期利息
	 */
	private BigDecimal setlOdInt;
	/**
	 * 复利
	 */
	private BigDecimal setlComInt;

	/**
	 * 设置：授权流水号
	 */
	public void setGenGlNo(String genGlNo) {
		this.genGlNo = genGlNo;
	}
	/**
	 * 获取：授权流水号
	 */
	public String getGenGlNo() {
		return genGlNo;
	}
	/**
	 * 设置：机构号
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	/**
	 * 获取：机构号
	 */
	public String getOrgId() {
		return orgId;
	}
	/**
	 * 设置：合同号
	 */
	public void setContNo(String contNo) {
		this.contNo = contNo;
	}
	/**
	 * 获取：合同号
	 */
	public String getContNo() {
		return contNo;
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
	 * 设置：币种
	 */
	public void setLoanCcy(String loanCcy) {
		this.loanCcy = loanCcy;
	}
	/**
	 * 获取：币种
	 */
	public String getLoanCcy() {
		return loanCcy;
	}
	/**
	 * 设置：收到总金额
	 */
	public void setSetlTotalAmt(BigDecimal setlTotalAmt) {
		this.setlTotalAmt = setlTotalAmt;
	}
	/**
	 * 获取：收到总金额
	 */
	public BigDecimal getSetlTotalAmt() {
		return setlTotalAmt;
	}
	/**
	 * 设置：收到金额
	 */
	public void setSetlRecvAmt(BigDecimal setlRecvAmt) {
		this.setlRecvAmt = setlRecvAmt;
	}
	/**
	 * 获取：收到金额
	 */
	public BigDecimal getSetlRecvAmt() {
		return setlRecvAmt;
	}
	/**
	 * 设置：收到手续费
	 */
	public void setSetlFeeAmt(BigDecimal setlFeeAmt) {
		this.setlFeeAmt = setlFeeAmt;
	}
	/**
	 * 获取：收到手续费
	 */
	public BigDecimal getSetlFeeAmt() {
		return setlFeeAmt;
	}
	/**
	 * 设置：还款模式
	 */
	public void setSetlMode(String setlMode) {
		this.setlMode = setlMode;
	}
	/**
	 * 获取：还款模式
	 */
	public String getSetlMode() {
		return setlMode;
	}
	/**
	 * 设置：还款类型
	 */
	public void setSetlTyp(String setlTyp) {
		this.setlTyp = setlTyp;
	}
	/**
	 * 获取：还款类型
	 */
	public String getSetlTyp() {
		return setlTyp;
	}
	/**
	 * 设置：还款日期
	 */
	public void setSetlValDt(String setlValDt) {
		this.setlValDt = setlValDt;
	}
	/**
	 * 获取：还款日期
	 */
	public String getSetlValDt() {
		return setlValDt;
	}
	/**
	 * 设置：银行代码
	 */
	public void setBankCde(String bankCde) {
		this.bankCde = bankCde;
	}
	/**
	 * 获取：银行代码
	 */
	public String getBankCde() {
		return bankCde;
	}
	/**
	 * 设置：分支机构代码
	 */
	public void setBchCde(String bchCde) {
		this.bchCde = bchCde;
	}
	/**
	 * 获取：分支机构代码
	 */
	public String getBchCde() {
		return bchCde;
	}
	/**
	 * 设置：账户机构代码
	 */
	public void setPaymCcyCde(String paymCcyCde) {
		this.paymCcyCde = paymCcyCde;
	}
	/**
	 * 获取：账户机构代码
	 */
	public String getPaymCcyCde() {
		return paymCcyCde;
	}
	/**
	 * 设置：还款账户名称
	 */
	public void setPaymAcctNam(String paymAcctNam) {
		this.paymAcctNam = paymAcctNam;
	}
	/**
	 * 获取：还款账户名称
	 */
	public String getPaymAcctNam() {
		return paymAcctNam;
	}
	/**
	 * 设置：发证国家
	 */
	public void setIssCtry(String issCtry) {
		this.issCtry = issCtry;
	}
	/**
	 * 获取：发证国家
	 */
	public String getIssCtry() {
		return issCtry;
	}
	/**
	 * 设置：证件类型
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}
	/**
	 * 获取：证件类型
	 */
	public String getIdType() {
		return idType;
	}
	/**
	 * 设置：证件号
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	/**
	 * 获取：证件号
	 */
	public String getIdNo() {
		return idNo;
	}
	/**
	 * 设置：账户类型
	 */
	public void setPaymAcctCcy(String paymAcctCcy) {
		this.paymAcctCcy = paymAcctCcy;
	}
	/**
	 * 获取：账户类型
	 */
	public String getPaymAcctCcy() {
		return paymAcctCcy;
	}
	/**
	 * 设置：还款账户卡号
	 */
	public void setPaymAcctCardNo(String paymAcctCardNo) {
		this.paymAcctCardNo = paymAcctCardNo;
	}
	/**
	 * 获取：还款账户卡号
	 */
	public String getPaymAcctCardNo() {
		return paymAcctCardNo;
	}
	/**
	 * 设置：SU: 未发送
SP: 处理中
CP: 已处理
	 */
	public void setSendSts(String sendSts) {
		this.sendSts = sendSts;
	}
	/**
	 * 获取：SU: 未发送
SP: 处理中
CP: 已处理
	 */
	public String getSendSts() {
		return sendSts;
	}
	/**
	 * 设置：失败原因
	 */
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}
	/**
	 * 获取：失败原因
	 */
	public String getFailReason() {
		return failReason;
	}
	/**
	 * 设置：CP: 资金清算已完成清算
SU: 待发送到清算系统
NR: 待资金清算系统处理
	 */
	public void setTxAmtSts(String txAmtSts) {
		this.txAmtSts = txAmtSts;
	}
	/**
	 * 获取：CP: 资金清算已完成清算
SU: 待发送到清算系统
NR: 待资金清算系统处理
	 */
	public String getTxAmtSts() {
		return txAmtSts;
	}
	/**
	 * 设置：贷款归属机构
	 */
	public void setDkGsjg(String dkGsjg) {
		this.dkGsjg = dkGsjg;
	}
	/**
	 * 获取：贷款归属机构
	 */
	public String getDkGsjg() {
		return dkGsjg;
	}
	/**
	 * 设置：贷款号
	 */
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}
	/**
	 * 获取：贷款号
	 */
	public String getApplyNo() {
		return applyNo;
	}
	/**
	 * 设置：借款人
	 */
	public void setBorRower(String borRower) {
		this.borRower = borRower;
	}
	/**
	 * 获取：借款人
	 */
	public String getBorRower() {
		return borRower;
	}
	/**
	 * 设置：备注
	 */
	public void setMeMo(String meMo) {
		this.meMo = meMo;
	}
	/**
	 * 获取：备注
	 */
	public String getMeMo() {
		return meMo;
	}
	/**
	 * 设置：交易识别码：SJSF:资金清算，SJFS:提前结清
	 */
	public void setTxCode(String txCode) {
		this.txCode = txCode;
	}
	/**
	 * 获取：交易识别码：SJSF:资金清算，SJFS:提前结清
	 */
	public String getTxCode() {
		return txCode;
	}
	/**
	 * 设置：处理分页数据标志
	 */
	public void setPrcsPageDtInd(String prcsPageDtInd) {
		this.prcsPageDtInd = prcsPageDtInd;
	}
	/**
	 * 获取：处理分页数据标志
	 */
	public String getPrcsPageDtInd() {
		return prcsPageDtInd;
	}
	/**
	 * 设置：本金
	 */
	public void setSetlPrcpAmt(BigDecimal setlPrcpAmt) {
		this.setlPrcpAmt = setlPrcpAmt;
	}
	/**
	 * 获取：本金
	 */
	public BigDecimal getSetlPrcpAmt() {
		return setlPrcpAmt;
	}
	/**
	 * 设置：正常利息
	 */
	public void setSetlIntAmt(BigDecimal setlIntAmt) {
		this.setlIntAmt = setlIntAmt;
	}
	/**
	 * 获取：正常利息
	 */
	public BigDecimal getSetlIntAmt() {
		return setlIntAmt;
	}
	/**
	 * 设置：逾期利息
	 */
	public void setSetlOdInt(BigDecimal setlOdInt) {
		this.setlOdInt = setlOdInt;
	}
	/**
	 * 获取：逾期利息
	 */
	public BigDecimal getSetlOdInt() {
		return setlOdInt;
	}
	/**
	 * 设置：复利
	 */
	public void setSetlComInt(BigDecimal setlComInt) {
		this.setlComInt = setlComInt;
	}
	/**
	 * 获取：复利
	 */
	public BigDecimal getSetlComInt() {
		return setlComInt;
	}
}
