package com.caxs.minos.serv.db;

import com.caxs.minos.domain.trans.ShdMtdTrans;

/***
 * @ClassName(类名) : IPaymentLastDueDtCalService
 * @Description(描述) : 计算到日期
 * * @Author: coffee
 * @date (开发日期) ： 2020/8/5 10:56
 */
public interface IPaymentLastDueDtCalService {
    /**
     * @param repaymentParam
     * @Description: 计算到日期
     * @Date: 2020/7/29 10:51
     * @Author: zhuruilong
     * @Return java.util.List<java.lang.String>
     * @Throws
     */
      String calLastDueDt(ShdMtdTrans repaymentParam);

}
