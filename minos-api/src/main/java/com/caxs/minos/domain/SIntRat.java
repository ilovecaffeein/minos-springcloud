package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class SIntRat implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * ${column.comments}
	 */
	private String effDt;
	/**
	 * ${column.comments}
	 */
	private String rateTyp;
	/**
	 * ${column.comments}
	 */
	private BigDecimal intRat;
	/**
	 * ${column.comments}
	 */
	private String dailyUpdInd;
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
	private String ccy;

	/**
	 * 设置：${column.comments}
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getEffDt() {
		return effDt;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setRateTyp(String rateTyp) {
		this.rateTyp = rateTyp;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getRateTyp() {
		return rateTyp;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setIntRat(BigDecimal intRat) {
		this.intRat = intRat;
	}
	/**
	 * 获取：${column.comments}
	 */
	public BigDecimal getIntRat() {
		return intRat;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setDailyUpdInd(String dailyUpdInd) {
		this.dailyUpdInd = dailyUpdInd;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getDailyUpdInd() {
		return dailyUpdInd;
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
	public void setCcy(String ccy) {
		this.ccy = ccy;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getCcy() {
		return ccy;
	}
}
