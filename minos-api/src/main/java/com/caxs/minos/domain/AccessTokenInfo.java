package com.caxs.minos.domain;

import java.io.Serializable;


/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class AccessTokenInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 调用方ID：唯一性标识，创建时分配给双方，接口调用需传递
	 */
	private String callId;
	/**
	 * 调用方名称
	 */
	private String callName;
	/**
	 * 调用方Secret
	 */
	private String callSecret;
	/**
	 * 调用方Token
	 */
	private String callToken;
	/**
	 * 更新时间
	 */
	private String uptTime;
	/**
	 * 有效期
	 */
	private String validityPeriod;
	/**
	 * 操作员
	 */
	private String operator;
	/**
	 * 操作机构
	 */
	private String operatorInstude;
	/**
	 * 操作时间
	 */
	private String operatorTime;

	/**
	 * 设置：调用方ID：唯一性标识，创建时分配给双方，接口调用需传递
	 */
	public void setCallId(String callId) {
		this.callId = callId;
	}
	/**
	 * 获取：调用方ID：唯一性标识，创建时分配给双方，接口调用需传递
	 */
	public String getCallId() {
		return callId;
	}
	/**
	 * 设置：调用方名称
	 */
	public void setCallName(String callName) {
		this.callName = callName;
	}
	/**
	 * 获取：调用方名称
	 */
	public String getCallName() {
		return callName;
	}
	/**
	 * 设置：调用方Secret
	 */
	public void setCallSecret(String callSecret) {
		this.callSecret = callSecret;
	}
	/**
	 * 获取：调用方Secret
	 */
	public String getCallSecret() {
		return callSecret;
	}
	/**
	 * 设置：调用方Token
	 */
	public void setCallToken(String callToken) {
		this.callToken = callToken;
	}
	/**
	 * 获取：调用方Token
	 */
	public String getCallToken() {
		return callToken;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUptTime(String uptTime) {
		this.uptTime = uptTime;
	}
	/**
	 * 获取：更新时间
	 */
	public String getUptTime() {
		return uptTime;
	}
	/**
	 * 设置：有效期
	 */
	public void setValidityPeriod(String validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
	/**
	 * 获取：有效期
	 */
	public String getValidityPeriod() {
		return validityPeriod;
	}
	/**
	 * 设置：操作员
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**
	 * 获取：操作员
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * 设置：操作机构
	 */
	public void setOperatorInstude(String operatorInstude) {
		this.operatorInstude = operatorInstude;
	}
	/**
	 * 获取：操作机构
	 */
	public String getOperatorInstude() {
		return operatorInstude;
	}
	/**
	 * 设置：操作时间
	 */
	public void setOperatorTime(String operatorTime) {
		this.operatorTime = operatorTime;
	}
	/**
	 * 获取：操作时间
	 */
	public String getOperatorTime() {
		return operatorTime;
	}
}
