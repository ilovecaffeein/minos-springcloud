package com.caxs.minos.serv.db;

import com.caxs.minos.domain.trans.LmSetLmtTrans;
import com.caxs.minos.domain.trans.SingleResultTrans;
/***
 * @ClassName(类名) : ICoreSystemService
 * @Description(描述) : TODD
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/9/2 17:34
 */
public interface ICoreSystemService {
    /**
     * @param lmSetLmtTrans
     * @Description: 代扣数据发送业务逻辑
     * @Date: 2020/9/02 13:37
     * @Author: fengdetian
     * @Return String
     * @Throws
     */
     SingleResultTrans singleToPorosReady(LmSetLmtTrans lmSetLmtTrans);
    /**
     * @param lmSetLmtTrans
     * @Description: 代扣结果查询业务逻辑
     * @Date: 2020/9/08 13:37
     * @Author: fengdetian
     * @Return String
     * @Throws
     */
     SingleResultTrans singleToPorosQuery(LmSetLmtTrans lmSetLmtTrans);
}
