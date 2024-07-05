package com.caxs.minos.dao;


import com.caxs.minos.domain.LmHoldShd;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * LM_HOLD_SHD(出资人收益计划表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmHoldShdDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmHoldShd]
     * @return LmHoldShd
     */
    LmHoldShd selectOneByObject(LmHoldShd lmHoldShd);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmHoldShd]
     * @return List<LmHoldShd>
     */
    List<LmHoldShd> selectListByObject(LmHoldShd lmHoldShd);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmHoldShd]
     */
    void insert(LmHoldShd lmHoldShd);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmHoldShd]
     */
    void update(LmHoldShd lmHoldShd);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmHoldShd]
     */
    void insertList(List<LmHoldShd> lmHoldShdList);
}
