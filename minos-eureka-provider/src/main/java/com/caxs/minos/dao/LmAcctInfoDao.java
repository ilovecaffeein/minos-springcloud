package com.caxs.minos.dao;

import com.caxs.minos.domain.LmAcctInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 存储还款账号，包括户名、证件类型、证件号等等信息。

 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmAcctInfoDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAcctInfo]
     * @return LmAcctInfo
     */
    LmAcctInfo selectOneByObject(LmAcctInfo lmAcctInfo);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAcctInfo]
     * @return List<LmAcctInfo>
     */
    List<LmAcctInfo> selectListByObject(LmAcctInfo lmAcctInfo);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAcctInfo]
     */
    void insert(LmAcctInfo lmAcctInfo);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAcctInfo]
     */
    void update(LmAcctInfo lmAcctInfo);

    /**
     * @Author fengdetian
     * @Description 批量插入
     * @Date  2020-09-14 12:34:09
     * @Param [lmAcctInfo]
     */
    void insertList(List<LmAcctInfo> lmAcctInfos);

}
