package com.caxs.minos.dao;


import com.caxs.minos.domain.LmFundInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmFundInfoDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFundInfo]
     * @return LmFundInfo
     */
    LmFundInfo selectOneByObject(LmFundInfo lmFundInfo);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFundInfo]
     * @return List<LmFundInfo>
     */
    List<LmFundInfo> selectListByObject(LmFundInfo lmFundInfo);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFundInfo]
     */
    void insert(LmFundInfo lmFundInfo);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFundInfo]
     */
    void update(LmFundInfo lmFundInfo);
}
