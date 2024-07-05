package com.caxs.minos.dao;


import com.caxs.minos.domain.SComCde;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface SComCdeDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [sComCde]
     * @return SComCde
     */
    SComCde selectOneByObject(SComCde sComCde);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [sComCde]
     * @return List<SComCde>
     */
    List<SComCde> selectListByObject(SComCde sComCde);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [sComCde]
     */
    void insert(SComCde sComCde);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [sComCde]
     */
    void update(SComCde sComCde);
}
