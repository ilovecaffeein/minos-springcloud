package com.caxs.minos.domain.trans;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by lenovo on 2020/8/13.
 */
public class ShdTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;

    String ppErInd;

    Integer psPerdNo;

    String psDueDt;

    String psBillDt;

    BigDecimal psInstmAmt = new BigDecimal(0);

    BigDecimal psPrcpAmt = new BigDecimal(0);

    BigDecimal psNormIntAmt =  new BigDecimal(0);

    BigDecimal psIntRate = new BigDecimal(0);

    BigDecimal psOdIntRate = new BigDecimal(0);

    BigDecimal psRemPrcp = new BigDecimal(0);

    BigDecimal interestPrcp = new BigDecimal(0);

    boolean perdPlusDayCount = false;

    boolean isCaculateAccordingActualDay;

    public BigDecimal getPsIntRate()
    {
        return this.psIntRate;
    }

    public void setPsIntRate(BigDecimal psIntRate) {
        this.psIntRate = psIntRate;
    }

    public BigDecimal getPsOdIntRate() {
        return this.psOdIntRate;
    }

    public void setPsOdIntRate(BigDecimal psOdIntRate) {
        this.psOdIntRate = psOdIntRate;
    }

    public BigDecimal getInterestPrcp()
    {
        return this.interestPrcp;
    }

    public void setInterestPrcp(BigDecimal interestPrcp) {
        this.interestPrcp = interestPrcp;
    }

    public BigDecimal getPsRemPrcp() {
        return this.psRemPrcp;
    }

    public void setPsRemPrcp(BigDecimal psRemPrcp) {
        this.psRemPrcp = psRemPrcp;
    }

    public Integer getPsPerdNo() {
        return this.psPerdNo;
    }

    public void setPsPerdNo(Integer psPerdNo) {
        this.psPerdNo = psPerdNo;
    }

    public void  setPsDueDt(String psDueDt) {
        this.psDueDt = psDueDt;
    }
    public String getPsDueDt() {
        return this.psDueDt;
    }

    public BigDecimal getPsInstmAmt() {
        return this.psInstmAmt;
    }

    public void setPsInstmAmt( BigDecimal psInstmAmt) {
        this.psInstmAmt = psInstmAmt;
    }

    public void setPsNormIntAmt( BigDecimal psNormIntAmt) {
        this.psNormIntAmt = psNormIntAmt;
    }

    public void setPsPrcpAmt( BigDecimal psPrcpAmt) {
        this.psPrcpAmt = psPrcpAmt;
    }

    public BigDecimal getPsPrcpAmt() {
        return this.psPrcpAmt;
    }

    public BigDecimal getPsNormIntAmt() {
        return this.psNormIntAmt;
    }

    public ShdTrans(int psPerdNo)
    {
        this.psPerdNo = Integer.valueOf(psPerdNo);
    }

    public ShdTrans(){
    }

    public ShdTrans(Integer psPerdNo, String psDueDt, BigDecimal psInstmAmt, BigDecimal psPrcpAmt,
                    BigDecimal psNormIntAmt, BigDecimal psIntRate) {
        this.psPerdNo = psPerdNo;
        this.psDueDt = psDueDt;
        this.psInstmAmt = psInstmAmt;
        this.psPrcpAmt = psPrcpAmt;
        this.psNormIntAmt = psNormIntAmt;
        this.psIntRate = psIntRate;
    }

    public ShdTrans(Integer psPerdNo, String psDueDt, BigDecimal psInstmAmt, BigDecimal psPrcpAmt, BigDecimal psNormIntAmt,
                    BigDecimal psIntRate, BigDecimal psOdIntRate, BigDecimal psRemPrcp, BigDecimal interestPrcp, boolean isCaculateAccordingActualDay) {
        this.psPerdNo = psPerdNo;
        this.psDueDt = psDueDt;
        this.psInstmAmt = psInstmAmt;
        this.psPrcpAmt = psPrcpAmt;
        this.psNormIntAmt = psNormIntAmt;
        this.psIntRate = psIntRate;
        this.psOdIntRate = psOdIntRate;
        this.psRemPrcp = psRemPrcp;
        this.interestPrcp = interestPrcp;
        this.isCaculateAccordingActualDay = isCaculateAccordingActualDay;
    }

    public int compareTo(ShdTrans o) {
        return this.psDueDt.compareTo(o.getPsDueDt());
    }

    public boolean isCaculateAccordingActualDay()
    {
        return this.isCaculateAccordingActualDay;
    }

    public String getPsBillDt() {
        return this.psBillDt;
    }

    public void setPsBillDt(String psBillDt) {
        this.psBillDt = psBillDt;
    }

    public String toString() {
        return " \n[期数=" + this.psPerdNo + ", 日期=" + this.psDueDt + ",期供：" + this.psInstmAmt +
                ", 利息=" + this.psNormIntAmt + ", 本金=" + this.psPrcpAmt + ", 剩余本金=" +
                this.psRemPrcp + ",计息本金=" + this.interestPrcp + ", 是否实天=" +
                //  this.isCaculateAccordingActualDay + ", 频率=" + this.paymUnit +
                ((this.perdPlusDayCount) ? ",期加天=是" : ",期利率=否") + ", 利率=" +
                this.psIntRate + "]";
    }

    public boolean isPerdPlusDayCount() {
        return this.perdPlusDayCount;
    }

    public void setPerdPlusDayCount(boolean perdPlusDayCount) {
        this.perdPlusDayCount = perdPlusDayCount;
    }
}
