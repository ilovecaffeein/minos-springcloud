package com.caxs.minos.serv.core.comm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
/***
 * @ClassName(类名) : PikoPayHttpList
 * @Description(描述) : 代扣发送支付报文体
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PikoPayHttpList implements Serializable {
    @XmlElement
    private String payType;
    @XmlElement
    private String transType;
    @XmlElement
    private String merId;
    @XmlElement
    private String orderNumber;
    @XmlElement
    private String qid;
    @XmlElement
    private String orderAmount;
    @XmlElement
    private String payAmount;
    @XmlElement
    private String state;
    @XmlElement
    private String refundAmount;
    @XmlElement
    private String orderCurrency;
    @XmlElement
    private String orderTime;
    @XmlElement
    private String merReserved1;
    @XmlElement
    private String merReserved2;
    @XmlElement
    private String merReserved3;
    @XmlElement
    private String sign;
    @XmlElement
    private String pchCde;

    public String getPchCde() {
        return pchCde;
    }
    public void setPchCde(String pchCde) {
        this.pchCde = pchCde;
    }

    public String getPayType() {
        return payType;
    }
    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getTransType() {
        return transType;
    }
    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getMerId() {
        return merId;
    }
    public void setMerId(String merId) {
        this.merId = merId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getQid() {
        return qid;
    }
    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getOrderAmount() {
        return orderAmount;
    }
    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getPayAmount() {
        return payAmount;
    }
    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getRefundAmount() {
        return refundAmount;
    }
    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getOrderCurrency() {
        return orderCurrency;
    }
    public void setOrderCurrency(String orderCurrency) {
        this.orderCurrency = orderCurrency;
    }

    public String getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getMerReserved1() {
        return merReserved1;
    }
    public void setMerReserved1(String merReserved1) {
        this.merReserved1 = merReserved1;
    }

    public String getMerReserved2() {
        return merReserved2;
    }
    public void setMerReserved2(String merReserved2) {
        this.merReserved2 = merReserved2;
    }

    public String getMerReserved3() {
        return merReserved3;
    }
    public void setMerReserved3(String merReserved3) {
        this.merReserved3 = merReserved3;
    }

    public String getSign() {
        return sign;
    }
    public void setSign(String sign) {
        this.sign = sign;
    }
}
