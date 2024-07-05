package com.caxs.minos.domain.trans;

import java.io.Serializable;
import java.math.BigDecimal;

/***
 * @ClassName(类名) : OnlineTrans
 * @Description(描述) : TODD
 * @author(作者) ： fengdetian
 * @date (开发日期) ： 2020/9/17 15:15
 */
public class LmGlnoLogTrans implements Serializable {
    private static final long serialVersionUID = 1L;

        /**
         * 授权号
         */
        private String genGlNo;
        /**
         * 记账处理标识
         */
        private String genGlInd;
        /**
         * 机构号
         */
        private String bchCde;
        /**
         * 币种
         */
        private String ccyCde;
        /**
         * 申请业务日期
         */
        private String appDt;
        /**
         * 创建日期
         */
        private String crtDt;
        /**
         * 创建时间
         */
        private String crtTm;
        /**
         * 申请用户
         */
        private String appUserName;
        /**
         * 申请用户编号
         */
        private String appUserId;
        /**
         * 申请用户机构号
         */
        private String appUserOrgNo;
        /**
         * 交易流水
         */
        private Long txLogSeq;
        /**
         * 交易码
         */
        private String transCode;
        /**
         * 交易金额
         */
        private BigDecimal amount;
        /**
         * 备注
         */
        private String memo;
        /**
         * 撤销标志
         */
        private String revseInd;
        /**
         * 撤销日期
         */
        private String revseDt;
        /**
         * 撤销时间
         */
        private String revseTm;
        /**
         * 是否通知管理系统
         */
        private String infoCmisInd;
        /**
         * 接口服务编码
         */
        private String serviceId;
        /**
         * 合同编码
         */
        private String loanContNo;
        /**
         * 发送系统标识
         XD 信贷系统
         GJ 国结系统
         */
        private String sentSys;
        /**
         * 状态
         */
        private String state;
        /**
         * 借据号
         */
        private String loanNo;
        /**
         * 国结系统流水号
         */
        private String fromGjNo;
        /**
         * 核心入账流水号
         */
        private String myrzSerno;
        /**
         * 出账用户编号
         */
        private String accUserId;
        /**
         * 出账用户机构号
         */
        private String accUserOrgNo;
        /**
         * 本金
         */
        private BigDecimal prcpAmt;
        /**
         * 正常利息
         */
        private BigDecimal normIntAmt;

        /**
         * 逾期利息
         */
        private BigDecimal odIntAmt;
        /**
         * 复利
         */
        private BigDecimal commOdIntAmt;

        public  LmGlnoLogTrans(){
        }

        public static long getSerialVersionUID() {
            return serialVersionUID;
        }

        public String getGenGlNo() {
            return genGlNo;
        }

        public void setGenGlNo(String genGlNo) {
            this.genGlNo = genGlNo;
        }

        public String getGenGlInd() {
            return genGlInd;
        }

        public void setGenGlInd(String genGlInd) {
            this.genGlInd = genGlInd;
        }

        /**
         * 设置：机构号
         */
        public void setBchCde(String bchCde) {
            this.bchCde = bchCde;
        }
        /**
         * 获取：机构号
         */
        public String getBchCde() {
            return bchCde;
        }

        public String getCcyCde() {
            return ccyCde;
        }

        public void setCcyCde(String ccyCde) {
            this.ccyCde = ccyCde;
        }

        public String getAppDt() {
            return appDt;
        }

        public void setAppDt(String appDt) {
            this.appDt = appDt;
        }

        public String getCrtDt() {
            return crtDt;
        }

        public void setCrtDt(String crtDt) {
            this.crtDt = crtDt;
        }

        public String getCrtTm() {
            return crtTm;
        }

        public void setCrtTm(String crtTm) {
            this.crtTm = crtTm;
        }

        public String getAppUserName() {
            return appUserName;
        }

        public void setAppUserName(String appUserName) {
            this.appUserName = appUserName;
        }

        public String getAppUserId() {
            return appUserId;
        }

        public void setAppUserId(String appUserId) {
            this.appUserId = appUserId;
        }

        public String getAppUserOrgNo() {
            return appUserOrgNo;
        }

        public void setAppUserOrgNo(String appUserOrgNo) {
            this.appUserOrgNo = appUserOrgNo;
        }

        public Long getTxLogSeq() {
            return txLogSeq;
        }

        public void setTxLogSeq(Long txLogSeq) {
            this.txLogSeq = txLogSeq;
        }

        public String getTransCode() {
            return transCode;
        }

        public void setTransCode(String transCode) {
            this.transCode = transCode;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public String getMemo() {
            return memo;
        }

        public void setMemo(String memo) {
            this.memo = memo;
        }

        public String getRevseInd() {
            return revseInd;
        }

        public void setRevseInd(String revseInd) {
            this.revseInd = revseInd;
        }

        public String getRevseDt() {
            return revseDt;
        }

        public void setRevseDt(String revseDt) {
            this.revseDt = revseDt;
        }

        public String getRevseTm() {
            return revseTm;
        }

        public void setRevseTm(String revseTm) {
            this.revseTm = revseTm;
        }

        public String getInfoCmisInd() {
            return infoCmisInd;
        }

        public void setInfoCmisInd(String infoCmisInd) {
            this.infoCmisInd = infoCmisInd;
        }

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }

        public String getLoanContNo() {
            return loanContNo;
        }

        public void setLoanContNo(String loanContNo) {
            this.loanContNo = loanContNo;
        }

        public String getSentSys() {
            return sentSys;
        }

        public void setSentSys(String sentSys) {
            this.sentSys = sentSys;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getLoanNo() {
            return loanNo;
        }

        public void setLoanNo(String loanNo) {
            this.loanNo = loanNo;
        }

        public String getFromGjNo() {
            return fromGjNo;
        }

        public void setFromGjNo(String fromGjNo) {
            this.fromGjNo = fromGjNo;
        }

        public String getMyrzSerno() {
            return myrzSerno;
        }

        public void setMyrzSerno(String myrzSerno) {
            this.myrzSerno = myrzSerno;
        }

        public String getAccUserId() {
            return accUserId;
        }

        public void setAccUserId(String accUserId) {
            this.accUserId = accUserId;
        }

        public String getAccUserOrgNo() {
            return accUserOrgNo;
        }

        public void setAccUserOrgNo(String accUserOrgNo) {
            this.accUserOrgNo = accUserOrgNo;
        }

        public BigDecimal getPrcpAmt() {
            return prcpAmt;
        }

        public void setPrcpAmt(BigDecimal prcpAmt) {
            this.prcpAmt = prcpAmt;
        }

        public BigDecimal getNormIntAmt() {
            return normIntAmt;
        }

        public void setNormIntAmt(BigDecimal normIntAmt) {
            this.normIntAmt = normIntAmt;
        }

        public BigDecimal getOdIntAmt() {
            return odIntAmt;
        }

        public void setOdIntAmt(BigDecimal odIntAmt) {
            this.odIntAmt = odIntAmt;
        }

        public BigDecimal getCommOdIntAmt() {
            return commOdIntAmt;
        }

        public void setCommOdIntAmt(BigDecimal commOdIntAmt) {
            this.commOdIntAmt = commOdIntAmt;
        }

}
