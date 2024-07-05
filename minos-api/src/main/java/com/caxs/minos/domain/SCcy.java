package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
public class SCcy implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ${column.comments}
	 */
	private String ccyCde;
	/**
	 * ${column.comments}
	 */
	private String ccyDesc;
	/**
	 * ${column.comments}
	 */
	private Integer ccyBase;
	/**
	 * ${column.comments}
	 */
	private BigDecimal ccyRatio;
	/**
	 * ${column.comments}
	 */
	private String hostCde;
	/**
	 * ${column.comments}
	 */
	private String lastChgDt;
	/**
	 * ${column.comments}
	 */
	private String lastChgUsr;
	/**
	 * ${column.comments}
	 */
	private String ccyStatus;
	/**
	 * ${column.comments}
	 */
	private Integer intAccu;

	/**
	 * 设置：${column.comments}
	 */
	public void setCcyCde(String ccyCde) {
		this.ccyCde = ccyCde;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getCcyCde() {
		return ccyCde;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setCcyDesc(String ccyDesc) {
		this.ccyDesc = ccyDesc;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getCcyDesc() {
		return ccyDesc;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setCcyBase(Integer ccyBase) {
		this.ccyBase = ccyBase;
	}
	/**
	 * 获取：${column.comments}
	 */
	public Integer getCcyBase() {
		return ccyBase;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setCcyRatio(BigDecimal ccyRatio) {
		this.ccyRatio = ccyRatio;
	}
	/**
	 * 获取：${column.comments}
	 */
	public BigDecimal getCcyRatio() {
		return ccyRatio;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setHostCde(String hostCde) {
		this.hostCde = hostCde;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getHostCde() {
		return hostCde;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setLastChgDt(String lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getLastChgDt() {
		return lastChgDt;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getLastChgUsr() {
		return lastChgUsr;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setCcyStatus(String ccyStatus) {
		this.ccyStatus = ccyStatus;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getCcyStatus() {
		return ccyStatus;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setIntAccu(Integer intAccu) {
		this.intAccu = intAccu;
	}
	/**
	 * 获取：${column.comments}
	 */
	public Integer getIntAccu() {
		return intAccu;
	}
}
