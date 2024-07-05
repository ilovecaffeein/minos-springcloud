package com.caxs.minos.dao;


import com.caxs.minos.domain.PLoanMtdDtl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用于定义实际的还款方式，包括本息偿还方式、利率等
MTD_DTL_RPYM_OPT:用于选择是只还利息，还是本息＋利息
MTD_DTL_TYP:用于选择使用等额本金、还是使用等额本息方法
MTD_DTL_MODE:用于选择是使用固定利率，还是使用浮动利率方式
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
@Mapper
public interface PLoanMtdDtlDao {
    List<PLoanMtdDtl> selectAll(PLoanMtdDtl record);
    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanMtdDtl]
     * @return PLoanMtdDtl
     */
    PLoanMtdDtl selectOneByObject(PLoanMtdDtl pLoanMtdDtl);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanMtdDtl]
     * @return List<PLoanMtdDtl>
     */
    List<PLoanMtdDtl> selectListByObject(PLoanMtdDtl pLoanMtdDtl);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanMtdDtl]
     */
    void insert(PLoanMtdDtl pLoanMtdDtl);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanMtdDtl]
     */
    void update(PLoanMtdDtl pLoanMtdDtl);
}
