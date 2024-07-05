package com.caxs.minos.utils;

import com.caxs.minos.enums.CommPartEnum;
import com.caxs.minos.enums.YnFlagEnum;

/**
 * 罚息计算参数
 *
 * @author coffee
 *
 */
public class PunishConfigUtils {
    private double minOdInt = 0;// 最小罚息
    private CommPartEnum commPart;// 罚息组成
    private boolean hasMinOdInt = false;// 是否有最小罚息
    private boolean isPay = false;// 是否扣款
    private boolean stopOdInt=false; //是否停止罚息
    private boolean loanOdGraceInd=false; //是否停止罚息
    private boolean loanOdIntGraceInd=false; //是否停止复利

    //获取是否停止罚息
    public boolean getLoanOdGraceInd() {
        return loanOdGraceInd;
    }
    //设置是否停止罚息
    public void setLoanOdGraceInd(boolean loanOdGraceInd) {
        this.loanOdGraceInd = loanOdGraceInd;
    }

    //获取是否停止复利
    public boolean getLoanOdIntGraceInd() {
        return loanOdIntGraceInd;
    }
    //设置是否停止复利
    public void setLoanOdIntGraceInd(boolean loanOdIntGraceInd) {
        this.loanOdIntGraceInd = loanOdIntGraceInd;
    }

    //获取是否停止罚息
    public boolean isStopOdInt() {
        return stopOdInt;
    }
    //设置是否停止罚息
    public void setStopOdInt(boolean stopOdInt) {
        this.stopOdInt = stopOdInt;
    }

    /**
     * 补滚积数
     */
    private boolean appendProd=false;

    //获取是否补滚积数
    public boolean isAppendProd() {
        return appendProd;
    }
    //设置是否补滚积数
    public void setAppendProd(boolean appendProd) {
        this.appendProd = appendProd;
    }
    //获取是否扣款
    public boolean isPay() {
        return isPay;
    }
    //设置是否扣款
    public void setPay(boolean isPay) {
        this.isPay = isPay;
    }
    //获取是否有最小罚息
    public boolean isHasMinOdInt() {
        return hasMinOdInt;
    }
    //设置是否有最小罚息
    public void setHasMinOdInt(boolean hasMinOdInt) {
        this.hasMinOdInt = hasMinOdInt;
    }

    private YnFlagEnum isCalCommAndOdInt;// 是否计算罚息和复利
    //获取是否计算罚息和复利
    public YnFlagEnum getIsCalCommAndOdInt() {
        return isCalCommAndOdInt;
    }
    //设置是否计算罚息和复利
    public void setIsCalCommAndOdInt(YnFlagEnum isCalCommAndOdInt) {
        this.isCalCommAndOdInt = isCalCommAndOdInt;
    }
    //获取罚息组成
    public CommPartEnum getCommPart() {
        return commPart;
    }
    //设置罚息组成
    public void setCommPart(CommPartEnum commPart) {
        this.commPart = commPart;
    }
    //获取最小罚息
    public double getMinOdInt() {
        return minOdInt;
    }
    //设置最小罚息
    public void setMinOdInt(double minOdInt) {
        this.minOdInt = minOdInt;
    }
}
