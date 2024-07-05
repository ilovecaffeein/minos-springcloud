package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * P_CAP_CHANNEL(资金渠道管理)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-10-20 16:43:44
 */
public class PCapChannel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 序号
	 */
	private BigDecimal capSeq;
	/**
	 * 代码
	 */
	private String capCde;
	/**
	 * 描述
	 */
	private String capDesc;
	/**
	 * 发布金融机构
	 */
	private String capInstuCde;
	/**
	 * 金融机构名称
	 */
	private String capInstuName;
	/**
	 * 成本利率
	 */
	private BigDecimal costRat;
	/**
	 * 生效日期
	 */
	private String strDt;
	/**
	 * 状态
	 */
	private String sts;
	/**
	 * 最后修改时间
	 */
	private String lastChgDt;
	/**
	 * 最新变更用户
	 */
	private String lastChgUsr;
	/**
	 * 结束日期
	 */
	private String endDt;
	/**
	 * ${column.comments}
	 */
	private BigDecimal proAmt;
	/**
	 * ${column.comments}
	 */
	private BigDecimal restAmt;
	/**
	 * 适用银行
	 */
	private String applicationBankCde;
	/**
	 * 开户行
	 */
	private String accBankCde;
	/**
	 * 开户行名称
	 */
	private String accBankName;
	/**
	 * 户名
	 */
	private String acName;
	/**
	 * 账号
	 */
	private String acCard;
	/**
	 * 信托产品代码
	 */
	private String trstCapCde;

	/**
	 * 设置：序号
	 */
	public void setCapSeq(BigDecimal capSeq) {
		this.capSeq = capSeq;
	}
	/**
	 * 获取：序号
	 */
	public BigDecimal getCapSeq() {
		return capSeq;
	}
	/**
	 * 设置：代码
	 */
	public void setCapCde(String capCde) {
		this.capCde = capCde;
	}
	/**
	 * 获取：代码
	 */
	public String getCapCde() {
		return capCde;
	}
	/**
	 * 设置：描述
	 */
	public void setCapDesc(String capDesc) {
		this.capDesc = capDesc;
	}
	/**
	 * 获取：描述
	 */
	public String getCapDesc() {
		return capDesc;
	}
	/**
	 * 设置：发布金融机构
	 */
	public void setCapInstuCde(String capInstuCde) {
		this.capInstuCde = capInstuCde;
	}
	/**
	 * 获取：发布金融机构
	 */
	public String getCapInstuCde() {
		return capInstuCde;
	}
	/**
	 * 设置：金融机构名称
	 */
	public void setCapInstuName(String capInstuName) {
		this.capInstuName = capInstuName;
	}
	/**
	 * 获取：金融机构名称
	 */
	public String getCapInstuName() {
		return capInstuName;
	}
	/**
	 * 设置：成本利率
	 */
	public void setCostRat(BigDecimal costRat) {
		this.costRat = costRat;
	}
	/**
	 * 获取：成本利率
	 */
	public BigDecimal getCostRat() {
		return costRat;
	}
	/**
	 * 设置：生效日期
	 */
	public void setStrDt(String strDt) {
		this.strDt = strDt;
	}
	/**
	 * 获取：生效日期
	 */
	public String getStrDt() {
		return strDt;
	}
	/**
	 * 设置：状态
	 */
	public void setSts(String sts) {
		this.sts = sts;
	}
	/**
	 * 获取：状态
	 */
	public String getSts() {
		return sts;
	}
	/**
	 * 设置：最后修改时间
	 */
	public void setLastChgDt(String lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	/**
	 * 获取：最后修改时间
	 */
	public String getLastChgDt() {
		return lastChgDt;
	}
	/**
	 * 设置：最新变更用户
	 */
	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr;
	}
	/**
	 * 获取：最新变更用户
	 */
	public String getLastChgUsr() {
		return lastChgUsr;
	}
	/**
	 * 设置：结束日期
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	/**
	 * 获取：结束日期
	 */
	public String getEndDt() {
		return endDt;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setProAmt(BigDecimal proAmt) {
		this.proAmt = proAmt;
	}
	/**
	 * 获取：${column.comments}
	 */
	public BigDecimal getProAmt() {
		return proAmt;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setRestAmt(BigDecimal restAmt) {
		this.restAmt = restAmt;
	}
	/**
	 * 获取：${column.comments}
	 */
	public BigDecimal getRestAmt() {
		return restAmt;
	}
	/**
	 * 设置：适用银行
	 */
	public void setApplicationBankCde(String applicationBankCde) {
		this.applicationBankCde = applicationBankCde;
	}
	/**
	 * 获取：适用银行
	 */
	public String getApplicationBankCde() {
		return applicationBankCde;
	}
	/**
	 * 设置：开户行
	 */
	public void setAccBankCde(String accBankCde) {
		this.accBankCde = accBankCde;
	}
	/**
	 * 获取：开户行
	 */
	public String getAccBankCde() {
		return accBankCde;
	}
	/**
	 * 设置：开户行名称
	 */
	public void setAccBankName(String accBankName) {
		this.accBankName = accBankName;
	}
	/**
	 * 获取：开户行名称
	 */
	public String getAccBankName() {
		return accBankName;
	}
	/**
	 * 设置：户名
	 */
	public void setAcName(String acName) {
		this.acName = acName;
	}
	/**
	 * 获取：户名
	 */
	public String getAcName() {
		return acName;
	}
	/**
	 * 设置：账号
	 */
	public void setAcCard(String acCard) {
		this.acCard = acCard;
	}
	/**
	 * 获取：账号
	 */
	public String getAcCard() {
		return acCard;
	}
	/**
	 * 设置：信托产品代码
	 */
	public void setTrstCapCde(String trstCapCde) {
		this.trstCapCde = trstCapCde;
	}
	/**
	 * 获取：信托产品代码
	 */
	public String getTrstCapCde() {
		return trstCapCde;
	}
}
