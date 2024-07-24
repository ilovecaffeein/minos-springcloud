package com.caxs.minos.serv.db;

import com.caxs.minos.domain.LmPmShd;
import com.caxs.minos.domain.LmSetlmtLog;
import org.springframework.transaction.annotation.Transactional;

/***
 * @ClassName(类名) : IPaymentNormMoneyService
 * @Description(描述) : TODD
 * @author(作者) ：归还欠款入账，更新还款计划
 * @date (开发日期) ： 2020/8/5 10:56
 */
public interface IPaymentNormMoneyService {
    /***
     * @ClassName(类名) : genFormal
     * @Description(描述) :请先删除要删除的还款 产生正式还款计划表
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
     void genFormal();
    /***
     * @ClassName(类名) : saveLoanPayment
     * @Description(描述) :归还还款，更新还款计划
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
     void saveLoanPayment(LmSetlmtLog log);
    /***
     * @ClassName(类名) : updateLoan
     * @Description(描述) :根据借据信息
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
     void updateLoan(LmPmShd lmPmShd);
}
