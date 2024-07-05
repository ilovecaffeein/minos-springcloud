package com.caxs.minos.serv.db.imp;

import com.caxs.minos.domain.trans.AdvPayOptTrans;
import com.caxs.minos.domain.trans.PaymentTryCalculationTrans;
import com.caxs.minos.domain.trans.PunishIntFieldsTrans;
import com.caxs.minos.enums.CommPartEnum;
import com.caxs.minos.serv.db.IPaymentTryCalculationService;
import com.caxs.minos.serv.db.ISplitPunishIntExampleService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.Map;
/***
 * @ClassName(类名) : paymentTryCalculation
 * @Description(描述) : 还款试算
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
@Component
@Service
public class PaymentTryCalculationService implements IPaymentTryCalculationService {
    @Reference
    private SplitPaymentExampleService splitPaymentExampleService;

    @Reference
    private ISplitPunishIntExampleService splitPunishIntExampleService;

    /***
     * @Description(描述) :还款试算
     * @param loanNo
     * @param buzDate
     * @param actvPayMoney
     * @param paymentMode
     * @param paymentTyp
     * @return PaymentTryCalculationTrans
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
    @Override
    public PaymentTryCalculationTrans paymentTryCalForPay(String loanNo, String buzDate,
                         double actvPayMoney, String paymentMode, String paymentTyp) {
        return  splitPaymentExampleService.getSplitPaymentExample(loanNo,buzDate,actvPayMoney,paymentMode,
                paymentTyp,new AdvPayOptTrans(CommPartEnum.PROP.getCodeInDb()));
    }

    /***
     * @Description(描述) :还款模式：部分提前还款
     * @param loanNo
     * @param buzDate
     * @param actvPayMoney
     * @param paymentMode
     * @param paymentTyp
     * @return PaymentTryCalculationTrans
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
    @Override
    public PaymentTryCalculationTrans paymentTryCalForPartActvPay(String loanNo,
                         String buzDate, double actvPayMoney, String paymentMode,String paymentTyp) {
        return  splitPaymentExampleService.getSplitPaymentExample(loanNo,buzDate,actvPayMoney,paymentMode,
                paymentTyp,new AdvPayOptTrans(CommPartEnum.PROP.getCodeInDb()));
    }

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
    @Override
    public PaymentTryCalculationTrans paymentTryCalForAllActvPay(String loanNo, String buzDate,
                              double actvPayMoney,  String paymentMode,String paymentTyp) {
        return  splitPaymentExampleService.getSplitPaymentExample(loanNo,buzDate,actvPayMoney,paymentMode,
                paymentTyp,new AdvPayOptTrans(CommPartEnum.PROP.getCodeInDb()));
    }

    /***
     * @Description(描述) :还款模式：罚息复利
     * @param loanNo
     * @param buzDate
     * @param actvPayMoney
     * @param paymentMode
     * @param paymentTyp
     * @return paymentTryCalPunishIntPay
     * @author(作者) ： coffee
     * @date (开发日期) ： 2020/8/13 15:37
     */
    @Override
    public Map<Integer, PunishIntFieldsTrans> paymentTryCalPunishIntPay(String loanNo, String buzDate,
                                    double actvPayMoney, String paymentMode, String paymentTyp) {
        return  splitPunishIntExampleService.getSplitPunishIntExample(loanNo,buzDate,actvPayMoney,paymentMode,
                paymentTyp,new AdvPayOptTrans(CommPartEnum.PROP.getCodeInDb()));
    }
}
