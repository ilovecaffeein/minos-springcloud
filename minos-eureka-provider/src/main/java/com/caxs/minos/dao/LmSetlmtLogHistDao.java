package com.caxs.minos.dao;

import com.caxs.minos.domain.LmSetlmtLogHist;

import java.util.List;
/**
 * 记录当次还款交易的还款情况，如果一次交易归还多期情况，则该表中有一条记录，对应LM_PAYM_LOG有多条记录，从LM_PAYM_LOG中可看出归还了还款计划表中哪几期，以及归还了哪些部分的情况。
SETLMT_TYP: 还款类型 NM: 正常归还　TR: 第三方代偿 TB: 第三方回购 CO: 核销收回
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-10-20 16:43:44
 */
public interface LmSetlmtLogHistDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-10-20 16:43:44
     * @Param [lmSetlmtLogHist]
     * @return LmSetlmtLogHist
     */
    LmSetlmtLogHist selectOneByObject(LmSetlmtLogHist lmSetlmtLogHist);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-10-20 16:43:44
     * @Param [lmSetlmtLogHist]
     * @return List<LmSetlmtLogHist>
     */
    List<LmSetlmtLogHist> selectListByObject(LmSetlmtLogHist lmSetlmtLogHist);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-10-20 16:43:44
     * @Param [lmSetlmtLogHist]
     */
    void insert(LmSetlmtLogHist lmSetlmtLogHist);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-10-20 16:43:44
     * @Param [lmSetlmtLogHist]
     */
    void update(LmSetlmtLogHist lmSetlmtLogHist);
}
