package com.caxs.minos.domain.trans;

import java.io.Serializable;

/**
 * 利率变动日志。添加了结束日期。
 * 
 * @author hb
 * 
 */
public class RateChangeLogTrans implements Serializable {
	private static final long serialVersionUID = 7607704161124404623L;

	//起始日
	private String startDate;
	//原执行利率
	private double oldIntRate;
	//新执行利率
	private double newIntRate;
	//本金积数
	private double prcpProd;
	//是否结清标志
	private boolean setl;
	
	
	
	//获取是否结清标志
	public boolean isSetl() {
		return setl;
	}
	//设置是否结清标志
	public void setSetl(boolean setl) {
		this.setl = setl;
	}
	//获取本金积数
	public double getPrcpProd() {
		return prcpProd;
	}
	//设置本金积数
	public void setPrcpProd(double prcpProd) {
		this.prcpProd = prcpProd;
	}
	//获取新执行利率
	public double getNewIntRate() {
		return newIntRate;
	}
	//赋值新执行利率
	public void setNewIntRate(double newIntRate) {
		this.newIntRate = newIntRate;
	}
	//获取原执行利率
	public double getOldIntRate() {
		return oldIntRate;
	}
	//赋值新执行利率
	public void setOldIntRate(double oldIntRate) {
		this.oldIntRate = oldIntRate;
	}
	//获取开始日期
	public String getStartDate() {
		return startDate;
	}
	//赋值开始日期
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

}
