package com.caxs.minos.dao;


import com.caxs.minos.domain.LmGlnoLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * LM_GLNO_LOG(授权交易日志)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmGlnoLogDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmGlnoLog]
     * @return LmGlnoLog
     */
    LmGlnoLog selectOneByObject(LmGlnoLog lmGlnoLog);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmGlnoLog]
     * @return List<LmGlnoLog>
     */
    List<LmGlnoLog> selectListByObject(LmGlnoLog lmGlnoLog);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmGlnoLog]
     */
    void insert(LmGlnoLog lmGlnoLog);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmGlnoLog]
     */
    void update(LmGlnoLog lmGlnoLog);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    void deleteByObject(@Param("loanNo") String loanNo, @Param("txLogSeq") String txLogSeq );
}
