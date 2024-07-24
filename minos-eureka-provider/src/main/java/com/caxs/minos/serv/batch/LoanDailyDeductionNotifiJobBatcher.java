package com.caxs.minos.serv.batch;

import com.caxs.minos.domain.DeAtpyJobs;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.BatcherCodeEnum;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.db.IDailyDeductionNotifiService;
import com.caxs.minos.serv.db.imp.BatcherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
/***
 * @ClassName(类名) : LoanDailyDeductionNotifiBatch
 * @Description(描述) : 每日扣款统计短信通知
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class LoanDailyDeductionNotifiJobBatcher extends BatcherService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());

    private IDailyDeductionNotifiService idailyDeductionNotifiService;

    public LoanDailyDeductionNotifiJobBatcher() {
        super();
    }

    public LoanDailyDeductionNotifiJobBatcher(IDailyDeductionNotifiService idailyDeductionNotifiService,BatchJobContextTrans jobContext, DeAtpyJobs deAtpyJobs  ) {
        super(jobContext);
        this.deAtpyJobs = deAtpyJobs;
        this.idailyDeductionNotifiService = idailyDeductionNotifiService;
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
            idailyDeductionNotifiService.listDeductionNotifiTrans(this.getJobContext());
        } catch (Throwable t) {
            throw new MinosException(t);
        }
    }
}
