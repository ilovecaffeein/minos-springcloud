package com.caxs.minos.domain;

import java.io.Serializable;
/**
 * 日终操作错误日志表
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class DeErrorLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 日终错误序号
	 */
	private Long deErrSeq;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 业务日期
	 */
	private String prcsDt;
	/**
	 * 机器日期
	 */
	private String logDt;
	/**
	 * 机器时间
	 */
	private String macTime;
	/**
	 * 步骤名
	 */
	private String jobNam;
	/**
	 * 调用函数返回代码
	 */
	private String rtnCde;
	/**
	 * 错误信息
	 */
	private String errMsg;

	/**
	 * 设置：日终错误序号
	 */
	public void setDeErrSeq(Long deErrSeq) {
		this.deErrSeq = deErrSeq;
	}
	/**
	 * 获取：日终错误序号
	 */
	public Long getDeErrSeq() {
		return deErrSeq;
	}
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
	 * 设置：业务日期
	 */
	public void setPrcsDt(String prcsDt) {
		this.prcsDt = prcsDt;
	}
	/**
	 * 获取：业务日期
	 */
	public String getPrcsDt() {
		return prcsDt;
	}
	/**
	 * 设置：机器日期
	 */
	public void setLogDt(String logDt) {
		this.logDt = logDt;
	}
	/**
	 * 获取：机器日期
	 */
	public String getLogDt() {
		return logDt;
	}
	/**
	 * 设置：机器时间
	 */
	public void setMacTime(String macTime) {
		this.macTime = macTime;
	}
	/**
	 * 获取：机器时间
	 */
	public String getMacTime() {
		return macTime;
	}
	/**
	 * 设置：步骤名
	 */
	public void setJobNam(String jobNam) {
		this.jobNam = jobNam;
	}
	/**
	 * 获取：步骤名
	 */
	public String getJobNam() {
		return jobNam;
	}
	/**
	 * 设置：调用函数返回代码
	 */
	public void setRtnCde(String rtnCde) {
		this.rtnCde = rtnCde;
	}
	/**
	 * 获取：调用函数返回代码
	 */
	public String getRtnCde() {
		return rtnCde;
	}
	/**
	 * 设置：错误信息
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	/**
	 * 获取：错误信息
	 */
	public String getErrMsg() {
		return errMsg;
	}

	public  DeErrorLog() {
	}

	public  DeErrorLog(String prcsDt ,String jobNam) {
		this.jobNam = jobNam ;
		this.prcsDt = prcsDt ;
	}
}
