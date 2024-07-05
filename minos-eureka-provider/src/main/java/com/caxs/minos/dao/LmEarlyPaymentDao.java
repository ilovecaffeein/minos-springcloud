package com.caxs.minos.dao;


import com.caxs.minos.domain.LmEarlyPayment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 中原银行提前还款清算流水表
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
@Mapper
public interface LmEarlyPaymentDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmEarlyPayment]
     * @return LmEarlyPayment
     */
    LmEarlyPayment selectOneByObject(LmEarlyPayment lmEarlyPayment);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmEarlyPayment]
     * @return List<LmEarlyPayment>
     */
    List<LmEarlyPayment> selectListByObject(LmEarlyPayment lmEarlyPayment);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmEarlyPayment]
     */
    void insert(LmEarlyPayment lmEarlyPayment);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmEarlyPayment]
     */
    void update(LmEarlyPayment lmEarlyPayment);
}
