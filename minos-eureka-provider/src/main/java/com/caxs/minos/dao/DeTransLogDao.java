package com.caxs.minos.dao;


import com.caxs.minos.domain.DeTransLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * DE_TRANS_LOG(日终交易日志)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface DeTransLogDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deTransLog]
     * @return DeTransLog
     */
    DeTransLog selectOneByObject(DeTransLog deTransLog);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deTransLog]
     * @return List<DeTransLog>
     */
    List<DeTransLog> selectListByObject(DeTransLog deTransLog);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deTransLog]
     */
    void insert(DeTransLog deTransLog);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deTransLog]
     */
    void update(DeTransLog deTransLog);
}
