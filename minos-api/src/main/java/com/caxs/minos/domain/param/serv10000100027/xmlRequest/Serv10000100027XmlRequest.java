package com.caxs.minos.domain.param.serv10000100027.xmlRequest;


import com.caxs.minos.domain.common.request.LmDnShdMtdForm;
import com.caxs.minos.domain.common.request.LmPmShdForm;
import com.caxs.minos.domain.param.XmlRequestBody;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/***
 * @ClassName(类名) :
 * @Description(描述) : TODD
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/5 10:21
 */
@XmlRootElement(name = "msgbody")
public class Serv10000100027XmlRequest extends XmlRequestBody implements Serializable {
    @XmlElement(name="ORIG_PRCP")
    private BigDecimal   origPrcp;

    @XmlElement(name="DUE_DAY")
    private String   dueDay;

    @XmlElement(name="INT_START_DT")
    private String   intStartDt;

    @XmlElement(name="LAST_DUE_DT")
    private String   lastDueDt;

    @XmlElement(name="PAYM_FREQ_UNIT")
    private String   paymFreqUnit;

    @XmlElement(name="PAYM_FREQ_FREQ")
    private String   paymFreqFreq;

    @XmlElement(name="LOAN_ACTV_DT")
    private String   loanActvDt;

    @XmlElement(name="INSTM_IND")
    private String   instmInd;

    @XmlElement(name="LOAN_PAYM_TYP")
    private String   loanPaymTyp;

    @XmlElement(name="LOAN_TYP")
    private String   loanTyp;

    @XmlElement(name="LOAN_INT_RATE")
    private BigDecimal   loanIntRate;

    @XmlElement(name="LOAN_PAYM_MTD")
    private String   loanPaymMtd;

    @XmlElement(name="TNR")
    private Integer   tnr;

    @XmlElementWrapper(name = "LmDnShdMtdTList")
    @XmlElement(name = "MX")
    private List<LmDnShdMtdForm> lmDnShdMtdTList = new ArrayList<LmDnShdMtdForm>();

    @XmlElementWrapper(name = "LmPmShdTList")
    @XmlElement(name = "MX")
    private List<LmPmShdForm> lmPmShdTList = new ArrayList<LmPmShdForm>();

    @XmlTransient
    public List<LmDnShdMtdForm> getLmDnShdMtdTList() {
        return lmDnShdMtdTList;
    }
    public void setLmDnShdMtdTList(List<LmDnShdMtdForm> lmDnShdMtdTList) {
        this.lmDnShdMtdTList = lmDnShdMtdTList;
    }

    @XmlTransient
    public List<LmPmShdForm> getLmPmShdTList() {
        return lmPmShdTList;
    }
    public void setLmPmShdTList(List<LmPmShdForm> lmPmShdTList) {
        this.lmPmShdTList = lmPmShdTList;
    }

    @XmlTransient
    public BigDecimal getOrigPrcp() {
        return origPrcp;
    }
    public void setOrigPrcp(BigDecimal origPrcp) {
        this.origPrcp = origPrcp;
    }

    @XmlTransient
    public String getDueDay() {
        return dueDay;
    }
    public void setDueDay(String dueDay) {
        this.dueDay = dueDay;
    }

    @XmlTransient
    public String getIntStartDt() {
        return intStartDt;
    }
    public void setIntStartDt(String intStartDt) {
        this.intStartDt = intStartDt;
    }

    @XmlTransient
    public String getLastDueDt() {
        return lastDueDt;
    }
    public void setLastDueDt(String lastDueDt) {
        this.lastDueDt = lastDueDt;
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
    public String getLoanPaymTyp() {
        return loanPaymTyp;
    }
    public void setLoanPaymTyp(String loanPaymTyp) {
        this.loanPaymTyp = loanPaymTyp;
    }

    @XmlTransient
    public String getInstmInd() {
        return instmInd;
    }
    public void setInstmInd(String instmInd) {
        this.instmInd = instmInd;
    }

    @XmlTransient
    public String getLoanActvDt() {
        return loanActvDt;
    }
    public void setLoanActvDt(String loanActvDt) {
        this.loanActvDt = loanActvDt;
    }

    @XmlTransient
    public String getLoanTyp() {
        return loanTyp;
    }
    public void setLoanTyp(String loanTyp) {
        this.loanTyp = loanTyp;
    }

    @XmlTransient
    public BigDecimal getLoanIntRate() {
        return loanIntRate;
    }
    public void setLoanIntRate(BigDecimal loanIntRate) {
        this.loanIntRate = loanIntRate;
    }

    @XmlTransient
    public String getLoanPaymMtd() {
        return loanPaymMtd;
    }
    public void setLoanPaymMtd(String loanPaymMtd) {
        this.loanPaymMtd = loanPaymMtd;
    }

    @XmlTransient
    public Integer getTnr() {
        return tnr;
    }
    public void setTnr(Integer tnr) {
        this.tnr = tnr;
    }
}
