package com.caxs.minos.domain.trans;

import java.io.Serializable;

/**
 * Created by lenovo on 2020/9/30.
 */
public class PakAgeDataTrans implements Serializable {

    private static final long serialVersionUID = 1L;
    private long   txseq;           //序号
    private String merId;			//商户号
    private String payType;		    //接口类型
    private String transType;		//交易类型
    private String orderNumber;	    //订单号
    private String orderAmount;		//订单金额(分)
    private String orderCurrency;	//交易币种
    private String accName;		    //姓名
    private String accNo;			//银行卡号
    private String bankNo;			//开户行联行号
    private String protocolNo;      //协议号
    private String agentAmount;     //交易拆分
    private String loanNo;	        //备注
    private String Mtime;	        //时间
    private String succflag;	    //交易状态
    private String subtxseq;	    //清算平台流水号
    private String txMemo;	        //交易摘要
    private String pchCde;    //扣款渠道

    public String getPchCde() {
        return pchCde;
    }
    public void setPchCde(String pchCde) {
        this.pchCde = pchCde;
    }
    public String getTxMemo() {
        return txMemo;
    }
    public void setTxMemo(String txMemo) {
        this.txMemo = txMemo;
    }
    public String getBankNo() {
        return bankNo;
    }
    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }
    public String getPayType() {
        return payType;
    }
    public void setPayType(String payType) {
        this.payType = payType;
    }
    public String getSuccflag() {
        return succflag;
    }
    public void setSuccflag(String succflag) {
        this.succflag = succflag;
    }
    public String getSubtxseq() {
        return subtxseq;
    }
    public void setSubtxseq(String subtxseq) {
        this.subtxseq = subtxseq;
    }
    public String getMtime() {
        return Mtime;
    }
    public void setMtime(String Mtime) {
        this.Mtime = Mtime;
    }
    public long getTxseq() {
        return txseq;
    }
    public void setTxseq(long txseq) {
        this.txseq = txseq;
    }
    public String getMerId() {
        return merId;
    }
    public void setMerId(String merId) {
        this.merId = merId;
    }
    public String getTransType() {
        return transType;
    }
    public void setTransType(String transType) {
        this.transType = transType;
    }
    public String getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    public String getOrderAmount() {
        return orderAmount;
    }
    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }
    public String getOrderCurrency() {
        return orderCurrency;
    }
    public void setOrderCurrency(String orderCurrency) {
        this.orderCurrency = orderCurrency;
    }
    public String getAccName() {
        return accName;
    }
    public void setAccName(String accName) {
        this.accName = accName;
    }
    public String getAccNo() {
        return accNo;
    }
    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }
    public String getProtocolNo() {
        return protocolNo;
    }
    public void setProtocolNo(String protocolNo) {
        this.protocolNo = protocolNo;
    }
    public String getAgentAmount() {
        return agentAmount;
    }
    public void setAgentAmount(String agentAmount) {
        this.agentAmount = agentAmount;
    }
    public String getLoanNo() {
        return loanNo;
    }
    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public PakAgeDataTrans(){
    }

    public PakAgeDataTrans(long txseq, String merId, String transType,
                      String orderNumber,String orderAmount,
                      String orderCurrency,String accName,String accNo,
                      String protocolNo,String agentAmount,String loanNo,String Mtime,
                      String succflag,String subtxseq,String payType,
                      String bankNo,String txMemo,String pchCde) {
        this.txseq = txseq;
        this.merId = merId;
        this.transType = transType;
        this.orderNumber = orderNumber;
        this.orderAmount = orderAmount;
        this.orderCurrency = orderCurrency;
        this.accName = accName;
        this.accNo = accNo;
        this.protocolNo = protocolNo;
        this.agentAmount = agentAmount;
        this.loanNo = loanNo;
        this.Mtime = Mtime;
        this.succflag = succflag;
        this.subtxseq = subtxseq;
        this.payType = payType;
        this.bankNo = bankNo;
        this.txMemo=txMemo;
        this.pchCde = pchCde;
    }
}
