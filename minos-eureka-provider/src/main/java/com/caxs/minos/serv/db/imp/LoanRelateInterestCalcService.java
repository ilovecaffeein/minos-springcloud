package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.LmPmShdDao;
import com.caxs.minos.dao.PLoanTypGlDao;
import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.LmLnRepcLog;
import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.LmLoanCont;
import com.caxs.minos.domain.LmPmShd;
import com.caxs.minos.domain.trans.RateChangeLogTrans;
import com.caxs.minos.enums.AdvancePaymentIntBaseEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.buz.InterestCal;
import com.caxs.minos.serv.db.IEntryRuleConfiguraService;
import com.caxs.minos.serv.db.ILoanRelateInterestCalcService;
import com.caxs.minos.utils.DateOperation;
import com.caxs.minos.utils.LoanRelateUtils;
import com.caxs.minos.utils.RoundingUtil;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/***
 * @ClassName(类名) : LoanRelateInterestCalcService
 * @Description(描述) :当前剩余本金利息计算器
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/17 15:48
 */
@Component
@Service
public class LoanRelateInterestCalcService implements ILoanRelateInterestCalcService {
	//从命名表对象
	private LoanRelateUtils loanRelate;
	//还款计划对象
	private LmPmShd interestPrcpShd;
	//利率变动日志列表
	private List<RateChangeLogTrans> lmLnRepcLogList;
	//当前业务日期
	private String buzDate;
	//当天是否计算利息
	private boolean hasLastDateInterest;
	//计算利息本金
	private BigDecimal interestPrcp;
	//主动还款的还款计划
	private List<LmPmShd> ppErLmPmShdList;

	@Resource
	IEntryRuleConfiguraService iEntryRuleConfiguraService;

	@Resource
	LmPmShdDao lmPmShdDao;

	@Resource
	PLoanTypGlDao pLoanTypGlDao;

	public LoanRelateInterestCalcService(){
		super();
	}


	/**
	 * 获取计算本金
	 * @return
	 */
	public BigDecimal getInterestPrcp() {
		return interestPrcp;
	}

	/**
	 * 查询<=operationDate 的利息计算起始期
	 *
	 * @param operationDate
	 *            查询日期
	 * @return 。
	 */
	public LmPmShd getInterestDatePmShd(String operationDate) {
		return getInterestDateShd(operationDate, true);
	}

	/**
	 * 获取用于计算利息的本金
	 * @return
	 */
	public BigDecimal calInterestPrcp(LmPmShd shd) {
		if (loanRelate.isUseRemainPrcpToCalInterest()) {
			if (shd == null) {
				shd = interestPrcpShd;
			}
			return shd.getPsRemPrcp();
		} else {
			return loanRelate.getOrigPrcp();
		}
	}


	/**
	 * 查询计息本金
	 *
	 * @param buzDate
	 *            查询日期
	 * @return 。
	 */
	public LmPmShd getInterestPrcpPmShd(String loanNo, String buzDate) {
		LmPmShd shd = lmPmShdDao.findMaxPerdNoBeforePsDueDt(loanNo, buzDate);
		if (shd == null) {
			throw new MinosException("没有找到计息本金还款计划");
		}
		return shd;
	}

	/**
	 * 查询<=operationDate 的利息计算起始期。
	 *
	 * @param buzDate
	 *            查询日期
	 * @return shd 还款计划表
	 */
	public LmPmShd getInterestDateShd(String buzDate,boolean isEqualDate) {
		LmPmShd shd = lmPmShdDao.findMaxPerdNoBeforePsDueDt(loanRelate.getLoanNo(), buzDate);
		if (shd == null) {
			// 返回0期
			if (buzDate.equals(loanRelate.getLoan().getIntStartDt())) {
				shd =lmPmShdDao.selectOneByObject(new LmPmShd(loanRelate.getLoanNo(),0));
				if (shd != null) {
					return shd;
				}
			}
			throw new MinosException("没有找到利息计算开始日！");
		}
		return shd;
	}


	/**
	 * 当前剩余本金利息计算器构造方法
	 * @param loanCont
	 * @param lmLoan
	 * @param interestShd
	 * @param curDueShd
	 * @param buzDate
	 * @param hasLastDateInterest
	 *            当天是否计算利息，一般填false
	 */
	@Override
	public void getLoanRelateInterestCalc(LmLoanCont loanCont,LmLoan lmLoan, LmPmShd interestShd,
									   LmPmShd curDueShd,String buzDate ,boolean hasLastDateInterest) {
		this.loanRelate = new LoanRelateUtils(lmLoan,loanCont);
		this.interestPrcpShd = interestShd;
		if ((interestShd.getPsPerdNo() + 1) < curDueShd.getPsPerdNo().intValue()) {
			interestPrcpShd = getInterestPrcpPmShd(loanRelate.getLoanNo(), buzDate);
		}
		this.buzDate = buzDate;
		this.lmLnRepcLogList = getRateChangeLogList(getRepcLogList(
				interestShd.getPsDueDt(), this.buzDate));
		this.hasLastDateInterest = hasLastDateInterest;
	}

	/**
	 * 计算利息，返回的利息修约到2位
	 *
	 * @return
	 */
	@Override
	public BigDecimal cal() {
		BigDecimal normInt = MinosConst.ZERO_BIGDECIMAL;
		switch (AdvancePaymentIntBaseEnum.getEnum(
				iEntryRuleConfiguraService.findBytypGlId(loanRelate.getBankCde(),
						loanRelate.getLoan().getLoanTyp()).getGlPpRatBase())) {
		case REMAINING_PRINCIPAL:
		case ADVANCE_PRINCIPAL:
			normInt = ospCal();
			break;
		case NO_INTEREST:
			normInt = MinosConst.ZERO_BIGDECIMAL;
			break;
		default:
			throw new MinosException("not support adv option");
		}
		return RoundingUtil.roundingBigDecimal(normInt);
	}


	/**
	 * 计算利息
	 *
	 * @return
	 */
	public BigDecimal ospCal() {
		BigDecimal result = new BigDecimal(0);
		double lastRateDayly = loanRelate.getIntRateDayly();
		String firstDate = interestPrcpShd.getPsDueDt();
		interestPrcp = calInterestPrcp(null);
		if ( CollectionUtils.isEmpty(lmLnRepcLogList) ) {
			// 计算调整利率前的计提天数
			int accDays = (int) DateOperation.DateCal(buzDate, firstDate);
			if ( hasLastDateInterest ) {// 31,会多一天
				accDays++;
			}
			if ( accDays < 0 ) {
				throw new MinosException("计算利息的天数：" + accDays + "不能小于0");
			}
			result = InterestCal.computeInterest(new BigDecimal(lastRateDayly), interestPrcp,accDays);
		} else {
			/************
			 PayShdIntCal cal = new PShdRepcLogCal(firstDate, buzDate,
			 lmLnRepcLogList, ppErLmPmShdList, loanRelate, hasLastDateInterest,false);
			 result = cal.cal(interestPrcp, lastRateDayly);
			 ************/
		}
		return result;
	}


	/**
	 * 获取利率变动日志列表
	 * @param logList
	 * @return 。
	 */
	public List<RateChangeLogTrans> getRateChangeLogList(List<LmLnRepcLog> logList) {
		if (CollectionUtils.isEmpty(logList)) {
			return Collections.EMPTY_LIST;
		}
		List<RateChangeLogTrans> rList = new ArrayList<RateChangeLogTrans>(logList.size());
		/********************************************
		for (LmLnRepcLog l : logList) {
			RateChangeLog rcl = new RateChangeLog();
			rcl.setPrcpProd(l.getPrcpProd());
			rcl.setOldIntRate(l.getRpOldIntRate());
			rcl.setSetl(YnFlag.isTrue(l.getSetlInd()));
			rcl.setStartDate(l.getId().getRepcDt());
			rcl.setNewIntRate(l.getRpNewIntRate());
			rList.add(rcl);
		}*********************************************/
		return rList;
	}

	/**
	 * 返回利率变动日志，>=开始日期,<=结束日期。
	 *
	 * @param startDate
	 * @param endDate
	 *            应当为getInterestPmShd的日期，也就是起息日日期
	 * @return
	 */
	public List<LmLnRepcLog> getRepcLogList(String startDate,
											String endDate) {
		List<LmLnRepcLog> list =null;
		/********************************************
		return DAOContainer.getLmLnRepcLogDAO(conn != null)
				.findbyLoanNoAndDate(loanRelate.getLoan(), startDate, endDate);
		 **********************************************/
		return list;
	}
}
