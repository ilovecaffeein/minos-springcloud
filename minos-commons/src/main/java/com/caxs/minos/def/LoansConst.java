package com.caxs.minos.def;

import java.util.Locale;
/**
 * @author hb
 *
 */
public final class LoansConst {
    /**
     * 日终结束标志
     */
    public final static long END_DAY_SEQ = 999L;
    /**
     * 日初结束标志
     */
    public final static long END_DAY_SEQ_BEGIN = 998L;
    /**
     * 默认利息保留位数。
     */
    public static int DEFAULT_INTEREST_DIGTIAL_COUNT = 12;

    //修约保留位数
    public static int CORE_GLTX_DIG_COUNT = 2;
    public final static String EMPTY_STRING="";
    /**
     * 利率保留位数
     */
    public static int DEFAULT_INT_RATE_DIGTIAL_COUNT = 12;

    //默认字符
    public static final Locale DEFAUTL_LOCALE = Locale.ENGLISH;
    /**
     * 利率比较值
     */
    public static double DEFAULT_RATE_COMPARE_VALUE = 1E-12;

    /**
     * 金额中间计算保留位数
     */
    public static int DEFAULT_AMT_COMPARE_DIGTIAL_COUNT = 18;

    /**
     * 浮点数比较值
     */
    public static double DEFAULT_FLOAT_COMPARE_VALUE = 1E-6;
    /**
     * 浮点数比较值
     */
    public static double DEFAULT_AMOUNT_COMPARE_VALUE = 1E-7;
    /**
     * 浮点数比较值
     */
    public static double DEFAULT_AMOUNT_ZERO_VALUE = 1E-4;

    /**
     * 0的浮点数
     */
    public final static Double ZERO_DOUBLE = Double.valueOf(0);
    /**
     * 0的小整数
     */
    public final static Short ZERO_SHORT = (short) 0;
    //0的整型数
    public final static Long ZERO_LONG =  0L;

    /**
     * 0的小整数
     */
    public final static int RATE_HALF_UP = 6;
    public static final String DEFAULT_LDGR_SEQ_NO="N";
}
