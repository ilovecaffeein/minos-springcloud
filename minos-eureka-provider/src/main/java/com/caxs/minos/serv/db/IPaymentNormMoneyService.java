package com.caxs.minos.serv.db;

import com.caxs.minos.domain.LmSetlmtLog;

/***
 * @ClassName(类名) : IPaymentNormMoneyService
 * @Description(描述) : TODD
 * @author(作者) ：归还欠款入账，更新还款计划
 * @date (开发日期) ： 2020/8/5 10:56
 */
public interface IPaymentNormMoneyService {
    /***
     * @ClassName(类名) : saveLoanPayment
     * @Description(描述) :归还还款，更新还款计划
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
     void saveLoanPayment(LmSetlmtLog log);
}
