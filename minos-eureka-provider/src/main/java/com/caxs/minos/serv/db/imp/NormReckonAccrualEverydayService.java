package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.*;
import com.caxs.minos.date.DateOperation;
import com.caxs.minos.def.DBConst;
import com.caxs.minos.def.ErrorCode;
import com.caxs.minos.def.LoanVarDef;
import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.LmLoanCont;
import com.caxs.minos.domain.LmPmShd;
import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.CalcOdTimeTypEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.*;
import com.caxs.minos.utils.LoanRelateUtils;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
/***
 * @ClassName(类名) : NormReckonAccrualEverydayService
 * @Description(描述) : 正常利息结息
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class NormReckonAccrualEverydayService implements INormReckonAccrualEverydayService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());
    /**
     * 批量锁
     */
    private Object lockbatch = new Object();

    @Reference
    ILoanEndOfDayDataFlowService loanEndOfDayDataFlowService;

    @Reference
    ILmChgStatRuleService lmChgStatRuleService;

    @Reference
    IBatchJoErrorLogService iBatchJoErrorLogService;

    @Reference
    ISystemInfoService iSystemInfoService;

    @Reference
    IPunishCalorService iPunishCalorService;

    @Reference
    LmAtpyDetlDao  lmAtpyDetlDao;

    @Reference
    LmLoanContDao lmLoanContDao;

    @Reference
    LmLoanDao lmLoanDao;

    @Reference
    LmPmShdDao  lmPmShdDao;

    @Reference
    LmOdIntLogDao lmOdIntLogDao;

    @Reference
    SCcyDao sCcyDao;


    /**
     * 批量结息调用主函数:
     *正常利息结息
     * @param jobContext
     * @param sbch
     */
    @Override
    public void listtransSetlNormIntDBTrans(BatchJobContextTrans jobContext, SBch sbch) {
        LmLoanCont lmLoanCont = null;
        List<LmLoan> lmLoanList = null;

        String buzDt = jobContext.getBuzDate();
        //如果是扣款日前一天结息的话,交易日+1取数
        if (CalcOdTimeTypEnum.B.getCodeInDb().equals(LoanVarDef.calcOdTimeTyp)) {
            buzDt = DateOperation.addDays(buzDt, 1);
        }
        try {
            // 批处理之前先把满足条件的数据标识设置为未处理 （N）
            lmLoanDao.updatePageFlagRepayByThdCnt(jobContext.getThreadCntStr(),buzDt);
            do {
                synchronized (lockbatch) {
                    lmLoanList = lmLoanDao.findBySetlForNormInt(jobContext.getThreadCntStr(),buzDt);
                }
                // 如果没有查询到数据，那么退出
                if (lmLoanList.size() == 0)
                    return;
                for (LmLoan  lmloan : lmLoanList) {
                    try {
                        lmloan.setPrcsPageDtInd("Y");
                        lmLoanDao.update(lmloan);
                        lmLoanCont = lmLoanContDao.selectOneByLoanContNo(lmloan.getLoanContNo());
                        LoanRelateUtils loanRelateTrans = new LoanRelateUtils(lmloan, lmLoanCont);
                        saveSetlNormInt(jobContext,loanRelateTrans);
                    } catch (Exception e) {
                        iBatchJoErrorLogService.saveErrLogNoIncCount(lmloan.getLoanNo(),jobContext.getBuzDate(),
                                jobContext.getJobExe(),"处理错误借据号 [" + lmloan.getLoanNo() +
                                        " ] 错误, 错误信息 [ " + e.getMessage() + " ]", ErrorCode.ERROR00009);
                        e.printStackTrace();
                    }
                }
            } while (lmLoanList.size() == DBConst.PAGE_RECORD);
        } catch (RuntimeException re) {
            re.printStackTrace();
            throw new MinosException("批量记录结息信息失败！", re);
        }
    }


    /**
     * 批量结息调用主函数:
     *正常利息结息
     * @param jobContext
     * @param loanRelate
     */
    public void saveSetlNormInt(BatchJobContextTrans jobContext, LoanRelateUtils loanRelate) {
        LmPmShd shd = lmPmShdDao.findMinPsDueDtAfterEqualBuz(loanRelate.getLoanNo(), jobContext.getBuzDate());
        if (shd == null) {
            throw new MinosException("没有找到结息还款计划");
        }
        shd.setSetlIncTaken(shd.getPsNormIntAmt());
        lmPmShdDao.update(shd);
        loanRelate.getLoan().setLastRepcDt(jobContext.getBuzDate());
        lmLoanDao.update(loanRelate.getLoan());
    }
}
