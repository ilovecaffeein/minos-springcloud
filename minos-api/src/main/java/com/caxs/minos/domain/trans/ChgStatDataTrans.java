package com.caxs.minos.domain.trans;

import com.caxs.minos.domain.LmPmShd;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2020/9/27.
 */
public class ChgStatDataTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;
    // 还款计划列表
    List<LmPmShd> pmShdList = null;
    /**
     * 是否假期
     */
    boolean isHolidayProcessed = false;
    // 是否逾期利息转正常
    boolean isOdIntToNorm = false;
    /**
     * 是否利息转表外
     */
    boolean isIntToSusp = false;
    /**
     * 表外逾期90天
     */
    boolean isOver90Day = false;
    /**
     * 本金拖欠
     */
    boolean isPrcpOver = false;
    /**
     * 正常利息转逾期
     */
    boolean isNormIntOd = false;// 正常利息逾期90天转表外
    double normInt = 0;// 正常利息
    double odInt = 0; // 逾期利息
    double commInt = 0; // 复利
    double prcp = 0; // 本金
    boolean hasAccount = false; // 是否需要记账
    int holidayCount; // 假期天数

    /**
     * 是否补计提
     * */
    private boolean isSuppAcc =true;

    /**
     * 是否补计提
     * */
    public boolean isSuppAcc() {
        return isSuppAcc;
    }

    /**
     * 转表外利息
     */
    double suspNormInt = 0;
    /**
     *表外利息
     */
    double suspCommInt = 0;

    /**
     * 转表外计提利息
     */
    double incTaken = 0;
    /**
     * 转表外逾期计提
     */
    double odIncTaken = 0;
    /**
     * 转表外逾期利息
     */
    double suspOdInt = 0;
    /**
     * 贷款逾期
     */
    boolean isOver = false; // 是否逾期
    double delqPrcp = 0; // 拖欠本金
    double overPrcp = 0; // 逾期本金
    boolean isFirstSusp = false;// 利息是否首次转表外，之前无转表外情况
    boolean isDueDtDbTrans = false;// 当前是否有多次形态转移，如应还款日正好是转表外日期
    boolean isIntToOd = false;// 利息转逾期 应还款日正好是转表外日期或者逾期90天后利息到期

    /**
     * 表外利息转逾期 逾期回到90天以内
     */
    double innOdNormInt = 0; // 逾期转表外或表外转回表内利息
    double dueIncTaken = 0; // 转回的当期应计利息
    double dueOdIncTaken = 0; // 转回的当期应计罚息


    public List<LmPmShd> getPmShdList() {
        return pmShdList;
    }
    public void setPmShdList(List<LmPmShd> pmShdList) {
        this.pmShdList = pmShdList;
    }
    public boolean isHolidayProcessed() {
        return isHolidayProcessed;
    }
    public void setHolidayProcessed(boolean isHolidayProcessed) {
        this.isHolidayProcessed = isHolidayProcessed;
    }
    public boolean isOdIntToNorm() {
        return isOdIntToNorm;
    }
    public void setOdIntToNorm(boolean isOdIntToNorm) {
        this.isOdIntToNorm = isOdIntToNorm;
    }
    public boolean isIntToSusp() {
        return isIntToSusp;
    }
    public void setIntToSusp(boolean isIntToSusp) {
        this.isIntToSusp = isIntToSusp;
    }
    public boolean isOver90Day() {
        return isOver90Day;
    }
    public void setOver90Day(boolean isOver90Day) {
        this.isOver90Day = isOver90Day;
    }
    public boolean isPrcpOver() {
        return isPrcpOver;
    }
    public void setPrcpOver(boolean isPrcpOver) {
        this.isPrcpOver = isPrcpOver;
    }
    public boolean isNormIntOd() {
        return isNormIntOd;
    }
    public void setNormIntOd(boolean isNormIntOd) {
        this.isNormIntOd = isNormIntOd;
    }
    public double getNormInt() {
        return normInt;
    }
    public void setNormInt(double normInt) {
        this.normInt = normInt;
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
    public double getPrcp() {
        return prcp;
    }
    public void setPrcp(double prcp) {
        this.prcp = prcp;
    }
    public boolean isHasAccount() {
        return hasAccount;
    }
    public void setHasAccount(boolean hasAccount) {
        this.hasAccount = hasAccount;
    }
    public int getHolidayCount() {
        return holidayCount;
    }
    public void setHolidayCount(int holidayCount) {
        this.holidayCount = holidayCount;
    }
    public double getSuspNormInt() {
        return suspNormInt;
    }
    public void setSuspNormInt(double suspNormInt) {
        this.suspNormInt = suspNormInt;
    }
    public double getSuspCommInt() {
        return suspCommInt;
    }
    public void setSuspCommInt(double suspCommInt) {
        this.suspCommInt = suspCommInt;
    }
    public double getIncTaken() {
        return incTaken;
    }
    public void setIncTaken(double incTaken) {
        this.incTaken = incTaken;
    }
    public double getOdIncTaken() {
        return odIncTaken;
    }
    public void setOdIncTaken(double odIncTaken) {
        this.odIncTaken = odIncTaken;
    }
    public double getSuspOdInt() {
        return suspOdInt;
    }
    public void setSuspOdInt(double suspOdInt) {
        this.suspOdInt = suspOdInt;
    }
    public boolean isOver() {
        return isOver;
    }
    public void setOver(boolean isOver) {
        this.isOver = isOver;
    }
    public double getDelqPrcp() {
        return delqPrcp;
    }
    public void setDelqPrcp(double delqPrcp) {
        this.delqPrcp = delqPrcp;
    }
    public double getOverPrcp() {
        return overPrcp;
    }
    public void setOverPrcp(double overPrcp) {
        this.overPrcp = overPrcp;
    }
    public boolean isFirstSusp() {
        return isFirstSusp;
    }
    public void setFirstSusp(boolean isFirstSusp) {
        this.isFirstSusp = isFirstSusp;
    }
    public boolean isDueDtDbTrans() {
        return isDueDtDbTrans;
    }
    public void setDueDtDbTrans(boolean isDueDtDbTrans) {
        this.isDueDtDbTrans = isDueDtDbTrans;
    }
    public boolean isIntToOd() {
        return isIntToOd;
    }
    public void setIntToOd(boolean isIntToOd) {
        this.isIntToOd = isIntToOd;
    }
    public double getInnOdNormInt() {
        return innOdNormInt;
    }
    public void setInnOdNormInt(double innOdNormInt) {
        this.innOdNormInt = innOdNormInt;
    }
    public double getDueIncTaken() {
        return dueIncTaken;
    }
    public void setDueIncTaken(double dueIncTaken) {
        this.dueIncTaken = dueIncTaken;
    }
    public double getDueOdIncTaken() {
        return dueOdIncTaken;
    }
    public void setDueOdIncTaken(double dueOdIncTaken) {
        this.dueOdIncTaken = dueOdIncTaken;
    }
}
