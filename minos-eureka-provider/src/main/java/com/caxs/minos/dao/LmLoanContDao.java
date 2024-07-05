package com.caxs.minos.dao;


import com.caxs.minos.domain.LmLoanCont;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * 主要用于存放与合同相关的信息，包括期限、放款日期、生效日期、到期日、以及利率类型、利息罚息计算规则等等。
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
@Mapper
public interface LmLoanContDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmLoanCont]
     * @return LmLoanCont
     */
    LmLoanCont selectOneByObject(LmLoanCont lmLoanCont);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmLoanCont]
     * @return List<LmLoanCont>
     */
    List<LmLoanCont> selectListByObject(LmLoanCont lmLoanCont);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmLoanCont]
     */
    void insert(LmLoanCont lmLoanCont);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmLoanCont]
     */
    void update(LmLoanCont lmLoanCont);
    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmLoanCont]
     * @return LmLoanCont
     */
    LmLoanCont selectOneByLoanContNo(String loanContNo);
}
