package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 还款计划表的备份表，当还款计划表涉及调整时都会先备份到该表中。
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmPmShdHist implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 流水序号
	 */
	private Long seqNo;
	/**
	 * 交易号
	 */
	private Long txNo;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 期号
	 */
	private Long psPerdNo;
	/**
	 * 到期日
	 */
	private String psDueDt;
	/**
	 * 账单日
	 */
	private String psBillDt;
	/**
	 * 期供金额
	 */
	private BigDecimal psInstmAmt;
	/**
	 * 本金
	 */
	private BigDecimal psPrcpAmt;
	/**
	 * 正常利息
	 */
	private BigDecimal psNormIntAmt;
	/**
	 * 逾期利息
	 */
	private BigDecimal psOdIntAmt;
	/**
	 * 复利
	 */
	private BigDecimal psCommOdInt;
	/**
	 * 费用金额
	 */
	private BigDecimal psFeeAmt;
	/**
	 * 追加罚息
	 */
	private BigDecimal extOdIntAmt;
	/**
	 * 贴息
	 */
	private BigDecimal sbsyIntAmt;
	/**
	 * 本金积数
	 */
	private BigDecimal prodPrcpAmt;
	/**
	 * 利息积数
	 */
	private BigDecimal prodIntAmt;
	/**
	 * 复利积数
	 */
	private BigDecimal prodCommIntAmt;
	/**
	 * 费用积数
	 */
	private BigDecimal prodFeeAmt;
	/**
	 * 剩余本金
	 */
	private BigDecimal psRemPrcp;
	/**
	 * 已还本金
	 */
	private BigDecimal setlPrcp;
	/**
	 * 已还利息
	 */
	private BigDecimal setlNormInt;
	/**
	 * 已还逾期利息
	 */
	private BigDecimal setlOdIntAmt;
	/**
	 * 已还复利
	 */
	private BigDecimal setlCommOdInt;
	/**
	 * 已还费用金额
	 */
	private BigDecimal setlFeeAmt;
	/**
	 * 已还罚息计提金额
	 */
	private BigDecimal setlOdIncTaken;
	/**
	 * 已还利息计提金额
	 */
	private BigDecimal setlIncTaken;
	/**
	 * 贷款执行利率
	 */
	private BigDecimal psIntRate;
	/**
	 * 贴息利率
	 */
	private BigDecimal sbsyRate;
	/**
	 * 罚息利率
	 */
	private BigDecimal psOdIntRate;
	/**
	 * 逾期标志
	 */
	private String psOdInd;
	/**
	 * 最近还款日
	 */
	private String lastSetlDt;
	/**
	 * 已计提正常利息
	 */
	private BigDecimal psIncTaken;
	/**
	 * 已计提逾期利息
	 */
	private BigDecimal psOdIncTaken;
	/**
	 * 减免本金金额
	 */
	private BigDecimal psWvPrcpAmt;
	/**
	 * 减免正常利息
	 */
	private BigDecimal psWvNmInt;
	/**
	 * 减免逾期利息
	 */
	private BigDecimal psWvOdInt;
	/**
	 * 减免复利
	 */
	private BigDecimal psWvCommInt;
	/**
	 * 本金状态
	 */
	private String prcpState;
	/**
	 * 利息状态
	 */
	private String intState;
	/**
	 * 结清标志
	 */
	private String setlInd;
	/**
	 * 上次结罚息日期
	 */
	private String commOdGenDt;
	/**
	 * 当期还款记录是否为主动还款
	 */
	private String ppErInd;
	/**
	 * 滚积数日期
	 */
	private String psGenProdDt;
	/**
	 * 当期逾期利息计提金额
	 */
	private BigDecimal psCurOdIncTaken;
	/**
	 * 宽限期本金积数
	 */
	private BigDecimal grcProdPrcp;
	/**
	 * 宽限期利息积数
	 */
	private BigDecimal grcProdInt;
	/**
	 * 宽限期复利积数
	 */
	private BigDecimal grcProdComm;

	/**
	 * 设置：流水序号
	 */
	public void setSeqNo(Long seqNo) {
		this.seqNo = seqNo;
	}
	/**
	 * 获取：流水序号
	 */
	public Long getSeqNo() {
		return seqNo;
	}
	/**
	 * 设置：交易号
	 */
	public void setTxNo(Long txNo) {
		this.txNo = txNo;
	}
	/**
	 * 获取：交易号
	 */
	public Long getTxNo() {
		return txNo;
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
	 * 设置：期号
	 */
	public void setPsPerdNo(Long psPerdNo) {
		this.psPerdNo = psPerdNo;
	}
	/**
	 * 获取：期号
	 */
	public Long getPsPerdNo() {
		return psPerdNo;
	}
	/**
	 * 设置：到期日
	 */
	public void setPsDueDt(String psDueDt) {
		this.psDueDt = psDueDt;
	}
	/**
	 * 获取：到期日
	 */
	public String getPsDueDt() {
		return psDueDt;
	}
	/**
	 * 设置：账单日
	 */
	public void setPsBillDt(String psBillDt) {
		this.psBillDt = psBillDt;
	}
	/**
	 * 获取：账单日
	 */
	public String getPsBillDt() {
		return psBillDt;
	}
	/**
	 * 设置：期供金额
	 */
	public void setPsInstmAmt(BigDecimal psInstmAmt) {
		this.psInstmAmt = psInstmAmt;
	}
	/**
	 * 获取：期供金额
	 */
	public BigDecimal getPsInstmAmt() {
		return psInstmAmt;
	}
	/**
	 * 设置：本金
	 */
	public void setPsPrcpAmt(BigDecimal psPrcpAmt) {
		this.psPrcpAmt = psPrcpAmt;
	}
	/**
	 * 获取：本金
	 */
	public BigDecimal getPsPrcpAmt() {
		return psPrcpAmt;
	}
	/**
	 * 设置：正常利息
	 */
	public void setPsNormIntAmt(BigDecimal psNormIntAmt) {
		this.psNormIntAmt = psNormIntAmt;
	}
	/**
	 * 获取：正常利息
	 */
	public BigDecimal getPsNormIntAmt() {
		return psNormIntAmt;
	}
	/**
	 * 设置：逾期利息
	 */
	public void setPsOdIntAmt(BigDecimal psOdIntAmt) {
		this.psOdIntAmt = psOdIntAmt;
	}
	/**
	 * 获取：逾期利息
	 */
	public BigDecimal getPsOdIntAmt() {
		return psOdIntAmt;
	}
	/**
	 * 设置：复利
	 */
	public void setPsCommOdInt(BigDecimal psCommOdInt) {
		this.psCommOdInt = psCommOdInt;
	}
	/**
	 * 获取：复利
	 */
	public BigDecimal getPsCommOdInt() {
		return psCommOdInt;
	}
	/**
	 * 设置：费用金额
	 */
	public void setPsFeeAmt(BigDecimal psFeeAmt) {
		this.psFeeAmt = psFeeAmt;
	}
	/**
	 * 获取：费用金额
	 */
	public BigDecimal getPsFeeAmt() {
		return psFeeAmt;
	}
	/**
	 * 设置：追加罚息
	 */
	public void setExtOdIntAmt(BigDecimal extOdIntAmt) {
		this.extOdIntAmt = extOdIntAmt;
	}
	/**
	 * 获取：追加罚息
	 */
	public BigDecimal getExtOdIntAmt() {
		return extOdIntAmt;
	}
	/**
	 * 设置：贴息
	 */
	public void setSbsyIntAmt(BigDecimal sbsyIntAmt) {
		this.sbsyIntAmt = sbsyIntAmt;
	}
	/**
	 * 获取：贴息
	 */
	public BigDecimal getSbsyIntAmt() {
		return sbsyIntAmt;
	}
	/**
	 * 设置：本金积数
	 */
	public void setProdPrcpAmt(BigDecimal prodPrcpAmt) {
		this.prodPrcpAmt = prodPrcpAmt;
	}
	/**
	 * 获取：本金积数
	 */
	public BigDecimal getProdPrcpAmt() {
		return prodPrcpAmt;
	}
	/**
	 * 设置：利息积数
	 */
	public void setProdIntAmt(BigDecimal prodIntAmt) {
		this.prodIntAmt = prodIntAmt;
	}
	/**
	 * 获取：利息积数
	 */
	public BigDecimal getProdIntAmt() {
		return prodIntAmt;
	}
	/**
	 * 设置：复利积数
	 */
	public void setProdCommIntAmt(BigDecimal prodCommIntAmt) {
		this.prodCommIntAmt = prodCommIntAmt;
	}
	/**
	 * 获取：复利积数
	 */
	public BigDecimal getProdCommIntAmt() {
		return prodCommIntAmt;
	}
	/**
	 * 设置：费用积数
	 */
	public void setProdFeeAmt(BigDecimal prodFeeAmt) {
		this.prodFeeAmt = prodFeeAmt;
	}
	/**
	 * 获取：费用积数
	 */
	public BigDecimal getProdFeeAmt() {
		return prodFeeAmt;
	}
	/**
	 * 设置：剩余本金
	 */
	public void setPsRemPrcp(BigDecimal psRemPrcp) {
		this.psRemPrcp = psRemPrcp;
	}
	/**
	 * 获取：剩余本金
	 */
	public BigDecimal getPsRemPrcp() {
		return psRemPrcp;
	}
	/**
	 * 设置：已还本金
	 */
	public void setSetlPrcp(BigDecimal setlPrcp) {
		this.setlPrcp = setlPrcp;
	}
	/**
	 * 获取：已还本金
	 */
	public BigDecimal getSetlPrcp() {
		return setlPrcp;
	}
	/**
	 * 设置：已还利息
	 */
	public void setSetlNormInt(BigDecimal setlNormInt) {
		this.setlNormInt = setlNormInt;
	}
	/**
	 * 获取：已还利息
	 */
	public BigDecimal getSetlNormInt() {
		return setlNormInt;
	}
	/**
	 * 设置：已还逾期利息
	 */
	public void setSetlOdIntAmt(BigDecimal setlOdIntAmt) {
		this.setlOdIntAmt = setlOdIntAmt;
	}
	/**
	 * 获取：已还逾期利息
	 */
	public BigDecimal getSetlOdIntAmt() {
		return setlOdIntAmt;
	}
	/**
	 * 设置：已还复利
	 */
	public void setSetlCommOdInt(BigDecimal setlCommOdInt) {
		this.setlCommOdInt = setlCommOdInt;
	}
	/**
	 * 获取：已还复利
	 */
	public BigDecimal getSetlCommOdInt() {
		return setlCommOdInt;
	}
	/**
	 * 设置：已还费用金额
	 */
	public void setSetlFeeAmt(BigDecimal setlFeeAmt) {
		this.setlFeeAmt = setlFeeAmt;
	}
	/**
	 * 获取：已还费用金额
	 */
	public BigDecimal getSetlFeeAmt() {
		return setlFeeAmt;
	}
	/**
	 * 设置：已还罚息计提金额
	 */
	public void setSetlOdIncTaken(BigDecimal setlOdIncTaken) {
		this.setlOdIncTaken = setlOdIncTaken;
	}
	/**
	 * 获取：已还罚息计提金额
	 */
	public BigDecimal getSetlOdIncTaken() {
		return setlOdIncTaken;
	}
	/**
	 * 设置：已还利息计提金额
	 */
	public void setSetlIncTaken(BigDecimal setlIncTaken) {
		this.setlIncTaken = setlIncTaken;
	}
	/**
	 * 获取：已还利息计提金额
	 */
	public BigDecimal getSetlIncTaken() {
		return setlIncTaken;
	}
	/**
	 * 设置：贷款执行利率
	 */
	public void setPsIntRate(BigDecimal psIntRate) {
		this.psIntRate = psIntRate;
	}
	/**
	 * 获取：贷款执行利率
	 */
	public BigDecimal getPsIntRate() {
		return psIntRate;
	}
	/**
	 * 设置：贴息利率
	 */
	public void setSbsyRate(BigDecimal sbsyRate) {
		this.sbsyRate = sbsyRate;
	}
	/**
	 * 获取：贴息利率
	 */
	public BigDecimal getSbsyRate() {
		return sbsyRate;
	}
	/**
	 * 设置：罚息利率
	 */
	public void setPsOdIntRate(BigDecimal psOdIntRate) {
		this.psOdIntRate = psOdIntRate;
	}
	/**
	 * 获取：罚息利率
	 */
	public BigDecimal getPsOdIntRate() {
		return psOdIntRate;
	}
	/**
	 * 设置：逾期标志
	 */
	public void setPsOdInd(String psOdInd) {
		this.psOdInd = psOdInd;
	}
	/**
	 * 获取：逾期标志
	 */
	public String getPsOdInd() {
		return psOdInd;
	}
	/**
	 * 设置：最近还款日
	 */
	public void setLastSetlDt(String lastSetlDt) {
		this.lastSetlDt = lastSetlDt;
	}
	/**
	 * 获取：最近还款日
	 */
	public String getLastSetlDt() {
		return lastSetlDt;
	}
	/**
	 * 设置：已计提正常利息
	 */
	public void setPsIncTaken(BigDecimal psIncTaken) {
		this.psIncTaken = psIncTaken;
	}
	/**
	 * 获取：已计提正常利息
	 */
	public BigDecimal getPsIncTaken() {
		return psIncTaken;
	}
	/**
	 * 设置：已计提逾期利息
	 */
	public void setPsOdIncTaken(BigDecimal psOdIncTaken) {
		this.psOdIncTaken = psOdIncTaken;
	}
	/**
	 * 获取：已计提逾期利息
	 */
	public BigDecimal getPsOdIncTaken() {
		return psOdIncTaken;
	}
	/**
	 * 设置：减免本金金额
	 */
	public void setPsWvPrcpAmt(BigDecimal psWvPrcpAmt) {
		this.psWvPrcpAmt = psWvPrcpAmt;
	}
	/**
	 * 获取：减免本金金额
	 */
	public BigDecimal getPsWvPrcpAmt() {
		return psWvPrcpAmt;
	}
	/**
	 * 设置：减免正常利息
	 */
	public void setPsWvNmInt(BigDecimal psWvNmInt) {
		this.psWvNmInt = psWvNmInt;
	}
	/**
	 * 获取：减免正常利息
	 */
	public BigDecimal getPsWvNmInt() {
		return psWvNmInt;
	}
	/**
	 * 设置：减免逾期利息
	 */
	public void setPsWvOdInt(BigDecimal psWvOdInt) {
		this.psWvOdInt = psWvOdInt;
	}
	/**
	 * 获取：减免逾期利息
	 */
	public BigDecimal getPsWvOdInt() {
		return psWvOdInt;
	}
	/**
	 * 设置：减免复利
	 */
	public void setPsWvCommInt(BigDecimal psWvCommInt) {
		this.psWvCommInt = psWvCommInt;
	}
	/**
	 * 获取：减免复利
	 */
	public BigDecimal getPsWvCommInt() {
		return psWvCommInt;
	}
	/**
	 * 设置：本金状态
	 */
	public void setPrcpState(String prcpState) {
		this.prcpState = prcpState;
	}
	/**
	 * 获取：本金状态
	 */
	public String getPrcpState() {
		return prcpState;
	}
	/**
	 * 设置：利息状态
	 */
	public void setIntState(String intState) {
		this.intState = intState;
	}
	/**
	 * 获取：利息状态
	 */
	public String getIntState() {
		return intState;
	}
	/**
	 * 设置：结清标志
	 */
	public void setSetlInd(String setlInd) {
		this.setlInd = setlInd;
	}
	/**
	 * 获取：结清标志
	 */
	public String getSetlInd() {
		return setlInd;
	}
	/**
	 * 设置：上次结罚息日期
	 */
	public void setCommOdGenDt(String commOdGenDt) {
		this.commOdGenDt = commOdGenDt;
	}
	/**
	 * 获取：上次结罚息日期
	 */
	public String getCommOdGenDt() {
		return commOdGenDt;
	}
	/**
	 * 设置：当期还款记录是否为主动还款
	 */
	public void setPpErInd(String ppErInd) {
		this.ppErInd = ppErInd;
	}
	/**
	 * 获取：当期还款记录是否为主动还款
	 */
	public String getPpErInd() {
		return ppErInd;
	}
	/**
	 * 设置：滚积数日期
	 */
	public void setPsGenProdDt(String psGenProdDt) {
		this.psGenProdDt = psGenProdDt;
	}
	/**
	 * 获取：滚积数日期
	 */
	public String getPsGenProdDt() {
		return psGenProdDt;
	}
	/**
	 * 设置：当期逾期利息计提金额
	 */
	public void setPsCurOdIncTaken(BigDecimal psCurOdIncTaken) {
		this.psCurOdIncTaken = psCurOdIncTaken;
	}
	/**
	 * 获取：当期逾期利息计提金额
	 */
	public BigDecimal getPsCurOdIncTaken() {
		return psCurOdIncTaken;
	}
	/**
	 * 设置：宽限期本金积数
	 */
	public void setGrcProdPrcp(BigDecimal grcProdPrcp) {
		this.grcProdPrcp = grcProdPrcp;
	}
	/**
	 * 获取：宽限期本金积数
	 */
	public BigDecimal getGrcProdPrcp() {
		return grcProdPrcp;
	}
	/**
	 * 设置：宽限期利息积数
	 */
	public void setGrcProdInt(BigDecimal grcProdInt) {
		this.grcProdInt = grcProdInt;
	}
	/**
	 * 获取：宽限期利息积数
	 */
	public BigDecimal getGrcProdInt() {
		return grcProdInt;
	}
	/**
	 * 设置：宽限期复利积数
	 */
	public void setGrcProdComm(BigDecimal grcProdComm) {
		this.grcProdComm = grcProdComm;
	}
	/**
	 * 获取：宽限期复利积数
	 */
	public BigDecimal getGrcProdComm() {
		return grcProdComm;
	}
}
