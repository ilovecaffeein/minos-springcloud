package com.caxs.minos.utils;

import com.caxs.minos.def.MinosConst;

/**
 * @ClassName: RateUtils
 * @Description: 利率工具
 * @Author: cpffee
 * @Date: 2020/8/4 16:23
 * @Version: v1.0 文件初始创建
 */
public class RateUtils {
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
}
