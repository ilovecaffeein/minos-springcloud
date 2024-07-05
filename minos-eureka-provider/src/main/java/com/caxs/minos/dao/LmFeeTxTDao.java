package com.caxs.minos.dao;


import com.caxs.minos.domain.LmFeeTxT;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 0061.LM_FEE_TX_T(费用授权信息)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmFeeTxTDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTxT]
     * @return LmFeeTxT
     */
    LmFeeTxT selectOneByObject(LmFeeTxT lmFeeTxT);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTxT]
     * @return List<LmFeeTxT>
     */
    List<LmFeeTxT> selectListByObject(LmFeeTxT lmFeeTxT);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTxT]
     */
    void insert(LmFeeTxT lmFeeTxT);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTxT]
     */
    void update(LmFeeTxT lmFeeTxT);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [list<lmFeeTxT>]
     */
    void insertList(List<LmFeeTxT> lmFeeTxTs);


}
