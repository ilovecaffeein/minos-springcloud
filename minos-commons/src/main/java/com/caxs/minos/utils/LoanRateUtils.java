package com.caxs.minos.utils;

import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.LmLoanCont;
import com.caxs.minos.enums.LoanRateBaseEnum;
import com.caxs.minos.exception.MinosException;

import java.math.BigDecimal;
/**
 * Created by lenovo on 2020/8/14.
 */
public class LoanRateUtils {
    private int dayCountYearly;
    private LoanRateBaseEnum loanRateBase;
    private LmLoan lmLoan;
    // 为true表按实际天数算，由p_loan_typ_gl表中GL_RAT_BASE决定
    private LoanRelateUtils loanRelate;

    /**
     * @return the dayCountYearly
     */
    public int getDayCountYearly() {
        return dayCountYearly;
    }

    /**
     * @param lmLoan
     * @param lmLoanCont
     * LmLoan, LmLoanCont lmLoanCont
     */
    public LoanRateUtils(LmLoan lmLoan, LmLoanCont lmLoanCont, int dayCountYearly) {
        this.lmLoan = lmLoan;
        loanRelate = new LoanRelateUtils(lmLoan, lmLoanCont);
		/* 取利率基础 */
        loanRateBase = LoanRateBaseEnum.getEnum(lmLoan.getRateBase());
        //计算一年多少天
        this.dayCountYearly = dayCountYearly;
    }

    public BigDecimal getLendOdIntRateDayly() {
        BigDecimal lendingRate = computeDaylyRate(
                loanRateBase, lmLoan.getLoanOdIntRate(), dayCountYearly);
        return lendingRate;
    }

    public BigDecimal getLendingRateDayly() {
        BigDecimal lendingRate = computeDaylyRate(
                loanRateBase, lmLoan.getLoanIntRate(), dayCountYearly);
        return lendingRate;
    }

    //计算日利率
    public BigDecimal computeDaylyRate(LoanRateBaseEnum loanRateBase,BigDecimal rate, int yearDayCount) {
        if (rate == null) {
            throw new MinosException("利率不能为空");
        }
        switch (loanRateBase) {
            case M:
                return BigDecimal.valueOf(rate.doubleValue() * 12 / yearDayCount);
            case D:
                return rate;
            case Y:
                return BigDecimal.valueOf((rate.doubleValue() / yearDayCount));
        }
        throw new MinosException("not supported");
    }

    /**
     * @return the loanRateBase
     */
    public LoanRateBaseEnum getLoanRateBase() {
        return loanRateBase;
    }
}
