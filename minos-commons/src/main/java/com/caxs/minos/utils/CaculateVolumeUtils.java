package com.caxs.minos.utils;

import java.util.Calendar;
import java.util.Date;
/**
 * @ClassName: CaculateVolumeUtils
 * @Description:
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class CaculateVolumeUtils {
    /**
     * 取两个时间的月数
     *
     * @param yyMMdd1
     * @return
     */
    public static int countMonth(String yyMMdd1, String yyMMdd2) {

        int rv = 0;

        Date dt1 = DateOperation.parseStringToDate(yyMMdd1);
        Date dt2 = DateOperation.parseStringToDate(yyMMdd2);

        Calendar cl = Calendar.getInstance();
        cl.setTime(dt1);

        int yy1 = cl.get(Calendar.YEAR);
        int mm1 = cl.get(Calendar.MONTH) + 1;

        cl.setTime(dt2);

        int yy2 = cl.get(Calendar.YEAR);
        int mm2 = cl.get(Calendar.MONTH) + 1;

        if (yy1 > yy2)

            rv = (yy1 - yy2) * 12 + (mm1 - mm2);
        else
            rv = (yy2 - yy1) * 12 + (mm2 - mm1);
        return rv;
    }

    /**
     * 计算多于天数
     * @param staDate
     * @param endDate
     * @return
     */
    public static int countOuterDays(String staDate, String endDate) {
        Calendar intCalendar = Calendar.getInstance();
        intCalendar.setTime(DateOperation.parseStringToDate(staDate));
        Calendar rsCalendar = Calendar.getInstance();
        rsCalendar.setTime(DateOperation.parseStringToDate(endDate));

        int day1 = intCalendar.get(Calendar.DATE);
        int day2 = rsCalendar.get(Calendar.DATE);

        if (day2 >= day1)
            return day2 - day1;
        else {
            int month = rsCalendar.get(Calendar.MONTH);
            intCalendar.set(Calendar.MONTH, month);
            intCalendar.add(Calendar.MONTH, -1);

            String dateStr1 = DateOperation.getDateStringToDb(rsCalendar
                    .getTime());
            String dateStr2 = DateOperation.getDateStringToDb(intCalendar
                    .getTime());
            return DateOperation.comparingTwoDates(dateStr1, dateStr2);
        }
    }
}
