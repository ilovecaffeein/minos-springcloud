package com.caxs.minos.domain;

public class LmLoanSuspFunc {
    private String loanNo;

    private String suspCde;

    private String suspDt;

    private String buzDt;

    private String userNam;

    private String userOrg;

    private Long txLogSeq;

    private String procInd;

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo == null ? null : loanNo.trim();
    }

    public String getSuspCde() {
        return suspCde;
    }

    public void setSuspCde(String suspCde) {
        this.suspCde = suspCde == null ? null : suspCde.trim();
    }

    public String getSuspDt() {
        return suspDt;
    }

    public void setSuspDt(String suspDt) {
        this.suspDt = suspDt == null ? null : suspDt.trim();
    }

    public String getBuzDt() {
        return buzDt;
    }

    public void setBuzDt(String buzDt) {
        this.buzDt = buzDt == null ? null : buzDt.trim();
    }

    public String getUserNam() {
        return userNam;
    }

    public void setUserNam(String userNam) {
        this.userNam = userNam == null ? null : userNam.trim();
    }

    public String getUserOrg() {
        return userOrg;
    }

    public void setUserOrg(String userOrg) {
        this.userOrg = userOrg == null ? null : userOrg.trim();
    }

    public Long getTxLogSeq() {
        return txLogSeq;
    }

    public void setTxLogSeq(Long txLogSeq) {
        this.txLogSeq = txLogSeq;
    }

    public String getProcInd() {
        return procInd;
    }

    public void setProcInd(String procInd) {
        this.procInd = procInd == null ? null : procInd.trim();
    }
}