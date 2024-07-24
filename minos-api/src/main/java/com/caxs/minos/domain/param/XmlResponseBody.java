package com.caxs.minos.domain.param;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
/***
 * @ClassName(类名) : ResponseBody
 * @Description(描述) : 请求返回值封装模板
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/3 15:54
 */
@XmlRootElement
public class XmlResponseBody {

    /*
     返回码
     */
    protected String errorCode;

    /*
     返回码描述
     */
    protected String errorMsg;

    @XmlElement(name = "errorCode")
    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @XmlElement(name = "errorMsg")
    public String getErrorMsg() {
        return errorMsg;
    }
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        XmlResponseBody that = (XmlResponseBody) o;
        return errorCode.equals(that.errorCode) && errorMsg.equals(that.errorMsg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorCode, errorMsg);
    }
}
