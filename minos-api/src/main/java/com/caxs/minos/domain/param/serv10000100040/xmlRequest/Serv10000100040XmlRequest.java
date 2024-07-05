package com.caxs.minos.domain.param.serv10000100040.xmlRequest;


import com.caxs.minos.domain.param.XmlRequestBody;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
/***
 * @ClassName(类名) : Serv10000100040XmlRequest
 * @Description(描述) : TODD
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/5 10:21
 */
@XmlRootElement(name = "msgbody")
@XmlType(propOrder = {"LOAN_NO","ACTV_PAY_AMT","REL_PERD_CNT","PP_RAT_BASE","PAYM_MODE"})
public class Serv10000100040XmlRequest  extends XmlRequestBody {
    @XmlElement(name="LOAN_NO")
    private String   LOAN_NO;

    @XmlElement(name="ACTV_PAY_AMT")
    private Double   ACTV_PAY_AMT;

    @XmlElement(name="REL_PERD_CNT")
    private String   REL_PERD_CNT;

    @XmlElement(name="PP_RAT_BASE")
    private String   PP_RAT_BASE;

    @XmlElement(name="PAYM_MODE")
    private String   PAYM_MODE;

    @XmlTransient
    public String getLOAN_NO() {
        return LOAN_NO;
    }
    public void setLOAN_NO(String lOANNO) {
        LOAN_NO = lOANNO;
    }

    @XmlTransient
    public Double getACTV_PAY_AMT() {
        return ACTV_PAY_AMT;
    }
    public void setACTV_PAY_AMT(Double aCTVPAYAMT) {
        ACTV_PAY_AMT = aCTVPAYAMT;
    }

    @XmlTransient
    public String getREL_PERD_CNT() {
        return REL_PERD_CNT;
    }
    public void setREL_PERD_CNT(String rELPERDCNT) {
        REL_PERD_CNT = rELPERDCNT;
    }

    @XmlTransient
    public String getPP_RAT_BASE() {
        return PP_RAT_BASE;
    }
    public void setPP_RAT_BASE(String pPRATBASE) {
        PP_RAT_BASE = pPRATBASE;
    }

    @XmlTransient
    public String getPAYM_MODE() {
        return PAYM_MODE;
    }
    public void setPAYM_MODE(String pAYMMODE) {
        PAYM_MODE = pAYMMODE;
    }
}
