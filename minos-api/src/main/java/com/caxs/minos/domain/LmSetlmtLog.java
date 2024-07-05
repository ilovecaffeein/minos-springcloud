package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 记录当次还款交易的还款情况，如果一次交易归还多期情况，则该表中有一条记录，对应LM_PAYM_LOG有多条记录，从LM_PAYM_LOG中可看出归还了还款计划表中哪几期，以及归还了哪些部分的情况。
SETLMT_TYP: 还款类型 NM: 正常归还　TR: 第三方代偿 TB: 第三方回购 CO: 核销收回
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
public class LmSetlmtLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 处理业务类型
	 */
	private String bussTyp;
	/**
	 * 会计分录流水号
	 */
	private Long txNo;
	/**
	 * 交易流水号
	 */
	private Long txLogSeq;

	private Long txlogNo;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 原贷款状态
	 */
	private String oldDebtSts;
	/**
	 * 新贷款状态
	 */
	private String newDebtSts;
	/**
	 * 还款模式
	 */
	private String setlMode;
	/**
	 * 还款类型
	 */
	private String setlTyp;
	/**
	 * 收到金额
	 */
	private BigDecimal setlRecvAmt;
	/**
	 * 生效日期
	 */
	private String setlValDt;
	/**
	 * 冲正标志
	 */
	private String setlRevseInd;
	/**
	 * 创建日期
	 */
	private String setlCreateDt;
	/**
	 * 创建用户
	 */
	private String setlCreateUsr;
	/**
	 * 归还欠本金额
	 */
	private BigDecimal setlOdPrcpAmt;
	/**
	 * 归还正常利息金额
	 */
	private BigDecimal setlIntAmt;
	/**
	 * 归还罚息金额
	 */
	private BigDecimal setlOdIntAmt;
	/**
	 * 归还复利金额
	 */
	private BigDecimal setlOdCommInt;
	/**
	 * 归还费用金额
	 */
	private BigDecimal setlFeeAmt;
	/**
	 * 提前还本金额
	 */
	private BigDecimal setlRemPrcpPaym;
	/**
	 * 冲正备注
	 */
	private String setlRevseRmk;
	/**
	 * 冲正交易号
	 */
	private Integer setlRevseTxNo;
	/**
	 * 冲正日期
	 */
	private String setlRevseDt;
	/**
	 * 冲正用户
	 */
	private String setlRevseUsr;
	/**
	 * 利息计算到
	 */
	private String setlFpaidIntOpt;
	/**
	 * 应计利息
	 */
	private BigDecimal setlAccInt;
	/**
	 * 代偿标志
	 */
	private String setlCompInd;
	/**
	 * 是否允许只还本金
	 */
	private String setlPrcpInd;
	/**
	 * 生成会计分录标志
	 */
	private String genGlInd;
	/**
	 * 还款后期数
	 */
	private Integer paymPerdCnt;
	/**
	 * 补记罚息标志
	 */
	private String apdProdInd;
	/**
	 * 提前还款利息选项
	 */
	private String ppRatBase;
	/**
	 * 提前还款后的首次还款日
	 */
	private String firstPayDt;
	/**
	 * 在清偿模式下的实际还款金额
	 */
	private BigDecimal trueRecvAmt;
	/**
	 * 凭证号
	 */
	private String inputProof;
	/**
	 * 凭证类型
	 */
	private String inputProofType;
	/**
	 * 最后还款日期
	 */
	private String lastPayDt;
	/**
	 * 新期供金额
	 */
	private BigDecimal newInstmAmt;
	/**
	 * 提前划款附加利息
	 */
	private BigDecimal ppPayIntAmt;
	/**
	 * 贷款执行利率
	 */
	private BigDecimal loanIntRate;
	/**
	 * 是否清偿还款
	 */
	private String clearOweInd;
	/**
	 * 本金科目
	 */
	private String prcpGlCde;
	/**
	 * 01:股权置换
02: 票据置换
03: 其它置换
	 */
	private String dpTyp;
	/**
	 * 期次
	 */
	private Integer psPerdNo;
	/**
	 * 账单日
	 */
	private String psBillDt;
	/**
	 * 拆分账单类型
	 */
	private String psMode;
	/**
	 * 是否线上线下标识：Y：线上，N：线下
	 */
	private String olInd;
	/**
	 * 扣款渠道
	 */
	private String pchCde;

	/**
	 * 设置：处理业务类型
	 */
	public void setBussTyp(String bussTyp) {
		this.bussTyp = bussTyp;
	}
	/**
	 * 获取：处理业务类型
	 */
	public String getBussTyp() {
		return bussTyp;
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
	 * 设置：会计分录流水号
	 */
	public void setTxlogNo(Long txlogNo) {
		this.txlogNo = txlogNo;
	}
	/**
	 * 获取：会计分录流水号
	 */
	public Long getTxlogNo() {
		return txlogNo;
	}
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
	 * 设置：原贷款状态
	 */
	public void setOldDebtSts(String oldDebtSts) {
		this.oldDebtSts = oldDebtSts;
	}
	/**
	 * 获取：原贷款状态
	 */
	public String getOldDebtSts() {
		return oldDebtSts;
	}
	/**
	 * 设置：新贷款状态
	 */
	public void setNewDebtSts(String newDebtSts) {
		this.newDebtSts = newDebtSts;
	}
	/**
	 * 获取：新贷款状态
	 */
	public String getNewDebtSts() {
		return newDebtSts;
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
	 * 设置：还款类型
	 */
	public void setSetlTyp(String setlTyp) {
		this.setlTyp = setlTyp;
	}
	/**
	 * 获取：还款类型
	 */
	public String getSetlTyp() {
		return setlTyp;
	}
	/**
	 * 设置：收到金额
	 */
	public void setSetlRecvAmt(BigDecimal setlRecvAmt) {
		this.setlRecvAmt = setlRecvAmt;
	}
	/**
	 * 获取：收到金额
	 */
	public BigDecimal getSetlRecvAmt() {
		return setlRecvAmt;
	}
	/**
	 * 设置：生效日期
	 */
	public void setSetlValDt(String setlValDt) {
		this.setlValDt = setlValDt;
	}
	/**
	 * 获取：生效日期
	 */
	public String getSetlValDt() {
		return setlValDt;
	}
	/**
	 * 设置：冲正标志
	 */
	public void setSetlRevseInd(String setlRevseInd) {
		this.setlRevseInd = setlRevseInd;
	}
	/**
	 * 获取：冲正标志
	 */
	public String getSetlRevseInd() {
		return setlRevseInd;
	}
	/**
	 * 设置：创建日期
	 */
	public void setSetlCreateDt(String setlCreateDt) {
		this.setlCreateDt = setlCreateDt;
	}
	/**
	 * 获取：创建日期
	 */
	public String getSetlCreateDt() {
		return setlCreateDt;
	}
	/**
	 * 设置：创建用户
	 */
	public void setSetlCreateUsr(String setlCreateUsr) {
		this.setlCreateUsr = setlCreateUsr;
	}
	/**
	 * 获取：创建用户
	 */
	public String getSetlCreateUsr() {
		return setlCreateUsr;
	}
	/**
	 * 设置：归还欠本金额
	 */
	public void setSetlOdPrcpAmt(BigDecimal setlOdPrcpAmt) {
		this.setlOdPrcpAmt = setlOdPrcpAmt;
	}
	/**
	 * 获取：归还欠本金额
	 */
	public BigDecimal getSetlOdPrcpAmt() {
		return setlOdPrcpAmt;
	}
	/**
	 * 设置：归还正常利息金额
	 */
	public void setSetlIntAmt(BigDecimal setlIntAmt) {
		this.setlIntAmt = setlIntAmt;
	}
	/**
	 * 获取：归还正常利息金额
	 */
	public BigDecimal getSetlIntAmt() {
		return setlIntAmt;
	}
	/**
	 * 设置：归还罚息金额
	 */
	public void setSetlOdIntAmt(BigDecimal setlOdIntAmt) {
		this.setlOdIntAmt = setlOdIntAmt;
	}
	/**
	 * 获取：归还罚息金额
	 */
	public BigDecimal getSetlOdIntAmt() {
		return setlOdIntAmt;
	}
	/**
	 * 设置：归还复利金额
	 */
	public void setSetlOdCommInt(BigDecimal setlOdCommInt) {
		this.setlOdCommInt = setlOdCommInt;
	}
	/**
	 * 获取：归还复利金额
	 */
	public BigDecimal getSetlOdCommInt() {
		return setlOdCommInt;
	}
	/**
	 * 设置：归还费用金额
	 */
	public void setSetlFeeAmt(BigDecimal setlFeeAmt) {
		this.setlFeeAmt = setlFeeAmt;
	}
	/**
	 * 获取：归还费用金额
	 */
	public BigDecimal getSetlFeeAmt() {
		return setlFeeAmt;
	}
	/**
	 * 设置：提前还本金额
	 */
	public void setSetlRemPrcpPaym(BigDecimal setlRemPrcpPaym) {
		this.setlRemPrcpPaym = setlRemPrcpPaym;
	}
	/**
	 * 获取：提前还本金额
	 */
	public BigDecimal getSetlRemPrcpPaym() {
		return setlRemPrcpPaym;
	}
	/**
	 * 设置：冲正备注
	 */
	public void setSetlRevseRmk(String setlRevseRmk) {
		this.setlRevseRmk = setlRevseRmk;
	}
	/**
	 * 获取：冲正备注
	 */
	public String getSetlRevseRmk() {
		return setlRevseRmk;
	}
	/**
	 * 设置：冲正交易号
	 */
	public void setSetlRevseTxNo(Integer setlRevseTxNo) {
		this.setlRevseTxNo = setlRevseTxNo;
	}
	/**
	 * 获取：冲正交易号
	 */
	public Integer getSetlRevseTxNo() {
		return setlRevseTxNo;
	}
	/**
	 * 设置：冲正日期
	 */
	public void setSetlRevseDt(String setlRevseDt) {
		this.setlRevseDt = setlRevseDt;
	}
	/**
	 * 获取：冲正日期
	 */
	public String getSetlRevseDt() {
		return setlRevseDt;
	}
	/**
	 * 设置：冲正用户
	 */
	public void setSetlRevseUsr(String setlRevseUsr) {
		this.setlRevseUsr = setlRevseUsr;
	}
	/**
	 * 获取：冲正用户
	 */
	public String getSetlRevseUsr() {
		return setlRevseUsr;
	}
	/**
	 * 设置：利息计算到
	 */
	public void setSetlFpaidIntOpt(String setlFpaidIntOpt) {
		this.setlFpaidIntOpt = setlFpaidIntOpt;
	}
	/**
	 * 获取：利息计算到
	 */
	public String getSetlFpaidIntOpt() {
		return setlFpaidIntOpt;
	}
	/**
	 * 设置：应计利息
	 */
	public void setSetlAccInt(BigDecimal setlAccInt) {
		this.setlAccInt = setlAccInt;
	}
	/**
	 * 获取：应计利息
	 */
	public BigDecimal getSetlAccInt() {
		return setlAccInt;
	}
	/**
	 * 设置：代偿标志
	 */
	public void setSetlCompInd(String setlCompInd) {
		this.setlCompInd = setlCompInd;
	}
	/**
	 * 获取：代偿标志
	 */
	public String getSetlCompInd() {
		return setlCompInd;
	}
	/**
	 * 设置：是否允许只还本金
	 */
	public void setSetlPrcpInd(String setlPrcpInd) {
		this.setlPrcpInd = setlPrcpInd;
	}
	/**
	 * 获取：是否允许只还本金
	 */
	public String getSetlPrcpInd() {
		return setlPrcpInd;
	}
	/**
	 * 设置：生成会计分录标志
	 */
	public void setGenGlInd(String genGlInd) {
		this.genGlInd = genGlInd;
	}
	/**
	 * 获取：生成会计分录标志
	 */
	public String getGenGlInd() {
		return genGlInd;
	}
	/**
	 * 设置：还款后期数
	 */
	public void setPaymPerdCnt(Integer paymPerdCnt) {
		this.paymPerdCnt = paymPerdCnt;
	}
	/**
	 * 获取：还款后期数
	 */
	public Integer getPaymPerdCnt() {
		return paymPerdCnt;
	}
	/**
	 * 设置：补记罚息标志
	 */
	public void setApdProdInd(String apdProdInd) {
		this.apdProdInd = apdProdInd;
	}
	/**
	 * 获取：补记罚息标志
	 */
	public String getApdProdInd() {
		return apdProdInd;
	}
	/**
	 * 设置：提前还款利息选项
	 */
	public void setPpRatBase(String ppRatBase) {
		this.ppRatBase = ppRatBase;
	}
	/**
	 * 获取：提前还款利息选项
	 */
	public String getPpRatBase() {
		return ppRatBase;
	}
	/**
	 * 设置：提前还款后的首次还款日
	 */
	public void setFirstPayDt(String firstPayDt) {
		this.firstPayDt = firstPayDt;
	}
	/**
	 * 获取：提前还款后的首次还款日
	 */
	public String getFirstPayDt() {
		return firstPayDt;
	}
	/**
	 * 设置：在清偿模式下的实际还款金额
	 */
	public void setTrueRecvAmt(BigDecimal trueRecvAmt) {
		this.trueRecvAmt = trueRecvAmt;
	}
	/**
	 * 获取：在清偿模式下的实际还款金额
	 */
	public BigDecimal getTrueRecvAmt() {
		return trueRecvAmt;
	}
	/**
	 * 设置：凭证号
	 */
	public void setInputProof(String inputProof) {
		this.inputProof = inputProof;
	}
	/**
	 * 获取：凭证号
	 */
	public String getInputProof() {
		return inputProof;
	}
	/**
	 * 设置：凭证类型
	 */
	public void setInputProofType(String inputProofType) {
		this.inputProofType = inputProofType;
	}
	/**
	 * 获取：凭证类型
	 */
	public String getInputProofType() {
		return inputProofType;
	}
	/**
	 * 设置：最后还款日期
	 */
	public void setLastPayDt(String lastPayDt) {
		this.lastPayDt = lastPayDt;
	}
	/**
	 * 获取：最后还款日期
	 */
	public String getLastPayDt() {
		return lastPayDt;
	}
	/**
	 * 设置：新期供金额
	 */
	public void setNewInstmAmt(BigDecimal newInstmAmt) {
		this.newInstmAmt = newInstmAmt;
	}
	/**
	 * 获取：新期供金额
	 */
	public BigDecimal getNewInstmAmt() {
		return newInstmAmt;
	}
	/**
	 * 设置：提前划款附加利息
	 */
	public void setPpPayIntAmt(BigDecimal ppPayIntAmt) {
		this.ppPayIntAmt = ppPayIntAmt;
	}
	/**
	 * 获取：提前划款附加利息
	 */
	public BigDecimal getPpPayIntAmt() {
		return ppPayIntAmt;
	}
	/**
	 * 设置：贷款执行利率
	 */
	public void setLoanIntRate(BigDecimal loanIntRate) {
		this.loanIntRate = loanIntRate;
	}
	/**
	 * 获取：贷款执行利率
	 */
	public BigDecimal getLoanIntRate() {
		return loanIntRate;
	}
	/**
	 * 设置：是否清偿还款
	 */
	public void setClearOweInd(String clearOweInd) {
		this.clearOweInd = clearOweInd;
	}
	/**
	 * 获取：是否清偿还款
	 */
	public String getClearOweInd() {
		return clearOweInd;
	}
	/**
	 * 设置：本金科目
	 */
	public void setPrcpGlCde(String prcpGlCde) {
		this.prcpGlCde = prcpGlCde;
	}
	/**
	 * 获取：本金科目
	 */
	public String getPrcpGlCde() {
		return prcpGlCde;
	}
	/**
	 * 设置：01:股权置换
02: 票据置换
03: 其它置换
	 */
	public void setDpTyp(String dpTyp) {
		this.dpTyp = dpTyp;
	}
	/**
	 * 获取：01:股权置换
02: 票据置换
03: 其它置换
	 */
	public String getDpTyp() {
		return dpTyp;
	}
	/**
	 * 设置：期次
	 */
	public void setPsPerdNo(Integer psPerdNo) {
		this.psPerdNo = psPerdNo;
	}
	/**
	 * 获取：期次
	 */
	public Integer getPsPerdNo() {
		return psPerdNo;
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
	 * 设置：拆分账单类型
	 */
	public void setPsMode(String psMode) {
		this.psMode = psMode;
	}
	/**
	 * 获取：拆分账单类型
	 */
	public String getPsMode() {
		return psMode;
	}
	/**
	 * 设置：是否线上线下标识：Y：线上，N：线下
	 */
	public void setOlInd(String olInd) {
		this.olInd = olInd;
	}
	/**
	 * 获取：是否线上线下标识：Y：线上，N：线下
	 */
	public String getOlInd() {
		return olInd;
	}
	/**
	 * 设置：扣款渠道
	 */
	public void setPchCde(String pchCde) {
		this.pchCde = pchCde;
	}
	/**
	 * 获取：扣款渠道
	 */
	public String getPchCde() {
		return pchCde;
	}

	public LmSetlmtLog(){
	}
	public LmSetlmtLog(Long txNo){
		this.txNo = txNo;
	}
}
