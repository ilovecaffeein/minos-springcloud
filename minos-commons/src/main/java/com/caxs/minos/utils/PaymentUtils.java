package com.caxs.minos.utils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.*;
import com.caxs.minos.date.DateOperation;
import com.caxs.minos.def.MinosConst;
import com.caxs.minos.exception.MinosException;
import com.yuchengtech.ycloans.common.enumeration.PaymentFreq;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * 付款应用
 * @author hb
 */
public class PaymentUtils {

	// 打印日志属性
	private static Log log = LogFactory.getLog(PaymentUtils.class);


	/**
	 * 计算起息日以后的第一个付款日
	 *
	 * @param intStartDate
	 *            :利息起始日
	 * @param freq
	 *            :还款频率
	 * @param freqUnit
	 *            :频率单位。例如双周供=2，一般=1
	 * @param firstPayDateInLoan
	 *            借据中的第一次付款日。
	 * @return
	 */
	public static Date calPayDate(String intStartDate, PaymentFreq freq,
								  int freqUnit, String firstPayDateInLoan, int dueDay) {
		return calPayDate(DateOperation.getDateFromDbString(intStartDate),
				freq, freqUnit, firstPayDateInLoan, dueDay);
	}

	/**
	 * 计算起息日以后的第一个付款日
	 *
	 * @param intStartDate
	 *            :利息起始日
	 * @param freq
	 *            :还款频率
	 * @param freqUnit
	 *            :频率单位。例如双周供=2，一般=1
	 * @param firstPayDateInLoan
	 *            借据中的第一次付款日。
	 * @return
	 */
	public static Date calPayDate(Date intStartDate, PaymentFreq freq,
								  int freqUnit, String firstPayDateInLoan, int dueDay) {
		Date priorDate = DateOperation.getDateFromDbString(firstPayDateInLoan);
		if (priorDate.after(intStartDate)) {
			return priorDate;
		}
		return DateOperation.getNextDateByPaymentFreq(priorDate, intStartDate,
				freq, freqUnit, dueDay);
	}

	/**
	 * 计算最后还款日。
	 *
	 * @param freq
	 *            还款频率
	 * @param freqUnit
	 *            频率单位数，一般=1
	 * @param firstPayDate
	 *            本阶段付款日。通过#calPayDate()来获取
	 * @param loanLastDueDate
	 * @param perdCount
	 *            不包含firstPaydate的期数 期数
	 * @return
	 */
	public static Date calLastPayDate(Date firstPayDate, PaymentFreq freq,
									  int freqUnit, Date loanLastDueDate, int perdCount,
									  String firstPayDateInLoan, int dueDay) {
		if (perdCount <= 0)
			return firstPayDate;
		if (freq == PaymentFreq.NULL) {
			return firstPayDate;
		}
		if (loanLastDueDate != null) {
			if (DateOperation.getDateStringToDb(firstPayDate).compareTo(
					DateOperation.getDateStringToDb(loanLastDueDate)) >= 0) {
				return loanLastDueDate;
			}
		}

		Date startFreqDate = DateOperation
				.getDateFromDbString(firstPayDateInLoan);
		if (!DateOperation.isFreqDate(firstPayDate, freq, freqUnit,
				startFreqDate, dueDay)) {
			throw new MinosException("付款日期必须是频率倍数");
		}
		Date lastPayDate = DateOperation.getDayByPaymentFreq(firstPayDate,
				freq, freqUnit * (perdCount), dueDay);
		if (loanLastDueDate == null) {
			return lastPayDate;
		}
		if (lastPayDate.before(loanLastDueDate)) {
			return lastPayDate;
		}
		return loanLastDueDate;
	}


	/**
	 * 从buzDate开始计算还款日期，返回列表 不包含开始日期=startdate，那一期但是包含最后一期
	 *
	 * @param startDate
	 * @param lastDueDt
	 * @param freq
	 * @return
	 */
	public static String[] calPaymentDueDtList(String startDate,
											   String lastDueDt, PaymentFreq freq, int dueDay, int freqUnit,
											   boolean isFirstPerdOverOnePaymentFreq) {
		// 一次性还本付息。
		if (freq == PaymentFreq.NULL)
			return new String[] { lastDueDt };
		Set<String> set = new HashSet<String>();
		Date firstPayDate = DateOperation.getFirstPayDateByPaymentFreq(
				startDate, dueDay, freq, freqUnit,
				isFirstPerdOverOnePaymentFreq);
		String fstPayDt = DateOperation.getDateStringToDb(firstPayDate);
		if (fstPayDt.compareTo(lastDueDt) >= 0) {
			return new String[] { lastDueDt };
		}
		set.add(fstPayDt);
		Date lastDueDate = DateOperation.getDateFromDbString(lastDueDt);
		Date date = firstPayDate;
		while (true) {
			if (date.before(lastDueDate)) {
				set.add(DateOperation.getDateStringToDb(date));
				date = DateOperation.getDayByPaymentFreq(date, freq, freqUnit,
						dueDay);
				continue;
			} else
				break;
		}
		set.add(lastDueDt);
		String[] result = set.toArray(new String[0]);
		Arrays.sort(result);
		if (isFirstPerdOverOnePaymentFreq) {
			if (freq == PaymentFreq.MONTH) {
				if (result.length >= 2) {
					if (((DateOperation.getMonth(result[result.length - 1])) == (DateOperation
							.getMonth(result[result.length - 2])))
							&& ((DateOperation
							.getYear(result[result.length - 1])) == (DateOperation
							.getYear(result[result.length - 2])))) {
						String[] result1 = new String[result.length - 1];
						System.arraycopy(result, 0, result1, 0, result1.length);
						result1[result1.length - 1] = lastDueDt;
						return result1;
					}
				}

			} else if (freq == PaymentFreq.QUATER) {//期供类的最后一期修约 by shanyj
				if (result.length >= 2) {
					if (DateOperation.isYearAndMonthSame(result[result.length-1],
							result[result.length-2])) {
						String[] result1 = new String[result.length - 1];
						System.arraycopy(result, 0, result1, 0, result1.length);
						result1[result1.length - 1] = lastDueDt;
						return result1;
					}
				}
			} else if (freq == PaymentFreq.WEEK) {//期供类的最后一期修约 by shanyj
				if (result.length >= 2) {
					if (DateOperation.isYearAndMonthSame(result[result.length-1],
							result[result.length-2])) {
						String[] result1 = new String[result.length - 1];
						System.arraycopy(result, 0, result1, 0, result1.length);
						result1[result1.length - 1] = lastDueDt;
						return result1;
					}
				}
			}

		}
		return result;
	}

	/**
	 * 计算从开始日期到截止日期一共有多少期数。 不包含开始日期=startdate，那一期但是包含最后一期
	 *
	 * @param startDate
	 * @param lastDueDt
	 * @param freq
	 * @param dueDay
	 * @param freqUnit
	 * @return
	 */
	public static int calPaymentPeriodCount(String startDate, String lastDueDt,
											PaymentFreq freq, int dueDay, int freqUnit,
											boolean isFirstPerdOverOnePaymentFreq) {
		String[] dueDtList = calPaymentDueDtList(startDate, lastDueDt, freq,
				dueDay, freqUnit, isFirstPerdOverOnePaymentFreq);
		return dueDtList.length;

	}




	/**
	 * 能否还款
	 *
	 * @param conn
	 * @param loanNo
	 * @return
	 */
	public static void checkCanPaymentMoney(Connection conn, String loanNo) {

	}


	/**
	 * 根据起止时间计算实际天数 Get actual day count between beginDate and endDate
	 *
	 * @param beginDate
	 *            Begin date
	 * @param endDate
	 *            End date
	 * @return 1 if the same day, otherwise ABS(endDate - beginDate)
	 */
	public static int getActualDayCount(Date beginDate, Date endDate) {
		beginDate = DateOperation.getDateFromDbString(DateOperation
				.getDateStringToDb(beginDate));
		endDate = DateOperation.getDateFromDbString(DateOperation
				.getDateStringToDb(endDate));
		int result = 1;
		if (beginDate != null && endDate != null) {
			result = (int) Math.abs((endDate.getTime() - beginDate.getTime())
					/ 24 / 60 / 60 / 1000);
		}
		return (result == 0) ? 1 : result;
	}

	/**
	 * 计算等额本息期供金额：包含本金和利息
	 *
	 * @param rateTermly
	 *            :如果期数是按月，那么填入月利率,注意一般都不是日利率或者年利率
	 * @param perdCount
	 *            :期数。
	 * @param paymentPrcp
	 *            ：从1期到perdCount之间要归还的本金
	 * @param paymentRemPrcp
	 *            期数之后的本金
	 * @return
	 */
	public static double calInstmAmountForEqualPrcpAndInt(double rateTermly,
														  int perdCount, double paymentPrcp, double paymentRemPrcp) {
		double temp = Math.pow(1 + rateTermly, perdCount);
		if (SystemUtils.isAmtLessThanZero((temp - 1))) {
			throw new MinosException("等额本息除数不能小于0:" + (temp - 1));
		}
		double amount = (paymentPrcp * temp - paymentRemPrcp) * rateTermly
				/ (temp - 1);
		amount = SystemUtils.getDoubleWhenEvenUp(amount);
		return amount;

	}

	/**
	 * 根据期供计算期数
	 *
	 * @param rateTermly
	 * @param instmAmt
	 * @param paymentPrcp
	 * @param paymentRemPrcp
	 * @return
	 */
	public static int calPerdCntForEqualPrcpAndInt(double rateTermly,
												   double instmAmt, double paymentPrcp, double paymentRemPrcp) {
		if (SystemUtils.isAmtLessThanOrEqualZero(//shanyj
				(instmAmt - rateTermly * paymentPrcp))) {
			return 0;
		}
		double k = (instmAmt - paymentRemPrcp * rateTermly)
				/ (instmAmt - rateTermly * paymentPrcp);
		if (SystemUtils.isAmtLessThanOrEqualZero(k)) {
			return 0;
		}
		if (Math.log10(1 + rateTermly) ==0) {//add by shanyj 贷款执行利率为0时
			return 0;
		}
		int perdCount = (int) SystemUtils.getDouble((Math.log10(k) / Math
				.log10(1 + rateTermly)), 0);
		return perdCount;

	}



	/**
	 * 计算从开始日期到截止日期一共有多少期数。 不包含开始日期=startdate，那一期但是包含最后一期
	 *
	 * @param startDate
	 * @param lastDueDt
	 * @param freq
	 * @param dueDay
	 * @param freqUnit
	 * @return
	 */
	public static int calJjBankPaymentPeriodCount(String startDate, String lastDueDt,
												  PaymentFreq freq, int dueDay, int freqUnit,
												  boolean isFirstPerdOverOnePaymentFreq) {
		String[] dueDtList = calJjBankPaymentDueDtList(startDate, lastDueDt, freq,
				dueDay, freqUnit, isFirstPerdOverOnePaymentFreq);
		return dueDtList.length;

	}


	/**
	 * 从buzDate开始计算还款日期，返回列表 不包含开始日期=startdate，那一期但是包含最后一期
	 * @param startDate
	 * @param lastDueDt
	 * @param freq
	 * @return
	 */
	public static String[] calJjBankPaymentDueDtList(String startDate,
													 String lastDueDt, PaymentFreq freq, int dueDay, int freqUnit,
													 boolean isFirstPerdOverOnePaymentFreq) {
		// 一次性还本付息。
		if (freq == PaymentFreq.NULL)
			return new String[] { lastDueDt };
		Set<String> set = new HashSet<String>();

		Date firstPayDate=null;
		int Day=DateOperation.getDay(startDate);
		//九江银行1 至9号，当月计算还款日 和 17号至月末 生成  t+1  月首期还款日。
		if( Day >=1 && Day <=9 && dueDay >9 ){
			firstPayDate = DateOperation.getFirstPayDateByPaymentFreq(
					startDate, dueDay, freq, 0,
					isFirstPerdOverOnePaymentFreq);
		}else {
			firstPayDate = DateOperation.getFirstPayDateByPaymentFreq(
					startDate, dueDay, freq, freqUnit,
					isFirstPerdOverOnePaymentFreq);
		}
		String fstPayDt =DateOperation.getDateStringToDb(firstPayDate);
		if ( fstPayDt.compareTo(lastDueDt) >= 0) {
			return new String[] { lastDueDt };
		}
		set.add(fstPayDt);
		Date lastDueDate = DateOperation.getDateFromDbString(lastDueDt);
		Date date = firstPayDate;
		while (true) {
			if (date.before(lastDueDate)) {
				set.add(DateOperation.getDateStringToDb(date));
				date = DateOperation.getDayByPaymentFreq(date, freq, freqUnit,
						dueDay);
				continue;
			} else
				break;
		}
		set.add(lastDueDt);
		String[] result = set.toArray(new String[0]);
		Arrays.sort(result);
		if (isFirstPerdOverOnePaymentFreq) {
			if (freq == PaymentFreq.MONTH) {
				if (result.length >= 2) {
					if (((DateOperation.getMonth(result[result.length - 1])) == (DateOperation
							.getMonth(result[result.length - 2])))
							&& ((DateOperation
							.getYear(result[result.length - 1])) == (DateOperation
							.getYear(result[result.length - 2])))) {
						if( ( Day >=1 && Day <=9 ) || Day >=17 ){
							String[] result1 = new String[result.length ];
							System.arraycopy(result, 0, result1, 0, result1.length);
							return result1;
						}else{
							String[] result1 = new String[result.length - 1];
							System.arraycopy(result, 0, result1, 0, result1.length);
							result1[result1.length - 1] = lastDueDt;
							return result1;
						}
					}
				}
			} else if (freq == PaymentFreq.QUATER) {//期供类的最后一期修约 by shanyj
				if (result.length >= 2) {
					if (DateOperation.isYearAndMonthSame(result[result.length-1],
							result[result.length-2])) {
						String[] result1 = new String[result.length - 1];
						System.arraycopy(result, 0, result1, 0, result1.length);
						result1[result1.length - 1] = lastDueDt;
						return result1;
					}
				}
			} else if (freq == PaymentFreq.WEEK) {//期供类的最后一期修约 by shanyj
				if (result.length >= 2) {
					if (DateOperation.isYearAndMonthSame(result[result.length-1],
							result[result.length-2])) {
						String[] result1 = new String[result.length - 1];
						System.arraycopy(result, 0, result1, 0, result1.length);
						result1[result1.length - 1] = lastDueDt;
						return result1;
					}
				}
			}

		}
		return result;
	}

	/**
	 * 计算用于计算积数计算的金额
	 * @param amt
	 * @return
	 */
	public static BigDecimal getBigDecimalAmtForInterestCal(BigDecimal amt) {
		return amt.setScale(0, MinosConst.DEFAULT_INTEREST_DIGTIAL_COUNT);
	}

	/**
	 * 计算用于计算积数计算的金额
	 * @param amt
	 * @return
	 */
	public static double getAmtForInterestCal(double amt) {
		BigDecimal dec1 = BigDecimal.valueOf(amt);
		dec1 = dec1.setScale(0, MinosConst.DEFAULT_INTEREST_DIGTIAL_COUNT);
		return dec1.doubleValue();
	}
}
