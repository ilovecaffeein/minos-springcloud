package com.caxs.minos.serv.db;

import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
/***
 * @ClassName(类名) : IOverdueIntAccrualService
 * @Description(描述) : 逾期利息计提
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface IOverdueIntAccrualService {
    /**
     * 逾期利息计提
     * @param jobContext
     * @param sbch
     * @return
     */
    void listtransOdIntDBTrans(BatchJobContextTrans jobContext, SBch sbch);

}
