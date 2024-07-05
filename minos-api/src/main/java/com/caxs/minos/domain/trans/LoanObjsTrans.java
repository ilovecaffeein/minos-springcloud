package com.caxs.minos.domain.trans;

import com.caxs.minos.domain.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2020/9/7.
 */
public class LoanObjsTrans implements Serializable {
    private static final long serialVersionUID = 7607704161124404623L;

    //贷款对象
    private LmGlnoLog lmGlnoLog;
    private LmLoan lmLoan;
    private LmLoanCont lmLoanCont;
    private final List<LmPmShd> lmPmShdList = new ArrayList<LmPmShd>();
    private List<LmLnShdMtd> lmlnShdMtdList = new ArrayList<LmLnShdMtd>();
    private List<LmAcctInfo> lmAcctInfoList = new ArrayList<LmAcctInfo>();
    private final List<LmFeeTx> lmFeeTxList = new ArrayList<LmFeeTx>();
    private LmActvLog lmActvLog;

    public LmGlnoLog getLmGlnoLog() {
        return lmGlnoLog;
    }

    public void setLmGlnoLog(LmGlnoLog lmGlnoLog) {
        this.lmGlnoLog = lmGlnoLog;
    }

    public List<LmFeeTx> getLmFeeTxList() {
        return lmFeeTxList;
    }

    public void addLmFeeTxList(List<LmFeeTx> lmFeeTxList) {
        this.lmFeeTxList.addAll(lmFeeTxList);
    }


    public void addLmAcctInfo(LmAcctInfo acctInfo) {
        this.lmAcctInfoList.add(acctInfo);
    }

    public LmLoan getLmLoan() {
        return lmLoan;
    }

    public void setLmLoan(LmLoan lmLoan) {
        this.lmLoan = lmLoan;
    }

    public LmLoanCont getLmLoanCont() {
        return lmLoanCont;
    }

    public void setLmLoanCont(LmLoanCont lmLoanCont) {
        this.lmLoanCont = lmLoanCont;
    }

    public List<LmLnShdMtd> getLmlnShdMtdList() {
        return lmlnShdMtdList;
    }

    public void setLmlnShdMtdList(List<LmLnShdMtd> lmlnShdMtdList) {
        this.lmlnShdMtdList = lmlnShdMtdList;
    }

    public List<LmAcctInfo> getLmAcctInfoList() {
        return lmAcctInfoList;
    }
    public void setLmAcctInfoList(List<LmAcctInfo> lmAcctInfoList) {
        this.lmAcctInfoList.addAll(lmAcctInfoList);
    }

    public LmActvLog getLmActvLog() {
        return lmActvLog;
    }

    public void setLmActvLog(LmActvLog lmActvLog) {
        this.lmActvLog = lmActvLog;
    }

    public List<LmPmShd> getLmPmShdList() {
        return lmPmShdList;
    }
    public void addLmPmShdList(List<LmPmShd> lmPmShdList) {
        this.lmPmShdList.addAll(lmPmShdList);
    }


}
