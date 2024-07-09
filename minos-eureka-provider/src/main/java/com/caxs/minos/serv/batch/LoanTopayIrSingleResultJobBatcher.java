package com.caxs.minos.serv.batch;

import com.caxs.minos.domain.DeAtpyJobs;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.exception.MinosException;
import com.caxs.minos.serv.common.enumeration.BatcherCode;
import com.caxs.minos.serv.db.ISpeciPaySystemService;
import com.caxs.minos.serv.db.imp.BatcherService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/***
 * @ClassName(类名) : LoanTopayIrSingleResultJobBatch
 * @Description(描述) : 日终单笔获取核心批扣结果
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public class LoanTopayIrSingleResultJobBatcher extends BatcherService {
    // 打印日志属性
    private final Log log = LogFactory.getLog(getClass());
    public static volatile int i=0;// 用于保证执行的线程小于最大线程数
    public static volatile int currentThread;// 用于保证执行的线程小于最大线程数

    private ISpeciPaySystemService speciPaySystemService;

    private DeAtpyJobs deAtpyJobs;

    public LoanTopayIrSingleResultJobBatcher(ISpeciPaySystemService speciPaySystemService,
                                             BatchJobContextTrans jobContext, DeAtpyJobs deAtpyJobs  ) {
        super(jobContext);
        this.deAtpyJobs = deAtpyJobs;
        this.speciPaySystemService = speciPaySystemService;
    }


    @Override
    public BatcherCode getBatcherCode() {
        return BatcherCode.LNBS;
    }

    @Override
    public void runBatch() {
        try {
            speciPaySystemService.listtransTopayIrSingleResultBatch(this.getJobContext(),deAtpyJobs);
        } catch (Throwable t) {
            throw new MinosException(t);
        } finally {
            LoanTopayIrSingleResultBatcher.currentThread++;
            log.info("执行线程号："+deAtpyJobs.getAtpySeqNo() + " 结束！");
        }
    }
}
