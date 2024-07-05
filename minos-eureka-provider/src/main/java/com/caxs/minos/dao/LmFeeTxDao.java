package com.caxs.minos.dao;


import com.caxs.minos.domain.LmFeeTx;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 记录费用交易记录
FUNC_ID: 功能编号，通过该编号可以知道该笔费用是放款时收的还是还款时收的等等
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmFeeTxDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return LmFeeTx
     */
    LmFeeTx selectOneByObject(LmFeeTx lmFeeTx);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
    List<LmFeeTx> selectListByObject(LmFeeTx lmFeeTx);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     */
    void insert(LmFeeTx lmFeeTx);
    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     */
    void update(LmFeeTx lmFeeTx);

    /**
     * @Author fengdetian
     * @Description 批量新增
     * @Date  2020-09-14 12:34:09
     * @Param [List<LmFeeTx> ]
     */
    void insertList(List<LmFeeTx> lmFeeTxs);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    void deleteByObject(@Param("loanNo") String loanNo, @Param("txLogSeq") String txLogSeq );
}
