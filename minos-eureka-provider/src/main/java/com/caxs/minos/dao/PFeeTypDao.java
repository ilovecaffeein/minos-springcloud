package com.caxs.minos.dao;


import com.caxs.minos.domain.PFeeTyp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * FEE_CHRG_PCT_BASE(费用计算比例基础选项)：期供金额、贷款金额、未付本金、未付本金+未付利息
FEE_TYP(费用类型): 在能用代码中定义,用以区分一些特别的标志，如印花税、提前还款费用等等
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
@Mapper
public interface PFeeTypDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pFeeTyp]
     * @return PFeeTyp
     */
    PFeeTyp selectOneByObject(PFeeTyp pFeeTyp);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pFeeTyp]
     * @return List<PFeeTyp>
     */
    List<PFeeTyp> selectListByObject(PFeeTyp pFeeTyp);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pFeeTyp]
     */
    void insert(PFeeTyp pFeeTyp);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pFeeTyp]
     */
    void update(PFeeTyp pFeeTyp);
}
