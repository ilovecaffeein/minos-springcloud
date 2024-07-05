package com.caxs.minos.domain.trans;

import com.caxs.minos.domain.LmPmShd;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lenovo on 2020/8/13.
 */
public class PaymentShdTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;

    private Integer psPerdNo;
    private BigDecimal psInstmAmt;
    private BigDecimal psPrcpAmt;
    private BigDecimal psNormIntAmt;
    private BigDecimal psOdIntAmt;
    private BigDecimal psCommOdInt;
    private BigDecimal psFeeAmt;
    private BigDecimal setlPrcp;
    private BigDecimal setlNormInt;
    private BigDecimal setlOdIntAmt;
    private BigDecimal setlCommOdInt;
    private BigDecimal setlFeeAmt;
    private String setlInd;
    private BigDecimal psIncTaken;
    private BigDecimal psOdIncTaken;
    private BigDecimal psCurOdIncTaken;
    private String intState;
    private String prcpState;
    private BigDecimal psRemPrcp;
    private LmPmShd shd;
    private String psDueDt;
    private BigDecimal prodPrcpAmt;
    private BigDecimal prodIntAmt;
    private BigDecimal psIntRate;			//执行利率
    private BigDecimal psOdIntRate;			//逾期利率
    /**
     * 原确认的罚息
     */
    private BigDecimal confirmOdInt;
    /**
     * 原确认的复利
     */
    private BigDecimal confirmCommInt;

    private BigDecimal prodCommIntAmt;

    private boolean isNormIntAccount = false;
    /**
     * 正常利息是否记账。
     */
    private boolean isOdIntAccount = false;
    /**
     * 是否结出新的罚息
     */
    private boolean isSetlPunish = true;
    /**
     * 是否还新结罚息
     */
    private boolean isPayNewPunish = false;

    private BigDecimal payedDevCommInt;

    private BigDecimal payedCustomInt;

    private BigDecimal payedDevOdInt;

    /**
     * 还得本金
     */
    private BigDecimal payedPrcp = new BigDecimal(0);
    /**
     * 还得利息
     */
    private BigDecimal payedNormInt = new BigDecimal(0);
    /**
     * 还得逾期利息
     */
    private BigDecimal payedOdInt =new BigDecimal(0);
    /**
     * 还得手续费
     */
    private BigDecimal payedFeeAmt =new BigDecimal(0);
    /**
     * 还得复利
     */
    private BigDecimal payedCommInt =new BigDecimal(0);

    private BigDecimal payedDevNormInt = new BigDecimal(0);

    private BigDecimal payedOdPrcp =new BigDecimal(0);

    private BigDecimal payedDevOdPrcp =new BigDecimal(0);

    private BigDecimal payedDevNormPrcp =new BigDecimal(0);


    public BigDecimal getSetlFeeAmt() {
        return setlFeeAmt;
    }

    public void setSetlFeeAmt(BigDecimal setlFeeAmt) {
        this.setlFeeAmt = setlFeeAmt;
    }

    public BigDecimal getPsFeeAmt() {
        return psFeeAmt;
    }

    public void setPsFeeAmt(BigDecimal psFeeAmt) {
        this.psFeeAmt = psFeeAmt;
    }


    public BigDecimal getProdPrcpAmt() {
        return prodPrcpAmt;
    }

    public void setProdPrcpAmt(BigDecimal prodPrcpAmt) {
        this.prodPrcpAmt = prodPrcpAmt;
    }

    public BigDecimal getProdIntAmt() {
        return prodIntAmt;
    }

    public void setProdIntAmt(BigDecimal prodIntAmt) {
        this.prodIntAmt = prodIntAmt;
    }

    public BigDecimal getProdCommIntAmt() {
        return prodCommIntAmt;
    }

    public void setProdCommIntAmt(BigDecimal prodCommIntAmt) {
        this.prodCommIntAmt = prodCommIntAmt;
    }

    public boolean isNormIntAccount() {
        return isNormIntAccount;
    }

    public void setNormIntAccount(boolean isNormIntAccount) {
        this.isNormIntAccount = isNormIntAccount;
    }

    public boolean isOdIntAccount() {
        return isOdIntAccount;
    }

    public BigDecimal getPsCurOdIncTaken() {
        return psCurOdIncTaken;
    }

    public void setPsCurOdIncTaken(BigDecimal psCurOdIncTaken) {
        this.psCurOdIncTaken = psCurOdIncTaken;
    }

    public void setOdIntAccount(boolean isOdIntAccount) {
        this.isOdIntAccount = isOdIntAccount;
    }

    public BigDecimal getConfirmOdInt() {
        return confirmOdInt;
    }

    public void setConfirmOdInt(BigDecimal confirmOdInt) {
        this.confirmOdInt = confirmOdInt;
    }

    public BigDecimal getConfirmCommInt() {
        return confirmCommInt;
    }

    public void setConfirmCommInt(BigDecimal confirmCommInt) {
        this.confirmCommInt = confirmCommInt;
    }

    /**
     * 是否还新结罚息
     *
     * @return
     */
    public boolean isPayNewPunish() {
        return isPayNewPunish;
    }

    public void setPayNewPunish(boolean isPayNewPunish) {
        this.isPayNewPunish = isPayNewPunish;
    }

    public BigDecimal getPayedCustomInt() {
        return payedCustomInt;
    }

    public void setPayedCustomInt(BigDecimal payedCustomInt) {
        this.payedCustomInt = payedCustomInt;
    }


    public BigDecimal getPayedDevOdInt() {
        return payedDevOdInt;
    }

    public BigDecimal getPayedDevCommInt() {
        return payedDevCommInt;
    }

    public void setPayedDevCommInt(BigDecimal payedDevCommInt) {
        this.payedDevCommInt = payedDevCommInt;
    }

    public void setPayedDevOdInt(BigDecimal payedDevOdInt) {
        this.payedDevOdInt = payedDevOdInt;
    }

    public BigDecimal getPayedDevNormInt() {
        return payedDevNormInt;
    }

    public BigDecimal getPayedDevOdPrcp() {
        return payedDevOdPrcp;
    }

    public void setPayedDevOdPrcp(BigDecimal payedDevOdPrcp) {
        this.payedDevOdPrcp = payedDevOdPrcp;
    }

    public BigDecimal getPayedDevNormPrcp() {
        return payedDevNormPrcp;
    }

    public void setPayedDevNormPrcp(BigDecimal payedDevNormPrcp) {
        this.payedDevNormPrcp = payedDevNormPrcp;
    }

    public void setPayedDevNormInt(BigDecimal payedDevNormInt) {
        this.payedDevNormInt = payedDevNormInt;
    }

    public BigDecimal getPayedOdPrcp() {
        return payedOdPrcp;
    }

    public void setPayedOdPrcp(BigDecimal payedOdPrcp) {
        this.payedOdPrcp = payedOdPrcp;
    }

    public BigDecimal getPayedNormInt() {
        return payedNormInt;
    }

    public void setPayedNormInt(BigDecimal payedNormInt) {
        this.payedNormInt = payedNormInt;
    }

    public BigDecimal getPayedOdInt() {
        return payedOdInt;
    }

    public void setPayedOdInt(BigDecimal payedOdInt) {
        this.payedOdInt = payedOdInt;
    }

    public BigDecimal getPayedCommInt() {
        return payedCommInt;
    }

    public void setPayedFeeAmt(BigDecimal payedFeeAmt) {
        this.payedFeeAmt = payedFeeAmt;
    }

    public BigDecimal getPayedFeeAmt() {
        return payedFeeAmt;
    }


    public boolean isSetlPunish() {
        return isSetlPunish;
    }

    public void setSetlPunish(boolean isSetlPunish) {
        this.isSetlPunish = isSetlPunish;
    }

    public void setPayedCommInt(BigDecimal payedCommInt) {
        this.payedCommInt = payedCommInt;
    }

    public BigDecimal getPayedPrcp() {
        return payedPrcp;
    }

    public void setPayedPrcp(BigDecimal payedPrcp) {
        this.payedPrcp = payedPrcp;
    }

    public String getPsDueDt() {
        return psDueDt;
    }

    public void setPsDueDt(String psDueDt) {
        this.psDueDt = psDueDt;
    }

    public PaymentShdTrans() {
        super();
    }

    public LmPmShd getShd() {
        return shd;
    }

    public void setShd(LmPmShd shd) {
        this.shd = shd;
    }

    public String getIntState() {
        return intState;
    }

    public void setIntState(String intState) {
        this.intState = intState;
    }

    public String getPrcpState() {
        return prcpState;
    }

    public void setPrcpState(String prcpState) {
        this.prcpState = prcpState;
    }

    public BigDecimal getPsIncTaken() {
        return psIncTaken;
    }

    public void setPsIncTaken(BigDecimal psIncTaken) {
        this.psIncTaken = psIncTaken;
    }

    public String getSetlInd() {
        return setlInd;
    }

    public void setSetlInd(String setlInd) {
        this.setlInd = setlInd;
    }

    public Integer getPsPerdNo() {
        return psPerdNo;
    }

    public void setPsPerdNo(Integer psPerdNo) {
        this.psPerdNo = psPerdNo;
    }

    public BigDecimal getPsInstmAmt() {
        return psInstmAmt;
    }

    public void setPsInstmAmt(BigDecimal psInstmAmt) {
        this.psInstmAmt = psInstmAmt;
    }

    public BigDecimal getPsPrcpAmt() {
        return psPrcpAmt;
    }

    public void setPsPrcpAmt(BigDecimal psPrcpAmt) {
        this.psPrcpAmt = psPrcpAmt;
    }

    public BigDecimal getPsNormIntAmt() {
        return psNormIntAmt;
    }

    public void setPsNormIntAmt(BigDecimal psNormIntAmt) {
        this.psNormIntAmt = psNormIntAmt;
    }

    public BigDecimal getPsOdIntAmt() {
        return psOdIntAmt;
    }

    public void setPsOdIntAmt(BigDecimal psOdIntAmt) {
        this.psOdIntAmt = psOdIntAmt;
    }

    public BigDecimal getPsCommOdInt() {
        return psCommOdInt;
    }

    public void setPsCommOdInt(BigDecimal psCommOdInt) {
        this.psCommOdInt = psCommOdInt;
    }

    public BigDecimal getSetlPrcp() {
        return setlPrcp;
    }

    public void setSetlPrcp(BigDecimal setlPrcp) {
        this.setlPrcp = setlPrcp;
    }

    public BigDecimal getSetlNormInt() {
        return setlNormInt;
    }

    public void setSetlNormInt(BigDecimal setlNormInt) {
        this.setlNormInt = setlNormInt;
    }

    public BigDecimal getSetlOdIntAmt() {
        return setlOdIntAmt;
    }

    public void setSetlOdIntAmt(BigDecimal setlOdIntAmt) {
        this.setlOdIntAmt = setlOdIntAmt;
    }

    public BigDecimal getSetlCommOdInt() {
        return setlCommOdInt;
    }

    public void setSetlCommOdInt(BigDecimal setlCommOdInt) {
        this.setlCommOdInt = setlCommOdInt;
    }

    public BigDecimal getPsOdIncTaken() {
        return psOdIncTaken;
    }

    public void setPsOdIncTaken(BigDecimal psOdIncTaken) {
        this.psOdIncTaken = psOdIncTaken;
    }

    public BigDecimal getPsRemPrcp() {
        return psRemPrcp;
    }

    public void setPsRemPrcp(BigDecimal psRemPrcp) {
        this.psRemPrcp = psRemPrcp;
    }

    public BigDecimal getPsIntRate() {
        return psIntRate;
    }

    public void setPsIntRate(BigDecimal psIntRate) {
        this.psIntRate = psIntRate;
    }

    public BigDecimal getPsOdIntRate() {
        return psOdIntRate;
    }

    public void setPsOdIntRate(BigDecimal psOdIntRate) {
        this.psOdIntRate = psOdIntRate;
    }

    public PaymentShdTrans(LmPmShd shd) {
        super();
        this.psPerdNo = shd.getPsPerdNo();
        this.shd = shd;
    }
    public PaymentShdTrans(BigDecimal psInstmAmt,BigDecimal psPrcpAmt, BigDecimal psNormIntAmt,
                           BigDecimal psOdIntAmt, BigDecimal psCommOdInt,BigDecimal psFeeAmt,
                           BigDecimal setlPrcp,BigDecimal setlNormInt, BigDecimal setlOdIntAmt,
                           BigDecimal setlCommOdInt, BigDecimal setlFeeAmt) {
        super();
        this.psInstmAmt = psInstmAmt;
        this.psPrcpAmt = psPrcpAmt;
        this.psNormIntAmt = psNormIntAmt;
        this.psOdIntAmt = psOdIntAmt;
        this.psCommOdInt = psCommOdInt;
        this.psFeeAmt = psFeeAmt;
        this.setlPrcp = setlPrcp;
        this.setlNormInt = setlNormInt;
        this.setlOdIntAmt = setlOdIntAmt;
        this.setlCommOdInt = setlCommOdInt;
        this.setlFeeAmt = setlFeeAmt;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append("perdno=").append(getPsPerdNo()).append(",");
        sb.append("payedPrcp=").append(getPayedPrcp()).append(",");
        sb.append("payedNormInt=").append(payedNormInt).append(",");
        sb.append("payedDevNormInt=").append(payedDevNormInt).append(",");
        sb.append("payedOdInt=").append(payedOdInt).append(",");
        sb.append("payedDevOdInt=").append(payedDevOdInt).append(",");
        sb.append("payedCommInt=").append(payedCommInt).append(",");
        sb.append("payedDevCommInt=").append(payedDevCommInt).append(",");
        sb.append("payedCustomInt=").append(payedCustomInt).append(",");
        return sb.toString();

    }
}
