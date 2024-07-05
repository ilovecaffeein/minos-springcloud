package com.caxs.minos.dao;


import com.caxs.minos.domain.LmInterfaceInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 01.lm_interface_info(信托计划参数信息表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmInterfaceInfoDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmInterfaceInfo]
     * @return LmInterfaceInfo
     */
    LmInterfaceInfo selectOneByObject(LmInterfaceInfo lmInterfaceInfo);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmInterfaceInfo]
     * @return List<LmInterfaceInfo>
     */
    List<LmInterfaceInfo> selectListByObject(LmInterfaceInfo lmInterfaceInfo);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmInterfaceInfo]
     */
    void insert(LmInterfaceInfo lmInterfaceInfo);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmInterfaceInfo]
     */
    void update(LmInterfaceInfo lmInterfaceInfo);
}
