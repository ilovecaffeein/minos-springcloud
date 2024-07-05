package com.caxs.minos.domain;

public class SaccBank {
    private String accBankCde;

    private String accBankName;

    private String bankSts;

    private String lastChgDt;

    private String lastChgUsr;

    private String olInd;

    private String bankCode;

    private String dataSts;

    public String getAccBankCde() {
        return accBankCde;
    }

    public void setAccBankCde(String accBankCde) {
        this.accBankCde = accBankCde == null ? null : accBankCde.trim();
    }

    public String getAccBankName() {
        return accBankName;
    }

    public void setAccBankName(String accBankName) {
        this.accBankName = accBankName == null ? null : accBankName.trim();
    }

    public String getBankSts() {
        return bankSts;
    }

    public void setBankSts(String bankSts) {
        this.bankSts = bankSts == null ? null : bankSts.trim();
    }

    public String getLastChgDt() {
        return lastChgDt;
    }

    public void setLastChgDt(String lastChgDt) {
        this.lastChgDt = lastChgDt == null ? null : lastChgDt.trim();
    }

    public String getLastChgUsr() {
        return lastChgUsr;
    }

    public void setLastChgUsr(String lastChgUsr) {
        this.lastChgUsr = lastChgUsr == null ? null : lastChgUsr.trim();
    }

    public String getOlInd() {
        return olInd;
    }

    public void setOlInd(String olInd) {
        this.olInd = olInd == null ? null : olInd.trim();
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getDataSts() {
        return dataSts;
    }

    public void setDataSts(String dataSts) {
        this.dataSts = dataSts == null ? null : dataSts.trim();
    }
}