package com.caxs.minos.serv.db.imp;

import com.caxs.minos.domain.trans.BatchJobContextTrans;
import com.caxs.minos.enums.BatcherCodeEnum;
import com.caxs.minos.serv.db.IBatcherService;

/***
 * @ClassName(类名) : BatcherService
 * @Description(描述) : 批处理基类，需要处理批得需要实现继承此类。
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public abstract class BatcherService implements IBatcherService {
    private BatchJobContextTrans jobContext;

    public BatcherService(BatchJobContextTrans jobContext) {
        this.jobContext = jobContext;
    }

    public BatchJobContextTrans getJobContext() {
        return jobContext;
    }

    public BatcherService( ) {}

    abstract public void runBatch();

    public abstract BatcherCodeEnum getBatcherCode();

    final public void run() {
        RunForEndDayService.incThreadCount();
        try {
            runBatch();
        } catch (Exception e) {
            e.printStackTrace();
            RunForEndDayService.isexception = -1;
        } finally {
            RunForEndDayService.decThreadCount();
        }
    }
}
