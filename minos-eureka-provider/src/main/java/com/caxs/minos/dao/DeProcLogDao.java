package com.caxs.minos.dao;

import com.caxs.minos.domain.DeProcLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 日终操作日志情况表
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface DeProcLogDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deProcLog]
     * @return DeProcLog
     */
    DeProcLog selectOneByObject(DeProcLog deProcLog);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deProcLog]
     * @return List<DeProcLog>
     */
    List<DeProcLog> selectListByObject(DeProcLog deProcLog);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deProcLog]
     */
    void insert(DeProcLog deProcLog);
    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deProcLog]
     */
    void insertList(List<DeProcLog> deProcLog);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deProcLog]
     */
    void update(DeProcLog deProcLog);
    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deProc]
     * @return List<DeProc>
     */
    List<DeProcLog> selectLastProcLog(DeProcLog deProcLog);
}
