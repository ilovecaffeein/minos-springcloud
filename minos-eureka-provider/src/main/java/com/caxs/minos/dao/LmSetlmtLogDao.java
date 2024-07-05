package com.caxs.minos.dao;


import com.caxs.minos.domain.LmSetlmtLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 记录当次还款交易的还款情况，如果一次交易归还多期情况，则该表中有一条记录，对应LM_PAYM_LOG有多条记录，从LM_PAYM_LOG中可看出归还了还款计划表中哪几期，以及归还了哪些部分的情况。
SETLMT_TYP: 还款类型 NM: 正常归还　TR: 第三方代偿 TB: 第三方回购 CO: 核销收回
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
@Mapper
public interface LmSetlmtLogDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmSetlmtLog]
     * @return LmSetlmtLog
     */
    LmSetlmtLog selectOneByObject(LmSetlmtLog lmSetlmtLog);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmSetlmtLog]
     * @return List<LmSetlmtLog>
     */
    List<LmSetlmtLog> selectListByObject(LmSetlmtLog lmSetlmtLog);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmSetlmtLog]
     */
    void insert(LmSetlmtLog lmSetlmtLog);
    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmSetlmtLog]
     */
    void insertList(List<LmSetlmtLog>  lmSetlmtLogList);
    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmSetlmtLog]
     */
    void update(LmSetlmtLog lmSetlmtLog);
    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmSetlmtLog]
     */
    void updatelist(LmSetlmtLog lmSetlmtLog);
    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmSetlmtLog]
     */
    void updateList(LmSetlmtLog lmSetlmtLog);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    void deleteByObject(@Param("loanNo") String loanNo, @Param("txLogSeq") String txLogSeq );
}
