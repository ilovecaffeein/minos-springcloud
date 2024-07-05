package com.caxs.minos.def;

import java.math.BigDecimal;
import java.util.Locale;

/**
 * @ClassName: MinosConst
 * @Description:
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public final class MinosConst {
    // 文件字符
    public static final String PKGTYP = "5";

    // 文件字符
    public static final String FILE_CHARGBK = "GBK";

    // 文件字符
    public static final String FILE_CHARUTF = "UTF";

    // 文件字符
    public static final String FILE_CHARUTF_8 = "UTF-8";
    /**
     * 文件的列分隔符
     */
    public static final String COLUMN_SEPERATOR = "|";
    /**
     * 按天宽限期
     */
    public static final int isOver90Day = 90;

    /**
     * 按天宽限期
     */
    public static final int GRACE_TYP_BY_DAY = 0;
    /**
     * 日终结束标志
     */
    public final static String RETURN_CODE = "000000";
    /**
     * 日终结束标志
     */
    public final static String ERROR00000 = "00000";
    /**
     * 日终结束标志
     */
    public final static String ERROR00 = "00";
    /**
     * 日终结束标志
     */
    public final static String ERROR9999 = "99999";

    /**
     * 日终结束标志
     */
    public final static String ERROR0001 = "00001";
    /**
     * 日终结束标志
     */
    public final static String ERROR03 = "03";

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
    public static int DEFAULT_AMT_COMPARE_DIGTIAL_COUNT = 9;

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
    public final static Double ZERO_DOUBLE = 0.0;
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

    public static final String PSBC="PSBC";

    public static final String JJCCB="JJCCB";

    /**
     * 0的浮点数
     */
    public final static BigDecimal ZERO_BIGDECIMAL = new BigDecimal(0.0);
}
