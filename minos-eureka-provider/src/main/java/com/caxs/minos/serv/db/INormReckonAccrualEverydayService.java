package com.caxs.minos.serv.db;

import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;

/***
 * @ClassName(类名) : INormReckonAccrualEverydayService
 * @Description(描述) : 正常利息结息
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface INormReckonAccrualEverydayService {
    /**
     * 正常利息结息调用主方法
     * @param jobContext
     * @param sbch
     */
    void listtransSetlNormIntDBTrans(BatchJobContextTrans jobContext, SBch sbch);

}
