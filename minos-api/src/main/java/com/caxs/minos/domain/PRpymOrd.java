package com.caxs.minos.domain;

import java.io.Serializable;


/**
 * RPYM_ORD_TYP:  正常扣款、非应计扣款
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class PRpymOrd implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 还款顺序编号
	 */
	private Integer rpymOrdSeqNo;
	/**
	 * 顺序描述
	 */
	private String rpymOrdDesc;
	/**
	 * 类型
	 */
	private String rpymOrdTyp;
	/**
	 * 状态
	 */
	private String rpymOrdStatus;

	/**
	 * 设置：还款顺序编号
	 */
	public void setRpymOrdSeqNo(Integer rpymOrdSeqNo) {
		this.rpymOrdSeqNo = rpymOrdSeqNo;
	}
	/**
	 * 获取：还款顺序编号
	 */
	public Integer getRpymOrdSeqNo() {
		return rpymOrdSeqNo;
	}
	/**
	 * 设置：顺序描述
	 */
	public void setRpymOrdDesc(String rpymOrdDesc) {
		this.rpymOrdDesc = rpymOrdDesc;
	}
	/**
	 * 获取：顺序描述
	 */
	public String getRpymOrdDesc() {
		return rpymOrdDesc;
	}
	/**
	 * 设置：类型
	 */
	public void setRpymOrdTyp(String rpymOrdTyp) {
		this.rpymOrdTyp = rpymOrdTyp;
	}
	/**
	 * 获取：类型
	 */
	public String getRpymOrdTyp() {
		return rpymOrdTyp;
	}
	/**
	 * 设置：状态
	 */
	public void setRpymOrdStatus(String rpymOrdStatus) {
		this.rpymOrdStatus = rpymOrdStatus;
	}
	/**
	 * 获取：状态
	 */
	public String getRpymOrdStatus() {
		return rpymOrdStatus;
	}
}
