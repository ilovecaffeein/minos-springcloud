package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * LM_HOLD_INFO(投资人相关信息表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmHoldInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 客户编号
	 */
	private String custId;
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
	 * 出资比例
	 */
	private BigDecimal holdPct;
	/**
	 * 最后更新用户
	 */
	private String lastChgUsr;
	/**
	 * 最后更新日期
	 */
	private String lastChgDt;
	/**
	 * 出资金额
	 */
	private BigDecimal holdAmt;
	/**
	 * 预期收益率
	 */
	private BigDecimal incPct;
	/**
	 * 资金来源
	 */
	private String chnType;

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
	 * 设置：客户编号
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}
	/**
	 * 获取：客户编号
	 */
	public String getCustId() {
		return custId;
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
	 * 设置：证件号码
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	/**
	 * 获取：证件号码
	 */
	public String getIdNo() {
		return idNo;
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
	 * 设置：出资比例
	 */
	public void setHoldPct(BigDecimal holdPct) {
		this.holdPct = holdPct;
	}
	/**
	 * 获取：出资比例
	 */
	public BigDecimal getHoldPct() {
		return holdPct;
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
	 * 设置：出资金额
	 */
	public void setHoldAmt(BigDecimal holdAmt) {
		this.holdAmt = holdAmt;
	}
	/**
	 * 获取：出资金额
	 */
	public BigDecimal getHoldAmt() {
		return holdAmt;
	}
	/**
	 * 设置：预期收益率
	 */
	public void setIncPct(BigDecimal incPct) {
		this.incPct = incPct;
	}
	/**
	 * 获取：预期收益率
	 */
	public BigDecimal getIncPct() {
		return incPct;
	}
	/**
	 * 设置：资金来源
	 */
	public void setChnType(String chnType) {
		this.chnType = chnType;
	}
	/**
	 * 获取：资金来源
	 */
	public String getChnType() {
		return chnType;
	}
}
