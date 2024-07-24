package com.caxs.minos.date;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.caxs.minos.def.LoanVarDef;
import com.caxs.minos.def.MinosConst;
import com.caxs.minos.enums.AmortFreqEnum;
import com.caxs.minos.exception.MinosException;
import com.yuchengtech.ycloans.common.enumeration.PaymentFreq;

/**
 * @author hb
 *
 */
public class DateOperation {
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
			throw new MinosException("get failed", e);
		}
		return days;
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
	 * 获取日期型数据的字符串形式
	 *
	 * @param date
	 * @return
	 */
	public static String getTimeString(Date date) {

		return FORMAT_YCLOANS_TIMES().format(date);
	}

	/**
	 * 获取月部分
	 *
	 * @param date
	 * @return
	 */
	public static int getMonth(String date) {
		Date d = DateOperation.getDateFromDbString(date);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c.get(Calendar.MONTH) + 1;
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
	 * 获取年部分
	 *
	 * @param date
	 * @return
	 */
	public static int getYear(String date) {
		Date d = DateOperation.getDateFromDbString(date);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c.get(Calendar.YEAR);
	}

	/**
	 * 获取年部分
	 *
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}

	/**
	 * 获取日部分
	 *
	 * @param date
	 * @return
	 */
	public static int getDay(String date) {
		Date d = DateOperation.getDateFromDbString(date);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c.get(Calendar.DAY_OF_MONTH);

	}

	/**
	 * 获取日部分
	 *
	 * @param date
	 * @return
	 */
	public static int getEndDayInMonth(String date) {
		Date d = DateOperation.getDateFromDbString(date);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);

	}

	/**
	 * 返回当前时间
	 *
	 * @return
	 */
	public static String getNowTimeString() {
		return getTimeString(new Date());
	}

	// 根据还款间隔计算日期
	public static Date getDayByPaymentFreq(String startDate, PaymentFreq freq,
										   int freqUnit, int dueDay) {
		return getDayByPaymentFreq(getDateFromDbString(startDate), freq,
				freqUnit, dueDay);
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
												String dateBeforeResultDate, PaymentFreq freq, int freqUnit,
												int dueDay) {
		Date startFreqDt = DateOperation.getDateFromDbString(startFreqDate);
		Date before = getDateFromDbString(dateBeforeResultDate);
		return getNextDateByPaymentFreq(startFreqDt, before, freq, freqUnit,
				dueDay);
	}

	/**
	 * 返回下个摊销频率日期
	 *
	 * @param nowDate
	 * @param af
	 * @return
	 */
	public static String getNextDateByAmortFreq(String nowDate, AmortFreqEnum af) {
		if (AmortFreqEnum.DAY.equals(af)) {
			return getDateIncDayCount(nowDate, 1);
		}
		if (AmortFreqEnum.MONTH_END.equals(af)) {
			return DateOperation.getDateStringToDb(getDayByPaymentFreq(nowDate,
					PaymentFreq.MONTH, 1, 31));
		}
		if (AmortFreqEnum.MONTH_START.equals(af)) {
			return DateOperation.getDateStringToDb(getDayByPaymentFreq(nowDate,
					PaymentFreq.MONTH, 1, 1));
		}
		if (AmortFreqEnum.QUART_END.equals(af)) {
			return DateOperation.getDateStringToDb(getDayByPaymentFreq(nowDate,
					PaymentFreq.QUATER, 1, 31));
		}
		if (AmortFreqEnum.YEAR_START.equals(af)) {

			return DateOperation.getNextYearBegin(nowDate);
		}
		if (AmortFreqEnum.YEAR_END.equals(af)) {

			Date d = DateOperation.getDateFromDbString(nowDate);
			Calendar c = Calendar.getInstance();
			c.setTime(d);

			c.add(Calendar.YEAR, 1);
			c.set(Calendar.MONTH, 11);
			c.set(Calendar.DATE, 31);

			return FORMAT_YCLOANS().format(c.getTime());
		}
		throw new MinosException("不支持的摊销频率:" + af);
	}

	/**
	 * 返回下个摊销频率日期
	 *
	 * @param nowDate
	 * @param af
	 * @return
	 */
	public static String getNowDateByAmortFreq(String nowDate, AmortFreqEnum af) {
		if (AmortFreqEnum.DAY.equals(af)) {
			return nowDate;
		}
		switch (af) {
			case MONTH_START:
				String nextDay = DateOperation.getDateStringToDb(DateOperation
						.getDateByDayCount(nowDate, 1));
				if (nextDay.equals(nowDate)) {
					return nextDay;
				} else {
					nextDay = DateOperation.getDateStringToDb(getDayByPaymentFreq(
							nowDate, PaymentFreq.MONTH, 1, 1));
					return DateOperation.getDateStringToDb(DateOperation
							.getDateByDayCount(nextDay, 1));
				}
			case MONTH_END:
				return DateOperation.getDateStringToDb(DateOperation
						.getDateByDayCount(nowDate, 31));
			case QUART_END:
			case QUART_START:
				int month = DateOperation.getMonth(nowDate);
				switch (month) {
					case 3:
					case 6:
					case 9:
					case 12:
						int day = DateOperation.getDay(nowDate);
						if (day == DateOperation.getEndDayInMonth(nowDate)) {
							return nowDate;
						}
				}
				return DateOperation.getDateStringToDb(DateOperation
						.getFirstPayDateByPaymentFreq(nowDate, 31,
								PaymentFreq.QUATER, 1, false));
		}
		if (AmortFreqEnum.YEAR_END.equals(af)) {
			return DateOperation.getDateStringToDb(DateOperation
					.getFirstPayDateByPaymentFreq(nowDate, 31,
							PaymentFreq.YEAR, 1, false));

		}
		throw new MinosException("不支持的摊销频率:" + af);
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

	/**
	 * 生成FirstPayDate，例如。年频率,dueDay=21，现在是2009-8-1，那么返回日期=2009-12-21
	 * @param startDate
	 * @param freq
	 * @param freqUnit
	 * @param lastPayDate
	 * @param isFirstPerdOverOnePaymentFreq
	 *            贷款的起息日
	 * @return
	 */
	public static Date getFirstPayDateByPaymentFreq(String startDate,
													int dueDay, PaymentFreq freq, int freqUnit, String lastPayDate,
													boolean isFirstPerdOverOnePaymentFreq) {
		if (freq == PaymentFreq.NULL) {
			return DateOperation.getDateFromDbString(lastPayDate);
		}
		return getFirstPayDateByPaymentFreq(startDate, dueDay, freq, freqUnit,
				isFirstPerdOverOnePaymentFreq);
	}

	/**
	 * 生成FirstPayDate，例如。年频率,dueDay=21，现在是2009-8-1，那么返回日期=2009-12-21
	 * @param startDate
	 * @param freq
	 * @param freqUnit
	 * @param isFirstPerdOverOnePaymentFreq
	 *            如果首期超过一期，那么合并为一期 返回日期之前的任何一个日期。
	 * @return
	 */
	public static Date getFirstPayDateByPaymentFreq(String startDate,
													int dueDay, PaymentFreq freq, int freqUnit,
													boolean isFirstPerdOverOnePaymentFreq) {
		if (freq == null) {
			return null;
		}
		if (PaymentFreq.NULL == freq) {
			throw new MinosException("不支持无频率取首次付款日");
		}
		Date startDt = DateOperation.getDateFromDbString(startDate);
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
				// if (startDate.equals(intStartDtOfLoan)) {
				// dayByPaymentFreq = getDayByPaymentFreq(startDate,
				// PaymentFreq.MONTH, 1);
				// }
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
	 * 检查checkedDate是不是频率日期
	 *
	 * @param freq
	 * @param freqUnit
	 * @param checkedDate
	 * @param startFreqDate
	 * @return
	 */
	public static boolean isFreqDate(String checkedDate, PaymentFreq freq,
									 int freqUnit, String startFreqDate, int dueDay) {
		Date startFreqDt = DateOperation.getDateFromDbString(startFreqDate);
		Date checkedDt = DateOperation.getDateFromDbString(checkedDate);
		return isFreqDate(checkedDt, freq, freqUnit, startFreqDt, dueDay);
	}

	// 检查是否是还款频率日期
	public static boolean isFreqDate(Date checkedDate, PaymentFreq freq,
									 int freqUnit, Date startFreqDate, int dueDay) {
		Date nextDate = startFreqDate;
		Date checkedDt = checkedDate;
		if (nextDate.equals(checkedDt)) {
			return true;
		}
		if (nextDate.after(checkedDt)) {
			freqUnit = -freqUnit;
		}
		boolean isContinue;
		while (true) {
			if (freqUnit > 0)
				isContinue = nextDate.before(checkedDt);
			else {
				isContinue = nextDate.after(checkedDt);
			}
			if (!isContinue) {
				break;
			}
			nextDate = getDayByPaymentFreq(nextDate, freq, freqUnit, dueDay);
			if (nextDate.equals(checkedDt)) {
				return true;
			}
		}
		return false;

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
												Date dateBeforeResultDate, PaymentFreq freq, int freqUnit,
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
	 * 获取还款日期频率
	 *
	 * @param startDate
	 * @param freq
	 * @param freqUnit
	 *            可以小于0，就是倒着走。
	 * @return
	 */
	public static Date getDayByPaymentFreq(Date startDate, PaymentFreq freq,
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
	 * 返回输入日期月的最后一天
	 *
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
	 * 返回输入日期月份有多少天。 例如2月可能有28
	 *
	 * @param inputDate
	 * @return
	 */
	public static int getDayCountInOneMounth(Date inputDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(inputDate);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 返回输入日期月份有多少天。 例如2月可能有28
	 *
	 * @param inputDate
	 * @return
	 */
	public static int getDayCountInOneMounth(String inputDate) {
		return getDayCountInOneMounth(DateOperation
				.getDateFromDbString(inputDate));
	}

	/**
	 * 返回。输入日期+dayCount 输入负数，就是减少天数
	 *
	 * @param inputDate
	 * @return
	 */
	public static String getDateIncDayCount(String inputDate, int dayCount) {
		Date d = DateOperation.getDateFromDbString(inputDate);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DAY_OF_YEAR, dayCount);
		return DateOperation.getDateStringToDb(c.getTime());
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
	 * 指定一月的某一天，返回当天日。
	 *
	 * @param input
	 * @param dayCount
	 * @return 日期型
	 */
	public static Date getDateByDayCount(String input, int dayCount) {
		return getDateByDayCount(DateOperation.getDateFromDbString(input),
				dayCount);
	}

	/**
	 * 判断是否为月末
	 *
	 * @param date
	 * @return 判断是否为月末
	 */
	public static boolean isEndMonth(String date) {
		Date toDate = DateOperation.getDateFromDbString(date);
		Calendar c = Calendar.getInstance();
		c.setTime(toDate);
		int monthEnd = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int trueMonthEnd = c.get(Calendar.DATE);
		return trueMonthEnd == monthEnd;
	}

	/**
	 * 判断是否为年末
	 *
	 * @param date
	 * @return 判断是否为年末 12-31号
	 */
	public static boolean isEndYear(String date) {
		Date toDate = DateOperation.getDateFromDbString(date);
		Calendar dealDate = Calendar.getInstance();
		dealDate.setTime(toDate);

		int monthNow = dealDate.get(Calendar.MONTH);
		int dateNow = dealDate.get(Calendar.DATE);

		if (monthNow == 11 && dateNow == 31) {
			return true;
		}
		return false;
	}

	/**
	 * 判断是否为季末
	 *
	 * @param date
	 * @return 判断是否为季末
	 */
	public static boolean isEndQuarter(String date) {
		Date toDate = DateOperation.getDateFromDbString(date);
		Calendar dealDate = Calendar.getInstance();
		dealDate.setTime(toDate);

		int month = dealDate.get(Calendar.MONTH);
		int day = dealDate.get(Calendar.DATE);

		int monthEnd = dealDate.getActualMaximum(Calendar.DAY_OF_MONTH);
		if (month % 3 == 0 && monthEnd == day) {
			return true;
		}
		return false;
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

	public static String getDateStringToDb() {
		return FORMAT_YCLOANS().format(new Date());
	}

	/**
	 * 把数据库的字符串转化成Date型
	 *
	 * @param dateString
	 *            字符串格式(yyyy-MM-dd)
	 * @return
	 */
	public static Date getDateFromDbString(String dateString) {
		try {
			return FORMAT_YCLOANS().parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("string format error!! ，错误日期数据："
					+ dateString);
		}
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
	 * 查询当前是否假日。 如果是，那么还要检查相邻几天是否假日。如果今天，明天都是假日，那么返回2，如果今天是假日，返回1
	 * @param currDate
	 * @return
	 */
	public static int findHolidayCount(Connection conn, String currDate) {
		int i = 0;
		return 0;
	}

	// 日期型转化
	public static SimpleDateFormat FORMAT_YCLOANS_TIMES() {
		// edited by renee,时间格式可配置
		String timeFormat = null;
		if (timeFormat == null)
			timeFormat = LoanVarDef.TIME_FORMAT;// 默认格式
		return new SimpleDateFormat(timeFormat, MinosConst.DEFAUTL_LOCALE);
	}

	// 日期型转化
	public static SimpleDateFormat FORMAT_YCLOANS() {
		// edited by renee,日期格式可配置
		String dateFormat = null;
		if (dateFormat == null)
			dateFormat = LoanVarDef.DATE_FORMAT;// 默认格式
		return new SimpleDateFormat(dateFormat, MinosConst.DEFAUTL_LOCALE);
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
	 * 判断date1和date2是否年和月相同,如果相同就返回date2，否则返回date1
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static java.sql.Date isEqualsYM(java.sql.Date date1,
										   java.sql.Date date2) {
		Calendar date1Temp = Calendar.getInstance();
		Calendar date2Temp = Calendar.getInstance();
		date1Temp.setTime(date1);
		date2Temp.setTime(date2);
		if ((date1Temp.get(Calendar.YEAR) == date2Temp.get(Calendar.YEAR))
				&& date1Temp.get(Calendar.MONTH) == date2Temp
				.get(Calendar.MONTH)) {
			date1 = date2;
		}
		return date1;
	}

	/**
	 * 阶段描述
	 *
	 * @author hb
	 *
	 */
	public static class TermDes {
		public int termCount = 0;
		public int accualDayCount = 0;
		public Date billDay;
		public java.sql.Date someDebitDay;
		public boolean termPlusDay = false;
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
	 * 是否月初
	 * @param date
	 * @return
	 */
	public static boolean isFirstMonth(String date) {
		Date dt = DateOperation.getDateFromDbString(date);
		Calendar c = Calendar.getInstance();
		c.setTime(dt);

		return c.get(Calendar.MONTH) == 0;
	}

	/**
	 * 获取月末日期
	 * @param date
	 * @return
	 */
	public static String getEndMonth(String date) {
		Date dt = DateOperation.getDateFromDbString(date);

		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.DATE, cal.get(Calendar.DAY_OF_MONTH));// 日，设为一号
		cal.add(Calendar.MONTH, 1);// 月份加一，得到下个月的一号
		cal.add(Calendar.DATE, -1);// 下一个月减一为本月最后一天

		return FORMAT_YCLOANS().format(cal.getTime());
	}

	/**
	 * 获取月初日期
	 * @param date
	 * @return
	 */
	public static String getBeginMonth(String date) {

		Calendar cal = getCalendarObject(date);
		cal.set(Calendar.DATE, 1);// 日，设为一号

		return FORMAT_YCLOANS().format(cal.getTime());
	}

	/**
	 * 获取当前日期的Calendar对象
	 * @param date
	 * @return
	 */
	public static Calendar getCalendarObject(String date) {

		Calendar c = Calendar.getInstance();
		Date dt = DateOperation.getDateFromDbString(date);
		c.setTime(dt);

		return c;
	}

	/**
	 * 获取上月月初日期
	 * @param date
	 * @return
	 */
	public static String getLastBeginMonth(String date) {

		Calendar cal = getCalendarObject(date);

		cal.add(Calendar.MONTH, -1);// 月份减一，得到上个月的一号
		cal.set(Calendar.DATE, 1);// 日，设为一号

		return FORMAT_YCLOANS().format(cal.getTime());
	}

	/**
	 * 获取下月月初日期
	 * @param date
	 * @return
	 */
	public static String getNextMonthEnd(String date) {

		Calendar cal = getCalendarObject(date);

		cal.add(Calendar.MONTH, 1);// 月份加一，得到下个月的一号
		cal.set(Calendar.DATE, 1);// 日，设为一号

		return FORMAT_YCLOANS().format(cal.getTime());
	}

	/**
	 * 获取下月月初日期
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
	 * 获取两个日期之间的月数
	 *
	 * @param frmDate
	 * @param endDate
	 * @return
	 */
	public static int getMonthCountBetweenDate(String frmDate, String endDate) {
		Calendar cStart = Calendar.getInstance();
		Calendar cEnd = Calendar.getInstance();
		cStart.setTime(DateOperation.getDateFromDbString(frmDate));
		cEnd.setTime(DateOperation.getDateFromDbString(endDate));
		int sYear = cStart.get(Calendar.YEAR);
		int eYear = cEnd.get(Calendar.YEAR);
		int sMonth = cStart.get(Calendar.MONTH);
		int eMonth = cEnd.get(Calendar.MONTH);
		int sDate = cStart.get(Calendar.DATE);
		int eDate = cEnd.get(Calendar.DATE);
		int addMonth = 0;
		if (eDate > sDate) {
			addMonth = 1;
		}
		return (eYear - sYear) * 12 + (eMonth - sMonth) + addMonth;
	}

	/**
	 * 当前业务日期+/-count年
	 * @param date
	 * @param count
	 * @return
	 */
	public static String getDateOfCountYear(String date, int count) {

		Calendar cal = getCalendarObject(date);

		cal.add(Calendar.YEAR, count);

		return FORMAT_YCLOANS().format(cal.getTime());
	}

	/**
	 * 当前业务日期+/-count月
	 * @param date
	 * @param count
	 * @return
	 */
	public static String getDateOfCountMonth(String date, int count) {

		Calendar cal = getCalendarObject(date);

		cal.add(Calendar.MONTH, count);

		return FORMAT_YCLOANS().format(cal.getTime());
	}

	/**
	 * 获取下月月末日期
	 *
	 * @param date
	 * @return
	 */
	public static String getNextMonthLast(String date) {

		Date dt = DateOperation.getDateFromDbString(date);
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.MONTH, 1);// 月份加1
		c.set(Calendar.DATE, c.get(Calendar.DAY_OF_MONTH));
		return FORMAT_YCLOANS().format(c.getTime());
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
	 * 取当年的1月1日
	 *
	 * @param date
	 * @return
	 */
	public static String getCurrentYearBegin(String date) {

		Calendar cal = getCalendarObject(date);
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

		Date toDate = DateOperation.getDateFromDbString(date);
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
	 * 取下个月的某天日期
	 *
	 * @param LastMonthDay
	 * @param dayCount
	 * @return
	 */
	public static String getNextMonthDate(String LastMonthDay, int dayCount) {
		String NextMonthDate = getNextMonthEnd(LastMonthDay);
		NextMonthDate = getDateStringToDb(getDateByDayCount(NextMonthDate,
				dayCount));
		return NextMonthDate;
	}

	/**
	 * 按季计息，取下一个季度的21日，如3月21,6月21,9月21,12月21，如果参数进来恰好是计息日，则往后取最近下一个季度的21日，如3月21日
	 * ， 就返回6月21日 add by liaozy 2014.2.12
	 *
	 * @param date
	 * @return
	 */
	public static String getQuaterDay21(String date) {

		Date dt = DateOperation.getDateFromDbString(date);
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = c.get(Calendar.DATE);

		int newMonth = 0;
		if (month == 12 && day >= 21) {
			year = year + 1;
		}
		// 1-3月 12月21-3.20取3.21
		if (month >= 1 && month <= 2) {
			newMonth = 3;
		}
		if (month == 3 && day < 21) {
			newMonth = 3;
		}
		if (month == 12 && day >= 21) {
			newMonth = 3;
		}
		if (month == 3 && day >= 21) {
			newMonth = 6;
		}
		// 4-6月 4.1-4.20取4.21
		if (month >= 4 && month <= 5) {
			newMonth = 6;
		}
		if (month == 6 && day < 21) {
			newMonth = 6;
		}
		if (month == 6 && day >= 21) {
			newMonth = 9;
		}
		// 7-9月 7.1-9.20取9.21
		if (month >= 7 && month <= 8) {
			newMonth = 9;
		}
		if (month == 9 && day < 21) {
			newMonth = 9;
		}
		if (month == 9 && day >= 21) {
			newMonth = 12;
		}
		// 10-12月 10.1-12.20返回12.21
		if (month >= 10 && month <= 11) {
			newMonth = 12;
		}
		if (month == 12 && day < 21) {
			newMonth = 12;
		}

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);// 年
		cal.set(Calendar.MONTH, newMonth - 1);// 月，因为Calendar里的月是从0开始，所以要减1
		cal.set(Calendar.DATE, 21);// 日，设为21号

		return FORMAT_YCLOANS().format(cal.getTime());
	}

	/**
	 * 获取每月21日
	 * @param date
	 * @return
	 */
	public static String getDay21(String date) {

		Calendar cal = getCalendarObject(date);
		cal.set(Calendar.DATE, 21);// 日，设为一号

		return FORMAT_YCLOANS().format(cal.getTime());
	}

	/**
	 * 获取上月21日
	 * @param date
	 * @return
	 */
	public static String getLastDay21(String date) {

		Calendar cal = getCalendarObject(date);

		cal.add(Calendar.MONTH, -1);// 月份减一，得到上个月的一号
		cal.set(Calendar.DATE, 21);// 日，设为一号

		return FORMAT_YCLOANS().format(cal.getTime());
	}

	/**
	 * 获取自然日,yyyy-MM-dd HH:mm:ss
	 * */
	public static String getNaturalDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(Calendar.getInstance().getTime());
	}

	/**
	 * 比较两个日期的是否同年同月
	 * */
	public static boolean isBothMonth(String d1, String d2) {
		Date dt1 = DateOperation.getDateFromDbString(d1);
		Date dt2 = DateOperation.getDateFromDbString(d2);

		Calendar c = Calendar.getInstance();
		c.setTime(dt1);
		int y1 = c.get(Calendar.YEAR);
		int m1 = c.get(Calendar.MONTH) + 1;
		c.setTime(dt2);
		int y2 = c.get(Calendar.YEAR);
		int m2 = c.get(Calendar.MONTH) + 1;

		if (y1 == y2) {
			if (m1 == m2) {
				return true;
			}
		}
		return false;
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
	 * 针对扣款日与放款日不一致的贷款,修约到期日的day
	 * */
	public static String repairLastDueDay(String intStartDay, String lastDueDay) {
		Calendar c1 = getCalendarObject(intStartDay);
		Calendar c2 = getCalendarObject(lastDueDay);
		if (c1.get(Calendar.DATE) != c2.get(Calendar.DATE)) {
			//起息扣款日
			int day = c1.get(Calendar.DAY_OF_MONTH);
			//月末
			int day2 = c2.getActualMaximum(Calendar.DAY_OF_MONTH);
			//如果到期日已在月末,那就是月末,如果不在月末那就按起息日的扣款日修约
			day = day > day2 ? day2 : day;
			c2.set(Calendar.DATE, day);
		}
		return FORMAT_YCLOANS().format(c2.getTime());
	}

	/** 传入年月日的值 */
	public static String getExpiryDt(int year, int month, int date) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DATE, date);
		return FORMAT_YCLOANS().format(c.getTime());

	}

	/**
	 * 判断当前月份是否包含该天
	 *
	 * @param date
	 */
	public static boolean hasThisDay(String date,int day) {
		Date toDate = DateOperation.getDateFromDbString(date);
		Calendar dealDate = Calendar.getInstance();
		dealDate.setTime(toDate);

		if (day <= dealDate.getActualMaximum(Calendar.DATE)) {
			return true;
		}
		return false;
	}

	/**
	 * 获取当前月份的最大天数的日期
	 *
	 * @param date
	 */
	public static String getMaxDate(String date) {
		Date toDate = DateOperation.getDateFromDbString(date);
		Calendar dealDate = Calendar.getInstance();
		dealDate.setTime(toDate);

		dealDate.set(Calendar.DAY_OF_MONTH, dealDate.getActualMaximum(Calendar.DATE));
		return FORMAT_YCLOANS().format(dealDate.getTime());
	}

	public static void main(String[] args) {
		Date toDate = DateOperation.getDateFromDbString("2016-02-29");
		Calendar dealDate = Calendar.getInstance();
		dealDate.setTime(toDate);

		System.out.print(dealDate.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * 获取每月21日
	 * @param Buzdate
	 * @return
	 */
	public static String getDay15(String Buzdate) {
		int   date=getDay(Buzdate);
		if(date>=1 && date<=14){
			String  LastBeginMonth=getLastBeginMonth(Buzdate);
			Calendar cal = getCalendarObject(LastBeginMonth);
			cal.set(Calendar.DATE, 15);// 日，设为一号
			return FORMAT_YCLOANS().format(cal.getTime());
		}else{
			Calendar cal = getCalendarObject(Buzdate);
			cal.set(Calendar.DATE, 15);// 日，设为一号
			return FORMAT_YCLOANS().format(cal.getTime());
		}
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
	 *将字符串格式yyyyMMdd的字符串转为日期，格式"yyyy-MM-dd"
	 *
	 * @param date 日期字符串
	 * @return 返回格式化的日期
	 * @throws ParseException 分析时意外地出现了错误异常
	 */
	public static String strToDateFormat(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		formatter.setLenient(false);
		Date newDate= formatter.parse(date);
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(newDate);
	}

	/**
	 * 计算两个日期大小
	 *
	 * @param startDate
	 *            ,被减数
	 * @param endDate
	 *            ， 减数 计算两个日期之间的相隔天数
	 */
	public  static boolean compareDeTo(String startDate, String endDate) {
		try {
			Date dt1 = FORMAT_YCLOANS().parse(startDate);
			Date dt2 = FORMAT_YCLOANS().parse(endDate);
			if (dt1.getTime() >= dt2.getTime()) {
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			throw new MinosException("get failed", e);
		}
	}


	// 根据还款间隔计算日期
	public static Date getDayTimePaymentFreq(String startDate, PaymentFreq freq,
											 int freqUnit, int dueDay) {
		return getDayByTimementFreq(getDateFromDbString(startDate), freq,
				freqUnit, dueDay);
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
	public static Date getDayByTimementFreq(Date startDate, PaymentFreq freq,
											int freqUnit, int dueDay) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		switch (freq) {
			case MONTH: {
				cal.add(Calendar.MONTH, freqUnit);
				return adjustByTimeDay(cal.getTime(), dueDay);
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
	public static Date adjustByTimeDay(Date result, int dueDay) {
		Calendar newResult = Calendar.getInstance();
		newResult.setTime(result);
		return adjustByTimeDay(newResult, dueDay).getTime();
	}


	/**
	 * 如果起息日是31,但是到了2月却只有28天，加频率加出来就有问题。
	 *
	 * @param result
	 * @param dueDay
	 * @return
	 */
	public static Calendar adjustByTimeDay(Calendar result, int dueDay) {
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
		}else{
			result.set(Calendar.DAY_OF_MONTH, dueDay);
		}
		return result;
	}

	// 日期型转化 yyyy-MM-dd HH:mm:ss
	public static long getStringToTimeStamp(String str,String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if( !"".equals(format))
			simpleDateFormat =new SimpleDateFormat(format);
		long timeStemp = 0 ;
		try{
			Date date = simpleDateFormat.parse(str);
			timeStemp = date.getTime();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return timeStemp;
	}


	/**
	 * 判断当月是否存在31号
	 * @param starDate
	 * @param endDate
	 */
	public  static boolean DayOfMonth(String starDate , String endDate) {
		boolean isLastDayOfMonth = false ;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(starDate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int maxDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
			calendar.set(Calendar.DAY_OF_MONTH, maxDayOfMonth);
			Date lastDayOfMonth = calendar.getTime();
			String lastMonthDate = getDateStringToDb(lastDayOfMonth);
			int day = Integer.parseInt(lastMonthDate.substring(8, 10));

			//判断当月是否是31号
			if( (DateOperation.comparingTwoDates(endDate,lastMonthDate)>0) ){
				isLastDayOfMonth = true;
				return isLastDayOfMonth;
			}
			isLastDayOfMonth = day == 31;
			if( isLastDayOfMonth )
				return isLastDayOfMonth;

			return isLastDayOfMonth;
		} catch (Exception e) {
			throw new MinosException("get failed", e);
		}
	}


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
}
