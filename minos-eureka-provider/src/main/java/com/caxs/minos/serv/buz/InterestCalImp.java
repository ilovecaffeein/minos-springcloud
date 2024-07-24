package com.caxs.minos.serv.buz;

import java.math.BigDecimal;
import com.caxs.minos.def.MinosConst;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.utils.PaymentUtils;
import com.caxs.minos.utils.SystemUtils;
import com.yuchengtech.ycloans.accounting.model.PaymentFrequency.Frequency;
import com.yuchengtech.ycloans.common.enumeration.LoanRateBase;
import com.yuchengtech.ycloans.common.enumeration.LoanRoundingMode;
/**
 * @ClassName: InterestCalImp
 * @Description: 按日期来计算一个阶段利率
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class InterestCalImp{

	/*
	 * 计算期数利率,返回数据未修约
	 */
	public static BigDecimal computeInterest(BigDecimal calendarRate,
			BigDecimal money, LoanRoundingMode roundingMode,
			int calendarRateUnitCount, int reservedDigitalCount) {
		if (calendarRateUnitCount < 0) {
			throw new MinosException("计算利息的天数：" + calendarRateUnitCount
					+ "不能小于0");
		}
		money = PaymentUtils.getBigDecimalAmtForInterestCal(money);
		BigDecimal result = money.multiply(calendarRate).multiply(
				new BigDecimal(calendarRateUnitCount));
		return result.setScale(reservedDigitalCount, roundingMode
				.getRoundingMode());
	}

	//计算期数利率,返回数据未修约
	public static double computeInterest(double calendarRate, double money,
			LoanRoundingMode roundingMode, int calendarRateUnitCount, int reservedDigitalCount) {
		if (calendarRateUnitCount < 0) {
			throw new MinosException("计算利息的天数：" + calendarRateUnitCount
					+ "不能小于0");
		}
		money = PaymentUtils.getAmtForInterestCal(money);
		double result = SystemUtils.amtMult(money, calendarRate);
		result = SystemUtils.amtMult(result, calendarRateUnitCount);
		BigDecimal r = SystemUtils.getBigDecimal(result);
		return r.setScale(reservedDigitalCount, roundingMode.getRoundingMode())
				.doubleValue();
	}

	//计算期数利率,返回数据未修约
	public static double computeInterest(double calendarRate, double money,
			int calendarRateUnitCount) {
		return computeInterest(calendarRate, money,
				LoanRoundingMode.FOUR_REMOVE_FIVE_UP, calendarRateUnitCount,
				MinosConst.CORE_GLTX_DIG_COUNT);
	}

	//计算期数利率,返回数据未修约
	public static BigDecimal computeInterest(BigDecimal rate,
			BigDecimal moneyMutiDayCount, LoanRoundingMode roundingMode,
			int reservedDigitalCount) {
		BigDecimal result = moneyMutiDayCount.multiply(rate);
		return result.setScale(reservedDigitalCount, roundingMode
				.getRoundingMode());

	}

	//计算对应的期利率
	public static double getPhaseRate(double rateYearly, double yearDayCount,
			Frequency frequency, double frequencyRange) {
		switch (frequency) {
		case PAY_MONTHLY:
			return SystemUtils.amtDiv(SystemUtils.amtMult(rateYearly,
					frequencyRange), 12);
		case PAY_QUARTERLY:
			return SystemUtils.amtDiv(SystemUtils.amtMult(rateYearly,
					frequencyRange), 4);
		case PAY_YEARLY:
			return SystemUtils.amtDiv(SystemUtils.amtMult(rateYearly,
					frequencyRange), 1);
		case PAY_WEEKLY:
			return SystemUtils.amtMult((SystemUtils.amtMult(SystemUtils.amtDiv(
					rateYearly, yearDayCount), 7)), frequencyRange);
		}
		throw new MinosException("没有计算利率的方法：" + frequency.toString());
	}


	//返回一年有多少天
	public double getYearDays(String loanCcy, boolean useActualDayCount) {
		double days = 360;
		return days;
	}

	// .divide(new BigDecimal(100))有可能要出于100
	//计算日利率
	public static BigDecimal computeDaylyRate(LoanRateBase loanRateBase,
											  BigDecimal rate, int yearDayCount) {
		if (rate == null) {
			throw new MinosException("利率不能为空");
		}
		switch (loanRateBase) {
		case M:
			return BigDecimal.valueOf(rate.doubleValue() * 12 / yearDayCount);
		case D:
			return rate;
		case Y:
			return BigDecimal.valueOf((rate.doubleValue() / yearDayCount));
		}
		throw new MinosException("not supported");
	}

	/**
	 * 计算利息,四舍五入保留2位小数
	 * 
	 * @param rateTermly
	 * @param rateDayly
	 * @param interestPrcp
	 * @param termCount
	 * @param dayCount
	 * @return
	 */
	public  double computeInterest(double rateTermly, double rateDayly,
			double interestPrcp, int termCount, int dayCount) {
		double intRate = 0;
		if (termCount > 0) {
			intRate = computeInterestWithoutRounding(rateTermly, interestPrcp,
					termCount);
		}
		if (dayCount > 0) {
			intRate += computeInterestWithoutRounding(rateDayly, interestPrcp,
					dayCount);
		}
		return SystemUtils.getDoubleWhenEvenUp(intRate);
	}

	//未修约
	public double computeInterestWithoutRounding(double calendarRate,
			double money, int calendarRateUnitCount) {
		money = PaymentUtils.getAmtForInterestCal(money);
		double result = SystemUtils.amtMult(money, calendarRate);
		return result = SystemUtils.amtMult(result, calendarRateUnitCount);

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
