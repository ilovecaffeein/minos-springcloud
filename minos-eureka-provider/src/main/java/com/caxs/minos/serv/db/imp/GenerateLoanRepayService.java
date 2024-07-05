package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.*;
import com.caxs.minos.def.DBConst;
import com.caxs.minos.def.ErrorCode;
import com.caxs.minos.def.LoanVarDef;
import com.caxs.minos.def.MinosConst;
import com.caxs.minos.domain.*;
import com.caxs.minos.domain.trans.AdvPayOptTrans;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.domain.trans.PaymentTryCalculationTrans;
import com.caxs.minos.enums.*;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.*;
import com.caxs.minos.serv.db.*;
import com.caxs.minos.utils.DateOperation;
import com.caxs.minos.utils.LoanRelateUtils;
import com.caxs.minos.utils.RoundingUtil;
import com.caxs.minos.utils.SystemUtils;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static com.caxs.minos.enums.YnFlagEnum.YnFlag;
/***
 * @ClassName(类名) : GenerateLoanRepayService
 * @Description(描述) : 生成自动扣款相关数据
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class GenerateLoanRepayService implements IGenerateLoanRepayService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    @Resource
    ISpeciPaySystemService speciPaySystemService;

    @Reference
    ISplitPaymentExampleService splitPaymentExampleService;

    @Reference
    ICustomerEntryPerationService iCustomerEntryPerationService;

    @Resource
    ISystemInfoService systemInfoService;

    @Resource
    IBatchJoErrorLogService batchJoErrorLogService;

    @Resource
    LmLoanDao lmLoanDao;

    @Resource
    LmLoanContDao lmLoanContDao;

    @Resource
    LmAcctInfoDao lmAcctInfoDao;

    @Resource
    LmPmShdDao lmPmShdDao;

    @Resource
    LmAtpyDetlDao lmAtpyDetlDao;

    @Resource
    DeAtpyJobsDao deAtpyJobsDao;

    @Resource
    PayRstDao  payRstDao;

    @Resource
    SCtrlDao  sCtrlDao;


    /**
     * 是否处理
     * @param lmLoan
     * @return
     */
    private boolean isProcess(LmLoan  lmLoan) {
        switch (JobBussTypeEnum.getEnum(lmLoan.getBussTyp())) {
            case ACCP:
                break;
            case GUTR:
                break;
            default:
                return true;
        }
        return true;
    }

    /**
     * 批量锁
     */
    private Object lockbatch = new Object();

    @Override
    public void listransFrozenAccounts(BatchJobContextTrans jobContext, DeAtpyJobs job) {
        listtransExecuteRepay(jobContext, job);
    }

    /**
     * 在放完核心以前执行，执行非核心扣款准备。 一个完整的事务
     * @author(作者) ： coffee
     * @param jobContext
     * @param job
     * @return true ;false
     */
    public void listtransExecuteRepay(BatchJobContextTrans jobContext,
                                      DeAtpyJobs job) {
        //获取系统时间
        SCtrl sCtrl = sCtrlDao.selectOneByObject(null);

        jobContext.setAtpySeqNo(String.valueOf(job.getAtpySeqNo()));
        //需要清除loan 处理标识。PRCS_PAGE_DT_IND='N' 分页处理标识。
        synchronized (lockbatch) {
            lmLoanDao.updatePageFlagLoanRepayByThdCnt(jobContext.getThreadCntStr(),jobContext.getBuzDate());
        }
        //允许单个文件系号对应数据最大笔数系号
        LmLoanCont lmLoanCont;
        List<LmLoan> lmLoanList;
        do {
            synchronized (lockbatch) {
                lmLoanList = lmLoanDao.searchRepayDataByJobContext(
                        jobContext.getThreadCntStr(),jobContext.getBuzDate(),jobContext.getAtpySeqNo());
            }
            // 如果没有查询到数据，那么退出
            if (lmLoanList.size() == 0)
                return;
            Iterator<LmLoan> it = lmLoanList.iterator();
            for (; it.hasNext();) {
                LmLoan loan = it.next();
                lmLoanCont = lmLoanContDao.selectOneByLoanContNo(loan.getLoanContNo());
                // 查找有效的第一条
                loan.setPrcsPageDtInd(YnFlagEnum.YES.getCodeInDb());
                lmLoanDao.update(loan);
                if (log.isInfoEnabled()) {
                    log.info("开始保存Loan，借据号为【" + loan.getLoanNo() + "】");
                }
                if (!isProcess(loan)) {
                    continue;
                }
                try {
                    if ( lmAtpyDetlDao.findBySeqAndLoanNo(loan.getLoanNo(),job.getAtpySeqNo()) == null) {
                        saveOneLoan(jobContext, loan, lmLoanCont, job, sCtrl);
                    }
                } catch ( Exception re) {
                    batchJoErrorLogService.saveErrLogNoIncCount(loan.getLoanNo(),jobContext.getBuzDate(),
                            jobContext.getJobExe(),"处理错误借据号 [" + loan.getLoanNo() +
                                    " ] 错误, 错误信息 [ " + re.getMessage() + " ]", ErrorCode.ERROR00009);
                    re.printStackTrace();
                }
            }
        }while (lmLoanList.size() == DBConst.PAGE_RECORD);
    }


    /**
     * 保存一个借据
     * @param jobContext
     * @param loan
     * @param lmLoanCont
     * @param job
     * @param sCtrl
     */
    @Override
    public void saveOneLoan(BatchJobContextTrans jobContext, LmLoan loan,
                            LmLoanCont lmLoanCont, DeAtpyJobs job, SCtrl sCtrl) {
        //初始化机构
        LoanRelateUtils loanRelate = new LoanRelateUtils(loan, lmLoanCont);
        if (!jobContext.getIsNight()) {
            if (loanRelate.isLoanOverDate()) {
                if (loanRelate.getLoanDevaInd() == YnFlag.YES) {
                    if (SystemUtils.isAmtGreatThanZero(loanRelate
                            .getLoanOsPrcp().doubleValue())) {
                        return;
                    }
                }
            }
        }
        if ("N".equals(loanRelate.getLoan().getLoanOdInd())) {
            loan.setLoanOdInd("Y");
            lmLoanDao.update(loan);
        }
        if (!LoanRepayMethodEnum.AUTOPAY.getCodeInDb().equals(
                loanRelate.getLoanCont().getLoanRepayMthd())) {
            return;
        }
        LmAtpyDetl lmAtpyDetl =null;
        try {
             lmAtpyDetl = startBuildLmAtpyDetlList(job,loanRelate, jobContext);
        } catch ( Exception re) {
            throw new MinosException("lmAtpyDetl 计算应还金额失败!");
        }

        if (lmAtpyDetl != null) {
            try {
                if ( lmAtpyDetl.getAtpyPaymAmt().doubleValue() > 0) {
                    //计算逾期天数
                    if( loan.getNextDueDt()==null || "".equals(loan.getNextDueDt())){
                        loan.setNextDueDt(jobContext.getBuzDate());
                    }
                    long nDays =  DateOperation.DateCal(jobContext.getBuzDate(), loan.getNextDueDt());
                    lmAtpyDetl.setDebtOverDay((int) nDays);
                    lmAtpyDetl.setPchCde(loanRelate.getLoan().getPlaceCde());
                    lmAtpyDetl.setZhyCde(loan.getPlaceCde());
                    lmAtpyDetl.setNight(YnFlagEnum.YES.getCodeInDb());
                    lmAtpyDetl.setPrcsPageDtInd(YnFlagEnum.YES.getCodeInDb());
                    lmAtpyDetlDao.insert(lmAtpyDetl);
                    if( YnFlagEnum.YES.getCodeInDb().equals(loan.getPbcInd()) && LoanVarDef.CA.equals(loan.getPlaceCde())
                            &&  ( nDays <=sCtrl.getDebtOver()) ){
                        speciPaySystemService.saveAppendBatchPayData(jobContext, loan, lmAtpyDetl, job);
                    }
                }
            } catch (RuntimeException re) {
                throw new MinosException("不能保存detail列表");
            }
        }
    }

    /**
     * 构造需要保存的LmAtpyDetl列表
     * @param job
     * @param loanRelate
     * @param jobContext
     * @return
     */
    private LmAtpyDetl startBuildLmAtpyDetlList(DeAtpyJobs job,
                  LoanRelateUtils loanRelate, BatchJobContextTrans jobContext) {

        LmAcctInfo  lmAcctInfo = new LmAcctInfo();
        lmAcctInfo.setLoanNo(loanRelate.getLoanNo());
        lmAcctInfo.setLoanAcctTyp(LoanAccountTypEnum.REPAY.getCodeInDb());
        lmAcctInfo = lmAcctInfoDao.selectOneByObject(lmAcctInfo);
        if (lmAcctInfo == null) {
            throw new NullPointerException("借据号" + loanRelate.getLoanNo()
                    + "账户信息不能为空");
        }
        //归还欠款试算
        if (log.isDebugEnabled())
            log.debug("待试算借据号= " + loanRelate.getLoanNo());
        PaymentTryCalculationTrans paymentTryCalculation;
        try {
            paymentTryCalculation = splitPaymentExampleService.getSplitPaymentExample(
                    loanRelate.getLoanNo(),jobContext.getBuzDate(),Double.valueOf(0), PaymentModeEnum.NORMAL.getCodeInDb(),
                    PaymentModeEnum.NORMAL.getCodeInDb(),new AdvPayOptTrans(CommPartEnum.PROP.getCodeInDb()));
        } catch ( Exception re) {
            throw new MinosException("lmAtpyDetl 计算应还金额失败!");
        }
        //组装结构体汇总
        LmAtpyDetl detail = createDetailCommInfo(loanRelate, lmAcctInfo,jobContext.getBuzDate(), job);
        detail.setAtpyPrcpAmt(new BigDecimal(String.valueOf(paymentTryCalculation.getArrearPrincipal())));
        detail.setAtpyIntAmt(new BigDecimal(String.valueOf(paymentTryCalculation.getArrearInterest())));
        detail.setAtpyCompInt(new BigDecimal(String.valueOf(paymentTryCalculation.getArrearCompoundInterest())));
        // /修约方法
        detail.setAtpyOdInt(new BigDecimal(String.valueOf(paymentTryCalculation.getArrearLateInterest())));
        detail.setAtpyFeeAmt(new BigDecimal(String.valueOf(paymentTryCalculation.getArrearFeeAmt())));
        BigDecimal money = detail.getAtpyPrcpAmt().add(detail.getAtpyIntAmt()).add(detail.getAtpyOdInt());
        money = money.add(detail.getAtpyCompInt()).add(detail.getAtpyFeeAmt());
        money = RoundingUtil.roundingBigDecimal(money);
        detail.setAtpyPaymAmt(money);
        detail.setAtpyInstmNo(new BigDecimal(0));
        detail.setBindMobile(lmAcctInfo.getBindMobile());
        // 业务类型
        return detail;
    }

    /**
     * 创建lmatpydetail公共信息
     *
     * @param loanRelate
     * @param lmAcctInfo
     * @param buzDate
     * @param buzDate
     * @param job
     * @return
     */
    private LmAtpyDetl createDetailCommInfo(LoanRelateUtils loanRelate,
                             LmAcctInfo  lmAcctInfo, String buzDate, DeAtpyJobs job) {
        LmAtpyDetl detail = new LmAtpyDetl();
        detail.setTxlogNo(Long.valueOf(systemInfoService.getNextValDual()));
        detail.setTxlogSeqNo(1L);
        detail.setAtpySeqNo(job.getAtpySeqNo());
        detail.setAtpyValDt(buzDate);
        detail.setLoanNo(loanRelate.getLoanNo());
        detail.setAtpyBchCde(loanRelate.getBchCde());
        detail.setAtpyBankCde(loanRelate.getBankCde());
        detail.setAtpyAcctNo(lmAcctInfo.getAcctNo());
        detail.setGutrNo("");
        // /账户信息
        detail.setAtpyAcctName(lmAcctInfo.getAcctName());
        if (StringUtils.isEmpty(lmAcctInfo.getAcctNo())) {
            throw new MinosException("账号不能为空", ErrorCode.ERROR1001);
        }
        detail.setAtpyAcctIdNo(lmAcctInfo.getAcctIdNo());
        detail.setAtpyAcctIdType(lmAcctInfo.getAcctIdType());
        detail.setAtpyAcctIssCtry(lmAcctInfo.getAcctIssCtry());
        detail.setAtpyAcctBankCde(lmAcctInfo.getAcctBankCde());
        detail.setAtpyAcctBchCde(lmAcctInfo.getAcctBchCde());
        detail.setAtpyAcctTyp(lmAcctInfo.getAcctTyp());
        detail.setAtpyHoldBussTyp(JobBussTypeEnum.ALLLOAN.getCodeInDb());
        detail.setAtpyLdgrCde(lmAcctInfo.getAcctLdgrCde());
        detail.setAtpyAcctCde(lmAcctInfo.getAcctCde());
        // 科目号
        detail.setAtpyAcctLdgrCde(lmAcctInfo.getAcctLdgrCde());
        // 钞汇标志
        detail.setAtpyAcctNttInd(lmAcctInfo.getAcctNttInd());
        // 账户编码：卡或者是存折等。754335
        detail.setAtpyAcctCcyCde(lmAcctInfo.getAcctCcyCde());
        detail.setAtpyCcyCde(lmAcctInfo.getAcctCcyCde());
        detail.setAtpyCreateDt(DateOperation.getDateStringToDb());
        detail.setAtpyTyp(AtpyTypeEnum.NORMAL.getCodeInDb());
        detail.setBussTyp(job.getBussTyp());
        detail.setAtpySts(AtpyStateEnum.SU.getCodeInDb());
        detail.setFileSeq(job.getFileSeq());
        return detail;
    }


    /**
     * 发送核心 根据de_atpy_jobs生成pkg. 修改成调用PaySystem.扣款 修改LM_ATPY_DETL
     * @param jobContext
     * @param job
     */
    public void listtransSendToCoreFreeze(BatchJobContextTrans jobContext, DeAtpyJobs job){
        iCustomerEntryPerationService.updatePageLmAtpyDetl(
                    jobContext,job,AtpyStateEnum.SU.getCodeInDb());
        List<LmAtpyDetl> lmAtpyDetls = null;
        do {
            lmAtpyDetls = lmAtpyDetlDao.searchBySeqAndstate(jobContext.getBuzDate(),job.getAtpySeqNo(),
                    AtpyStateEnum.SU.getCodeInDb());
            for ( int i = 0; i < lmAtpyDetls.size(); i++ ){
                LmAtpyDetl lmAtpyDetl = lmAtpyDetls.get(i);
                PayRst payRst = payRstDao.findById(lmAtpyDetl.getTxlogNo(),lmAtpyDetl.getTxlogSeqNo());
                if ( payRst == null ){
                    lmAtpyDetl.setPrcsPageDtInd(YnFlagEnum.YES.getCodeInDb());
                    lmAtpyDetl.setAtpySts(AtpyStateEnum.FREEZE.getCodeInDb());
                }else{
                    lmAtpyDetl.setAtpyTxAmt(payRst.getActAmt());
                    lmAtpyDetl.setPrcsPageDtInd(YnFlagEnum.YES.getCodeInDb());
                    lmAtpyDetl.setAtpySts(AtpyStateEnum.FREEZE.getCodeInDb());
                    lmAtpyDetl.setAtpyErrDesc(payRst.getErrMsg());
                }
                log.debug("######循环开始,批扣借据号：" + lmAtpyDetl.getLoanNo());
                lmAtpyDetlDao.update(lmAtpyDetl);
            }
        } while (lmAtpyDetls.size() == DBConst.PAGE_RECORD);
    }


    /**
     * 提交核心记账交易准备
     * @param jobContext
     * @param job
     */
    @Override
    public void listtransPrepareCoreWrite(BatchJobContextTrans jobContext, DeAtpyJobs job) {
        boolean isProcess;
        boolean isLast;
        String nextLoanNo = null;
        LmAtpyDetl detailPycl = null;
        List<LmAtpyDetl> loanPyclList = new ArrayList<LmAtpyDetl>(1);
        List<LmAtpyDetl> detailPyclList = new ArrayList<LmAtpyDetl>(0);
        //更新入账状态
        iCustomerEntryPerationService.updatePageLmAtpyDetl(
                jobContext,job,AtpyStateEnum.FREEZE.getCodeInDb());
        do {
            int i = 0;
            detailPyclList = lmAtpyDetlDao.searchBySeqAndstate(jobContext.getBuzDate(),
                    job.getAtpySeqNo(),AtpyStateEnum.FREEZE.getCodeInDb());
            if (CollectionUtils.isEmpty(detailPyclList)) {
                return;
            }
            do {
                isLast = (i == detailPyclList.size() - 1);
                detailPycl = detailPyclList.get(i);
                loanPyclList.add(detailPycl);
                if (!isLast)
                    nextLoanNo = detailPyclList.get(i + 1).getLoanNo();
                isProcess = isLast
                        || (!(detailPycl.getLoanNo().equals(nextLoanNo)));
                if (isProcess) {
                    // /更新处理标志=N
                    Long txLogSeq = loanPyclList.get(0).getTxlogNo();
                    if (txLogSeq == null) {
                        txLogSeq = Long.valueOf(systemInfoService.getNextValDual());
                    }
                    for (LmAtpyDetl detl : loanPyclList) {
                        detl.setTxLogSeq(txLogSeq);
                        detl.setPrcsPageDtInd(YnFlagEnum.YES.getCodeInDb());
                        lmAtpyDetlDao.update(detl);
                    }
                    try {
                        saveOneLoanPayment(loanPyclList, jobContext, job);
                    } catch (RuntimeException re) {
                        batchJoErrorLogService.saveErrLogNoIncCount(detailPycl.getLoanNo(),jobContext.getBuzDate(),
                                jobContext.getJobExe(),"处理错误借据号 [" + detailPycl.getLoanNo() +
                                        " ] 错误, 错误信息 [ " + re.getMessage() + " ]", ErrorCode.ERROR00009);
                    }
                    loanPyclList.clear();
                }
                i++;
            } while (i < detailPyclList.size());
        } while (detailPyclList.size() == DBConst.PAGE_RECORD);
    }


    /**
     * 执行入账
     * @param jobContext
     * @param job
     */
    @Override
    public void saveOneLoanPayment(List<LmAtpyDetl> loanPyclList,
                                   BatchJobContextTrans jobContext, DeAtpyJobs job){
        try {
            // 可能从LmAtpyDetl取出冻结金额为0的记录, 如果是贷款扣款则过滤掉
            Iterator itPyclList = loanPyclList.iterator();
            while (itPyclList.hasNext()) {
                LmAtpyDetl detail = (LmAtpyDetl) itPyclList.next();
                if ( detail.getAtpyTxAmt().doubleValue() == 0) {
                    itPyclList.remove();
                }
            }
            if (loanPyclList.size() == 0)
                return;

            LmSetlmtLog lmSetlmtObj = null;
            lmSetlmtObj = getNewedLmSetlmt(loanPyclList,jobContext);
            lmSetlmtObj.setPchCde(loanPyclList.get(0).getPchCde());

            //会计分录入账
            //iPaymentNormMoneyService.saveLoanPayment(lmSetlmtObj);
            AtpyStateEnum as = AtpyStateEnum.COMPLETE;
            loanPyclList.get(0).setAtpySts(as.getCodeInDb());
            lmAtpyDetlDao.update(loanPyclList.get(0));

            //更新入账线程编号
            job.setAtpySts(as.getCodeInDb());
            deAtpyJobsDao.update(job);
        }catch ( Exception e) {
            e.printStackTrace();
            throw new MinosException(MinosException.ERROR99999, e.getMessage());
        }
    }

    /**
     * 记录当次还款交易的还款情况，如果一次交易归还多期情况，则该表中有一条记录，对应LM_PAYM_LOG有多条记录，
     * 从LM_PAYM_LOG中可看出归还了还款计划表中哪几期，以及归还了哪些部分的情况。 SETLMT_TYP: 还款类型 NM: 正常归还　TR:
     * 第三方代偿 TB: 第三方回购 CO: 核销收回
     * @param jobContext
     * @return
     */
    private LmSetlmtLog getNewedLmSetlmt(List<LmAtpyDetl> loanPyclList,
                                         BatchJobContextTrans jobContext) {
        LmAtpyDetl atpyDetailPycl = loanPyclList.get(0);
        LmSetlmtLog lmtLog = new LmSetlmtLog();
        lmtLog.setBussTyp(JobBussTypeEnum.ALLLOAN.getCodeInDb());// ///ACCP
        lmtLog.setLoanNo(atpyDetailPycl.getLoanNo());
        lmtLog.setSetlMode(PaymentModeEnum.NORMAL.getCodeInDb());
        lmtLog.setSetlTyp(PaymentModeEnum.NORMAL.getCodeInDb());
        lmtLog.setSetlRecvAmt(atpyDetailPycl.getAtpyTxAmt());// 收到金额
        lmtLog.setTrueRecvAmt(atpyDetailPycl.getAtpyTxAmt());// 收到金额
        lmtLog.setSetlFeeAmt(MinosConst.ZERO_BIGDECIMAL);
        lmtLog.setSetlValDt(jobContext.getBuzDate());
        lmtLog.setSetlRevseInd(YnFlag.NO.getCodeInDb());// 冲正标志
        lmtLog.setSetlCreateDt(DateOperation.getDateStringToDb());
        lmtLog.setSetlCreateUsr("admin");
        lmtLog.setSetlOdPrcpAmt(atpyDetailPycl.getAtpyPrcpAmt());// /先按照未还来计算？
        lmtLog.setSetlOdIntAmt(atpyDetailPycl.getAtpyOdInt());
        lmtLog.setSetlOdCommInt(atpyDetailPycl.getAtpyCompInt());
        // /和收付记录表建立关联
        lmtLog.setTxLogSeq(atpyDetailPycl.getTxLogSeq());
        lmtLog.setSetlFpaidIntOpt("CD");
        lmtLog.setSetlAccInt(new BigDecimal(0));
        lmtLog.setSetlCompInd(YnFlag.NO.getCodeInDb());
        lmtLog.setSetlPrcpInd(YnFlag.NO.getCodeInDb());
        lmtLog.setOlInd(YnFlag.YES.getCodeInDb());
        return lmtLog;
    }

    /**
     * 完成整个生成扣款任务工作
     * @param job
     */
    public void finishAllJob(DeAtpyJobs job){
        List<LmAtpyDetl> lmAtpyDetlList = lmAtpyDetlDao.findCountWithRzError(job.getAtpySeqNo(),
                JobBussType.ACCP.getCodeInDb().equals(job.getBussTyp()));
        if ( CollectionUtils.isEmpty(lmAtpyDetlList)) {
            if (ATPYExpStateEnum.STR.getCodeInDb().equals(job.getAtpyexpSts())) {
                job.setAtpySts(AtpyStateEnum.COMPLETE.getCodeInDb());
                deAtpyJobsDao.update(job);
            }
        }
    }
}
