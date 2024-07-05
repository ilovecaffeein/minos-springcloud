package com.caxs.minos.domain.trans;

import java.io.Serializable;

/**
 * Created by lenovo on 2020/8/13.
 */
public class LmFeeTxTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;
    // Fields
    private Long txLogSeq;
    private String loanNo;	//借据号
    private String feeCde;	//费用代码
    private String ccyCde;	//币种
    private String recvPayInd;	//收付标志
    private String feeTyp;		//费用类型
    private Double baseAmt;		//基准金额
    private Double chrgPct;		//费率
    /*
     * 待收费日期
     */
    private String holdFeeSetlDt;	//待收费结清日期
    private Double feeAmt;	//费用金额
    private String txAmtTyp;	//金额类型
    private String feeRmk;		//备注
    private String ldgrCde;		//会计科目
    private String ldgrCdeSeq;	//会计科目序号
    private short txLogSeqNo;	//交易流水子序号
    /**
     * add by dzj 2011-09-20
     */
    private String feePayTyp;	//费用支付类型
    private Short frmPerd;		//起始期号
    private Short toPerd;		//截止期号
    private String loanAcctTyp;		//账户类型
    private String holdFeeInd;/*待收费标志*/
    private String accAmtTyp;	//摊销金额类型
    private String accInd;		//摊销标志
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
     * 获取待收费标志
     * @return
     */
    public String getHoldFeeInd() {
        return holdFeeInd;
    }
    /**
     * 设置待收费标志
     * @param holdFeeInd
     */
    public void setHoldFeeInd(String holdFeeInd) {
        this.holdFeeInd = holdFeeInd;
    }
    /**
     * 获取账户类型
     * @return
     */
    public String getLoanAcctTyp() {
        return loanAcctTyp;
    }
    /**
     * 设置账户类型
     * @param loanAcctTyp
     */
    public void setLoanAcctTyp(String loanAcctTyp) {
        this.loanAcctTyp = loanAcctTyp;
    }

    /**
     * 费用信息交互对象默认构造函数
     * default constructor
     *
     * */
    public LmFeeTxTrans() {
    }

    // Property accessors

    /**
     * 获取待收费结清日期
     * @return
     */
    public String getHoldFeeSetlDt() {
        return holdFeeSetlDt;
    }
    /**
     * 设置待收费结清日期
     * @param holdFeeSetlDt
     */
    public void setHoldFeeSetlDt(String holdFeeSetlDt) {
        this.holdFeeSetlDt = holdFeeSetlDt;
    }
    /**
     * 费用信息交互对象构造函数
     * @param loanNo
     * @param feeCde
     * @param ccyCde
     * @param recvPayInd
     * @param feeTyp
     * @param baseAmt
     * @param chrgPct
     * @param isHoldFee
     * @param holdFeeSetlDt
     * @param feeAmt
     * @param txAmtTyp
     * @param feeRmk
     * @param ldgrCde
     * @param ldgrCdeSeq
     * @param txLogSeqNo
     * @param feePayTyp
     * @param frmPerd
     * @param toPerd
     */
    public LmFeeTxTrans(String loanNo, String feeCde, String ccyCde,
                        String recvPayInd, String feeTyp, Double baseAmt, Double chrgPct,
                        boolean isHoldFee, String holdFeeSetlDt, Double feeAmt,
                        String txAmtTyp, String feeRmk, String ldgrCde, String ldgrCdeSeq,
                        short txLogSeqNo, String feePayTyp, Short frmPerd, Short toPerd) {
        this.loanNo = loanNo;
        this.feeCde = feeCde;
        this.ccyCde = ccyCde;
        this.recvPayInd = recvPayInd;
        this.feeTyp = feeTyp;
        this.baseAmt = baseAmt;
        this.chrgPct = chrgPct;
        this.holdFeeSetlDt = holdFeeSetlDt;
        this.feeAmt = feeAmt;
        this.txAmtTyp = txAmtTyp;
        this.feeRmk = feeRmk;
        this.ldgrCde = ldgrCde;
        this.ldgrCdeSeq = ldgrCdeSeq;
        this.txLogSeqNo = txLogSeqNo;
        this.feePayTyp = feePayTyp;
        this.frmPerd = frmPerd;
        this.toPerd = toPerd;
    }
    /**
     * 获取币种信息
     * @return
     */
    public String getCcyCde() {
        return ccyCde;
    }
    /**
     * 设置币种信息
     * @param ccyCde
     */
    public void setCcyCde(String ccyCde) {
        this.ccyCde = ccyCde;
    }
    /**
     * 获取收付标志
     * @return
     */
    public String getRecvPayInd() {
        return recvPayInd;
    }
    /**
     * 设置收付标志
     * @param recvPayInd
     */
    public void setRecvPayInd(String recvPayInd) {
        this.recvPayInd = recvPayInd;
    }
    /**
     * 获取基准金额
     * @return
     */
    public Double getBaseAmt() {
        return baseAmt;
    }
    /**
     * 设置基准金额
     * @param baseAmt
     */
    public void setBaseAmt(Double baseAmt) {
        this.baseAmt = baseAmt;
    }
    /**
     * 获取费率
     * @return
     */
    public Double getChrgPct() {
        return chrgPct;
    }
    /**
     * 设置费率
     * @param chrgPct
     */
    public void setChrgPct(Double chrgPct) {
        this.chrgPct = chrgPct;
    }

    /**
     * 获取会计科目
     * @return
     */
    public String getLdgrCde() {
        return ldgrCde;
    }
    /**
     * 设置会计科目
     * @param ldgrCde
     */
    public void setLdgrCde(String ldgrCde) {
        this.ldgrCde = ldgrCde;
    }
    /**
     * 获取会计科目序号
     * @return
     */
    public String getLdgrCdeSeq() {
        return ldgrCdeSeq;
    }
    /**
     * 设置会计科目序号
     * @param ldgrCdeSeq
     */
    public void setLdgrCdeSeq(String ldgrCdeSeq) {
        this.ldgrCdeSeq = ldgrCdeSeq;
    }
    /**
     * 获取借据号
     * @return
     */
    public String getLoanNo() {
        return this.loanNo;
    }
    /**
     * 设置会计科目序号
     * @param loanNo
     */
    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }
    /**
     * 获取费用金额
     * @return
     */
    public Double getFeeAmt() {
        return this.feeAmt;
    }
    /**
     * 设置费用金额
     * @param feeAmt
     */
    public void setFeeAmt(Double feeAmt) {
        this.feeAmt = feeAmt;
    }
    /**
     * 获取费用代码
     * @return
     */
    public String getFeeCde() {
        return this.feeCde;
    }
    /**
     * 设置费用代码
     * @param feeCde
     */
    public void setFeeCde(String feeCde) {
        this.feeCde = feeCde;
    }
    /**
     * 获取费用类型
     * @return
     */
    public String getFeeTyp() {
        return this.feeTyp;
    }
    /**
     * 设置费用类型
     * @param feeTyp
     */
    public void setFeeTyp(String feeTyp) {
        this.feeTyp = feeTyp;
    }
    /**
     * 获取金额类型
     * @return
     */
    public String getTxAmtTyp() {
        return this.txAmtTyp;
    }
    /**
     * 设置金额类型
     * @param txAmtTyp
     */
    public void setTxAmtTyp(String txAmtTyp) {
        this.txAmtTyp = txAmtTyp;
    }
    /**
     * 获取费用备注信息
     * @return
     */
    public String getFeeRmk() {
        return this.feeRmk;
    }
    /**
     * 设置费用备注信息
     * @param feeRmk
     */
    public void setFeeRmk(String feeRmk) {
        this.feeRmk = feeRmk;
    }
    /**
     * 设置交易流水子序号
     * @param txLogSeqNo
     */
    public void setTxLogSeqNo(short txLogSeqNo) {
        this.txLogSeqNo = txLogSeqNo;
    }
    /**
     * 获取交易流水子序号
     * @return
     */
    public short getTxLogSeqNo() {
        return txLogSeqNo;
    }
    /**
     * 获取费用支付类型
     * @return
     */
    public String getFeePayTyp() {
        return feePayTyp;
    }
    /**
     * 设置费用支付类型
     * @param feePayTyp
     */
    public void setFeePayTyp(String feePayTyp) {
        this.feePayTyp = feePayTyp;
    }
    /**
     * 获取起始期号
     * @return
     */
    public Short getFrmPerd() {
        return frmPerd;
    }
    /**
     * 设置起始期号
     * @param frmPerd
     */
    public void setFrmPerd(Short frmPerd) {
        this.frmPerd = frmPerd;
    }
    /**
     * 获取截止期号
     * @return
     */
    public Short getToPerd() {
        return toPerd;
    }
    /**
     * 设置截止期号
     * @param toPerd
     */
    public void setToPerd(Short toPerd) {
        this.toPerd = toPerd;
    }
    public String getAccAmtTyp() {
        return accAmtTyp;
    }
    public void setAccAmtTyp(String accAmtTyp) {
        this.accAmtTyp = accAmtTyp;
    }
    public String getAccInd() {
        return accInd;
    }
    public void setAccInd(String accInd) {
        this.accInd = accInd;
    }

}
