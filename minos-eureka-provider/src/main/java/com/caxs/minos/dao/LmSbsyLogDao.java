package com.caxs.minos.dao;


import com.caxs.minos.domain.LmSbsyLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * LM_GLNO_LOG(贴息贷款流水表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmSbsyLogDao {
    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmSbsyLog]
     * @return LmSbsyLog
     */
    LmSbsyLog selectOneByObject(LmSbsyLog lmSbsyLog);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmSbsyLog]
     * @return List<LmSbsyLog>
     */
    List<LmSbsyLog> selectListByObject(LmSbsyLog lmSbsyLog);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmSbsyLog]
     */
    void insert(LmSbsyLog lmSbsyLog);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmSbsyLog]
     */
    void update(LmSbsyLog lmSbsyLog);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmSbsyLog]
     * @return List<LmSbsyLog>
     */
    List<LmSbsyLog> selectListByObject(@Param("loanContNo") String loanContNo, @Param("sbsyOlInd") String sbsyOlInd);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmSbsyLog]
     */
    void insertList(List<LmSbsyLog> lmSbsyLogList);
}
