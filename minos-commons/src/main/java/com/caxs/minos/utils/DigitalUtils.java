package com.caxs.minos.utils;

import java.math.BigDecimal;

/**
 * @ClassName: DigitalUtils
 * @Description:
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class DigitalUtils {
    /**
     * 两值相加
     * @param left1 算式左边第一个
     * @param left2 算式左边第二个
     * @return
     */
    public static double amtAdd(double left1, double left2) {
        BigDecimal left1Big = BigDecimal.valueOf(left1);
        return left1Big.add(BigDecimal.valueOf(left2)).doubleValue();
    }

    /**
     * 两值相减
     * @param left1 算式左边第一个
     * @param left2 算式左边第二个
     * @return
     */
    public static double subtract(double left1, double left2) {
        BigDecimal left1Big = BigDecimal.valueOf(left1);
        return left1Big.subtract(BigDecimal.valueOf(left2)).doubleValue();
    }

    // 两数相除
    public static double amtDiv(double left1, double left2, int digCount) {
        BigDecimal dec1 = getBigDecimal(left1, digCount + 1);

        BigDecimal dec2 = getBigDecimal(left2, digCount + 1);
        BigDecimal dec3 = dec1.divide(dec2, digCount,
                BigDecimal.ROUND_HALF_UP);
        return dec3.doubleValue();

    }

    // 两数相除
    public static BigDecimal amtBigDeciDiv(BigDecimal left1, BigDecimal left2, int digCount) {
        BigDecimal dec1 = new BigDecimal(0);
        BigDecimal dec2 = new BigDecimal(0);
        dec1.setScale(digCount + 1,BigDecimal.ROUND_HALF_UP);
        dec2.setScale(digCount + 1,BigDecimal.ROUND_HALF_UP);
        return dec1.divide(dec2, digCount,BigDecimal.ROUND_HALF_UP);
    }


    // 获取修约后的高精度值
    public static BigDecimal getBigDecimal(double amt, int reservedDigCount) {
        BigDecimal dec1 = BigDecimal.valueOf(amt);
        dec1 = dec1.setScale(reservedDigCount,
                BigDecimal.ROUND_HALF_UP);
        return dec1;
    }


    /**
     * 两个数相乘法。
     *
     * @param left1
     *            算式左边第一个
     * @param left2 算式左边第二个
     * @return
     */
    public static double amtMult(double left1, double left2) {
        BigDecimal left1Big = getBigDecimal(left1);
        BigDecimal left2Big = getBigDecimal(left2);
        return left1Big.multiply(left2Big).doubleValue();
    }


    // 获取高精度值，参数为双精度浮点型
    public static BigDecimal getBigDecimal(double amt) {
        BigDecimal dec1 = BigDecimal.valueOf(amt);
        dec1 = dec1.setScale(BigDecimal.ROUND_CEILING,
                BigDecimal.ROUND_HALF_UP);
        return dec1;
    }

    /**
     *
     * 计算用于计算积数计算的金额
     *
     * @param amt
     * @return
     */
    public static double getAmtForInterestCal(double amt) {
        BigDecimal dec1 = BigDecimal.valueOf(amt);
        dec1 = dec1.setScale(BigDecimal.ROUND_CEILING,
                BigDecimal.ROUND_HALF_UP);
        return dec1.doubleValue();
    }


}
