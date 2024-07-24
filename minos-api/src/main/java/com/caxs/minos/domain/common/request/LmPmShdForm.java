package com.caxs.minos.domain.common.request;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/***
 * @ClassName(类名) : LmPmShdForm
 * @Description(描述) : TODD
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/5 10:19
 */
@XmlRootElement(name = "MX")
public class LmPmShdForm implements Serializable {
    @XmlElement(name = "LOAN_NO")
    private String   loanNo;

    @XmlElement(name = "PS_PERD_NO")
    private String   psPerdNo;

    @XmlElement(name = "PS_DUE_DT")
    private String   psDueDt;

    @XmlElement(name = "PS_PRCP_AMT")
    private String   psPrcpAmt;

    @XmlElement(name = "PS_NORM_INT_AMT")
    private String   psNormIntAmt;

    @XmlTransient
    public String getLoanNo() {
        return this.loanNo;
    }
    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    @XmlTransient
    public String getPsPerdNo() {
        return psPerdNo;
    }
    public void setPsPerdNo(String psPerdNo) {
        this.psPerdNo = psPerdNo;
    }

    @XmlTransient
    public String getPsDueDt() {
        return psDueDt;
    }
    public void setPsDueDt(String psDueDt) {
        this.psDueDt = psDueDt;
    }

    @XmlTransient
    public String getPsPrcpAmt() {
        return psPrcpAmt;
    }
    public void setPsPrcpAmt(String psPrcpAmt) {
        this.psPrcpAmt = psPrcpAmt;
    }

    @XmlTransient
    public String getPsNormIntAmt() {
        return psNormIntAmt;
    }
    public void setPsNormIntAmt(String psNormIntAmt) {
        this.psNormIntAmt = psNormIntAmt;
    }

}
