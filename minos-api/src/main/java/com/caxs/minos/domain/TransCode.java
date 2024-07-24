package com.caxs.minos.domain;

import java.lang.reflect.Method;
/**
 * 交易码 ，不要再在这个类加入枚举常量。 新加入交易码，需加入数据库。 通过
 * SystemInfo.getSystemInfo().findTransCode("LNCX");来获取TransCode
 * 
 * @author hb
 * 
 */
public class TransCode implements Comparable<TransCode> {
	// 交易码
	private String transCode;

	// 核心码
	private String coreCode;
	/**
	 *是否更新到历史表
	 */
	private boolean toHist;

	// 获取是否更新到历史表
	public boolean isToHist() {
		return toHist;
	}

	/**
	 * 是否记账
	 */
	public boolean hasAccount;

	// 设置是否更新到历史表
	public void setToHist(boolean toHist) {
		this.toHist = toHist;
	}

	/**
	 * 余额计算方法
	 */
	private String osCalMtd;

	/**
	 *是否保存到重打日志
	 */
	private boolean reprt;

	// 获取是否保存到重打日志
	public boolean isReprt() {
		return reprt;
	}

	// 设置是否保存到重打日志标志
	public void setReprt(boolean reprt) {
		this.reprt = reprt;
	}

	// 交易码构造方法
	public TransCode(String transCode) {
		super();
		this.transCode = transCode;
	}

	// 获取余额计算方法
	public String getOsCalMtd() {
		return osCalMtd;
	}

	// 设置余额计算方法
	public void setOsCalMtd(String osCalMtd) {
		this.osCalMtd = osCalMtd;
	}

	// 交易码构造方法
	public TransCode(String transCode, String coreCode) {
		super();
		this.transCode = transCode;
		this.coreCode = coreCode;
	}

	/**
	 * 返回字符串编码
	 * 
	 * @return
	 */
	public String getCode() {
		return this.transCode;
	}

	/**
	 * 返回核心里面的编码
	 * 
	 * @return
	 */
	public String getCoreCode() {
		return this.coreCode;
	}


	// 获取核心码
	public void setCoreCode(String coreCode) {
		this.coreCode = coreCode;
	}

	// 转化为字符串
	@Override
	public String toString() {
		return transCode;
	}

	// 哈希值
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((transCode == null) ? 0 : transCode.hashCode());
		return result;
	}

	// 是否相等
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransCode other = (TransCode) obj;
		if (transCode == null) {
			if (other.transCode != null)
				return false;
		} else if (!transCode.equals(other.transCode))
			return false;
		return true;
	}

	// 比较方法
	public int compareTo(TransCode o) {
		return this.transCode.compareTo(o.transCode);
	}

	// 获取是否记账
	public boolean isHasAccount() {
		return hasAccount;
	}

	// 设置是否记账
	public void setHasAccount(boolean hasAccount) {
		this.hasAccount = hasAccount;
	}

	/**
	 * 实时交易主方法
	 */
	private Method onlineTransMethod;
	/**
	 * 实时交易业务对象
	 */
	private Object onlineTransObj;

	public Method getOnlineTransMethod() {
		return onlineTransMethod;
	}

	public Object getOnlineTransObj() {
		return onlineTransObj;
	}

	public void setOnlineTransObj(Object onlineTransObj) {
		this.onlineTransObj = onlineTransObj;
	}

	public void setOnlineTransMethod(Method onlineTransMethod) {
		this.onlineTransMethod = onlineTransMethod;
	}

}
