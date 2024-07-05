package com.caxs.minos.dao;

import com.caxs.minos.domain.LmHoldShdHist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-18 13:55:38
 */
@Mapper
public interface LmHoldShdHistDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-18 13:55:38
     * @Param [lmHoldShdHist]
     * @return LmHoldShdHist
     */
    LmHoldShdHist selectOneByObject(LmHoldShdHist lmHoldShdHist);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-18 13:55:38
     * @Param [lmHoldShdHist]
     * @return List<LmHoldShdHist>
     */
    List<LmHoldShdHist> selectListByObject(LmHoldShdHist lmHoldShdHist);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-18 13:55:38
     * @Param [lmHoldShdHist]
     */
    void insert(LmHoldShdHist lmHoldShdHist);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-18 13:55:38
     * @Param [lmHoldShdHist]
     */
    void update(LmHoldShdHist lmHoldShdHist);
}
