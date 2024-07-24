package com.caxs.minos.dao;

import com.caxs.minos.domain.PLoanMtd;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * 还款方式定义主表
LOAN_MTD_TYP: 包括是否为气球贷、是否为利随本清、是否为弹性还款、本息不同间隔、本金递增递减等。
LOAN_MTD_BY_RATIO:表示是否按阶段期数比例更新贷款申请的还款方式
MTD_PRCP_PCT 和MTD_PRCP_AMT 不能同时有值
MTD_PROP_UNIT:用于弹性还款法，表示从表中的本金比例是按照贷款金额，还是按照购买房产/车辆总金额
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
@Mapper
public interface PLoanMtdDao {
    PLoanMtd selectByPrimaryKey(PLoanMtd record);
    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanMtd]
     * @return PLoanMtd
     */
    PLoanMtd selectOneByObject(PLoanMtd pLoanMtd);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanMtd]
     * @return List<PLoanMtd>
     */
    List<PLoanMtd> selectListByObject(PLoanMtd pLoanMtd);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanMtd]
     */
    void insert(PLoanMtd pLoanMtd);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [pLoanMtd]
     */
    void update(PLoanMtd pLoanMtd);
}
