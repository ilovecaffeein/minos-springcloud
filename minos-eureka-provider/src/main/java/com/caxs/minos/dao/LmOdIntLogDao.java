package com.caxs.minos.dao;

import com.caxs.minos.domain.LmOdIntLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 按期结算出罚息放入该表，包括从什么时候结算到什么时候，应收罚息及已收罚息、是表内还是表外等等信息。
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-24 15:47:03
 */
@Mapper
public interface LmOdIntLogDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-24 15:47:03
     * @Param [lmOdIntLog]
     * @return LmOdIntLog
     */
    LmOdIntLog selectOneByObject(LmOdIntLog lmOdIntLog);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-24 15:47:03
     * @Param [lmOdIntLog]
     * @return List<LmOdIntLog>
     */
    List<LmOdIntLog> selectListByObject(LmOdIntLog lmOdIntLog);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-24 15:47:03
     * @Param [lmOdIntLog]
     */
    void insert(LmOdIntLog lmOdIntLog);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-24 15:47:03
     * @Param [lmOdIntLog]
     */
    void update(LmOdIntLog lmOdIntLog);

    /**
     * @Author coffee
     * @Description 新增方法。
     * @Date  2020-09-24 15:47:03
     * @Param [lmOdIntLog]
     */
    void saveList(List<LmOdIntLog> lmOdIntLogList);
}
