package com.caxs.minos.domain;

/**
 *操作柜员信息
 * 
 * @author liucp
 * 
 */

public class OperaUserInf {
	private String userId;		//用户编号
	private String userName;		//用户姓名
	private String userOrgNo;		//机构编号
	private String bankCde;			//银行编号
	
	/**
	 * 操作员信息默认构造函数
	 */
	public OperaUserInf() {
		super();
	}
	/**
	 * 操作员信息构造函数
	 * @param userId
	 * @param userName
	 * @param userOrgNo
	 */
	public OperaUserInf(String userId, String userName, String userOrgNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userOrgNo = userOrgNo;
	}
	/**
	 * 获取用户id
	 * @return
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置用户id
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取用户姓名
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置用户姓名
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取机构号
	 * @return
	 */
	public String getUserOrgNo() {
		return userOrgNo;
	}
	/**
	 * 设置机构号
	 * @param userOrgNo
	 */
	public void setUserOrgNo(String userOrgNo) {
		this.userOrgNo = userOrgNo;
	}
	/**
	 * 获取银行编号
	 * @return
	 */
	public String getBankCde() {
		return bankCde;
	}
	/**
	 * 设置银行编号
	 * @param bankCde
	 */
	public void setBankCde(String bankCde) {
		this.bankCde = bankCde;
	}

}
