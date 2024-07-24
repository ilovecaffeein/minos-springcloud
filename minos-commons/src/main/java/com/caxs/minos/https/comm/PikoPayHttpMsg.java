package com.caxs.minos.https.comm;

/***
 * @ClassName(类名) : PikoPayHttpMsg
 * @Description(描述) : 代扣查询发送支付报文体
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;
@XmlRootElement(name="document")
public class PikoPayHttpMsg  implements Serializable {
    private String version;
    private String charset;
    private String respCode;
    private String respMsg;
    private String recordCount;
    private String signMethod;

    @XmlElement(name = "queryorder")
    private List<PikoPayHttpList> pikoPayHttpList ;

    @XmlElement(name="version")
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }

    @XmlElement(name="charset")
    public String getCharset() {
        return charset;
    }
    public void setCharset(String charset) {
        this.charset = charset;
    }

    @XmlElement(name="respCode")
    public String getRespCode() {
        return respCode;
    }
    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    @XmlElement(name="respMsg")
    public String getRespMsg() {
        return respMsg;
    }
    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }

    @XmlElement(name="recordCount")
    public String getRecordCount() {
        return recordCount;
    }
    public void setRecordCount(String recordCount) {
        this.recordCount = recordCount;
    }

    @XmlElement(name="signMethod")
    public String getSignMethod() {
        return signMethod;
    }
    public void setSignMethod(String signMethod) {
        this.signMethod = signMethod;
    }

    public List<PikoPayHttpList> getPikoPayHttp() {
        return pikoPayHttpList;
    }
    public void setPikoPayHttp(List<PikoPayHttpList> pikoPayHttpList) {
        pikoPayHttpList = pikoPayHttpList;
    }
}
