package com.caxs.minos.serv.db;

import com.caxs.minos.domain.*;
import com.caxs.minos.domain.trans.BatchJobContextTrans;

import java.util.List;
/***
 * @ClassName(类名) : IGenerateLoanRepayService
 * @Description(描述) : 生成扣款任务
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface IGenerateLoanRepayService {
    /**
     * 第1个独立步骤: ,不能够对Job多线程。 针对每一个扣款JOb初始化。 删除状态为SU的扣款明细 针对每一个job冻结账号进行准备
     *
     * @param jobContext
     * @param job
     */
     void listransFrozenAccounts(BatchJobContextTrans jobContext, DeAtpyJobs job) ;
    /**
     * 保存一个借据相关的所有信息
     * @param jobContext
     * @param loan
     * @param lmLoanCont
     * @param job
     * @param sCtrl
     */
     void saveOneLoan(BatchJobContextTrans jobContext, LmLoan loan, LmLoanCont lmLoanCont,
                            DeAtpyJobs job,SCtrl sCtrl) ;
    /**
     * 发送核心 根据de_atpy_jobs生成pkg. 修改成调用PaySystem.扣款 修改LM_ATPY_DETL
     * @param jobContext
     * @param job
     */
     void listtransSendToCoreFreeze(BatchJobContextTrans jobContext, DeAtpyJobs job);
    /**
     * 提交核心记账交易准备
     * @param jobContext
     * @param job
     */
    void listtransPrepareCoreWrite(BatchJobContextTrans jobContext, DeAtpyJobs job);
    /**
     * 执行入账
     * @param jobContext
     * @param job
     */
     void saveOneLoanPayment(List<LmAtpyDetl> loanPyclList,
                                   BatchJobContextTrans jobContext, DeAtpyJobs job);
    /**
     * 完成整个生成扣款任务工作
     * @param job
     */
     void finishAllJob(DeAtpyJobs job);
}
