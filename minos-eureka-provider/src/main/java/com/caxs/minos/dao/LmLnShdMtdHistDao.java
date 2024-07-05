package com.caxs.minos.dao;


import com.caxs.minos.domain.LmLnShdMtdHist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 08.LM_LN_SHD_MTD_HIST(还款方式历史表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmLnShdMtdHistDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLnShdMtdHist]
     * @return LmLnShdMtdHist
     */
    LmLnShdMtdHist selectOneByObject(LmLnShdMtdHist lmLnShdMtdHist);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLnShdMtdHist]
     * @return List<LmLnShdMtdHist>
     */
    List<LmLnShdMtdHist> selectListByObject(LmLnShdMtdHist lmLnShdMtdHist);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLnShdMtdHist]
     */
    void insert(LmLnShdMtdHist lmLnShdMtdHist);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLnShdMtdHist]
     */
    void update(LmLnShdMtdHist lmLnShdMtdHist);
}
