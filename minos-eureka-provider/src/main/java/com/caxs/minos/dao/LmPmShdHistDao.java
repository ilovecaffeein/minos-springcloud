package com.caxs.minos.dao;


import com.caxs.minos.domain.LmPmShdHist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 还款计划表的备份表，当还款计划表涉及调整时都会先备份到该表中。
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmPmShdHistDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmPmShdHist]
     * @return LmPmShdHist
     */
    LmPmShdHist selectOneByObject(LmPmShdHist lmPmShdHist);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmPmShdHist]
     * @return List<LmPmShdHist>
     */
    List<LmPmShdHist> selectListByObject(LmPmShdHist lmPmShdHist);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmPmShdHist]
     */
    void insert(LmPmShdHist lmPmShdHist);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmPmShdHist]
     */
    void update(LmPmShdHist lmPmShdHist);
}
