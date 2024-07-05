package com.caxs.minos.domain.param;

import javax.xml.bind.annotation.XmlElement;
/***
 * @ClassName(类名) : RequsetBody
 * @Description(描述) : TODD
 * @author(作者) ： fengdetian
 * @date (开发日期) ： 2020/8/5 10:19
 */
public class XmlRequestBody {

    private String serviceId;

    @XmlElement(name = "serviceId")
    public String getServiceId() {
        return serviceId;
    }
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }
}
