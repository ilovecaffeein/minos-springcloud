package com.caxs.minos.domain.trans;

import java.io.Serializable;

/**
 * Created by lenovo on 2020/8/14.
 */
public class AdvPayOptTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;
    /**
     *等额本金递增调整 如果为-1 表示不加调整
     */

    private double pgsPrcpAmt = -1;

    public double getPgsPrcpAmt() {
        return pgsPrcpAmt;
    }

    public void setPgsPrcpAmt(double pgsPrcpAmt) {
        this.pgsPrcpAmt = pgsPrcpAmt;
    }

    /**
     *传入的提前还的金额是本金还是本息
     */
    private String intPrcpInd = null;

    public String getIntPrcpInd() {
        return intPrcpInd;
    }

    public void setIntPrcpInd(String intPrcpInd) {
        this.intPrcpInd = intPrcpInd;
    }


    public AdvPayOptTrans(String intPrcpInd) {
        this.intPrcpInd = intPrcpInd;
    }

    /**
     * 首次还款日
     */
    private String firstPayDt = null;

    public String getFirstPayDt() {
        return firstPayDt;
    }

    public void setFirstPayDt(String firstPayDt) {
        this.firstPayDt = firstPayDt;
    }

}
