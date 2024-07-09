package com.caxs.minos.serv.db;

import com.caxs.minos.domain.SBch;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
/***
 * @ClassName(类名) : INormIntAccrualSerivce
 * @Description(描述) : 正常利息计提
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/8/4 18:47
 */
public interface INormIntAccrualSerivce {
    /**
     *  正常利息计提：本金或利息逾期90天后，正常利息不再计提，在贷款日时结息。
     *  已计提部分在90天形态转移时全部转表外，剩余当期未计提部分在结息时转表外
     * @param jobContext
     * @return
     */
    void listtransAccrueDBTrans(BatchJobContextTrans jobContext, SBch sbch);
}
