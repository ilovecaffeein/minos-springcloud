package com.caxs.minos.domain.trans;

import java.io.Serializable;

/**
 *  * LmActvLog对应交互类 --发放日志
 * Created by lenovo on 2020/9/4.
 */
public class LmActvLogTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;
    // Fields
    //流水序号
    private Long txLogSeq;
    private String loanNo;	//借据号
    private String prodTyp;	//业务类型
    private String actvDt;	//放款日期
    private Double actvDrawdnAmt;	//放款/退款金额
    private String crLine;		//额度代码
    private String contractNo;	//合同编号
    private String actvApprUsr;	//放款审批用户
    private Double realDownAmt;// 实际发放金额
    private String olInd;	 //是否线上清算
    public String getOlInd() {
        return olInd;
    }
    public void setOlInd(String olInd) {
        this.olInd = olInd;
    }
    // Constructors
    //获取交易流水序号
    public Long getTxLogSeq() {
        return txLogSeq;
    }
    //赋值交易流水序号
    public void setTxLogSeq(Long txLogSeq) {
        this.txLogSeq = txLogSeq;
    }
    /**
     * 获取实际发放金额
     * @return
     */
    public Double getRealDownAmt() {
        return realDownAmt;
    }
    /**
     * 设置实际发放金额
     * @param realDownAmt
     */
    public void setRealDownAmt(Double realDownAmt) {
        this.realDownAmt = realDownAmt;
    }

    /**
     * 发放/退回日志默认构造函数
     * default constructor
     */
    public LmActvLogTrans() {
    }

    /**
     * 发放/退回日志构造函数
     * full constructor
     * */
    public LmActvLogTrans(String loanNo, String prodTyp, String actvDt,
                          Double actvDrawdnAmt, String crLine, String contractNo,
                          String actvApprUsr,String olInd) {
        this.loanNo = loanNo;
        this.prodTyp = prodTyp;
        this.actvDt = actvDt;
        this.actvDrawdnAmt = actvDrawdnAmt;
        this.crLine = crLine;
        this.contractNo = contractNo;
        this.actvApprUsr = actvApprUsr;
        this.olInd=olInd;
    }

    // Property accessors
    /**
     * 获取借据号
     * @return
     */
    public String getLoanNo() {
        return this.loanNo;
    }
    /**
     * 设置借据号
     * @param loanNo
     */
    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }
    /**
     * 获取业务类型
     * @return
     */
    public String getProdTyp() {
        return this.prodTyp;
    }
    /**
     * 设置业务类型
     * @param prodTyp
     */
    public void setProdTyp(String prodTyp) {
        this.prodTyp = prodTyp;
    }
    /**
     * 获取发放日期
     * @return
     */
    public String getActvDt() {
        return this.actvDt;
    }
    /**
     * 设置发放日期
     * @param actvDt
     */
    public void setActvDt(String actvDt) {
        this.actvDt = actvDt;
    }
    /**
     * 获取放款/退款金额
     * @return
     */
    public Double getActvDrawdnAmt() {
        return this.actvDrawdnAmt;
    }
    /**
     * 设置放款/退款金额
     * @param actvDrawdnAmt
     */
    public void setActvDrawdnAmt(Double actvDrawdnAmt) {
        this.actvDrawdnAmt = actvDrawdnAmt;
    }
    /**
     * 获取额度代码
     * @return
     */
    public String getCrLine() {
        return this.crLine;
    }
    /**
     * 设置额度代码
     * @param crLine
     */
    public void setCrLine(String crLine) {
        this.crLine = crLine;
    }
    /**
     * 获取合同编号
     * @return
     */
    public String getContractNo() {
        return this.contractNo;
    }
    /**
     * 设置合同编号
     * @param contractNo
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }
    /**
     * 获取放款审批用户
     * @return
     */
    public String getActvApprUsr() {
        return this.actvApprUsr;
    }
    /**
     * 设置放款审批用户
     * @param actvApprUsr
     */
    public void setActvApprUsr(String actvApprUsr) {
        this.actvApprUsr = actvApprUsr;
    }
}
