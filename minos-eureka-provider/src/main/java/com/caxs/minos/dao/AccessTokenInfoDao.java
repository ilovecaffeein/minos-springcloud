package com.caxs.minos.dao;

import com.caxs.minos.domain.AccessTokenInfo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface AccessTokenInfoDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [accessTokenInfo]
     * @return AccessTokenInfo
     */
    AccessTokenInfo selectOneByObject(AccessTokenInfo accessTokenInfo);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [accessTokenInfo]
     * @return List<AccessTokenInfo>
     */
    List<AccessTokenInfo> selectListByObject(AccessTokenInfo accessTokenInfo);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [accessTokenInfo]
     */
    void insert(AccessTokenInfo accessTokenInfo);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [accessTokenInfo]
     */
    void update(AccessTokenInfo accessTokenInfo);
}
