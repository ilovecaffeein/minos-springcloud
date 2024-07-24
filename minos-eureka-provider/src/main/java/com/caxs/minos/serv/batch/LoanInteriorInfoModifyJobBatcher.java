package com.caxs.minos.serv.batch;

import com.caxs.minos.domain.DeAtpyJobs;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.BatcherCodeEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.ILoanInteriorInfoModifyService;
import com.caxs.minos.serv.db.imp.BatcherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/***
 * @ClassName(类名) : LoanInteriorInfoModifyJobBatcher
 * @Description(描述) : 核算内部信息更新批处理
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public class LoanInteriorInfoModifyJobBatcher extends BatcherService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    private ILoanInteriorInfoModifyService loanInteriorInfoModifyService;

    public LoanInteriorInfoModifyJobBatcher() {
        super();
    }

    public LoanInteriorInfoModifyJobBatcher(ILoanInteriorInfoModifyService loanInteriorInfoModifyService,BatchJobContextTrans jobContext, DeAtpyJobs deAtpyJobs  ) {
        super(jobContext);
        this.deAtpyJobs = deAtpyJobs;
        this.loanInteriorInfoModifyService = loanInteriorInfoModifyService;
    }

    private DeAtpyJobs deAtpyJobs;

    public DeAtpyJobs getDeAtpyJobs() {
        return deAtpyJobs;
    }

    public void setDeAtpyJobs(DeAtpyJobs deAtpyJobs) {
        this.deAtpyJobs = deAtpyJobs;
    }

    public BatcherCodeEnum getBatcherCode() {
        return BatcherCodeEnum.LNAO;
    }


    @Override
    public void runBatch() {
        try {
            loanInteriorInfoModifyService.listtransUpDateLoanInfo(this.getJobContext());
        } catch (Throwable t) {
            throw new MinosException(t);
        }
    }
}
