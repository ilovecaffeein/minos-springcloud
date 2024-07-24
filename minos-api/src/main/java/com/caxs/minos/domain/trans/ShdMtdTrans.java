package com.caxs.minos.domain.trans;

import com.caxs.minos.domain.LmPmShd;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName: ShdMtdTrans
 * @Description: 还款方式参数
 * @Author: coffee
 * @Date: 2020/7/28 14:24
 * @Version: v1.0 文件初始创建
 */
public class ShdMtdTrans implements Serializable {

    private static final long serialVersionUID = 1L;
    private LmPmShd lmPmShdDomain;    //借据号
    private String loanNo;            //借据号
    private BigDecimal loanIntRate;   //贷款执行利率
    private BigDecimal loanOdIntRate; //贷款罚息执行利率
    private String firstPayDate;      //首次还款日
    private String intStartDt;        //起息日
    private String lastDueDt;         //最后到日
    private BigDecimal termPrcpAmt;   //贷款金额
    private Short  termNo;            //序号
    private String mtdCde;            //还款方式代码
    private String mtdTyp;            //还款方式种类
    private Integer mtdMinTnr;        //支持最小期限(月)
    private Integer mtdMaxTnr;        //支持最大期限(月)
    private Integer mtdInstl;         //执行期数
    private BigDecimal mtdPrcpRatio;  //本金比例
    private String mtdCalcTnr;        //计算期限
    private String mtdRpymOpt;        //还款方式
    private String mtdPaymTyp;        //还款类型
    private String mtdIntBase;        //利息计算基础
    private String mtdRateBase;       //利息计算基础
    private String mtdModiInd;        //是否允许修改
    private String mtdBaseTyp;        //利率类型
    private String mtdBatBase;        //利率计算基础
    private String instmInd;          //首期期供标志(Y:次月还款，N：当月还款)
    private String lastTmInd;         //末期供标志(Y:当月一次还款，N：当月二次还款)
    private Integer payDay;           //还款日
    private Integer nextMtdInstl;     //下次执行期数

    public LmPmShd getLmPmShdDomain() {
        return lmPmShdDomain;
    }
    public void setLmPmShdDomain(LmPmShd lmPmShdDomain) {
        this.lmPmShdDomain = lmPmShdDomain;
    }

    public Integer getNextMtdInstl() {
        return nextMtdInstl;
    }
    public void setNextMtdInstl(Integer nextMtdInstl) {
        this.nextMtdInstl = nextMtdInstl;
    }
    public String getFirstPayDate(){
        return firstPayDate;
    }
    public void setFirstPayDate(String firstPayDate) {
        this.firstPayDate = firstPayDate;
    }

    public String getMtdTyp(){
        return mtdTyp;
    }
    public void setMtdTyp(String mtdTyp) {
        this.mtdTyp = mtdTyp;
    }

    public Integer getMtdMinTnr() {
        return mtdMinTnr;
    }
    public void setMtdMinTnr(Integer mtdMinTnr) {
        this.mtdMinTnr = mtdMinTnr;
    }

    public Integer getMtdMaxTnr() {
        return mtdMaxTnr;
    }
    public void setMtdMaxTnr(Integer mtdMaxTnr) {
        this.mtdMaxTnr = mtdMaxTnr;
    }

    public String getInstmInd() {
        return instmInd;
    }
    public void setInstmInd(String instmInd) {
        this.instmInd = instmInd;
    }

    public String getLastTmInd() {
        return lastTmInd;
    }
    public void setLastTmInd(String lastTmInd) {
        this.lastTmInd = lastTmInd;
    }


    public BigDecimal getTermPrcpAmt() {
        return termPrcpAmt;
    }
    public void setTermPrcpAmt(BigDecimal termPrcpAmt) {
        this.termPrcpAmt = termPrcpAmt;
    }

    public String getLoanNo() {
        return loanNo;
    }
    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }
    public BigDecimal getLoanIntRate() {
        return loanIntRate;
    }
    public void setLoanIntRate(BigDecimal loanIntRate) {
        this.loanIntRate = loanIntRate;
    }
    public BigDecimal getLoanOdIntRate() {
        return loanOdIntRate;
    }
    public void setLoanOdIntRate(BigDecimal loanOdIntRate) {
        this.loanOdIntRate = loanOdIntRate;
    }
    public String getIntStartDt() {
        return intStartDt;
    }
    public void setIntStartDt(String intStartDt) {
        this.intStartDt = intStartDt;
    }
    public String getLastDueDt() {
        return lastDueDt;
    }
    public void setLastDueDt(String lastDueDt) {
        this.lastDueDt = lastDueDt;
    }
    public Short getTermNo() {
        return termNo;
    }
    public void setTermNo(Short termNo) {
        this.termNo = termNo;
    }
    public String getMtdCde() {
        return mtdCde;
    }
    public void setMtdCde(String mtdCde) {
        this.mtdCde = mtdCde;
    }
    public int getMtdInstl() {
        return mtdInstl;
    }
    public void setMtdInstl(int mtdInstl) {
        this.mtdInstl = mtdInstl;
    }
    public BigDecimal getMtdPrcpRatio() {
        return mtdPrcpRatio;
    }
    public void setMtdPrcpRatio(BigDecimal mtdPrcpRatio) {
        this.mtdPrcpRatio = mtdPrcpRatio;
    }
    public String getMtdCalcTnr() {
        return mtdCalcTnr;
    }
    public void setMtdCalcTnr(String mtdCalcTnr) { this.mtdCalcTnr = mtdCalcTnr; }
    public String getMtdRpymOpt() {
        return mtdRpymOpt;
    }
    public void setMtdRpymOpt(String mtdRpymOpt) {
        this.mtdRpymOpt = mtdRpymOpt;
    }
    public String getMtdPaymTyp() {
        return mtdPaymTyp;
    }
    public void setMtdPaymTyp(String mtdSetlTyp) {
        this.mtdPaymTyp = mtdSetlTyp;
    }

    public String getMtdRateBase() {
        return mtdRateBase;
    }
    public void setMtdRateBase(String mtdRateBase) {
        this.mtdRateBase = mtdRateBase;
    }

    public String getMtdIntBase() {
        return mtdIntBase;
    }
    public void setMtdIntBase(String mtdIntBase) {
        this.mtdIntBase = mtdIntBase;
    }

    public String getMtdModiInd() {
        return mtdModiInd;
    }
    public void setMtdModiInd(String mtdModiInd) {
        this.mtdModiInd = mtdModiInd;
    }

    public String getMtdBaseTyp() {
        return mtdBaseTyp;
    }
    public void setMtdBaseTyp(String mtdBaseTyp) {
        this.mtdBaseTyp = mtdBaseTyp;
    }

    public String getMtdBatBase() {
        return mtdBatBase;
    }
    public void setMtdBatBase(String mtdBatBase) {
        this.mtdBatBase = mtdBatBase;
    }

    public int getPayDay() {
        return payDay;
    }

    public void setPayDay(Integer payDay) {
        this.payDay = payDay;
    }

    public  ShdMtdTrans(String intStartDt,int mtdInstl,String instmInd){
        this.intStartDt  =intStartDt ;
        this.mtdInstl  =mtdInstl ;
        this.instmInd  =instmInd ;
    }
}
