package com.caxs.minos.utils;

import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.LmLoan;
import com.yuchengtech.ycloans.buz.Rate;
import com.yuchengtech.ycloans.buz.domain.ShdMtd;
import com.yuchengtech.ycloans.common.enumeration.LoanRateBase;
import com.yuchengtech.ycloans.common.enumeration.PaymentFreq;
import java.math.BigDecimal;
/**
 * @ClassName: RateUtils
 * @Description: 利率工具
 * @Author: cpffee
 * @Date: 2020/8/4 16:23
 * @Version: v1.0 文件初始创建
 */
public class RateUtils {
    /**
     * 根据借据构造Rate对象
     *
     * @param lmLoan
     * @return
     */
    public static Rate buildRate(LmLoan lmLoan) {
        Rate rate = new Rate();
        rate.setBaseRate(lmLoan.getLoanBaseRate().doubleValue());
        rate.setIntRate(lmLoan.getLoanIntRate().doubleValue());
        rate.setAdjPct(lmLoan.getIntAdjPct().doubleValue());
        rate.setSprd(lmLoan.getLoanSprd().doubleValue());
        rate.setOdIntRate(lmLoan.getLoanOdIntRate().doubleValue());
        rate.setSprd(lmLoan.getLoanSprd().doubleValue());
        rate.setRateBase(LoanRateBase.getEnum(lmLoan.getRateBase()));
        return rate;
    }

    // 根据还款方式对象构建利率信息
    public static Rate buildRate(ShdMtd shdMtd) {
        Rate rate = new Rate();
        rate.setBaseRate(SystemUtils.getZeroDoubleIfNull(shdMtd.getBaseRate()));
        rate.setIntRate(SystemUtils
                .getZeroDoubleIfNull(shdMtd.getLoanIntRate()));
        rate.setAdjPct(shdMtd.getIntAdjPct());
        rate.setSprd(shdMtd.getSprd());
        rate.setRateTyp(shdMtd.getRateTyp());
        rate.setRateMode(shdMtd.getLoanRateMode());
        rate.setOdIntRate(SystemUtils.getZeroDoubleIfNull(shdMtd
                .getLoanOdIntRate()));
        return rate;
    }


    /**
     * 计算阶段利率
     * @param loanCcy
     * @param isCaculateAccordingActualDay
     * @param paymentFreq
     * @param loanRateBase
     * @param rateYearly
     * @param frequenceRange
     * @return
     */
    public static double calTermlyRate(String loanCcy,
                                       boolean isCaculateAccordingActualDay, PaymentFreq paymentFreq,
                                       LoanRateBase loanRateBase, double rateYearly, int frequenceRange) {

        double daylyRate = calDaylyRate(loanCcy, isCaculateAccordingActualDay,
                loanRateBase, rateYearly);
        return calTermlyRate(paymentFreq, rateYearly, frequenceRange, daylyRate);
    }



    /**
     * 计算阶段利率
     *
     * @param paymentFreq
     * @param rateYearly
     * @param frequenceRange
     * @param daylyRate
     * @return
     */
    public static double calTermlyRate(PaymentFreq paymentFreq,
                                       double rateYearly, int frequenceRange, double daylyRate) {
        switch (paymentFreq) {
            case MONTH:
                return SystemUtils.amtDiv(SystemUtils.amtMult(rateYearly,
                        frequenceRange), 12);
            case QUATER:
                return SystemUtils.amtDiv(SystemUtils.amtMult(rateYearly,
                        frequenceRange), 4);
            case YEAR:
                return SystemUtils.amtDiv(SystemUtils.amtMult(rateYearly,
                        frequenceRange), 1);
            case HALFYEAR:
                return SystemUtils.amtDiv(SystemUtils.amtMult(rateYearly,
                        frequenceRange), 2);
            case WEEK:
                return SystemUtils.amtMult((SystemUtils.amtMult(daylyRate, 7)),
                        frequenceRange);
        }
        return rateYearly;
    }

    /**
     * 计算阶段利率
     * @param rateYearly
     * @param frequenceRange
     * @return
     */
    public static double calTermlyRate(double rateYearly, int frequenceRange) {
        return SystemUtils.amtDiv(SystemUtils.amtMult(rateYearly,
                frequenceRange), 12);
    }


    /**
     * 计算执行利率
     *
     * @param baseRate
     * @param sprd
     * @param intAdjPct
     * @return
     */
    public static double calExecuteIntRate(double baseRate, double sprd,
                                           double intAdjPct) {
        return RateUtils.roundYearRate(DigitalUtils.amtMult((baseRate + sprd),
                (1 + intAdjPct)));
    }

    /**
     * 根据系统配置对年利率修约
     *
     * @param rate
     * @return
     */
    public static double roundYearRate(double rate) {
        double newRate = RoundingUtil.getDoubleByLoanRoundMode(rate,
                MinosConst.DEFAULT_INTEREST_DIGTIAL_COUNT);
        if (SystemUtils.isRateGrateEqual(newRate, 0.0)) {
            return newRate;
        }
        return 0.0;
    }


    /**
     * 计算日利率
     * @param loanCcy
     * @param isCaculateAccordingActualDay
     * @param loanRateBase
     * @param rateYearly
     * @return
     */
    public static double calDaylyRate(String loanCcy,
                                      boolean isCaculateAccordingActualDay, LoanRateBase loanRateBase,
                                      double rateYearly) {
        int dayCount = 360;
        if ( rateYearly <= 0.0) {
            throw new RuntimeException("not found enum");
        }
        switch (loanRateBase) {
            case M:
                return BigDecimal.valueOf(rateYearly * 12 / 360).doubleValue();
            case D:
                return rateYearly;
            case Y:
                return BigDecimal.valueOf((rateYearly / 360)).doubleValue();
        }
        return rateYearly;
    }
}
