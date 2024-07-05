package com.caxs.minos.dao;

import com.caxs.minos.domain.DeErrorLog;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * 日终操作错误日志表
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface DeErrorLogDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deErrorLog]
     * @return DeErrorLog
     */
    DeErrorLog selectOneByObject(DeErrorLog deErrorLog);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deErrorLog]
     * @return List<DeErrorLog>
     */
    List<DeErrorLog> selectListByObject(DeErrorLog deErrorLog);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deErrorLog]
     */
    void insert(DeErrorLog deErrorLog);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deErrorLog]
     */
    void update(DeErrorLog deErrorLog);
}
