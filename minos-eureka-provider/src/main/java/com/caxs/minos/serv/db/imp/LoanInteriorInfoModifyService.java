package com.caxs.minos.serv.db.imp;

import com.caxs.minos.dao.LmLnShdMtdDao;
import com.caxs.minos.dao.LmLoanDao;
import com.caxs.minos.dao.LmPmShdDao;
import com.caxs.minos.def.DBConst;
import com.caxs.minos.def.ErrorCode;
import com.caxs.minos.domain.LmLnShdMtd;
import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.LmPmShd;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.IBatchJoErrorLogService;
import com.caxs.minos.serv.db.ILoanEndOfDayDataFlowService;
import com.caxs.minos.serv.db.ILoanInteriorInfoModifyService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import javax.annotation.Resource;
import java.util.List;
/***
 * @ClassName(类名) : LoanInteriorInfoModifyService
 * @Description(描述) : 内部信息变更批处理
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class LoanInteriorInfoModifyService implements ILoanInteriorInfoModifyService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    @Resource
    IBatchJoErrorLogService batchJoErrorLogService;

    @Resource
    ILoanEndOfDayDataFlowService loanEndOfDayDataFlowService;

    @Resource
    LmPmShdDao lmPmShdDao;

    @Resource
    LmLnShdMtdDao lmLnShdMtdDao;

    @Resource
    LmLoanDao lmLoanDao;

    /**
     * 内部信息变更批处理
     * @param jobContext
     * @return
     */
    @Override
    public void listtransUpDateLoanInfo(BatchJobContextTrans jobContext){
        List<LmLoan> loanList = null;
        try {
            log.info("内部信息变更开始");
            /**
             * 更新当前还款日
             */
            lmLoanDao.updateLmLoanByPsDueDtandLoanSts(jobContext.getBuzDate());
            do {
                loanList = lmLoanDao.findLmLoanByPsDueDtandLoanSts(jobContext.getBuzDate());
                for ( LmLoan loan : loanList )  {
                    loan.setPrcsPageDtInd(YnFlagEnum.YES.getCodeInDb());
                    try {
                        jobContext.setLoanNo(loan.getLoanNo());
                        saveSynRate(jobContext,loan);
                    } catch (MinosException ye) {
                        batchJoErrorLogService.saveErrLogNoIncCount(jobContext.getLoanNo(),jobContext.getBuzDate(),
                                jobContext.getJobExe(),"处理错误借据号 [" + jobContext.getLoanNo() +
                                        " ] 错误, 错误信息 [ " + ye.getMessage() + " ]", ErrorCode.ERROR00009);
                        ye.printStackTrace();
                    }
                }
            } while (loanList.size() == DBConst.PAGE_RECORD);
        } catch (Exception e) {
            throw new MinosException("批量变更内部信息失败！", e);
        }
    }


    /**
     * 同步借据利息信息
     * @param jobContext
     * @return
     */
    public void saveSynRate(BatchJobContextTrans jobContext,LmLoan lmloan){
        lmloan.setCurDueDt("");
        LmPmShd lmPmShd=lmPmShdDao.findMinPsDueDtAfterBuz(lmloan.getLoanNo(),jobContext.getBuzDate());
        if( lmPmShd !=null )
            lmloan.setCurDueDt(lmPmShd.getPsDueDt());
        lmLoanDao.update(lmloan);
    }

    /**
     * 计算下次利率同步日期 如果没有，那么设置未空
     * @param jobContext
     * @param mtdList
     * @return
     */
    public String calNextSynRateDt(BatchJobContextTrans jobContext, List<LmLnShdMtd> mtdList) {
        LmPmShd dueDtShd =loanEndOfDayDataFlowService.findCurrDueDtShd(
                jobContext.getLoanNo(),jobContext.getBuzDate());
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

    @Override
    public void run() {

    }
}
