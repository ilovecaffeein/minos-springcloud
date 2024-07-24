package com.caxs.minos.serv.db.imp;

import com.caxs.minos.date.DateOperation;
import com.caxs.minos.domain.trans.ShdMtdTrans;
import com.caxs.minos.enums.YnFlagEnum;
import com.caxs.minos.serv.db.IPaymentLastDueDtCalService;
import com.caxs.minos.utils.ObjectUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import static com.caxs.minos.serv.buz.RepaymentPlanUtil.getDayByPaymentLastFreq;
/***
 * @ClassName(类名) : PaymentLastDueDtCalService
 * @Description(描述) : 计算到期日
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/5 11:34
 */
@Component
@Service
public class PaymentLastDueDtCalService implements IPaymentLastDueDtCalService {
    /**
     * @Description: 计算最后的到日期
     * @param repaymentParam 还款方式参数明细
     * @Date: 2020/7/29 10:51
     * @Author:  coffee
     * @Return java.util.List<java.lang.String>
     * @Throws
     */
    public  String calLastDueDt(ShdMtdTrans repaymentParam) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DateOperation.parseStringToDate(repaymentParam.getIntStartDt()));
        // 本月计息日日期
        int freqUnit = repaymentParam.getMtdInstl();
        int paymFreqFreq = repaymentParam.getMtdInstl() ;
        int loanDay = calendar.get(Calendar.DAY_OF_MONTH);
        //int dueDay = repaymentParam.getPayDay();
        int dueDay = DateOperation.getDay(repaymentParam.getIntStartDt());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // 根据期供标识计算首期还款日，Y表示下月为第一期还款日，N表示本月为第一期；且还款日在本月计息日之后，首期还款日为本月还款
        if (YnFlagEnum.NO.getCodeInDb().equalsIgnoreCase(repaymentParam.getInstmInd()) && dueDay > loanDay) {
            calendar.set(Calendar.DAY_OF_MONTH, dueDay);
            repaymentParam.setMtdInstl(repaymentParam.getMtdInstl() + 1) ;
        } else {
            calendar.set(Calendar.DAY_OF_MONTH, dueDay);
            calendar.add(Calendar.MONTH, 1);
        }

        //首次还款日
        String firstPayDate = DateOperation.formatDate(calendar.getTime());

        List<String> repaymentTime = new ArrayList(repaymentParam.getMtdInstl());
        // 设置计息日为第0期
        repaymentTime.add(repaymentParam.getIntStartDt());
        // 获取最后到日期
        String lastDueDt = repaymentParam.getLastDueDt();
        if ( ObjectUtil.stringIsNullOrBlank(lastDueDt)) {
            lastDueDt = DateOperation.formatDate(getDayByPaymentLastFreq(firstPayDate,"M", --freqUnit, dueDay));
        }
        return lastDueDt;
    }
}
