package com.caxs.minos.serv.db;

import com.caxs.minos.domain.trans.BatchJobContextTrans;

/***
 * @ClassName(类名) : IDailyDeductionNotifiService
 * @Description(描述) : 每日扣款统计短信通知
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/9/14 15:17
 */
public interface IDailyDeductionNotifiService {
    /**
     * 发送短信
     * @param jobContext
     * @return
     */
     void listDeductionNotifiTrans(BatchJobContextTrans jobContext);
}

