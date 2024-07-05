package com.caxs.minos.utils;

import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.LmLoanCont;
import com.caxs.minos.domain.LmPmShd;
import com.caxs.minos.domain.PLoanTypGl;
import com.caxs.minos.enums.*;
import com.caxs.minos.exception.MinosException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.CollectionUtils;
import java.math.BigDecimal;
import java.util.List;

/**
 * 从命名表对象
 * Created by lenovo on 2020/8/14.
 */
public class LoanRelateUtils {
    // 打印日志属性
    private Log log = LogFactory.getLog(getClass());
    // 基准利率
    private double intRate = -2;
    // 从命名表对象
    private LoanRateUtils loanRate;

    // 借据对象属性
    private LmLoan lmLoan = null;

    // 合同对象
    private LmLoanCont loanCont = null;

    // 获取借据对象
    public LmLoan getLoan() {
        return lmLoan;
    }

    // 获取合同对象
    public LmLoanCont getLoanCont() {
        return loanCont;
    }

    //贷款所有利率
    private Double defaultLoanRate;

    // 贷款所有利率
    public Double getDefaultLoanRate() {
        return defaultLoanRate;
    }

    // 获取计算罚息部分
    public String getLoanOdCommPart() {
        return getLoanCont().getLoanOdCommPart();
    }

    // 获取贷款减值标志
    public YnFlagEnum getLoanDevaInd() {
        return YnFlagEnum.getEnum(lmLoan.getLoanDevaInd());
    }

    // 获取借据号
    public String getLoanNo() {
        return this.lmLoan.getLoanNo();
    }

    // 获取银行代码信息
    public String getBankCde() {
        return this.lmLoan.getBankCde();
    }

    // 获取机构代码信息
    public String getBchCde() {
        return this.lmLoan.getBchCde();
    }

    // 获取最后到期日
    public String getLastDueDt() {
        return this.lmLoan.getLastDueDt();
    }

    // 获取贷款逾期标志
    public String getLoanOdInd() {
        return this.lmLoan.getLoanOdInd();
    }

    // 获取从命名表对象
    public LoanRateUtils getLoanRate() {
        if (loanCont == null) {
            throw new MinosException("没有借据合同");
        }
        if (this.loanRate == null) {
            this.loanRate = new LoanRateUtils(this.lmLoan,
                    this.loanCont,cmpDayCountInOneYear());
        }
        return loanRate;
    }

    /**
     * 返回一年有多少天
     *
     * @return
     */
    public int cmpDayCountInOneYear() {
        int  dayCount = 360;
        if (this.loanCont == null)
            throw new MinosException("lmLoanCont can not null");
        String loanCcy = this.lmLoan.getLoanCcy();
        if ((loanCcy == null) || (loanCcy.trim().equals(""))) {
            throw new NullPointerException("查询的ccy代码不能为空");
        }
        return dayCount;
    }

    /**
     * 返回借据日利息
     *
     * @return 返回借据日利息
     */
    public double getIntRateDayly() {
        if (this.intRate < 0) {
            this.intRate = getLoanRate().getLendingRateDayly().doubleValue();
        }
        return intRate;
    }


    // 是否是委托贷款
    private Boolean tLoan = null;
    private Boolean fLoan = null;

    /**
     * 是否委托贷款
     *
     * @return
     */
    public boolean isTLoan() {
        if (this.tLoan == null) {
            this.tLoan = JobBussTypeEnum.TLOAN.equals(getJobBussTyp());
        }
        return tLoan;
    }

    // 获取贷款金额
    public BigDecimal getOrigPrcp() {
        return this.lmLoan.getOrigPrcp();
    }

    /**
     * 返回借据业务类型
     *
     * @return 返回借据业务类型
     */
    public JobBussType getJobBussTyp() {
        return JobBussType.getEnum(this.getLoan().getBussTyp());
    }


    /**
     * 调用此函数之前必须要先补计提,也就是psIncTaken已经是计提过的
     *
     * @param lps
     */
    public BigDecimal getUnsetlIncTaken(LmPmShd lps) {
        if (lps.getPsPerdNo() == 0) {
            return new BigDecimal(0);
        }
        BigDecimal setlNormInt = lps.getPsIncTaken().subtract(lps.getSetlIncTaken());
        setlNormInt = SystemUtils.getBigDecimalWhenEvenUp(setlNormInt);
        if (SystemUtils.isAmtLessThanZero(setlNormInt.doubleValue())) {
            throw new MinosException("结息金额不能小于零");
        }
        return setlNormInt;
    }


    /**
     * 是否委托贷款
     *
     * @return 是否委托贷款
     */
    public boolean isWTLoan() {
        return "TLOAN".equals(this.lmLoan.getBussTyp());
    }

    /**
     * 还款日
     *
     * @return
     */
    public int getDueDay() {
        return this.lmLoan.getDueDay();
    }

    // 获取还款间隔单位
    public String getPaymFreqUnit() {
        return this.lmLoan.getPaymFreqUnit();
    }

    // 获取还款间隔
    public int getPaymFreqFreq() {
        if (this.lmLoan.getPaymFreqFreq() == null) {
            return 1;
        } else {
            return this.lmLoan.getPaymFreqFreq().intValue();
        }

    }
    // 获取是否使用剩余本金计算利息
    public boolean isUseRemainPrcpToCalInterest() {
        return !("PPP".equals(this.lmLoan.getIntBase()));
    }

    // 提前还款利息计算基础
    AdvancePaymentIntBaseEnum pp = null;

    /**
     * 提前还按照剩余本金扣还是按照提前还本金
     *
     * @return
     */
    public AdvancePaymentIntBaseEnum getPpRatBase(PLoanTypGl pLoanTypGl) {
        if ( pp != null ) {
            return pp;
        }
        if (!isUseRemainPrcpToCalInterest()) {
            return AdvancePaymentIntBaseEnum.REMAINING_PRINCIPAL;
        }
        return AdvancePaymentIntBaseEnum.getEnum(pLoanTypGl.getGlPpRatBase());
    }


    /**
     * 剩余本金
     *
     * @return 剩余本金
     */
    public BigDecimal getLoanOsPrcp() {
        return this.getLoan().getLoanOsPrcp();
    }

    /**
     * 借据是否逾期
     *
     * @return
     */
    public boolean isLoanOverDate() {
        return LoanStateEnum.OVER.getCodeInDb().equals(lmLoan.getLoanDebtSts());

    }

    // 获取还款间隔
    public int getFreqenceRange() {
        return (int) Math.floor(lmLoan.getPaymFreqFreq());
    }

    /**
     * 假期利率调整
     * @param buzDate
     * @param holidayCount
     * @return
     */
    public boolean adjNormIntWhenHoliday(int holidayCount,String buzDate) {
        if (holidayCount <= 0) {
            return false;
        }
        return true;
    }


    /**
     * 首期是否超过一个期
     * @param pLoanTypGlList<PLoanTypGl>
     * @return
     */
    public  boolean isFirstPerdOverOnePaymentFreq(List<PLoanTypGl> pLoanTypGlList) {
        if (CollectionUtils.isEmpty(pLoanTypGlList)) {
            throw new MinosException("pLoanTypGl不能为空");
        }
        for (PLoanTypGl pLoanTypGl : pLoanTypGlList) {
            if (getLoan().getLoanTyp().equals(pLoanTypGl.getTypGl())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 还款频率，如果等于PaymentFreq.NULL，就表示一次性还本付息
     *
     * @return 还款频率，如果等于PaymentFreq.NULL，就表示一次性还本付息
     */
    public PaymentFreqEnum getPaymentFreq() {
        if ("05".equals(lmLoan.getLoanPaymTyp())) {
            return PaymentFreqEnum.NULL;
        }
        return PaymentFreqEnum.getEnum(lmLoan.getPaymFreqUnit());
    }


    // 从命名表对象构造函数
    public LoanRelateUtils(LmLoan lmLoan, LmLoanCont loanCont) {
        super();
        this.lmLoan = lmLoan;
        this.loanCont = loanCont;
        this.defaultLoanRate = lmLoan.getLoanOdIntRate().doubleValue();
    }

    // 从命名表对象构造函数
    public LoanRelateUtils(LmLoan lmLoan) {
        super();
        this.lmLoan = lmLoan;
    }

    /**
     * 是否在宽限期内 在宽限期内不扣罚息
     *
     * @param buzDate
     * @param lastOweDt 下次扣款日
     * @param isToPay
     *            是否扣款
     * @return
     */
    public boolean isInGraceDay(String buzDate,String lastOweDt, boolean isToPay) {
        int graceDay = getOdGraceDay(buzDate);
        if (graceDay == 0) {
            return false;
        }
        if (isToPay) {
            graceDay++;
        }
        if (graceDay < 0) {
            return false;
        }
        String graceDate = DateOperation.getDateIncDayCount(lastOweDt, graceDay);
        if (buzDate.compareTo(graceDate) < 0) {// 宽限期内
            if (log.isDebugEnabled()) {
                log.info("宽限期=" + graceDate);
            }
            return true;
        }
        return false;
    }

    /**
     * 是否在利息宽限期内 在利息宽限期内不扣复利
     *
     * @param lastOweDt 下次扣款日
     * @param isToPay
     *            是否扣款
     * @return
     */
    public boolean isInIntGraceDay(String buzDate,String lastOweDt,boolean isToPay) {
        int graceDay = getOdIntGraceDay(buzDate);
        if (graceDay == 0) {
            return false;
        }
        if (isToPay) {
            graceDay++;
        }
        if (graceDay < 0) {
            return false;
        }
        String graceDate = DateOperation.getDateIncDayCount(lastOweDt, graceDay);
        if (buzDate.compareTo(graceDate) < 0) {// 宽限期内
            if (log.isDebugEnabled()) {
                log.info("利息宽限期=" + graceDate);
            }
            return true;
        }
        return false;
    }


    // 获取宽限期天数
    public int getOdGraceDay(String buzDate) {
        if (loanCont.getLoanOdGrace() == null) {
            return 0;
        }
        if (YnFlagEnum.NO.getCodeInDb().equals(lmLoan.getLoanOdInd())) {
            if( lmLoan.getLastDueDt().equals(buzDate)|| DateOperation.compareTo(buzDate, lmLoan.getLastDueDt())){
                //最后到期日给予宽限期设置
                return loanCont.getLoanOdGrace();
            }
        }
        if ( 0 == MinosConst.GRACE_TYP_BY_DAY) { // 20200812带后续修改
            return loanCont.getLoanOdGrace();
        } else {
            if (loanCont.getLoanOdGrace() != 365) {// 该模式下，loan_od_grace必须为365，表示该笔贷款是月末宽限期
                return loanCont.getLoanOdGrace();
            }
            if (!DateOperation.isYearAndMonthSame(lmLoan.getNextDueDt(), buzDate)) {
                return 0;
            }
            String lastDayInMonth = DateOperation
                    .formatDate(DateOperation
                            .getLastDayInMonth(DateOperation
                                    .parseStringToDate(buzDate)));
            int graceDay = (int) DateOperation.DateCal(lastDayInMonth, lmLoan.getNextDueDt());
            return ++graceDay;
        }
    }

    // 获取罚息宽限期天数
    public int getOdIntGraceDay(String buzDate) {
        if (loanCont.getLoanOdIntGrace() == null) {
            return 0;
        }
        if (YnFlagEnum.NO.getCodeInDb().equals(lmLoan.getLoanOdInd())) {
            if( lmLoan.getLastDueDt().equals(buzDate)|| DateOperation.compareTo(buzDate, lmLoan.getLastDueDt())){
                //最后到期日给予宽限期设置
            }else{
                return 0;
            }
        }
        if ( 0 == MinosConst.GRACE_TYP_BY_DAY) { // 20200812带后续修改
            return loanCont.getLoanOdIntGrace();
        } else {
            if (loanCont.getLoanOdIntGrace() != 365) {// 该模式下，loan_od_grace必须为365，表示该笔贷款是月末宽限期
                return loanCont.getLoanOdIntGrace();
            }
            if (!DateOperation.isYearAndMonthSame(lmLoan.getNextDueDt(), buzDate)) {
                return 0;
            }
            String lastDayInMonth = DateOperation
                    .formatDate(DateOperation
                            .getLastDayInMonth(DateOperation
                                    .parseStringToDate(buzDate)));
            int graceDay = (int) DateOperation.DateCal(lastDayInMonth, lmLoan.getNextDueDt());
            return ++graceDay;
        }
    }


}
