package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 按期结算出罚息放入该表，包括从什么时候结算到什么时候，应收罚息及已收罚息、是表内还是表外等等信息。
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-24 15:47:03
 */
public class LmOdIntLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 期号
	 */
	private Integer perdNo;
	/**
	 * 交易流水
	 */
	private Integer txLogSeq;
	/**
	 * 序号
	 */
	private Integer seqNo;
	/**
	 * 交易日期
	 */
	private String txDt;
	/**
	 * 利率
	 */
	private BigDecimal odRate;
	/**
	 * 计算基数
	 */
	private BigDecimal odOsAmt;
	/**
	 * 从日期
	 */
	private String odFromDt;
	/**
	 * 到日期
	 */
	private String odToDt;
	/**
	 * 罚息金额
	 */
	private BigDecimal odIntAmt;
	/**
	 * 本金部分还是利息部分
	 */
	private String odIntAmtPart;
	/**
	 * 计算部分
	 */
	private String odIntIntType;
	/**
	 * 减免罚息
	 */
	private BigDecimal odIntWvInt;
	/**
	 * 表内表外标志
	 */
	private String odIntOffBsInd;
	/**
	 * 起息日
	 */
	private String odIntStartDt;
	/**
	 * 本金积数
	 */
	private BigDecimal prcpProd;
	/**
	 * 利息积数
	 */
	private BigDecimal intProd;
	/**
	 * 复利积数
	 */
	private BigDecimal commProd;

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
	 * 设置：期号
	 */
	public void setPerdNo(Integer perdNo) {
		this.perdNo = perdNo;
	}
	/**
	 * 获取：期号
	 */
	public Integer getPerdNo() {
		return perdNo;
	}
	/**
	 * 设置：交易流水
	 */
	public void setTxLogSeq(Integer txLogSeq) {
		this.txLogSeq = txLogSeq;
	}
	/**
	 * 获取：交易流水
	 */
	public Integer getTxLogSeq() {
		return txLogSeq;
	}
	/**
	 * 设置：序号
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	/**
	 * 获取：序号
	 */
	public Integer getSeqNo() {
		return seqNo;
	}
	/**
	 * 设置：交易日期
	 */
	public void setTxDt(String txDt) {
		this.txDt = txDt;
	}
	/**
	 * 获取：交易日期
	 */
	public String getTxDt() {
		return txDt;
	}
	/**
	 * 设置：利率
	 */
	public void setOdRate(BigDecimal odRate) {
		this.odRate = odRate;
	}
	/**
	 * 获取：利率
	 */
	public BigDecimal getOdRate() {
		return odRate;
	}
	/**
	 * 设置：计算基数
	 */
	public void setOdOsAmt(BigDecimal odOsAmt) {
		this.odOsAmt = odOsAmt;
	}
	/**
	 * 获取：计算基数
	 */
	public BigDecimal getOdOsAmt() {
		return odOsAmt;
	}
	/**
	 * 设置：从日期
	 */
	public void setOdFromDt(String odFromDt) {
		this.odFromDt = odFromDt;
	}
	/**
	 * 获取：从日期
	 */
	public String getOdFromDt() {
		return odFromDt;
	}
	/**
	 * 设置：到日期
	 */
	public void setOdToDt(String odToDt) {
		this.odToDt = odToDt;
	}
	/**
	 * 获取：到日期
	 */
	public String getOdToDt() {
		return odToDt;
	}
	/**
	 * 设置：罚息金额
	 */
	public void setOdIntAmt(BigDecimal odIntAmt) {
		this.odIntAmt = odIntAmt;
	}
	/**
	 * 获取：罚息金额
	 */
	public BigDecimal getOdIntAmt() {
		return odIntAmt;
	}
	/**
	 * 设置：本金部分还是利息部分
	 */
	public void setOdIntAmtPart(String odIntAmtPart) {
		this.odIntAmtPart = odIntAmtPart;
	}
	/**
	 * 获取：本金部分还是利息部分
	 */
	public String getOdIntAmtPart() {
		return odIntAmtPart;
	}
	/**
	 * 设置：计算部分
	 */
	public void setOdIntIntType(String odIntIntType) {
		this.odIntIntType = odIntIntType;
	}
	/**
	 * 获取：计算部分
	 */
	public String getOdIntIntType() {
		return odIntIntType;
	}
	/**
	 * 设置：减免罚息
	 */
	public void setOdIntWvInt(BigDecimal odIntWvInt) {
		this.odIntWvInt = odIntWvInt;
	}
	/**
	 * 获取：减免罚息
	 */
	public BigDecimal getOdIntWvInt() {
		return odIntWvInt;
	}
	/**
	 * 设置：表内表外标志
	 */
	public void setOdIntOffBsInd(String odIntOffBsInd) {
		this.odIntOffBsInd = odIntOffBsInd;
	}
	/**
	 * 获取：表内表外标志
	 */
	public String getOdIntOffBsInd() {
		return odIntOffBsInd;
	}
	/**
	 * 设置：起息日
	 */
	public void setOdIntStartDt(String odIntStartDt) {
		this.odIntStartDt = odIntStartDt;
	}
	/**
	 * 获取：起息日
	 */
	public String getOdIntStartDt() {
		return odIntStartDt;
	}
	/**
	 * 设置：本金积数
	 */
	public void setPrcpProd(BigDecimal prcpProd) {
		this.prcpProd = prcpProd;
	}
	/**
	 * 获取：本金积数
	 */
	public BigDecimal getPrcpProd() {
		return prcpProd;
	}
	/**
	 * 设置：利息积数
	 */
	public void setIntProd(BigDecimal intProd) {
		this.intProd = intProd;
	}
	/**
	 * 获取：利息积数
	 */
	public BigDecimal getIntProd() {
		return intProd;
	}
	/**
	 * 设置：复利积数
	 */
	public void setCommProd(BigDecimal commProd) {
		this.commProd = commProd;
	}
	/**
	 * 获取：复利积数
	 */
	public BigDecimal getCommProd() {
		return commProd;
	}

	/** full constructor */
	public LmOdIntLog(Integer txLogSeq, Integer seqNo,String loanNo, Integer perdNo,
					  String txDt, BigDecimal odRate, BigDecimal odOsAmt, String odFromDt,
					  String odToDt, BigDecimal odIntAmt, String odIntAmtPart,
					  String odIntIntType, BigDecimal odIntWvInt, String odIntOffBsInd,
					  String odIntStartDt, BigDecimal prcpProd, BigDecimal intProd,
					  BigDecimal commProd) {
		this.txLogSeq = txLogSeq;
		this.seqNo = seqNo;
		this.loanNo = loanNo;
		this.perdNo = perdNo;
		this.txDt = txDt;
		this.odRate = odRate;
		this.odOsAmt = odOsAmt;
		this.odFromDt = odFromDt;
		this.odToDt = odToDt;
		this.odIntAmt = odIntAmt;
		this.odIntAmtPart = odIntAmtPart;
		this.odIntIntType = odIntIntType;
		this.odIntWvInt = odIntWvInt;
		this.odIntOffBsInd = odIntOffBsInd;
		this.odIntStartDt = odIntStartDt;
		this.prcpProd = prcpProd;
		this.intProd = intProd;
		this.commProd = commProd;
	}
}
