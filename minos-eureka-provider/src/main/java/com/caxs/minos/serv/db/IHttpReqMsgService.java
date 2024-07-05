package com.caxs.minos.serv.db;

import com.caxs.minos.domain.LmActvLog;
import com.caxs.minos.domain.trans.LmSetLmtTrans;
import com.caxs.minos.domain.trans.SingleResultTrans;
/***
 * @ClassName(类名) : IHttpReqMsgService
 * @Description(描述) : TODD
 * @author(作者) ： fengdetian
 * @date (开发日期) ： 2020/9/2 17:34
 */
public interface IHttpReqMsgService {

    /**
     * @Description: 手续费代扣数据发送业务逻辑
     * @param lmSetLmtTrans
     * @Date: 2020/9/02 13:37
     * @Author: fengdetian
     * @Return String
     * @Throws
     */
    SingleResultTrans SingleChargeCollection(LmSetLmtTrans lmSetLmtTrans);

    /**
     * @Description:  手续费代扣结果查询业务逻辑
     * @param lmSetLmtTrans
     * @Date: 2020/9/08 13:37
     * @Author: fengdetian
     * @Return String
     * @Throws
     */
    SingleResultTrans SingleChargeCollectionQry(LmSetLmtTrans lmSetLmtTrans);
}
