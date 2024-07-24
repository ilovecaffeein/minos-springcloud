package com.caxs.minos.controller;

import com.caxs.minos.dao.LmLoanDao;
import com.caxs.minos.date.DateOperation;
import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.trans.PaymentTryCalculationTrans;
import com.caxs.minos.domain.trans.PaymentTryTrans;
import com.caxs.minos.enums.PaymentModeEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.IPaymentTryCalculationService;
import com.caxs.minos.serv.db.ISystemInfoService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
/***
 * @ClassName(类名) : LmPmShdBuzController
 * @Description(描述) : 还款试算
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@RestController
public class Serv10000100040BuzService {

	@Resource
	private IPaymentTryCalculationService iPaymentTryCalculationService;

	@Resource
	private ISystemInfoService systemInfoService;

	@Resource
	private LmLoanDao lmLoanDao;

	/**
	 * 归还欠款
	 */
	@RequestMapping(value = "/PaymentTryCalculation/Nm/",method = RequestMethod.GET)
	public PaymentTryCalculationTrans paymentTryCalForPay(@RequestBody PaymentTryTrans paymentTryTrans){
		//还款方法
		String buzDate = systemInfoService.getBuzDate();

		LmLoan lmLoan = lmLoanDao.findByLoanNo(paymentTryTrans.getLoanNo());
		if (lmLoan == null) {
			throw new MinosException("此借据无借据主表信息！");
		}
		if ( PaymentModeEnum.ALL.getCodeInDb().equals(paymentTryTrans.getSetlMode()) ||
				PaymentModeEnum.ADVANCE.getCodeInDb().equals(paymentTryTrans.getSetlMode()) ){//提前还款
			if ( DateOperation.compareTo(paymentTryTrans.getBuzDate(),lmLoan.getNextDueDt())){
				throw new MinosException(
						MinosException.ERROR90001,"该贷款已经拖欠,不可做普通(FS 或者 ER)还款");
			}
		}

		return  iPaymentTryCalculationService.paymentTryCalForPay(
				paymentTryTrans.getLoanNo(),buzDate,paymentTryTrans.getActvPayAmt(),paymentTryTrans.getSetlMode(),paymentTryTrans.getSeltTyp());
	}

	/**
	 * 提前部分还款
	 */
	@RequestMapping(value = "/PaymentTryCalculation/Er/",method = RequestMethod.GET)
	public PaymentTryCalculationTrans paymentTryCalForPartActvPay(@RequestBody PaymentTryTrans paymentTryTrans){
		//还款方法
		String buzDate = systemInfoService.getBuzDate();

		LmLoan lmLoan = lmLoanDao.findByLoanNo(paymentTryTrans.getLoanNo());
		if (lmLoan == null) {
			throw new MinosException("此借据无借据主表信息！");
		}
		if ( PaymentModeEnum.ALL.getCodeInDb().equals(paymentTryTrans.getSetlMode()) ||
				PaymentModeEnum.ADVANCE.getCodeInDb().equals(paymentTryTrans.getSetlMode()) ){//提前还款
			if ( DateOperation.compareTo(paymentTryTrans.getBuzDate(),lmLoan.getNextDueDt())){
				throw new MinosException(
						MinosException.ERROR90001,"该贷款已经拖欠,不可做普通(FS 或者 ER)还款");
			}
		}

		return  iPaymentTryCalculationService.paymentTryCalForPartActvPay(
				paymentTryTrans.getLoanNo(),buzDate,paymentTryTrans.getActvPayAmt(),
				PaymentModeEnum.getEnum(paymentTryTrans.getSetlMode()).getCodeInDb(),PaymentModeEnum.getEnum(paymentTryTrans.getSeltTyp()).getCodeInDb());
	}

	/**
	 * 提前部分还款
	 */
	@RequestMapping(value = "/PaymentTryCalculation/Fs/",method = RequestMethod.GET)
	public PaymentTryCalculationTrans paymentTryCalForAllActvPay(@RequestBody PaymentTryTrans paymentTryTrans){
		//还款方法
		String buzDate = systemInfoService.getBuzDate();

		LmLoan lmLoan = lmLoanDao.findByLoanNo(paymentTryTrans.getLoanNo());
		if (lmLoan == null) {
			throw new MinosException("此借据无借据主表信息！");
		}
		if ( PaymentModeEnum.ALL.getCodeInDb().equals(paymentTryTrans.getSetlMode()) ||
				PaymentModeEnum.ADVANCE.getCodeInDb().equals(paymentTryTrans.getSetlMode()) ){//提前还款
			if ( DateOperation.compareTo(paymentTryTrans.getBuzDate(),lmLoan.getNextDueDt())){
				throw new MinosException(
						MinosException.ERROR90001,"该贷款已经拖欠,不可做普通(FS 或者 ER)还款");
			}
		}

		return iPaymentTryCalculationService.paymentTryCalForAllActvPay(
				paymentTryTrans.getLoanNo(),buzDate,Double.valueOf(paymentTryTrans.getActvPayAmt()),
				PaymentModeEnum.getEnum(paymentTryTrans.getSetlMode()).getCodeInDb(),PaymentModeEnum.getEnum(paymentTryTrans.getSeltTyp()).getCodeInDb());
	}
}