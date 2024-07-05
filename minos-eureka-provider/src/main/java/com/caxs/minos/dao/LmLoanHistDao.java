package com.caxs.minos.dao;


import com.caxs.minos.domain.LmLoanHist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 主要用于存放与借据相关的信息，包括期限、放款日期、生效日期、到期日、以及利率类型、利息罚息计算规则等等。
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmLoanHistDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoanHist]
     * @return LmLoanHist
     */
    LmLoanHist selectOneByObject(LmLoanHist lmLoanHist);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoanHist]
     * @return List<LmLoanHist>
     */
    List<LmLoanHist> selectListByObject(LmLoanHist lmLoanHist);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoanHist]
     */
    void insert(LmLoanHist lmLoanHist);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoanHist]
     */
    void update(LmLoanHist lmLoanHist);
}
