package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 主要用于存放与借据相关的信息，包括期限、放款日期、生效日期、到期日、以及利率类型、利息罚息计算规则等等。
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
public class LmLoanHist implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 交易流水号
	 */
	private Long txLogSeq;
	/**
	 * 借据号
	 */
	private String loanNo;
	/**
	 * 银行代码
	 */
	private String bankCde;
	/**
	 * 分支机构代码
	 */
	private String bchCde;
	/**
	 * 借款人证件类型
	 */
	private String idType;
	/**
	 * 借款人证件号
	 */
	private String idNo;
	/**
	 * 借款人发证国家
	 */
	private String issCtry;
	/**
	 * 客户编号
	 */
	private String custId;
	/**
	 * 借款人姓名
	 */
	private String custName;
	/**
	 * 商户/经销商代码
	 */
	private String dealerCde;
	/**
	 * 贷款品种代码
	 */
	private String loanTyp;
	/**
	 * 贷款合同号
	 */
	private String loanContNo;
	/**
	 * 贷款状态
	 */
	private String loanSts;
	/**
	 * 贷款月数
	 */
	private BigDecimal tnr;
	/**
	 * 最后到期日
	 */
	private String lastDueDt;
	/**
	 * 起息日
	 */
	private String intStartDt;
	/**
	 * 账务状态
	 */
	private String loanDebtSts;
	/**
	 * 第一次扣款日
	 */
	private String fstPaymDt;
	/**
	 * 还款日
	 */
	private Long dueDay;
	/**
	 * 拖欠标志
	 */
	private String loanOdInd;
	/**
	 * 减值标志
	 */
	private String loanDevaInd;
	/**
	 * 已减值日期
	 */
	private String loanDevaDt;
	/**
	 * 转表外标志
	 */
	private String loanStpAccInd;
	/**
	 * 转表外日期
	 */
	private String loanStpAccDt;
	/**
	 * 放款日期
	 */
	private String loanActvDt;
	/**
	 * 利率模式
	 */
	private String loanRateMode;
	/**
	 * 利率计算基础
	 */
	private String rateBase;
	/**
	 * 利率代码
	 */
	private String loanRateTyp;
	/**
	 * 贷款执行利率
	 */
	private BigDecimal loanIntRate;
	/**
	 * 借据基准利率
	 */
	private BigDecimal loanBaseRate;
	/**
	 * 借据浮动利率
	 */
	private BigDecimal loanSprd;
	/**
	 * 借据利率浮动比例
	 */
	private BigDecimal intAdjPct;
	/**
	 * 罚息利率代码
	 */
	private String loanOdRateTyp;
	/**
	 * 罚息基准利率
	 */
	private BigDecimal loanOdBaseRate;
	/**
	 * 罚息执行利率
	 */
	private BigDecimal loanOdIntRate;
	/**
	 * 贷款挪用标志
	 */
	private String loanDiverInd;
	/**
	 * 贷款挪用利率
	 */
	private BigDecimal loanDiverIntRate;
	/**
	 * 第一次调整日期
	 */
	private String firstRepcDt;
	/**
	 * 上一次结罚息日
	 */
	private String lastGenOdIntDt;
	/**
	 * 上一次计提日
	 */
	private String lastIntAccDt;
	/**
	 * 上一次减值计提日
	 */
	private String lastDeviIntAccDt;
	/**
	 * 上一次扣款日
	 */
	private String lastSetlDt;
	/**
	 * 当前归还日期
	 */
	private String curDueDt;
	/**
	 * 下一次还款日
	 */
	private String nextDueDt;
	/**
	 * 下一次账单日
	 */
	private String nextBillDt;
	/**
	 * 还款间隔单位
	 */
	private String paymFreqUnit;
	/**
	 * 还款间隔
	 */
	private Integer paymFreqFreq;
	/**
	 * 最近一次调整还款计划日期
	 */
	private String lastRepcDt;
	/**
	 * 下一次利率调整日期
	 */
	private String nextRepcDt;
	/**
	 * 币种
	 */
	private String loanCcy;
	/**
	 * 发放金额
	 */
	private BigDecimal origPrcp;
	/**
	 * 剩余本金
	 */
	private BigDecimal loanOsPrcp;
	/**
	 * 期数
	 */
	private Integer loanTnr;
	/**
	 * 贷款多余天数(贷款期限折算成月之后还剩余的天数)
	 */
	private Integer loanOsDay;
	/**
	 * 核销日期
	 */
	private String chargeDt;
	/**
	 * 利率调整生效日期
	 */
	private String ratChgEffDt;
	/**
	 * 会计核算规则代码
	 */
	private String loanGlRoleCde;
	/**
	 * 业务数据来源
	 */
	private String bussTyp;
	/**
	 * 摊余成本积数
	 */
	private BigDecimal lnCostProd;
	/**
	 * 摊余成本积数日期
	 */
	private String lnCostProdDt;
	/**
	 * 贷款五级分类代码
	 */
	private String loanGrd;
	/**
	 * 还款方式
	 */
	private String loanPaymMtd;
	/**
	 * 还款方式类型
	 */
	private String loanPaymTyp;
	/**
	 * 罚息利率浮动比例
	 */
	private BigDecimal odRateAdjPct;
	/**
	 * 挪用利率浮动比例
	 */
	private BigDecimal diverAdjPct;
	/**
	 * 利息计算基础
	 */
	private String intBase;
	/**
	 * 当前结罚息日期
	 */
	private String curGenOdIntDt;
	/**
	 * 上次计提罚息日期
	 */
	private String lastOdIntAccDt;
	/**
	 * 减值顺序
	 */
	private String loanDevaOrd;
	/**
	 * 原最后到期日
	 */
	private String oldLastDueDt;
	/**
	 * 处理分页数据标志
	 */
	private String prcsPageDtInd;
	/**
	 * 账单日
	 */
	private Integer billDay;
	/**
	 * 列表编号
	 */
	private String lisId;
	/**
	 * 贴息标志
	 */
	private String sbsyInd;
	/**
	 * 卡号
	 */
	private String acctNo;
	/**
	 * 上次转逾期日
	 */
	private String lastChgOdDt;
	/**
	 * 更新版本
	 */
	private BigDecimal upVer;
	/**
	 * 下次同步方式表利率日期
	 */
	private String nextSynRateDt;
	/**
	 * 期供标志
	 */
	private String instmInd;
	/**
	 * 贴息利率
	 */
	private BigDecimal sbsyIntRate;
	/**
	 * 阶段剩余本金
	 */
	private BigDecimal remTermPrcp;
	/**
	 * 线程号
	 */
	private Integer thdCnt;
	/**
	 * 申请用户编号
	 */
	private String appUserId;
	/**
	 * 申请用户名
	 */
	private String appUserName;
	/**
	 * 申请用户机构号
	 */
	private String appUserOrgNo;
	/**
	 * 真实利率
	 */
	private BigDecimal rlIntRate;
	/**
	 * 贷款组
	 */
	private String typGrp;
	/**
	 * 支付类型
	 */
	private String payTyp;
	/**
	 * 罚息利率浮动点差
	 */
	private BigDecimal odRateSprd;
	/**
	 * 原贷款品种
	 */
	private String oldLoanTyp;

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
	 * 设置：借款人证件类型
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}
	/**
	 * 获取：借款人证件类型
	 */
	public String getIdType() {
		return idType;
	}
	/**
	 * 设置：借款人证件号
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	/**
	 * 获取：借款人证件号
	 */
	public String getIdNo() {
		return idNo;
	}
	/**
	 * 设置：借款人发证国家
	 */
	public void setIssCtry(String issCtry) {
		this.issCtry = issCtry;
	}
	/**
	 * 获取：借款人发证国家
	 */
	public String getIssCtry() {
		return issCtry;
	}
	/**
	 * 设置：客户编号
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}
	/**
	 * 获取：客户编号
	 */
	public String getCustId() {
		return custId;
	}
	/**
	 * 设置：借款人姓名
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	/**
	 * 获取：借款人姓名
	 */
	public String getCustName() {
		return custName;
	}
	/**
	 * 设置：商户/经销商代码
	 */
	public void setDealerCde(String dealerCde) {
		this.dealerCde = dealerCde;
	}
	/**
	 * 获取：商户/经销商代码
	 */
	public String getDealerCde() {
		return dealerCde;
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
	 * 设置：贷款合同号
	 */
	public void setLoanContNo(String loanContNo) {
		this.loanContNo = loanContNo;
	}
	/**
	 * 获取：贷款合同号
	 */
	public String getLoanContNo() {
		return loanContNo;
	}
	/**
	 * 设置：贷款状态
	 */
	public void setLoanSts(String loanSts) {
		this.loanSts = loanSts;
	}
	/**
	 * 获取：贷款状态
	 */
	public String getLoanSts() {
		return loanSts;
	}
	/**
	 * 设置：贷款月数
	 */
	public void setTnr(BigDecimal tnr) {
		this.tnr = tnr;
	}
	/**
	 * 获取：贷款月数
	 */
	public BigDecimal getTnr() {
		return tnr;
	}
	/**
	 * 设置：最后到期日
	 */
	public void setLastDueDt(String lastDueDt) {
		this.lastDueDt = lastDueDt;
	}
	/**
	 * 获取：最后到期日
	 */
	public String getLastDueDt() {
		return lastDueDt;
	}
	/**
	 * 设置：起息日
	 */
	public void setIntStartDt(String intStartDt) {
		this.intStartDt = intStartDt;
	}
	/**
	 * 获取：起息日
	 */
	public String getIntStartDt() {
		return intStartDt;
	}
	/**
	 * 设置：账务状态
	 */
	public void setLoanDebtSts(String loanDebtSts) {
		this.loanDebtSts = loanDebtSts;
	}
	/**
	 * 获取：账务状态
	 */
	public String getLoanDebtSts() {
		return loanDebtSts;
	}
	/**
	 * 设置：第一次扣款日
	 */
	public void setFstPaymDt(String fstPaymDt) {
		this.fstPaymDt = fstPaymDt;
	}
	/**
	 * 获取：第一次扣款日
	 */
	public String getFstPaymDt() {
		return fstPaymDt;
	}
	/**
	 * 设置：还款日
	 */
	public void setDueDay(Long dueDay) {
		this.dueDay = dueDay;
	}
	/**
	 * 获取：还款日
	 */
	public Long getDueDay() {
		return dueDay;
	}
	/**
	 * 设置：拖欠标志
	 */
	public void setLoanOdInd(String loanOdInd) {
		this.loanOdInd = loanOdInd;
	}
	/**
	 * 获取：拖欠标志
	 */
	public String getLoanOdInd() {
		return loanOdInd;
	}
	/**
	 * 设置：减值标志
	 */
	public void setLoanDevaInd(String loanDevaInd) {
		this.loanDevaInd = loanDevaInd;
	}
	/**
	 * 获取：减值标志
	 */
	public String getLoanDevaInd() {
		return loanDevaInd;
	}
	/**
	 * 设置：已减值日期
	 */
	public void setLoanDevaDt(String loanDevaDt) {
		this.loanDevaDt = loanDevaDt;
	}
	/**
	 * 获取：已减值日期
	 */
	public String getLoanDevaDt() {
		return loanDevaDt;
	}
	/**
	 * 设置：转表外标志
	 */
	public void setLoanStpAccInd(String loanStpAccInd) {
		this.loanStpAccInd = loanStpAccInd;
	}
	/**
	 * 获取：转表外标志
	 */
	public String getLoanStpAccInd() {
		return loanStpAccInd;
	}
	/**
	 * 设置：转表外日期
	 */
	public void setLoanStpAccDt(String loanStpAccDt) {
		this.loanStpAccDt = loanStpAccDt;
	}
	/**
	 * 获取：转表外日期
	 */
	public String getLoanStpAccDt() {
		return loanStpAccDt;
	}
	/**
	 * 设置：放款日期
	 */
	public void setLoanActvDt(String loanActvDt) {
		this.loanActvDt = loanActvDt;
	}
	/**
	 * 获取：放款日期
	 */
	public String getLoanActvDt() {
		return loanActvDt;
	}
	/**
	 * 设置：利率模式
	 */
	public void setLoanRateMode(String loanRateMode) {
		this.loanRateMode = loanRateMode;
	}
	/**
	 * 获取：利率模式
	 */
	public String getLoanRateMode() {
		return loanRateMode;
	}
	/**
	 * 设置：利率计算基础
	 */
	public void setRateBase(String rateBase) {
		this.rateBase = rateBase;
	}
	/**
	 * 获取：利率计算基础
	 */
	public String getRateBase() {
		return rateBase;
	}
	/**
	 * 设置：利率代码
	 */
	public void setLoanRateTyp(String loanRateTyp) {
		this.loanRateTyp = loanRateTyp;
	}
	/**
	 * 获取：利率代码
	 */
	public String getLoanRateTyp() {
		return loanRateTyp;
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
	 * 设置：借据基准利率
	 */
	public void setLoanBaseRate(BigDecimal loanBaseRate) {
		this.loanBaseRate = loanBaseRate;
	}
	/**
	 * 获取：借据基准利率
	 */
	public BigDecimal getLoanBaseRate() {
		return loanBaseRate;
	}
	/**
	 * 设置：借据浮动利率
	 */
	public void setLoanSprd(BigDecimal loanSprd) {
		this.loanSprd = loanSprd;
	}
	/**
	 * 获取：借据浮动利率
	 */
	public BigDecimal getLoanSprd() {
		return loanSprd;
	}
	/**
	 * 设置：借据利率浮动比例
	 */
	public void setIntAdjPct(BigDecimal intAdjPct) {
		this.intAdjPct = intAdjPct;
	}
	/**
	 * 获取：借据利率浮动比例
	 */
	public BigDecimal getIntAdjPct() {
		return intAdjPct;
	}
	/**
	 * 设置：罚息利率代码
	 */
	public void setLoanOdRateTyp(String loanOdRateTyp) {
		this.loanOdRateTyp = loanOdRateTyp;
	}
	/**
	 * 获取：罚息利率代码
	 */
	public String getLoanOdRateTyp() {
		return loanOdRateTyp;
	}
	/**
	 * 设置：罚息基准利率
	 */
	public void setLoanOdBaseRate(BigDecimal loanOdBaseRate) {
		this.loanOdBaseRate = loanOdBaseRate;
	}
	/**
	 * 获取：罚息基准利率
	 */
	public BigDecimal getLoanOdBaseRate() {
		return loanOdBaseRate;
	}
	/**
	 * 设置：罚息执行利率
	 */
	public void setLoanOdIntRate(BigDecimal loanOdIntRate) {
		this.loanOdIntRate = loanOdIntRate;
	}
	/**
	 * 获取：罚息执行利率
	 */
	public BigDecimal getLoanOdIntRate() {
		return loanOdIntRate;
	}
	/**
	 * 设置：贷款挪用标志
	 */
	public void setLoanDiverInd(String loanDiverInd) {
		this.loanDiverInd = loanDiverInd;
	}
	/**
	 * 获取：贷款挪用标志
	 */
	public String getLoanDiverInd() {
		return loanDiverInd;
	}
	/**
	 * 设置：贷款挪用利率
	 */
	public void setLoanDiverIntRate(BigDecimal loanDiverIntRate) {
		this.loanDiverIntRate = loanDiverIntRate;
	}
	/**
	 * 获取：贷款挪用利率
	 */
	public BigDecimal getLoanDiverIntRate() {
		return loanDiverIntRate;
	}
	/**
	 * 设置：第一次调整日期
	 */
	public void setFirstRepcDt(String firstRepcDt) {
		this.firstRepcDt = firstRepcDt;
	}
	/**
	 * 获取：第一次调整日期
	 */
	public String getFirstRepcDt() {
		return firstRepcDt;
	}
	/**
	 * 设置：上一次结罚息日
	 */
	public void setLastGenOdIntDt(String lastGenOdIntDt) {
		this.lastGenOdIntDt = lastGenOdIntDt;
	}
	/**
	 * 获取：上一次结罚息日
	 */
	public String getLastGenOdIntDt() {
		return lastGenOdIntDt;
	}
	/**
	 * 设置：上一次计提日
	 */
	public void setLastIntAccDt(String lastIntAccDt) {
		this.lastIntAccDt = lastIntAccDt;
	}
	/**
	 * 获取：上一次计提日
	 */
	public String getLastIntAccDt() {
		return lastIntAccDt;
	}
	/**
	 * 设置：上一次减值计提日
	 */
	public void setLastDeviIntAccDt(String lastDeviIntAccDt) {
		this.lastDeviIntAccDt = lastDeviIntAccDt;
	}
	/**
	 * 获取：上一次减值计提日
	 */
	public String getLastDeviIntAccDt() {
		return lastDeviIntAccDt;
	}
	/**
	 * 设置：上一次扣款日
	 */
	public void setLastSetlDt(String lastSetlDt) {
		this.lastSetlDt = lastSetlDt;
	}
	/**
	 * 获取：上一次扣款日
	 */
	public String getLastSetlDt() {
		return lastSetlDt;
	}
	/**
	 * 设置：当前归还日期
	 */
	public void setCurDueDt(String curDueDt) {
		this.curDueDt = curDueDt;
	}
	/**
	 * 获取：当前归还日期
	 */
	public String getCurDueDt() {
		return curDueDt;
	}
	/**
	 * 设置：下一次还款日
	 */
	public void setNextDueDt(String nextDueDt) {
		this.nextDueDt = nextDueDt;
	}
	/**
	 * 获取：下一次还款日
	 */
	public String getNextDueDt() {
		return nextDueDt;
	}
	/**
	 * 设置：下一次账单日
	 */
	public void setNextBillDt(String nextBillDt) {
		this.nextBillDt = nextBillDt;
	}
	/**
	 * 获取：下一次账单日
	 */
	public String getNextBillDt() {
		return nextBillDt;
	}
	/**
	 * 设置：还款间隔单位
	 */
	public void setPaymFreqUnit(String paymFreqUnit) {
		this.paymFreqUnit = paymFreqUnit;
	}
	/**
	 * 获取：还款间隔单位
	 */
	public String getPaymFreqUnit() {
		return paymFreqUnit;
	}
	/**
	 * 设置：还款间隔
	 */
	public void setPaymFreqFreq(Integer paymFreqFreq) {
		this.paymFreqFreq = paymFreqFreq;
	}
	/**
	 * 获取：还款间隔
	 */
	public Integer getPaymFreqFreq() {
		return paymFreqFreq;
	}
	/**
	 * 设置：最近一次调整还款计划日期
	 */
	public void setLastRepcDt(String lastRepcDt) {
		this.lastRepcDt = lastRepcDt;
	}
	/**
	 * 获取：最近一次调整还款计划日期
	 */
	public String getLastRepcDt() {
		return lastRepcDt;
	}
	/**
	 * 设置：下一次利率调整日期
	 */
	public void setNextRepcDt(String nextRepcDt) {
		this.nextRepcDt = nextRepcDt;
	}
	/**
	 * 获取：下一次利率调整日期
	 */
	public String getNextRepcDt() {
		return nextRepcDt;
	}
	/**
	 * 设置：币种
	 */
	public void setLoanCcy(String loanCcy) {
		this.loanCcy = loanCcy;
	}
	/**
	 * 获取：币种
	 */
	public String getLoanCcy() {
		return loanCcy;
	}
	/**
	 * 设置：发放金额
	 */
	public void setOrigPrcp(BigDecimal origPrcp) {
		this.origPrcp = origPrcp;
	}
	/**
	 * 获取：发放金额
	 */
	public BigDecimal getOrigPrcp() {
		return origPrcp;
	}
	/**
	 * 设置：剩余本金
	 */
	public void setLoanOsPrcp(BigDecimal loanOsPrcp) {
		this.loanOsPrcp = loanOsPrcp;
	}
	/**
	 * 获取：剩余本金
	 */
	public BigDecimal getLoanOsPrcp() {
		return loanOsPrcp;
	}
	/**
	 * 设置：期数
	 */
	public void setLoanTnr(Integer loanTnr) {
		this.loanTnr = loanTnr;
	}
	/**
	 * 获取：期数
	 */
	public Integer getLoanTnr() {
		return loanTnr;
	}
	/**
	 * 设置：贷款多余天数(贷款期限折算成月之后还剩余的天数)
	 */
	public void setLoanOsDay(Integer loanOsDay) {
		this.loanOsDay = loanOsDay;
	}
	/**
	 * 获取：贷款多余天数(贷款期限折算成月之后还剩余的天数)
	 */
	public Integer getLoanOsDay() {
		return loanOsDay;
	}
	/**
	 * 设置：核销日期
	 */
	public void setChargeDt(String chargeDt) {
		this.chargeDt = chargeDt;
	}
	/**
	 * 获取：核销日期
	 */
	public String getChargeDt() {
		return chargeDt;
	}
	/**
	 * 设置：利率调整生效日期
	 */
	public void setRatChgEffDt(String ratChgEffDt) {
		this.ratChgEffDt = ratChgEffDt;
	}
	/**
	 * 获取：利率调整生效日期
	 */
	public String getRatChgEffDt() {
		return ratChgEffDt;
	}
	/**
	 * 设置：会计核算规则代码
	 */
	public void setLoanGlRoleCde(String loanGlRoleCde) {
		this.loanGlRoleCde = loanGlRoleCde;
	}
	/**
	 * 获取：会计核算规则代码
	 */
	public String getLoanGlRoleCde() {
		return loanGlRoleCde;
	}
	/**
	 * 设置：业务数据来源
	 */
	public void setBussTyp(String bussTyp) {
		this.bussTyp = bussTyp;
	}
	/**
	 * 获取：业务数据来源
	 */
	public String getBussTyp() {
		return bussTyp;
	}
	/**
	 * 设置：摊余成本积数
	 */
	public void setLnCostProd(BigDecimal lnCostProd) {
		this.lnCostProd = lnCostProd;
	}
	/**
	 * 获取：摊余成本积数
	 */
	public BigDecimal getLnCostProd() {
		return lnCostProd;
	}
	/**
	 * 设置：摊余成本积数日期
	 */
	public void setLnCostProdDt(String lnCostProdDt) {
		this.lnCostProdDt = lnCostProdDt;
	}
	/**
	 * 获取：摊余成本积数日期
	 */
	public String getLnCostProdDt() {
		return lnCostProdDt;
	}
	/**
	 * 设置：贷款五级分类代码
	 */
	public void setLoanGrd(String loanGrd) {
		this.loanGrd = loanGrd;
	}
	/**
	 * 获取：贷款五级分类代码
	 */
	public String getLoanGrd() {
		return loanGrd;
	}
	/**
	 * 设置：还款方式
	 */
	public void setLoanPaymMtd(String loanPaymMtd) {
		this.loanPaymMtd = loanPaymMtd;
	}
	/**
	 * 获取：还款方式
	 */
	public String getLoanPaymMtd() {
		return loanPaymMtd;
	}
	/**
	 * 设置：还款方式类型
	 */
	public void setLoanPaymTyp(String loanPaymTyp) {
		this.loanPaymTyp = loanPaymTyp;
	}
	/**
	 * 获取：还款方式类型
	 */
	public String getLoanPaymTyp() {
		return loanPaymTyp;
	}
	/**
	 * 设置：罚息利率浮动比例
	 */
	public void setOdRateAdjPct(BigDecimal odRateAdjPct) {
		this.odRateAdjPct = odRateAdjPct;
	}
	/**
	 * 获取：罚息利率浮动比例
	 */
	public BigDecimal getOdRateAdjPct() {
		return odRateAdjPct;
	}
	/**
	 * 设置：挪用利率浮动比例
	 */
	public void setDiverAdjPct(BigDecimal diverAdjPct) {
		this.diverAdjPct = diverAdjPct;
	}
	/**
	 * 获取：挪用利率浮动比例
	 */
	public BigDecimal getDiverAdjPct() {
		return diverAdjPct;
	}
	/**
	 * 设置：利息计算基础
	 */
	public void setIntBase(String intBase) {
		this.intBase = intBase;
	}
	/**
	 * 获取：利息计算基础
	 */
	public String getIntBase() {
		return intBase;
	}
	/**
	 * 设置：当前结罚息日期
	 */
	public void setCurGenOdIntDt(String curGenOdIntDt) {
		this.curGenOdIntDt = curGenOdIntDt;
	}
	/**
	 * 获取：当前结罚息日期
	 */
	public String getCurGenOdIntDt() {
		return curGenOdIntDt;
	}
	/**
	 * 设置：上次计提罚息日期
	 */
	public void setLastOdIntAccDt(String lastOdIntAccDt) {
		this.lastOdIntAccDt = lastOdIntAccDt;
	}
	/**
	 * 获取：上次计提罚息日期
	 */
	public String getLastOdIntAccDt() {
		return lastOdIntAccDt;
	}
	/**
	 * 设置：减值顺序
	 */
	public void setLoanDevaOrd(String loanDevaOrd) {
		this.loanDevaOrd = loanDevaOrd;
	}
	/**
	 * 获取：减值顺序
	 */
	public String getLoanDevaOrd() {
		return loanDevaOrd;
	}
	/**
	 * 设置：原最后到期日
	 */
	public void setOldLastDueDt(String oldLastDueDt) {
		this.oldLastDueDt = oldLastDueDt;
	}
	/**
	 * 获取：原最后到期日
	 */
	public String getOldLastDueDt() {
		return oldLastDueDt;
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
	 * 设置：账单日
	 */
	public void setBillDay(Integer billDay) {
		this.billDay = billDay;
	}
	/**
	 * 获取：账单日
	 */
	public Integer getBillDay() {
		return billDay;
	}
	/**
	 * 设置：列表编号
	 */
	public void setLisId(String lisId) {
		this.lisId = lisId;
	}
	/**
	 * 获取：列表编号
	 */
	public String getLisId() {
		return lisId;
	}
	/**
	 * 设置：贴息标志
	 */
	public void setSbsyInd(String sbsyInd) {
		this.sbsyInd = sbsyInd;
	}
	/**
	 * 获取：贴息标志
	 */
	public String getSbsyInd() {
		return sbsyInd;
	}
	/**
	 * 设置：卡号
	 */
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	/**
	 * 获取：卡号
	 */
	public String getAcctNo() {
		return acctNo;
	}
	/**
	 * 设置：上次转逾期日
	 */
	public void setLastChgOdDt(String lastChgOdDt) {
		this.lastChgOdDt = lastChgOdDt;
	}
	/**
	 * 获取：上次转逾期日
	 */
	public String getLastChgOdDt() {
		return lastChgOdDt;
	}
	/**
	 * 设置：更新版本
	 */
	public void setUpVer(BigDecimal upVer) {
		this.upVer = upVer;
	}
	/**
	 * 获取：更新版本
	 */
	public BigDecimal getUpVer() {
		return upVer;
	}
	/**
	 * 设置：下次同步方式表利率日期
	 */
	public void setNextSynRateDt(String nextSynRateDt) {
		this.nextSynRateDt = nextSynRateDt;
	}
	/**
	 * 获取：下次同步方式表利率日期
	 */
	public String getNextSynRateDt() {
		return nextSynRateDt;
	}
	/**
	 * 设置：期供标志
	 */
	public void setInstmInd(String instmInd) {
		this.instmInd = instmInd;
	}
	/**
	 * 获取：期供标志
	 */
	public String getInstmInd() {
		return instmInd;
	}
	/**
	 * 设置：贴息利率
	 */
	public void setSbsyIntRate(BigDecimal sbsyIntRate) {
		this.sbsyIntRate = sbsyIntRate;
	}
	/**
	 * 获取：贴息利率
	 */
	public BigDecimal getSbsyIntRate() {
		return sbsyIntRate;
	}
	/**
	 * 设置：阶段剩余本金
	 */
	public void setRemTermPrcp(BigDecimal remTermPrcp) {
		this.remTermPrcp = remTermPrcp;
	}
	/**
	 * 获取：阶段剩余本金
	 */
	public BigDecimal getRemTermPrcp() {
		return remTermPrcp;
	}
	/**
	 * 设置：线程号
	 */
	public void setThdCnt(Integer thdCnt) {
		this.thdCnt = thdCnt;
	}
	/**
	 * 获取：线程号
	 */
	public Integer getThdCnt() {
		return thdCnt;
	}
	/**
	 * 设置：申请用户编号
	 */
	public void setAppUserId(String appUserId) {
		this.appUserId = appUserId;
	}
	/**
	 * 获取：申请用户编号
	 */
	public String getAppUserId() {
		return appUserId;
	}
	/**
	 * 设置：申请用户名
	 */
	public void setAppUserName(String appUserName) {
		this.appUserName = appUserName;
	}
	/**
	 * 获取：申请用户名
	 */
	public String getAppUserName() {
		return appUserName;
	}
	/**
	 * 设置：申请用户机构号
	 */
	public void setAppUserOrgNo(String appUserOrgNo) {
		this.appUserOrgNo = appUserOrgNo;
	}
	/**
	 * 获取：申请用户机构号
	 */
	public String getAppUserOrgNo() {
		return appUserOrgNo;
	}
	/**
	 * 设置：真实利率
	 */
	public void setRlIntRate(BigDecimal rlIntRate) {
		this.rlIntRate = rlIntRate;
	}
	/**
	 * 获取：真实利率
	 */
	public BigDecimal getRlIntRate() {
		return rlIntRate;
	}
	/**
	 * 设置：贷款组
	 */
	public void setTypGrp(String typGrp) {
		this.typGrp = typGrp;
	}
	/**
	 * 获取：贷款组
	 */
	public String getTypGrp() {
		return typGrp;
	}
	/**
	 * 设置：支付类型
	 */
	public void setPayTyp(String payTyp) {
		this.payTyp = payTyp;
	}
	/**
	 * 获取：支付类型
	 */
	public String getPayTyp() {
		return payTyp;
	}
	/**
	 * 设置：罚息利率浮动点差
	 */
	public void setOdRateSprd(BigDecimal odRateSprd) {
		this.odRateSprd = odRateSprd;
	}
	/**
	 * 获取：罚息利率浮动点差
	 */
	public BigDecimal getOdRateSprd() {
		return odRateSprd;
	}
	/**
	 * 设置：原贷款品种
	 */
	public void setOldLoanTyp(String oldLoanTyp) {
		this.oldLoanTyp = oldLoanTyp;
	}
	/**
	 * 获取：原贷款品种
	 */
	public String getOldLoanTyp() {
		return oldLoanTyp;
	}
}
