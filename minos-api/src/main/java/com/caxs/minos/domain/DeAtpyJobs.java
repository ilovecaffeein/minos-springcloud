package com.caxs.minos.domain;

import java.io.Serializable;
/**
 * DE_ATPY_JOBS(自动扣款任务并发日志表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class DeAtpyJobs implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * LOAN: 贷款
DISC: 贴现
ACCP: 银承
GUTR:保函
	 */
	private String bussTyp;
	/**
	 * 批扣流水号
	 */
	private String atpySeqNo;
	/**
	 * 机构代码
	 */
	private String bchCde;
	/**
	 * 币种
	 */
	private String ccyCde;
	/**
	 * 扣款日期
	 */
	private String atpyDt;
	/**
	 * 进程总数
	 */
	private Integer jobCount;
	/**
	 * INIT:  任务发起
DTEX: 数据准备
DTSU:扣款数据生成
FLUP: 上传扣款文件
FLDW: 下载扣款文件
UPDT: 扣款文件返回数据更新
GLUP: 上传分录文件
	 */
	private String atpySts;
	/**
	 * PD: 未生成
CP: 已完成
	 */
	private String atpyexpSts;
	/**
	 * N: 未发送
Y:已发送
	 */
	private String atpyToCorebankSts;
	/**
	 * Y:已更新
N:未更新
	 */
	private String atpyexpUdpSts;
	/**
	 * 开始时间
	 */
	private String startTime;
	/**
	 * 结束时间
	 */
	private String endTime;
	/**
	 * 上传文件名
	 */
	private String uploadFile;
	/**
	 * 上传文件记录数
	 */
	private Integer upRowCount;
	/**
	 * 下载文件名
	 */
	private String downloadFile;
	/**
	 * 下传文件记录数
	 */
	private Integer downRowCount;
	/**
	 * 文件序号
	 */
	private String fileSeq;
	/**
	 * Y/N
	 */
	private String night;

	/**
	 * 设置：LOAN: 贷款
DISC: 贴现
ACCP: 银承
GUTR:保函
	 */
	public void setBussTyp(String bussTyp) {
		this.bussTyp = bussTyp;
	}
	/**
	 * 获取：LOAN: 贷款
DISC: 贴现
ACCP: 银承
GUTR:保函
	 */
	public String getBussTyp() {
		return bussTyp;
	}
	/**
	 * 设置：批扣流水号
	 */
	public void setAtpySeqNo(String atpySeqNo) {
		this.atpySeqNo = atpySeqNo;
	}
	/**
	 * 获取：批扣流水号
	 */
	public String getAtpySeqNo() {
		return atpySeqNo;
	}
	/**
	 * 设置：机构代码
	 */
	public void setBchCde(String bchCde) {
		this.bchCde = bchCde;
	}
	/**
	 * 获取：机构代码
	 */
	public String getBchCde() {
		return bchCde;
	}
	/**
	 * 设置：币种
	 */
	public void setCcyCde(String ccyCde) {
		this.ccyCde = ccyCde;
	}
	/**
	 * 获取：币种
	 */
	public String getCcyCde() {
		return ccyCde;
	}
	/**
	 * 设置：扣款日期
	 */
	public void setAtpyDt(String atpyDt) {
		this.atpyDt = atpyDt;
	}
	/**
	 * 获取：扣款日期
	 */
	public String getAtpyDt() {
		return atpyDt;
	}
	/**
	 * 设置：进程总数
	 */
	public void setJobCount(Integer jobCount) {
		this.jobCount = jobCount;
	}
	/**
	 * 获取：进程总数
	 */
	public Integer getJobCount() {
		return jobCount;
	}
	/**
	 * 设置：INIT:  任务发起
DTEX: 数据准备
DTSU:扣款数据生成
FLUP: 上传扣款文件
FLDW: 下载扣款文件
UPDT: 扣款文件返回数据更新
GLUP: 上传分录文件
	 */
	public void setAtpySts(String atpySts) {
		this.atpySts = atpySts;
	}
	/**
	 * 获取：INIT:  任务发起
DTEX: 数据准备
DTSU:扣款数据生成
FLUP: 上传扣款文件
FLDW: 下载扣款文件
UPDT: 扣款文件返回数据更新
GLUP: 上传分录文件
	 */
	public String getAtpySts() {
		return atpySts;
	}
	/**
	 * 设置：PD: 未生成
CP: 已完成
	 */
	public void setAtpyexpSts(String atpyexpSts) {
		this.atpyexpSts = atpyexpSts;
	}
	/**
	 * 获取：PD: 未生成
CP: 已完成
	 */
	public String getAtpyexpSts() {
		return atpyexpSts;
	}
	/**
	 * 设置：N: 未发送
Y:已发送
	 */
	public void setAtpyToCorebankSts(String atpyToCorebankSts) {
		this.atpyToCorebankSts = atpyToCorebankSts;
	}
	/**
	 * 获取：N: 未发送
Y:已发送
	 */
	public String getAtpyToCorebankSts() {
		return atpyToCorebankSts;
	}
	/**
	 * 设置：Y:已更新
N:未更新
	 */
	public void setAtpyexpUdpSts(String atpyexpUdpSts) {
		this.atpyexpUdpSts = atpyexpUdpSts;
	}
	/**
	 * 获取：Y:已更新
N:未更新
	 */
	public String getAtpyexpUdpSts() {
		return atpyexpUdpSts;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * 设置：结束时间
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：结束时间
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * 设置：上传文件名
	 */
	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}
	/**
	 * 获取：上传文件名
	 */
	public String getUploadFile() {
		return uploadFile;
	}
	/**
	 * 设置：上传文件记录数
	 */
	public void setUpRowCount(Integer upRowCount) {
		this.upRowCount = upRowCount;
	}
	/**
	 * 获取：上传文件记录数
	 */
	public Integer getUpRowCount() {
		return upRowCount;
	}
	/**
	 * 设置：下载文件名
	 */
	public void setDownloadFile(String downloadFile) {
		this.downloadFile = downloadFile;
	}
	/**
	 * 获取：下载文件名
	 */
	public String getDownloadFile() {
		return downloadFile;
	}
	/**
	 * 设置：下传文件记录数
	 */
	public void setDownRowCount(Integer downRowCount) {
		this.downRowCount = downRowCount;
	}
	/**
	 * 获取：下传文件记录数
	 */
	public Integer getDownRowCount() {
		return downRowCount;
	}
	/**
	 * 设置：文件序号
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	/**
	 * 获取：文件序号
	 */
	public String getFileSeq() {
		return fileSeq;
	}
	/**
	 * 设置：Y/N
	 */
	public void setNight(String night) {
		this.night = night;
	}
	/**
	 * 获取：Y/N
	 */
	public String getNight() {
		return night;
	}

	public DeAtpyJobs() {

	}

	public DeAtpyJobs(String bussTyp, String atpyDt) {
        this.atpyDt = atpyDt;
		this.bussTyp = bussTyp;
	}
}
