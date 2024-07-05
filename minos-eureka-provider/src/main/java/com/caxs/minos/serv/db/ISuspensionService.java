package com.caxs.minos.serv.db;

import com.caxs.minos.domain.trans.BatchJobContextTrans;

/***
 * @ClassName(类名) : ISuspensionService
 * @Description(描述) : 贷款停息
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface ISuspensionService {
    /**
     * 内部信息变更批处理
     * @param jobContext
     * @return
     */
    void listtransUpDateLoanInfo(BatchJobContextTrans jobContext);
}
