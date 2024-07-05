package com.caxs.minos.domain.common.reponse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
/***
 * @ClassName(类名) : ActvPayShdTryListAll
 * @Description(描述) : TODD
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/5 10:19
 */
public class ActvPayShdTryListAll implements Serializable {
    @XmlElement(name = "PERD_NO")
    private Integer    perdNo;

    @XmlElement(name = "PRCP_AMT")
    private BigDecimal   prcpAmt;

    @XmlElement(name = "INSTM_AMT")
    private BigDecimal   instmAmt;

    @XmlElement(name = "NORM_INT")
    private BigDecimal   normInt;

    @XmlElement(name = "INT_RATE")
    private BigDecimal   intRate;

    @XmlElement(name = "OD_INT_RATE")
    private BigDecimal   odIntRate;

    @XmlElement(name = "DUE_DT")
    private String   dueDt;

    @XmlElement(name = "PS_REM_PRCP")
    private BigDecimal   psRemPrcp;

    @XmlTransient
    public Integer getPerdNo() {
        return perdNo;
    }
    public void setPerdNo(Integer perdNo) {
        this.perdNo = perdNo;
    }

    @XmlTransient
    public BigDecimal getPrcpAmt() {
        return prcpAmt;
    }
    public void setPrcpAmt(BigDecimal prcpAmt) {
        this.prcpAmt = prcpAmt;
    }

    @XmlTransient
    public BigDecimal getInstmAmt() {
        return instmAmt;
    }
    public void setInstmAmt(BigDecimal instmAmt) {
        this.instmAmt = instmAmt;
    }

    @XmlTransient
    public BigDecimal getNormInt() {
        return normInt;
    }
    public void setNormInt(BigDecimal normInt) {
        this.normInt = normInt;
    }

    @XmlTransient
    public BigDecimal getIntRate() {
        return intRate;
    }
    public void setIntRate(BigDecimal intRate) {
        this.intRate = intRate;
    }

    @XmlTransient
    public BigDecimal getOdIntRate() {
        return odIntRate;
    }
    public void setOdIntRate(BigDecimal odIntRate) {
        this.odIntRate = odIntRate;
    }

    @XmlTransient
    public String getDueDt() {
        return dueDt;
    }
    public void setDueDt(String dueDt) {
        this.dueDt = dueDt;
    }

    @XmlTransient
    public BigDecimal getPsRemPrcp() {
        return psRemPrcp;
    }
    public void setPsRemPrcp(BigDecimal psRemPrcp) {
        this.psRemPrcp = psRemPrcp;
    }
}
