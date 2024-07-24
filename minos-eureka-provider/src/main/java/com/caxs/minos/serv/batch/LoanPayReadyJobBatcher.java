package com.caxs.minos.serv.batch;

import com.caxs.minos.domain.DeAtpyJobs;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.BatcherCodeEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.IGenerateLoanRepayService;
import com.caxs.minos.serv.db.imp.BatcherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/***
 * @ClassName(类名) : LoanPayReadyJobBatcher
 * @Description(描述) : 自动扣款批处理,本程序会产生子线程。
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public class LoanPayReadyJobBatcher extends BatcherService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    private IGenerateLoanRepayService generateLoanRepayService;


    public LoanPayReadyJobBatcher(IGenerateLoanRepayService generateLoanRepayService,
                                  BatchJobContextTrans jobContext, DeAtpyJobs deAtpyJobs  ) {
        super(jobContext);
        this.deAtpyJobs = deAtpyJobs;
        this.generateLoanRepayService = generateLoanRepayService;
    }

    public LoanPayReadyJobBatcher() {
        super();
    }

    private DeAtpyJobs deAtpyJobs;

    public DeAtpyJobs getDeAtpyJobs() {
        return deAtpyJobs;
    }

    public void setDeAtpyJobs(DeAtpyJobs deAtpyJobs) {
        this.deAtpyJobs = deAtpyJobs;
    }

    @Override
    public BatcherCodeEnum getBatcherCode() {
        return BatcherCodeEnum.LNAF;
    }

    @Override
    public void runBatch() {
        try {
            generateLoanRepayService.listransFrozenAccounts(this.getJobContext(),deAtpyJobs);
        } catch (Throwable t) {
            throw new MinosException(t);
        } finally {
            LoanPayReadyBatcher.currentThread++;
            log.info("自动扣款批处理执行线程号："+deAtpyJobs.getAtpySeqNo() + " 结束！");
        }
    }
}
