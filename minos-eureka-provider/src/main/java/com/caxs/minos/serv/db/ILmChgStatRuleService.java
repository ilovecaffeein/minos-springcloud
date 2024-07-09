package com.caxs.minos.serv.db;

import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.LmPmShd;
import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
/***
 * @ClassName(类名) : ILmChgStatRuleService
 * @Description(描述) : 形态转移规则。
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface ILmChgStatRuleService {
    /**
     * 是否部分转表外
     *
     * @return
     */
     boolean isPartSusp();

    /**
     * 是否有表外
     */
     boolean isHasSusp();

    /**
     * 利息是否转逾期
     */
     boolean isHasOdInt();

    /**
     * 利息转表外天数条件。如果等于-1，那么不判断天数
     */
     int getIntSuspConditionDayes();

    /**
     * 本金转逾期天数条件。
     */
     int getPrcpDevConditionDayes();

    /**
     * 本金转非应计\利息转表外，需看本息状态，本金或利息逾期90天，本金状态可用逗号分隔
     */
     String getPrcpIntSuspPrcpIntStates();

    /**
     * 本金利息逾期，看利息状态，利息状态可用逗号分隔
     */
     String getPrcpIntOdIntStates();

    /**
     * 贷款到期后逾期结息方式 P:普通做法每月20号结息 M:按月结息，F:按原有频率结息
     */
     String getLoanOverToCalcOdTyp();

    /**
     * 本金\利息转非应计\表外，默认条件是本金或利息逾期>=90,并且本金状态非表外。
     *
     * @return 利息是否转表外 本金是否转非应计 (泰安利息或本金逾期90天，到当前所欠利息转表外 所有剩余未还本金转非应计)
     */
     boolean isPrcpIntChgToSusp(String psDueDt, String buzDate,
                                      String prcpState, String intState, LmLoan loan);

    /**
     * 非应计本金\表外利息转逾期， 条件1：本金或利息逾期<90,转表外标识还为Y 条件2：本金或利息逾期<90,并且本金状态非应计\利息为表外。
     *
     * @param buzDate
     *            当前业务日期
     * @param loan
     *            转表外标识
     * @param compLoanStpAccInd
     *            转表外标识
     * @return 还款至本金和利息的逾期天数<90天，非应计的未还正常本金转正常科目，逾期的回逾期科目;表外利息转回逾期科目
	 */
     boolean isPrcpIntChgToInner(String buzDate, LmLoan loan,
                                       String compLoanStpAccInd);

    /**
     * 默认条件是>=90,并且本金状态非表外。
     *
     * @return 利息是否转表外 本金是否转非应计 (泰安利息或本金逾期90天，利息转表外 所有剩余未还本金转非应计)
     */
     boolean isIntChgToSusp(String psDueDt, String buzDate,
                                  String prcpState, LmLoan loan);

    /**
     * 90天利息转表外，不记表内，贷款结息时用到
     *
     * @return 利息是否转表外
     */
     boolean isIntToSusp(LmPmShd shd, String buzDate, LmLoan loan);

    /**
     * 90天利息转逾期条件。
     *
     * @return 利息是否转表外
     */
     boolean isIntToOd(LmPmShd shd, String buzDate, LmLoan loan);

    /**
     * 借据没有转表外或非应计(本金或利息逾期90天)，本息状态都正常，当期未还转逾期；
     * 本或息有逾期90天，未到期的当期利息先转逾期后转非应计，本金不再转非应计
     *
     *
     * @return 当期本息是否转逾期
     */
     boolean isPrcpIntChgToOd(String psDueDt, String buzDate,
                                    String intState, double prcpIntAmt, double setlPrcpIntAmt,
                                    LmLoan loan);

    /**
     * 默认条件是>=90,并且本金状态非表外。
     *
     * @return 本金是否转逾期
     */
     boolean isPrcpChgToOd(String psDueDt, String buzDate,
                                 String prcpState, double prcpAmt, double setlPrcpAmt);

    // 设置形态转移条件天数
     void setSuspConditionDayes(int days);

    /**
     *按揭贷款部分转表外
     */
     boolean isInstmLoanPartSusp();

    /**
     * 转表外的时候是否清除计提
     * @return
     */
     boolean isClearIncTakenWhenSusp();
    /**
     * 采用形态转移转减值
     * @return
     */
     boolean isDevUsingLmChgState();

    /**
     * 只要小于90天逾期就转回正常。一般情况下把欠款还完转回正常贷款，
     * 如果为true，小于90天就需要转回
     * @return
     */
     boolean isSuspToNormWhenLessThan90();

    /**
     * 贷款形态转移: 贷款到期前：没有转表外可做形态转移；贷款转回；到期以后
     * @return
     */
    void listtransChgStatDBTrans(BatchJobContextTrans jobContext,SBch sbch);
}
