package com.caxs.minos.serv.db;

import com.caxs.minos.domain.trans.AdvPayOptTrans;
import com.caxs.minos.domain.trans.PaymentTryCalculationTrans;

/***
 * @ClassName(类名) : ISplitPaymentExampleService
 * @Description(描述) : 取到还款日时客户归还欠款
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/5 10:56
 */
public interface ISplitPaymentExampleService {
    /***
     * @Description(描述) :取到还款日时客户归还欠款
     * @param receiptNumber
     * @param paymentTime
     * @param repaymentAmount
     * @param paymentMode
     * @param paymentTyp
     * @param advPayOpt
     * @return PaymentTryCalculationTrans
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
    PaymentTryCalculationTrans getSplitPaymentExample(String receiptNumber, String paymentTime,
                                                      double repaymentAmount, String paymentMode, String paymentTyp,
                                                      AdvPayOptTrans advPayOpt);

}
