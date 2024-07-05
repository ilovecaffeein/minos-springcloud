package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * LM_SETLMT_T（提前还款授权）
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
public class LmSetlmtT implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 授权流水号
	 */
	private String genGlNo;
	/**
	 * 核算处理标志
	 */
	private String genGlInd;
	/**
	 * 交易流水号
	 */
	private Long txLogSeq;
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
	 * 收到金额
	 */
	private BigDecimal setlRecvAmt;
	/**
	 * 还款模式
	 */
	private String setlMode;
	/**
	 * 还款类型
	 */
	private String setlTyp;
	/**
	 * 归还本金
	 */
	private BigDecimal setlOdPrcpAmt;
	/**
	 * 记账日期
	 */
	private String setlValDt;
	/**
	 * 归还利息
	 */
	private BigDecimal setlIntAmt;
	/**
	 * 归还逾期利息
	 */
	private BigDecimal setlOdIntAmt;
	/**
	 * 归还复利
	 */
	private BigDecimal setlOdCommInt;
	/**
	 * 归还后剩余本金
	 */
	private BigDecimal setlRemPrcpPaym;
	/**
	 * 利息计算选项
	 */
	private String setlFpaidIntOpt;
	/**
	 * 归还已计提利息
	 */
	private BigDecimal setlAccInt;
	/**
	 * 代偿标志
	 */
	private String setlCompInd;
	/**
	 * 归还本金标志
	 */
	private String setlPrcpInd;
	/**
	 * 还款账号
	 */
	private String paymAcctNo;
	/**
	 * 还款币种
	 */
	private String paymCcyCde;
	/**
	 * 银行代码
	 */
	private String bankCde;
	/**
	 * 分支机构代码
	 */
	private String bchCde;
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
	 * 还款账号币种
	 */
	private String paymAcctCcy;
	/**
	 * 还款账户卡号
	 */
	private String paymAcctCardNo;
	/**
	 * 钞汇标志
	 */
	private String paymAcctNttInd;
	/**
	 * 账户代码
	 */
	private String paymAcctCde;
	/**
	 * 账户科目代码
	 */
	private String paymAcctLdgrCde;
	/**
	 * 账户类型
	 */
	private String paymAcctTyp;
	/**
	 * 还款后期数
	 */
	private Integer paymPerdCnt;
	/**
	 * 业务数据来源
	 */
	private String bussTyp;
	/**
	 * 补记罚息标志
	 */
	private String apdProdInd;
	/**
	 * 凭证号
	 */
	private String inputProof;
	/**
	 * 凭证类型
	 */
	private String inputProofType;
	/**
	 * 账号类型
	 */
	private String acctTyp;
	/**
	 * 归还的拖欠费用
	 */
	private BigDecimal setlFeeAmt;
	/**
	 * ${column.comments}
	 */
	private BigDecimal trueRecvAmt;
	/**
	 * ${column.comments}
	 */
	private String ppRatBase;
	/**
	 * 01:股权置换
02: 票据置换
03: 其它置换
	 */
	private String dpTyp;
	/**
	 * 是否清偿还
	 */
	private String clearOweInd;
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
	 * 冲正标示
	 */
	private String revseInd;
	/**
	 * 冲正日期
	 */
	private String revseDt;
	/**
	 * 还款后期供金额
	 */
	private BigDecimal paymPerdAmt;
	/**
	 * 是否线上清算表示：Y:连接建行扣款，N：不走建行扣款，R：债权转让且不走建行扣款
	 */
	private String olInd;
	/**
	 * 交易来源
	 */
	private String txcodeTyp;
	/**
	 * 冲正标志
	 */
	private String revsInd;
	/**
	 * 10324:信托,12176:新生
	 */
	private String caxInd;
	/**
	 * ${column.comments}
	 */
	private String bankBchCde;
	/**
	 * 交易类别：ZQZR:债权转让，ZDHK：主动还款
	 */
	private String zqzrTyp;
	/**
	 * 信贷授权号
	 */
	private String cmisGenGlNo;
	/**
	 * 信贷收到金额
	 */
	private BigDecimal cmisSetlRecvAmt;
	/**
	 * 扣款渠道
	 */
	private String pchCde;
	/**
	 * 创建用户
	 */
	private String setlCreateUsr;


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
	 * 设置：核算处理标志
	 */
	public void setGenGlInd(String genGlInd) {
		this.genGlInd = genGlInd;
	}
	/**
	 * 获取：核算处理标志
	 */
	public String getGenGlInd() {
		return genGlInd;
	}
	/**
	 * 设置：交易流水号
	 */
	public void setTxLogSeq(Long txLogSeq) {
		this.txLogSeq = txLogSeq;
	}
	/**
	 * 获取：交易流水号
	 */
	public Long getTxLogSeq() {
		return txLogSeq;
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
	 * 设置：归还本金
	 */
	public void setSetlOdPrcpAmt(BigDecimal setlOdPrcpAmt) {
		this.setlOdPrcpAmt = setlOdPrcpAmt;
	}
	/**
	 * 获取：归还本金
	 */
	public BigDecimal getSetlOdPrcpAmt() {
		return setlOdPrcpAmt;
	}
	/**
	 * 设置：记账日期
	 */
	public void setSetlValDt(String setlValDt) {
		this.setlValDt = setlValDt;
	}
	/**
	 * 获取：记账日期
	 */
	public String getSetlValDt() {
		return setlValDt;
	}
	/**
	 * 设置：归还利息
	 */
	public void setSetlIntAmt(BigDecimal setlIntAmt) {
		this.setlIntAmt = setlIntAmt;
	}
	/**
	 * 获取：归还利息
	 */
	public BigDecimal getSetlIntAmt() {
		return setlIntAmt;
	}
	/**
	 * 设置：归还逾期利息
	 */
	public void setSetlOdIntAmt(BigDecimal setlOdIntAmt) {
		this.setlOdIntAmt = setlOdIntAmt;
	}
	/**
	 * 获取：归还逾期利息
	 */
	public BigDecimal getSetlOdIntAmt() {
		return setlOdIntAmt;
	}
	/**
	 * 设置：归还复利
	 */
	public void setSetlOdCommInt(BigDecimal setlOdCommInt) {
		this.setlOdCommInt = setlOdCommInt;
	}
	/**
	 * 获取：归还复利
	 */
	public BigDecimal getSetlOdCommInt() {
		return setlOdCommInt;
	}
	/**
	 * 设置：归还后剩余本金
	 */
	public void setSetlRemPrcpPaym(BigDecimal setlRemPrcpPaym) {
		this.setlRemPrcpPaym = setlRemPrcpPaym;
	}
	/**
	 * 获取：归还后剩余本金
	 */
	public BigDecimal getSetlRemPrcpPaym() {
		return setlRemPrcpPaym;
	}
	/**
	 * 设置：利息计算选项
	 */
	public void setSetlFpaidIntOpt(String setlFpaidIntOpt) {
		this.setlFpaidIntOpt = setlFpaidIntOpt;
	}
	/**
	 * 获取：利息计算选项
	 */
	public String getSetlFpaidIntOpt() {
		return setlFpaidIntOpt;
	}
	/**
	 * 设置：归还已计提利息
	 */
	public void setSetlAccInt(BigDecimal setlAccInt) {
		this.setlAccInt = setlAccInt;
	}
	/**
	 * 获取：归还已计提利息
	 */
	public BigDecimal getSetlAccInt() {
		return setlAccInt;
	}
	/**
	 * 设置：代偿标志
	 */
	public void setSetlCompInd(String setlCompInd) {
		this.setlCompInd = setlCompInd;
	}
	/**
	 * 获取：代偿标志
	 */
	public String getSetlCompInd() {
		return setlCompInd;
	}
	/**
	 * 设置：归还本金标志
	 */
	public void setSetlPrcpInd(String setlPrcpInd) {
		this.setlPrcpInd = setlPrcpInd;
	}
	/**
	 * 获取：归还本金标志
	 */
	public String getSetlPrcpInd() {
		return setlPrcpInd;
	}
	/**
	 * 设置：还款账号
	 */
	public void setPaymAcctNo(String paymAcctNo) {
		this.paymAcctNo = paymAcctNo;
	}
	/**
	 * 获取：还款账号
	 */
	public String getPaymAcctNo() {
		return paymAcctNo;
	}
	/**
	 * 设置：还款币种
	 */
	public void setPaymCcyCde(String paymCcyCde) {
		this.paymCcyCde = paymCcyCde;
	}
	/**
	 * 获取：还款币种
	 */
	public String getPaymCcyCde() {
		return paymCcyCde;
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
	 * 设置：还款账号币种
	 */
	public void setPaymAcctCcy(String paymAcctCcy) {
		this.paymAcctCcy = paymAcctCcy;
	}
	/**
	 * 获取：还款账号币种
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
	 * 设置：钞汇标志
	 */
	public void setPaymAcctNttInd(String paymAcctNttInd) {
		this.paymAcctNttInd = paymAcctNttInd;
	}
	/**
	 * 获取：钞汇标志
	 */
	public String getPaymAcctNttInd() {
		return paymAcctNttInd;
	}
	/**
	 * 设置：账户代码
	 */
	public void setPaymAcctCde(String paymAcctCde) {
		this.paymAcctCde = paymAcctCde;
	}
	/**
	 * 获取：账户代码
	 */
	public String getPaymAcctCde() {
		return paymAcctCde;
	}
	/**
	 * 设置：账户科目代码
	 */
	public void setPaymAcctLdgrCde(String paymAcctLdgrCde) {
		this.paymAcctLdgrCde = paymAcctLdgrCde;
	}
	/**
	 * 获取：账户科目代码
	 */
	public String getPaymAcctLdgrCde() {
		return paymAcctLdgrCde;
	}
	/**
	 * 设置：账户类型
	 */
	public void setPaymAcctTyp(String paymAcctTyp) {
		this.paymAcctTyp = paymAcctTyp;
	}
	/**
	 * 获取：账户类型
	 */
	public String getPaymAcctTyp() {
		return paymAcctTyp;
	}
	/**
	 * 设置：还款后期数
	 */
	public void setPaymPerdCnt(Integer paymPerdCnt) {
		this.paymPerdCnt = paymPerdCnt;
	}
	/**
	 * 获取：还款后期数
	 */
	public Integer getPaymPerdCnt() {
		return paymPerdCnt;
	}
	/**
	 * 设置：业务数据来源
	 */
	public void setBussTyp(String bussTyp) {
		this.bussTyp = bussTyp;
	}
	/**
	 * 获取：业务数据来源
	 */
	public String getBussTyp() {
		return bussTyp;
	}
	/**
	 * 设置：补记罚息标志
	 */
	public void setApdProdInd(String apdProdInd) {
		this.apdProdInd = apdProdInd;
	}
	/**
	 * 获取：补记罚息标志
	 */
	public String getApdProdInd() {
		return apdProdInd;
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
	 * 设置：账号类型
	 */
	public void setAcctTyp(String acctTyp) {
		this.acctTyp = acctTyp;
	}
	/**
	 * 获取：账号类型
	 */
	public String getAcctTyp() {
		return acctTyp;
	}
	/**
	 * 设置：归还的拖欠费用
	 */
	public void setSetlFeeAmt(BigDecimal setlFeeAmt) {
		this.setlFeeAmt = setlFeeAmt;
	}
	/**
	 * 获取：归还的拖欠费用
	 */
	public BigDecimal getSetlFeeAmt() {
		return setlFeeAmt;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setTrueRecvAmt(BigDecimal trueRecvAmt) {
		this.trueRecvAmt = trueRecvAmt;
	}
	/**
	 * 获取：${column.comments}
	 */
	public BigDecimal getTrueRecvAmt() {
		return trueRecvAmt;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setPpRatBase(String ppRatBase) {
		this.ppRatBase = ppRatBase;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getPpRatBase() {
		return ppRatBase;
	}
	/**
	 * 设置：01:股权置换
02: 票据置换
03: 其它置换
	 */
	public void setDpTyp(String dpTyp) {
		this.dpTyp = dpTyp;
	}
	/**
	 * 获取：01:股权置换
02: 票据置换
03: 其它置换
	 */
	public String getDpTyp() {
		return dpTyp;
	}
	/**
	 * 设置：是否清偿还
	 */
	public void setClearOweInd(String clearOweInd) {
		this.clearOweInd = clearOweInd;
	}
	/**
	 * 获取：是否清偿还
	 */
	public String getClearOweInd() {
		return clearOweInd;
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
	 * 设置：冲正标示
	 */
	public void setRevseInd(String revseInd) {
		this.revseInd = revseInd;
	}
	/**
	 * 获取：冲正标示
	 */
	public String getRevseInd() {
		return revseInd;
	}
	/**
	 * 设置：冲正日期
	 */
	public void setRevseDt(String revseDt) {
		this.revseDt = revseDt;
	}
	/**
	 * 获取：冲正日期
	 */
	public String getRevseDt() {
		return revseDt;
	}
	/**
	 * 设置：还款后期供金额
	 */
	public void setPaymPerdAmt(BigDecimal paymPerdAmt) {
		this.paymPerdAmt = paymPerdAmt;
	}
	/**
	 * 获取：还款后期供金额
	 */
	public BigDecimal getPaymPerdAmt() {
		return paymPerdAmt;
	}
	/**
	 * 设置：是否线上清算表示：Y:连接建行扣款，N：不走建行扣款，R：债权转让且不走建行扣款
	 */
	public void setOlInd(String olInd) {
		this.olInd = olInd;
	}
	/**
	 * 获取：是否线上清算表示：Y:连接建行扣款，N：不走建行扣款，R：债权转让且不走建行扣款
	 */
	public String getOlInd() {
		return olInd;
	}
	/**
	 * 设置：交易来源
	 */
	public void setTxcodeTyp(String txcodeTyp) {
		this.txcodeTyp = txcodeTyp;
	}
	/**
	 * 获取：交易来源
	 */
	public String getTxcodeTyp() {
		return txcodeTyp;
	}
	/**
	 * 设置：冲正标志
	 */
	public void setRevsInd(String revsInd) {
		this.revsInd = revsInd;
	}
	/**
	 * 获取：冲正标志
	 */
	public String getRevsInd() {
		return revsInd;
	}
	/**
	 * 设置：10324:信托,12176:新生
	 */
	public void setCaxInd(String caxInd) {
		this.caxInd = caxInd;
	}
	/**
	 * 获取：10324:信托,12176:新生
	 */
	public String getCaxInd() {
		return caxInd;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setBankBchCde(String bankBchCde) {
		this.bankBchCde = bankBchCde;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getBankBchCde() {
		return bankBchCde;
	}
	/**
	 * 设置：交易类别：ZQZR:债权转让，ZDHK：主动还款
	 */
	public void setZqzrTyp(String zqzrTyp) {
		this.zqzrTyp = zqzrTyp;
	}
	/**
	 * 获取：交易类别：ZQZR:债权转让，ZDHK：主动还款
	 */
	public String getZqzrTyp() {
		return zqzrTyp;
	}
	/**
	 * 设置：信贷授权号
	 */
	public void setCmisGenGlNo(String cmisGenGlNo) {
		this.cmisGenGlNo = cmisGenGlNo;
	}
	/**
	 * 获取：信贷授权号
	 */
	public String getCmisGenGlNo() {
		return cmisGenGlNo;
	}
	/**
	 * 设置：信贷收到金额
	 */
	public void setCmisSetlRecvAmt(BigDecimal cmisSetlRecvAmt) {
		this.cmisSetlRecvAmt = cmisSetlRecvAmt;
	}
	/**
	 * 获取：信贷收到金额
	 */
	public BigDecimal getCmisSetlRecvAmt() {
		return cmisSetlRecvAmt;
	}
	/**
	 * 设置：扣款渠道
	 */
	public void setPchCde(String pchCde) {
		this.pchCde = pchCde;
	}
	/**
	 * 获取：扣款渠道
	 */
	public String getPchCde() {
		return pchCde;
	}
	/**
	 * 设置：创建用户
	 */
	public void setSetlCreateUsr(String setlCreateUsr) {
		this.setlCreateUsr = setlCreateUsr;
	}
	/**
	 * 获取：创建用户
	 */
	public String getSetlCreateUsr() {
		return setlCreateUsr;
	}
}
