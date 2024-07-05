package com.caxs.minos.dao;


import com.caxs.minos.domain.LmActvLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * 用于存放贷款、银承、贴现发放的日志
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
@Mapper
public interface LmActvLogDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmActvLog]
     * @return LmActvLog
     */
    LmActvLog selectOneByObject(LmActvLog lmActvLog);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmActvLog]
     * @return List<LmActvLog>
     */
    List<LmActvLog> selectListByObject(LmActvLog lmActvLog);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmActvLog]
     */
    void insert(LmActvLog lmActvLog);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmActvLog]
     */
    void update(LmActvLog lmActvLog);
    /**
     * @Author fengdetian
     * @Description 还款计划查询
     * @Date  2020-09-14 12:34:09
     * @Param [lmAcctInfo]
     */
    List<LmActvLog> selectAllActvLog(@Param("LOAN_NO") String loan_no,
                                     @Param("ID_NO") String id_no,
                                     @Param("CUST_NAME")String cust_name,
                                     @Param("STAR_DATE")String star_date,
                                     @Param("END_DATE") String end_date);
}
