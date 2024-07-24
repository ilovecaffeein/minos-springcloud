package com.caxs.minos.serv.db;

import com.yuchengtech.ycloans.buz.domain.ShdMtd;
import com.yuchengtech.ycloans.buz.payment.shd.GenShdInfoQueryImp;
import com.yuchengtech.ycloans.common.enumeration.PaymentFreq;
import java.util.List;
/***
 * @ClassName(类名) : IMtdUtilsService
 * @Description(描述) :放款试算用
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/17 15:48
 */
public interface IMtdUtilsService {

    /**
     * 放款试算用
     * @param mlt
     */
    public List<ShdMtd> createNomalMtdT(GenShdInfoQueryImp mlt, PaymentFreq freq);
}
