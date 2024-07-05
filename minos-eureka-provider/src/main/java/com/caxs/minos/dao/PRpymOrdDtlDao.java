package com.caxs.minos.dao;


import com.caxs.minos.domain.PRpymOrdDtl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * RPYM_ORD_TYP:当期本金、当期利息、逾期利息、逾期本金、表外罚息、表内罚息、费用
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface PRpymOrdDtlDao {
    List<PRpymOrdDtl> selectPRpymOrdDtl(@Param("rpymOrdSeqNo") Integer rpymOrdSeqNo);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [pRpymOrdDtl]
     * @return PRpymOrdDtl
     */
    PRpymOrdDtl selectOneByObject(PRpymOrdDtl pRpymOrdDtl);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [pRpymOrdDtl]
     * @return List<PRpymOrdDtl>
     */
    List<PRpymOrdDtl> selectListByObject(PRpymOrdDtl pRpymOrdDtl);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [pRpymOrdDtl]
     */
    void insert(PRpymOrdDtl pRpymOrdDtl);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [pRpymOrdDtl]
     */
    void update(PRpymOrdDtl pRpymOrdDtl);
}
