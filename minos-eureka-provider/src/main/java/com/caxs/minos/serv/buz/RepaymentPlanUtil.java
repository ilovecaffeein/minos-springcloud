package com.caxs.minos.serv.buz;

import com.caxs.minos.date.DateOperation;
import com.caxs.minos.def.LoansConst;
import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.LmPmShdId;
import com.caxs.minos.domain.trans.RepaymentPlanTrans;
import com.caxs.minos.domain.trans.ShdMtdTrans;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.utils.ObjectUtil;
import com.caxs.minos.utils.RoundingUtil;
import com.yuchengtech.ycloans.common.enumeration.PaymentFreq;
import org.springframework.util.StringUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * @ClassName: RepaymentPlanUtil
 * @Description: 计算还款计划相关工具方法
 * @Author: coffee
 * @Date: 2020/7/29 10:40
 * @Version: v1.0 文件初始创建
 */
public class RepaymentPlanUtil {
    private static final int MAX_DAY_OF_MONTH = 31;

    /**
     * @Description: 按当前期实际天数计算期供利息
     * @param totalAmt 本金总额
     * @param yearlyRate 年利率
     * @param repayStartTime 当前期还款开始时间
     * @param repayEndTime 当前期还款截止时间
     * @Date: 2020/7/30 14:17
     * @Author: zhuruilong
     * @Return double
     * @Throws
     */
    public static BigDecimal calculateMonthlyInterestByDay(
            BigDecimal totalAmt, BigDecimal yearlyRate,
                             String repayStartTime, String repayEndTime) {
        // 计算当前期总天数
        long intervalDays = DateOperation.DateCal(repayEndTime, repayStartTime);
        // 计算天利息
        BigDecimal dailyRate = yearlyRate.divide(BigDecimal.valueOf(360), LoansConst.DEFAULT_AMT_COMPARE_DIGTIAL_COUNT,RoundingMode.HALF_UP);
        // 计算期供利息
        BigDecimal monthlyInterest = totalAmt.multiply(dailyRate).multiply(BigDecimal.valueOf(intervalDays));
        return RoundingUtil.roundingBigDecimal(monthlyInterest);

    }

    /**
     * @param reverseAmt
     * @param term 当前还款期次,等额本金方式下该数据不参与计算
     * @Description: 计算每月还款本金
     * @Date: 2020/8/4 15:47
     * @Author: zhuruilong
     * @Return double
     * @Throws
     */
    public  static BigDecimal calculateMonthlyAndPrincipal(
            BigDecimal reverseAmt, int term) {
        return RoundingUtil.roundingBigDecimal(reverseAmt.divide(
                new BigDecimal(term),9,BigDecimal.ROUND_HALF_UP));
    }

    /**
     * @param reserveAmt
     * @Description: 计算每月应还利息 计算公式 (本金总额 - 已还本金) * 月利率 或 (本金总额 - 已还本金) * (年利率 / 12)
     * @Date: 2020/8/4 15:48
     * @Author: zhuruilong
     * @Return double
     * @Throws
     */
    public static  BigDecimal calculateMonthlyInterest(
            BigDecimal reserveAmt ,BigDecimal loanIntRate) {
        BigDecimal monthlyRate = loanIntRate.divide(BigDecimal.valueOf(12),LoansConst.DEFAULT_AMT_COMPARE_DIGTIAL_COUNT,BigDecimal.ROUND_HALF_UP);
        return reserveAmt.multiply(monthlyRate);
    }

    /**
     * @param repaymentParam   月还款本金
     * @param monthlyPrincipal 月还款本金
     * @param monthlyInterest  月应还利息
     * @Description: 计算每月应还总额, 等额本息还款方式下每月还款本金与每月利率不参与运算
     * @Date: 2020/8/4 15:49
     * @Author: zhuruilong
     * @Return BigDecimal
     * @Throws
     */
    public static BigDecimal calculateMonthlyTotalAmt(ShdMtdTrans repaymentParam,
                                     BigDecimal monthlyPrincipal, BigDecimal monthlyInterest) {
        BigDecimal monthlyRate = repaymentParam.getLoanIntRate()
                .divide(BigDecimal.valueOf(12), LoansConst.DEFAULT_AMT_COMPARE_DIGTIAL_COUNT, RoundingMode.HALF_UP);
        int terms = repaymentParam.getMtdInstl();
        double pow = Math.pow(1 + repaymentParam.getLoanIntRate().doubleValue(), terms);
        return repaymentParam.getTermPrcpAmt().multiply(monthlyRate).multiply(
                BigDecimal.valueOf(pow)).divide(BigDecimal.valueOf(pow - 1), 2, RoundingMode.HALF_UP);
    }

    /**
     * @param repaymentParam
     * @param term
     * @Description: 计算每月还款本金 B=a*i(1+i)^(n-1)/[(1+i)^N-1]
     * @Date: 2020/8/4 15:47
     * @Author: zhuruilong
     * @Return double
     * @Throws
     */
    public static  BigDecimal calculateMonthlyPrincipal(ShdMtdTrans repaymentParam, int term) {
        BigDecimal monthlyRate = repaymentParam.getLoanIntRate().divide(BigDecimal.valueOf(12), LoansConst.DEFAULT_AMT_COMPARE_DIGTIAL_COUNT, RoundingMode.HALF_UP);
        int terms = repaymentParam.getMtdInstl();
        return repaymentParam.getTermPrcpAmt().multiply(monthlyRate)
                .multiply(BigDecimal.valueOf(Math.pow(1+monthlyRate.doubleValue(),(term - 1))))
                .divide(BigDecimal.valueOf(Math.pow(1+monthlyRate.doubleValue(),terms)-1), 2, RoundingMode.HALF_UP);
    }

    /**
     * 每月本息金额  = (贷款本金×月利率×(1＋月利率)＾还款月数)÷ ((1＋月利率)＾还款月数-1))
     * @param invest 贷款本金
     * @param yearRate 年利率
     * @param totalmonth  还款总月数
     * @Throws
     */
    public static BigDecimal calculateBigDeMonthlyPeriodic(BigDecimal invest, BigDecimal yearRate,int totalmonth){
        BigDecimal  monthlyRate = yearRate.divide(BigDecimal.valueOf(12), LoansConst.DEFAULT_AMT_COMPARE_DIGTIAL_COUNT, RoundingMode.HALF_UP);
        return invest.multiply(monthlyRate)
                .multiply(BigDecimal.valueOf(Math.pow(1+monthlyRate.doubleValue(),totalmonth)))
                .divide(BigDecimal.valueOf(Math.pow(1+monthlyRate.doubleValue(),totalmonth)-1), 2, RoundingMode.HALF_UP);
    }

    /**
     * 每月剩余本金  = 上一次贷款本金 - 当前本金
     * @param left1 上一次贷款本金
     * @param left2 当前本金
     * @Date: 2020/7/28 17:02
     * @Throws
     */
    public static double calculateMonthlyRemPrcp(double left1, double left2){
        BigDecimal dec1 = RoundingUtil.getBigDecimal(left1,
                MinosConst.DEFAULT_AMT_COMPARE_DIGTIAL_COUNT + 1);
        BigDecimal dec2 = RoundingUtil.getBigDecimal(left2,
                MinosConst.DEFAULT_AMT_COMPARE_DIGTIAL_COUNT + 1);
        BigDecimal dec3 = dec1.subtract(dec2);
        return dec3.doubleValue();
    }


    /**
     * 实际天数利息  = 剩余本金  * 贷款日利率  * 天数
     * @param lastRemPrcp  剩余本金
     * @param yearRate     年利率
     * @param starDate     开始日期
     * @param endDate      结束日期
     * @return             每月利息
     * @Throws
     */
    public static  BigDecimal calculateMonthlyActualInterest(BigDecimal lastRemPrcp,
                          BigDecimal yearRate, String starDate, String endDate){
        long  intervalDays = DateOperation.DateCal(endDate, starDate);
        BigDecimal monthlyRate = yearRate.divide(BigDecimal.valueOf(360), LoansConst.DEFAULT_AMT_COMPARE_DIGTIAL_COUNT, RoundingMode.HALF_UP);
        BigDecimal  monthInterest = lastRemPrcp.multiply(monthlyRate).multiply(new BigDecimal(intervalDays));
        return RoundingUtil.roundingBigDecimal(monthInterest);
    }

    /**
     * @Description: 最后到期日
     * @Date: 2020/7/29 10:51
     * @param startDate
     * @param freq
     * @param freqUnit
     * @param dueDay
     * @return
     */
    public static Date getDayByPaymentFreq(String startDate, String freq,
                                           int freqUnit, int dueDay) {
        return getDayByPaymentFreq(DateOperation.parseStringToDate(startDate), freq, freqUnit, dueDay);
    }

    /**
     * @Description: 最后到期日
     * @Date: 2020/7/29 10:51
     * @param startDate
     * @param freq
     * @param freqUnit
     * @param dueDay
     * @return
     */
    public static Date getDayByPaymentLastFreq(String startDate, String freq,
                                           int freqUnit, int dueDay) {
        return getDayByPaymentLastFreq(DateOperation.parseStringToDate(startDate), freq, freqUnit, dueDay);
    }

    /**
     * @Description: 获取还款日期频率
     * @Date: 2020/7/29 10:51
     * @param startDate
     * @param freq
     * @param freqUnit
     * @param dueDay
     * @return
     */
    public static Date getDayByPaymentFreq(Date startDate, String freq, int freqUnit, int dueDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.MONTH, freqUnit);
        return adjustByDueDay(cal.getTime(), dueDay);
    }

    /**
     * @Description: 获取还款日期频率
     * @Date: 2020/7/29 10:51
     * @param startDate
     * @param freq
     * @param freqUnit
     * @param dueDay
     * @return
     */
    public static Date getDayByPaymentLastFreq(Date startDate, String freq, int freqUnit, int dueDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.MONTH, freqUnit);
        return adjustByLastDueDay(cal.getTime(), dueDay);
    }

    /**
     * @Description: 如果起息日是31,但是到了2月却只有28天，加频率加出来就有问题。
     * @Date: 2020/7/29 10:51
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
     * @Description: 如果起息日是31,但是到了2月却只有28天，加频率加出来就有问题。
     * @Date: 2020/7/29 10:51
     * @param result
     * @param dueDay
     * @return
     */
    public static Date adjustByLastDueDay(Date result, int dueDay) {
        Calendar newResult = Calendar.getInstance();
        newResult.setTime(result);
        return adjustByLastDueDay(newResult, dueDay).getTime();
    }

    /**
     * @Description: 如果起息日是31,但是到了2月却只有28天，加频率加出来就有问题。
     * @Date: 2020/7/29 10:51
     * @param result
     * @param dueDay
     * @return
     */
    public static Calendar adjustByLastDueDay(Calendar result, int dueDay) {
        if ( dueDay > 28 ) {
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

    /**
     * @Description: 如果起息日是31,但是到了2月却只有28天，加频率加出来就有问题。
     * @Date: 2020/7/29 10:51
     * @param result
     * @param dueDay
     * @return
     */
    public static Calendar adjustByDueDay(Calendar result, int dueDay) {
        if ( dueDay > 28 ) {
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
     * @Description: 如果还款日在31号，则每个月还款日取当月最后一天。
     * @Date: 2020/7/29 10:51
     * @param result
     * @return
     */
    public static String adjustPsDueDay(Date  result) {
        Date date2 = DateOperation.getLastDayInMonth(result) ;
        if( result.compareTo(date2) > 0 )
            return DateOperation.formatDate(date2);
        return DateOperation.formatDate(result);
    }


    /**
     * @Description: 计算还款计划中的约定还款时间
     * @param firstRepaymentDate
     * @param totalTerms
     * @Date: 2020/7/29 10:51
     * @Author: zhuruilong
     * @Return java.util.List<java.lang.String>
     * @Throws 
     */
    public static List<String> calculateRepaymentTime(Date firstRepaymentDate, int totalTerms) {
        List<String> repaymentTime = new ArrayList(totalTerms);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstRepaymentDate);
        // 首期还款日
        int firstRepaymentDay = calendar.get(Calendar.DAY_OF_MONTH);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 1; i <= totalTerms; i++) {
            calendar.add(Calendar.MONTH, 1);
            // 如果首期还款日为31号，则将后续还款日中存在31号的日期设置为31号
            if (firstRepaymentDay == MAX_DAY_OF_MONTH && calendar.getMaximum(Calendar.DAY_OF_MONTH) == MAX_DAY_OF_MONTH) {
                calendar.set(Calendar.DAY_OF_MONTH, MAX_DAY_OF_MONTH);
            }
            repaymentTime.add(format.format(calendar.getTime()));
        }
        return repaymentTime;
    }


    /**
     * @Description: 计算还款计划中的约定还款时间
     * @param repaymentParam 还款方式参数明细
     * @Date: 2020/7/29 10:51
     * @Author: coffee
     * @Return java.util.List<java.lang.String>
     * @Throws
     */
    public static List<String> calculateRepaymentTimeList(ShdMtdTrans repaymentParam) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateOperation.parseStringToDate(repaymentParam.getIntStartDt()));

        int loanDay = calendar.get(Calendar.DAY_OF_MONTH);
        int dueDay = repaymentParam.getPayDay();
        // 根据期供标识计算首期还款日，Y表示下月为第一期还款日，N表示本月为第一期；
        // 且还款日在本月计息日之后，首期还款日为本月还款
        String firstPayDate ="";
        if( StringUtils.isEmpty(repaymentParam.getFirstPayDate())){
            if (YnFlagEnum.NO.getCodeInDb().equalsIgnoreCase(repaymentParam.getInstmInd()) && dueDay > loanDay) {
                calendar.set(Calendar.DAY_OF_MONTH, dueDay);
                repaymentParam.setMtdInstl(repaymentParam.getMtdInstl() + 1);
            } else {
                calendar.set(Calendar.DAY_OF_MONTH, dueDay);
                calendar.add(Calendar.MONTH, 1);
            }
            //首次还款日
            firstPayDate = DateOperation.formatDate(calendar.getTime());
        }else {
            if ("N".equalsIgnoreCase(repaymentParam.getInstmInd()) ) {
                repaymentParam.setMtdInstl(repaymentParam.getMtdInstl() + 1);
            }
            //首次还款日
            firstPayDate = DateOperation.formatDate(calendar.getTime());
        }

        //如果是提前还款需要补还款日
        List<String> repaymentTime = new ArrayList(repaymentParam.getMtdInstl() + 1);
        for( int i=0 ;  i < repaymentParam.getNextMtdInstl(); i ++ )
            repaymentTime.add(repaymentParam.getFirstPayDate());

        // 本月计息日日期
        int freqUnit = repaymentParam.getMtdInstl() - repaymentParam.getNextMtdInstl();
        /*****************计算末期是否需要二次还款
         * 例如 ：2020-12-18是合同到日期，还款日是每个月15号，则
         * 如果 等于 Y ，则标识。2020-12-18  当月末期还款日
         * 如果 等于 N ，则标识。2020-12-15  为还款日，2020-12-18 号为末期还款日
         */
        //获取期供到日期
        String lastMinDt = "";
        if ( YnFlagEnum.YES.getCodeInDb().equalsIgnoreCase(repaymentParam.getLastTmInd()))
            lastMinDt = DateOperation.formatDate(getDayByPaymentFreq(firstPayDate, "M", --freqUnit, dueDay));

        //设置计息日为第0期
        repaymentTime.add(repaymentParam.getIntStartDt());
        // 获取最后到日期
        String lastDueDt = repaymentParam.getLastDueDt();
        if ( ObjectUtil.stringIsNullOrBlank(lastDueDt) ) {
            int intDay = DateOperation.getDay(repaymentParam.getIntStartDt());
            freqUnit = repaymentParam.getMtdInstl();
            //获取合同到日期
            lastDueDt = DateOperation.formatDate(getDayByPaymentLastFreq(firstPayDate,"M", --freqUnit, intDay));
        }
        //计算首期账单日
        Date date = DateOperation.parseStringToDate(firstPayDate);
        //计算最后一期账单日
        Date lastDueDate = DateOperation.parseStringToDate(lastDueDt);
        if ( ! ObjectUtil.stringIsNullOrBlank(lastMinDt))
            lastDueDate = DateOperation.parseStringToDate(lastMinDt);
        while (true) {
            if (date.before(lastDueDate)) {
                repaymentTime.add(adjustPsDueDay(date));
                date = getDayByPaymentFreq(date, "M", 1, dueDay);
            } else
                break;
        }
        repaymentTime.add(lastDueDt);
        return repaymentTime;
    }

    /**
     * 初始化还款计划
     * @param psPerdNo     期次
     * @param loanNO       借据号
     * @param psDueDt      到日期
     * @param psInstmAmt   期供金额
     * @param psPrcpAmt    应还本金
     * @param psNormIntAmt 应还利息
     * @param psRemPrcp    剩余本金
     * @return             lmPmShd
     */
    public static RepaymentPlanTrans createRepaymentPlan(int psPerdNo, String loanNO ,
                                   String psDueDt, BigDecimal psInstmAmt, BigDecimal psPrcpAmt,
                                              BigDecimal psNormIntAmt , BigDecimal psRemPrcp, BigDecimal loanIntRate,BigDecimal psOdIntRate){
        RepaymentPlanTrans lmPmShd = new RepaymentPlanTrans();
        lmPmShd.setId(new LmPmShdId(loanNO,psPerdNo));
        lmPmShd.setPsDueDt(psDueDt);
        lmPmShd.setPsInstmAmt(psInstmAmt);
        lmPmShd.setPsPrcpAmt(psPrcpAmt);
        lmPmShd.setPsNormIntAmt(psNormIntAmt);
        lmPmShd.setPsRemPrcp(psRemPrcp);
        lmPmShd.setPsIntRate(loanIntRate);
        lmPmShd.setPsOdIntRate(psOdIntRate);
        return lmPmShd;
    }

    /**
     * 初始化还款计划
     * @param psPerdNo     期次
     * @param repaymentParam       还款方式参数明细
     * @param repaymentTime 到期日
     * @return  RepaymentPlanTrans 默认还款计划
     */
    public static RepaymentPlanTrans createDefaultRepaymentPlan(int psPerdNo, String repaymentTime,
                                                                ShdMtdTrans repaymentParam){
        RepaymentPlanTrans lmPmShd = new RepaymentPlanTrans();
        lmPmShd.setId(new LmPmShdId(repaymentParam.getLoanNo(),psPerdNo));
        lmPmShd.setPsDueDt(repaymentTime);
        lmPmShd.setPsInstmAmt(new BigDecimal(MinosConst.ZERO_DOUBLE));
        lmPmShd.setPsPrcpAmt(new BigDecimal(MinosConst.ZERO_DOUBLE));
        lmPmShd.setPsNormIntAmt(new BigDecimal(MinosConst.ZERO_DOUBLE));
        lmPmShd.setPsRemPrcp(repaymentParam.getTermPrcpAmt());
        lmPmShd.setPsIntRate(repaymentParam.getLoanIntRate());
        return lmPmShd;
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
                                               String lastDueDt, String freq, int dueDay, int freqUnit,
                                               boolean isFirstPerdOverOnePaymentFreq) {
        // 一次性还本付息。
        if (freq == PaymentFreq.NULL.getCodeInDb())
            return new String[] { lastDueDt };
        Set<String> set = new HashSet<String>();
        Date firstPayDate = DateOperation.getFirstPayDateByPaymentFreq(
                startDate, dueDay, PaymentFreq.getEnum(freq), freqUnit,
                isFirstPerdOverOnePaymentFreq);
        String fstPayDt = DateOperation.getDateStringToDb(firstPayDate);
        if (fstPayDt.compareTo(lastDueDt) >= 0) {
            return new String[] { lastDueDt };
        }
        set.add(fstPayDt);
        Date lastDueDate = DateOperation.parseStringToDate(lastDueDt);
        Date date = firstPayDate;
        while (true) {
            if (date.before(lastDueDate)) {
                set.add(DateOperation.getDateStringToDb(date));
                date = DateOperation.getDayByPaymentFreq(date, PaymentFreq.getEnum(freq), freqUnit,
                        dueDay);
                continue;
            } else
                break;
        }
        set.add(lastDueDt);
        String[] result = set.toArray(new String[0]);
        Arrays.sort(result);
        if (isFirstPerdOverOnePaymentFreq) {
            if (freq == PaymentFreq.MONTH.getCodeInDb()) {
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
            } else if (freq == PaymentFreq.QUATER.getCodeInDb()) {//期供类的最后一期修约 by shanyj
                if (result.length >= 2) {
                    if (DateOperation.isYearAndMonthSame(result[result.length-1],
                            result[result.length-2])) {
                        String[] result1 = new String[result.length - 1];
                        System.arraycopy(result, 0, result1, 0, result1.length);
                        result1[result1.length - 1] = lastDueDt;
                        return result1;
                    }
                }
            } else if (freq == PaymentFreq.WEEK.getCodeInDb()) {//期供类的最后一期修约 by shanyj
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
}
