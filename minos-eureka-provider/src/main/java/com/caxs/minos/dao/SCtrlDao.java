package com.caxs.minos.dao;


import com.caxs.minos.domain.SCtrl;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
@Mapper
public interface SCtrlDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [sCtrl]
     * @return SCtrl
     */
    SCtrl selectOneByObject(SCtrl sCtrl);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [sCtrl]
     * @return List<SCtrl>
     */
    List<SCtrl> selectListByObject(SCtrl sCtrl);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [sCtrl]
     */
    void insert(SCtrl sCtrl);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [sCtrl]
     */
    void update(SCtrl sCtrl);

    List<String> selectEndOfDayState();

    List<SCtrl> selectAll();
}
