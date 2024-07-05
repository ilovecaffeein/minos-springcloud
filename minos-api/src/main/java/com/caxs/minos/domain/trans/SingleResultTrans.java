package com.caxs.minos.domain.trans;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * @ClassName: SingleResultTrans
 * @Description: 调第三方返回结果类
 * @Author: coffee
 * @Date: 2020/7/28 14:24
 * @Version: v1.0 文件初始创建
 */
public class SingleResultTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;

    String  respCode;
    String  respMsg;
    String  status  ;
    String  pchCde  ;
    BigDecimal payAmount;

    public BigDecimal getPayAmount() {
        return payAmount;
    }
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getPchCde() {
        return pchCde;
    }
    public void setPchCde(String pchCde) {
        this.pchCde = pchCde;
    }


    public String getRespCode() {
        return respCode;
    }
    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }
    public String getRespMsg() {
        return respMsg;
    }
    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
