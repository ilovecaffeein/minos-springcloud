package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.*;
import com.caxs.minos.date.DateOperation;
import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.*;
import com.caxs.minos.domain.trans.*;
import com.caxs.minos.enums.CommPartEnum;
import com.caxs.minos.enums.LoanStateEnum;
import com.caxs.minos.enums.PaymentModeEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.buz.AccountUtils;
import com.caxs.minos.serv.buz.AdvPayMentLmPmShd;
import com.caxs.minos.serv.buz.AdvPayMentSetlmtLog;
import com.caxs.minos.serv.buz.payment.PaymentThisPeriodMoney;
import static com.caxs.minos.enums.PaymentModeEnum.ADVANCE;
import com.caxs.minos.serv.db.*;
import com.caxs.minos.utils.LoanRelateUtils;
import com.caxs.minos.utils.SystemUtils;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/***
 * @ClassName(类名) : PaymentNormMoneyService
 * @Description(描述) : 归还欠款入账，更新还款计划
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/5 11:34
 */
@Component
@Service
public class PaymentNormMoneyService implements IPaymentNormMoneyService {
    //打印日志属性
    private Log logg = LogFactory.getLog(getClass());

    @Reference
    private ISystemInfoService systemInfoService;

    @Reference
    CopyAdjustTablesToHisService copyAdjustTablesToHisService;

    @Reference
    ISplitPaymentExampleService splitPaymentExampleService;

    @Reference
    ICustomerEntryPerationService customerEntryPerationService;

    @Reference
    IEntryRuleConfiguraService entryRuleConfiguraService;

    @Reference
    LmLoanContDao lmLoanContDao;

    @Reference
    LmLoanDao lmLoanDao;

    @Reference
    LmPmShdDao lmPmShdDao;

    @Reference
    LmSetlmtLogDao lmSetlmtLogDao;

    @Reference
    LmLnShdMtdDao lmLnShdMtdDao;

    // 借据信息
    private LmLoan lmLoan;

    // 借据信息
    private LmPmShd lmPmShd;

    private LmSetlmtLog lmSetlmtLog;

    //当前扣款期号
    private Integer currDuePerd = -1;

    // 提前还是全部还是部分还款
    private PaymentModeEnum  paymentModeEnum;


    /**
     * @desc 金融公司先调用清算，再调用还款，将还款逻辑拆出来
     * @param lmSetlmtLog
     * @return
     * @author coffee
     */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public void saveLoanPayment(LmSetlmtLog lmSetlmtLog){

        setPaymentModeEnum(PaymentModeEnum.getEnum(lmSetlmtLog.getSetlMode()));
        LmLoan lmLoan = lmLoanDao.findByLoanNo(lmSetlmtLog.getLoanNo());
        if ( lmLoan == null ) {
            throw new MinosException("此借据无借据主表信息！");
        }
        String loanContractNumber = lmLoan.getLoanContNo();
        LmLoanCont lmLoanCont = lmLoanContDao.selectOneByLoanContNo(loanContractNumber);
        if ( lmLoanCont == null ) {
            throw new MinosException("此借据无合同主表信息！");
        }
        if ( LoanStateEnum.SETL.getCodeInDb().equals(lmLoan.getLoanSts())) {
            throw new MinosException("当前借据已还清！");
        }
        if ( lmSetlmtLog.getSetlMode().equals(PaymentModeEnum.ALL.getCodeInDb())
                || lmSetlmtLog.getSetlMode().equals(ADVANCE.getCodeInDb()) ){
            throw new MinosException(" 错误的还款方式！");
        }

        try {

            LoanRelateUtils loanRelate = new LoanRelateUtils(lmLoan, lmLoanCont);
            //构造数据备份
            copyAdjustTablesToHisService.toHis(lmLoan.getLoanNo(),lmSetlmtLog.getTxLogSeq());
            //初始化入账流水表
            List<LmSetlmtLog> lmSetlmtLogList = new ArrayList<LmSetlmtLog>();
            AdvPayMentSetlmtLog advLmSetlmtLog =new AdvPayMentSetlmtLog(lmSetlmtLog,loanRelate.getLoan());

            //根据当前贷款是否转表外LM_LOAN.LOAN_STP_ACC_IND 获取相应的还款顺序(针对表外或者表内)Y: 已转表外 N:未转表外
            PLoanTypGl pLoanTypGl = entryRuleConfiguraService.findBytypGlId(
                    loanRelate.getBankCde(),loanRelate.getLoan().getLoanTyp());
            String loanDeveOrd = String.valueOf(pLoanTypGl.getGlRpymMtd());

            /* 查询指定借据的小于等于当前业务日志日期没有结清的还款计划 */
            List<LmPmShd> lmPmShdList = new ArrayList<LmPmShd>();
            lmPmShdList = lmPmShdDao.findByLoanNoBeforePsDueDtWithoutSetl(lmSetlmtLog.getLoanNo(),lmSetlmtLog.getSetlValDt());
            if (lmPmShdList.size() < 0)
                throw new MinosException("还款计划表无数据");

            BigDecimal toPayMoney = lmSetlmtLog.getTrueRecvAmt();//实际入账金额
            //取到还款日时客户归还欠款
            PaymentTryCalculationTrans paymentTryCal = splitPaymentExampleService.getSplitPaymentExample(lmSetlmtLog.getLoanNo(),
                    lmSetlmtLog.getSetlValDt(), lmSetlmtLog.getTrueRecvAmt().doubleValue(), PaymentModeEnum.getEnum(lmSetlmtLog.getSetlMode()).getCodeInDb(),
                    PaymentModeEnum.getEnum(lmSetlmtLog.getSetlTyp()).getCodeInDb(), new AdvPayOptTrans(CommPartEnum.PROP.getCodeInDb()));
            List<PaymentShdTrans> paymentShdList = paymentTryCal.getPaymentShdList();
            for(int index= 0 ; index < paymentShdList.size(); index ++){
                PaymentShdTrans paymentShdTrans = paymentShdList.get(index);
                /*过滤第0期次数据*/
                if( paymentShdTrans.getPsPerdNo()==0 )
                    continue;
                //计算逾期金额是超过90天宽限期，做入账顺序处理
                LmPmShd lmPmShd = lmPmShdDao.findMaxPerdNoBeforePsDueDt(
                        paymentShdTrans.getShd().getLoanNo(), lmSetlmtLog.getSetlValDt());
                String newGraceDate = DateOperation.getDateIncDayCount(lmPmShd.getPsDueDt(), MinosConst.isOver90Day);
                if ( logg.isDebugEnabled() ) {
                    logg.info("本金入账顺序处理日=" + newGraceDate);
                }
                if ( YnFlagEnum.YES.getCodeInDb().equals(loanRelate.getLoan().getLoanStpAccInd())
                        && lmPmShd.getPsDueDt().compareTo(newGraceDate) > 0 ) { //复利,逾期利息,当期利息,当期本金
                    loanDeveOrd = loanRelate.getLoan().getLoanDevaOrd();
                }
                /*初始化每一期应还金额和已还款金额（本金，利息，罚息，复利）*/
                PaymentThisPeriodMoney paymentThisPeriodMoney = new PaymentThisPeriodMoney(
                        new MoneyPayTrans(paymentShdTrans.getPsPrcpAmt(), paymentShdTrans.getPsNormIntAmt(), paymentShdTrans.getPsOdIntAmt(),
                                paymentShdTrans.getPsCommOdInt(), paymentShdTrans.getPsFeeAmt(),paymentShdTrans.getSetlPrcp(),
                                paymentShdTrans.getSetlNormInt(), paymentShdTrans.getSetlOdIntAmt(),paymentShdTrans.getSetlCommOdInt(),
                                paymentShdTrans.getSetlFeeAmt()),toPayMoney);
                paymentThisPeriodMoney.decidePaymentMoney(entryRuleConfiguraService.findAll(loanDeveOrd));
                /*获取每一期应还款（本金，利息，罚息，复利）*/
                paymentShdTrans.setSetlPrcp(paymentThisPeriodMoney.getMoney().getPrcp());
                paymentShdTrans.setSetlNormInt(paymentThisPeriodMoney.getMoney().getNormInt());
                paymentShdTrans.setSetlOdIntAmt(paymentThisPeriodMoney.getMoney().getOdInt());
                paymentShdTrans.setSetlCommOdInt(paymentThisPeriodMoney.getMoney().getCommInt());
                paymentShdTrans.setSetlFeeAmt(paymentThisPeriodMoney.getMoney().getFeeAmt());
                paymentShdTrans.setSetlInd(paymentThisPeriodMoney.isShdSetlNm(paymentShdTrans) ?
                        YnFlagEnum.YES.getCodeInDb() : YnFlagEnum.NO.getCodeInDb());
                /*获取每一期应已还款本金，利息，罚息，复利入账流水*/
                LmSetlmtLog setlmtLog =advLmSetlmtLog.buildAppendLmSetlmtLog(lmSetlmtLog);
                setlmtLog.setSetlRecvAmt(paymentThisPeriodMoney.getRetlRecvAmt());
                setlmtLog.setSetlOdPrcpAmt(paymentThisPeriodMoney.getMoney().getDevOdPrcpAmount());
                setlmtLog.setSetlIntAmt(paymentThisPeriodMoney.getMoney().getDevNormPrcpAmount());
                setlmtLog.setSetlOdIntAmt(paymentThisPeriodMoney.getMoney().getDevOdIntAmount());
                setlmtLog.setSetlOdCommInt(paymentThisPeriodMoney.getMoney().getDevCommIntAmount());
                setlmtLog.setSetlFeeAmt(paymentThisPeriodMoney.getMoney().getDevPayedFee());
                setlmtLog.setPsBillDt(paymentShdTrans.getPsDueDt());
                setlmtLog.setPsPerdNo(Integer.valueOf(paymentShdTrans.getPsPerdNo()));
                setlmtLog.setTxLogSeq(Long.valueOf(systemInfoService.getNextValDual()));
                lmSetlmtLogDao.insert(setlmtLog);

                //还款计划赋值入账
                AccountUtils.genPmShd(paymentShdTrans,lmPmShdList.get(index),lmSetlmtLog.getSetlValDt());
                //更新还款计划参数配置
                lmPmShdDao.update(AccountUtils.mergeLmShd(lmPmShdList.get(index),lmSetlmtLog));
                //剩余本金
                loanRelate.getLoan().setLoanOsPrcp(loanRelate.getLoan().getLoanOsPrcp().subtract(
                        paymentThisPeriodMoney.getMoney().getDevOdPrcpAmount()));
                //计算逾期标识
                loanRelate.getLoan().setLoanOdInd(YnFlagEnum.NO.getCodeInDb().equals(
                        paymentShdTrans.getSetlInd()) ? YnFlagEnum.YES.getCodeInDb() : YnFlagEnum.NO.getCodeInDb());
                //更新下次还款日
                if( loanRelate.getLoan().getLoanOdInd().equals(YnFlagEnum.NO.getCodeInDb())){
                    lmPmShd  = lmPmShdDao.findMaxPerdNoAlterPsDueDt(lmSetlmtLog.getLoanNo(),paymentShdTrans.getPsDueDt());
                    loanRelate.getLoan().setNextDueDt(lmPmShd !=null ? lmPmShd.getPsDueDt():"");
                }
                //判断实际还款金额是否够扣款
                toPayMoney = paymentThisPeriodMoney.getToPayMoney();
                if( paymentThisPeriodMoney.runOver())
                    break;
            }
            // 如果提前部分或者全部还款
            lmSetlmtLog.setTrueRecvAmt(toPayMoney);
            payment(lmSetlmtLog);
            if( loanRelate.getLoan().getLoanOdInd().equals(YnFlagEnum.NO.getCodeInDb()))
                loanRelate.getLoan().setLoanDebtSts(LoanStateEnum.NORMAL.getCodeInDb());
            loanRelate.getLoan().setLastSetlDt(lmSetlmtLog.getSetlValDt());
            if( loanRelate.getLoan().getLoanOsPrcp().compareTo(BigDecimal.ZERO) <=0 ){
                loanRelate.getLoan().setLoanSts(LoanStateEnum.SETL.getCodeInDb());
                loanRelate.getLoan().setLoanDebtSts(LoanStateEnum.SETL.getCodeInDb());
            }
            //更新下次还款日和是否结清标识
            lmLoanDao.update(loanRelate.getLoan());
        }catch ( Exception e) {
            e.printStackTrace();
            throw new MinosException(MinosException.ERROR99999, e.toString());
        }
    }

    public void payment(LmSetlmtLog log) {
        switch (getPaymentModeEnum()) {
            case ALL:
            case ADVANCE:
                this.paymentAll(log);
                break;
        }
    }

    /**
     * 全部还款
     */
    private void paymentAll(LmSetlmtLog log) {
        try {

            List<LmPmShd> lmPmShdList = new ArrayList<LmPmShd>();
            LmLoanCont lmLoanCont = lmLoanContDao.selectOneByLoanContNo(log.getLoanNo());
            if ( lmLoanCont == null ) {
                throw new MinosException("此借据无合同主表信息！");
            }
            LoanRelateUtils loanRelate = new LoanRelateUtils(lmLoan, lmLoanCont);
            //构造数据备份
            copyAdjustTablesToHisService.toHis(lmLoan.getLoanNo(),log.getTxLogSeq());
            //初始化入账流水表
            AdvPayMentSetlmtLog advLmSetlmtLog =new AdvPayMentSetlmtLog(log,loanRelate.getLoan());
            LmSetlmtLog lmSetlmtLog =advLmSetlmtLog.buildAppendLmSetlmtLog(log);

            //根据当前贷款是否转表外LM_LOAN.LOAN_STP_ACC_IND 获取相应的还款顺序(针对表外或者表内)Y: 已转表外 N:未转表外
            PLoanTypGl pLoanTypGl = entryRuleConfiguraService.findBytypGlId(
                    loanRelate.getBankCde(),loanRelate.getLoan().getLoanTyp());
            String loanDeveOrd = String.valueOf(pLoanTypGl.getGlRpymMtd());
            //初始化还款参数
            PaymentThisPeriodMoney paymentThisPeriodMoney = new PaymentThisPeriodMoney(
                    new MoneyPayTrans(new BigDecimal(String.valueOf(log.getSetlRemPrcpPaym())),
                            new BigDecimal(String.valueOf(log.getSetlIntAmt())), MinosConst.ZERO_BIGDECIMAL,
                            MinosConst.ZERO_BIGDECIMAL, MinosConst.ZERO_BIGDECIMAL, MinosConst.ZERO_BIGDECIMAL,
                            MinosConst.ZERO_BIGDECIMAL, MinosConst.ZERO_BIGDECIMAL, MinosConst.ZERO_BIGDECIMAL,
                            MinosConst.ZERO_BIGDECIMAL),log.getTrueRecvAmt());
            paymentThisPeriodMoney.decidePaymentMoney(entryRuleConfiguraService.findAll(loanDeveOrd));
            //查询小于当前业务日期的最近的一期还款计划
            LmPmShd lmPmShd = lmPmShdDao.findMaxPerdNoBeforePsDueDt(log.getLoanNo(),log.getSetlValDt());
            if ( lmPmShd == null ) {
                throw new MinosException("获取还款计划表数据错误！");
            }
            //构造还款计划
            AdvPayMentLmPmShd advPaymentLmPmShd =new AdvPayMentLmPmShd(
                    lmPmShd,loanRelate,paymentThisPeriodMoney.getMoney(),log);
            advPaymentLmPmShd.setSetlInd(paymentThisPeriodMoney.isShdSetlAll()
                    ? YnFlagEnum.YES.getCodeInDb() : YnFlagEnum.NO.getCodeInDb());
            advPaymentLmPmShd.buildAppendShdWhenPayAllOrPart();
            lmPmShdList.add(advPaymentLmPmShd.getInterestShd());
            /*删除指定借据的小于等于当前业务日期所有的还款计划 */
            int psPerdNo = lmPmShd.getPsPerdNo() + 1;
            lmPmShdDao.deleteAfterPerdNo(log.getLoanNo(),psPerdNo);
            //更新还款计划参数配置
            lmPmShdDao.insertList(AccountUtils.mergeLmShd(lmPmShdList,log));
            //生成部分提前还款计划
            if ( log.getSetlMode().equals(ADVANCE.getCodeInDb()) ){
                exect(lmLoan,advPaymentLmPmShd.getInterestShd());
                genFormal();
            }
            //初始化入账流水表
            lmSetlmtLog.setSetlRecvAmt(paymentThisPeriodMoney.getRetlRecvAmt());
            lmSetlmtLog.setSetlOdPrcpAmt(paymentThisPeriodMoney.getMoney().getDevOdPrcpAmount());
            lmSetlmtLog.setSetlIntAmt(paymentThisPeriodMoney.getMoney().getDevNormPrcpAmount());
            lmSetlmtLog.setSetlOdIntAmt(paymentThisPeriodMoney.getMoney().getDevOdIntAmount());
            lmSetlmtLog.setSetlOdCommInt(paymentThisPeriodMoney.getMoney().getDevCommIntAmount());
            lmSetlmtLog.setSetlFeeAmt(paymentThisPeriodMoney.getMoney().getDevPayedFee());
            lmSetlmtLog.setPsBillDt(lmSetlmtLog.getSetlValDt());
            lmSetlmtLog.setPsPerdNo(psPerdNo);
            lmSetlmtLog.setTxLogSeq(Long.valueOf(systemInfoService.getNextValDual()));
            lmSetlmtLogDao.insert(lmSetlmtLog);
            //更新借据信息
            updateLoan(advPaymentLmPmShd.getInterestShd());
        }catch ( Exception e) {
            e.printStackTrace();
            throw new MinosException(MinosException.ERROR99999, e.toString());
        }
    }

    /***
     * @ClassName(类名) : genFormal
     * @Description(描述) :请先删除要删除的还款 产生正式还款计划表
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public void genFormal() {
        AdvPayMentLmPmShd advPaymentLmPmShd=new AdvPayMentLmPmShd();
        try {
            List<ShdTrans> shdList = genShdList();
            ShdTrans tshdDetl;
            /* 转移数据 */
            deleteOldData();
            /* 还款计划表 */
            if (!CollectionUtils.isEmpty(shdList)) {
                List<LmPmShd> lpsList = new ArrayList<LmPmShd>(shdList.size());
                String[] dueDts = new String[shdList.size()];
                for (int index = 0, aSize = shdList.size(); index < aSize; index++) {
                    tshdDetl = shdList.get(index);
                    if (tshdDetl.getPsPerdNo() < this.currDuePerd) {
                        dueDts[index] = tshdDetl.getPsDueDt();
                        continue;
                    }
                    for (int i = 0; i < index; i++) {
                        if (dueDts[i].equals(tshdDetl.getPsDueDt())) {
                            StringBuilder sb = new StringBuilder("有重复的还款日数据,日期：");
                            sb.append(tshdDetl.getPsDueDt());
                            sb.append("，期号:").append(tshdDetl.getPsPerdNo());
                            sb.append(",重新产生还款计划表失败!");
                            throw new MinosException(sb.toString());
                        }
                    }
                    dueDts[index] = tshdDetl.getPsDueDt();

                    LmPmShd lmPmShd = lmPmShdDao.selectOneByObject(
                            new LmPmShd(lmLoan.getLoanNo(),tshdDetl.getPsPerdNo()));
                    if( lmPmShd !=null ){
                        continue;
                    }
                    lmPmShd = advPaymentLmPmShd.buildAppendShdWhenPayAllOrPart(lmLoan.getLoanNo(), tshdDetl);
                    if (SystemUtils.isAmtGreatThanZero(lmPmShd.getPsInstmAmt().doubleValue())) {
                        lpsList.add(lmPmShd);
                    }
                    if (logg.isDebugEnabled()) {
                        logg.info("dueDt=" + lmPmShd.getPsDueDt());
                        logg.info("perdNo=" + lmPmShd.getPsPerdNo());
                    }
                }
                lmPmShdDao.insertList(lpsList);
            }
            saveLmLnShdMtd();
        }catch ( Exception e) {
            e.printStackTrace();
            throw new MinosException(MinosException.ERROR99999, e.toString());
        }
    }

    /***
     * @ClassName(类名) : genShdList
     * @Description(描述) :产生正式还款计划表
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
    public List<ShdTrans> genShdList() {
        List<ShdTrans> shdList = new ArrayList<ShdTrans>();
        /**还款策略构造函数**/
        /*************
        List<RepaymentPlanTrans> repaymentPlanTransList = iPaymentShdCalPreviewService.shdPreview(ShdMtdTransList());
        for (RepaymentPlanTrans repaymentPlanTrans:  repaymentPlanTransList){
            ShdTrans shdTrans =new ShdTrans();
            shdTrans.setPsPerdNo(Integer.valueOf(repaymentPlanTrans.getId().getPsPerdNo()));
            shdTrans.setPsDueDt(repaymentPlanTrans.getPsDueDt());
            shdTrans.setPsInstmAmt(repaymentPlanTrans.getPsInstmAmt());
            shdTrans.setPsPrcpAmt(repaymentPlanTrans.getPsPrcpAmt());
            shdTrans.setPsNormIntAmt(repaymentPlanTrans.getPsNormIntAmt());
            shdTrans.setPsRemPrcp(repaymentPlanTrans.getPsRemPrcp());
            shdTrans.setPsIntRate(repaymentPlanTrans.getPsIntRate());
            shdTrans.setPsOdIntRate(repaymentPlanTrans.getPsOdIntRate());
            shdList.add(shdTrans);
        }****************************/
        return shdList;
    }

    /***
     * @ClassName(类名) : deleteOldData
     * @Description(描述) :删除还款计划，期数>=输入期数
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
    public void deleteOldData() {
        lmPmShdDao.deleteAfterPerdNo(lmLoan.getLoanNo(),currDuePerd + 1);
    }


    /***
     * @ClassName(类名) : updateLoan
     * @Description(描述) :根据借据信息
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public void updateLoan(LmPmShd lmPmShd){
        LmLoan lmLoan = lmLoanDao.findByLoanNo(lmPmShd.getLoanNo());
        if (lmLoan == null) {
            throw new MinosException("此借据无借据主表信息！");
        }
        lmLoan.setLastSetlDt(systemInfoService.getBuzDate());
        if( YnFlagEnum.YES.getCodeInDb().equals(lmPmShd.getSetlInd()) ){
            String lastIntAccDt = DateOperation.getDateIncDayCount(systemInfoService.getBuzDate(), -1);
            lmLoan.setLastIntAccDt(lastIntAccDt);
            lmLoan.setLoanOsPrcp(lmLoan.getLoanOsPrcp().subtract(lmPmShd.getSetlPrcp()));
            LmPmShd lmPmNextShd = lmPmShdDao.findMaxPerdNoAlterPsDueDt(lmPmShd.getLoanNo(),systemInfoService.getBuzDate());
            lmLoan.setNextDueDt(lmPmNextShd==null ? "" :lmPmNextShd.getPsDueDt());
            if ( lmPmShd.getSetlMode().equals(PaymentModeEnum.ALL.getCodeInDb()) ) {
                lmLoan.setLastDueDt(systemInfoService.getBuzDate());
                lmLoan.setLoanOsPrcp(MinosConst.ZERO_BIGDECIMAL);
                lmLoan.setLoanSts(LoanStateEnum.SETL.getCodeInDb());
                lmLoan.setLoanDebtSts(LoanStateEnum.SETL.getCodeInDb());
                lmLoan.setOldLastDueDt(lmLoan.getLastDueDt());
            }
        }
        lmLoanDao.update(lmLoan);
    }

    /***
     * @ClassName(类名) : exect
     * @Description(描述) :重新生成还款计划表构造方法
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
    public void exect(LmLoan  lmLoan,LmPmShd lmPmShd) {
        this.lmLoan = lmLoan;
        this.lmPmShd = lmPmShd;
        this.currDuePerd = lmPmShd.getPsPerdNo() ;
    }

    /***
     * @ClassName(类名) : genFormal
     * @Description(描述) :生成新的还款策略方式
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
    public void saveLmLnShdMtd() {
        int toPerd = 0;
        LmLnShdMtd lmLnShdMtd =new LmLnShdMtd();
        List<LmLnShdMtd> lmLnShdMtdList = lmLnShdMtdDao.selectListByObject(
                new LmLnShdMtd(lmLoan.getLoanNo()));
        for (int index = 0; index < lmLnShdMtdList.size(); index++) {
            toPerd = lmLnShdMtdList.get(index).getToPerd();
        }
        lmLnShdMtdList.get(0).setToPerd(toPerd + 1);
        lmLnShdMtdDao.update(lmLnShdMtdList.get(0));
    }


    public PaymentModeEnum getPaymentModeEnum() {
        return paymentModeEnum;
    }

    public void setPaymentModeEnum(PaymentModeEnum  paymentModeEnum) {
        this.paymentModeEnum =paymentModeEnum;
    }

}
