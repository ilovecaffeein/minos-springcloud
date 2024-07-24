package com.caxs.minos.serv.buz;

import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.LmLoanCont;
import com.caxs.minos.utils.SystemUtils;
import com.yuchengtech.ycloans.common.enumeration.LoanRateBase;
import static com.caxs.minos.enums.LoanPenaltyTypeEnum.LoanPenaltyTypeEnum;
/***
 * @ClassName(类名) : LoanRate
 * @Description(描述) : 初始化
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public class LoanRate {

	private int dayCountYearly;
	private LoanRateBase loanRateBase;
	private LmLoan lmLoan;
	private LmLoanCont lmLoanCont;

	/**
	 * @return the dayCountYearly
	 */
	public int getDayCountYearly() {
		return dayCountYearly;
	}

	/**
	 * @return the loanRateBase
	 */
	public LoanRateBase getLoanRateBase() {
		return loanRateBase;
	}

	/**
	 * @param lmLoan
	 * @param lmLoanCont
	 */
	public LoanRate(LmLoan lmLoan, LmLoanCont lmLoanCont) {
		this.lmLoan = lmLoan;
		this.lmLoanCont = lmLoanCont;
		/* 取计息天数 */
		dayCountYearly = 360;
		/* 取利率基础 */
		loanRateBase = LoanRateBase.getEnum(lmLoan.getRateBase());
	}

	public double getLendingRateDayly() {
		double lendingRate = InterestCalImp
				.computeDaylyRate(loanRateBase, lmLoan.getLoanIntRate(),
						dayCountYearly).doubleValue();
		return lendingRate;
	}


	public double getOutLendingRateDayly() {
		double lendingRate = InterestCalImp
				.computeDaylyRate(loanRateBase, lmLoan.getLoanIntRate(),
						dayCountYearly).doubleValue();
		return lendingRate;
	}

	public double getPenaltyLendingRateDayly() {
		double penaltyLendingRate = (double) InterestCalImp
				.computeDaylyRate(loanRateBase, lmLoan.getLoanOdIntRate(),
						dayCountYearly).doubleValue();
		return penaltyLendingRate;
	}

	public static double getLendingRateCal(double benchmarkInterestRate,
			double floatingInterestRate, double proportionOfFloatingRate) {
		double amtAdd = SystemUtils.amtAdd(benchmarkInterestRate,
				floatingInterestRate);
		double amtAdd1 = SystemUtils.amtAdd(1, proportionOfFloatingRate);
		return SystemUtils.amtMult(amtAdd, amtAdd1);
	}

	public static double getPenaltyLendingRate(String penaltyRateType,
			double penaltyActionInterestRate,
			double proportionOfPenaltyFloatingRate) {
		if (LoanPenaltyTypeEnum.getEnum(penaltyRateType).equals(
				LoanPenaltyTypeEnum.ACTION)) {
			double amtAdd = SystemUtils.amtAdd(1,
					proportionOfPenaltyFloatingRate);
			return SystemUtils.amtMult(amtAdd, penaltyActionInterestRate);
		}

		return penaltyActionInterestRate;
	}
	
	/**
	 * @desc 增加罚息利率浮动点差odRateSprd，修改罚息利率的计算公式
	 * @param penaltyRateType
	 * @param penaltyActionInterestRate
	 * @param proportionOfPenaltyFloatingRate
	 * @param odRateSprd
	 * @return
	 */
	public static double getPenaltyLendingRate(String penaltyRateType,
			double penaltyActionInterestRate,
			double proportionOfPenaltyFloatingRate,double odRateSprd) {
		if (LoanPenaltyTypeEnum.getEnum(penaltyRateType).equals(
				LoanPenaltyTypeEnum.ACTION)) {
			double amtAdd = SystemUtils.amtAdd(1,
					proportionOfPenaltyFloatingRate);
			double rateAdd = SystemUtils.amtAdd(penaltyActionInterestRate,
					odRateSprd);
			return SystemUtils.amtMult(amtAdd, rateAdd);
		}

		return penaltyActionInterestRate;
	}
}
