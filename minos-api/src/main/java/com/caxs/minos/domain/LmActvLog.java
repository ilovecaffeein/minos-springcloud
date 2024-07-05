package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 用于存放贷款、银承、贴现发放的日志
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
public class LmActvLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 交易流水
	 */
	private BigDecimal txLogSeq;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 冲正标志
	 */
	private String actvRevseInd;
	/**
	 * 会计分录流水号
	 */
	private BigDecimal txNo;
	/**
	 * 是否为续按揭标志
	 */
	private String exdDrawdnInd;
	/**
	 * 续按揭借据号
	 */
	private String loanDrawdnNo;
	/**
	 * 放款日期
	 */
	private String actvDt;
	/**
	 * 放款/退款金额
	 */
	private BigDecimal actvDrawdnAmt;
	/**
	 * 上次剩余本金
	 */
	private BigDecimal lastOsPrcp;
	/**
	 * 额度代码
	 */
	private String crLine;
	/**
	 * 是否放款标志
	 */
	private String actvInd;
	/**
	 * 合同编号
	 */
	private String contractNo;
	/**
	 * 放款审批用户
	 */
	private String actvApprUsr;
	/**
	 * 商户/经销商代码
	 */
	private String dealerCde;
	/**
	 * 实际发放金额
	 */
	private BigDecimal realDownAmt;
	/**
	 * 凭证类型
	 */
	private String inputProofType;
	/**
	 * 凭证号
	 */
	private String inputProof;
	/**
	 * ${column.comments}
	 */
	private String loanCcy;
	/**
	 * 还款帐号银行代码
	 */
	private String acctBankCde;
	/**
	 * 还款帐号机构代码
	 */
	private String acctBchCde;
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
	private String acctCardNo;
	/**
	 * 银行地址
	 */
	private String acctBankAdd;
	/**
	 * 银行名称
	 */
	private String acctBankNam;
	/**
	 * 账号证件类型
	 */
	private String acctIdType;
	/**
	 * 账号证件号码
	 */
	private String acctIdNo;
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
	 * 冲正日期
	 */
	private String actvRevseDt;
	/**
	 * 核算处理状态
	 */
	private String txAmtSts;
	/**
	 * 是否线上清算
	 */
	private String olInd;
	/**
	 * 签约协议号
	 */
	private String protocolNo;
	/**
	 * 是否签约标志
	 */
	private String proInd;
	/**
	 * 分支机构代码
	 */
	private String bchCde;
	/**
	 * 信托计划
	 */
	private String capCde;
	/**
	 * 中原银行贷款归属机构
	 */
	private String dkGsjg;
	/**
	 * 中原银行贷款号
	 */
	private String loanZyhh;
	/**
	 * 支付平台签约处理状态：SU 未处理，SP 处理中，CP 处理完成，FL 签约失败 
	 */
	private String signedSts;
	/**
	 * 支付平台协议号
	 */
	private String signedIp;
	/**
	 * 信托计划代码
	 */
	private String trstplnNo;
	/**
	 * 信托计划名称
	 */
	private String trstplnName;
	/**
	 * 放款账户类型
	 */
	private String acctTyp;

	/**
	 * 设置：交易流水
	 */
	public void setTxLogSeq(BigDecimal txLogSeq) {
		this.txLogSeq = txLogSeq;
	}
	/**
	 * 获取：交易流水
	 */
	public BigDecimal getTxLogSeq() {
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
	 * 设置：冲正标志
	 */
	public void setActvRevseInd(String actvRevseInd) {
		this.actvRevseInd = actvRevseInd;
	}
	/**
	 * 获取：冲正标志
	 */
	public String getActvRevseInd() {
		return actvRevseInd;
	}
	/**
	 * 设置：会计分录流水号
	 */
	public void setTxNo(BigDecimal txNo) {
		this.txNo = txNo;
	}
	/**
	 * 获取：会计分录流水号
	 */
	public BigDecimal getTxNo() {
		return txNo;
	}
	/**
	 * 设置：是否为续按揭标志
	 */
	public void setExdDrawdnInd(String exdDrawdnInd) {
		this.exdDrawdnInd = exdDrawdnInd;
	}
	/**
	 * 获取：是否为续按揭标志
	 */
	public String getExdDrawdnInd() {
		return exdDrawdnInd;
	}
	/**
	 * 设置：续按揭借据号
	 */
	public void setLoanDrawdnNo(String loanDrawdnNo) {
		this.loanDrawdnNo = loanDrawdnNo;
	}
	/**
	 * 获取：续按揭借据号
	 */
	public String getLoanDrawdnNo() {
		return loanDrawdnNo;
	}
	/**
	 * 设置：放款日期
	 */
	public void setActvDt(String actvDt) {
		this.actvDt = actvDt;
	}
	/**
	 * 获取：放款日期
	 */
	public String getActvDt() {
		return actvDt;
	}
	/**
	 * 设置：放款/退款金额
	 */
	public void setActvDrawdnAmt(BigDecimal actvDrawdnAmt) {
		this.actvDrawdnAmt = actvDrawdnAmt;
	}
	/**
	 * 获取：放款/退款金额
	 */
	public BigDecimal getActvDrawdnAmt() {
		return actvDrawdnAmt;
	}
	/**
	 * 设置：上次剩余本金
	 */
	public void setLastOsPrcp(BigDecimal lastOsPrcp) {
		this.lastOsPrcp = lastOsPrcp;
	}
	/**
	 * 获取：上次剩余本金
	 */
	public BigDecimal getLastOsPrcp() {
		return lastOsPrcp;
	}
	/**
	 * 设置：额度代码
	 */
	public void setCrLine(String crLine) {
		this.crLine = crLine;
	}
	/**
	 * 获取：额度代码
	 */
	public String getCrLine() {
		return crLine;
	}
	/**
	 * 设置：是否放款标志
	 */
	public void setActvInd(String actvInd) {
		this.actvInd = actvInd;
	}
	/**
	 * 获取：是否放款标志
	 */
	public String getActvInd() {
		return actvInd;
	}
	/**
	 * 设置：合同编号
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	/**
	 * 获取：合同编号
	 */
	public String getContractNo() {
		return contractNo;
	}
	/**
	 * 设置：放款审批用户
	 */
	public void setActvApprUsr(String actvApprUsr) {
		this.actvApprUsr = actvApprUsr;
	}
	/**
	 * 获取：放款审批用户
	 */
	public String getActvApprUsr() {
		return actvApprUsr;
	}
	/**
	 * 设置：商户/经销商代码
	 */
	public void setDealerCde(String dealerCde) {
		this.dealerCde = dealerCde;
	}
	/**
	 * 获取：商户/经销商代码
	 */
	public String getDealerCde() {
		return dealerCde;
	}
	/**
	 * 设置：实际发放金额
	 */
	public void setRealDownAmt(BigDecimal realDownAmt) {
		this.realDownAmt = realDownAmt;
	}
	/**
	 * 获取：实际发放金额
	 */
	public BigDecimal getRealDownAmt() {
		return realDownAmt;
	}
	/**
	 * 设置：凭证类型
	 */
	public void setInputProofType(String inputProofType) {
		this.inputProofType = inputProofType;
	}
	/**
	 * 获取：凭证类型
	 */
	public String getInputProofType() {
		return inputProofType;
	}
	/**
	 * 设置：凭证号
	 */
	public void setInputProof(String inputProof) {
		this.inputProof = inputProof;
	}
	/**
	 * 获取：凭证号
	 */
	public String getInputProof() {
		return inputProof;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setLoanCcy(String loanCcy) {
		this.loanCcy = loanCcy;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getLoanCcy() {
		return loanCcy;
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
	 * 设置：账号证件类型
	 */
	public void setAcctIdType(String acctIdType) {
		this.acctIdType = acctIdType;
	}
	/**
	 * 获取：账号证件类型
	 */
	public String getAcctIdType() {
		return acctIdType;
	}
	/**
	 * 设置：账号证件号码
	 */
	public void setAcctIdNo(String acctIdNo) {
		this.acctIdNo = acctIdNo;
	}
	/**
	 * 获取：账号证件号码
	 */
	public String getAcctIdNo() {
		return acctIdNo;
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
	 * 设置：冲正日期
	 */
	public void setActvRevseDt(String actvRevseDt) {
		this.actvRevseDt = actvRevseDt;
	}
	/**
	 * 获取：冲正日期
	 */
	public String getActvRevseDt() {
		return actvRevseDt;
	}
	/**
	 * 设置：核算处理状态
	 */
	public void setTxAmtSts(String txAmtSts) {
		this.txAmtSts = txAmtSts;
	}
	/**
	 * 获取：核算处理状态
	 */
	public String getTxAmtSts() {
		return txAmtSts;
	}
	/**
	 * 设置：是否线上清算
	 */
	public void setOlInd(String olInd) {
		this.olInd = olInd;
	}
	/**
	 * 获取：是否线上清算
	 */
	public String getOlInd() {
		return olInd;
	}
	/**
	 * 设置：签约协议号
	 */
	public void setProtocolNo(String protocolNo) {
		this.protocolNo = protocolNo;
	}
	/**
	 * 获取：签约协议号
	 */
	public String getProtocolNo() {
		return protocolNo;
	}
	/**
	 * 设置：是否签约标志
	 */
	public void setProInd(String proInd) {
		this.proInd = proInd;
	}
	/**
	 * 获取：是否签约标志
	 */
	public String getProInd() {
		return proInd;
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
	 * 设置：信托计划
	 */
	public void setCapCde(String capCde) {
		this.capCde = capCde;
	}
	/**
	 * 获取：信托计划
	 */
	public String getCapCde() {
		return capCde;
	}
	/**
	 * 设置：中原银行贷款归属机构
	 */
	public void setDkGsjg(String dkGsjg) {
		this.dkGsjg = dkGsjg;
	}
	/**
	 * 获取：中原银行贷款归属机构
	 */
	public String getDkGsjg() {
		return dkGsjg;
	}
	/**
	 * 设置：中原银行贷款号
	 */
	public void setLoanZyhh(String loanZyhh) {
		this.loanZyhh = loanZyhh;
	}
	/**
	 * 获取：中原银行贷款号
	 */
	public String getLoanZyhh() {
		return loanZyhh;
	}
	/**
	 * 设置：支付平台签约处理状态：SU 未处理，SP 处理中，CP 处理完成，FL 签约失败 
	 */
	public void setSignedSts(String signedSts) {
		this.signedSts = signedSts;
	}
	/**
	 * 获取：支付平台签约处理状态：SU 未处理，SP 处理中，CP 处理完成，FL 签约失败 
	 */
	public String getSignedSts() {
		return signedSts;
	}
	/**
	 * 设置：支付平台协议号
	 */
	public void setSignedIp(String signedIp) {
		this.signedIp = signedIp;
	}
	/**
	 * 获取：支付平台协议号
	 */
	public String getSignedIp() {
		return signedIp;
	}
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
	 * 设置：放款账户类型
	 */
	public void setAcctTyp(String acctTyp) {
		this.acctTyp = acctTyp;
	}
	/**
	 * 获取：放款账户类型
	 */
	public String getAcctTyp() {
		return acctTyp;
	}

	public LmActvLog() {
	}

	public LmActvLog(String loanNo) {
		this.loanNo = loanNo;
	}
}
