package com.caxs.minos.serv.db;

import com.caxs.minos.domain.trans.BatchJobContextTrans;

/***
 * @ClassName(类名) : ILoanInterestEverydayBatchService
 * @Description(描述) : 贷款结息 -正常利息结息
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface ILoanInterestEverydayBatcherService extends Runnable{
    /**
     * 日终调用主方法
     * @param batchJobContext
     */
    void runBatch(BatchJobContextTrans batchJobContext);
}
