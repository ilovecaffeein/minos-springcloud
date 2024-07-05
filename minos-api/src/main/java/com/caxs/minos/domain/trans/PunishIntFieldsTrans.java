package com.caxs.minos.domain.trans;

import java.io.Serializable;

/**
 * Created by lenovo on 2020/8/14.
 */
public class PunishIntFieldsTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;

    private double sum = 0;
    /**
     * 利息
     */
    private double odInt = 0;
    private double prodPrcpAmt = 0;
    private double prodOdAmt = 0;
    private double prodCommAmt = 0;
    /**是否有新结追加罚息，最小罚息用，如果是还款则启动比较最小罚息，如果计提不比较最小罚息*/
    private double appedOdInt = 0;

    /**
     * 复利
     */
    private double commInt = 0;

    public double getProdPrcpAmt() {
        return prodPrcpAmt;
    }

    public void setProdPrcpAmt(double prodPrcpAmt) {
        this.prodPrcpAmt = prodPrcpAmt;
    }

    public double getProdCommAmt() {
        return prodCommAmt;
    }

    public void setProdCommAmt(double prodCommAmt) {
        this.prodCommAmt = prodCommAmt;
    }


    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getProdOdAmt() {
        return prodOdAmt;
    }

    public void setProdOdAmt(double prodOdAmt) {
        this.prodOdAmt = prodOdAmt;
    }

    public double getOdInt() {
        return odInt;
    }

    public void setOdInt(double odInt) {
        this.odInt = odInt;
    }

    public double getCommInt() {
        return commInt;
    }

    public void setCommInt(double commInt) {
        this.commInt = commInt;
    }

    public double getAppedOdInt() {
        return appedOdInt;
    }

    public void setAppedOdInt(double appedOdInt) {
        this.appedOdInt = appedOdInt;
    }

}
