package com.caxs.minos.utils;

import java.math.BigDecimal;

/**
 * @ClassName: RoundingUtil
 * @Description: 数据修约处理
 * @Author: zhuruilong
 * @Date: 2020/7/28 14:39
 * @Version: v1.0 文件初始创建
 */
public class RoundingUtil {
    public static double roundingResult(BigDecimal value) {
        return value.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static BigDecimal roundingBigDecimal(BigDecimal value) {
        return value.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    // 获取修约后的高精度值
    public static BigDecimal getBigDecimal(double amt, int reservedDigCount) {
        BigDecimal dec1 = BigDecimal.valueOf(amt);
        dec1 = dec1.setScale(reservedDigCount,BigDecimal.ROUND_HALF_UP);
        return dec1;
    }

    /**
     * 根据修约模式修约
     *
     * @param amt
     * @param reservedDigCount
     * @return
     */
    public static double getDoubleByLoanRoundMode(double amt,int reservedDigCount) {
        BigDecimal dec1 = BigDecimal.valueOf(amt);
        dec1 = dec1.setScale(reservedDigCount, BigDecimal.ROUND_HALF_UP);
        return dec1.doubleValue();
    }

}
