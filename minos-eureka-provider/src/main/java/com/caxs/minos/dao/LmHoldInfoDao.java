package com.caxs.minos.dao;


import com.caxs.minos.domain.LmHoldInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * LM_HOLD_INFO(投资人相关信息表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmHoldInfoDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmHoldInfo]
     * @return LmHoldInfo
     */
    LmHoldInfo selectOneByObject(LmHoldInfo lmHoldInfo);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmHoldInfo]
     * @return List<LmHoldInfo>
     */
    List<LmHoldInfo> selectListByObject(LmHoldInfo lmHoldInfo);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmHoldInfo]
     */
    void insert(LmHoldInfo lmHoldInfo);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmHoldInfo]
     */
    void update(LmHoldInfo lmHoldInfo);
}
