package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.LmLoanContDao;
import com.caxs.minos.dao.LmLoanDao;
import com.caxs.minos.dao.LmPmShdDao;
import com.caxs.minos.dao.PLoanTypGlDao;
import com.caxs.minos.def.DBConst;
import com.caxs.minos.def.ErrorCode;
import com.caxs.minos.def.LoanVarDef;
import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.LmLoanCont;
import com.caxs.minos.domain.LmPmShd;
import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.domain.trans.ChgStatDataTrans;
import com.caxs.minos.enums.LoanStateEnum;
import com.caxs.minos.enums.LoanStpAccIndEnum;
import com.caxs.minos.enums.PrcpAndIntStateEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.IBatchJoErrorLogService;
import com.caxs.minos.serv.db.ILmChgStatRuleService;
import com.caxs.minos.serv.db.ILoanEndOfDayDataFlowService;
import com.caxs.minos.utils.DateOperation;
import com.caxs.minos.utils.LoanRelateUtils;
import com.caxs.minos.utils.PayShchedueCalUtils;
import com.caxs.minos.utils.SystemUtils;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import java.math.BigDecimal;
import java.util.List;
/***
 * @ClassName(类名) : LmChgStatRuleDefaultService
 * @Description(描述) : 默认形态转移规则
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class LmChgStatRuleDefaultService implements ILmChgStatRuleService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    @Reference
    ILoanEndOfDayDataFlowService loanEndOfDayDataFlowService;

    @Reference
    IBatchJoErrorLogService batchJoErrorLogService;

    @Reference
    private PLoanTypGlDao pLoanTypGlDao;

    @Reference
    LmLoanDao lmLoanDao;

    @Reference
    LmLoanContDao lmLoanContDao;

    @Reference
    LmPmShdDao  lmPmShdDao;

    /**
     * 是否有表外
     */
    private boolean hasSusp = true;
    /**
     * 利息是否转逾期
     */
    private boolean hasOdInt = true;

    /**
     * 利息转表外天数条件。如果等于-1，那么不判断天数
     */
    private int intSuspConditionDayes = 90;

    /**
     * 本金转逾期天数条件。
     */
    private int prcpDevConditionDayes = 0;

    /**
     * 本金转非应计\利息转表外，需看本息状态，本金或利息逾期90天，本金状态可用逗号分隔
     */
    private String prcpIntSuspPrcpIntStates = "10,30";
    /**
     * 本金利息逾期90天以内是否转表内
     */
    private boolean prcpIntToInner = false;

    // 获取是本金利息逾期90天以内是否转表内
    public boolean isPrcpIntToInner() {
        return prcpIntToInner;
    }

    // 设置本金利息逾期90天以内是否转表内
    public void setPrcpIntToInner(boolean prcpIntToInner) {
        this.prcpIntToInner = prcpIntToInner;
    }

    /**
     * 本金利息逾期，看利息状态，利息状态可用逗号分隔
     */
    private String prcpIntOdIntStates = "10";

    /**
     * 贷款到期后逾期结息方式 P:普通做法每月20号结息 M:按月结息，F:按原有频率结息
     */
    private String loanOverToCalcOdTyp = "P";
    // 是否部分转表外
    private boolean partSusp = false;


    // 获取是否有表外
    public boolean isHasSusp() {
        return hasSusp;
    }

    // 设置是否有表外
    public void setHasSusp(boolean hasSusp) {
        this.hasSusp = hasSusp;
    }

    // 获取 利息是否转逾期
    public boolean isHasOdInt() {
        return hasOdInt;
    }

    // 设置 利息是否转逾期
    public void setHasOdInt(boolean hasOdInt) {
        this.hasOdInt = hasOdInt;
    }

    // 获取利息转表外天数条件
    public int getIntSuspConditionDayes() {
        return intSuspConditionDayes;
    }

    // 设置利息转表外天数条件
    public void setIntSuspConditionDayes(int intSuspConditionDayes) {
        this.intSuspConditionDayes = intSuspConditionDayes;
    }

    // 获取本金转逾期天数条件
    public int getPrcpDevConditionDayes() {
        return prcpDevConditionDayes;
    }

    // 设置本金转逾期天数条件
    public void setPrcpDevConditionDayes(int prcpDevConditionDayes) {
        this.prcpDevConditionDayes = prcpDevConditionDayes;
    }

    // 获取本金转非应计\利息转表外值条件
    public String getPrcpIntSuspPrcpIntStates() {
        return prcpIntSuspPrcpIntStates;
    }

    // 设置本金转非应计\利息转表外条件
    public void setPrcpIntSuspPrcpIntStates(String prcpIntSuspPrcpIntStates) {
        this.prcpIntSuspPrcpIntStates = prcpIntSuspPrcpIntStates;
    }

    // 获取本金利息逾期利息状态
    public String getPrcpIntOdIntStates() {
        return prcpIntOdIntStates;
    }

    // 设置本金利息逾期利息状态
    public void setPrcpIntOdIntStates(String prcpIntOdIntStates) {
        this.prcpIntOdIntStates = prcpIntOdIntStates;
    }

    // 获取贷款到期后逾期结息方式
    public String getLoanOverToCalcOdTyp() {
        return loanOverToCalcOdTyp;
    }

    // 设置贷款到期后逾期结息方式
    public void setLoanOverToCalcOdTyp(String loanOverToCalcOdTyp) {
        this.loanOverToCalcOdTyp = loanOverToCalcOdTyp;
    }

    // 设置利息转表外天数条件
    public void setSuspConditionDayes(int days) {
        this.setIntSuspConditionDayes(days);
    }

    // 设置是否部分转表外
    public void setPartSusp(boolean partSusp) {
        this.partSusp = partSusp;
    }

    // 获取是否部分转表外
    public boolean isPartSusp() {
        return partSusp;
    }

    private boolean instmLoanPartSusp = false;

    public boolean isInstmLoanPartSusp() {
        return instmLoanPartSusp;
    }

    public void setInstmLoanPartSusp(boolean instmLoanPartSusp) {
        this.instmLoanPartSusp = instmLoanPartSusp;
    }

    private boolean clearIncTakenWhenSusp = true;

    public boolean isClearIncTakenWhenSusp() {
        return clearIncTakenWhenSusp;
    }

    public void setClearIncTakenWhenSusp(boolean clearIncTakenWhenSusp) {
        this.clearIncTakenWhenSusp = clearIncTakenWhenSusp;
    }

    /**
     * 采用形态转移转减值，而不是LR01
     */
    private boolean devUsingLmChgState = true;

    public boolean isDevUsingLmChgState() {
        return devUsingLmChgState;
    }

    public void setDevUsingLmChgState(boolean devUsingLmChgState) {
        this.devUsingLmChgState = devUsingLmChgState;
    }

    private boolean suspToNormWhenLessThan90=true;

    public boolean isSuspToNormWhenLessThan90() {
        return suspToNormWhenLessThan90;
    }

    public void setSuspToNormWhenLessThan90(boolean suspToNormWhenLessThan90) {
        this.suspToNormWhenLessThan90 = suspToNormWhenLessThan90;
    }



    /**
     * 贷款形态转移: 贷款到期前：没有转表外可做形态转移；贷款转回；到期以后
     * @param jobContext
     */
    @Override
    public void listtransChgStatDBTrans(BatchJobContextTrans jobContext,SBch sbch){
        LmLoanCont lmLoanCont = null;
        List<LmLoan> loanList = null;
        // 更改没有扣到款的贷款逾期标志为Y
        lmLoanDao.updateLoanOdInd(sbch.getBchCde(),jobContext.getBuzDate());

        lmLoanDao.updateShapeTransPageFlag(sbch.getBchCde(),jobContext.getBuzDate());
        do {
            loanList = lmLoanDao.findLmLoanByNextSynRateDt(sbch.getBchCde(),jobContext.getBuzDate());
            if (log.isDebugEnabled())
                log.debug("待处理形态转移" + loanList.size() + "条");
            for (LmLoan lmloan : loanList) {
                lmLoanCont = lmLoanContDao.selectOneByLoanContNo(lmloan.getLoanContNo());
                LoanRelateUtils loanRelate = new LoanRelateUtils(lmloan, lmLoanCont);
                loanRelate.getLoan().setPrcsPageDtInd(YnFlagEnum.YES.getCodeInDb());
                lmLoanDao.update(loanRelate.getLoan());
                try {
                    if (loanRelate.getLoanCont() == null) {
                        continue;
                    }
                    if ( loanRelate.getLoanCont().getLoanTyp() == null) {
                        continue;
                    }
                    saveChgStatDBTrans(jobContext,loanRelate);
                } catch (MinosException e) {
                    batchJoErrorLogService.saveErrLogNoIncCount(lmloan.getLoanNo(),jobContext.getBuzDate(),
                            jobContext.getJobExe(),"处理错误借据号 [" + lmloan.getLoanNo() +
                                    " ] 错误, 错误信息 [ " + e.getMessage() + " ]", ErrorCode.ERROR00009);
                    e.printStackTrace();
                } catch (RuntimeException re) {
                    batchJoErrorLogService.saveErrLogNoIncCount(lmloan.getLoanNo(),jobContext.getBuzDate(),
                            jobContext.getJobExe(),"处理错误借据号 [" + lmloan.getLoanNo() +
                                    " ] 错误, 错误信息 [ " + re.getMessage() + " ]", ErrorCode.ERROR00009);
                    re.printStackTrace();
                }
            }
        } while (loanList.size() == DBConst.PAGE_RECORD);
    }


    /**
     * 对某一笔贷款做形态转移
     * @param jobContext
     * @param loanRelate
     */
    public void saveChgStatDBTrans(BatchJobContextTrans jobContext,LoanRelateUtils loanRelate) {
        String loanType = loanRelate.getLoanCont().getLoanTyp();
        if (loanType == null) {
            throw new MinosException("指定的贷款合同已经被删除。");
        }
        if (log.isDebugEnabled()) {
            log.info("lastDueDt=" + loanRelate.getLoan().getLastDueDt());
        }
        try {
            // 更新代款信息
            ChgStatDataTrans chgStatData = new ChgStatDataTrans();
            chgStatData.setHolidayCount(jobContext.getHolidayCount());
            updatePmShdStat(loanRelate, chgStatData, jobContext);
            updateLoanAndAccount(loanRelate,chgStatData, jobContext);
        } catch (Exception e) {
            throw new MinosException("更改贷款信息失败", e);
        }
    }


    /**
     * 更改贷款信息表
     * @param loanRelate
     *            贷款对象
     * @param chgStatData
     * @param jobContext
     */
    private void updateLoanAndAccount(LoanRelateUtils loanRelate,
                                      ChgStatDataTrans chgStatData, BatchJobContextTrans jobContext){
        String  accrueDate = jobContext.getBuzDate();
        if (isLoanPrcpChgTo(chgStatData, accrueDate, loanRelate, jobContext)){
            chgStatData.setOver(true);
            if (!LoanStateEnum.ACTIVE.equals(loanRelate.getLoan().getLoanSts())) {
                throw new MinosException("借据:" + loanRelate.getLoanNo() + "未结清贷款状态不正确");
            }
            loanRelate.getLoan().setLoanDebtSts(LoanStateEnum.OVER.getCodeInDb());
            /* 更换利率为逾期利率 */
            /****************************************
            loanRelate.getLoan().setOdRateAdjPct(loanRelate.getLoanCont().getLoanOdRateAdjPct1());
            if (loanRelate.getLoanCont().getLoanOdRateAdjPct1() == null) {
                throw new MinosException("逾期利率浮动比不允许为空");
            }
            if (loanRelate.getLoanCont().getLoanOdIntRate1() == null) {
                throw new MinosException("合同逾期利率不能为空");
            }
            loanRelate.getLoan().setLoanOdIntRate(loanRelate.getLoanCont().getLoanOdIntRate1());
            loanRelate.getLoan().setLastChgOdDt(jobContext.getBuzDate());
            ********************/
            lmLoanDao.update(loanRelate.getLoan());
        }
        if (loanRelate.isWTLoan()) {
            chgStatData.setHasAccount(false);
            return;
        }
        // 非应计转回正常或逾期，表外转回表内逾期
        if ( LoanStpAccIndEnum.RET.getCodeInDb().equals(loanRelate.getLoan().getLoanStpAccInd()) ) {
            updateShdStat(chgStatData.getPmShdList(), PrcpAndIntStateEnum.NONACCRUAL,
                    PrcpAndIntStateEnum.NORMAL);
            updateShdStat(loanRelate, accrueDate, PrcpAndIntStateEnum.NONACCRUAL,
                    PrcpAndIntStateEnum.NORMAL);
            chgStatData.setFirstSusp(false);
            chgStatData.setOver90Day(false);
            loanRelate.getLoan().setLoanStpAccInd(YnFlagEnum.NO.getCodeInDb());
            if (isDevUsingLmChgState()) {
                loanRelate.getLoan().setLoanDevaDt(null);
                loanRelate.getLoan().setLoanDevaInd("N");
            }
            lmLoanDao.update(loanRelate.getLoan());
            return;
        }
        // 本金拖欠
        if ( chgStatData.isPrcpOver() && jobContext.getJobExe().equals(LoanVarDef.LNPC)) {
            chgStatData.setHasAccount(true);
            updateShdStat(chgStatData.getPmShdList(), PrcpAndIntStateEnum.NORMAL,
                    PrcpAndIntStateEnum.NORMAL);
            // 如果借据处于未到期且后逾期90天后，
            // 扣款日当天正好是90天或者90天后的扣款日，则应先将应计利息H01入应收利息A01.
        }
        // 逾期90天将表内应收利息A01转表外应收A04
        if ( chgStatData.isOver90Day() && jobContext.getJobExe().equals(LoanVarDef.LNPC) ){
            // 找到将要还款的哪一期。
            if ( !isPartSusp() ){
                LmPmShd currDueDtShd = loanEndOfDayDataFlowService.findCurrDueDtShd(accrueDate);
                if ( isClearIncTakenWhenSusp()) {
                    currDueDtShd.setPsIncTaken(new BigDecimal(MinosConst.ZERO_DOUBLE));
                }
                currDueDtShd.setSetlIncTaken(currDueDtShd.getPsIncTaken());
                lmPmShdDao.update(currDueDtShd);
                if ( chgStatData.isFirstSusp() ) {
                    if ( !isPartSusp() ) {
                        loanRelate.getLoan().setLoanStpAccInd(
                                YnFlagEnum.YES.getCodeInDb());
                        if ( isDevUsingLmChgState() ) {
                            loanRelate.getLoan().setLoanDevaInd(YnFlagEnum.YES.getCodeInDb());
                            loanRelate.getLoan().setLoanDevaDt(jobContext.getBuzDate());
                        }
                    } else {
                        updateShdStat(loanRelate, accrueDate,
                                PrcpAndIntStateEnum.NORMAL, PrcpAndIntStateEnum.NONACCRUAL);
                    }
                    loanRelate.getLoan().setLoanStpAccDt(accrueDate);
                }
            }
        }
        if ( chgStatData.isNormIntOd() ) {
            if (!(loanRelate.getLoan().getLoanStpAccInd() != null
                    && !"".equals(loanRelate.getLoan().getLoanStpAccInd().trim()) && YnFlagEnum.YES.getCodeInDb().equals(
                    loanRelate.getLoan().getLoanStpAccInd().trim()))) {
                if (! isPartSusp()) {
                    loanRelate.getLoan().setLoanStpAccInd(YnFlagEnum.YES.getCodeInDb());
                    if ( isDevUsingLmChgState()) {
                        loanRelate.getLoan().setLoanDevaInd(YnFlagEnum.YES.getCodeInDb());
                        loanRelate.getLoan().setLoanDevaDt(jobContext.getBuzDate());
                    }
                }
                loanRelate.getLoan().setLoanStpAccDt(accrueDate);
            }
            if (chgStatData.isHasAccount()) {
                lmLoanDao.update(loanRelate.getLoan());
            }
        }
        if (chgStatData.isHasAccount() && (chgStatData.isPrcpOver() || chgStatData.isOver90Day())) {
            // 补正常结息
            if (chgStatData.isPrcpOver()) {
                if (LoanStateEnum.NORMAL.getCodeInDb().equals(loanRelate.getLoan().getLoanDebtSts())) {
                    loanRelate.getLoan().setLoanDebtSts(LoanStateEnum.DELQ.getCodeInDb());
                    lmLoanDao.update(loanRelate.getLoan());
                }
                if ( chgStatData.isSuppAcc() ) {
                    LmPmShd curDueShd = loanEndOfDayDataFlowService.findCurrDueDtShd(loanRelate.getLoanNo(),accrueDate);
                    BigDecimal accAmt = SystemUtils.getBigDecimalWhenEvenUp(
                            curDueShd.getPsIncTaken().subtract(curDueShd.getSetlIncTaken()));
                    if (SystemUtils.isAmtGreatThanZero(accAmt.doubleValue())) {
                        curDueShd.setSetlIncTaken(accAmt);
                        lmPmShdDao.update(curDueShd);
                    }
                }
            }
            lmLoanDao.update(loanRelate.getLoan());
        }
    }


    /**
     * 本金\利息转非应计\表外，默认条件是本金或利息逾期>=90,并且本金状态非表外。
     *
     * @return 利息是否转表外 本金是否转非应计 (泰安利息或本金逾期90天，到当前所欠利息转表外 所有剩余未还本金转非应计)
     */
    public boolean isPrcpIntChgToSusp(String psDueDt, String buzDate,
                                      String prcpState, String intState, LmLoan loan) {
        // 减值后的贷款不做
        if (!hasSusp) {
            return false;
        }
        boolean result = true;
        if (intSuspConditionDayes > 0) {
            result = (DateOperation.DateCal(buzDate, psDueDt) >= intSuspConditionDayes);
        }
        if (prcpIntSuspPrcpIntStates != null) {
            String[] cond = prcpIntSuspPrcpIntStates.split(",");
            boolean b = false;
            for (int i = 0; i < cond.length; i++) {
                b = b || (cond[i].equals(prcpState)) || (cond[i].equals(intState));
            }
            result = result && b;
        }
        return result;
    }

    /**
     * 非应计本金\表外利息转逾期， 条件1：本金或利息逾期<90,转表外标识还为Y 条件2：本金或利息逾期<90,并且本金状态非应计\利息为表外。
     *
     * @return 还款至本金和利息的逾期天数<90天，非应计的未还正常本金转正常科目，逾期的回逾期科目;表外利息转回逾期科目
	 */
    public boolean isPrcpIntChgToInner(String buzDate, LmLoan loan,
                                       String compLoanStpAccInd) {
        // 减值后的贷款不做
        if (!prcpIntToInner) {
            return false;
        }
        if (YnFlagEnum.YES.getCodeInDb().equals(loan.getLoanDevaInd())) {
            return false;
        }
        if (!hasSusp) {
            return false;
        }
        boolean result = false;
        if (YnFlagEnum.getEnum(loan.getLoanOdInd()) == YnFlagEnum.YES) {
            return false;
        }
        if (intSuspConditionDayes > 0) {
            result = (DateOperation.DateCal(buzDate, loan.getNextDueDt()) < intSuspConditionDayes);
        }

        result = result && compLoanStpAccInd.equals(loan.getLoanStpAccInd());
        return result;
    }

    /**
     * 默认条件是>=90,并且本金状态非表外。
     *
     * @return 利息是否转表外 本金是否转非应计 (泰安利息或本金逾期90天，利息转表外 所有剩余未还本金转非应计)
     */
    public boolean isIntChgToSusp(String psDueDt, String buzDate,
                                  String prcpState, LmLoan loan) {
        // 减值后的贷款不做
        if (YnFlagEnum.YES.getCodeInDb().equals(loan.getLoanDevaInd())) {
            return false;
        }
        if (!hasSusp) {
            return false;
        }
        boolean result = true;
        if (intSuspConditionDayes > 0) {
            result = (DateOperation.DateCal(buzDate, psDueDt) >= intSuspConditionDayes);
        }
        if (prcpIntSuspPrcpIntStates != null) {
            String[] cond = prcpIntSuspPrcpIntStates.split(",");
            boolean b = false;
            for (int i = 0; i < cond.length; i++) {
                b = b || (cond[i].equals(prcpState));
            }
            result = result && b;
        }

        return result;

    }

    /**
     * 90天利息转表外，不记表内，贷款结息时用到
     *
     * @return 利息是否转表外
     */
    public boolean isIntToSusp(LmPmShd shd, String buzDate, LmLoan loan) {
        // 减值后的贷款不做
        if (YnFlagEnum.YES.getCodeInDb().equals(loan.getLoanDevaInd())) {
            return false;
        }
        if (!hasOdInt) {
            return false;
        }
        if ((!(PrcpAndIntStateEnum.NORMAL.getCodeInDb().equals(shd.getIntState())) && !(PrcpAndIntStateEnum.DELQ
                .getCodeInDb().equals(shd.getIntState())))
                || (PrcpAndIntStateEnum.NONACCRUAL.getCodeInDb().equals(shd
                .getIntState()))) {
            return false;
        }
        boolean result = true;
        // 当前日期与计划到期日的差大于等于转表外天数，则条件成立
        if (intSuspConditionDayes > 0) {
            result &= (DateOperation.DateCal(buzDate, shd.getPsDueDt()) >= intSuspConditionDayes);
        }
        result &= SystemUtils.isAmtGreat(shd.getPsNormIntAmt().doubleValue(), shd
                .getSetlNormInt().doubleValue());
        return result;

    }

    /**
     * 90天利息转逾期条件。
     *
     * @return 利息是否转表外
     */
    public boolean isIntToOd(LmPmShd shd, String buzDate, LmLoan loan) {

        if (!hasOdInt) {
            return false;
        }
        // 减值后的贷款不做
        if (YnFlagEnum.YES.getCodeInDb().equals(loan.getLoanDevaInd())) {
            return false;
        }
        if (!(PrcpAndIntStateEnum.NORMAL.getCodeInDb().equals(shd.getIntState()))
                && !(PrcpAndIntStateEnum.DELQ.getCodeInDb().equals(shd
                .getIntState()))) {
            return false;
        }
        boolean result = true;
        // 当前日期与计划到期日的差大于等于转表外天数，则条件成立
        if (intSuspConditionDayes > 0) {
            result &= (DateOperation.DateCal(buzDate, shd.getPsDueDt()) >= intSuspConditionDayes);
        }
        // 正常利息要大于结清利息（即未结清利息大于0）
        result &= SystemUtils.isAmtGreat(
                shd.getPsNormIntAmt().doubleValue(), shd.getSetlNormInt().doubleValue());
        return result;

    }

    /**
     * 借据没有转表外或非应计(本金或利息逾期90天)，本息状态都正常，当期未还转逾期；
     * 本或息有逾期90天，未到期的当期利息先转逾期后转非应计，本金不再转非应计
     *
     *
     * @return 当期本息是否转逾期
     */
    public boolean isPrcpIntChgToOd(String psDueDt, String buzDate,
                                    String intState, double prcpIntAmt, double setlPrcpIntAmt,
                                    LmLoan loan) {
        boolean result = true;
        // 减值后的贷款不做
        if ( YnFlagEnum.YES.getCodeInDb().equals(loan.getLoanDevaInd()) ) {
            return false;
        }
        if ( prcpDevConditionDayes > 0 ) {
            result = (DateOperation.DateCal(psDueDt, buzDate) < prcpDevConditionDayes);
        }
        if ( prcpIntOdIntStates != null ) {
            String[] cond = prcpIntOdIntStates.split(",");
            boolean b = false;
            for (int i = 0; i < cond.length; i++) {
                b = b || (cond[i].equals(intState));
            }
            result = result && b;
        }
        result = result && (SystemUtils.isAmtGreatThanZero(prcpIntAmt));
        result = result && (SystemUtils.isAmtGreat(prcpIntAmt, setlPrcpIntAmt));
        return result;
    }

    /**
     * 默认条件是>=90,并且本金状态非表外。
     *
     * @return 本金是否转逾期
     */
    public boolean isPrcpChgToOd(String psDueDt, String buzDate,
                                 String prcpState, double prcpAmt, double setlPrcpAmt) {

        boolean result = true;
        if (prcpDevConditionDayes > 0) {
            result = (DateOperation.DateCal(psDueDt, buzDate) < prcpDevConditionDayes);
        }
        if (prcpIntOdIntStates != null) {
            String[] cond = prcpIntOdIntStates.split(",");
            boolean b = false;
            for (int i = 0; i < cond.length; i++) {
                b = b || (cond[i].equals(prcpState));
            }
            result = result && b;
        }
        result = result && (SystemUtils.isAmtGreatThanZero(prcpAmt));
        result = result && (SystemUtils.isAmtGreat(prcpAmt, setlPrcpAmt));
        return result;
    }


    /**
     * 根据还款计划表计算并更新逾期状态
     * @param loanRelate
     * @param chgStatData
     * @param jobContext
     */
    public void updatePmShdStat(LoanRelateUtils loanRelate, ChgStatDataTrans chgStatData,
                                 BatchJobContextTrans jobContext){
        int overDay = intSuspConditionDayes;
        String  accrueDate = jobContext.getBuzDate();
        List<LmPmShd> pmshdList = lmPmShdDao.findShapPmShdStat(
                                loanRelate.getLoanNo(), jobContext.getBuzDate());
        for (LmPmShd ps : pmshdList) {
            PayShchedueCalUtils cal = new PayShchedueCalUtils(ps, DateOperation
                    .parseStringToDate(jobContext.getBuzDate()));
            chgStatData.setDueDtDbTrans((DateOperation.DateCal(jobContext.getBuzDate(), ps
                    .getPsDueDt()) == 0 ? true : false));
            if (isPrcpIntChgToOd(
                            ps.getPsDueDt(),
                            jobContext.getBuzDate(),
                            ps.getIntState(),
                            SystemUtils.getBigDecimalfNull(ps.getPsPrcpAmt().add(ps.getPsNormIntAmt())),
                            SystemUtils.getBigDecimalfNull(ps.getSetlPrcp().add(ps.getSetlNormInt())),
                            loanRelate.getLoan())) {
                if (accrueDate.compareTo(loanRelate.getLastDueDt()) <= 0) {
                    if (YnFlagEnum.YES.getCodeInDb().equals(loanRelate.getLoanOdInd())) {
                        // 转逾期金额,本金逾期，增加利息
                        chgStatData.setHolidayProcessed(true);
                        if (!loanRelate.adjNormIntWhenHoliday(chgStatData.getHolidayCount(), accrueDate)) {
                            // 本金拖欠：当前业务日期大于下一次应扣款还款日(下次扣款时应该从哪一期开始扣收)
                            if (LoanStpAccIndEnum.NO.getCodeInDb().equals(
                                    loanRelate.getLoan().getLoanStpAccInd())) {
                                if (ps.getPrcpState() != null
                                        && PrcpAndIntStateEnum.NORMAL.getCodeInDb().equals(ps.getPrcpState().trim())) {// 未转过表外，则将当期本息转逾期
                                    if (PrcpAndIntStateEnum.NORMAL.getCodeInDb()
                                            .equals(ps.getPrcpState())) {
                                        ps.setPrcpState(PrcpAndIntStateEnum.LATE
                                                .getCodeInDb());
                                        lmPmShdDao.update(ps);
                                    }
                                    chgStatData.setDelqPrcp(chgStatData.getDelqPrcp() + cal.getPrcp());
                                    chgStatData.setNormInt(chgStatData.getNormInt() + cal.getNormInt());
                                    chgStatData.setCommInt(chgStatData.getCommInt() + cal.getCommInt());
                                }
                            } else if (LoanStpAccIndEnum.YES.getCodeInDb().equals(
                                    loanRelate.getLoan().getLoanStpAccInd())) {// 已有转表外，则只将当期利息转逾期
                                if (ps.getPrcpState() != null
                                        && PrcpAndIntStateEnum.NONACCRUAL.getCodeInDb().equals(ps.getPrcpState().trim())) {
                                    chgStatData.setNormInt(chgStatData.getNormInt() + cal.getNormInt());
                                    chgStatData.setCommInt(chgStatData.getCommInt() + cal.getCommInt());
                                }
                            } else if (LoanStpAccIndEnum.RET.getCodeInDb().equals(
                                    loanRelate.getLoan().getLoanStpAccInd())) {// 转回当天有转逾期
                                if (ps.getPrcpState() != null
                                        && ps.getIntState() != null
                                        && PrcpAndIntStateEnum.NONACCRUAL.getCodeInDb().equals(ps.getPrcpState().trim())
                                        && PrcpAndIntStateEnum.NORMAL.getCodeInDb().equals(ps.getIntState().trim())) {
                                    chgStatData.setDelqPrcp(chgStatData.getDelqPrcp() + cal.getPrcp());
                                    chgStatData.setNormInt(chgStatData.getNormInt() + cal.getNormInt());
                                    chgStatData.setCommInt(chgStatData.getCommInt() + cal.getCommInt());
                                }
                            } else {
                                batchJoErrorLogService.saveErrLogNoIncCount(loanRelate.getLoanNo(),jobContext.getBuzDate(),
                                        jobContext.getJobExe(),"借据的转表外标识有误[" + loanRelate.getLoanNo() +"]", ErrorCode.ERROR00009);
                            }
                            chgStatData.setPrcpOver(true);
                            chgStatData.setIntToOd(true);
                            chgStatData.setHasAccount(true);
                        }
                    }
                }
                //本金超过90天的数据->90
                if (isPrcpIntChgToSusp(loanRelate.getLoan().getNextDueDt(), accrueDate,
                                ps.getPrcpState(), ps.getIntState(), loanRelate.getLoan())) {
                    // 转表外利息
                    boolean isPartSusp =isPartSusp();
                    // 本金状态转非应计,利息状态转表外
                    if (!PrcpAndIntStateEnum.NONACCRUAL.getCodeInDb().equals(ps.getPrcpState())
                            || !PrcpAndIntStateEnum.NONACCRUAL.getCodeInDb().equals(ps.getIntState())) {
                        ps.setPrcpState(PrcpAndIntStateEnum.NONACCRUAL.getCodeInDb());
                        ps.setIntState(PrcpAndIntStateEnum.NONACCRUAL.getCodeInDb());
                        lmPmShdDao.update(ps);
                    }
                    if (!isPartSusp) {
                        chgStatData.setSuspNormInt(chgStatData.getSuspNormInt()
                                + cal.getPrcp());
                        chgStatData.setOdInt(chgStatData.getOdInt()
                                + cal.getNormInt() + chgStatData.getOdInt());
                    } else {
                        if (PrcpAndIntStateEnum.getEnum(ps.getIntState()) != PrcpAndIntStateEnum.NONACCRUAL) {
                            if (DateOperation.DateCal(jobContext.getBuzDate(), ps.getPsDueDt()) >= overDay) {
                                // 是否使用减值时候的利息
                                boolean isUseOldInt = true;
                                isUseOldInt &= loanRelate.getLoanDevaInd() == YnFlagEnum.YES;
                                if (isUseOldInt) {
                                    chgStatData.setSuspNormInt(chgStatData.getSuspNormInt()
                                            + SystemUtils.getBigDecimalfNull(cal.getLmPmShd().getPsIncTaken()));
                                    if (!PrcpAndIntStateEnum.NONACCRUAL.getCodeInDb()
                                            .equals(ps.getPrcpState())) {
                                        chgStatData.setSuspOdInt(chgStatData.getSuspOdInt()
                                                + SystemUtils.getBigDecimalfNull(cal.getLmPmShd().getGrcProdInt()));
                                    }
                                    chgStatData.setSuspCommInt(chgStatData.getSuspCommInt()
                                            + SystemUtils.getBigDecimalfNull(cal.getLmPmShd().getGrcProdInt()));
                                } else {
                                    chgStatData.setSuspNormInt(chgStatData.getSuspNormInt()
                                            + cal.getNormInt());
                                    if (!PrcpAndIntStateEnum.NONACCRUAL.getCodeInDb()
                                            .equals(ps.getPrcpState())) {
                                        chgStatData.setSuspOdInt(chgStatData.getSuspOdInt()
                                                + cal.getNormInt());
                                    }
                                    chgStatData.setCommInt(chgStatData.getCommInt()
                                            + cal.getNormInt());
                                    chgStatData.setIncTaken(chgStatData.getIncTaken()
                                            + SystemUtils.getBigDecimalfNull(ps.getPsIncTaken().add(ps.getSetlIncTaken())));
                                    chgStatData.setOdIncTaken(chgStatData.getOdIncTaken()
                                            + SystemUtils.getBigDecimalfNull(ps.getPsCurOdIncTaken()));
                                }
                            }
                        }
                    }
                    // 转表外罚息
                    // 转表外复利
                    chgStatData.setCommInt(chgStatData.getCommInt() + cal.getCommInt());
                    if (!(loanRelate.getLoan().getLoanStpAccInd() != null
                            && YnFlagEnum.YES.getCodeInDb().equals(loanRelate.getLoan().getLoanStpAccInd().trim()))) {
                        chgStatData.setFirstSusp(true);
                    }
                    chgStatData.setOver90Day(true);
                    chgStatData.setIntToOd(true);
                    chgStatData.setHasAccount(true);
                }
                if (isPrcpIntChgToInner(accrueDate, loanRelate.getLoan(), LoanStpAccIndEnum.RET.getCodeInDb())) {
                    // 考虑转回当天有转逾期情况，逾期的当期本金先转回正常再转逾期，利息不转回
                    if ( ps.getPrcpState() != null  && ps.getIntState() != null
                            && PrcpAndIntStateEnum.NORMAL.getCodeInDb().equals(ps.getPrcpState().trim())
                            && PrcpAndIntStateEnum.NONACCRUAL.getCodeInDb().equals(ps.getIntState().trim())) {
                        // 非应计表外转回
                        chgStatData.setOverPrcp(chgStatData.getOverPrcp() + cal.getPrcp());
                        chgStatData.setInnOdNormInt(chgStatData.getInnOdNormInt() + cal.getNormInt());
                        chgStatData.setHasAccount(true);

                        // 正常未到期的已转表外应计利息转回表内应计利息，剩余未转回部分补提上
                        if (pmshdList.get(pmshdList.size() - 1).getPsDueDt().compareTo(ps.getPsDueDt()) == 0) {
                            LmPmShd curDueShd =lmPmShdDao.findCurPayTerm(loanRelate.getLoanNo(), (int) (ps.getPsPerdNo().shortValue() + 1),
                                            loanRelate.getPpRatBase(pLoanTypGlDao.selectByPrimaryKey(
                                                    loanRelate.getLoan().getBankCde(),loanRelate.getLoan().getLoanTyp())).getCodeInDb());
                            if ( curDueShd != null ) {
                                chgStatData.setDueIncTaken(SystemUtils.getBigDecimalfNull(curDueShd.getPsIncTaken()));
                                chgStatData.setDueOdIncTaken(SystemUtils.getBigDecimalfNull(curDueShd.getPsCurOdIncTaken()));
                            }
                        }
                    }
                }
                if (isIntToOd(ps, accrueDate, loanRelate.getLoan())) {
                    chgStatData.setNormIntOd(true);
                    chgStatData.setCommInt(chgStatData.getCommInt()
                            + cal.getCommInt());
                    chgStatData.setNormInt(chgStatData.getNormInt()
                            + cal.getNormInt());
                    chgStatData.setHasAccount(true);
                    chgStatData.setFirstSusp(true);
                }
                if ( chgStatData.isHasAccount() ) {
                    chgStatData.setNormInt(SystemUtils.getDoubleWhenEvenUp(
                            chgStatData.getNormInt()));
                    chgStatData.setOdInt(SystemUtils.getDoubleWhenEvenUp(
                            chgStatData.getOdInt()));
                    chgStatData.setCommInt(SystemUtils.getDoubleWhenEvenUp(
                            chgStatData.getCommInt()));
                    chgStatData.setDelqPrcp(SystemUtils.getDoubleWhenEvenUp(
                            chgStatData.getDelqPrcp()));
                    chgStatData.setOverPrcp(SystemUtils.getDoubleWhenEvenUp(
                            chgStatData.getOverPrcp()));
                    chgStatData.setSuspCommInt(SystemUtils.getDoubleWhenEvenUp(
                            chgStatData.getSuspCommInt()));
                    chgStatData.setSuspNormInt(SystemUtils.getDoubleWhenEvenUp(
                            chgStatData.getSuspNormInt()));
                    chgStatData.setSuspOdInt(SystemUtils.getDoubleWhenEvenUp(
                            chgStatData.getSuspOdInt()));
                    chgStatData.setInnOdNormInt(SystemUtils.getDoubleWhenEvenUp(
                            chgStatData.getInnOdNormInt()));
                    chgStatData.setDueOdIncTaken(SystemUtils.getDoubleWhenEvenUp(
                            chgStatData.getDueOdIncTaken()));
                    chgStatData.setDueIncTaken(SystemUtils.getDoubleWhenEvenUp(
                            chgStatData.getDueIncTaken()));
                    chgStatData.setIncTaken(SystemUtils.getDoubleWhenEvenUp(
                            chgStatData.getIncTaken()));
                    chgStatData.setOdIncTaken(SystemUtils.getDoubleWhenEvenUp(
                            chgStatData.getOdIncTaken()));
                    // 未转过表外，首次转将当前未还所有剩余本金转非应计,
                    // 未还所有逾期利息转表外，已有转表外，只将利息当期利息转表外
                }
                chgStatData.setPmShdList(pmshdList);
            }
        }
    }




    /**
     * 整条贷款是否逾期
     *
     * @param buzDate
     * @param loanRelate
     * @return
     */
    private boolean isLoanPrcpChgTo(ChgStatDataTrans chgStatData, String buzDate,
                                    LoanRelateUtils loanRelate, BatchJobContextTrans jobContext) {
        boolean isOver = true;
        if (!StringUtils.hasText(loanRelate.getLoan().getLastDueDt())) {
            throw new MinosException("借据表的lastDueDt不能为空");
        }
        isOver = (buzDate.compareTo(loanRelate.getLastDueDt()) >= 0);
        return isOver;
    }


    /**
     * 更新状态从正常到逾期状态 更新状态从非应计\表外到逾期状态
     * @param shdList
     * @param fromState
     * @param toState
     */
    private void updateShdStat(List<LmPmShd> shdList,
                               PrcpAndIntStateEnum fromState, PrcpAndIntStateEnum toState) {
        if (!CollectionUtils.isEmpty(shdList)) {
            for (LmPmShd shd : shdList)
                if (YnFlagEnum.NO.getCodeInDb().equals(shd.getSetlInd())) {
                    shd.setIntState(shd.getIntState().equals(
                            fromState.getCodeInDb()) ? toState.getCodeInDb()
                            : shd.getIntState());
                    shd.setPrcpState(shd.getPrcpState().equals(
                            fromState.getCodeInDb()) ? toState.getCodeInDb()
                            : shd.getPrcpState());
                   lmPmShdDao.update(shd);
                }
        }
    }


    /**
     * 本或息逾期90天 ,更新当前业务时间以后的还款计划本金状态从正常到非应计状态;
     * 本或息逾期90天退回90天以内,更新当前业务时间以后的还款计划本金状态从非应计状态到正常
     *
     * @param loanRelate
     * @param accrueDate
     *            当前业务时间
     * @param fromPrcpState
     *            原来本金状态
     * @param toPrcpState
     *            新本金状态
     */
    private void updateShdStat(LoanRelateUtils loanRelate, String accrueDate,
                               PrcpAndIntStateEnum fromPrcpState, PrcpAndIntStateEnum toPrcpState) {
        List<LmPmShd> shdList = lmPmShdDao.findLmPmShdAfterPsDueDt(loanRelate.getLoanNo(), accrueDate);
        if (!CollectionUtils.isEmpty(shdList)) {
            for (LmPmShd shd : shdList)
                if (YnFlagEnum.NO.getCodeInDb().equals(shd.getSetlInd())) {
                    shd.setPrcpState(shd.getPrcpState().equals(
                            fromPrcpState.getCodeInDb()) ? toPrcpState
                            .getCodeInDb() : shd.getPrcpState());
                    lmPmShdDao.update(shd);
                }
        }
    }
}
