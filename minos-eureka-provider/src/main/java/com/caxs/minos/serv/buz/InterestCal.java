package com.caxs.minos.serv.buz;

import com.caxs.minos.exception.MinosException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.math.BigDecimal;
/**
 * @ClassName: InterestCal
 * @Description: 按日期来计算一个阶段利率
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class InterestCal {
    // 打印日志属性
    private Log log = LogFactory.getLog(getClass());

    //计算期数利率,返回数据未修约
    public static double computeInterest(BigDecimal rate, BigDecimal moneyMutiDayCount) {
        BigDecimal result = moneyMutiDayCount.multiply(rate);
        return  result.setScale(0, BigDecimal.ROUND_CEILING).doubleValue();
    }

    //计算期数利率,返回数据未修约
    public static BigDecimal computeInterest(BigDecimal rate, BigDecimal moneyMutiDayCount, int calendarRateUnitCount) {
        BigDecimal result = moneyMutiDayCount.multiply(rate);
        result = result.multiply(BigDecimal.valueOf(calendarRateUnitCount));
        return  result.setScale(0, BigDecimal.ROUND_CEILING);
    }

    /*
     * 计算期数利率,返回数据未修约
    * (non-Javadoc)
    *
    */
    public static double decimalAmtForInterestCal(BigDecimal calendarRate,
                                      BigDecimal money, int calendarRateUnitCount, int reservedDigitalCount) {
        if (calendarRateUnitCount < 0) {
            throw new MinosException("计算利息的天数：" + calendarRateUnitCount
                    + "不能小于0");
        }
        BigDecimal result = money.multiply(calendarRate).multiply(
                new BigDecimal(calendarRateUnitCount));
        return result.setScale(reservedDigitalCount,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
