package com.caxs.minos.domain.param.serv10000100040.xmlResponse;

import com.caxs.minos.domain.common.reponse.PayShdTryListAll;
import com.caxs.minos.domain.common.reponse.PaymentShd;
import com.caxs.minos.domain.param.XmlResponseBody;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/***
 * @ClassName(类名) : Serv10000100040XmlResponse
 * @Description(描述) : TODD
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/5 10:21
 */
@XmlRootElement(name = "msgall")
@XmlType(propOrder = {"loanNo","prcpAmt","normInt","odInt","commInt","actvNormInt","actvPrcp","relPerdCnt","feeAmt","payShdTryListAll","paymentShdList"})
public class Serv10000100040XmlResponse extends XmlResponseBody {
    @XmlElement(name="LOAN_NO")
    private String   loanNo;

    @XmlElement(name="PRCP_AMT")
    private BigDecimal prcpAmt;

    @XmlElement(name="NORM_INT")
    private BigDecimal  normInt;

    @XmlElement(name="OD_INT")
    private BigDecimal  odInt;

    @XmlElement(name="COMM_INT")
    private BigDecimal   commInt;

    @XmlElement(name="ACTV_NORM_INT")
    private BigDecimal   actvNormInt;

    @XmlElement(name="ACTV_PRCP")
    private BigDecimal   actvPrcp;

    @XmlElement(name="REL_PERD_CNT")
    private Integer  relPerdCnt;

    @XmlElement(name="FEE_AMT")
    private BigDecimal   feeAmt;

    @XmlElementWrapper(name = "ActvPayShdTryListAll")
    @XmlElement(name = "MX")
    private List<PayShdTryListAll> payShdTryListAll = new ArrayList<>();

    @XmlElementWrapper(name = "PaymentShd")
    @XmlElement(name = "MX")
    private List<PaymentShd> paymentShdList = new ArrayList<>();

    @XmlTransient
    public List<PayShdTryListAll> getPayShdTryListAll() {
        return payShdTryListAll;
    }
    public void setPayShdTryListAll(List<PayShdTryListAll> payShdTryListAll) {
        this.payShdTryListAll = payShdTryListAll;
    }

    @XmlTransient
    public List<PaymentShd> getPaymentShdList() {
        return paymentShdList;
    }
    public void setPaymentShdList(List<PaymentShd> paymentShdList) {
        this.paymentShdList = paymentShdList;
    }

    @XmlTransient
    public String getLoanNo() {
        return loanNo;
    }
    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    @XmlTransient
    public BigDecimal getPrcpAmt() {
        return prcpAmt;
    }
    public void setPrcpAmt(BigDecimal prcpAmt) {
        this.prcpAmt = prcpAmt;
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
    public BigDecimal getActvNormInt() {
        return actvNormInt;
    }
    public void setActvNormInt(BigDecimal actvNormInt) {
        this.actvNormInt = actvNormInt;
    }

    @XmlTransient
    public BigDecimal getActvPrcp() {
        return actvPrcp;
    }
    public void setActvPrcp(BigDecimal actvPrcp) {
        this.actvPrcp = actvPrcp;
    }

    @XmlTransient
    public Integer getRelPerdCnt() {
        return relPerdCnt;
    }
    public void setRelPerdCnt(Integer relPerdCnt) {
        this.relPerdCnt = relPerdCnt;
    }

    @XmlTransient
    public BigDecimal getFeeAmt() {
        return feeAmt;
    }
    public void setFeeAmt(BigDecimal feeAmt) {
        this.feeAmt = feeAmt;
    }
}
