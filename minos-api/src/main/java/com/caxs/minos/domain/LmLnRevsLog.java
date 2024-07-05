package com.caxs.minos.domain;

import java.io.Serializable;
public class LmLnRevsLog  implements Serializable {
    private Long txLogSeq;

    private String state;

    private Long txNo;

    private String loanNo;

    private String inputDt;

    private String orgId;

    private String lendOffice;

    private String lastChgDt;

    private String crtUsr;

    private String lastChgUsr;

    private String memo;

    private String lmState;

    private String txFuncId;

    private Long revsTxNo;

    private String genGlNo;

    private String sendSts;

    private String failReason;

    private String txAmtSts;

    private String revsTyp;

    public Long getTxLogSeq() {
        return txLogSeq;
    }

    public void setTxLogSeq(Long txLogSeq) {
        this.txLogSeq = txLogSeq;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Long getTxNo() {
        return txNo;
    }

    public void setTxNo(Long txNo) {
        this.txNo = txNo;
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo == null ? null : loanNo.trim();
    }

    public String getInputDt() {
        return inputDt;
    }

    public void setInputDt(String inputDt) {
        this.inputDt = inputDt == null ? null : inputDt.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getLendOffice() {
        return lendOffice;
    }

    public void setLendOffice(String lendOffice) {
        this.lendOffice = lendOffice == null ? null : lendOffice.trim();
    }

    public String getLastChgDt() {
        return lastChgDt;
    }

    public void setLastChgDt(String lastChgDt) {
        this.lastChgDt = lastChgDt == null ? null : lastChgDt.trim();
    }

    public String getCrtUsr() {
        return crtUsr;
    }

    public void setCrtUsr(String crtUsr) {
        this.crtUsr = crtUsr == null ? null : crtUsr.trim();
    }

    public String getLastChgUsr() {
        return lastChgUsr;
    }

    public void setLastChgUsr(String lastChgUsr) {
        this.lastChgUsr = lastChgUsr == null ? null : lastChgUsr.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getLmState() {
        return lmState;
    }

    public void setLmState(String lmState) {
        this.lmState = lmState == null ? null : lmState.trim();
    }

    public String getTxFuncId() {
        return txFuncId;
    }

    public void setTxFuncId(String txFuncId) {
        this.txFuncId = txFuncId == null ? null : txFuncId.trim();
    }

    public Long getRevsTxNo() {
        return revsTxNo;
    }

    public void setRevsTxNo(Long revsTxNo) {
        this.revsTxNo = revsTxNo;
    }

    public String getGenGlNo() {
        return genGlNo;
    }

    public void setGenGlNo(String genGlNo) {
        this.genGlNo = genGlNo == null ? null : genGlNo.trim();
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

    public String getRevsTyp() {
        return revsTyp;
    }

    public void setRevsTyp(String revsTyp) {
        this.revsTyp = revsTyp == null ? null : revsTyp.trim();
    }
}