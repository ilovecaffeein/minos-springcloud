package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * LM_GLNO_LOG(授权交易日志)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmGlnoLog implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 授权号
	 */
	private String genGlNo;
	/**
	 * 记账处理标识
	 */
	private String genGlInd;
	/**
	 * 机构号
	 */
	private String bchCde;
	/**
	 * 币种
	 */
	private String ccyCde;
	/**
	 * 申请业务日期
	 */
	private String appDt;
	/**
	 * 创建日期
	 */
	private String crtDt;
	/**
	 * 创建时间
	 */
	private String crtTm;
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
	 * 交易流水
	 */
	private Long  txLogSeq;
	/**
	 * 交易码
	 */
	private String transCode;
	/**
	 * 交易金额
	 */
	private BigDecimal amount;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 撤销标志
	 */
	private String revseInd;
	/**
	 * 撤销日期
	 */
	private String revseDt;
	/**
	 * 撤销时间
	 */
	private String revseTm;
	/**
	 * 是否通知管理系统
	 */
	private String infoCmisInd;
	/**
	 * 接口服务编码
	 */
	private String serviceId;
	/**
	 * 合同编码
	 */
	private String loanContNo;
	/**
	 * 发送系统标识
XD 信贷系统
GJ 国结系统
	 */
	private String sentSys;
	/**
	 * 状态
	 */
	private String state;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 国结系统流水号
	 */
	private String fromGjNo;
	/**
	 * 核心入账流水号
	 */
	private String myrzSerno;
	/**
	 * 出账用户编号
	 */
	private String accUserId;
	/**
	 * 出账用户机构号
	 */
	private String accUserOrgNo;
	/**
	 * 本金
	 */
	private BigDecimal prcpAmt;
	/**
	 * 正常利息
	 */
	private BigDecimal normIntAmt;
	/**
	 * 逾期利息
	 */
	private BigDecimal odIntAmt;
	/**
	 * 复利
	 */
	private BigDecimal commOdIntAmt;

	/**
	 * 设置：授权号
	 */
	public void setGenGlNo(String genGlNo) {
		this.genGlNo = genGlNo;
	}
	/**
	 * 获取：授权号
	 */
	public String getGenGlNo() {
		return genGlNo;
	}
	/**
	 * 设置：记账处理标识
	 */
	public void setGenGlInd(String genGlInd) {
		this.genGlInd = genGlInd;
	}
	/**
	 * 获取：记账处理标识
	 */
	public String getGenGlInd() {
		return genGlInd;
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
	 * 设置：币种
	 */
	public void setCcyCde(String ccyCde) {
		this.ccyCde = ccyCde;
	}
	/**
	 * 获取：币种
	 */
	public String getCcyCde() {
		return ccyCde;
	}
	/**
	 * 设置：申请业务日期
	 */
	public void setAppDt(String appDt) {
		this.appDt = appDt;
	}
	/**
	 * 获取：申请业务日期
	 */
	public String getAppDt() {
		return appDt;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCrtDt(String crtDt) {
		this.crtDt = crtDt;
	}
	/**
	 * 获取：创建日期
	 */
	public String getCrtDt() {
		return crtDt;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCrtTm(String crtTm) {
		this.crtTm = crtTm;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCrtTm() {
		return crtTm;
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
	 * 设置：交易流水
	 */
	public void setTxLogSeq(Long txLogSeq) {
		this.txLogSeq = txLogSeq;
	}
	/**
	 * 获取：交易流水
	 */
	public Long  getTxLogSeq() {
		return txLogSeq;
	}
	/**
	 * 设置：交易码
	 */
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}
	/**
	 * 获取：交易码
	 */
	public String getTransCode() {
		return transCode;
	}
	/**
	 * 设置：交易金额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * 获取：交易金额
	 */
	public BigDecimal getAmount() {
		return amount;
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
	/**
	 * 设置：撤销标志
	 */
	public void setRevseInd(String revseInd) {
		this.revseInd = revseInd;
	}
	/**
	 * 获取：撤销标志
	 */
	public String getRevseInd() {
		return revseInd;
	}
	/**
	 * 设置：撤销日期
	 */
	public void setRevseDt(String revseDt) {
		this.revseDt = revseDt;
	}
	/**
	 * 获取：撤销日期
	 */
	public String getRevseDt() {
		return revseDt;
	}
	/**
	 * 设置：撤销时间
	 */
	public void setRevseTm(String revseTm) {
		this.revseTm = revseTm;
	}
	/**
	 * 获取：撤销时间
	 */
	public String getRevseTm() {
		return revseTm;
	}
	/**
	 * 设置：是否通知管理系统
	 */
	public void setInfoCmisInd(String infoCmisInd) {
		this.infoCmisInd = infoCmisInd;
	}
	/**
	 * 获取：是否通知管理系统
	 */
	public String getInfoCmisInd() {
		return infoCmisInd;
	}
	/**
	 * 设置：接口服务编码
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	/**
	 * 获取：接口服务编码
	 */
	public String getServiceId() {
		return serviceId;
	}
	/**
	 * 设置：合同编码
	 */
	public void setLoanContNo(String loanContNo) {
		this.loanContNo = loanContNo;
	}
	/**
	 * 获取：合同编码
	 */
	public String getLoanContNo() {
		return loanContNo;
	}
	/**
	 * 设置：发送系统标识
XD 信贷系统
GJ 国结系统
	 */
	public void setSentSys(String sentSys) {
		this.sentSys = sentSys;
	}
	/**
	 * 获取：发送系统标识
XD 信贷系统
GJ 国结系统
	 */
	public String getSentSys() {
		return sentSys;
	}
	/**
	 * 设置：状态
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * 获取：状态
	 */
	public String getState() {
		return state;
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
	 * 设置：国结系统流水号
	 */
	public void setFromGjNo(String fromGjNo) {
		this.fromGjNo = fromGjNo;
	}
	/**
	 * 获取：国结系统流水号
	 */
	public String getFromGjNo() {
		return fromGjNo;
	}
	/**
	 * 设置：核心入账流水号
	 */
	public void setMyrzSerno(String myrzSerno) {
		this.myrzSerno = myrzSerno;
	}
	/**
	 * 获取：核心入账流水号
	 */
	public String getMyrzSerno() {
		return myrzSerno;
	}
	/**
	 * 设置：出账用户编号
	 */
	public void setAccUserId(String accUserId) {
		this.accUserId = accUserId;
	}
	/**
	 * 获取：出账用户编号
	 */
	public String getAccUserId() {
		return accUserId;
	}
	/**
	 * 设置：出账用户机构号
	 */
	public void setAccUserOrgNo(String accUserOrgNo) {
		this.accUserOrgNo = accUserOrgNo;
	}
	/**
	 * 获取：出账用户机构号
	 */
	public String getAccUserOrgNo() {
		return accUserOrgNo;
	}
	/**
	 * 设置：本金
	 */
	public void setPrcpAmt(BigDecimal prcpAmt) {
		this.prcpAmt = prcpAmt;
	}
	/**
	 * 获取：本金
	 */
	public BigDecimal getPrcpAmt() {
		return prcpAmt;
	}
	/**
	 * 设置：正常利息
	 */
	public void setNormIntAmt(BigDecimal normIntAmt) {
		this.normIntAmt = normIntAmt;
	}
	/**
	 * 获取：正常利息
	 */
	public BigDecimal getNormIntAmt() {
		return normIntAmt;
	}
	/**
	 * 设置：逾期利息
	 */
	public void setOdIntAmt(BigDecimal odIntAmt) {
		this.odIntAmt = odIntAmt;
	}
	/**
	 * 获取：逾期利息
	 */
	public BigDecimal getOdIntAmt() {
		return odIntAmt;
	}
	/**
	 * 设置：复利
	 */
	public void setCommOdIntAmt(BigDecimal commOdIntAmt) {
		this.commOdIntAmt = commOdIntAmt;
	}
	/**
	 * 获取：复利
	 */
	public BigDecimal getCommOdIntAmt() {
		return commOdIntAmt;
	}

	public LmGlnoLog(String genGlNo){
		this.genGlNo = genGlNo;
	}

	public LmGlnoLog(){
	}
}
