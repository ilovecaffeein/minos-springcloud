package com.caxs.minos.domain.param.serv10000100027.xmlResponse;

import com.caxs.minos.domain.common.reponse.ActvPayShdTryListAll;
import com.caxs.minos.domain.param.XmlResponseBody;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/***
 * @ClassName(类名) : Serv10000100027XmlRequest
 * @Description(描述) : TODD
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/5 10:21
 */
@XmlRootElement(name = "msgall")
public class Serv10000100027XmlResponse extends XmlResponseBody {
    @XmlElement(name = "TOTAL_NORM_INT")
    private BigDecimal totalNormInt;

    @XmlElement(name = "TOTAL_AMT")
    private BigDecimal  totalAmt;

    @XmlElementWrapper(name = "ActvPayShdTryList")
    @XmlElement(name = "MX")
    private List<ActvPayShdTryListAll> actvPayShdTryListAll = new ArrayList<ActvPayShdTryListAll>();

    @XmlTransient
    public List<ActvPayShdTryListAll> getActvPayShdTryListAll() {
        return actvPayShdTryListAll;
    }
    public void setActvPayShdTryListAll(
            List<ActvPayShdTryListAll> actvPayShdTryListAll) {
        this.actvPayShdTryListAll = actvPayShdTryListAll;
    }

    @XmlTransient
    public BigDecimal getTotalAmt() {
        return totalAmt;
    }
    public void setTotalAmt(BigDecimal totalAmt) {
        this.totalAmt = totalAmt;
    }

    @XmlTransient
    public BigDecimal getTotalNormInt() {
        return totalNormInt;
    }
    public void setTotalNormInt(BigDecimal totalNormInt) {
        this.totalNormInt = totalNormInt;
    }

}
