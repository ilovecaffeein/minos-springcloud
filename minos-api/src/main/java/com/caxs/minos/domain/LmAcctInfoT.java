package com.caxs.minos.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class LmAcctInfoT implements Serializable {
    private static final long serialVersionUID = 1L;

    private String genGlNo;

    private String loanNo;

    private String acctBankCde;

    private String acctBchCde;

    private String loanAcctTyp;

    private String acctNo;

    private String acctName;

    private String acctValDt;

    private String acctCreateDt;

    private String acctExpiryDt;

    private String acctRmk;

    private String atpySts;

    private String acctCardNo;

    private String acctNttInd;

    private String acctTyp;

    private String acctCde;

    private String acctCcyCde;

    private String acctIdType;

    private String acctIdNo;

    private String acctIssCtry;

    private String acctLdgrCde;

    private Integer acctPriNo;

    private String acctCompstInd;

    private String contrNo;

    private BigDecimal issueAmt;

    private String accountSelf;

    private String acctBankAdd;

    private String acctBankNam;

    private BigDecimal actvAmt;

    private BigDecimal actvAmtPct;

    private String lastChgUsr;

    private String lastChgDt;

    private BigDecimal fundRatio;

    private BigDecimal fundAmt;

    private String bindMobile;

    public String getGenGlNo() {
        return genGlNo;
    }

    public void setGenGlNo(String genGlNo) {
        this.genGlNo = genGlNo == null ? null : genGlNo.trim();
    }

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo == null ? null : loanNo.trim();
    }

    public String getAcctBankCde() {
        return acctBankCde;
    }

    public void setAcctBankCde(String acctBankCde) {
        this.acctBankCde = acctBankCde == null ? null : acctBankCde.trim();
    }

    public String getAcctBchCde() {
        return acctBchCde;
    }

    public void setAcctBchCde(String acctBchCde) {
        this.acctBchCde = acctBchCde == null ? null : acctBchCde.trim();
    }

    public String getLoanAcctTyp() {
        return loanAcctTyp;
    }

    public void setLoanAcctTyp(String loanAcctTyp) {
        this.loanAcctTyp = loanAcctTyp == null ? null : loanAcctTyp.trim();
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName == null ? null : acctName.trim();
    }

    public String getAcctValDt() {
        return acctValDt;
    }

    public void setAcctValDt(String acctValDt) {
        this.acctValDt = acctValDt == null ? null : acctValDt.trim();
    }

    public String getAcctCreateDt() {
        return acctCreateDt;
    }

    public void setAcctCreateDt(String acctCreateDt) {
        this.acctCreateDt = acctCreateDt == null ? null : acctCreateDt.trim();
    }

    public String getAcctExpiryDt() {
        return acctExpiryDt;
    }

    public void setAcctExpiryDt(String acctExpiryDt) {
        this.acctExpiryDt = acctExpiryDt == null ? null : acctExpiryDt.trim();
    }

    public String getAcctRmk() {
        return acctRmk;
    }

    public void setAcctRmk(String acctRmk) {
        this.acctRmk = acctRmk == null ? null : acctRmk.trim();
    }

    public String getAtpySts() {
        return atpySts;
    }

    public void setAtpySts(String atpySts) {
        this.atpySts = atpySts == null ? null : atpySts.trim();
    }

    public String getAcctCardNo() {
        return acctCardNo;
    }

    public void setAcctCardNo(String acctCardNo) {
        this.acctCardNo = acctCardNo == null ? null : acctCardNo.trim();
    }

    public String getAcctNttInd() {
        return acctNttInd;
    }

    public void setAcctNttInd(String acctNttInd) {
        this.acctNttInd = acctNttInd == null ? null : acctNttInd.trim();
    }

    public String getAcctTyp() {
        return acctTyp;
    }

    public void setAcctTyp(String acctTyp) {
        this.acctTyp = acctTyp == null ? null : acctTyp.trim();
    }

    public String getAcctCde() {
        return acctCde;
    }

    public void setAcctCde(String acctCde) {
        this.acctCde = acctCde == null ? null : acctCde.trim();
    }

    public String getAcctCcyCde() {
        return acctCcyCde;
    }

    public void setAcctCcyCde(String acctCcyCde) {
        this.acctCcyCde = acctCcyCde == null ? null : acctCcyCde.trim();
    }

    public String getAcctIdType() {
        return acctIdType;
    }

    public void setAcctIdType(String acctIdType) {
        this.acctIdType = acctIdType == null ? null : acctIdType.trim();
    }

    public String getAcctIdNo() {
        return acctIdNo;
    }

    public void setAcctIdNo(String acctIdNo) {
        this.acctIdNo = acctIdNo == null ? null : acctIdNo.trim();
    }

    public String getAcctIssCtry() {
        return acctIssCtry;
    }

    public void setAcctIssCtry(String acctIssCtry) {
        this.acctIssCtry = acctIssCtry == null ? null : acctIssCtry.trim();
    }

    public String getAcctLdgrCde() {
        return acctLdgrCde;
    }

    public void setAcctLdgrCde(String acctLdgrCde) {
        this.acctLdgrCde = acctLdgrCde == null ? null : acctLdgrCde.trim();
    }

    public Integer getAcctPriNo() {
        return acctPriNo;
    }

    public void setAcctPriNo(Integer acctPriNo) {
        this.acctPriNo = acctPriNo;
    }

    public String getAcctCompstInd() {
        return acctCompstInd;
    }

    public void setAcctCompstInd(String acctCompstInd) {
        this.acctCompstInd = acctCompstInd == null ? null : acctCompstInd.trim();
    }

    public String getContrNo() {
        return contrNo;
    }

    public void setContrNo(String contrNo) {
        this.contrNo = contrNo == null ? null : contrNo.trim();
    }

    public BigDecimal getIssueAmt() {
        return issueAmt;
    }

    public void setIssueAmt(BigDecimal issueAmt) {
        this.issueAmt = issueAmt;
    }

    public String getAccountSelf() {
        return accountSelf;
    }

    public void setAccountSelf(String accountSelf) {
        this.accountSelf = accountSelf == null ? null : accountSelf.trim();
    }

    public String getAcctBankAdd() {
        return acctBankAdd;
    }

    public void setAcctBankAdd(String acctBankAdd) {
        this.acctBankAdd = acctBankAdd == null ? null : acctBankAdd.trim();
    }

    public String getAcctBankNam() {
        return acctBankNam;
    }

    public void setAcctBankNam(String acctBankNam) {
        this.acctBankNam = acctBankNam == null ? null : acctBankNam.trim();
    }

    public BigDecimal getActvAmt() {
        return actvAmt;
    }

    public void setActvAmt(BigDecimal actvAmt) {
        this.actvAmt = actvAmt;
    }

    public BigDecimal getActvAmtPct() {
        return actvAmtPct;
    }

    public void setActvAmtPct(BigDecimal actvAmtPct) {
        this.actvAmtPct = actvAmtPct;
    }

    public String getLastChgUsr() {
        return lastChgUsr;
    }

    public void setLastChgUsr(String lastChgUsr) {
        this.lastChgUsr = lastChgUsr == null ? null : lastChgUsr.trim();
    }

    public String getLastChgDt() {
        return lastChgDt;
    }

    public void setLastChgDt(String lastChgDt) {
        this.lastChgDt = lastChgDt == null ? null : lastChgDt.trim();
    }

    public BigDecimal getFundRatio() {
        return fundRatio;
    }

    public void setFundRatio(BigDecimal fundRatio) {
        this.fundRatio = fundRatio;
    }

    public BigDecimal getFundAmt() {
        return fundAmt;
    }

    public void setFundAmt(BigDecimal fundAmt) {
        this.fundAmt = fundAmt;
    }

    public String getBindMobile() {
        return bindMobile;
    }

    public void setBindMobile(String bindMobile) {
        this.bindMobile = bindMobile == null ? null : bindMobile.trim();
    }

    public LmAcctInfoT(){}

    public LmAcctInfoT(String genGlNo){
        this.genGlNo = genGlNo;
    }
}