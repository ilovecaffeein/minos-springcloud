package com.caxs.minos.serv.db;

import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
/***
 * @ClassName(类名) : ILoanAmountAccService
 * @Description(描述) : 金额摊销 or 合并日间总账  or  日终机构总账内部合并
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface ILoanAmountAccService {
    /**
     * 金额摊销调用主方法
     * @param jobContext
     * @param sbch
     */
    void listtransAmountACC(BatchJobContextTrans jobContext, SBch sbch);
    /**
     * 合并日间总账调用主方法
     * @param jobContext
     * @param sbch
     */
    void listtransRegenLmBchGlTx(BatchJobContextTrans jobContext, SBch sbch);
    /**
     * 日终机构总账内部合并调用主方法
     * @param jobContext
     * @param sbch
     */
    void listtransSumAccountOs(BatchJobContextTrans jobContext, SBch sbch);

}
