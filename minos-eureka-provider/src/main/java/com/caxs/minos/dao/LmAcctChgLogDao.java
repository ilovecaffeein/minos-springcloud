package com.caxs.minos.dao;

import com.caxs.minos.domain.LmAcctChgLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 保存还款账号变更情况
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-10-13 16:11:35
 */
@Mapper
public interface LmAcctChgLogDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-10-13 16:11:35
     * @Param [lmAcctChgLog]
     * @return LmAcctChgLog
     */
    LmAcctChgLog selectOneByObject(LmAcctChgLog lmAcctChgLog);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-10-13 16:11:35
     * @Param [lmAcctChgLog]
     * @return List<LmAcctChgLog>
     */
    List<LmAcctChgLog> selectListByObject(LmAcctChgLog lmAcctChgLog);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-10-13 16:11:35
     * @Param [lmAcctChgLog]
     */
    void insert(LmAcctChgLog lmAcctChgLog);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-10-13 16:11:35
     * @Param [lmAcctChgLog]
     */
    void update(LmAcctChgLog lmAcctChgLog);
}
