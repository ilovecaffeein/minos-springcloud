package com.caxs.minos.dao;


import com.caxs.minos.domain.SBch;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
@Mapper
public interface SBchDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [sBch]
     * @return SBch
     */
    SBch selectOneByObject(SBch sBch);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [sBch]
     * @return List<SBch>
     */
    List<SBch> selectListByObject(SBch sBch);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [sBch]
     */
    void insert(SBch sBch);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [sBch]
     */
    void update(SBch sBch);
}
