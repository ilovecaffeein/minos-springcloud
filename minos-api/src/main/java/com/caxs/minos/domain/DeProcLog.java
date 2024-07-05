package com.caxs.minos.domain;

import java.io.Serializable;


/**
 * 日终操作日志情况表
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class DeProcLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 日终序号
	 */
	private String seqNo;
	/**
	 * 当前业务日期
	 */
	private String prcsDt;
	/**
	 * 步骤名
	 */
	private String jobNam;
	/**
	 * 日终运行状态
	 */
	private String jobSts;
	/**
	 * 错误信息
	 */
	private String errMsg;
	/**
	 * 日终类型
	 */
	private String jobTyp;
	/**
	 * 机器时间
	 */
	private String macTime;
	/**
	 * 忽略标志
	 */
	private String ignoreFlag;
	/**
	 * 开始运行时间
	 */
	private String startRunTime;

	/**
	 * 设置：日终序号
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	/**
	 * 获取：日终序号
	 */
	public String getSeqNo() {
		return seqNo;
	}
	/**
	 * 设置：当前业务日期
	 */
	public void setPrcsDt(String prcsDt) {
		this.prcsDt = prcsDt;
	}
	/**
	 * 获取：当前业务日期
	 */
	public String getPrcsDt() {
		return prcsDt;
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
	 * 设置：日终运行状态
	 */
	public void setJobSts(String jobSts) {
		this.jobSts = jobSts;
	}
	/**
	 * 获取：日终运行状态
	 */
	public String getJobSts() {
		return jobSts;
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
	/**
	 * 设置：日终类型
	 */
	public void setJobTyp(String jobTyp) {
		this.jobTyp = jobTyp;
	}
	/**
	 * 获取：日终类型
	 */
	public String getJobTyp() {
		return jobTyp;
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
	 * 设置：忽略标志
	 */
	public void setIgnoreFlag(String ignoreFlag) {
		this.ignoreFlag = ignoreFlag;
	}
	/**
	 * 获取：忽略标志
	 */
	public String getIgnoreFlag() {
		return ignoreFlag;
	}
	/**
	 * 设置：开始运行时间
	 */
	public void setStartRunTime(String startRunTime) {
		this.startRunTime = startRunTime;
	}
	/**
	 * 获取：开始运行时间
	 */
	public String getStartRunTime() {
		return startRunTime;
	}
}
