package com.caxs.minos.dao;


import com.caxs.minos.domain.SIntRat;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface SIntRatDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [sIntRat]
     * @return SIntRat
     */
    SIntRat selectOneByObject(SIntRat sIntRat);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [sIntRat]
     * @return List<SIntRat>
     */
    List<SIntRat> selectListByObject(SIntRat sIntRat);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [sIntRat]
     */
    void insert(SIntRat sIntRat);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [sIntRat]
     */
    void update(SIntRat sIntRat);
}
