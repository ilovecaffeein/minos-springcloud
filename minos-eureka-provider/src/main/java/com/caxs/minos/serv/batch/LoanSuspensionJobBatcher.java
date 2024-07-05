
package com.caxs.minos.serv.batch;

import com.caxs.minos.domain.DeAtpyJobs;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.common.enumeration.BatcherCode;
import com.caxs.minos.serv.db.ISuspensionService;
import com.caxs.minos.serv.db.imp.BatcherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/***
 * @ClassName(类名) : LoanSuspensionJobBatcher
 * @Description(描述) : 贷款停息批处理
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public class LoanSuspensionJobBatcher extends BatcherService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    private ISuspensionService iSuspensionService;

    public LoanSuspensionJobBatcher( ) {
        super();
    }

    public LoanSuspensionJobBatcher(ISuspensionService iSuspensionService, BatchJobContextTrans jobContext, DeAtpyJobs deAtpyJobs  ) {
        super(jobContext);
        this.deAtpyJobs = deAtpyJobs;
        this.iSuspensionService = iSuspensionService;
    }

    private DeAtpyJobs deAtpyJobs;

    public DeAtpyJobs getDeAtpyJobs() {
        return deAtpyJobs;
    }

    public void setDeAtpyJobs(DeAtpyJobs deAtpyJobs) {
        this.deAtpyJobs = deAtpyJobs;
    }

    public BatcherCode getBatcherCode() {
        return BatcherCode.LN12;
    }

    @Override
    public void runBatch() {
        try {
            // 发送冻结job包含所有账号
            iSuspensionService.listtransUpDateLoanInfo(this.getJobContext());
            if (log.isDebugEnabled())
                log.debug("贷款停息");
        } catch (Throwable t) {
            throw new MinosException(t);
        }
    }
}
