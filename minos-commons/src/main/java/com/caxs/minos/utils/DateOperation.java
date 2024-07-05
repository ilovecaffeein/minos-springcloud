package com.caxs.minos.utils;

import com.caxs.minos.def.LoanVarDef;
import com.caxs.minos.def.MinosConst;
import com.caxs.minos.enums.PaymentFreqEnum;
import com.caxs.minos.exception.MinosException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @ClassName: DateOperation
 * @Description:
 * @Author: zhuruilong
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class DateOperation {

    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";
    private static final long MILLIS_OF_ONE_DAY = 24 * 60 * 60 * 1000;

    /**
     * @Description: yyyy-MM-dd类型字符串类型转换成Date类型
     * @param dateString
     * @Date: 2020/7/29 16:50
     * @Author: zhuruilong
     * @Return java.util.Date
     * @Throws
     */
    public static Date parseStringToDate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat(LoanVarDef.DATE_FORMAT);
        try {
            return format.parse(dateString);
        } catch (ParseException e) {
            // TODO log exception
        }
        return new Date();
    }

    public static int calculateDurationOfTwoDate(Date startDate, Date endDate) {
        long startTimestamp = startDate.getTime();
        long endTimestamp = endDate.getTime();
        long dayInterval = (endTimestamp - startTimestamp) / MILLIS_OF_ONE_DAY;
        return (int)dayInterval;

    }

    public static int calculateDurationOfTwoDateString(String startDateStr, String endDateStr) {
        Date startDate = parseStringToDate(startDateStr);
        Date endDate = parseStringToDate(endDateStr);
        long startTimestamp = startDate.getTime();
        long endTimestamp = endDate.getTime();
        long dayInterval = (endTimestamp - startTimestamp) / MILLIS_OF_ONE_DAY;
        return (int)dayInterval;

    }

    /**
     * 返回当前时间
     *
     * @return
     */
    public static String getNowTimeString() {
        return formatTime(new Date());
    }

    /**
     * 返回当期日期的字符串
     *
     * @return
     */
    public static String getNowDateString() {
        return getDateStringToDb(new Date());
    }

    /**
     * @Description: 格式化日期为yyyy-MM-dd格式
     * @param date
     * @Date: 2020/8/5 11:15
     * @Author: zhuruilong
     * @Return java.lang.Object
     * @Throws
     */
    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(LoanVarDef.DATE_FORMAT);
        return format.format(date);
    }

    /**
     * @Description: 格式化时间为hh：mm:ss格式
     * @param date
     * @Date: 2020/8/20 11:15
     * @Author: fengdetian
     * @Return java.lang.String
     * @Throws
     */
    public static String formatTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat(LoanVarDef.TIME_FORMAT);
        return format.format(date);
    }

    /**
     * @Description: 返回输入日期月的最后一天
     * @Date: 2020/8/5 11:15
     * @param inputDate
     * @return
     */
    public static Date getLastDayInMonth(Date inputDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(inputDate);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    /**
     * 计算两个日期相差天数
     *
     * @param endDate
     *            ,被减数
     * @param startDate
     *            ， 减数 计算两个日期之间的相隔天数
     */
    public static long DateCal(String endDate, String startDate) {
        long days = 0;
        try {
            Date dt1 = FORMAT_YCLOANS().parse(endDate);
            Date dt2 = FORMAT_YCLOANS().parse(startDate);
            days = (dt1.getTime() - dt2.getTime()) / 60 / 60 / 1000 / 24;
        } catch (Exception e) {

        }
        return days;
    }

    // 日期型转化
    public static SimpleDateFormat FORMAT_YCLOANS() {
        // edited by renee,日期格式可配置
        String dateFormat = dateFormat = DATE_FORMAT_PATTERN;
        return new SimpleDateFormat(DATE_FORMAT_PATTERN, MinosConst.DEFAUTL_LOCALE);
    }

    /**
     * 将日期格式转换为String类型，并填充
     *
     * @param date
     * @return 将日期格式转换为String类型，并填充。例如：2009-5-5 ---> 2009-05-05
     */
    public static String getDateStringToDb(Date date) {
        return FORMAT_YCLOANS().format(date);
    }

    /**
     * 计算两个日期大小
     *
     * @param startDate
     *            ,被减数
     * @param endDate
     *            ， 减数 计算两个日期之间的相隔天数
     */
    public  static boolean compareTo(String startDate, String endDate) {
        try {
            Date dt1 = FORMAT_YCLOANS().parse(startDate);
            Date dt2 = FORMAT_YCLOANS().parse(endDate);
            if (dt1.getTime() > dt2.getTime()) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            throw new MinosException("get failed", e);
        }
    }

    /**
     * 是否同月年
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isYearAndMonthSame(String date1, String date2) {
        if (getMonth(date1) != getMonth(date2)) {
            return false;
        }
        if (getYear(date1) != getYear(date2)) {
            return false;
        }
        return true;
    }

    /**
     * 获取年部分
     *
     * @param date
     * @return
     */
    public static int getYear(String date) {
        Date d = parseStringToDate(date);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.YEAR);
    }

    /**
     * 获取月部分
     *
     * @param date
     * @return
     */
    public static int getMonth(String date) {
        Date d = parseStringToDate(date);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.MONTH) + 1;
    }


    /**
     * 返回。输入日期+dayCount 输入负数，就是减少天数
     *
     * @param inputDate
     * @return
     */
    public static String getDateIncDayCount(String inputDate, int dayCount) {
        Date d = DateOperation.parseStringToDate(inputDate);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DAY_OF_YEAR, dayCount);
        return DateOperation.formatDate(c.getTime());
    }

    /**
     * 获取日部分
     *
     * @param date
     * @return
     */
    public static int getDay(String date) {
        Date d = DateOperation.parseStringToDate(date);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.DAY_OF_MONTH);

    }

    /**
     * 获取下月月某一天
     *
     * @param dueDay
     * @return
     */
    public static String getNextMonthDay(int dueDay) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, dueDay);
        c.add(Calendar.MONTH, 1);
        return FORMAT_YCLOANS().format(c.getTime());
    }

    public static String getDateStringToDb() {
        return FORMAT_YCLOANS().format(new Date());
    }


    /**
     * 返回加过天数后的日期字符串
     *
     * @param standardDate
     * @param addDayNumber
     * @return
     */
    public static String dateStringAddDay(String standardDate, int addDayNumber) {
        Date beginDate = DateOperation.parseStringToDate(standardDate);
        Calendar intCalendar = Calendar.getInstance();
        intCalendar.setTime(beginDate);
        intCalendar.add(Calendar.DATE, addDayNumber);
        return DateOperation.getDateStringToDb(intCalendar.getTime());
    }


    /**
     *
     * 生成FirstPayDate，例如。年频率,dueDay=21，现在是2009-8-1，那么返回日期=2009-12-21
     *
     * @param startDate
     * @param dueDay
     * @param freq
     * @param freqUnit
     * @param isFirstPerdOverOnePaymentFreq
     *            如果首期超过一期，那么合并为一期 返回日期之前的任何一个日期。
     * @return
     */
    public static Date getFirstPayDateByPaymentFreq(String startDate,
                                                    int dueDay, PaymentFreqEnum freq, int freqUnit,
                                                    boolean isFirstPerdOverOnePaymentFreq) {
        if (freq == null) {
            return null;
        }
        if (PaymentFreqEnum.NULL == freq) {
            throw new MinosException("不支持无频率取首次付款日");
        }
        Date startDt = DateOperation.parseStringToDate(startDate);
        Calendar c = Calendar.getInstance();
        c.setTime(startDt);
        int thisYear = c.get(Calendar.YEAR);
        Date compareDate;
        switch (freq) {
            case YEAR:
                compareDate = getDueDay(thisYear, 12, dueDay);
                break;
            case QUATER:
                int month = DateOperation.getQuaterMonth(c.getTime());
                compareDate = getDueDay(thisYear, month, dueDay);
                break;
            case HALFYEAR:
                int month1 = DateOperation.getHalfYearMonth(c.getTime());
                compareDate = getDueDay(thisYear, month1, dueDay);
                break;
            case MONTH:
                compareDate = DateOperation.getDateByDayCount(startDt, dueDay);
                break;
            case WEEK:
                Date dayByPaymentFreq = startDt;
                return getDayByPaymentFreq(dayByPaymentFreq, freq, freqUnit, dueDay);
            default:
                return null;
        }
        if (startDt.equals(compareDate)) {
            startDate = DateOperation.getDateIncDayCount(startDate, 1);
            return getFirstPayDateByPaymentFreq(startDate, dueDay, freq,
                    freqUnit, false);
        }

        if (startDt.before(compareDate)) {
            if (isFirstPerdOverOnePaymentFreq) {
                switch (freq) {
                    case MONTH: {
                        if (DateOperation.getMonth(compareDate) != DateOperation
                                .getMonth(startDate)) {
                            if (freqUnit > 1) {
                                compareDate = getDayByPaymentFreq(compareDate,
                                        freq, freqUnit - 1, dueDay);
                            }
                            return compareDate;
                        }
                        break;
                    }
                    default:
                        return compareDate;
                }
                compareDate = getDayByPaymentFreq(compareDate, freq, freqUnit,
                        dueDay);
            } else {
                if (freqUnit > 1) {
                    compareDate = getDayByPaymentFreq(compareDate, freq,
                            freqUnit - 1, dueDay);
                }
            }

            return compareDate;
        } else {
            if (isFirstPerdOverOnePaymentFreq) {
                compareDate = getDayByPaymentFreq(compareDate, freq, freqUnit,
                        dueDay);
                return compareDate;
            }
        }
        startDt = compareDate;

        Date result = getDayByPaymentFreq(startDt, freq, freqUnit, dueDay);
        return DateOperation.getDateByDayCount(result, dueDay);
    }


    // 获取扣款日的日期型格式
    public static Date getDueDay(int year, int month, int dueDay) {
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(Calendar.YEAR, year);
        month--;
        c.set(Calendar.MONTH, month);
        if (dueDay > 28) {
            c.set(Calendar.DAY_OF_MONTH, 1);
            int m = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            if (dueDay >= m) {
                dueDay = m;
            }
        }
        c.set(Calendar.DAY_OF_MONTH, dueDay);
        return c.getTime();
    }

    // 获取季所属末月
    public static int getQuaterMonth(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int thisMonth = c.get(Calendar.MONTH);
        if (thisMonth < 3) {
            return 3;
        }
        if ((thisMonth > 3) && (thisMonth < 6)) {
            return 6;
        }
        if ((thisMonth > 6) && (thisMonth < 9)) {
            return 9;
        }
        if ((thisMonth > 9) && (thisMonth < 12)) {
            return 12;
        }
        return thisMonth;
    }


    // 获取半年所属末月
    public static int getHalfYearMonth(Date date) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int thisMonth = c.get(Calendar.MONTH);
        if (thisMonth < 6) {
            return 6;
        }
        if ((thisMonth > 6) && (thisMonth < 12)) {
            return 12;
        }
        return thisMonth;
    }

    /**
     * 指定一月的某一天，返回当天日。
     *
     * @param input
     * @param dayCount
     * @return 日期型
     */
    public static Date getDateByDayCount(Date input, int dayCount) {
        Calendar c = Calendar.getInstance();
        c.setTime(input);
        int maxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        dayCount = dayCount > maxDay ? maxDay : dayCount;
        c.set(Calendar.DAY_OF_MONTH, dayCount);
        return c.getTime();
    }

    /**
     * 获取还款日期频率
     *
     * @param startDate
     * @param freq
     * @param freqUnit
     *            可以小于0，就是倒着走。
     * @return
     */
    public static Date getDayByPaymentFreq(Date startDate, PaymentFreqEnum freq,
                                           int freqUnit, int dueDay) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        switch (freq) {
            case MONTH: {
                cal.add(Calendar.MONTH, freqUnit);
                return adjustByDueDay(cal.getTime(), dueDay);
            }
            case QUATER: {
                int startMonth = cal.get(Calendar.MONTH) + 1;
                int monthNum = (3 - startMonth % 3) + (freqUnit - 1) * 3;
                cal.add(Calendar.MONTH, monthNum);
                return adjustByDueDay(cal.getTime(), dueDay);

            }
            case HALFYEAR: {
                int startMonth = cal.get(Calendar.MONTH) + 1;
                int monthNum = (6 - startMonth % 6) + (freqUnit - 1) * 6;
                cal.add(Calendar.MONTH, monthNum);
                return adjustByDueDay(cal.getTime(), dueDay);

            }
            case WEEK: {
                cal.add(Calendar.DATE, freqUnit * 7);
                return cal.getTime();
            }
            case YEAR: {
                cal.add(Calendar.YEAR, freqUnit);
                return adjustByDueDay(cal.getTime(), dueDay);
            }
        }
        throw new MinosException("没有找到的日期频率");
    }

    /**
     * 如果起息日是31,但是到了2月却只有28天，加频率加出来就有问题。
     *
     * @param result
     * @param dueDay
     * @return
     */
    public static Date adjustByDueDay(Date result, int dueDay) {
        Calendar newResult = Calendar.getInstance();
        newResult.setTime(result);
        return adjustByDueDay(newResult, dueDay).getTime();
    }

    /**
     * 如果起息日是31,但是到了2月却只有28天，加频率加出来就有问题。
     *
     * @param result
     * @param dueDay
     * @return
     */
    public static Calendar adjustByDueDay(Calendar result, int dueDay) {
        if (dueDay > 28) {
            int curDueDay = result.get(Calendar.DAY_OF_MONTH);
            if (curDueDay != dueDay) {
                int max = result.getActualMaximum(Calendar.DAY_OF_MONTH);
                curDueDay = dueDay;
                if (max < dueDay) {
                    curDueDay = max;
                }
                result.set(Calendar.DAY_OF_MONTH, curDueDay);
            }
        }
        return result;
    }

    /**
     * 获取月部分
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }

    /**
     * 指定一月的某一天，返回当天日。
     *
     * @param input
     * @param dayCount
     * @return 日期型
     */
    public static Date getDateByDayCount(String input, int dayCount) {
        return getDateByDayCount(DateOperation.parseStringToDate(input),
                dayCount);
    }

    /**
     * 加天数
     * */
    public static String addDays(String date, int days) {
        Calendar c = getCalendarObject(date);
        c.add(Calendar.DATE, days);
        return FORMAT_YCLOANS().format(c.getTime());
    }

    /**
     * 获取当前日期的Calendar对象
     *
     * @param date
     * @return
     */
    public static Calendar getCalendarObject(String date) {
        Calendar c = Calendar.getInstance();
        Date dt = DateOperation.parseStringToDate(date);
        c.setTime(dt);

        return c;
    }

    /**
     * 比较两个值的大小，0为被减数与减数相等，-1为被减数小于减数，1被减数大于减数
     *
     * @param date1
     *            ,被减数
     * @param date2
     *            ， 减数 比较两个日期的大小
     */
    public static int comparingTwoDates(String date1, String date2) {
        // edited by renee,统一格式修改

        long days = 0;
        int result = 0;
        try {
            Date dt1 = FORMAT_YCLOANS().parse(date1);
            Date dt2 = FORMAT_YCLOANS().parse(date2);
            days = (dt1.getTime() - dt2.getTime()) / 60 / 60 / 1000 / 24;
        } catch (Exception e) {
            throw new MinosException("get failed", e);
        }
        if (days == 0) {
            result = 0;
        } else if (days < 0) {
            result = -1;
        } else if (days > 0) {
            result = 1;
        }
        return result;
    }

    /**
     * 获取大于日期:dateBeforeResultDate的下次频率日 频率起始日是startFreqDate
     * 返回的日期同时也大于startFreqDate
     *
     * @param startFreqDate
     * @param freq
     * @param freqUnit
     * @param dateBeforeResultDate
     *            返回日期之前的任何一个日期。
     * @return
     */
    public static Date getNextDateByPaymentFreq(String startFreqDate,
                                                String dateBeforeResultDate, PaymentFreqEnum freq, int freqUnit,
                                                int dueDay) {
        Date startFreqDt = DateOperation.parseStringToDate(startFreqDate);
        Date before = parseStringToDate(dateBeforeResultDate);
        return getNextDateByPaymentFreq(startFreqDt, before, freq, freqUnit,
                dueDay);
    }

    /**
     * 获取大于日期:dateBeforeResultDate的下次频率日 频率起始日是startFreqDate
     * 返回的日期同时也大于startFreqDate
     *
     * @param startFreqDate
     * @param freq
     * @param freqUnit
     * @param dateBeforeResultDate
     *            返回日期之前的任何一个日期。
     * @return
     */
    public static Date getNextDateByPaymentFreq(Date startFreqDate,
                      Date dateBeforeResultDate, PaymentFreqEnum freq, int freqUnit,
                                                int dueDay) {
        Date nextDate;
        int i = 0;
        while (true) {
            nextDate = getDayByPaymentFreq(startFreqDate, freq, freqUnit
                    * (++i), dueDay);
            if (nextDate.after(dateBeforeResultDate)) {
                return nextDate;
            }
        }
    }

    /**
     * 取下一年的1月1日
     *
     * @param date
     * @return
     */
    public static String getNextYearBegin(String date) {

        Calendar cal = getCalendarObject(date);
        cal.add(Calendar.YEAR, 1);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DATE, 1);// 日，设为一号

        return FORMAT_YCLOANS().format(cal.getTime());
    }

    /**
     * 按季调整利率，取每季初的：4月1 ,7月1, 10月1, 1月1
     *
     * @param date
     * @return
     */
    public static String getRepcDate(String date) {

        Date toDate = DateOperation.parseStringToDate(date);
        Calendar c = Calendar.getInstance();
        c.setTime(toDate);

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);

        int newMonth = 0;
        if (month >= 1 && month <= 3)
            newMonth = 4;
        if (month >= 4 && month <= 6)
            newMonth = 7;
        if (month >= 7 && month <= 9)
            newMonth = 10;
        if (month >= 10 && month <= 12) {
            year = year + 1;
            newMonth = 1;
        }

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);// 年
        cal.set(Calendar.MONTH, newMonth - 1);// 月，因为Calendar里的月是从0开始，所以要减1
        cal.set(Calendar.DATE, 1);// 日，设为一号

        return FORMAT_YCLOANS().format(cal.getTime());
    }

    /**
     * 获取下月月初日期
     *
     * @param date
     * @return
     */
    public static String getNextMonthBegin(String date) {

        Calendar cal = getCalendarObject(date);

        int month = cal.get(Calendar.MONTH) + 1;
        if (month == 13) {
            cal.add(Calendar.YEAR, 1);
            cal.set(Calendar.MONTH, 1);
        } else
            cal.add(Calendar.MONTH, 1);// 月份加一，得到下个月的一号

        cal.set(Calendar.DATE, 1);// 日，设为一号

        return FORMAT_YCLOANS().format(cal.getTime());
    }


    /**
     * 判断当月是否为31天
     * @param strDate
     * @return
     */
    public static boolean JudgmentMonth(String  strDate) {
        boolean  flag  = false ;
        int day = getMonth(strDate);
        switch (day) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println( day + "月份有：31天");
                flag = true;
                break;
            case 2:
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println( day + "月份有：30天");
                flag = false;
                break;
            default:
                System.out.println("请输入正确的年份和月份");
                break;
        }
        return flag;
    }
}

