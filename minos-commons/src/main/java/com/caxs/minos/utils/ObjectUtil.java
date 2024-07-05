package com.caxs.minos.utils;


import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName: ObjectUtil
 * @Description: 对象操作工具类
 * @Author: zhuruilong
 * @Date: 2020/8/4 16:23
 * @Version: v1.0 文件初始创建
 */

public class ObjectUtil {

    /**
     * @Description: 判断Decimal对象值是否为null或者值为0
     * @param decimal 参数
     * @Date: 2020/8/4 16:24
     * @Author: zhuruilong
     * @Return boolean
     * @Throws
     */
    public static boolean decimalIsNotNullOrZero(BigDecimal decimal) {
        return decimal != null && decimal.doubleValue() != 0;
    }

    /**
     * @Description: 判断字符串不为null或空字符
     * @param str 待验证字符串
     * @Date: 2020/8/26 15:53
     * @Author: zhuruilong
     * @Return boolean
     * @Throws
     */
    public static boolean stringNotNullOrBlank(String str) {
        return str != null && !str.trim().isEmpty();
    }

    /**
     * @Description: 判断字符串为null或空字符串
     * @param str 待验证字符串
     * @Date: 2020/8/26 15:53
     * @Author: zhuruilong
     * @Return boolean
     * @Throws
     */
    public static boolean stringIsNullOrBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean objectIsNull(Object obj) {
        return obj == null;
    }

    /**
     * @Description: 判断list对象是否为空或者为null
      * @param list
     * @Date: 2020/10/12 16:08
     * @Author: zhuruilong
     * @Return boolean
     * @Throws
     */
    public static boolean listIsNullOrEmpty(List list) {
        return list == null || list.isEmpty();
    }
}

