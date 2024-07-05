package com.caxs.minos.dao;


import com.caxs.minos.domain.SCcy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
@Mapper
public interface SCcyDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [sCcy]
     * @return SCcy
     */
    SCcy selectOneByObject(SCcy sCcy);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [sCcy]
     * @return List<SCcy>
     */
    List<SCcy> selectListByObject(SCcy sCcy);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [sCcy]
     */
    void insert(SCcy sCcy);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [sCcy]
     */
    void update(SCcy sCcy);
    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [sCcy]
     * @return SCcy
     */
    SCcy selectOneBySCcy(@Param("ccyCde")  String ccyCde);
}
