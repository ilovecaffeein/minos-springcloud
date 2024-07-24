package com.caxs.minos.domain.trans;

public class PaymentTryTrans {
    String loanNo;
    String buzDate;
    double actvPayAmt;
    String setlMode;
    String seltTyp;

    /**
     * 还款模式
     *
     * @return
     */
    public String getSetlMode() {
        return this.setlMode;
    }

    /**
     * 设置还款模式
     *
     * @param setlMode
     */
    public void setSetlMode(String setlMode) {
        this.setlMode = setlMode;
    }

    /**
     * 获取借据号
     *
     * @return
     */
    public String getLoanNo() {
        return this.loanNo;
    }

    /**
     * 设置借据号
     *
     * @param loanNo
     */
    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public String getBuzDate() {
        return buzDate;
    }

    public void setBuzDate(String buzDate) {
        this.buzDate = buzDate;
    }

    public double getActvPayAmt() {
        return actvPayAmt;
    }

    public void setActvPayAmt(double actvPayAmt) {
        this.actvPayAmt = actvPayAmt;
    }

    public String getSeltTyp() {
        return seltTyp;
    }

    public void setSeltTyp(String seltTyp) {
        this.seltTyp = seltTyp;
    }

    public  PaymentTryTrans(){
    }

    public  PaymentTryTrans(String loanNo,String buzDate ,
                            double actvPayAmt,String setlMode,String seltTyp){
        this.loanNo = loanNo;
        this.buzDate = buzDate;
        this.actvPayAmt = actvPayAmt;
        this.setlMode = setlMode;
        this.seltTyp = seltTyp;
    }
}
