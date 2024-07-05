package com.caxs.minos.dao;


import com.caxs.minos.domain.DeAtpyJobs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * DE_ATPY_JOBS(自动扣款任务并发日志表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface PrpLRegistDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deAtpyJobs]
     * @return DeAtpyJobs
     */
    DeAtpyJobs selectOneByObject(DeAtpyJobs deAtpyJobs);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deAtpyJobs]
     * @return List<DeAtpyJobs>
     */
    List<DeAtpyJobs> selectListByObject(DeAtpyJobs deAtpyJobs);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deAtpyJobs]
     */
    void insert(DeAtpyJobs deAtpyJobs);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deAtpyJobs]
     */
    void update(DeAtpyJobs deAtpyJobs);
    /**
     *  查找存在的工作。
     * @param bussTyp
     * @param atpyDt
     * @return
     */
     List<DeAtpyJobs> findJobExistsByBuzi(@Param("bussTyp") String bussTyp, @Param("atpyDt") String atpyDt);
    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deAtpyJobs]
     */
    void saveList(List<DeAtpyJobs> deAtpyJobsList);
}
