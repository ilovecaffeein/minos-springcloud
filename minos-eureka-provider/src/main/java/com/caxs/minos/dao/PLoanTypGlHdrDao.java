package com.caxs.minos.dao;


import com.caxs.minos.domain.PLoanTypGlHdr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 配置会计分录设置主表
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
@Mapper
public interface PLoanTypGlHdrDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanTypGlHdr]
     * @return PLoanTypGlHdr
     */
    PLoanTypGlHdr selectOneByObject(PLoanTypGlHdr pLoanTypGlHdr);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanTypGlHdr]
     * @return List<PLoanTypGlHdr>
     */
    List<PLoanTypGlHdr> selectListByObject(PLoanTypGlHdr pLoanTypGlHdr);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanTypGlHdr]
     */
    void insert(PLoanTypGlHdr pLoanTypGlHdr);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanTypGlHdr]
     */
    void update(PLoanTypGlHdr pLoanTypGlHdr);
}
