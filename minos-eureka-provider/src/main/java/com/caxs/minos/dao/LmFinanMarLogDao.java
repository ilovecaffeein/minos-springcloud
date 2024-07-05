package com.caxs.minos.dao;

import com.caxs.minos.domain.LmFinanMarLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * LM_GLNO_LOG(融资贷款流水表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmFinanMarLogDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFinanMarLog]
     * @return LmFinanMarLog
     */
    LmFinanMarLog selectOneByObject(LmFinanMarLog lmFinanMarLog);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFinanMarLog]
     * @return List<LmFinanMarLog>
     */
    List<LmFinanMarLog> selectListByObject(LmFinanMarLog lmFinanMarLog);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFinanMarLog]
     */
    void insert(LmFinanMarLog lmFinanMarLog);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFinanMarLog]
     */
    void update(LmFinanMarLog lmFinanMarLog);
    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFinanMarLog]
     */
    void insertList(List<LmFinanMarLog> lmFinanMarLogList);
}
