package com.caxs.minos.serv.db;

import com.caxs.minos.domain.trans.BatchJobContextTrans;

/***
 * @ClassName(类名) : ILoanAccountingFacadeBatchService
 * @Description(描述) : 合并日间总账
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface ILoanAccountingFacadeBatcherService extends Runnable{
    /**
     * 金额摊销调用主方法
     * @param batchJobContext
     */
    void runBatch(BatchJobContextTrans batchJobContext);
}
