package com.caxs.minos.domain;

/**
 * LmPmShd entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class LmPmShdT implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7607704161124404623L;
	private LmPmShdTId id;				//还款计划授权主键
	private String psDueDt;				//到期日
	private Double psInstmAmt;			//期供
	private Double psPrcpAmt;			//应还本金
	private Double psNormIntAmt;		//应还利息
	private Double psOdIntAmt;			//应还逾期利息
	private Double psCommOdInt;			//应还复利
	private Double psFeeAmt;			//应还费用
	private Double prodPrcpAmt;			//本金积数
	private Double prodIntAmt;			//利息积数
	private Double prodCommIntAmt;		//复利积数
	private Long prodFeeAmt;			//费用积数
	private Double psRemPrcp;			//剩余本金
	private Double setlPrcp;			//已还本金
	private Double setlNormInt;			//已还正常利息
	private Double setlOdIntAmt;		//已还逾期利息
	private Double setlCommOdInt;		//已还复利
	private Double setlFeeAmt;			//已还费用
	private Double psIntRate;			//执行利率
	private Double psOdIntRate;			//逾期利率
	private String psOdInd;				//逾期标志
	private String lastSetlDt;			//最近还款日
	private Double psIncTaken;			//计提利息
	private Double psOdIncTaken;		//计提罚息
	private Double psWvPrcpAmt;			//减免本金
	private Double psWvNmInt;			//减免正常利息
	private Double psWvOdInt;			//减免罚息
	private Double psWvCommInt;			//减免复利
	private String prcpState;			//本金状态
	private String intState;			//利息状态
	private String setlInd;				//结清状态
	private String commOdGenDt;			//上次结罚息日期
	private String ppErInd;				//当期还款记录是否为主动还款
	private String psGenProdDt;			//滚积数日期
	private Double psCurOdIncTaken;		//当期逾期利息计提金额
	private Double sbsyIntAmt;			//贴息金额
	private String psBillDt;			//账单日
	private Double sbsyRate;			//贴息利率
	private Double grcProdPrcp;			//未结息罚息
	private Double grcProdInt;			//减值罚息
	private Double grcProdComm;			//减值复利
	private Double setlIncTaken;		//已结正常利息
	private Double setlOdIncTaken;		//已结罚息利息
	// Constructors

	
	/**
	 * 获取已结正常利息
	 * @return
	 */
	public Double getSetlIncTaken() {
		return setlIncTaken;
	}
	/**
	 * 已结正常利息
	 * @param setlIncTaken
	 */
	public void setSetlIncTaken(Double setlIncTaken) {
		this.setlIncTaken = setlIncTaken;
	}
	/*
	 * 获取已结罚息利息
	 */
	public Double getSetlOdIncTaken() {
		return setlOdIncTaken;
	}
	/**
	 * 设置已结罚息利息
	 * @param setlOdIncTaken
	 */
	public void setSetlOdIncTaken(Double setlOdIncTaken) {
		this.setlOdIncTaken = setlOdIncTaken;
	}
	/** default constructor */
	public LmPmShdT() {
	}

	/** minimal constructor */
	public LmPmShdT(LmPmShdTId id) {
		this.id = id;
	}

	/** full constructor */
	public LmPmShdT(LmPmShdTId id, String psDueDt, Double psInstmAmt,
			Double psPrcpAmt, Double psNormIntAmt, Double psOdIntAmt,
			Double psCommOdInt, Double psFeeAmt, Double prodPrcpAmt,
			Double prodIntAmt, Double prodCommIntAmt, Long prodFeeAmt,
			Double psRemPrcp, Double setlPrcp, Double setlNormInt,
			Double setlOdIntAmt, Double setlCommOdInt, Double setlFeeAmt,
			Double psIntRate, Double psOdIntRate, String psOdInd,
			String lastSetlDt, Double psIncTaken, Double psOdIncTaken,
			Double psWvPrcpAmt, Double psWvNmInt, Double psWvOdInt,
			Double psWvCommInt, String prcpState, String intState,
			String setlInd, String commOdGenDt, String ppErInd,
			String psGenProdDt, Double psCurOdIncTaken, Double sbsyIntAmt,
			String psBillDt, Double sbsyRate, Double grcProdPrcp,
			Double grcProdInt, Double grcProdComm) {
		this.id = id;
		this.psDueDt = psDueDt;
		this.psInstmAmt = psInstmAmt;
		this.psPrcpAmt = psPrcpAmt;
		this.psNormIntAmt = psNormIntAmt;
		this.psOdIntAmt = psOdIntAmt;
		this.psCommOdInt = psCommOdInt;
		this.psFeeAmt = psFeeAmt;
		this.prodPrcpAmt = prodPrcpAmt;
		this.prodIntAmt = prodIntAmt;
		this.prodCommIntAmt = prodCommIntAmt;
		this.prodFeeAmt = prodFeeAmt;
		this.psRemPrcp = psRemPrcp;
		this.setlPrcp = setlPrcp;
		this.setlNormInt = setlNormInt;
		this.setlOdIntAmt = setlOdIntAmt;
		this.setlCommOdInt = setlCommOdInt;
		this.setlFeeAmt = setlFeeAmt;
		this.psIntRate = psIntRate;
		this.psOdIntRate = psOdIntRate;
		this.psOdInd = psOdInd;
		this.lastSetlDt = lastSetlDt;
		this.psIncTaken = psIncTaken;
		this.psOdIncTaken = psOdIncTaken;
		this.psWvPrcpAmt = psWvPrcpAmt;
		this.psWvNmInt = psWvNmInt;
		this.psWvOdInt = psWvOdInt;
		this.psWvCommInt = psWvCommInt;
		this.prcpState = prcpState;
		this.intState = intState;
		this.setlInd = setlInd;
		this.commOdGenDt = commOdGenDt;
		this.ppErInd = ppErInd;
		this.psGenProdDt = psGenProdDt;
		this.psCurOdIncTaken = psCurOdIncTaken;
		this.sbsyIntAmt = sbsyIntAmt;
		this.psBillDt = psBillDt;
		this.sbsyRate = sbsyRate;
		this.grcProdPrcp = grcProdPrcp;
		this.grcProdInt = grcProdInt;
		this.grcProdComm = grcProdComm;
	}

	// Property accessors
	/**
	 * 获取还款计划授权主键
	 * @return
	 */
	public LmPmShdTId getId() {
		return this.id;
	}
	/**
	 * 设置主键
	 * @param id
	 */
	public void setId(LmPmShdTId id) {
		this.id = id;
	}

	/**
	 * 到期日
	 * @return
	 */
	public String getPsDueDt() {
		return this.psDueDt;
	}

	/**
	 * 到期日
	 * @param psDueDt
	 */
	public void setPsDueDt(String psDueDt) {
		this.psDueDt = psDueDt;
	}

	/**
	 * 期供
	 * @return
	 */
	public Double getPsInstmAmt() {
		return this.psInstmAmt;
	}

	/**
	 * 期供
	 * @param psInstmAmt
	 */
	public void setPsInstmAmt(Double psInstmAmt) {
		this.psInstmAmt = psInstmAmt;
	}

	/**
	 * 应还本金
	 * @return
	 */
	public Double getPsPrcpAmt() {
		return this.psPrcpAmt;
	}

	/**
	 * 应还本金
	 * @param psPrcpAmt
	 */
	public void setPsPrcpAmt(Double psPrcpAmt) {
		this.psPrcpAmt = psPrcpAmt;
	}

	/**
	 * 应还利息
	 * @return
	 */
	public Double getPsNormIntAmt() {
		return this.psNormIntAmt;
	}

	/**
	 * 应还利息
	 * @param psNormIntAmt
	 */
	public void setPsNormIntAmt(Double psNormIntAmt) {
		this.psNormIntAmt = psNormIntAmt;
	}

	/**
	 * 应还逾期利息
	 * @return
	 */
	public Double getPsOdIntAmt() {
		return this.psOdIntAmt;
	}

	/**
	 * 应还逾期利息
	 * @param psOdIntAmt
	 */
	public void setPsOdIntAmt(Double psOdIntAmt) {
		this.psOdIntAmt = psOdIntAmt;
	}

	/**
	 * 应还复利
	 * @return
	 */
	public Double getPsCommOdInt() {
		return this.psCommOdInt;
	}

	/**
	 * 应还复利
	 * @param psCommOdInt
	 */
	public void setPsCommOdInt(Double psCommOdInt) {
		this.psCommOdInt = psCommOdInt;
	}

	/**
	 * 应还费用
	 * @return
	 */
	public Double getPsFeeAmt() {
		return this.psFeeAmt;
	}

	/**
	 * 应还费用
	 * @param psFeeAmt
	 */
	public void setPsFeeAmt(Double psFeeAmt) {
		this.psFeeAmt = psFeeAmt;
	}

	/**
	 * 本金积数
	 * @return
	 */
	public Double getProdPrcpAmt() {
		return this.prodPrcpAmt;
	}

	/**
	 * 本金积数
	 * @param prodPrcpAmt
	 */
	public void setProdPrcpAmt(Double prodPrcpAmt) {
		this.prodPrcpAmt = prodPrcpAmt;
	}

	/**
	 * 利息积数
	 * @return
	 */
	public Double getProdIntAmt() {
		return this.prodIntAmt;
	}

	/**
	 * 利息积数
	 * @param prodIntAmt
	 */
	public void setProdIntAmt(Double prodIntAmt) {
		this.prodIntAmt = prodIntAmt;
	}

	/**
	 * 复利积数
	 * @return
	 */
	public Double getProdCommIntAmt() {
		return this.prodCommIntAmt;
	}

	/**
	 * 复利积数
	 * @param prodCommIntAmt
	 */
	public void setProdCommIntAmt(Double prodCommIntAmt) {
		this.prodCommIntAmt = prodCommIntAmt;
	}

	/**
	 * 费用积数
	 * @return
	 */
	public Long getProdFeeAmt() {
		return this.prodFeeAmt;
	}

	/**
	 * 费用积数
	 * @param prodFeeAmt
	 */
	public void setProdFeeAmt(Long prodFeeAmt) {
		this.prodFeeAmt = prodFeeAmt;
	}

	/**
	 * 剩余本金
	 * @return
	 */
	public Double getPsRemPrcp() {
		return this.psRemPrcp;
	}

	/**
	 * 剩余本金
	 * @param psRemPrcp
	 */
	public void setPsRemPrcp(Double psRemPrcp) {
		this.psRemPrcp = psRemPrcp;
	}

	/**
	 * 已还本金
	 * @return
	 */
	public Double getSetlPrcp() {
		return this.setlPrcp;
	}

	/**
	 * 已还本金
	 * @param setlPrcp
	 */
	public void setSetlPrcp(Double setlPrcp) {
		this.setlPrcp = setlPrcp;
	}

	/**
	 * 已还正常利息
	 * @return
	 */
	public Double getSetlNormInt() {
		return this.setlNormInt;
	}

	/**
	 * 已还正常利息
	 * @param setlNormInt
	 */
	public void setSetlNormInt(Double setlNormInt) {
		this.setlNormInt = setlNormInt;
	}

	/**
	 * 已还逾期利息
	 * @return
	 */
	public Double getSetlOdIntAmt() {
		return this.setlOdIntAmt;
	}

	/**
	 * 已还逾期利息
	 * @param setlOdIntAmt
	 */
	public void setSetlOdIntAmt(Double setlOdIntAmt) {
		this.setlOdIntAmt = setlOdIntAmt;
	}

	/**
	 * 已还复利
	 * @return
	 */
	public Double getSetlCommOdInt() {
		return this.setlCommOdInt;
	}

	/**
	 * 已还复利
	 * @param setlCommOdInt
	 */
	public void setSetlCommOdInt(Double setlCommOdInt) {
		this.setlCommOdInt = setlCommOdInt;
	}

	/**
	 * 已还费用
	 * @return
	 */
	public Double getSetlFeeAmt() {
		return this.setlFeeAmt;
	}

	/**
	 * 已还费用
	 * @param setlFeeAmt
	 */
	public void setSetlFeeAmt(Double setlFeeAmt) {
		this.setlFeeAmt = setlFeeAmt;
	}

	/**
	 * 执行利率
	 * @return
	 */
	public Double getPsIntRate() {
		return this.psIntRate;
	}

	/**
	 * 执行利率
	 * @param psIntRate
	 */
	public void setPsIntRate(Double psIntRate) {
		this.psIntRate = psIntRate;
	}

	/**
	 * 逾期利率
	 * @return
	 */
	public Double getPsOdIntRate() {
		return this.psOdIntRate;
	}

	/**
	 * 逾期利率
	 * @param psOdIntRate
	 */
	public void setPsOdIntRate(Double psOdIntRate) {
		this.psOdIntRate = psOdIntRate;
	}

	/**
	 * 逾期标志
	 * @return
	 */
	public String getPsOdInd() {
		return this.psOdInd;
	}

	/**
	 * 逾期标志
	 * @param psOdInd
	 */
	public void setPsOdInd(String psOdInd) {
		this.psOdInd = psOdInd;
	}

	/**
	 * 最近还款日
	 * @return
	 */
	public String getLastSetlDt() {
		return this.lastSetlDt;
	}

	/**
	 * 最近还款日
	 * @param lastSetlDt
	 */
	public void setLastSetlDt(String lastSetlDt) {
		this.lastSetlDt = lastSetlDt;
	}

	/**
	 * 计提利息
	 * @return
	 */
	public Double getPsIncTaken() {
		return this.psIncTaken;
	}

	/**
	 * 计提利息
	 * @param psIncTaken
	 */
	public void setPsIncTaken(Double psIncTaken) {
		this.psIncTaken = psIncTaken;
	}

	/**
	 * 计提罚息
	 * @return
	 */
	public Double getPsOdIncTaken() {
		return this.psOdIncTaken;
	}

	/**
	 * 计提罚息
	 * @param psOdIncTaken
	 */
	public void setPsOdIncTaken(Double psOdIncTaken) {
		this.psOdIncTaken = psOdIncTaken;
	}

	/**
	 * 减免本金
	 * @return
	 */
	public Double getPsWvPrcpAmt() {
		return this.psWvPrcpAmt;
	}

	/**
	 * 减免本金
	 * @param psWvPrcpAmt
	 */
	public void setPsWvPrcpAmt(Double psWvPrcpAmt) {
		this.psWvPrcpAmt = psWvPrcpAmt;
	}

	/**
	 * 减免正常利息
	 * @return
	 */
	public Double getPsWvNmInt() {
		return this.psWvNmInt;
	}

	/**
	 * 减免正常利息
	 * @param psWvNmInt
	 */
	public void setPsWvNmInt(Double psWvNmInt) {
		this.psWvNmInt = psWvNmInt;
	}

	/**
	 * 减免罚息
	 * @return
	 */
	public Double getPsWvOdInt() {
		return this.psWvOdInt;
	}

	/**
	 * 减免罚息
	 * @param psWvOdInt
	 */
	public void setPsWvOdInt(Double psWvOdInt) {
		this.psWvOdInt = psWvOdInt;
	}

	/**
	 * 减免复利
	 * @return
	 */
	public Double getPsWvCommInt() {
		return this.psWvCommInt;
	}

	/**
	 * 减免复利
	 * @param psWvCommInt
	 */
	public void setPsWvCommInt(Double psWvCommInt) {
		this.psWvCommInt = psWvCommInt;
	}

	/**
	 * 本金状态
	 * @return
	 */
	public String getPrcpState() {
		return this.prcpState;
	}

	/**
	 * 本金状态
	 * @param prcpState
	 */
	public void setPrcpState(String prcpState) {
		this.prcpState = prcpState;
	}

	/**
	 * 利息状态
	 * @return
	 */
	public String getIntState() {
		return this.intState;
	}

	/**
	 * 利息状态
	 * @param intState
	 */
	public void setIntState(String intState) {
		this.intState = intState;
	}

	/**
	 * 结清状态
	 * @return
	 */
	public String getSetlInd() {
		return this.setlInd;
	}

	/**
	 * 结清状态
	 * @param setlInd
	 */
	public void setSetlInd(String setlInd) {
		this.setlInd = setlInd;
	}

	/**
	 * 上次结罚息日期
	 * @return
	 */
	public String getCommOdGenDt() {
		return this.commOdGenDt;
	}

	/**
	 * 上次结罚息日期
	 * @param commOdGenDt
	 */
	public void setCommOdGenDt(String commOdGenDt) {
		this.commOdGenDt = commOdGenDt;
	}

	/**
	 * 当期还款记录是否为主动还款
	 * @return
	 */
	public String getPpErInd() {
		return this.ppErInd;
	}

	/**
	 * 当期还款记录是否为主动还款
	 * @param ppErInd
	 */
	public void setPpErInd(String ppErInd) {
		this.ppErInd = ppErInd;
	}

	/**
	 * 滚积数日期
	 * @return
	 */
	public String getPsGenProdDt() {
		return this.psGenProdDt;
	}

	/**
	 * 滚积数日期
	 * @param psGenProdDt
	 */
	public void setPsGenProdDt(String psGenProdDt) {
		this.psGenProdDt = psGenProdDt;
	}

	/**
	 * 当期逾期利息计提金额
	 * @return
	 */
	public Double getPsCurOdIncTaken() {
		return this.psCurOdIncTaken;
	}

	/**
	 * 当期逾期利息计提金额
	 * @param psCurOdIncTaken
	 */
	public void setPsCurOdIncTaken(Double psCurOdIncTaken) {
		this.psCurOdIncTaken = psCurOdIncTaken;
	}

	/**
	 * 贴息金额
	 * @return
	 */
	public Double getSbsyIntAmt() {
		return this.sbsyIntAmt;
	}

	/**
	 * 贴息金额
	 * @param sbsyIntAmt
	 */
	public void setSbsyIntAmt(Double sbsyIntAmt) {
		this.sbsyIntAmt = sbsyIntAmt;
	}

	/**
	 * 账单日
	 * @return
	 */
	public String getPsBillDt() {
		return this.psBillDt;
	}

	/**
	 * 账单日
	 * @param psBillDt
	 */
	public void setPsBillDt(String psBillDt) {
		this.psBillDt = psBillDt;
	}

	/**
	 * 贴息利率
	 * @return
	 */
	public Double getSbsyRate() {
		return this.sbsyRate;
	}

	/**
	 * 贴息利率
	 * @param sbsyRate
	 */
	public void setSbsyRate(Double sbsyRate) {
		this.sbsyRate = sbsyRate;
	}

	/**
	 * 未结息罚息
	 * @return
	 */
	public Double getGrcProdPrcp() {
		return this.grcProdPrcp;
	}

	/**
	 * 未结息罚息
	 * @param grcProdPrcp
	 */
	public void setGrcProdPrcp(Double grcProdPrcp) {
		this.grcProdPrcp = grcProdPrcp;
	}

	/**
	 * 减值罚息
	 * @return
	 */
	public Double getGrcProdInt() {
		return this.grcProdInt;
	}

	/**
	 * 减值罚息
	 * @param grcProdInt
	 */
	public void setGrcProdInt(Double grcProdInt) {
		this.grcProdInt = grcProdInt;
	}

	/**
	 * 减值复利
	 * @return
	 */
	public Double getGrcProdComm() {
		return this.grcProdComm;
	}

	/**
	 * 减值复利
	 * @param grcProdComm
	 */
	public void setGrcProdComm(Double grcProdComm) {
		this.grcProdComm = grcProdComm;
	}

}