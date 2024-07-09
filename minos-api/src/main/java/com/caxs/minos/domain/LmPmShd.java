package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 每月应还的还款计划，包括本金、利息、贴息等。
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
public class LmPmShd implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 期号
	 */
	private Integer psPerdNo;
	/**
	 * 到期日
	 */
	private String psDueDt;
	/**
	 * 账单日
	 */
	private String psBillDt;
	/**
	 * 贴息利率
	 */
	private BigDecimal sbsyRate;
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
	 * 贴息金额
	 */
	private BigDecimal sbsyIntAmt;
	/**
	 * 费用金额
	 */
	private BigDecimal psFeeAmt;
	/**
	 * 逾期费用金额
	 */
	private BigDecimal psOdIntFeeAmt;
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
	 * 已计提正常利息
	 */
	private BigDecimal psIncTaken;
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
	 * 已还逾期费用罚息
	 */
	private BigDecimal setlOdIntFeeAmt;
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
	 * 代偿期供金额
	 */
	private BigDecimal dcInstmAmt;
	/**
	 * 代偿本金
	 */
	private BigDecimal dcPrcpAmt;
	/**
	 * 代偿正常利息
	 */
	private BigDecimal dcNormIntAmt;
	/**
	 * 代偿逾期利息
	 */
	private BigDecimal dcOdIntAmt;
	/**
	 * 代偿复利
	 */
	private BigDecimal dcCommOdInt;
	/**
	 * 是否代偿标志
	 */
	private String dcInd;
	/**
	 * 还款模式
	 */
	private String setlMode;
	/**
	 * 经销商代偿日期
	 */
	private String accpIssueDt;
	/**
	 * 客户是否归还代偿
	 */
	private String accInd;
	/**
	 * 垫付退还日期
	 */
	private String dftfDt;
	/**
	 * 垫付退还金额
	 */
	private BigDecimal dftfAmt;
	/**
	 * 退还代偿本金
	 */
	private BigDecimal dftfPrcpAmt;
	/**
	 * 退还代偿正常利息
	 */
	private BigDecimal dftfNormIntAmt;
	/**
	 * 退还代偿逾期利息
	 */
	private BigDecimal dftfOdIntAmt;
	/**
	 * 退还代偿复利
	 */
	private BigDecimal dftfCommOdIntAmt;
	/**
	 * 处理分页数据标志
	 */
	private String prcsPageDtInd;
	/**
	 * 代偿类型
	 */
	private String dcTyp;

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
	public void setPsPerdNo(Integer psPerdNo) {
		this.psPerdNo = psPerdNo;
	}
	/**
	 * 获取：期号
	 */
	public Integer getPsPerdNo() {
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
	 * 设置：贴息金额
	 */
	public void setSbsyIntAmt(BigDecimal sbsyIntAmt) {
		this.sbsyIntAmt = sbsyIntAmt;
	}
	/**
	 * 获取：贴息金额
	 */
	public BigDecimal getSbsyIntAmt() {
		return sbsyIntAmt;
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
	 * 获取：逾期费用金额
	 */
	public void setPsOdIntFeeAmt(BigDecimal psOdIntFeeAmt) {
		this.psOdIntFeeAmt = psOdIntFeeAmt;
	}
	/**
	 * 设置：逾期费用金额
	 */
	public BigDecimal getPsOdIntFeeAmt() {
		return psOdIntFeeAmt;
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
	 * 获取：已还逾期费用金额
	 */
	public BigDecimal getSetlOdIntFeeAmt() {
		return setlOdIntFeeAmt;
	}
	/**
	 * 设置：已还逾期费用金额
	 */
	public void setSetlOdIntFeeAmt(BigDecimal setlOdIntFeeAmt) {
		this.setlOdIntFeeAmt = setlOdIntFeeAmt;
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
	/**
	 * 设置：代偿期供金额
	 */
	public void setDcInstmAmt(BigDecimal dcInstmAmt) {
		this.dcInstmAmt = dcInstmAmt;
	}
	/**
	 * 获取：代偿期供金额
	 */
	public BigDecimal getDcInstmAmt() {
		return dcInstmAmt;
	}
	/**
	 * 设置：代偿本金
	 */
	public void setDcPrcpAmt(BigDecimal dcPrcpAmt) {
		this.dcPrcpAmt = dcPrcpAmt;
	}
	/**
	 * 获取：代偿本金
	 */
	public BigDecimal getDcPrcpAmt() {
		return dcPrcpAmt;
	}
	/**
	 * 设置：代偿正常利息
	 */
	public void setDcNormIntAmt(BigDecimal dcNormIntAmt) {
		this.dcNormIntAmt = dcNormIntAmt;
	}
	/**
	 * 获取：代偿正常利息
	 */
	public BigDecimal getDcNormIntAmt() {
		return dcNormIntAmt;
	}
	/**
	 * 设置：代偿逾期利息
	 */
	public void setDcOdIntAmt(BigDecimal dcOdIntAmt) {
		this.dcOdIntAmt = dcOdIntAmt;
	}
	/**
	 * 获取：代偿逾期利息
	 */
	public BigDecimal getDcOdIntAmt() {
		return dcOdIntAmt;
	}
	/**
	 * 设置：代偿复利
	 */
	public void setDcCommOdInt(BigDecimal dcCommOdInt) {
		this.dcCommOdInt = dcCommOdInt;
	}
	/**
	 * 获取：代偿复利
	 */
	public BigDecimal getDcCommOdInt() {
		return dcCommOdInt;
	}
	/**
	 * 设置：是否代偿标志
	 */
	public void setDcInd(String dcInd) {
		this.dcInd = dcInd;
	}
	/**
	 * 获取：是否代偿标志
	 */
	public String getDcInd() {
		return dcInd;
	}
	/**
	 * 设置：还款模式
	 */
	public void setSetlMode(String setlMode) {
		this.setlMode = setlMode;
	}
	/**
	 * 获取：还款模式
	 */
	public String getSetlMode() {
		return setlMode;
	}
	/**
	 * 设置：经销商代偿日期
	 */
	public void setAccpIssueDt(String accpIssueDt) {
		this.accpIssueDt = accpIssueDt;
	}
	/**
	 * 获取：经销商代偿日期
	 */
	public String getAccpIssueDt() {
		return accpIssueDt;
	}
	/**
	 * 设置：客户是否归还代偿
	 */
	public void setAccInd(String accInd) {
		this.accInd = accInd;
	}
	/**
	 * 获取：客户是否归还代偿
	 */
	public String getAccInd() {
		return accInd;
	}
	/**
	 * 设置：垫付退还日期
	 */
	public void setDftfDt(String dftfDt) {
		this.dftfDt = dftfDt;
	}
	/**
	 * 获取：垫付退还日期
	 */
	public String getDftfDt() {
		return dftfDt;
	}
	/**
	 * 设置：垫付退还金额
	 */
	public void setDftfAmt(BigDecimal dftfAmt) {
		this.dftfAmt = dftfAmt;
	}
	/**
	 * 获取：垫付退还金额
	 */
	public BigDecimal getDftfAmt() {
		return dftfAmt;
	}
	/**
	 * 设置：退还代偿本金
	 */
	public void setDftfPrcpAmt(BigDecimal dftfPrcpAmt) {
		this.dftfPrcpAmt = dftfPrcpAmt;
	}
	/**
	 * 获取：退还代偿本金
	 */
	public BigDecimal getDftfPrcpAmt() {
		return dftfPrcpAmt;
	}
	/**
	 * 设置：退还代偿正常利息
	 */
	public void setDftfNormIntAmt(BigDecimal dftfNormIntAmt) {
		this.dftfNormIntAmt = dftfNormIntAmt;
	}
	/**
	 * 获取：退还代偿正常利息
	 */
	public BigDecimal getDftfNormIntAmt() {
		return dftfNormIntAmt;
	}
	/**
	 * 设置：退还代偿逾期利息
	 */
	public void setDftfOdIntAmt(BigDecimal dftfOdIntAmt) {
		this.dftfOdIntAmt = dftfOdIntAmt;
	}
	/**
	 * 获取：退还代偿逾期利息
	 */
	public BigDecimal getDftfOdIntAmt() {
		return dftfOdIntAmt;
	}
	/**
	 * 设置：退还代偿复利
	 */
	public void setDftfCommOdIntAmt(BigDecimal dftfCommOdIntAmt) {
		this.dftfCommOdIntAmt = dftfCommOdIntAmt;
	}
	/**
	 * 获取：退还代偿复利
	 */
	public BigDecimal getDftfCommOdIntAmt() {
		return dftfCommOdIntAmt;
	}
	/**
	 * 设置：处理分页数据标志
	 */
	public void setPrcsPageDtInd(String prcsPageDtInd) {
		this.prcsPageDtInd = prcsPageDtInd;
	}
	/**
	 * 获取：处理分页数据标志
	 */
	public String getPrcsPageDtInd() {
		return prcsPageDtInd;
	}
	/**
	 * 设置：代偿类型
	 */
	public void setDcTyp(String dcTyp) {
		this.dcTyp = dcTyp;
	}
	/**
	 * 获取：代偿类型
	 */
	public String getDcTyp() {
		return dcTyp;
	}

	public LmPmShd (){
	}

	public LmPmShd (String loanNo){
		this.loanNo =loanNo;
	}

	public LmPmShd (String loanNo, Integer psPerdNo){
		this.loanNo =loanNo;
		this.psPerdNo = psPerdNo;
	}
}
