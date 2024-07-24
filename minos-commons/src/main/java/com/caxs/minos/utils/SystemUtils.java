package com.caxs.minos.utils;


import com.caxs.minos.def.MinosConst;
import com.caxs.minos.exception.Cfs2MinosException;
import com.caxs.minos.exception.MinosException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;
/***
 * @ClassName(类名) : SystemUtils
 * @Description(描述) : 数据比较
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public class SystemUtils {
    private static Log log = LogFactory.getLog(SystemUtils.class);

    /**
     * 年利率是否相等
     *
     * @param rate1
     * @param rate0
     * @return
     */
    public static boolean isDaylyRateEqual(double rate1, double rate0) {
        double result = Math.abs(rate1 - rate0);
        return getDoubleByLoanRoundMode(result,
                MinosConst.DEFAULT_INT_RATE_DIGTIAL_COUNT, BigDecimal.ROUND_HALF_UP) < MinosConst.DEFAULT_INT_RATE_DIGTIAL_COUNT;
    }

    /**
     * 根据修约模式修约
     *
     * @param amt
     * @param reservedDigCount
     * @return
     */
    public static double getDoubleByLoanRoundMode(double amt,
                                                  int reservedDigCount,int LoanRoundingMode) {
        BigDecimal dec1 = BigDecimal.valueOf(amt);
        dec1 = dec1.setScale(reservedDigCount, BigDecimal.ROUND_HALF_UP);
        return dec1.doubleValue();
    }


    /**
     * 四舍五入
     *
     * @param amt
     *            算式左边第一个
     * @return
     */
    public static double getDoubleWhenEvenUp(double amt) {
        BigDecimal dec1 = BigDecimal.valueOf(amt);
        dec1 = dec1.setScale(MinosConst.CORE_GLTX_DIG_COUNT,BigDecimal.ROUND_HALF_UP);
        return dec1.doubleValue();
    }

    /**
     * 四舍五入
     *
     * @param amt
     *            算式左边第一个
     * @return
     */
    public static BigDecimal getBigDecimalWhenEvenUp(BigDecimal amt) {
        return amt.setScale(MinosConst.CORE_GLTX_DIG_COUNT,BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 年利率是否>=
     *
     * @param rate1
     * @param rate0
     * @return
     */
    public static boolean isRateGrateEqual(double rate1, double rate0) {
        double result = rate1 - rate0;
        if (result >= -MinosConst.DEFAULT_INTEREST_DIGTIAL_COUNT) {
            return true;
        }
        return false;
    }


    /**
     * 第一个数是否大于第二个数
     *
     * @param amt1
     * @param amt0
     * @return
     */
    public static boolean isAmtGreat(double amt1, double amt0) {
        double result = DigitalUtils.subtract(amt1, amt0);
        if (result > MinosConst.DEFAULT_AMOUNT_ZERO_VALUE) {
            if(log.isDebugEnabled())
                log.debug("第一个数："+ amt1 + ", 第二个数：" + amt0);
            return true;
        }
        return false;
    }

    /**
     * 第一个数是否大于第二个数
     *
     * @param amt1
     * @param amt1
     * @return
     */
    public static boolean isAmtEqualZero(double amt1) {
        if (Math.abs(amt1) <= MinosConst.DEFAULT_AMOUNT_ZERO_VALUE) {
            return true;
        }
        return false;
    }

    // 两值是否相等
    public static boolean isAmtEqual(double amt1, double amt0) {
        double result = Math.abs(amtSubs(amt1, amt0));
        return getDouble(result, 2) < MinosConst.DEFAULT_AMOUNT_ZERO_VALUE;
    }

    // 转化为双精度浮点型
    public static double getDouble(double amt, int reservedDigCount) {
        BigDecimal dec1 = BigDecimal.valueOf(amt);
        dec1 = dec1.setScale(reservedDigCount,BigDecimal.ROUND_HALF_UP);
        return dec1.doubleValue();
    }

    /**
     * 两个数相减
     *
     * @param left1
     *            算式左边第一个
     * @param left2 算式左边第二个
     * @return
     */
    public static double amtSubs(double left1, double left2) {
        BigDecimal dec1 = getBigDecimal(left1,
                MinosConst.DEFAULT_AMT_COMPARE_DIGTIAL_COUNT + 1);
        BigDecimal dec2 = getBigDecimal(left2,
                MinosConst.DEFAULT_AMT_COMPARE_DIGTIAL_COUNT + 1);
        BigDecimal dec3 = dec1.subtract(dec2);
        return getBigDecimal(dec3.doubleValue(),2).doubleValue();
    }

    // 获取修约后的高精度值
    public static BigDecimal getBigDecimal(double amt, int reservedDigCount) {
        BigDecimal dec1 = BigDecimal.valueOf(amt);
        dec1 = dec1.setScale(reservedDigCount,BigDecimal.ROUND_HALF_UP);
        return dec1;
    }

    /**
     * 年利率是否相等
     *
     * @param rate1
     * @param rate0
     * @return
     */
    public static boolean isRateEqual(double rate1, double rate0) {
        double result = Math.abs(rate1 - rate0);
        return RoundingUtil.roundingResult(new BigDecimal(result)) < MinosConst.DEFAULT_INTEREST_DIGTIAL_COUNT;
    }




    /**
     * 年利率是否相等
     *
     * @param rate1
     * @param rate1
     * @return
     */
    public static boolean isRateEqualZero(double rate1) {
        return RoundingUtil.roundingResult(new BigDecimal(rate1)) < MinosConst.DEFAULT_INTEREST_DIGTIAL_COUNT;
    }


    /**
     * 第一个数是否大于等于第二个数
     *
     * @param amt1
     * @param amt0
     * @return
     */
    public static boolean isAmtGreatAndEqual(double amt1, double amt0) {
        double result =  DigitalUtils.subtract(amt1, amt0);
        if (result >= -MinosConst.DEFAULT_AMOUNT_ZERO_VALUE) {
            return true;
        }
        return false;
    }


    /**
     * 金额<0
     *
     * @param amt1
     * @return
     */
    public static boolean isAmtLessThanZero(double amt1) {
        return amt1 < -MinosConst.DEFAULT_AMOUNT_ZERO_VALUE;
    }

    /**
     * 一个金额是否<=0;
     *
     * @param amt1
     * @return
     */
    public static boolean isAmtLessThanOrEqualZero(double amt1) {
        if (amt1 <= MinosConst.DEFAULT_AMOUNT_ZERO_VALUE) {
            return true;
        }
        return false;
    }


    /**
     * 第一个数是否大于第二个数
     *
     * @param amt1
     * @param amt1
     * @return
     */
    public static boolean isAmtGreatThanZero(double amt1) {
        if (amt1 > MinosConst.DEFAULT_AMOUNT_ZERO_VALUE) {
            return true;
        }
        return false;
    }


    /**
     * 如果Double为空返回零
     *
     * @param input
     * @return
     */
    public static Double getZeroDoubleIfNull(Double input) {
        return input == null ? MinosConst.ZERO_DOUBLE : input;
    }
    /**
     * 如果Double为空返回零
     *
     * @param input
     * @return
     */
    public static Double getBigDecimalfNull(BigDecimal input) {
        return input == null ? MinosConst.ZERO_DOUBLE :  input.doubleValue();
    }

    /**
     * 如果Double为空返回零
     *
     * @param input
     * @return
     */
    public static BigDecimal getDoubleToBigDecimal(Double input) {
        return input == null ? new BigDecimal (MinosConst.ZERO_DOUBLE) : new BigDecimal(input);
    }

    /**
     * 如果Double为空返回零
     *
     * @param input
     * @return
     */
    public static BigDecimal getBigDecimalf(BigDecimal input) {
        return input == null || "".equals(input) ? new BigDecimal (MinosConst.ZERO_DOUBLE) : input;
    }

    /**
     * 拷贝数组，idClass可以为空
     *
     * @param srcList
     * @param destClass
     * @param idClass
     * @return
     */
    public static List<?> copyArrayes(List<?> srcList, Class<?> destClass,
                                      Class<?> idClass) {
        if (CollectionUtils.isEmpty(srcList) || ((destClass == null))) {
            return new ArrayList<Object>(0);
        }
        List<Object> resultList = new ArrayList<Object>(srcList.size());
        for (Object src : srcList) {
            Object dest = null;
            Object destId = null;
            try {
                dest = destClass.newInstance();
            } catch (InstantiationException e) {
                throw new MinosException("构造失败");
            } catch (IllegalAccessException e) {
                throw new MinosException("无效访问");
            }
            if (idClass != null) {
                try {
                    destId = idClass.newInstance();
                } catch (InstantiationException e) {
                    throw new MinosException("构造失败");
                } catch (IllegalAccessException e) {
                    throw new MinosException("无效访问");
                }
                SystemUtils.setPropertyValue(dest, "id", destId);
            }
            copyPropertiesIncIdFields(src, dest);
            resultList.add(dest);
        }
        return resultList;
    }

    // 设置属性值
    public static void setPropertyValue(Object obj, String fieldName,
                                        Object value) {
        try {
            BeanUtils.setProperty(obj, fieldName, value);
        } catch (IllegalAccessException e1) {
            throw new MinosException("无效访问方法", e1);
        } catch (InvocationTargetException e1) {
            throw new MinosException("不能调用目标对象", e1);
        }
    }

    /**
     * 拷贝数组，idClass可以为空
     *
     * @param srcList
     * @param destClass
     * @return
     */
    public static List<?> copyArrayes(List<?> srcList, Class<?> destClass) {
        if (CollectionUtils.isEmpty(srcList) || ((destClass == null))) {
            return new ArrayList<Object>(0);
        }
        List<Object> resultList = new ArrayList<Object>(srcList.size());
        for (Object src : srcList) {
            Object dest = null;
            try {
                dest = destClass.newInstance();
            } catch (InstantiationException e) {
                throw new MinosException("构造失败");
            } catch (IllegalAccessException e) {
                throw new MinosException("无效访问");
            }
            copyPropertiesIncIdFields(src, dest);
            resultList.add(dest);
            break;
        }
        return resultList;
    }


    /**
     * 复制属性，包括Id字段
     *
     * @param src
     * @param dest
     */
    @SuppressWarnings("unchecked")
    public static void copyPropertiesIncIdFields(Object src, Object dest) {

        if (src == null)
            return;
        copyProperties(src, dest);
        try {
            new PropertyDescriptor("id", dest.getClass());
            try {
                Object destIdValue = getIdPropertyValue(dest);
                if (destIdValue == null) {
                    throw new MinosException("you must set dest id object");
                }
                copyProperties(src, destIdValue);
            } catch (MinosException ye) {
                if (!(ye.getCause() instanceof IntrospectionException)) {
                    throw ye;
                }
            }
        } catch (IntrospectionException e1) {
        }
        try {
            try {
                new PropertyDescriptor("id", src.getClass());
                Object idValue = getIdPropertyValue(src);
                if (idValue != null) {
                    Object destIdValue = null;
                    try {
                        destIdValue = getIdPropertyValue(dest);
                        if (destIdValue == null) {
                            throw new MinosException(
                                    "you must set dest id object");
                        }
                        copyProperties(idValue, destIdValue);
                    } catch (MinosException ye) {
                        if ((ye.getCause() instanceof IntrospectionException)) {
                            SystemUtils.copyProperties(idValue, dest);
                            return;
                        } else {
                            throw ye;
                        }
                    }
                    // 读取原Id字段。
                    try {
                        Map<String, String> map = BeanUtils.describe(idValue);
                        Map<String, String> destMap = BeanUtils
                                .describe(destIdValue);
                        for (String key : map.keySet()) {
                            if (!destMap.keySet().contains(key)) {
                                Object value = SystemUtils.getPropertyValue(
                                        idValue, key);
                                SystemUtils.setPropertyValue(dest, key, value);
                            }
                        }
                    } catch (IllegalAccessException e) {
                        throw new MinosException(e);
                    } catch (InvocationTargetException e) {
                        throw new MinosException(e);
                    } catch (NoSuchMethodException e) {
                        throw new MinosException(e);
                    }
                }
            } catch (IntrospectionException e1) {
            }

        } catch (MinosException ye) {
            if (!(ye.getCause() instanceof IntrospectionException)) {
                throw ye;
            }
        }
        // 获取目标Id 字段，目标Id上可能包含原始非Id字段
        try {
            new PropertyDescriptor("id", src.getClass());
            Object idValue = getIdPropertyValue(dest);
            if (idValue != null) {
                // 读取原Id字段。
                try {
                    Map<String, String> map = BeanUtils.describe(idValue);
                    Map<String, String> srcMap = BeanUtils.describe(src);
                    for (String key : map.keySet()) {
                        if (srcMap.keySet().contains(key)) {
                            Object value = SystemUtils.getPropertyValue(src,
                                    key);
                            SystemUtils.setPropertyValue(idValue, key, value);
                        }
                    }
                } catch (IllegalAccessException e) {
                    throw new MinosException(e);
                } catch (InvocationTargetException e) {
                    throw new MinosException(e);
                } catch (NoSuchMethodException e) {
                    throw new MinosException(e);
                }
            }
        } catch (IntrospectionException e1) {
        }

    }


    // 获取属性值
    public static Object getPropertyValue(Object obj, String fieldName) {

        try {
            return BeanUtils.getProperty(obj, fieldName);
        } catch (IllegalAccessException e1) {
            throw new MinosException("无效访问方法", e1);
        } catch (InvocationTargetException e1) {
            throw new MinosException("不能调用目标对象", e1);
        } catch (NoSuchMethodException e1) {
            throw new MinosException("无此方法:" + fieldName, e1);
        }
    }

    /**
     * 返回域对象的Id值
     *
     * @param domain
     * @return
     */
    public static Object getIdPropertyValue(Object domain) {
        if (domain == null) {
            return null;
        }
        try {
            PropertyDescriptor pd = new PropertyDescriptor("id", domain
                    .getClass());
            return pd.getReadMethod().invoke(domain);
        } catch (IntrospectionException e1) {
            throw new MinosException(e1);
        } catch (IllegalArgumentException e) {
            throw new MinosException(e);
        } catch (IllegalAccessException e) {
            throw new MinosException(e);
        } catch (InvocationTargetException e) {
            throw new MinosException(e);
        }

    }

    /**
     *拷贝属性
     *
     * @param src
     * @param dest
     */
    public static void copyProperties(Object src, Object dest) {
        String key = null;
        try {
            Map<String, String> map = BeanUtils.describe(src);
            for (Iterator it = map.keySet().iterator(); it.hasNext();) {
                key = (String) it.next();
                Object value = map.get(key);
                if (!("id".equals(key) || "class".equals(key))) {
                    if (value == null) {
                        PropertyDescriptor pd;
                        try {
                            pd = new PropertyDescriptor(key, dest.getClass());
                            if (!pd.getWriteMethod().getParameterTypes()[0]
                                    .isPrimitive()) {
                                pd.getWriteMethod().invoke(dest,
                                        new Object[] { null });
                            } else {
                            }
                        } catch (IntrospectionException e) {
                        }
                    } else {
                        BeanUtils.copyProperty(dest, key, value);
                    }
                }
            }
        } catch (IllegalAccessException e1) {
            throw new MinosException("无效访问方法,字段名称:" + key == null ? "" : key,
                    e1);
        } catch (InvocationTargetException e1) {
            throw new MinosException("不能调用目标对象,字段名称:" + key == null ? ""
                    : key, e1);
        } catch (NoSuchMethodException e1) {
            throw new MinosException("无此方法,字段名称:" + key == null ? "" : key,
                    e1);
        } catch (IllegalArgumentException iae) {
            throw new MinosException("无效参数，可能源字段为空!字段名称:" + key == null ? ""
                    : key, iae);
        }
    }

    /**
     * 获取本机网卡IP地址
     * @author coffee
     */
    public static String  getAddress(String inetHostName) {
        log.info("%%%%%%%获取机器IP开始.........");
        StringBuilder IFCONFIG=new StringBuilder();
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                if (intf.isLoopback() || intf.isVirtual() || !intf.isUp()) {
                    continue;
                }
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && inetAddress.isSiteLocalAddress()) {
                        log.info("配置文件中网卡名："+inetHostName+",本机网卡名:" + intf.getName()+",本机 网卡IP地址：" + inetAddress.getHostAddress().toString());
                        if(inetHostName.equals(intf.getName())){
                            IFCONFIG.append(inetAddress.getHostAddress().toString());
                            break;
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            log.info("获取本机网卡IP异常.........");
        }
        log.info("获取机器IP地址:" + IFCONFIG.toString());
        log.info("%%%%%%%获取机器IP结束.........");
        return IFCONFIG.toString();
    }

    /**
     * 两值相加,double类型
     * @param left1 算式左边第一个
     * @param left2 算式左边第二个
     * @return
     */
    public static double amtAdd(double left1, double left2) {
        BigDecimal left1Big = BigDecimal.valueOf(left1);
        return left1Big.add(BigDecimal.valueOf(left2)).doubleValue();
    }

    /**
     * 两值相加,BigDecimal类型
     * @param left1 算式左边第一个
     * @param left2 算式左边第二个
     * @return
     */
    public static BigDecimal amtAdd(BigDecimal left1, BigDecimal left2) {
        BigDecimal left1Big = left1;
        return left1Big.add(left2);
    }


    /**
     * 两个数相乘法。
     *
     * @param left1 算式左边第一个
     * @param left2 算式左边第二个
     * @return
     */
    public static BigDecimal amtMult(BigDecimal left1, BigDecimal left2) {
        return left1.multiply(left2);
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
        dec1 = dec1.setScale(MinosConst.DEFAULT_AMT_COMPARE_DIGTIAL_COUNT, 2);
        return dec1;
    }


    // 两金额值相除
    public static double amtDiv(double left1, double left2) {
        return div(left1, left2, MinosConst.DEFAULT_AMT_COMPARE_DIGTIAL_COUNT);
    }

    // 两数相除
    private static double div(double left1, double left2, int digCount) {
        BigDecimal dec1 = getBigDecimal(left1, digCount + 1);

        BigDecimal dec2 = getBigDecimal(left2, digCount + 1);
        BigDecimal dec3 = dec1.divide(dec2, digCount, 2);
        return dec3.doubleValue();

    }

    /**
     * 返回金额
     */
    public static double getBigToAmt(BigDecimal str) throws Cfs2MinosException {
        try {
            return SystemUtils
                    .getDoubleWhenEvenUp(str.doubleValue());

        } catch (Exception e) {
            throw new Cfs2MinosException(Cfs2MinosException.ERROR99999,
                    "将String 类型的值[" + str + "]转换成double失败，请检查程序"
                            + e.getMessage());
        }
    }

    /**
     * 返回金额
     */
    public static double getObjToAmt(Object str) throws Cfs2MinosException {
        try {
            return SystemUtils
                    .getDoubleWhenEvenUp(Double.valueOf((String) str));

        } catch (Exception e) {
            throw new Cfs2MinosException(Cfs2MinosException.ERROR99999,
                    "将String 类型的值[" + str + "]转换成double失败，请检查程序"
                            + e.getMessage());
        }
    }

    /** 返回利率 */
    public static double getObToRate(Object rate) throws Cfs2MinosException {
        return SystemUtils.getBigDecimal(Double.valueOf(String.valueOf(rate)),
                MinosConst.DEFAULT_INT_RATE_DIGTIAL_COUNT + 1).doubleValue();
    }
}
