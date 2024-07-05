package com.caxs.minos.serv.db;

import com.caxs.minos.domain.trans.BatchJobContextTrans;
/***
 * @ClassName(类名) : ILoanRunForBeginDayBatchService
 * @Description(描述) : 日终初始化处理
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface ILoanRunForBeginDayBatcherService extends Runnable{
    /**
     * 日终调用主方法
     * @param batchJobContext
     */
    void runBatch(BatchJobContextTrans batchJobContext);

}
