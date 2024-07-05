package com.caxs.minos.dao;


import com.caxs.minos.domain.PLoanTypGlMap;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 该表定义信贷系统的品种与核算中定义的品种的对应关系
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
@Mapper
public interface PLoanTypGlMapDao {
    PLoanTypGlMap selectByPrimaryKey(String typCde);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanTypGlMap]
     * @return PLoanTypGlMap
     */
    PLoanTypGlMap selectOneByObject(PLoanTypGlMap pLoanTypGlMap);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanTypGlMap]
     * @return List<PLoanTypGlMap>
     */
    List<PLoanTypGlMap> selectListByObject(PLoanTypGlMap pLoanTypGlMap);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanTypGlMap]
     */
    void insert(PLoanTypGlMap pLoanTypGlMap);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanTypGlMap]
     */
    void update(PLoanTypGlMap pLoanTypGlMap);
}
