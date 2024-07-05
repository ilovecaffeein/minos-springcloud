package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.*;
import com.caxs.minos.domain.*;
import com.caxs.minos.domain.trans.AccountTrans;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.LoanAccountTypEnum;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.buz.AccountUtils;
import com.caxs.minos.serv.db.ICustomerEntryPerationService;
import com.caxs.minos.serv.db.IEntryRuleConfiguraService;
import com.caxs.minos.serv.db.ISystemInfoService;
import com.caxs.minos.utils.SystemUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.util.List;
/***
 * @ClassName(类名) : CustomerEntryPerationService
 * @Description(描述) : 日间操作数据业务
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class CustomerEntryPerationService implements ICustomerEntryPerationService {
    private Log log = LogFactory.getLog(getClass());

    @Resource
    private ISystemInfoService systemInfoService;

    @Resource
    IEntryRuleConfiguraService entryRuleConfiguraService;

    @Resource
    LmLnShdMtdDao lmLnShdMtdDao;

    @Resource
    LmAcctInfoDao lmAcctInfoDao;

    @Resource
    LmPmShdDao lmPmShdDao;

    @Resource
    LmLoanDao lmLoanDao;

    @Resource
    LmLoanContDao lmLoanContDao;

    @Resource
    LmFeeTxTDao  lmFeeTxTDao;

    @Resource
    LmSetlmtTDao  lmSetlmtTDao;

    @Resource
    LmSetlmtLogDao  lmSetLmtLogDao;

    @Resource
    private LmGlnoLogDao  lmGlnoLogDao;

    @Resource
    private LmAtpyDetlDao  lmAtpyDetlDao;

    @Resource
    SCcyDao  sCcyDao;

    /**
     * 计算下次扣款日，仅实时处理函数调用
     * @param loanNo
     * @param buzDate
     * @return
     */
    public String calNextDueDt(String loanNo,String buzDate,LmPmShd iShd) {
        LmLoan lmLoan = lmLoanDao.findByLoanNo(loanNo);
        if (iShd == null) {
            iShd = getInterestDateShd(lmLoan.getLoanNo(),buzDate,true);
        }
        if (YnFlagEnum.YES.getCodeInDb().equals(lmLoan.getLoanOdInd())) {
            return lmLoan.getNextDueDt();
        }
        List<LmPmShd> afterEqualPsDueDtList = lmPmShdDao.findByLoanNoAfterAllPsDueDt(
                iShd.getLoanNo(),buzDate);
        if (!CollectionUtils.isEmpty(afterEqualPsDueDtList)) {
            for (LmPmShd shd : afterEqualPsDueDtList) {
                if (shd.getPsPerdNo() > 0) {
                    if (!YnFlagEnum.isTrue(shd.getSetlInd())) {
                        if (!YnFlagEnum.YES.getCodeInDb().equals(shd.getPpErInd())) {
                            return shd.getPsDueDt();
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * 计算下次利率同步日期 如果没有，那么设置未空
     *
     * @param buzDt
     * @param mtdList
     * @return
     */
    public String calNextSynRateDt(String buzDt ,List<LmLnShdMtd> mtdList) {
        LmPmShd dueDtShd = findCurrDueDtShd(mtdList.get(0).getLoanNo(),buzDt);
        int duePerdNo = dueDtShd.getPsPerdNo();
        boolean start = false;
        String nextSynRateDt = null;
        if (CollectionUtils.isEmpty(mtdList)) {
            return null;
        }
        if (mtdList.size() == 0) {
            return null;
        }
        for (LmLnShdMtd mtd : mtdList) {
            if ((duePerdNo >= mtd.getFrmPerd())
                    && (duePerdNo <= mtd.getToPerd())) {
                start = true;
                continue;
            }
            if (start) {
                return mtd.getIntStartDt();
            }
        }
        return nextSynRateDt;
    }

    /**
     * 查询<=operationDate 的利息计算起始期。
     * @param buzDate
     *            查询日期
     * @return shd 还款计划表
     */
    public LmPmShd getInterestDateShd(String loanNo,String buzDate,boolean isEqualDate) {
        LmLoan lmLoan = new LmLoan ();
        lmLoan.setLoanNo(loanNo);
        lmLoan = lmLoanDao.selectOneByObject(lmLoan);
        LmPmShd shd = lmPmShdDao.findMaxPerdNoBefore(lmLoan.getLoanNo(),buzDate);
        if (shd == null) {
            if (buzDate.equals(lmLoan.getIntStartDt())) {
                shd = getLmPmShd(lmLoan.getLoanNo(), 0);
                if (shd != null) {
                    return shd;
                }
            }
            throw new MinosException("没有找到利息计算开始日！");
        }
        return shd;
    }

    /**
     * 查找还款计划表
     * @param loanNo
     * @param buzDate
     * @author coffee
     */
    public LmPmShd findCurrDueDtShd(String loanNo, String buzDate) {
        LmLoan lmLoan = new LmLoan ();
        lmLoan.setLoanNo(loanNo);
        lmLoan = lmLoanDao.selectOneByObject(lmLoan);
        if (lmLoan.getLastDueDt().compareTo(buzDate) <= 0) {
            return getLastPmShd(loanNo);
        }
        LmPmShd curDueShd = lmPmShdDao.findMinPsDueDtAfterBuz(loanNo, buzDate);
        if (curDueShd == null) {
            if (lmLoan.getIntStartDt().equals(buzDate)) {
                return getLmPmShd(loanNo,0);
            } else {
                return getLastPmShd(loanNo);
            }
        }
        if (curDueShd == null) {
            throw new MinosException("没有找到应还期数:" + buzDate);
        }
        return curDueShd;
    }


    public LmPmShd getLmPmShd(String loanNo, int perdNo) {
        return lmPmShdDao.selectOneByObject(new LmPmShd(loanNo,perdNo));
    }

    /**
     * 查找最后一期还款计划表
     * @param loanNO
     * @author coffee
     */
    public LmPmShd getLastPmShd(String loanNO) {
        LmPmShd lmPmShd =lmPmShdDao.findLastPerdNo(loanNO);
        if (lmPmShd == null) {
            throw new MinosException("没有找到最后一期还款计划表");
        }
        return lmPmShd;
    }


    /**
     * 主动还款数据操作
     * @param lmGlnoLog
     * @param lmFeeTxTs
     * @param lmSetLmt
     * @author fengdetian
     */
    public void activeRepayment( LmGlnoLog lmGlnoLog, List<LmFeeTxT> lmFeeTxTs, LmSetlmtT lmSetLmt){
        LmGlnoLog lmGlnoLogKey = new LmGlnoLog();
        lmGlnoLogKey.setGenGlNo(lmGlnoLog.getGenGlNo());
        if( lmGlnoLog != null ){
            if (lmGlnoLogDao.selectOneByObject(lmGlnoLogKey) == null){
                lmGlnoLogDao.insert(lmGlnoLog);
            }
            lmGlnoLogDao.update(lmGlnoLog);
        }
        if ( ! CollectionUtils.isEmpty(lmFeeTxTs) ){
            for (LmFeeTxT lmFeeTxT : lmFeeTxTs){
                lmFeeTxTDao.insert(lmFeeTxT);
            }
        }

        if( lmSetLmt != null ){
            LmSetlmtT lmSetlmtTKey = new LmSetlmtT();
            lmSetlmtTKey.setGenGlNo(lmGlnoLog.getGenGlNo());
            if (lmSetlmtTDao.selectOneByObject(lmSetlmtTKey) == null){
                lmSetlmtTDao.insert(lmSetLmt);
            }
        }
    }


    /**
     *  获取收费账户，如果收费账户为空，获取贷款还款账户，根据收费账号信息生成账户信息
     * @author coffee
     * @date 2020-11-26
     * @param lstAcctInfo
     * @return
     */
    public AccountTrans transAcctInfo(List<LmAcctInfoT> lstAcctInfo) {
        LmAcctInfo lmAcctInfo = new LmAcctInfo();
        if( lstAcctInfo != null && lstAcctInfo.size() > 0
                && lstAcctInfo.get(0).getAcctNo() != null && lstAcctInfo.get(0).getAcctName() != null) {
            lmAcctInfo = new LmAcctInfo();
            //只有一条收费账户
            LmAcctInfoT t = lstAcctInfo.get(0);
            SystemUtils.copyProperties(t, lmAcctInfo);
            lmAcctInfo.setLoanNo(t.getLoanNo());
            lmAcctInfo.setAcctNo(t.getAcctNo());
            lmAcctInfo.setLoanAcctTyp(t.getLoanAcctTyp());
            lmAcctInfo.setAcctPriNo(1);
            lmAcctInfo.setAcctValDt(systemInfoService.getBuzDate());
            lmAcctInfo.setAtpySts("A");
            lmAcctInfo.setAcctCreateDt(systemInfoService.getBuzDate());
            lmAcctInfo.setBindMobile(t.getBindMobile());
        } else {
            lmAcctInfo.setLoanAcctTyp(LoanAccountTypEnum.REPAY.getCodeInDb());
            lmAcctInfo.setLoanNo(lstAcctInfo.get(0).getLoanNo());
            lmAcctInfo =  lmAcctInfoDao.selectOneByObject(lmAcctInfo);
        }
        AccountTrans account = AccountUtils.buildAccount(lmAcctInfo);
        return account;
    }


    /**
     * 更新自动入账数据
     * @param jobContext
     * @param job
     * @author coffee
     */
    public void updatePageLmAtpyDetl(BatchJobContextTrans jobContext, DeAtpyJobs job, String atpySts) {
        LmAtpyDetl lmAtpyDetl =new LmAtpyDetl();
        lmAtpyDetl.setAtpySeqNo(job.getAtpySeqNo());
        lmAtpyDetl.setAtpyValDt(jobContext.getBuzDate());
        lmAtpyDetl.setAtpySts(atpySts);
        lmAtpyDetlDao.updatePageFlag(lmAtpyDetl);
    }

}
