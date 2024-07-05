package com.caxs.minos.serv.db;

import com.caxs.minos.domain.ToPayIr;
import com.caxs.minos.domain.trans.SingleResultTrans;

/***
 * @ClassName(类名) : ILineThirdPartyInterfaceService
 * @Description(描述) : 调第三方接口服务
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface IBatchThirdPartyInterfaceService {
    /**
     * @desc 主动还款发起支付扣款
     * @author coffee
     * @PARM object
     * @date 2015-01-13
     */
    void SingleBatch(ToPayIr toPayIr);
    /**
     * @desc 主动还款发起支付扣款
     * @author coffee
     * @PARM toPayIr
     * @date 2015-01-13
     */
    SingleResultTrans SingleResultBatch(ToPayIr toPayIr);
}

