package com.caxs.minos.domain;

public class IntfDgxtTransInfo {
    private Long applSeq;

    private Long caxtApplSeq;

    private String caxtApplCde;

    private String capInstuCde;

    private String isSendDy;

    private String operateTm;

    private String loanNo;

    private String caxtLoanNo;

    public Long getApplSeq() {
        return applSeq;
    }

    public void setApplSeq(Long applSeq) {
        this.applSeq = applSeq;
    }

    public Long getCaxtApplSeq() {
        return caxtApplSeq;
    }

    public void setCaxtApplSeq(Long caxtApplSeq) {
        this.caxtApplSeq = caxtApplSeq;
    }

    public String getCaxtApplCde() {
        return caxtApplCde;
    }

    public void setCaxtApplCde(String caxtApplCde) {
        this.caxtApplCde = caxtApplCde == null ? null : caxtApplCde.trim();
    }

    public String getCapInstuCde() {
        return capInstuCde;
    }

    public void setCapInstuCde(String capInstuCde) {
        this.capInstuCde = capInstuCde == null ? null : capInstuCde.trim();
    }

    public String getIsSendDy() {
        return isSendDy;
    }

    public void setIsSendDy(String isSendDy) {
        this.isSendDy = isSendDy == null ? null : isSendDy.trim();
    }

    public String getOperateTm() {
        return operateTm;
    }

    public void setOperateTm(String operateTm) {
        this.operateTm = operateTm == null ? null : operateTm.trim();
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo == null ? null : loanNo.trim();
    }

    public String getCaxtLoanNo() {
        return caxtLoanNo;
    }

    public void setCaxtLoanNo(String caxtLoanNo) {
        this.caxtLoanNo = caxtLoanNo == null ? null : caxtLoanNo.trim();
    }
}