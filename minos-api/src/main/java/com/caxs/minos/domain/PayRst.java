package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 扣款结果表
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class PayRst implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 交易流水号
	 */
	private Long txlogSeq;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 交易码
	 */
	private String transCode;
	/**
	 * 申请金额
	 */
	private BigDecimal appAmt;
	/**
	 * 实扣金额
	 */
	private BigDecimal actAmt;
	/**
	 * 账号
	 */
	private String acctNo;
	/**
	 * 统一的错误编码
	 */
	private String errCde;
	/**
	 * 文件中的错误信息
	 */
	private String errMsg;
	/**
	 * 分页处理标志
	 */
	private String prcsPageDtInd;
	/**
	 * 成功标志
	 */
	private String sucInd;
	/**
	 * 批量扣款序号
	 */
	private Long batSeqNo;
	/**
	 * 业务交易子流水号
	 */
	private Integer subTxlogSeq;

	/**
	 * 设置：交易流水号
	 */
	public void setTxlogSeq(Long txlogSeq) {
		this.txlogSeq = txlogSeq;
	}
	/**
	 * 获取：交易流水号
	 */
	public Long getTxlogSeq() {
		return txlogSeq;
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
	 * 设置：交易码
	 */
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}
	/**
	 * 获取：交易码
	 */
	public String getTransCode() {
		return transCode;
	}
	/**
	 * 设置：申请金额
	 */
	public void setAppAmt(BigDecimal appAmt) {
		this.appAmt = appAmt;
	}
	/**
	 * 获取：申请金额
	 */
	public BigDecimal getAppAmt() {
		return appAmt;
	}
	/**
	 * 设置：实扣金额
	 */
	public void setActAmt(BigDecimal actAmt) {
		this.actAmt = actAmt;
	}
	/**
	 * 获取：实扣金额
	 */
	public BigDecimal getActAmt() {
		return actAmt;
	}
	/**
	 * 设置：账号
	 */
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	/**
	 * 获取：账号
	 */
	public String getAcctNo() {
		return acctNo;
	}
	/**
	 * 设置：统一的错误编码
	 */
	public void setErrCde(String errCde) {
		this.errCde = errCde;
	}
	/**
	 * 获取：统一的错误编码
	 */
	public String getErrCde() {
		return errCde;
	}
	/**
	 * 设置：文件中的错误信息
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	/**
	 * 获取：文件中的错误信息
	 */
	public String getErrMsg() {
		return errMsg;
	}
	/**
	 * 设置：分页处理标志
	 */
	public void setPrcsPageDtInd(String prcsPageDtInd) {
		this.prcsPageDtInd = prcsPageDtInd;
	}
	/**
	 * 获取：分页处理标志
	 */
	public String getPrcsPageDtInd() {
		return prcsPageDtInd;
	}
	/**
	 * 设置：成功标志
	 */
	public void setSucInd(String sucInd) {
		this.sucInd = sucInd;
	}
	/**
	 * 获取：成功标志
	 */
	public String getSucInd() {
		return sucInd;
	}
	/**
	 * 设置：批量扣款序号
	 */
	public void setBatSeqNo(Long batSeqNo) {
		this.batSeqNo = batSeqNo;
	}
	/**
	 * 获取：批量扣款序号
	 */
	public Long getBatSeqNo() {
		return batSeqNo;
	}
	/**
	 * 设置：业务交易子流水号
	 */
	public void setSubTxlogSeq(Integer subTxlogSeq) {
		this.subTxlogSeq = subTxlogSeq;
	}
	/**
	 * 获取：业务交易子流水号
	 */
	public Integer getSubTxlogSeq() {
		return subTxlogSeq;
	}
}
