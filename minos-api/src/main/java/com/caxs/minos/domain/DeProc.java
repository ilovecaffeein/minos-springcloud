package com.caxs.minos.domain;

import java.io.Serializable;


/**
 * 日终操作步骤定义表
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class DeProc implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 日终序号
	 */
	private String seqNo;
	/**
	 * 步骤名
	 */
	private String jobNam;
	/**
	 * 运行标志
	 */
	private String execInd;
	/**
	 * 运行周期
	 */
	private String jobFreq;
	/**
	 * 错误是否退出
	 */
	private String jobAbort;
	/**
	 * 日终类型
	 */
	private String jobTyp;
	/**
	 * 日终运行程序
	 */
	private String jobExe;
	/**
	 * 日终标志
	 */
	private String eodFlag;
	/**
	 * 允许多线程标志
	 */
	private String mutiThread;
	/**
	 * 每次运行进程数
	 */
	private Integer threadCnt;
	/**
	 * 程序包名
	 */
	private String beanName;
	/**
	 * 主程序名
	 */
	private String mainFuncName;
	/**
	 * 分支级别
	 */
	private Integer branchLevel;
	/**
	 * 允许单个文件系号对应数据最大笔数
	 */
	private Integer mutiMumber;
	/**
	 * 是否允许单个文件系号切分多个文件
	 */
	private String mutiAbort;
	/**
	 * 运行状态：STATR： 开始状态，STOP ：停止状态
	 */
	private String jobStop;

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
	 * 设置：运行标志
	 */
	public void setExecInd(String execInd) {
		this.execInd = execInd;
	}
	/**
	 * 获取：运行标志
	 */
	public String getExecInd() {
		return execInd;
	}
	/**
	 * 设置：运行周期
	 */
	public void setJobFreq(String jobFreq) {
		this.jobFreq = jobFreq;
	}
	/**
	 * 获取：运行周期
	 */
	public String getJobFreq() {
		return jobFreq;
	}
	/**
	 * 设置：错误是否退出
	 */
	public void setJobAbort(String jobAbort) {
		this.jobAbort = jobAbort;
	}
	/**
	 * 获取：错误是否退出
	 */
	public String getJobAbort() {
		return jobAbort;
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
	 * 设置：日终运行程序
	 */
	public void setJobExe(String jobExe) {
		this.jobExe = jobExe;
	}
	/**
	 * 获取：日终运行程序
	 */
	public String getJobExe() {
		return jobExe;
	}
	/**
	 * 设置：日终标志
	 */
	public void setEodFlag(String eodFlag) {
		this.eodFlag = eodFlag;
	}
	/**
	 * 获取：日终标志
	 */
	public String getEodFlag() {
		return eodFlag;
	}
	/**
	 * 设置：允许多线程标志
	 */
	public void setMutiThread(String mutiThread) {
		this.mutiThread = mutiThread;
	}
	/**
	 * 获取：允许多线程标志
	 */
	public String getMutiThread() {
		return mutiThread;
	}
	/**
	 * 设置：每次运行进程数
	 */
	public void setThreadCnt(Integer threadCnt) {
		this.threadCnt = threadCnt;
	}
	/**
	 * 获取：每次运行进程数
	 */
	public Integer getThreadCnt() {
		return threadCnt;
	}
	/**
	 * 设置：程序包名
	 */
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	/**
	 * 获取：程序包名
	 */
	public String getBeanName() {
		return beanName;
	}
	/**
	 * 设置：主程序名
	 */
	public void setMainFuncName(String mainFuncName) {
		this.mainFuncName = mainFuncName;
	}
	/**
	 * 获取：主程序名
	 */
	public String getMainFuncName() {
		return mainFuncName;
	}
	/**
	 * 设置：分支级别
	 */
	public void setBranchLevel(Integer branchLevel) {
		this.branchLevel = branchLevel;
	}
	/**
	 * 获取：分支级别
	 */
	public Integer getBranchLevel() {
		return branchLevel;
	}
	/**
	 * 设置：允许单个文件系号对应数据最大笔数
	 */
	public void setMutiMumber(Integer mutiMumber) {
		this.mutiMumber = mutiMumber;
	}
	/**
	 * 获取：允许单个文件系号对应数据最大笔数
	 */
	public Integer getMutiMumber() {
		return mutiMumber;
	}
	/**
	 * 设置：是否允许单个文件系号切分多个文件
	 */
	public void setMutiAbort(String mutiAbort) {
		this.mutiAbort = mutiAbort;
	}
	/**
	 * 获取：是否允许单个文件系号切分多个文件
	 */
	public String getMutiAbort() {
		return mutiAbort;
	}
	/**
	 * 设置：运行状态：STATR： 开始状态，STOP ：停止状态
	 */
	public void setJobStop(String jobStop) {
		this.jobStop = jobStop;
	}
	/**
	 * 获取：运行状态：STATR： 开始状态，STOP ：停止状态
	 */
	public String getJobStop() {
		return jobStop;
	}
}
