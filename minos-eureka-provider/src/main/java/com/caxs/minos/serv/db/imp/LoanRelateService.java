package com.caxs.minos.serv.db.imp;

import com.caxs.minos.domain.*;
import com.caxs.minos.enums.PmShdAdjOptionEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.buz.LoanRate;
import com.caxs.minos.serv.db.ILoanRelateService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;
/***
 * @ClassName(类名) : LoanRelateService
 * @Description(描述) :从命名表对象
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/17 15:48
 */
public class LoanRelateService  implements ILoanRelateService {
	// 打印日志属性
	private Log log = LogFactory.getLog(getClass());
	/**
	 * 当前应还期
	 */
	private int curDuePerdNo = -1;
	// 借据对象属性
	private LmLoan loan = null;
	/**
	 *借据是否存在，在贷款试算阶段借据还不存在
	 */
	private boolean isLoanExists = true;

	// 获取借据是否存在
	public boolean isLoanExists() {
		return isLoanExists;
	}

	// 设置借据是否存在
	public void setLoanExists(boolean isLoanExists) {
		this.isLoanExists = isLoanExists;
	}

	/** 还款计划调整方式：只调整扣款日；只调整利率；调整扣款日和利率 */
	PmShdAdjOptionEnum pmShdAdjOpt = PmShdAdjOptionEnum.NULL;

	// 获取还款计划调整方式
	public PmShdAdjOptionEnum getPmShdAdjOpt() {
		return pmShdAdjOpt;
	}

	/**
	 * 核算分类
	 *
	 * @return 核算分类
	 */
	public String getGlRoleCde() {
		return loan.getLoanGlRoleCde();
	}

	// 设置还款计划调整方式
	public void setPmShdAdjOpt(PmShdAdjOptionEnum pmShdAdjOpt) {
		this.pmShdAdjOpt = pmShdAdjOpt;
	}

	/**
	 * 上次付款日
	 *
	 * @return 上次付款日
	 */
	public String getPriorPaydate() {
		return loan.getLastSetlDt();
	}

	/**
	 * 日终程序会自动变化。
	 *
	 * @return 当前应付款日。根据业务时间和付款频率来计算的付款日
	 */
	public String getCurDuePaymentDate() {
		return this.getLoan().getCurDueDt();
	}

	// 获取借据对象
	public LmLoan getLoan() {
		return loan;
	}

	// 获取合同对象
	public LmLoanCont getLoanCont() {
		return loanCont;
	}

	// 合同对象
	private LmLoanCont loanCont = null;
	// 从命名表对象
	private LoanRate loanRate;
	// 基准利率
	private double intRate = -2;
	// 贷款品种核算参数map
	private PLoanTypGlMap pLoanTyp;
	// 贷款品种核算参数
	private PLoanTypGl pLoanTypGl;
	// 罚息日利率
	private double odRateDayly = -2;
	// 还款顺序
	private Byte paymentOrdSeq = -2;
	// 利率浮动日志列表属性
	private List<LmLnRepcLog> repcLogList = null;
	// 当前期还款计划
	private LmPmShd curr_shd;
	private Double loanNormOsPrcp;// 当前剩余正常本金
	private String normIntStartDt; // 正常状态下，当前业务日期调整时对应期的起息日
	/**
	 * 当前应还期的上一期
	 */
	private int preDuePerdNo = -1;

	// 获取当前期还款计划
	public LmPmShd getCurr_shd() {
		return curr_shd;
	}

	// 设置当前期还款计划
	public void setCurr_shd(LmPmShd curr_shd) {
		this.curr_shd = curr_shd;
	}

	// 从命名表对象构造函数
	public LoanRelateService(LmLoan loan, LmLoanCont loanCont) {
		super();
		this.loan = loan;
		this.loanCont = loanCont;

	}

	// 从命名表对象构造函数
	public LoanRelateService(LmLoan loan) {
		super();
		this.loan = loan;
	}

	// 获取从命名表对象
	public LoanRate getLoanRate() {
		if (loanCont == null) {
			throw new MinosException("没有借据合同");
		}
		if (this.loanRate == null) {
			this.loanRate = new LoanRate(loan, loanCont);
		}
		return loanRate;
	}
}
