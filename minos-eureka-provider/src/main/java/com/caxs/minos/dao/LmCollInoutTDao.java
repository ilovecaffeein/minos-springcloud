package com.caxs.minos.dao;


import com.caxs.minos.domain.LmCollInoutT;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmCollInoutTDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmCollInoutT]
     * @return LmCollInoutT
     */
    LmCollInoutT selectOneByObject(LmCollInoutT lmCollInoutT);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmCollInoutT]
     * @return List<LmCollInoutT>
     */
    List<LmCollInoutT> selectListByObject(LmCollInoutT lmCollInoutT);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmCollInoutT]
     */
    void insert(LmCollInoutT lmCollInoutT);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmCollInoutT]
     */
    void update(LmCollInoutT lmCollInoutT);
}
