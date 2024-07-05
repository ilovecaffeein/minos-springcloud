package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 01.LM_BAL_FEE_TX(费用余额表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmBalFeeTx implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 分支机构代码
	 */
	private String bchCde;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 是否商户/经销商
	 */
	private String isDealerCde;
	/**
	 * 费用代码
	 */
	private String feeCde;
	/**
	 * 费用币种
	 */
	private String feeCcyCde;
	/**
	 * 费用余额
	 */
	private BigDecimal feeAmt;
	/**
	 * 费用余额动账日
	 */
	private String lastFeeDt;
	/**
	 * 次末费用余额
	 */
	private BigDecimal feeAmtPrev;
	/**
	 * 次末余额动账日
	 */
	private String lastFeeDtPrev;
	/**
	 * 费用类型
	 */
	private String feeTyp;
	/**
	 * 收付类型
	 */
	private String recvPayInd;
	/**
	 * 费用计算方式
	 */
	private String feeCalcTyp;
	/**
	 * 计算基础
	 */
	private String feePctBase;
	/**
	 * 费用最小金额
	 */
	private BigDecimal feeMinAmt;
	/**
	 * 费用最大金额
	 */
	private BigDecimal feeMaxAmt;
	/**
	 * 基准金额
	 */
	private BigDecimal baseAmt;
	/**
	 * 费用比率
	 */
	private BigDecimal chrgPct;
	/**
	 * 是否周期性收费
	 */
	private String holdFeeInd;
	/**
	 * 费用收取频率单位
	 */
	private String paymFreqUnit;
	/**
	 * 费用收取频率
	 */
	private BigDecimal paymFreqFreq;
	/**
	 * 贷款品种代码
	 */
	private String loanTyp;
	/**
	 * 手续费递延标识
	 */
	private String feeDlay;
	/**
	 * 费用收付账户类型
	 */
	private String loanAcctTyp;
	/**
	 * 费用收付账号
	 */
	private String acctNo;
	/**
	 * 费用收付账号名
	 */
	private String acctName;
	/**
	 * 费用收付账户开机构号
	 */
	private String acctBchCde;
	/**
	 * 收费方式
	 */
	private String feeChanl;
	/**
	 * 业务类型
	 */
	private String bussTyp;
	/**
	 * 交易码
	 */
	private String funcId;
	/**
	 * 费用成本金额
	 */
	private BigDecimal feePriceAmt;

	/**
	 * 设置：分支机构代码
	 */
	public void setBchCde(String bchCde) {
		this.bchCde = bchCde;
	}
	/**
	 * 获取：分支机构代码
	 */
	public String getBchCde() {
		return bchCde;
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
	 * 设置：是否商户/经销商
	 */
	public void setIsDealerCde(String isDealerCde) {
		this.isDealerCde = isDealerCde;
	}
	/**
	 * 获取：是否商户/经销商
	 */
	public String getIsDealerCde() {
		return isDealerCde;
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
	 * 设置：费用余额
	 */
	public void setFeeAmt(BigDecimal feeAmt) {
		this.feeAmt = feeAmt;
	}
	/**
	 * 获取：费用余额
	 */
	public BigDecimal getFeeAmt() {
		return feeAmt;
	}
	/**
	 * 设置：费用余额动账日
	 */
	public void setLastFeeDt(String lastFeeDt) {
		this.lastFeeDt = lastFeeDt;
	}
	/**
	 * 获取：费用余额动账日
	 */
	public String getLastFeeDt() {
		return lastFeeDt;
	}
	/**
	 * 设置：次末费用余额
	 */
	public void setFeeAmtPrev(BigDecimal feeAmtPrev) {
		this.feeAmtPrev = feeAmtPrev;
	}
	/**
	 * 获取：次末费用余额
	 */
	public BigDecimal getFeeAmtPrev() {
		return feeAmtPrev;
	}
	/**
	 * 设置：次末余额动账日
	 */
	public void setLastFeeDtPrev(String lastFeeDtPrev) {
		this.lastFeeDtPrev = lastFeeDtPrev;
	}
	/**
	 * 获取：次末余额动账日
	 */
	public String getLastFeeDtPrev() {
		return lastFeeDtPrev;
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
	 * 设置：收付类型
	 */
	public void setRecvPayInd(String recvPayInd) {
		this.recvPayInd = recvPayInd;
	}
	/**
	 * 获取：收付类型
	 */
	public String getRecvPayInd() {
		return recvPayInd;
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
	 * 设置：计算基础
	 */
	public void setFeePctBase(String feePctBase) {
		this.feePctBase = feePctBase;
	}
	/**
	 * 获取：计算基础
	 */
	public String getFeePctBase() {
		return feePctBase;
	}
	/**
	 * 设置：费用最小金额
	 */
	public void setFeeMinAmt(BigDecimal feeMinAmt) {
		this.feeMinAmt = feeMinAmt;
	}
	/**
	 * 获取：费用最小金额
	 */
	public BigDecimal getFeeMinAmt() {
		return feeMinAmt;
	}
	/**
	 * 设置：费用最大金额
	 */
	public void setFeeMaxAmt(BigDecimal feeMaxAmt) {
		this.feeMaxAmt = feeMaxAmt;
	}
	/**
	 * 获取：费用最大金额
	 */
	public BigDecimal getFeeMaxAmt() {
		return feeMaxAmt;
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
	 * 设置：贷款品种代码
	 */
	public void setLoanTyp(String loanTyp) {
		this.loanTyp = loanTyp;
	}
	/**
	 * 获取：贷款品种代码
	 */
	public String getLoanTyp() {
		return loanTyp;
	}
	/**
	 * 设置：手续费递延标识
	 */
	public void setFeeDlay(String feeDlay) {
		this.feeDlay = feeDlay;
	}
	/**
	 * 获取：手续费递延标识
	 */
	public String getFeeDlay() {
		return feeDlay;
	}
	/**
	 * 设置：费用收付账户类型
	 */
	public void setLoanAcctTyp(String loanAcctTyp) {
		this.loanAcctTyp = loanAcctTyp;
	}
	/**
	 * 获取：费用收付账户类型
	 */
	public String getLoanAcctTyp() {
		return loanAcctTyp;
	}
	/**
	 * 设置：费用收付账号
	 */
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	/**
	 * 获取：费用收付账号
	 */
	public String getAcctNo() {
		return acctNo;
	}
	/**
	 * 设置：费用收付账号名
	 */
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	/**
	 * 获取：费用收付账号名
	 */
	public String getAcctName() {
		return acctName;
	}
	/**
	 * 设置：费用收付账户开机构号
	 */
	public void setAcctBchCde(String acctBchCde) {
		this.acctBchCde = acctBchCde;
	}
	/**
	 * 获取：费用收付账户开机构号
	 */
	public String getAcctBchCde() {
		return acctBchCde;
	}
	/**
	 * 设置：收费方式
	 */
	public void setFeeChanl(String feeChanl) {
		this.feeChanl = feeChanl;
	}
	/**
	 * 获取：收费方式
	 */
	public String getFeeChanl() {
		return feeChanl;
	}
	/**
	 * 设置：业务类型
	 */
	public void setBussTyp(String bussTyp) {
		this.bussTyp = bussTyp;
	}
	/**
	 * 获取：业务类型
	 */
	public String getBussTyp() {
		return bussTyp;
	}
	/**
	 * 设置：交易码
	 */
	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}
	/**
	 * 获取：交易码
	 */
	public String getFuncId() {
		return funcId;
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
}
