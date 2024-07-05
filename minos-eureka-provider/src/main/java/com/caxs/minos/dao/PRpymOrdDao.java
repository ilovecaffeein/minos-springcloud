package com.caxs.minos.dao;


import com.caxs.minos.domain.PRpymOrd;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * RPYM_ORD_TYP:  正常扣款、非应计扣款
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface PRpymOrdDao {
    PRpymOrd selectByPrimaryKey(Integer rpymOrdSeqNo);
    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [pRpymOrd]
     * @return PRpymOrd
     */
    PRpymOrd selectOneByObject(PRpymOrd pRpymOrd);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [pRpymOrd]
     * @return List<PRpymOrd>
     */
    List<PRpymOrd> selectListByObject(PRpymOrd pRpymOrd);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [pRpymOrd]
     */
    void insert(PRpymOrd pRpymOrd);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [pRpymOrd]
     */
    void update(PRpymOrd pRpymOrd);
}
