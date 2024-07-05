package com.caxs.minos.domain.trans;

import com.caxs.minos.domain.LmPmShdId;

import java.io.Serializable;
import java.math.BigDecimal;

public class RepaymentPlanTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;
    private LmPmShdId id;			//还款计划主键
    private String psDueDt;				//到期日
    private BigDecimal psInstmAmt;			//期供
    private BigDecimal psPrcpAmt;			//应还本金
    private BigDecimal psNormIntAmt;		//应还利息
    private BigDecimal psOdIntAmt;			//应还逾期利息
    private BigDecimal psCommOdInt;			//应还复利
    private BigDecimal psFeeAmt;			//应还费用
    private BigDecimal prodPrcpAmt;			//本金积数
    private BigDecimal prodIntAmt;			//利息积数
    private BigDecimal prodCommIntAmt;		//复利积数
    private Long prodFeeAmt;			//费用积数
    private BigDecimal psRemPrcp;			//剩余本金
    private BigDecimal setlPrcp;			//已还本金
    private BigDecimal setlNormInt;			//已还正常利息
    private BigDecimal setlOdIntAmt;		//已还逾期利息
    private BigDecimal setlCommOdInt;		//已还复利
    private BigDecimal setlFeeAmt;			//已还费用
    private BigDecimal psIntRate;			//执行利率
    private BigDecimal psOdIntRate;			//逾期利率
    private String psOdInd;				//逾期标志
    private String lastSetlDt;			//最近还款日
    private BigDecimal psIncTaken;			//计提利息
    private BigDecimal psOdIncTaken;		//计提罚息
    private BigDecimal psWvPrcpAmt;			//减免本金
    private BigDecimal psWvNmInt;			//减免正常利息
    private BigDecimal psWvOdInt;			//减免罚息
    private BigDecimal psWvCommInt;			//减免复利
    private String prcpState;			//本金状态
    private String intState;			//利息状态
    private String setlInd;				//结清状态
    private String commOdGenDt;			//上次结罚息日期
    private String ppErInd;				//当期还款记录是否为主动还款
    private String psGenProdDt;			//滚积数日期
    private BigDecimal psCurOdIncTaken;		//当期逾期利息计提金额
    private BigDecimal sbsyIntAmt;			//贴息金额
    private String psBillDt;			//账单日
    private BigDecimal sbsyRate;			//贴息利率
    private BigDecimal grcProdPrcp;			//未结息罚息
    private BigDecimal dcInstmAmt;			//代偿期供
    private BigDecimal dcPrcpAmt;			//代偿应还本金
    private BigDecimal dcNormIntAmt;		//代偿应还利息
    private BigDecimal dcOdIntAmt;			//代偿应还逾期利息
    private BigDecimal dcCommOdInt;			//代偿应复利
    private String dcInd;				//是否代偿标志
    private String setlMode;		    //还款模式
    private String accpIssueDt;		    //经销商代偿日期
    private String accInd;		        //客户是否归还代偿
    private BigDecimal dftfAmt;             //垫付退还金额
    private String dftfDt;              //垫付退还日期
    private String prcsPageDtInd;       //处理分页数据标志
    private BigDecimal dftfPrcpAmt;         //垫付退还本金
    private BigDecimal dftfNormIntAmt;      //垫付退还利息
    private BigDecimal dftfOdIntAmt;        //垫付退还逾期利息
    private BigDecimal dftfCommOdIntAmt;    //垫付退还复利
    private String dcTyp;		        //代偿类型

    public String getDcTyp() {
        return dcTyp;
    }
    public void setDcTyp(String dcTyp) {
        this.dcTyp = dcTyp;
    }
    public String getPrcsPageDtInd() {
        return prcsPageDtInd;
    }
    public void setPrcsPageDtInd(String prcsPageDtInd) {
        this.prcsPageDtInd = prcsPageDtInd;
    }
    public BigDecimal getDftfPrcpAmt() {
        return dftfPrcpAmt;
    }
    public void setDftfPrcpAmt(BigDecimal dftfPrcpAmt) {
        this.dftfPrcpAmt = dftfPrcpAmt;
    }
    public BigDecimal getDftfNormIntAmt() {
        return dftfNormIntAmt;
    }
    public void setDftfNormIntAmt(BigDecimal dftfNormIntAmt) {
        this.dftfNormIntAmt = dftfNormIntAmt;
    }
    public BigDecimal getDftfOdIntAmt() {
        return dftfOdIntAmt;
    }
    public void setDftfOdIntAmt(BigDecimal dftfOdIntAmt) {
        this.dftfOdIntAmt = dftfOdIntAmt;
    }
    public BigDecimal getDftfCommOdIntAmt() {
        return dftfCommOdIntAmt;
    }
    public void setDftfCommOdIntAmt(BigDecimal dftfCommOdIntAmt) {
        this.dftfCommOdIntAmt = dftfCommOdIntAmt;
    }
    public BigDecimal getDftfAmt() {
        return dftfAmt;
    }
    public void setDftfAmt(BigDecimal dftfAmt) {
        this.dftfAmt = dftfAmt;
    }
    public String getDftfDt() {
        return dftfDt;
    }
    public void setDftfDt(String dftfDt) {
        this.dftfDt = dftfDt;
    }
    public String getAccInd() {
        return accInd;
    }
    public void setAccInd(String accInd) {
        this.accInd = accInd;
    }
    public String getAccpIssueDt() {
        return accpIssueDt;
    }
    public void setAccpIssueDt(String accpIssueDt) {
        this.accpIssueDt = accpIssueDt;
    }
    public String getSetlMode() {
        return setlMode;
    }
    public void setSetlMode(String setlMode) {
        this.setlMode = setlMode;
    }
    public BigDecimal getDcCommOdInt() {
        return dcCommOdInt;
    }
    public void setDcCommOdInt(BigDecimal dcCommOdInt) {
        this.dcCommOdInt = dcCommOdInt;
    }
    public BigDecimal getDcInstmAmt() {
        return dcInstmAmt;
    }
    public void setDcInstmAmt(BigDecimal dcInstmAmt) {
        this.dcInstmAmt = dcInstmAmt;
    }
    public BigDecimal getDcPrcpAmt() {
        return dcPrcpAmt;
    }
    public void setDcPrcpAmt(BigDecimal dcPrcpAmt) {
        this.dcPrcpAmt = dcPrcpAmt;
    }
    public BigDecimal getDcNormIntAmt() {
        return dcNormIntAmt;
    }
    public void setDcNormIntAmt(BigDecimal dcNormIntAmt) {
        this.dcNormIntAmt = dcNormIntAmt;
    }
    public BigDecimal getDcOdIntAmt() {
        return dcOdIntAmt;
    }
    public void setDcOdIntAmt(BigDecimal dcOdIntAmt) {
        this.dcOdIntAmt = dcOdIntAmt;
    }
    public String getDcInd() {
        return dcInd;
    }
    public void setDcInd(String dcInd) {
        this.dcInd = dcInd;
    }
    /**
     * 减值罚息
     */
    private BigDecimal grcProdInt;

    /**
     *减值复利
     */
    private BigDecimal grcProdComm;

    private BigDecimal setlIncTaken;		//已结正常利息
    private BigDecimal setlOdIncTaken;		//已结罚息利息




    // Constructors
    /**
     * 获取已结正常利息
     * @return
     */
    public BigDecimal getSetlIncTaken() {
        return setlIncTaken;
    }
    /**
     * 已结正常利息
     * @param setlIncTaken
     */
    public void setSetlIncTaken(BigDecimal setlIncTaken) {
        this.setlIncTaken = setlIncTaken;
    }
    /*
     * 获取已结罚息利息
     */
    public BigDecimal getSetlOdIncTaken() {
        return setlOdIncTaken;
    }
    /**
     * 设置已结罚息利息
     * @param setlOdIncTaken
     */
    public void setSetlOdIncTaken(BigDecimal setlOdIncTaken) {
        this.setlOdIncTaken = setlOdIncTaken;
    }

    /** default constructor */
    public RepaymentPlanTrans() {
    }

    /** minimal constructor */
    public RepaymentPlanTrans(LmPmShdId id) {
        this.id = id;
    }

    /** full constructor */
    public RepaymentPlanTrans(LmPmShdId id, String psDueDt, BigDecimal psInstmAmt,
                              BigDecimal psPrcpAmt, BigDecimal psNormIntAmt, BigDecimal psOdIntAmt,
                              BigDecimal psCommOdInt, BigDecimal psFeeAmt, BigDecimal prodPrcpAmt,
                              BigDecimal prodIntAmt, BigDecimal prodCommIntAmt, Long prodFeeAmt,
                              BigDecimal psRemPrcp, BigDecimal setlPrcp, BigDecimal setlNormInt,
                              BigDecimal setlOdIntAmt, BigDecimal setlCommOdInt, BigDecimal setlFeeAmt,
                              BigDecimal psIntRate, BigDecimal psOdIntRate, String psOdInd,
                              String lastSetlDt, BigDecimal psIncTaken, BigDecimal psOdIncTaken,
                              BigDecimal psWvPrcpAmt, BigDecimal psWvNmInt, BigDecimal psWvOdInt,
                              BigDecimal psWvCommInt, String prcpState, String intState,
                              String setlInd, String commOdGenDt, String ppErInd,
                              String psGenProdDt, BigDecimal psCurOdIncTaken, BigDecimal sbsyIntAmt,
                              String psBillDt, BigDecimal sbsyRate, BigDecimal grcProdPrcp,
                              BigDecimal grcProdInt, BigDecimal grcProdComm, BigDecimal dcInstmAmt, BigDecimal dcPrcpAmt,
                              BigDecimal dcNormIntAmt, BigDecimal dcOdIntAmt, BigDecimal dcCommOdInt,
                              String dcInd, String setlMode, String accpIssueDt, String accInd, BigDecimal dftfAmt, String dftfDt, String prcsPageDtInd,
                              BigDecimal dftfPrcpAmt, BigDecimal dftfNormIntAmt, BigDecimal dftfOdIntAmt, BigDecimal dftfCommOdIntAmt, String dcTyp) {
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
        this.dcPrcpAmt = dcPrcpAmt;
        this.dcInstmAmt = dcInstmAmt;
        this.dcNormIntAmt = dcNormIntAmt;
        this.dcOdIntAmt = dcOdIntAmt;
        this.dcCommOdInt=dcCommOdInt;
        this.dcInd = dcInd;
        this.setlMode=setlMode;
        this.accpIssueDt=accpIssueDt;
        this.accInd=accInd;
        this.dftfAmt=dftfAmt;
        this.dftfDt=dftfDt;
        this.prcsPageDtInd=prcsPageDtInd;
        this.dftfPrcpAmt=dftfPrcpAmt;
        this.dftfNormIntAmt=dftfNormIntAmt;
        this.dftfOdIntAmt=dftfOdIntAmt;
        this.dftfCommOdIntAmt=dftfCommOdIntAmt;
        this.dcTyp=dcTyp;
    }

    // Property accessors

    /**
     * 还款计划主键
     * @return
     */
    public LmPmShdId getId() {
        return this.id;
    }

    /**
     * 还款计划主键
     * @param id
     */
    public void setId(LmPmShdId id) {
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
    public BigDecimal getPsInstmAmt() {
        return this.psInstmAmt;
    }

    /**
     * 期供
     * @param psInstmAmt
     */
    public void setPsInstmAmt(BigDecimal psInstmAmt) {
        this.psInstmAmt = psInstmAmt;
    }

    /**
     * 应还本金
     * @return
     */
    public BigDecimal getPsPrcpAmt() {
        return this.psPrcpAmt;
    }

    /**
     * 应还本金
     * @param psPrcpAmt
     */
    public void setPsPrcpAmt(BigDecimal psPrcpAmt) {
        this.psPrcpAmt = psPrcpAmt;
    }

    /**
     * 应还利息
     * @return
     */
    public BigDecimal getPsNormIntAmt() {
        return this.psNormIntAmt;
    }

    /**
     * 应还利息
     * @param psNormIntAmt
     */
    public void setPsNormIntAmt(BigDecimal psNormIntAmt) {
        this.psNormIntAmt = psNormIntAmt;
    }

    /**
     * 应还逾期利息
     * @return
     */
    public BigDecimal getPsOdIntAmt() {
        return this.psOdIntAmt;
    }

    /**
     * 应还逾期利息
     * @param psOdIntAmt
     */
    public void setPsOdIntAmt(BigDecimal psOdIntAmt) {
        this.psOdIntAmt = psOdIntAmt;
    }

    /**
     * 应还复利
     * @return
     */
    public BigDecimal getPsCommOdInt() {
        return this.psCommOdInt;
    }

    /**
     * 应还复利
     * @param psCommOdInt
     */
    public void setPsCommOdInt(BigDecimal psCommOdInt) {
        this.psCommOdInt = psCommOdInt;
    }

    /**
     * 应还费用
     * @return
     */
    public BigDecimal getPsFeeAmt() {
        return this.psFeeAmt;
    }

    /**
     * 应还费用
     * @param psFeeAmt
     */
    public void setPsFeeAmt(BigDecimal psFeeAmt) {
        this.psFeeAmt = psFeeAmt;
    }

    /**
     * 本金积数
     * @return
     */
    public BigDecimal getProdPrcpAmt() {
        return this.prodPrcpAmt;
    }

    /**
     * 本金积数
     * @param prodPrcpAmt
     */
    public void setProdPrcpAmt(BigDecimal prodPrcpAmt) {
        this.prodPrcpAmt = prodPrcpAmt;
    }

    /**
     * 利息积数
     * @return
     */
    public BigDecimal getProdIntAmt() {
        return this.prodIntAmt;
    }

    /**
     * 利息积数
     * @param prodIntAmt
     */
    public void setProdIntAmt(BigDecimal prodIntAmt) {
        this.prodIntAmt = prodIntAmt;
    }

    /**
     * 复利积数
     * @return
     */
    public BigDecimal getProdCommIntAmt() {
        return this.prodCommIntAmt;
    }

    /**
     * 复利积数
     * @param prodCommIntAmt
     */
    public void setProdCommIntAmt(BigDecimal prodCommIntAmt) {
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
    public BigDecimal getPsRemPrcp() {
        return this.psRemPrcp;
    }

    /**
     * 剩余本金
     * @param psRemPrcp
     */
    public void setPsRemPrcp(BigDecimal psRemPrcp) {
        this.psRemPrcp = psRemPrcp;
    }

    /**
     * 已还本金
     * @return
     */
    public BigDecimal getSetlPrcp() {
        return this.setlPrcp;
    }

    /**
     * 已还本金
     * @param setlPrcp
     */
    public void setSetlPrcp(BigDecimal setlPrcp) {
        this.setlPrcp = setlPrcp;
    }

    /**
     * 已还正常利息
     * @return
     */
    public BigDecimal getSetlNormInt() {
        return this.setlNormInt;
    }

    /**
     * 已还正常利息
     * @param setlNormInt
     */
    public void setSetlNormInt(BigDecimal setlNormInt) {
        this.setlNormInt = setlNormInt;
    }

    /**
     * 已还逾期利息
     * @return
     */
    public BigDecimal getSetlOdIntAmt() {
        return this.setlOdIntAmt;
    }

    /**
     * 已还逾期利息
     * @param setlOdIntAmt
     */
    public void setSetlOdIntAmt(BigDecimal setlOdIntAmt) {
        this.setlOdIntAmt = setlOdIntAmt;
    }

    /**
     * 已还复利
     * @return
     */
    public BigDecimal getSetlCommOdInt() {
        return this.setlCommOdInt;
    }

    /**
     * 已还复利
     * @param setlCommOdInt
     */
    public void setSetlCommOdInt(BigDecimal setlCommOdInt) {
        this.setlCommOdInt = setlCommOdInt;
    }

    /**
     * 已还费用
     * @return
     */
    public BigDecimal getSetlFeeAmt() {
        return this.setlFeeAmt;
    }

    /**
     * 已还费用
     * @param setlFeeAmt
     */
    public void setSetlFeeAmt(BigDecimal setlFeeAmt) {
        this.setlFeeAmt = setlFeeAmt;
    }

    /**
     * 执行利率
     * @return
     */
    public BigDecimal getPsIntRate() {
        return this.psIntRate;
    }

    /**
     * 执行利率
     * @param psIntRate
     */
    public void setPsIntRate(BigDecimal psIntRate) {
        this.psIntRate = psIntRate;
    }

    /**
     * 逾期利率
     * @return
     */
    public BigDecimal getPsOdIntRate() {
        return this.psOdIntRate;
    }

    /**
     * 逾期利率
     * @param psOdIntRate
     */
    public void setPsOdIntRate(BigDecimal psOdIntRate) {
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
    public BigDecimal getPsIncTaken() {
        return this.psIncTaken;
    }

    /**
     * 计提利息
     * @param psIncTaken
     */
    public void setPsIncTaken(BigDecimal psIncTaken) {
        this.psIncTaken = psIncTaken;
    }

    /**
     * 计提罚息
     * @return
     */
    public BigDecimal getPsOdIncTaken() {
        return this.psOdIncTaken;
    }

    /**
     * 计提罚息
     * @param psOdIncTaken
     */
    public void setPsOdIncTaken(BigDecimal psOdIncTaken) {
        this.psOdIncTaken = psOdIncTaken;
    }

    /**
     * 减免本金
     * @return
     */
    public BigDecimal getPsWvPrcpAmt() {
        return this.psWvPrcpAmt;
    }

    /**
     * 减免本金
     * @param psWvPrcpAmt
     */
    public void setPsWvPrcpAmt(BigDecimal psWvPrcpAmt) {
        this.psWvPrcpAmt = psWvPrcpAmt;
    }

    /**
     * 减免正常利息
     * @return
     */
    public BigDecimal getPsWvNmInt() {
        return this.psWvNmInt;
    }

    /**
     * 减免正常利息
     * @param psWvNmInt
     */
    public void setPsWvNmInt(BigDecimal psWvNmInt) {
        this.psWvNmInt = psWvNmInt;
    }

    /**
     * 减免罚息
     * @return
     */
    public BigDecimal getPsWvOdInt() {
        return this.psWvOdInt;
    }

    /**
     * 减免罚息
     * @param psWvOdInt
     */
    public void setPsWvOdInt(BigDecimal psWvOdInt) {
        this.psWvOdInt = psWvOdInt;
    }

    /**
     * 减免复利
     * @return
     */
    public BigDecimal getPsWvCommInt() {
        return this.psWvCommInt;
    }

    /**
     * 减免复利
     * @param psWvCommInt
     */
    public void setPsWvCommInt(BigDecimal psWvCommInt) {
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
    public BigDecimal getPsCurOdIncTaken() {
        return this.psCurOdIncTaken;
    }

    /**
     * 当期逾期利息计提金额
     * @param psCurOdIncTaken
     */
    public void setPsCurOdIncTaken(BigDecimal psCurOdIncTaken) {
        this.psCurOdIncTaken = psCurOdIncTaken;
    }

    /**
     * 贴息金额
     * @return
     */
    public BigDecimal getSbsyIntAmt() {
        return this.sbsyIntAmt;
    }

    /**
     * 贴息金额
     * @param sbsyIntAmt
     */
    public void setSbsyIntAmt(BigDecimal sbsyIntAmt) {
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
    public BigDecimal getSbsyRate() {
        return this.sbsyRate;
    }

    /**
     * 贴息利率
     * @param sbsyRate
     */
    public void setSbsyRate(BigDecimal sbsyRate) {
        this.sbsyRate = sbsyRate;
    }

    /**
     * 未结息罚息
     * @return
     */
    public BigDecimal getGrcProdPrcp() {
        return this.grcProdPrcp;
    }

    /**
     * 未结息罚息
     * @param grcProdPrcp
     */
    public void setGrcProdPrcp(BigDecimal grcProdPrcp) {
        this.grcProdPrcp = grcProdPrcp;
    }

    /**
     * 减值罚息
     * @return
     */
    public BigDecimal getGrcProdInt() {
        return this.grcProdInt;
    }

    /**
     * 减值罚息
     * @param grcProdInt
     */
    public void setGrcProdInt(BigDecimal grcProdInt) {
        this.grcProdInt = grcProdInt;
    }

    /**
     * 减值复利
     * @return
     */
    public BigDecimal getGrcProdComm() {
        return this.grcProdComm;
    }

    /**
     * 减值复利
     * @param grcProdComm
     */
    public void setGrcProdComm(BigDecimal grcProdComm) {
        this.grcProdComm = grcProdComm;
    }

    @Override
    public String toString() {
        return " \n[期数=" + id.getPsPerdNo() + ", 日期=" + psDueDt + ",期供："
                + psInstmAmt + ", 利息=" + psNormIntAmt + ", 本金=" + psPrcpAmt
                + ", 剩余本金=" + psRemPrcp + ", 利率=" + psIntRate + "]";
    }
}
