package com.caxs.minos.domain.trans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lenovo on 2020/9/1.
 */
public class LmSetLmtTrans implements Serializable{
    private static final long serialVersionUID = 7607704161124404623L;

    private String genGlNo;

    private String genGlInd;

    private Integer txLogSeq;

    private String orgId;

    private String contNo;

    private String loanNo;

    private String loanCcy;

    private BigDecimal setlRecvAmt;

    private String setlMode;

    private String setlTyp;

    private BigDecimal setlOdPrcpAmt;

    private String setlValDt;

    private BigDecimal setlIntAmt;

    private BigDecimal setlOdIntAmt;

    private BigDecimal setlOdCommInt;

    private BigDecimal setlRemPrcpPaym;

    private String setlFpaidIntOpt;

    private BigDecimal setlAccInt;

    private String setlCompInd;

    private String setlPrcpInd;

    private String paymAcctNo;

    private String paymCcyCde;

    private String bankCde;

    private String bchCde;

    private String paymAcctNam;

    private String issCtry;

    private String idType;

    private String idNo;

    private String paymAcctCcy;

    private String paymAcctCardNo;

    private String paymAcctNttInd;

    private String paymAcctCde;

    private String paymAcctLdgrCde;

    private String paymAcctTyp;

    private Integer paymPerdCnt;

    private String bussTyp;

    private String apdProdInd;

    private String inputProof;

    private String inputProofType;

    private String acctTyp;

    private BigDecimal setlFeeAmt;

    private BigDecimal trueRecvAmt;

    private String ppRatBase;

    private String dpTyp;

    private String clearOweInd;

    private String sendSts;

    private String failReason;

    private String txAmtSts;

    private String revseInd;

    private String revseDt;

    private BigDecimal paymPerdAmt;

    private String olInd;

    private String txcodeTyp;

    private String revsInd;

    private String caxInd;

    private String bankBchCde;

    private String zqzrTyp;

    private String cmisGenGlNo;

    private BigDecimal cmisSetlRecvAmt;

    private String pchCde;

    private String trstplnNo;

    private String trstplnName;

    private String rqsId;

    private String rqsName;

    private String rqsSecret;

    private String rqsToken;

    private String bindMobile; //预留手机号

    public String getBindMobile() {
        return bindMobile;
    }

    public void setBindMobile(String bindMobile) {
        this.bindMobile = bindMobile;
    }


    public String getTrstplnNo() {
        return trstplnNo;
    }
    public void setTrstplnNo(String trstplnNo) {
        this.trstplnNo = trstplnNo;
    }
    public String getTrstplnName() {
        return trstplnName;
    }
    public void setTrstplnName(String trstplnName) {
        this.trstplnName = trstplnName;
    }
    public String getRqsId() {
        return rqsId;
    }
    public void setRqsId(String rqsId) {
        this.rqsId = rqsId;
    }
    public String getRqsName() {
        return rqsName;
    }
    public void setRqsName(String rqsName) {
        this.rqsName = rqsName;
    }
    public String getRqsSecret() {
        return rqsSecret;
    }
    public void setRqsSecret(String rqsSecret) {
        this.rqsSecret = rqsSecret;
    }
    public String getRqsToken() {
        return rqsToken;
    }
    public void setRqsToken(String rqsToken) {
        this.rqsToken = rqsToken;
    }

    public String getGenGlNo() {
        return genGlNo;
    }

    public void setGenGlNo(String genGlNo) {
        this.genGlNo = genGlNo == null ? null : genGlNo.trim();
    }

    public String getGenGlInd() {
        return genGlInd;
    }

    public void setGenGlInd(String genGlInd) {
        this.genGlInd = genGlInd == null ? null : genGlInd.trim();
    }

    public Integer getTxLogSeq() {
        return txLogSeq;
    }

    public void setTxLogSeq(Integer txLogSeq) {
        this.txLogSeq = txLogSeq;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getContNo() {
        return contNo;
    }

    public void setContNo(String contNo) {
        this.contNo = contNo == null ? null : contNo.trim();
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo == null ? null : loanNo.trim();
    }

    public String getLoanCcy() {
        return loanCcy;
    }

    public void setLoanCcy(String loanCcy) {
        this.loanCcy = loanCcy == null ? null : loanCcy.trim();
    }

    public BigDecimal getSetlRecvAmt() {
        return setlRecvAmt;
    }

    public void setSetlRecvAmt(BigDecimal setlRecvAmt) {
        this.setlRecvAmt = setlRecvAmt;
    }

    public String getSetlMode() {
        return setlMode;
    }

    public void setSetlMode(String setlMode) {
        this.setlMode = setlMode == null ? null : setlMode.trim();
    }

    public String getSetlTyp() {
        return setlTyp;
    }

    public void setSetlTyp(String setlTyp) {
        this.setlTyp = setlTyp == null ? null : setlTyp.trim();
    }

    public BigDecimal getSetlOdPrcpAmt() {
        return setlOdPrcpAmt;
    }

    public void setSetlOdPrcpAmt(BigDecimal setlOdPrcpAmt) {
        this.setlOdPrcpAmt = setlOdPrcpAmt;
    }

    public String getSetlValDt() {
        return setlValDt;
    }

    public void setSetlValDt(String setlValDt) {
        this.setlValDt = setlValDt == null ? null : setlValDt.trim();
    }

    public BigDecimal getSetlIntAmt() {
        return setlIntAmt;
    }

    public void setSetlIntAmt(BigDecimal setlIntAmt) {
        this.setlIntAmt = setlIntAmt;
    }

    public BigDecimal getSetlOdIntAmt() {
        return setlOdIntAmt;
    }

    public void setSetlOdIntAmt(BigDecimal setlOdIntAmt) {
        this.setlOdIntAmt = setlOdIntAmt;
    }

    public BigDecimal getSetlOdCommInt() {
        return setlOdCommInt;
    }

    public void setSetlOdCommInt(BigDecimal setlOdCommInt) {
        this.setlOdCommInt = setlOdCommInt;
    }

    public BigDecimal getSetlRemPrcpPaym() {
        return setlRemPrcpPaym;
    }

    public void setSetlRemPrcpPaym(BigDecimal setlRemPrcpPaym) {
        this.setlRemPrcpPaym = setlRemPrcpPaym;
    }

    public String getSetlFpaidIntOpt() {
        return setlFpaidIntOpt;
    }

    public void setSetlFpaidIntOpt(String setlFpaidIntOpt) {
        this.setlFpaidIntOpt = setlFpaidIntOpt == null ? null : setlFpaidIntOpt.trim();
    }

    public BigDecimal getSetlAccInt() {
        return setlAccInt;
    }

    public void setSetlAccInt(BigDecimal setlAccInt) {
        this.setlAccInt = setlAccInt;
    }

    public String getSetlCompInd() {
        return setlCompInd;
    }

    public void setSetlCompInd(String setlCompInd) {
        this.setlCompInd = setlCompInd == null ? null : setlCompInd.trim();
    }

    public String getSetlPrcpInd() {
        return setlPrcpInd;
    }

    public void setSetlPrcpInd(String setlPrcpInd) {
        this.setlPrcpInd = setlPrcpInd == null ? null : setlPrcpInd.trim();
    }

    public String getPaymAcctNo() {
        return paymAcctNo;
    }

    public void setPaymAcctNo(String paymAcctNo) {
        this.paymAcctNo = paymAcctNo == null ? null : paymAcctNo.trim();
    }

    public String getPaymCcyCde() {
        return paymCcyCde;
    }

    public void setPaymCcyCde(String paymCcyCde) {
        this.paymCcyCde = paymCcyCde == null ? null : paymCcyCde.trim();
    }

    public String getBankCde() {
        return bankCde;
    }

    public void setBankCde(String bankCde) {
        this.bankCde = bankCde == null ? null : bankCde.trim();
    }

    public String getBchCde() {
        return bchCde;
    }

    public void setBchCde(String bchCde) {
        this.bchCde = bchCde == null ? null : bchCde.trim();
    }

    public String getPaymAcctNam() {
        return paymAcctNam;
    }

    public void setPaymAcctNam(String paymAcctNam) {
        this.paymAcctNam = paymAcctNam == null ? null : paymAcctNam.trim();
    }

    public String getIssCtry() {
        return issCtry;
    }

    public void setIssCtry(String issCtry) {
        this.issCtry = issCtry == null ? null : issCtry.trim();
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    public String getPaymAcctCcy() {
        return paymAcctCcy;
    }

    public void setPaymAcctCcy(String paymAcctCcy) {
        this.paymAcctCcy = paymAcctCcy == null ? null : paymAcctCcy.trim();
    }

    public String getPaymAcctCardNo() {
        return paymAcctCardNo;
    }

    public void setPaymAcctCardNo(String paymAcctCardNo) {
        this.paymAcctCardNo = paymAcctCardNo == null ? null : paymAcctCardNo.trim();
    }

    public String getPaymAcctNttInd() {
        return paymAcctNttInd;
    }

    public void setPaymAcctNttInd(String paymAcctNttInd) {
        this.paymAcctNttInd = paymAcctNttInd == null ? null : paymAcctNttInd.trim();
    }

    public String getPaymAcctCde() {
        return paymAcctCde;
    }

    public void setPaymAcctCde(String paymAcctCde) {
        this.paymAcctCde = paymAcctCde == null ? null : paymAcctCde.trim();
    }

    public String getPaymAcctLdgrCde() {
        return paymAcctLdgrCde;
    }

    public void setPaymAcctLdgrCde(String paymAcctLdgrCde) {
        this.paymAcctLdgrCde = paymAcctLdgrCde == null ? null : paymAcctLdgrCde.trim();
    }

    public String getPaymAcctTyp() {
        return paymAcctTyp;
    }

    public void setPaymAcctTyp(String paymAcctTyp) {
        this.paymAcctTyp = paymAcctTyp == null ? null : paymAcctTyp.trim();
    }

    public Integer getPaymPerdCnt() {
        return paymPerdCnt;
    }

    public void setPaymPerdCnt(Integer paymPerdCnt) {
        this.paymPerdCnt = paymPerdCnt;
    }

    public String getBussTyp() {
        return bussTyp;
    }

    public void setBussTyp(String bussTyp) {
        this.bussTyp = bussTyp == null ? null : bussTyp.trim();
    }

    public String getApdProdInd() {
        return apdProdInd;
    }

    public void setApdProdInd(String apdProdInd) {
        this.apdProdInd = apdProdInd == null ? null : apdProdInd.trim();
    }

    public String getInputProof() {
        return inputProof;
    }

    public void setInputProof(String inputProof) {
        this.inputProof = inputProof == null ? null : inputProof.trim();
    }

    public String getInputProofType() {
        return inputProofType;
    }

    public void setInputProofType(String inputProofType) {
        this.inputProofType = inputProofType == null ? null : inputProofType.trim();
    }

    public String getAcctTyp() {
        return acctTyp;
    }

    public void setAcctTyp(String acctTyp) {
        this.acctTyp = acctTyp == null ? null : acctTyp.trim();
    }

    public BigDecimal getSetlFeeAmt() {
        return setlFeeAmt;
    }

    public void setSetlFeeAmt(BigDecimal setlFeeAmt) {
        this.setlFeeAmt = setlFeeAmt;
    }

    public BigDecimal getTrueRecvAmt() {
        return trueRecvAmt;
    }

    public void setTrueRecvAmt(BigDecimal trueRecvAmt) {
        this.trueRecvAmt = trueRecvAmt;
    }

    public String getPpRatBase() {
        return ppRatBase;
    }

    public void setPpRatBase(String ppRatBase) {
        this.ppRatBase = ppRatBase == null ? null : ppRatBase.trim();
    }

    public String getDpTyp() {
        return dpTyp;
    }

    public void setDpTyp(String dpTyp) {
        this.dpTyp = dpTyp == null ? null : dpTyp.trim();
    }

    public String getClearOweInd() {
        return clearOweInd;
    }

    public void setClearOweInd(String clearOweInd) {
        this.clearOweInd = clearOweInd == null ? null : clearOweInd.trim();
    }

    public String getSendSts() {
        return sendSts;
    }

    public void setSendSts(String sendSts) {
        this.sendSts = sendSts == null ? null : sendSts.trim();
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason == null ? null : failReason.trim();
    }

    public String getTxAmtSts() {
        return txAmtSts;
    }

    public void setTxAmtSts(String txAmtSts) {
        this.txAmtSts = txAmtSts == null ? null : txAmtSts.trim();
    }

    public String getRevseInd() {
        return revseInd;
    }

    public void setRevseInd(String revseInd) {
        this.revseInd = revseInd == null ? null : revseInd.trim();
    }

    public String getRevseDt() {
        return revseDt;
    }

    public void setRevseDt(String revseDt) {
        this.revseDt = revseDt == null ? null : revseDt.trim();
    }

    public BigDecimal getPaymPerdAmt() {
        return paymPerdAmt;
    }

    public void setPaymPerdAmt(BigDecimal paymPerdAmt) {
        this.paymPerdAmt = paymPerdAmt;
    }

    public String getOlInd() {
        return olInd;
    }

    public void setOlInd(String olInd) {
        this.olInd = olInd == null ? null : olInd.trim();
    }

    public String getTxcodeTyp() {
        return txcodeTyp;
    }

    public void setTxcodeTyp(String txcodeTyp) {
        this.txcodeTyp = txcodeTyp == null ? null : txcodeTyp.trim();
    }

    public String getRevsInd() {
        return revsInd;
    }

    public void setRevsInd(String revsInd) {
        this.revsInd = revsInd == null ? null : revsInd.trim();
    }

    public String getCaxInd() {
        return caxInd;
    }

    public void setCaxInd(String caxInd) {
        this.caxInd = caxInd == null ? null : caxInd.trim();
    }

    public String getBankBchCde() {
        return bankBchCde;
    }

    public void setBankBchCde(String bankBchCde) {
        this.bankBchCde = bankBchCde == null ? null : bankBchCde.trim();
    }

    public String getZqzrTyp() {
        return zqzrTyp;
    }

    public void setZqzrTyp(String zqzrTyp) {
        this.zqzrTyp = zqzrTyp == null ? null : zqzrTyp.trim();
    }

    public String getCmisGenGlNo() {
        return cmisGenGlNo;
    }

    public void setCmisGenGlNo(String cmisGenGlNo) {
        this.cmisGenGlNo = cmisGenGlNo == null ? null : cmisGenGlNo.trim();
    }

    public BigDecimal getCmisSetlRecvAmt() {
        return cmisSetlRecvAmt;
    }

    public void setCmisSetlRecvAmt(BigDecimal cmisSetlRecvAmt) {
        this.cmisSetlRecvAmt = cmisSetlRecvAmt;
    }

    public String getPchCde() {
        return pchCde;
    }

    public void setPchCde(String pchCde) {
        this.pchCde = pchCde == null ? null : pchCde.trim();
    }
}
