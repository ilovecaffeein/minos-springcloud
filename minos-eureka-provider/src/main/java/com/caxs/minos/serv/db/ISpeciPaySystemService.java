package com.caxs.minos.serv.db;

import com.caxs.minos.domain.DeAtpyJobs;
import com.caxs.minos.domain.LmAtpyDetl;
import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.trans.BatchJobContextTrans;

/***
 * @ClassName(类名) : ISpeciPaySystemService
 * @Description(描述) : 生成扣款，请求扣款，扣款结果读取
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface ISpeciPaySystemService {
    /**
     * 插入批量扣款数据(to_pay_ir), 准备扣款 (non-Javadoc)
     * @param jobContext
     * @param loan
     * @param lmAtpyDetl
     * @param job
     */
    void saveAppendBatchPayData(BatchJobContextTrans jobContext, LmLoan loan ,
                                                 LmAtpyDetl lmAtpyDetl, DeAtpyJobs job);
    /**
     * 发送扣款请求
     * @param jobContext
     * @param job
     */
    void listtransTopayIrSingleBatch(BatchJobContextTrans jobContext, DeAtpyJobs job);
    /**
     * 发送扣款请求
     * @param jobContext
     * @param job
     */
    void listtransTopayIrSingleResultBatch(BatchJobContextTrans jobContext, DeAtpyJobs job);
    /**
     * 批量下载外部扣款文件
     * @param jobContext
     */
     void listExternalDebitBatcher(BatchJobContextTrans jobContext, DeAtpyJobs job);
    /**
     * 批量下载外部还款计划文件
     * @param bjc
     */
    void listExternalLmPmShdDebitBatcher(BatchJobContextTrans bjc);
}
