package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * FEE_CHRG_PCT_BASE(费用计算比例基础选项)：期供金额、贷款金额、未付本金、未付本金+未付利息
FEE_TYP(费用类型): 在能用代码中定义,用以区分一些特别的标志，如印花税、提前还款费用等等
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
public class PFeeTyp implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 银行代码
	 */
	private String bankCde;
	/**
	 * 费用代码
	 */
	private String feeCde;
	/**
	 * 费用类型
	 */
	private String feeTyp;
	/**
	 * 费用描述
	 */
	private String feeDesc;
	/**
	 * 固定金额
	 */
	private BigDecimal feeFixAmt;
	/**
	 * 最小金额
	 */
	private BigDecimal feeMinFee;
	/**
	 * 最大金额
	 */
	private BigDecimal feeMaxFee;
	/**
	 * 默认费用比例
	 */
	private BigDecimal feePct;
	/**
	 * 费用计算比例基础选项
	 */
	private String feePctBase;
	/**
	 * 费用规则代码
	 */
	private String feeFormula;
	/**
	 * 参数有效状态
	 */
	private String feeStatus;
	/**
	 * 最新变更时间
	 */
	private String lastChgDt;
	/**
	 * 最新变更用户
	 */
	private String lastChgUsr;
	/**
	 * 费用计算类型
	 */
	private String feeActionTyp;
	/**
	 * 费用收取条件
	 */
	private String feeCondOpt;
	/**
	 * 费用收取操作符
	 */
	private String feeOperOpt;
	/**
	 * 费用收取天数
	 */
	private Integer feeDay;
	/**
	 * 放款月数标识
	 */
	private String feeLoanMth;
	/**
	 * 费用按期收取类型
	 */
	private String feeTnrType;
	/**
	 * 费用收取期限开始
	 */
	private Integer feeTnr;
	/**
	 * 费用收取期限结束
	 */
	private Integer feeTnrEnd;
	/**
	 * ${column.comments}
	 */
	private String feeAmtTyp;
	/**
	 * ${column.comments}
	 */
	private String feeTermEnd;
	/**
	 * ${column.comments}
	 */
	private String feeTermStart;
	/**
	 * 摊销标示
	 */
	private String accInd;
	/**
	 * 摊销科目
	 */
	private String accAmtTyp;

	/**
	 * 设置：银行代码
	 */
	public void setBankCde(String bankCde) {
		this.bankCde = bankCde;
	}
	/**
	 * 获取：银行代码
	 */
	public String getBankCde() {
		return bankCde;
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
	 * 设置：费用描述
	 */
	public void setFeeDesc(String feeDesc) {
		this.feeDesc = feeDesc;
	}
	/**
	 * 获取：费用描述
	 */
	public String getFeeDesc() {
		return feeDesc;
	}
	/**
	 * 设置：固定金额
	 */
	public void setFeeFixAmt(BigDecimal feeFixAmt) {
		this.feeFixAmt = feeFixAmt;
	}
	/**
	 * 获取：固定金额
	 */
	public BigDecimal getFeeFixAmt() {
		return feeFixAmt;
	}
	/**
	 * 设置：最小金额
	 */
	public void setFeeMinFee(BigDecimal feeMinFee) {
		this.feeMinFee = feeMinFee;
	}
	/**
	 * 获取：最小金额
	 */
	public BigDecimal getFeeMinFee() {
		return feeMinFee;
	}
	/**
	 * 设置：最大金额
	 */
	public void setFeeMaxFee(BigDecimal feeMaxFee) {
		this.feeMaxFee = feeMaxFee;
	}
	/**
	 * 获取：最大金额
	 */
	public BigDecimal getFeeMaxFee() {
		return feeMaxFee;
	}
	/**
	 * 设置：默认费用比例
	 */
	public void setFeePct(BigDecimal feePct) {
		this.feePct = feePct;
	}
	/**
	 * 获取：默认费用比例
	 */
	public BigDecimal getFeePct() {
		return feePct;
	}
	/**
	 * 设置：费用计算比例基础选项
	 */
	public void setFeePctBase(String feePctBase) {
		this.feePctBase = feePctBase;
	}
	/**
	 * 获取：费用计算比例基础选项
	 */
	public String getFeePctBase() {
		return feePctBase;
	}
	/**
	 * 设置：费用规则代码
	 */
	public void setFeeFormula(String feeFormula) {
		this.feeFormula = feeFormula;
	}
	/**
	 * 获取：费用规则代码
	 */
	public String getFeeFormula() {
		return feeFormula;
	}
	/**
	 * 设置：参数有效状态
	 */
	public void setFeeStatus(String feeStatus) {
		this.feeStatus = feeStatus;
	}
	/**
	 * 获取：参数有效状态
	 */
	public String getFeeStatus() {
		return feeStatus;
	}
	/**
	 * 设置：最新变更时间
	 */
	public void setLastChgDt(String lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	/**
	 * 获取：最新变更时间
	 */
	public String getLastChgDt() {
		return lastChgDt;
	}
	/**
	 * 设置：最新变更用户
	 */
	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr;
	}
	/**
	 * 获取：最新变更用户
	 */
	public String getLastChgUsr() {
		return lastChgUsr;
	}
	/**
	 * 设置：费用计算类型
	 */
	public void setFeeActionTyp(String feeActionTyp) {
		this.feeActionTyp = feeActionTyp;
	}
	/**
	 * 获取：费用计算类型
	 */
	public String getFeeActionTyp() {
		return feeActionTyp;
	}
	/**
	 * 设置：费用收取条件
	 */
	public void setFeeCondOpt(String feeCondOpt) {
		this.feeCondOpt = feeCondOpt;
	}
	/**
	 * 获取：费用收取条件
	 */
	public String getFeeCondOpt() {
		return feeCondOpt;
	}
	/**
	 * 设置：费用收取操作符
	 */
	public void setFeeOperOpt(String feeOperOpt) {
		this.feeOperOpt = feeOperOpt;
	}
	/**
	 * 获取：费用收取操作符
	 */
	public String getFeeOperOpt() {
		return feeOperOpt;
	}
	/**
	 * 设置：费用收取天数
	 */
	public void setFeeDay(Integer feeDay) {
		this.feeDay = feeDay;
	}
	/**
	 * 获取：费用收取天数
	 */
	public Integer getFeeDay() {
		return feeDay;
	}
	/**
	 * 设置：放款月数标识
	 */
	public void setFeeLoanMth(String feeLoanMth) {
		this.feeLoanMth = feeLoanMth;
	}
	/**
	 * 获取：放款月数标识
	 */
	public String getFeeLoanMth() {
		return feeLoanMth;
	}
	/**
	 * 设置：费用按期收取类型
	 */
	public void setFeeTnrType(String feeTnrType) {
		this.feeTnrType = feeTnrType;
	}
	/**
	 * 获取：费用按期收取类型
	 */
	public String getFeeTnrType() {
		return feeTnrType;
	}
	/**
	 * 设置：费用收取期限开始
	 */
	public void setFeeTnr(Integer feeTnr) {
		this.feeTnr = feeTnr;
	}
	/**
	 * 获取：费用收取期限开始
	 */
	public Integer getFeeTnr() {
		return feeTnr;
	}
	/**
	 * 设置：费用收取期限结束
	 */
	public void setFeeTnrEnd(Integer feeTnrEnd) {
		this.feeTnrEnd = feeTnrEnd;
	}
	/**
	 * 获取：费用收取期限结束
	 */
	public Integer getFeeTnrEnd() {
		return feeTnrEnd;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setFeeAmtTyp(String feeAmtTyp) {
		this.feeAmtTyp = feeAmtTyp;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getFeeAmtTyp() {
		return feeAmtTyp;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setFeeTermEnd(String feeTermEnd) {
		this.feeTermEnd = feeTermEnd;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getFeeTermEnd() {
		return feeTermEnd;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setFeeTermStart(String feeTermStart) {
		this.feeTermStart = feeTermStart;
	}
	/**
	 * 获取：${column.comments}
	 */
	public String getFeeTermStart() {
		return feeTermStart;
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
	 * 设置：摊销科目
	 */
	public void setAccAmtTyp(String accAmtTyp) {
		this.accAmtTyp = accAmtTyp;
	}
	/**
	 * 获取：摊销科目
	 */
	public String getAccAmtTyp() {
		return accAmtTyp;
	}

	public PFeeTyp() {

	}

	public PFeeTyp(String feeCde ,String feeTyp) {
		this.feeCde = feeCde;
		this.feeTyp = feeTyp;
	}

	public PFeeTyp(String bankCde, String feeCde ,String feeTyp) {
        this.bankCde = bankCde;
		this.feeCde = feeCde;
		this.feeTyp = feeTyp;
	}
}
