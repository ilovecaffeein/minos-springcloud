package com.caxs.minos.serv.db;

import com.caxs.minos.domain.trans.PaymentTryCalculationTrans;
import com.caxs.minos.domain.trans.PunishIntFieldsTrans;

import java.util.Map;
/***
 * @ClassName(类名) : IPaymentTryCalculationService
 * @Description(描述) : 还款试算接口
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:09
 */
public interface IPaymentTryCalculationService {
    /***
     * @Description(描述) :还款试算
     * @param loanNo
     * @param buzDate
     * @param actvPayMoney
     * @param  paymentMode
     * @param  paymentTyp
     * @return PaymentTryCalculationTrans
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
    PaymentTryCalculationTrans paymentTryCalForPay(String loanNo, String buzDate,
                                                   double actvPayMoney, String paymentMode, String paymentTyp);
    /***
     * @Description(描述) :还款模式：部分提前还款
     * @param loanNo
     * @param buzDate
     * @param actvPayMoney
     * @param  paymentMode
     * @param  paymentTyp
     * @return PaymentTryCalculationTrans
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
    PaymentTryCalculationTrans paymentTryCalForPartActvPay(String loanNo, String buzDate,
                                                           double actvPayMoney, String paymentMode, String paymentTyp);
    /***
     * @Description(描述) :还款模式：全部提前还款
     * @param loanNo
     * @param buzDate
     * @param actvPayMoney
     * @param  paymentMode
     * @param  paymentTyp
     * @return PaymentTryCalculationTrans
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
    PaymentTryCalculationTrans paymentTryCalForAllActvPay(String loanNo, String buzDate,
                                                          double actvPayMoney, String paymentMode, String paymentTyp);
    /***
     * @Description(描述) :获取试算取罚息复利
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
    /***
     * @Description(描述) :还款模式：全部提前还款
     * @param loanNo
     * @param buzDate
     * @param actvPayMoney
     * @param paymentMode
     * @param paymentTyp
     * @return PaymentTryCalculationTrans
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
     Map<Integer, PunishIntFieldsTrans> paymentTryCalPunishIntPay(String loanNo, String buzDate,
                                                double actvPayMoney, String paymentMode, String paymentTyp);
}
