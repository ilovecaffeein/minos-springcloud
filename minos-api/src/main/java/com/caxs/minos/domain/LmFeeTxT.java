package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 0061.LM_FEE_TX_T(费用授权信息)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmFeeTxT implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 出账授权编号
	 */
	private String genGlNo;
	/**
	 * 交易流水序号
	 */
	private BigDecimal txLogSeqNo;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 费用代码
	 */
	private String feeCde;
	/**
	 * 费用币种
	 */
	private String feeCcyCde;
	/**
	 * 费用金额
	 */
	private BigDecimal feeAmt;
	/**
	 * 收付标志
	 */
	private String recvPayInd;
	/**
	 * 费用类型
	 */
	private String feeTyp;
	/**
	 * 基准金额
	 */
	private BigDecimal baseAmt;
	/**
	 * 费用比率
	 */
	private BigDecimal chrgPct;
	/**
	 * 交易流水号
	 */
	private BigDecimal txLogSeq;
	/**
	 * 结清日期
	 */
	private String feeSetlDt;
	/**
	 * 备注
	 */
	private String feeRmk;
	/**
	 * 是否周期性收费
	 */
	private String holdFeeInd;
	/**
	 * 收费日期
	 */
	private String holdFeeSetlDt;
	/**
	 * 生成分录标志
	 */
	private String genGlInd;
	/**
	 * 费用收取频率
	 */
	private BigDecimal paymFreqFreq;
	/**
	 * 费用收取期数
	 */
	private BigDecimal feeSpan;
	/**
	 * 费用收取账户
	 */
	private String loanAcctTyp;
	/**
	 * 扣费日
	 */
	private BigDecimal dueDay;
	/**
	 * 费用计算方式
	 */
	private String feeCalcTyp;
	/**
	 * 费用收取频率单位
	 */
	private String paymFreqUnit;
	/**
	 * ${column.comments}
	 */
	private BigDecimal feeMinAmt;
	/**
	 * ${column.comments}
	 */
	private BigDecimal feeMaxAmt;
	/**
	 * 费用收取开始期号
	 */
	private BigDecimal feeStrPerdNo;
	/**
	 * 01-贷款金额
02-剩余本金
03-还款本金
04-还款本息
05-欠款金额

	 */
	private String feePctBase;
	/**
	 * 是否按周期均摊
	 */
	private String calcAccInd;
	/**
	 * 摊销标示
	 */
	private String accInd;
	/**
	 * 费用成本金额
	 */
	private BigDecimal feePriceAmt;

	/**
	 * 设置：出账授权编号
	 */
	public void setGenGlNo(String genGlNo) {
		this.genGlNo = genGlNo;
	}
	/**
	 * 获取：出账授权编号
	 */
	public String getGenGlNo() {
		return genGlNo;
	}
	/**
	 * 设置：交易流水序号
	 */
	public void setTxLogSeqNo(BigDecimal txLogSeqNo) {
		this.txLogSeqNo = txLogSeqNo;
	}
	/**
	 * 获取：交易流水序号
	 */
	public BigDecimal getTxLogSeqNo() {
		return txLogSeqNo;
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
	 * 设置：费用代码
	 */
	public void setFeeCde(String feeCde) {
		this.feeCde = feeCde;
	}
	/**
	 * 获取：费用代码
	 */
	public String getFeeCde() {
		return feeCde;
	}
	/**
	 * 设置：费用币种
	 */
	public void setFeeCcyCde(String feeCcyCde) {
		this.feeCcyCde = feeCcyCde;
	}
	/**
	 * 获取：费用币种
	 */
	public String getFeeCcyCde() {
		return feeCcyCde;
	}
	/**
	 * 设置：费用金额
	 */
	public void setFeeAmt(BigDecimal feeAmt) {
		this.feeAmt = feeAmt;
	}
	/**
	 * 获取：费用金额
	 */
	public BigDecimal getFeeAmt() {
		return feeAmt;
	}
	/**
	 * 设置：收付标志
	 */
	public void setRecvPayInd(String recvPayInd) {
		this.recvPayInd = recvPayInd;
	}
	/**
	 * 获取：收付标志
	 */
	public String getRecvPayInd() {
		return recvPayInd;
	}
	/**
	 * 设置：费用类型
	 */
	public void setFeeTyp(String feeTyp) {
		this.feeTyp = feeTyp;
	}
	/**
	 * 获取：费用类型
	 */
	public String getFeeTyp() {
		return feeTyp;
	}
	/**
	 * 设置：基准金额
	 */
	public void setBaseAmt(BigDecimal baseAmt) {
		this.baseAmt = baseAmt;
	}
	/**
	 * 获取：基准金额
	 */
	public BigDecimal getBaseAmt() {
		return baseAmt;
	}
	/**
	 * 设置：费用比率
	 */
	public void setChrgPct(BigDecimal chrgPct) {
		this.chrgPct = chrgPct;
	}
	/**
	 * 获取：费用比率
	 */
	public BigDecimal getChrgPct() {
		return chrgPct;
	}
	/**
	 * 设置：交易流水号
	 */
	public void setTxLogSeq(BigDecimal txLogSeq) {
		this.txLogSeq = txLogSeq;
	}
	/**
	 * 获取：交易流水号
	 */
	public BigDecimal getTxLogSeq() {
		return txLogSeq;
	}
	/**
	 * 设置：结清日期
	 */
	public void setFeeSetlDt(String feeSetlDt) {
		this.feeSetlDt = feeSetlDt;
	}
	/**
	 * 获取：结清日期
	 */
	public String getFeeSetlDt() {
		return feeSetlDt;
	}
	/**
	 * 设置：备注
	 */
	public void setFeeRmk(String feeRmk) {
		this.feeRmk = feeRmk;
	}
	/**
	 * 获取：备注
	 */
	public String getFeeRmk() {
		return feeRmk;
	}
	/**
	 * 设置：是否周期性收费
	 */
	public void setHoldFeeInd(String holdFeeInd) {
		this.holdFeeInd = holdFeeInd;
	}
	/**
	 * 获取：是否周期性收费
	 */
	public String getHoldFeeInd() {
		return holdFeeInd;
	}
	/**
	 * 设置：收费日期
	 */
	public void setHoldFeeSetlDt(String holdFeeSetlDt) {
		this.holdFeeSetlDt = holdFeeSetlDt;
	}
	/**
	 * 获取：收费日期
	 */
	public String getHoldFeeSetlDt() {
		return holdFeeSetlDt;
	}
	/**
	 * 设置：生成分录标志
	 */
	public void setGenGlInd(String genGlInd) {
		this.genGlInd = genGlInd;
	}
	/**
	 * 获取：生成分录标志
	 */
	public String getGenGlInd() {
		return genGlInd;
	}
	/**
	 * 设置：费用收取频率
	 */
	public void setPaymFreqFreq(BigDecimal paymFreqFreq) {
		this.paymFreqFreq = paymFreqFreq;
	}
	/**
	 * 获取：费用收取频率
	 */
	public BigDecimal getPaymFreqFreq() {
		return paymFreqFreq;
	}
	/**
	 * 设置：费用收取期数
	 */
	public void setFeeSpan(BigDecimal feeSpan) {
		this.feeSpan = feeSpan;
	}
	/**
	 * 获取：费用收取期数
	 */
	public BigDecimal getFeeSpan() {
		return feeSpan;
	}
	/**
	 * 设置：费用收取账户
	 */
	public void setLoanAcctTyp(String loanAcctTyp) {
		this.loanAcctTyp = loanAcctTyp;
	}
	/**
	 * 获取：费用收取账户
	 */
	public String getLoanAcctTyp() {
		return loanAcctTyp;
	}
	/**
	 * 设置：扣费日
	 */
	public void setDueDay(BigDecimal dueDay) {
		this.dueDay = dueDay;
	}
	/**
	 * 获取：扣费日
	 */
	public BigDecimal getDueDay() {
		return dueDay;
	}
	/**
	 * 设置：费用计算方式
	 */
	public void setFeeCalcTyp(String feeCalcTyp) {
		this.feeCalcTyp = feeCalcTyp;
	}
	/**
	 * 获取：费用计算方式
	 */
	public String getFeeCalcTyp() {
		return feeCalcTyp;
	}
	/**
	 * 设置：费用收取频率单位
	 */
	public void setPaymFreqUnit(String paymFreqUnit) {
		this.paymFreqUnit = paymFreqUnit;
	}
	/**
	 * 获取：费用收取频率单位
	 */
	public String getPaymFreqUnit() {
		return paymFreqUnit;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setFeeMinAmt(BigDecimal feeMinAmt) {
		this.feeMinAmt = feeMinAmt;
	}
	/**
	 * 获取：${column.comments}
	 */
	public BigDecimal getFeeMinAmt() {
		return feeMinAmt;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setFeeMaxAmt(BigDecimal feeMaxAmt) {
		this.feeMaxAmt = feeMaxAmt;
	}
	/**
	 * 获取：${column.comments}
	 */
	public BigDecimal getFeeMaxAmt() {
		return feeMaxAmt;
	}
	/**
	 * 设置：费用收取开始期号
	 */
	public void setFeeStrPerdNo(BigDecimal feeStrPerdNo) {
		this.feeStrPerdNo = feeStrPerdNo;
	}
	/**
	 * 获取：费用收取开始期号
	 */
	public BigDecimal getFeeStrPerdNo() {
		return feeStrPerdNo;
	}
	/**
	 * 设置：01-贷款金额
02-剩余本金
03-还款本金
04-还款本息
05-欠款金额

	 */
	public void setFeePctBase(String feePctBase) {
		this.feePctBase = feePctBase;
	}
	/**
	 * 获取：01-贷款金额
02-剩余本金
03-还款本金
04-还款本息
05-欠款金额

	 */
	public String getFeePctBase() {
		return feePctBase;
	}
	/**
	 * 设置：是否按周期均摊
	 */
	public void setCalcAccInd(String calcAccInd) {
		this.calcAccInd = calcAccInd;
	}
	/**
	 * 获取：是否按周期均摊
	 */
	public String getCalcAccInd() {
		return calcAccInd;
	}
	/**
	 * 设置：摊销标示
	 */
	public void setAccInd(String accInd) {
		this.accInd = accInd;
	}
	/**
	 * 获取：摊销标示
	 */
	public String getAccInd() {
		return accInd;
	}
	/**
	 * 设置：费用成本金额
	 */
	public void setFeePriceAmt(BigDecimal feePriceAmt) {
		this.feePriceAmt = feePriceAmt;
	}
	/**
	 * 获取：费用成本金额
	 */
	public BigDecimal getFeePriceAmt() {
		return feePriceAmt;
	}

	public LmFeeTxT() {
	}

	public LmFeeTxT(String genGlNo) {
		this.genGlNo = genGlNo;
	}
}
