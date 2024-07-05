package com.caxs.minos.domain.common.reponse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.math.BigDecimal;
/***
 * @ClassName(类名) : PaymentShd
 * @Description(描述) : TODD
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/5 10:19
 */
public class PaymentShd implements Serializable {
    @XmlElement(name = "PERD_NO")
    private Integer    perdNo;

    @XmlElement(name = "DUE_DT")
    private String   dueDt;

    @XmlElement(name = "INSTM_AMT")
    private BigDecimal   instmAmt;

    @XmlElement(name = "NORM_INT")
    private BigDecimal   normInt;

    @XmlElement(name = "OD_INT")
    private BigDecimal   odInt;

    @XmlElement(name = "COMM_INT")
    private BigDecimal   commInt;

    @XmlElement(name = "PRCP_AMT")
    private BigDecimal   prcpAmt;

    @XmlElement(name = "PROD_PRCP_AMT")
    private BigDecimal   prodPrcpAmt;

    @XmlElement(name = "PROD_INT_AMT")
    private BigDecimal   prodIntAmt;

    @XmlElement(name = "PROD_COMM_INT_AMT")
    private BigDecimal   prodCommIntAmt;

    @XmlElement(name = "SETL_NORM_INT")
    private BigDecimal   setlNormInt;

    @XmlElement(name = "SETL_PRCP")
    private BigDecimal   setlPrcp;

    @XmlElement(name = "SETL_COMM_OD_INT")
    private BigDecimal   setlCommOdInt;

    @XmlElement(name = "SETL_OD_INT_AMT")
    private BigDecimal   setlOdIntAmt;

    @XmlElement(name = "PS_INT_RATE")
    private BigDecimal   psIntRate;

    @XmlElement(name = "PS_OD_INT_RATE")
    private BigDecimal   psOdIntRate;

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
    public String getDueDt() {
        return dueDt;
    }
    public void setDueDt(String dueDt) {
        this.dueDt = dueDt;
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
    public BigDecimal getOdInt() {
        return odInt;
    }
    public void setOdInt(BigDecimal odInt) {
        this.odInt = odInt;
    }

    @XmlTransient
    public BigDecimal getCommInt() {
        return commInt;
    }
    public void setCommInt(BigDecimal commInt) {
        this.commInt = commInt;
    }

    @XmlTransient
    public BigDecimal getPrcpAmt() {
        return prcpAmt;
    }
    public void setPrcpAmt(BigDecimal prcpAmt) {
        this.prcpAmt = prcpAmt;
    }

    @XmlTransient
    public BigDecimal getProdPrcpAmt() {
        return prodPrcpAmt;
    }
    public void setProdPrcpAmt(BigDecimal prodPrcpAmt) {
        this.prodPrcpAmt = prodPrcpAmt;
    }

    @XmlTransient
    public BigDecimal getProdIntAmt() {
        return prodIntAmt;
    }
    public void setProdIntAmt(BigDecimal prodIntAmt) {
        this.prodIntAmt = prodIntAmt;
    }

    @XmlTransient
    public BigDecimal getProdCommIntAmt() {
        return prodCommIntAmt;
    }
    public void setProdCommIntAmt(BigDecimal prodCommIntAmt) {
        this.prodCommIntAmt = prodCommIntAmt;
    }

    @XmlTransient
    public BigDecimal getSetlNormInt() {
        return setlNormInt;
    }
    public void setSetlNormInt(BigDecimal setlNormInt) {
        this.setlNormInt = setlNormInt;
    }

    @XmlTransient
    public BigDecimal getSetlPrcp() {
        return setlPrcp;
    }
    public void setSetlPrcp(BigDecimal setlPrcp) {
        this.setlPrcp = setlPrcp;
    }

    @XmlTransient
    public BigDecimal getSetlCommOdInt() {
        return setlCommOdInt;
    }
    public void setSetlCommOdInt(BigDecimal setlCommOdInt) {
        this.setlCommOdInt = setlCommOdInt;
    }

    @XmlTransient
    public BigDecimal getSetlOdIntAmt() {
        return setlOdIntAmt;
    }
    public void setSetlOdIntAmt(BigDecimal setlOdIntAmt) {
        this.setlOdIntAmt = setlOdIntAmt;
    }

    @XmlTransient
    public BigDecimal getPsIntRate() {
        return psIntRate;
    }
    public void setPsIntRate(BigDecimal psIntRate) {
        this.psIntRate = psIntRate;
    }

    @XmlTransient
    public BigDecimal getPsOdIntRate() {
        return psOdIntRate;
    }
    public void setPsOdIntRate(BigDecimal psOdIntRate) {
        this.psOdIntRate = psOdIntRate;
    }

    @XmlTransient
    public BigDecimal getPsRemPrcp() {
        return psRemPrcp;
    }
    public void setPsRemPrcp(BigDecimal psRemPrcp) {
        this.psRemPrcp = psRemPrcp;
    }
}