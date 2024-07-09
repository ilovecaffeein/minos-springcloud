package com.caxs.minos.serv.db;

import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;

/***
 * @ClassName(类名) : IOverReckonAccrualEverydayService
 * @Description(描述) : 滚积数,结息调用主方法
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface IOverReckonAccrualEverydayService {
    /**
     * 罚息及复利结息调用主方法
     * @param jobContext
     * @param sbch
     */
    void listtransReckonAccrual(BatchJobContextTrans jobContext, SBch sbch);
}
