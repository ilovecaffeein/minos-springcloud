package com.caxs.minos.domain.trans;

import java.io.Serializable;

/**
 *  LmLoan对应交互类
 * Created by lenovo on 2020/9/4.
 */
public class LmLoanTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;

    // Fields
    private String loanNo;	//借据号
    private String lastDueDt;	//最后到期日
    private String intStartDt;	//起息日
    private Byte dueDay;		//扣款日
    private String loanActvDt;	//贷款放款日
    private String loanRateMode;	//利率模式
    private String loanRateTyp;		//利率代码
    private Double loanIntRate;		//贷款执行利率
    private Double loanBaseRate;	//借据基准利率
    private Double loanSprd;		//借据浮动利率
    private Double intAdjPct;		//借据利率浮动比例
    private String rateBase;		//利率计算基础
    private String paymFreqUnit;	//还款间隔单位
    private Short paymFreqFreq;		//还款间隔
    private String loanCcy;			//币种
    private Double origPrcp;		//发放金额
    private String loanGlRoleCde;		//会计核算规则代码
    private String bussTyp;				//业务数据来源
    private Double loanOdBaseRate;		//罚息基准利率
    private Double loanOdIntRate;		//罚息执行利率
    private String loanOdRateTyp;		//罚息利率代码
    private String ratChgEffDt;			//利率调整生效日期
    private String loanPaymMtd;			//还款方式
    private String dealerCde;	//商户代码
    private Double loanOdRateAdjPct;	//罚息利率浮动比例
    private String instmInd;			//期供标志
    private String appUserId;			//审批用户编号
    private String appUserName;			//审批用户姓名
    private String appUserOrgNo;		//审批用户机构号
    private String prcpBuyInd;
    private String bchCde;				//机构编号
    private String genGlNo;				//会计分录编号
    private String firstRepcDt;			//第一次调整日期
    private String fstPaymDt;//第一次扣款日期
    private String custId;//客户号
    private String custName;//客户名称
    private String idType;	//证件类型
    private String idNo;	//证件号码
    private String sbsyInd;				//贴息标志
    private Double sbsyIntRate;			//贴息利率
    private String pbcInd;				//是否上报征信
    private String placeCde;			//渠道来源
    private String trstplnNo;			//信托计划代码
    private String trstplnName;			//信托计划名称
    private String olInd;			     //是否线上清算
    private Double olPrcp;               //清算资金
    private Integer tnr;
    private String applPsbcCde;			 //是否线上清算

    /**
     * 设置：贷款月数
     */
    public void setTnr(Integer tnr) {
        this.tnr = tnr;
    }
    /**
     * 获取：贷款月数
     */
    public Integer getTnr() {
        return tnr;
    }
    public Double getOlPrcp() {
        return olPrcp;
    }
    public void setOlPrcp(Double olPrcp) {
        this.olPrcp = olPrcp;
    }
    public String getOlInd() {
        return olInd;
    }
    public void setOlInd(String olInd) {
        this.olInd = olInd;
    }
    public String getTrstplnNo() {
        return trstplnNo;
    }
    public void setTrstplnNo(String trstplnNo) {
        this.trstplnNo = trstplnNo;
    }
    public String getTrstplnName() {
        return trstplnName;
    }
    public void setTrstplnName(String trstplnName) {
        this.trstplnName = trstplnName;
    }
    public String getPlaceCde() {
        return placeCde;
    }
    public void setPlaceCde(String placeCde) {
        this.placeCde = placeCde;
    }
    public String getPbcInd() {
        return pbcInd;
    }
    public void setPbcInd(String pbcInd) {
        this.pbcInd = pbcInd;
    }
    public String getIdNo() {
        return idNo;
    }
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }
    public String getIdType() {
        return idType;
    }
    public void setIdType(String idType) {
        this.idType = idType;
    }
    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getCustId() {
        return custId;
    }
    public void setCustId(String custId) {
        this.custId = custId;
    }
    public String getFstPaymDt() {
        return fstPaymDt;
    }
    public void setFstPaymDt(String fstPaymDt) {
        this.fstPaymDt = fstPaymDt;
    }
    /**
     * 获取第一次调整日期
     * @return
     */
    public String getFirstRepcDt() {
        return firstRepcDt;
    }
    /**
     * 设置第一次调整日期
     * @param firstRepcDt
     */
    public void setFirstRepcDt(String firstRepcDt) {
        this.firstRepcDt = firstRepcDt;
    }
    /**
     * 获取会计分录编号
     * @return
     */
    public String getGenGlNo() {
        return genGlNo;
    }
    /**
     * 设置会计分录编号
     * @param genGlNo
     */
    public void setGenGlNo(String genGlNo) {
        this.genGlNo = genGlNo;
    }
    /**
     *
     * @return
     */
    public String getPrcpBuyInd() {
        return prcpBuyInd;
    }

    public void setPrcpBuyInd(String prcpBuyInd) {
        this.prcpBuyInd = prcpBuyInd;
    }
    /**
     * 获取期供标志
     * @return
     */
    public String getInstmInd() {
        return instmInd;
    }
    /**
     * 设置期供标志
     * @param instmInd
     */
    public void setInstmInd(String instmInd) {
        this.instmInd = instmInd;
    }

    /**
     * 贴息金额
     */
    private Double sbsyAmt = 0.0;
    /**
     * 减值顺序
     */
    private Byte loanDevaOrd;
    /**
     * 还款方式类型
     */
    private String loanPaymTyp;
    // Constructors
    /**
     * 获取贴息金额
     * @return
     */
    public Double getSbsyAmt() {
        return sbsyAmt;
    }
    /**
     * 设置贴息金额
     * @param sbsyAmt
     */
    public void setSbsyAmt(Double sbsyAmt) {
        this.sbsyAmt = sbsyAmt;
    }

    /** default constructor */
    public LmLoanTrans() {
    }

    /** minimal constructor */
    public LmLoanTrans(String loanNo) {
        this.loanNo = loanNo;
    }

    /** full constructor */
    public LmLoanTrans(String loanNo, String lastDueDt,String intStartDt,
                       Byte dueDay, String loanActvDt, String loanRateMode, String loanRateTyp,
                       Double loanIntRate, Double loanBaseRate, Double loanSprd,
                       Double intAdjPct, String rateBase, String paymFreqUnit,
                       Short paymFreqFreq,String loanCcy,Double origPrcp,
                       String ratChgEffDt, String loanGlRoleCde,String bussTyp,
                       Double loanOdBaseRate, Double loanOdIntRate,String loanOdRateTyp,String loanPaymMtd,String loanPaymTyp,
                       String appUserId,String appUserName,String appUserOrgNo,String bchCde,
                       String sbsyInd,Double sbsyIntRate,String pbcInd,String placeCde,String trstplnNo,String trstplnName,
                       String olInd,Double olPrcp) {
        this.loanNo = loanNo;
        this.lastDueDt = lastDueDt;
        this.intStartDt = intStartDt;
        this.dueDay = dueDay;
        this.loanActvDt = loanActvDt;
        this.loanRateMode = loanRateMode;
        this.loanRateTyp = loanRateTyp;
        this.loanIntRate = loanIntRate;
        this.loanBaseRate = loanBaseRate;
        this.loanSprd = loanSprd;
        this.intAdjPct = intAdjPct;
        this.rateBase = rateBase;
        this.paymFreqUnit = paymFreqUnit;
        this.paymFreqFreq = paymFreqFreq;
        this.loanCcy = loanCcy;
        this.origPrcp = origPrcp;
        this.ratChgEffDt = ratChgEffDt;
        this.loanGlRoleCde = loanGlRoleCde;
        this.bussTyp = bussTyp;
        this.loanOdBaseRate = loanOdBaseRate;
        this.loanOdIntRate = loanOdIntRate;
        this.loanOdRateTyp = loanOdRateTyp;
        this.loanPaymMtd=loanPaymMtd;
        this.loanPaymTyp=loanPaymTyp;
        this.appUserId = appUserId;
        this.appUserName = appUserName;
        this.appUserOrgNo = appUserOrgNo;
        this.bchCde = bchCde;
        this.sbsyInd = sbsyInd;
        this.sbsyIntRate = sbsyIntRate;
        this.pbcInd=pbcInd;
        this.placeCde=placeCde;
        this.trstplnNo=trstplnNo;
        this.trstplnName=trstplnName;
        this.olInd=olInd;
        this.olPrcp=olPrcp;
    }

    /**
     * 借据交互对象构造函数
     * @param loanNo
     * @param lastDueDt
     * @param intStartDt
     * @param dueDay
     * @param loanActvDt
     * @param loanRateMode
     * @param loanRateTyp
     * @param loanIntRate
     * @param loanBaseRate
     * @param loanSprd
     * @param intAdjPct
     * @param rateBase
     * @param paymFreqUnit
     * @param paymFreqFreq
     * @param loanCcy
     * @param origPrcp
     * @param loanGlRoleCde
     * @param bussTyp
     * @param loanOdBaseRate
     * @param loanOdIntRate
     * @param loanOdRateTyp
     * @param ratChgEffDt
     * @param loanPaymMtd
     * @param dealerCde
     * @param loanPaymTyp
     */
    public LmLoanTrans(String loanNo, String lastDueDt, String intStartDt,
                       Byte dueDay, String loanActvDt, String loanRateMode,
                       String loanRateTyp, Double loanIntRate, Double loanBaseRate,
                       Double loanSprd, Double intAdjPct, String rateBase,
                       String paymFreqUnit, Short paymFreqFreq, String loanCcy,
                       Double origPrcp, String loanGlRoleCde, String bussTyp,
                       Double loanOdBaseRate, Double loanOdIntRate, String loanOdRateTyp,
                       String ratChgEffDt, String loanPaymMtd, String dealerCde,String loanPaymTyp) {
        super();
        this.loanNo = loanNo;
        this.lastDueDt = lastDueDt;
        this.intStartDt = intStartDt;
        this.dueDay = dueDay;
        this.loanActvDt = loanActvDt;
        this.loanRateMode = loanRateMode;
        this.loanRateTyp = loanRateTyp;
        this.loanIntRate = loanIntRate;
        this.loanBaseRate = loanBaseRate;
        this.loanSprd = loanSprd;
        this.intAdjPct = intAdjPct;
        this.rateBase = rateBase;
        this.paymFreqUnit = paymFreqUnit;
        this.paymFreqFreq = paymFreqFreq;
        this.loanCcy = loanCcy;
        this.origPrcp = origPrcp;
        this.loanGlRoleCde = loanGlRoleCde;
        this.bussTyp = bussTyp;
        this.loanOdBaseRate = loanOdBaseRate;
        this.loanOdIntRate = loanOdIntRate;
        this.loanOdRateTyp = loanOdRateTyp;
        this.ratChgEffDt = ratChgEffDt;
        this.loanPaymMtd = loanPaymMtd;
        this.dealerCde = dealerCde;
        this.loanPaymTyp=loanPaymTyp;
    }

    // Property accessors
    /**
     * 获取借据号
     * @return
     */
    public String getLoanNo() {
        return this.loanNo;
    }
    /**
     * 获取审批用户编号
     * @return
     */
    public String getAppUserId() {
        return appUserId;
    }
    /**
     * 设置审批用户编号
     * @param appUserId
     */
    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId;
    }
    /**
     * 获取审批用户姓名
     * @return
     */
    public String getAppUserName() {
        return appUserName;
    }
    /**
     * 设置审批用户姓名
     * @param appUserName
     */
    public void setAppUserName(String appUserName) {
        this.appUserName = appUserName;
    }
    /**
     * 获取审批用户机构号
     * @return
     */
    public String getAppUserOrgNo() {
        return appUserOrgNo;
    }
    /**
     * 设置审批用户机构号
     * @param appUserOrgNo
     */
    public void setAppUserOrgNo(String appUserOrgNo) {
        this.appUserOrgNo = appUserOrgNo;
    }
    /**
     * 设置借据号
     * @param loanNo
     */
    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }
    /**
     * 获取最后到期日
     * @return
     */
    public String getLastDueDt() {
        return this.lastDueDt;
    }
    /**
     * 设置最后到期日
     * @param lastDueDt
     */
    public void setLastDueDt(String lastDueDt) {
        this.lastDueDt = lastDueDt;
    }
    /**
     * 获取起息日
     * @return
     */
    public String getIntStartDt() {
        return this.intStartDt;
    }
    /**
     * 设置起息日
     * @param intStartDt
     */
    public void setIntStartDt(String intStartDt) {
        this.intStartDt = intStartDt;
    }
    /**
     * 获取扣款日
     * @return
     */
    public Byte getDueDay() {
        return this.dueDay;
    }
    /**
     * 设置扣款日
     * @param dueDay
     */
    public void setDueDay(Byte dueDay) {
        this.dueDay = dueDay;
    }
    /**
     * 获取贷款发放日期
     * @return
     */
    public String getLoanActvDt() {
        return this.loanActvDt;
    }
    /**
     * 设置贷款发放日期
     * @param loanActvDt
     */
    public void setLoanActvDt(String loanActvDt) {
        this.loanActvDt = loanActvDt;
    }
    /**
     * 获取利率模式
     * @return
     */
    public String getLoanRateMode() {
        return this.loanRateMode;
    }
    /**
     * 设置利率模式
     * @param loanRateMode
     */
    public void setLoanRateMode(String loanRateMode) {
        this.loanRateMode = loanRateMode;
    }
    /**
     * 获取利率代码
     * @return
     */
    public String getLoanRateTyp() {
        return this.loanRateTyp;
    }
    /**
     * 设置利率代码
     * @param loanRateTyp
     */
    public void setLoanRateTyp(String loanRateTyp) {
        this.loanRateTyp = loanRateTyp;
    }
    /**
     * 获取贷款执行利率
     * @return
     */
    public Double getLoanIntRate() {
        return this.loanIntRate;
    }
    /**
     * 设置贷款执行利率
     * @param loanIntRate
     */
    public void setLoanIntRate(Double loanIntRate) {
        this.loanIntRate = loanIntRate;
    }
    /**
     * 获取借据基准利率
     * @return
     */
    public Double getLoanBaseRate() {
        return this.loanBaseRate;
    }
    /**
     * 设置借据基准利率
     * @param loanBaseRate
     */
    public void setLoanBaseRate(Double loanBaseRate) {
        this.loanBaseRate = loanBaseRate;
    }
    /**
     * 获取借据浮动利率
     * @return
     */
    public Double getLoanSprd() {
        return this.loanSprd;
    }
    /**
     * 设置借据浮动利率
     * @param loanSprd
     */
    public void setLoanSprd(Double loanSprd) {
        this.loanSprd = loanSprd;
    }
    /**
     * 获取借据利率浮动比例
     * @return
     */
    public Double getIntAdjPct() {
        return this.intAdjPct;
    }
    /**
     * 设置借据利率浮动比例
     * @param intAdjPct
     */
    public void setIntAdjPct(Double intAdjPct) {
        this.intAdjPct = intAdjPct;
    }
    /**
     * 获取利率计算基础
     * @return
     */
    public String getRateBase() {
        return this.rateBase;
    }
    /**
     * 设置利率计算基础
     * @param rateBase
     */
    public void setRateBase(String rateBase) {
        this.rateBase = rateBase;
    }
    /**
     * 获取还款间隔单位
     * @return
     */
    public String getPaymFreqUnit() {
        return paymFreqUnit;
    }
    /**
     * 设置还款间隔单位
     * @param paymFreqUnit
     */
    public void setPaymFreqUnit(String paymFreqUnit) {
        this.paymFreqUnit = paymFreqUnit;
    }
    /**
     * 获取还款间隔
     * @return
     */
    public Short getPaymFreqFreq() {
        return paymFreqFreq;
    }
    /**
     * 设置还款间隔
     * @param paymFreqFreq
     */
    public void setPaymFreqFreq(Short paymFreqFreq) {
        this.paymFreqFreq = paymFreqFreq;
    }
    /**
     * 获取币种信息
     * @return
     */
    public String getLoanCcy() {
        return this.loanCcy;
    }
    /**
     * 设置币种
     * @param loanCcy
     */
    public void setLoanCcy(String loanCcy) {
        this.loanCcy = loanCcy;
    }
    /**
     * 获取发放金额
     * @return
     */
    public Double getOrigPrcp() {
        return this.origPrcp;
    }
    /**
     * 设置发放金额
     * @param origPrcp
     */
    public void setOrigPrcp(Double origPrcp) {
        this.origPrcp = origPrcp;
    }
    /**
     * 获取利率调整生效日期
     * @return
     */
    public String getRatChgEffDt() {
        return this.ratChgEffDt;
    }
    /**
     * 设置利率调整生效日期
     * @param ratChgEffDt
     */
    public void setRatChgEffDt(String ratChgEffDt) {
        this.ratChgEffDt = ratChgEffDt;
    }
    /**
     * 获取会计核算规则代码
     * @return
     */
    public String getLoanGlRoleCde() {
        return this.loanGlRoleCde;
    }
    /**
     * 设置会计核算规则代码
     * @param loanGlRoleCde
     */
    public void setLoanGlRoleCde(String loanGlRoleCde) {
        this.loanGlRoleCde = loanGlRoleCde;
    }
    /**
     * 获取业务类型
     * @return
     */
    public String getBussTyp() {
        return this.bussTyp;
    }
    /**
     * 设置业务类型
     * @param bussTyp
     */
    public void setBussTyp(String bussTyp) {
        this.bussTyp = bussTyp;
    }
    /**
     * 获取罚息基准利率
     * @return
     */
    public Double getLoanOdBaseRate() {
        return loanOdBaseRate;
    }
    /**
     * 设置罚息基准利率
     * @param loanOdBaseRate
     */
    public void setLoanOdBaseRate(Double loanOdBaseRate) {
        this.loanOdBaseRate = loanOdBaseRate;
    }
    /**
     * 获取罚息执行利率
     * @return
     */
    public Double getLoanOdIntRate() {
        return loanOdIntRate;
    }
    /**
     * 设置罚息执行利率
     * @param loanOdIntRate
     */
    public void setLoanOdIntRate(Double loanOdIntRate) {
        this.loanOdIntRate = loanOdIntRate;
    }
    /**
     * 获取罚息利率代码
     * @return
     */
    public String getLoanOdRateTyp() {
        return loanOdRateTyp;
    }
    /**
     * 设置罚息利率代码
     * @param loanOdRateTyp
     */
    public void setLoanOdRateTyp(String loanOdRateTyp) {
        this.loanOdRateTyp = loanOdRateTyp;
    }
    /**
     * 获取还款方式
     * @return
     */
    public String getLoanPaymMtd() {
        return loanPaymMtd;
    }
    /**
     * 设置还款方式
     * @param loanPaymMtd
     */
    public void setLoanPaymMtd(String loanPaymMtd) {
        this.loanPaymMtd = loanPaymMtd;
    }
    /**
     * 获取商户代码
     * @return
     */
    public String getDealerCde() {
        return dealerCde;
    }
    /**
     * 设置商户代码
     * @param dealerCde
     */
    public void setDealerCde(String dealerCde) {
        this.dealerCde = dealerCde;
    }
    /**
     * 获取罚息利率浮动比例
     * @return
     */
    public Double getLoanOdRateAdjPct() {
        return loanOdRateAdjPct;
    }
    /**
     * 设置罚息利率浮动比例
     * @param loanOdRateAdjPct
     */
    public void setLoanOdRateAdjPct(Double loanOdRateAdjPct) {
        this.loanOdRateAdjPct = loanOdRateAdjPct;
    }
    /**
     * 设置减值顺序
     * @param b
     */
    public void setLoanDevaOrd(Byte b) {
        this.loanDevaOrd = b;
    }
    /**
     * 获取减值顺序
     * @return
     */
    public Byte getLoanDevaOrd() {
        return loanDevaOrd;
    }
    /**
     * 设置还款方式类型
     * @param loanPaymTyp
     */
    public void setLoanPaymTyp(String loanPaymTyp) {
        this.loanPaymTyp = loanPaymTyp;
    }
    /**
     * 获取还款方式类型
     * @return
     */
    public String getLoanPaymTyp() {
        return loanPaymTyp;
    }
    /**
     * 获取机构号
     * @return
     */
    public String getBchCde() {
        return bchCde;
    }
    /**
     * 设置机构号
     * @param bchCde
     */
    public void setBchCde(String bchCde) {
        this.bchCde = bchCde;
    }
    public String getSbsyInd() {
        return sbsyInd;
    }
    public void setSbsyInd(String sbsyInd) {
        this.sbsyInd = sbsyInd;
    }
    public Double getSbsyIntRate() {
        return sbsyIntRate;
    }
    public void setSbsyIntRate(Double sbsyIntRate) {
        this.sbsyIntRate = sbsyIntRate;
    }

    public void setApplPsbcCde(String applPsbcCde) {
        this.applPsbcCde = applPsbcCde;
    }
    public String getApplPsbcCde() {
        return applPsbcCde;
    }

}
