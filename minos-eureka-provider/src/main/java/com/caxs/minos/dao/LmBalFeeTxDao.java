package com.caxs.minos.dao;


import com.caxs.minos.domain.LmBalFeeTx;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 01.LM_BAL_FEE_TX(费用余额表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmBalFeeTxDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmBalFeeTx]
     * @return LmBalFeeTx
     */
    LmBalFeeTx selectOneByObject(LmBalFeeTx lmBalFeeTx);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmBalFeeTx]
     * @return List<LmBalFeeTx>
     */
    List<LmBalFeeTx> selectListByObject(LmBalFeeTx lmBalFeeTx);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmBalFeeTx]
     */
    void insert(LmBalFeeTx lmBalFeeTx);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmBalFeeTx]
     */
    void update(LmBalFeeTx lmBalFeeTx);
}
