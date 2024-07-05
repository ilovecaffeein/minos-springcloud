package com.caxs.minos.dao;


import com.caxs.minos.domain.PLoanTypGl;
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
public interface PLoanTypGlDao {
    PLoanTypGl selectByPrimaryKey(@Param("bankCde") String bankCde, @Param("typGl") String typGl);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanTypGl]
     * @return PLoanTypGl
     */
    PLoanTypGl selectOneByObject(PLoanTypGl pLoanTypGl);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanTypGl]
     * @return List<PLoanTypGl>
     */
    List<PLoanTypGl> selectListByObject(PLoanTypGl pLoanTypGl);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanTypGl]
     */
    void insert(PLoanTypGl pLoanTypGl);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanTypGl]
     */
    void update(PLoanTypGl pLoanTypGl);
}
