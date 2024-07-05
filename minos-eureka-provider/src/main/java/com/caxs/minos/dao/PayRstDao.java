package com.caxs.minos.dao;

import com.caxs.minos.domain.PayRst;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 扣款结果表
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface PayRstDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [payRst]
     * @return PayRst
     */
    PayRst selectOneByObject(PayRst payRst);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [payRst]
     * @return List<PayRst>
     */
    List<PayRst> selectListByObject(PayRst payRst);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [payRst]
     */
    void insert(PayRst payRst);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [payRst]
     */
    void update(PayRst payRst);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [payRst]
     * @return PayRst
     */
    PayRst findById(@Param("txlogSeq") Long txlogSeq, @Param("subTxlogSeq") Long subTxlogSeq);
}
