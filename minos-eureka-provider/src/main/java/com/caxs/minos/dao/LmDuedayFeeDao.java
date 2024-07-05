package com.caxs.minos.dao;


import com.caxs.minos.domain.LmDuedayFee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * LM_DUEDAY_FEE(扣款日费用记录表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmDuedayFeeDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmDuedayFee]
     * @return LmDuedayFee
     */
    LmDuedayFee selectOneByObject(LmDuedayFee lmDuedayFee);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmDuedayFee]
     * @return List<LmDuedayFee>
     */
    List<LmDuedayFee> selectListByObject(LmDuedayFee lmDuedayFee);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmDuedayFee]
     */
    void insert(LmDuedayFee lmDuedayFee);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmDuedayFee]
     */
    void update(LmDuedayFee lmDuedayFee);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmDuedayFee]
     */
    void insertList(List<LmDuedayFee>  lmDuedayFeeList);
}
