package com.caxs.minos.serv.db;

import com.caxs.minos.domain.trans.BatchJobContextTrans;

/**
 * Created by lenovo on 2020/12/9.
 */
public interface ILoanOverdueIntAccrualBatchService extends Runnable{
    /**
     * 日终调用主方法
     * @param batchJobContext
     */
    void runBatch(BatchJobContextTrans batchJobContext);
}
