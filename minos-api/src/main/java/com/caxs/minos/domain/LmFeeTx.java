package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 记录费用交易记录
FUNC_ID: 功能编号，通过该编号可以知道该笔费用是放款时收的还是还款时收的等等
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmFeeTx implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 交易流水号
	 */
	private Long txLogSeq;
	/**
	 * 交易流水序号
	 */
	private Integer txLogSeqNo;
	/**
	 * 会计分录流水号
	 */
	private Long txNo;
	/**
	 * 会计分录子流水号
	 */
	private Integer seqNo;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 创建日期
	 */
	private String createDt;
	/**
	 * 创建用户
	 */
	private String createUsr;
	/**
	 * 费用金额
	 */
	private BigDecimal feeAmt;
	/**
	 * 费用代码
	 */
	private String feeCde;
	/**
	 * 币种
	 */
	private String ccyCde;
	/**
	 * 核算号
	 */
	private String ldgrCde;
	/**
	 * 核算序号
	 */
	private String ldgrCdeSeq;
	/**
	 * R: 收
P: 付
	 */
	private String recvPayInd;
	/**
	 * Y: 已冲正
N: 未冲正
	 */
	private String revseInd;
	/**
	 * 费用类型，关联P_FEE_TYP
	 */
	private String feeTyp;
	/**
	 * 基准金额
	 */
	private BigDecimal baseAmt;
	/**
	 * 费率
	 */
	private BigDecimal chrgPct;
	/**
	 * 交费日期
	 */
	private String setlDt;
	/**
	 * 冲正备注
	 */
	private String revseRmk;
	/**
	 * 金额类型，F01
	 */
	private String txAmtTyp;
	/**
	 * 交易码，transCode
	 */
	private String funcId;
	/**
	 * 费用备注
	 */
	private String feeRmk;
	/**
	 * ${column.comments}
	 */
	private BigDecimal srcTxLogSeq;
	/**
	 * ${column.comments}
	 */
	private BigDecimal srcSeqNo;
	/**
	 * 摊销金额类型
	 */
	private String accAmtTyp;
	/**
	 * 费用成本金额
	 */
	private BigDecimal feePriceAmt;

	/**
	 * 设置：交易流水号
	 */
	public void setTxLogSeq(Long txLogSeq) {
		this.txLogSeq = txLogSeq;
	}
	/**
	 * 获取：交易流水号
	 */
	public Long getTxLogSeq() {
		return txLogSeq;
	}
	/**
	 * 设置：交易流水序号
	 */
	public void setTxLogSeqNo(Integer txLogSeqNo) {
		this.txLogSeqNo = txLogSeqNo;
	}
	/**
	 * 获取：交易流水序号
	 */
	public Integer getTxLogSeqNo() {
		return txLogSeqNo;
	}
	/**
	 * 设置：会计分录流水号
	 */
	public void setTxNo(Long txNo) {
		this.txNo = txNo;
	}
	/**
	 * 获取：会计分录流水号
	 */
	public Long getTxNo() {
		return txNo;
	}
	/**
	 * 设置：会计分录子流水号
	 */
	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}
	/**
	 * 获取：会计分录子流水号
	 */
	public Integer getSeqNo() {
		return seqNo;
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
	 * 设置：创建日期
	 */
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	/**
	 * 获取：创建日期
	 */
	public String getCreateDt() {
		return createDt;
	}
	/**
	 * 设置：创建用户
	 */
	public void setCreateUsr(String createUsr) {
		this.createUsr = createUsr;
	}
	/**
	 * 获取：创建用户
	 */
	public String getCreateUsr() {
		return createUsr;
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
	 * 设置：核算号
	 */
	public void setLdgrCde(String ldgrCde) {
		this.ldgrCde = ldgrCde;
	}
	/**
	 * 获取：核算号
	 */
	public String getLdgrCde() {
		return ldgrCde;
	}
	/**
	 * 设置：核算序号
	 */
	public void setLdgrCdeSeq(String ldgrCdeSeq) {
		this.ldgrCdeSeq = ldgrCdeSeq;
	}
	/**
	 * 获取：核算序号
	 */
	public String getLdgrCdeSeq() {
		return ldgrCdeSeq;
	}
	/**
	 * 设置：R: 收
P: 付
	 */
	public void setRecvPayInd(String recvPayInd) {
		this.recvPayInd = recvPayInd;
	}
	/**
	 * 获取：R: 收
P: 付
	 */
	public String getRecvPayInd() {
		return recvPayInd;
	}
	/**
	 * 设置：Y: 已冲正
N: 未冲正
	 */
	public void setRevseInd(String revseInd) {
		this.revseInd = revseInd;
	}
	/**
	 * 获取：Y: 已冲正
N: 未冲正
	 */
	public String getRevseInd() {
		return revseInd;
	}
	/**
	 * 设置：费用类型，关联P_FEE_TYP
	 */
	public void setFeeTyp(String feeTyp) {
		this.feeTyp = feeTyp;
	}
	/**
	 * 获取：费用类型，关联P_FEE_TYP
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
	 * 设置：费率
	 */
	public void setChrgPct(BigDecimal chrgPct) {
		this.chrgPct = chrgPct;
	}
	/**
	 * 获取：费率
	 */
	public BigDecimal getChrgPct() {
		return chrgPct;
	}
	/**
	 * 设置：交费日期
	 */
	public void setSetlDt(String setlDt) {
		this.setlDt = setlDt;
	}
	/**
	 * 获取：交费日期
	 */
	public String getSetlDt() {
		return setlDt;
	}
	/**
	 * 设置：冲正备注
	 */
	public void setRevseRmk(String revseRmk) {
		this.revseRmk = revseRmk;
	}
	/**
	 * 获取：冲正备注
	 */
	public String getRevseRmk() {
		return revseRmk;
	}
	/**
	 * 设置：金额类型，F01
	 */
	public void setTxAmtTyp(String txAmtTyp) {
		this.txAmtTyp = txAmtTyp;
	}
	/**
	 * 获取：金额类型，F01
	 */
	public String getTxAmtTyp() {
		return txAmtTyp;
	}
	/**
	 * 设置：交易码，transCode
	 */
	public void setFuncId(String funcId) {
		this.funcId = funcId;
	}
	/**
	 * 获取：交易码，transCode
	 */
	public String getFuncId() {
		return funcId;
	}
	/**
	 * 设置：费用备注
	 */
	public void setFeeRmk(String feeRmk) {
		this.feeRmk = feeRmk;
	}
	/**
	 * 获取：费用备注
	 */
	public String getFeeRmk() {
		return feeRmk;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setSrcTxLogSeq(BigDecimal srcTxLogSeq) {
		this.srcTxLogSeq = srcTxLogSeq;
	}
	/**
	 * 获取：${column.comments}
	 */
	public BigDecimal getSrcTxLogSeq() {
		return srcTxLogSeq;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setSrcSeqNo(BigDecimal srcSeqNo) {
		this.srcSeqNo = srcSeqNo;
	}
	/**
	 * 获取：${column.comments}
	 */
	public BigDecimal getSrcSeqNo() {
		return srcSeqNo;
	}
	/**
	 * 设置：摊销金额类型
	 */
	public void setAccAmtTyp(String accAmtTyp) {
		this.accAmtTyp = accAmtTyp;
	}
	/**
	 * 获取：摊销金额类型
	 */
	public String getAccAmtTyp() {
		return accAmtTyp;
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
