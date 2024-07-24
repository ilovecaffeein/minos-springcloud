package com.caxs.minos.domain.common.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/***
 * @ClassName(类名) : LmDnShdMtdForm
 * @Description(描述) : TODD
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/5 10:19
 */
public class LmDnShdMtdForm implements Serializable {
    @XmlElement(name = "TERM_NO")
    private String   termNo;

    @XmlElement(name = "TERM_NO")
    private String   frmPerd;

    @XmlElement(name = "FRM_PERD")
    private String   toPerd;

    @XmlElement(name = "PRCP_AMT")
    private String   prcpAmt;

    @XmlElement(name = "PAYM_FREQ_UNIT")
    private String   paymFreqUnit;

    @XmlElement(name = "PAYM_FREQ_FREQ")
    private String   paymFreqFreq;

    @XmlElement(name = "LOAN_INT_RATE")
    private String   loanIntRate;

    @XmlElement(name = "TERM_PRCP_AMT")
    private String   termPrcpAmt;

    @XmlElement(name = "PGS_PRCP_PCT")
    private String   pgsPrcpPct;

    @XmlElement(name = "PGS_PRCP_AMT")
    private String   pgsPrcpAmt;

    @XmlElement(name = "PGS_PRCP_FREQ")
    private String   pgsPrcpFreq;

    @XmlElement(name = "CAL_TOT_INSTM")
    private String   calTotInstm;

    @XmlElement(name = "PRCP_PCT")
    private String   prcpPct;

    @XmlElement(name = "RAT_BASE")
    private String   ratBase;

    @XmlElement(name = "INT_START_DT")
    private String   intStartDt;

    @XmlElement(name = "LOAN_OD_INT_RATE")
    private String   loanOdIntRate;

    @XmlElement(name = "PAYM_TYP")
    private String   paymTyp;

    @XmlElement(name = "PAYM_OPT")
    private String   paymPpt;

    @XmlTransient
    public String getTermNo() {
        return termNo;
    }
    public void setTermNo(String termNo) {
        this.termNo = termNo;
    }

    @XmlTransient
    public String getFrmPerd() {
        return frmPerd;
    }
    public void setFrmPerd(String frmPerd) {
        this.frmPerd = frmPerd;
    }

    @XmlTransient
    public String getToPerd() {
        return toPerd;
    }
    public void setToPerd(String toPerd) {
        this.toPerd = toPerd;
    }

    @XmlTransient
    public String getPrcpAmt() {
        return prcpAmt;
    }
    public void setPrcpAmt(String prcpAmt) {
        this.prcpAmt = prcpAmt;
    }

    @XmlTransient
    public String getPaymFreqUnit() {
        return paymFreqUnit;
    }
    public void setPaymFreqUnit(String paymFreqUnit) {
        this.paymFreqUnit = paymFreqUnit;
    }

    @XmlTransient
    public String getPaymFreqFreq() {
        return paymFreqFreq;
    }
    public void setPaymFreqFreq(String paymFreqFreq) {
        this.paymFreqFreq = paymFreqFreq;
    }

    @XmlTransient
    public String getLoanIntRate() {
        return loanIntRate;
    }
    public void setLoanIntRate(String loanIntRate) {
        this.loanIntRate = loanIntRate;
    }

    @XmlTransient
    public String getTermPrcpAmt() {
        return termPrcpAmt;
    }
    public void setTermPrcpAmt(String termPrcpAmt) {
        this.termPrcpAmt = termPrcpAmt;
    }

    @XmlTransient
    public String getPgsPrcpPct() {
        return pgsPrcpPct;
    }
    public void setPgsPrcpPct(String pgsPrcpPct) {
        this.pgsPrcpPct = pgsPrcpPct;
    }

    @XmlTransient
    public String getPgsPrcpAmt() {
        return pgsPrcpAmt;
    }
    public void setPgsPrcpAmt(String pgsPrcpAmt) {
        this.pgsPrcpAmt = pgsPrcpAmt;
    }

    @XmlTransient
    public String getPgsPrcpFreq() {
        return pgsPrcpFreq;
    }
    public void setPgsPrcpFreq(String pgsPrcpFreq) {
        this.pgsPrcpFreq = pgsPrcpFreq;
    }

    @XmlTransient
    public String getCalTotInstm() {
        return calTotInstm;
    }
    public void setCalTotInstm(String calTotInstm) {
        this.calTotInstm = calTotInstm;
    }

    @XmlTransient
    public String getPrcpPct() {
        return prcpPct;
    }
    public void setPrcpPct(String prcpPct) {
        this.prcpPct = prcpPct;
    }

    @XmlTransient
    public String getRatBase() {
        return ratBase;
    }
    public void setRatBase(String ratBase) {
        this.ratBase = ratBase;
    }

    @XmlTransient
    public String getIntStartDt() {
        return intStartDt;
    }
    public void setIntStartDt(String intStartDt) {
        this.intStartDt = intStartDt;
    }

    @XmlTransient
    public String getLoanOdIntRate() {
        return loanOdIntRate;
    }
    public void setLoanOdIntRate(String loanOdIntRate) {
        this.loanOdIntRate = loanOdIntRate;
    }

    @XmlTransient
    public String getPaymTyp() {
        return paymTyp;
    }
    public void setPaymTyp(String paymTyp) {
        this.paymTyp = paymTyp;
    }

    @XmlTransient
    public String getPaymPpt() {
        return paymPpt;
    }
    public void setPaymPpt(String paymPpt) {
        this.paymPpt = paymPpt;
    }

}
