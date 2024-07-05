package com.caxs.minos.domain.trans;

import java.io.Serializable;

/**
 * lmAcctInfo 对应管理交互类
 * Created by lenovo on 2020/9/4.
 */
public class LmAcctInfoTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;
    // Fields
    private String loanAcctTyp; 	//系统账户类型
    private String loanNo;			//借据号
    private String acctBchCde;		//还款帐号机构代码
    private String acctBankCde;		//还款帐号银行代码
    private String acctNo;			//还款账号
    private String acctName;		//户名
    private String acctValDt;		//生效日期
    private String acctExpiryDt;	//有效日期
    private String acctRmk;			//备注
    private String acctCardNo;		//还款卡号
    private String acctNttInd;		//钞汇标志
    private String acctTyp;			//账户类型
    private String acctCde;			//账户代码
    private String acctCcyCde;		//账户币种
    private String acctIdType;		//证件类型
    private String acctIdNo;		//证件号码
    private String acctIssCtry;		//发证国家
    private String acctLdgrCde;		//账号科目代码
    private Double actvAmt;			//发放金额

    private String contrNo;			//协议号


    private String acctBankNam;			//账户银行名

    private String acctBankAdd;
    private Double issueAmt;
    private String accountSelf;			//本行他行标志
    private Double fundRatio;			//委托人出资金额
    private String bindMobile; //手机号

    public String getBindMobile() {
        return bindMobile;
    }

    public void setBindMobile(String bindMobile) {
        this.bindMobile = bindMobile;
    }

    // Constructors
    public Double getFundRatio() {
        return fundRatio;
    }

    public void setFundRatio(Double fundRatio) {
        this.fundRatio = fundRatio;
    }

    //本行他行标志
    public String getAccountSelf() {
        return accountSelf;
    }

    //本行他行标志
    public void setAccountSelf(String accountSelf) {
        this.accountSelf = accountSelf;
    }

    //账户银行名
    public String getAcctBankNam() {
        return acctBankNam;
    }

    //账户银行名
    public void setAcctBankNam(String acctBankNam) {
        this.acctBankNam = acctBankNam;
    }


    public String getAcctBankAdd() {
        return acctBankAdd;
    }


    public void setAcctBankAdd(String acctBankAdd) {
        this.acctBankAdd = acctBankAdd;
    }

    //发放金额
    public Double getActvAmt() {
        return actvAmt;
    }

    //发放金额
    public void setActvAmt(Double actvAmt) {
        this.actvAmt = actvAmt;
    }


    /** default constructor */
    public LmAcctInfoTrans() {
    }

    public LmAcctInfoTrans(String loanAcctTyp, String loanNo,
                           String acctBchCde, String acctBankCde, String acctNo,
                           String acctName, String acctValDt, String acctExpiryDt,
                           String acctRmk, String acctCardNo, String acctNttInd,
                           String acctTyp, String acctCde, String acctCcyCde,
                           String acctIdType, String acctIdNo, String acctIssCtry,
                           String acctLdgrCde, Double actvAmt, String contrNo,
                           String isOwnFlag, String acctBankNam, String acctBankAdd,
                           Double issueAmt,String bindMobile) {
        super();
        this.loanAcctTyp = loanAcctTyp;
        this.loanNo = loanNo;
        this.acctBchCde = acctBchCde;
        this.acctBankCde = acctBankCde;
        this.acctNo = acctNo;
        this.acctName = acctName;
        this.acctValDt = acctValDt;
        this.acctExpiryDt = acctExpiryDt;
        this.acctRmk = acctRmk;
        this.acctCardNo = acctCardNo;
        this.acctNttInd = acctNttInd;
        this.acctTyp = acctTyp;
        this.acctCde = acctCde;
        this.acctCcyCde = acctCcyCde;
        this.acctIdType = acctIdType;
        this.acctIdNo = acctIdNo;
        this.acctIssCtry = acctIssCtry;
        this.acctLdgrCde = acctLdgrCde;
        this.actvAmt = actvAmt;
        this.contrNo = contrNo;
        this.acctBankNam = acctBankNam;
        this.acctBankAdd = acctBankAdd;
        this.issueAmt = issueAmt;
        this.bindMobile=bindMobile;
    }


    // Property accessors

    /**
     * 获取户名信息
     * @return
     */
    public String getAcctName() {
        return this.acctName;
    }
    /**
     * 设置户名信息
     * @param acctName
     */
    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }
    /**
     * 获取生效日期
     * @return
     */
    public String getAcctValDt() {
        return this.acctValDt;
    }
    /**
     * 设置生效日期
     * @param acctValDt
     */
    public void setAcctValDt(String acctValDt) {
        this.acctValDt = acctValDt;
    }
    /**
     * 获取有效日期
     * @return
     */
    public String getAcctExpiryDt() {
        return this.acctExpiryDt;
    }
    /**
     * 设置有效日期
     * @param acctExpiryDt
     */
    public void setAcctExpiryDt(String acctExpiryDt) {
        this.acctExpiryDt = acctExpiryDt;
    }
    /**
     * 获取备注
     * @return
     */
    public String getAcctRmk() {
        return this.acctRmk;
    }
    /**
     * 设置备注
     * @param acctRmk
     */
    public void setAcctRmk(String acctRmk) {
        this.acctRmk = acctRmk;
    }
    /**
     * 获取还款卡号
     * @return
     */
    public String getAcctCardNo() {
        return this.acctCardNo;
    }
    /**
     * 设置还款卡号
     * @param acctCardNo
     */
    public void setAcctCardNo(String acctCardNo) {
        this.acctCardNo = acctCardNo;
    }
    /**
     * 获取钞汇标志
     * @return
     */
    public String getAcctNttInd() {
        return this.acctNttInd;
    }
    /**
     * 设置钞汇标志
     * @param acctNttInd
     */
    public void setAcctNttInd(String acctNttInd) {
        this.acctNttInd = acctNttInd;
    }
    /**
     * 获取账户类型
     * @return
     */
    public String getAcctTyp() {
        return this.acctTyp;
    }
    /**
     * 设置账户类型
     * @param acctTyp
     */
    public void setAcctTyp(String acctTyp) {
        this.acctTyp = acctTyp;
    }
    /**
     * 获取账户代码
     * @return
     */
    public String getAcctCde() {
        return this.acctCde;
    }
    /**
     * 设置账户代码
     * @param acctCde
     */
    public void setAcctCde(String acctCde) {
        this.acctCde = acctCde;
    }
    /**
     * 获取账户币种
     * @return
     */
    public String getAcctCcyCde() {
        return this.acctCcyCde;
    }
    /**
     * 设置账户币种
     * @param acctCcyCde
     */
    public void setAcctCcyCde(String acctCcyCde) {
        this.acctCcyCde = acctCcyCde;
    }
    /**
     * 获取证件类型
     * @return
     */
    public String getAcctIdType() {
        return this.acctIdType;
    }
    /**
     * 设置证件类型
     * @param acctIdType
     */
    public void setAcctIdType(String acctIdType) {
        this.acctIdType = acctIdType;
    }
    /**
     * 获取证件号码
     * @return
     */
    public String getAcctIdNo() {
        return this.acctIdNo;
    }
    /**
     * 设置证件号码
     * @param acctIdNo
     */
    public void setAcctIdNo(String acctIdNo) {
        this.acctIdNo = acctIdNo;
    }
    /**
     * 获取发证国家
     * @return
     */
    public String getAcctIssCtry() {
        return this.acctIssCtry;
    }
    /**
     * 设置发证国家
     * @param acctIssCtry
     */
    public void setAcctIssCtry(String acctIssCtry) {
        this.acctIssCtry = acctIssCtry;
    }
    /**
     * 获取账号科目代码
     * @return
     */
    public String getAcctLdgrCde() {
        return this.acctLdgrCde;
    }
    /**
     * 设置账号科目代码
     * @param acctLdgrCde
     */
    public void setAcctLdgrCde(String acctLdgrCde) {
        this.acctLdgrCde = acctLdgrCde;
    }
    /**
     * 获取系统账户类型
     * @return
     */
    public String getLoanAcctTyp() {
        return loanAcctTyp;
    }
    /**
     * 设置系统账户类型
     * @param loanAcctTyp
     */
    public void setLoanAcctTyp(String loanAcctTyp) {
        this.loanAcctTyp = loanAcctTyp;
    }
    /**
     * 获取借据号
     * @return
     */
    public String getLoanNo() {
        return loanNo;
    }
    /**
     * 设置借据号
     * @param loanNo
     */
    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }
    /**
     * 获取还款帐号机构代码
     * @return
     */
    public String getAcctBchCde() {
        return acctBchCde;
    }
    /**
     * 设置还款帐号机构代码
     * @param acctBchCde
     */
    public void setAcctBchCde(String acctBchCde) {
        this.acctBchCde = acctBchCde;
    }
    /**
     * 获取还款帐号银行代码
     * @return
     */
    public String getAcctBankCde() {
        return acctBankCde;
    }
    /**
     * 设置还款帐号银行代码
     * @param acctBankCde
     */
    public void setAcctBankCde(String acctBankCde) {
        this.acctBankCde = acctBankCde;
    }
    /**
     * 获取还款账号
     * @return
     */
    public String getAcctNo() {
        return acctNo;
    }
    /**
     * 设置还款账号
     * @param acctNo
     */
    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }
    //协议号
    public String getContrNo() {
        return contrNo;
    }
    //协议号
    public void setContrNo(String contrNo) {
        this.contrNo = contrNo;
    }




    public Double getIssueAmt() {
        return issueAmt;
    }


    public void setIssueAmt(Double issueAmt) {
        this.issueAmt = issueAmt;
    }


}
