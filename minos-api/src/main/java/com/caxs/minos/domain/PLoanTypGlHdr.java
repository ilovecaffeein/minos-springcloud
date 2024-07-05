package com.caxs.minos.domain;

import java.io.Serializable;


/**
 * 配置会计分录设置主表
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
public class PLoanTypGlHdr implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 交易代码
	 */
	private String funcId;
	/**
	 * 方法状态
	 */
	private String mtdSts;
	/**
	 * 最新变更时间
	 */
	private String lastChgDt;
	/**
	 * 最新变更用户
	 */
	private String lastChgUsr;
	/**
	 * 核心系统交易码
	 */
	private String coreCode;
	/**
	 * 余额计算
	 */
	private String osCalMtd;
	/**
	 * 是否有交易撤销
	 */
	private String toHist;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 该交易是否记账
	 */
	private String hasAct;
	/**
	 * ${column.comments}
	 */
	private String beanName;
	/**
	 * ${column.comments}
	 */
	private String mainFuncName;
	/**
	 * ${column.comments}
	 */
	private String reprtInd;
	/**
	 * Y: 是
N: 否
	 */
	private String sysInd;
	/**
	 * 是否汇总帐
	 */
	private String sumAccount;

	/**
	 * 设置：交易代码
	 */
	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}
	/**
	 * 获取：交易代码
	 */
	public String getFuncId() {
		return funcId;
	}
	/**
	 * 设置：方法状态
	 */
	public void setMtdSts(String mtdSts) {
		this.mtdSts = mtdSts;
	}
	/**
	 * 获取：方法状态
	 */
	public String getMtdSts() {
		return mtdSts;
	}
	/**
	 * 设置：最新变更时间
	 */
	public void setLastChgDt(String lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	/**
	 * 获取：最新变更时间
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
	 * 设置：核心系统交易码
	 */
	public void setCoreCode(String coreCode) {
		this.coreCode = coreCode;
	}
	/**
	 * 获取：核心系统交易码
	 */
	public String getCoreCode() {
		return coreCode;
	}
	/**
	 * 设置：余额计算
	 */
	public void setOsCalMtd(String osCalMtd) {
		this.osCalMtd = osCalMtd;
	}
	/**
	 * 获取：余额计算
	 */
	public String getOsCalMtd() {
		return osCalMtd;
	}
	/**
	 * 设置：是否有交易撤销
	 */
	public void setToHist(String toHist) {
		this.toHist = toHist;
	}
	/**
	 * 获取：是否有交易撤销
	 */
	public String getToHist() {
		return toHist;
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
	 * 设置：该交易是否记账
	 */
	public void setHasAct(String hasAct) {
		this.hasAct = hasAct;
	}
	/**
	 * 获取：该交易是否记账
	 */
	public String getHasAct() {
		return hasAct;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getBeanName() {
		return beanName;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setMainFuncName(String mainFuncName) {
		this.mainFuncName = mainFuncName;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getMainFuncName() {
		return mainFuncName;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setReprtInd(String reprtInd) {
		this.reprtInd = reprtInd;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getReprtInd() {
		return reprtInd;
	}
	/**
	 * 设置：Y: 是
N: 否
	 */
	public void setSysInd(String sysInd) {
		this.sysInd = sysInd;
	}
	/**
	 * 获取：Y: 是
N: 否
	 */
	public String getSysInd() {
		return sysInd;
	}
	/**
	 * 设置：是否汇总帐
	 */
	public void setSumAccount(String sumAccount) {
		this.sumAccount = sumAccount;
	}
	/**
	 * 获取：是否汇总帐
	 */
	public String getSumAccount() {
		return sumAccount;
	}
}
