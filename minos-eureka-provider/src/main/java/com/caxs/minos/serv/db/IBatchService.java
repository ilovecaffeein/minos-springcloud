package com.caxs.minos.serv.db;

import com.caxs.minos.domain.trans.BatchJobContextTrans;
/***
 * @ClassName(类名) : IBatchService
 * @Description(描述) : TODD
 * @author(作者) ： coffee
 * @date (开发日期) ： 2020/9/14 15:17
 */
public interface IBatchService {
    /**
     * 产生日间还款日终步骤
     * @param
     */
    void genNightBatchStep();
    /**
     * 系统切日
     * @param bjc
     */
    void saveSystemChangeDate(BatchJobContextTrans bjc);
    /**
     * 生成还款任务
     * @param bussType
     * @param jobContext
     */
    void generateRepayTask(BatchJobContextTrans jobContext,String bussType);

    /**
     * 检查当天扣款任务包
     * @param jobContext
     * @param bussType
     */
    void checkJobValidate(BatchJobContextTrans jobContext, String bussType);

}
