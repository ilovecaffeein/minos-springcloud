package com.caxs.minos.dao;


import com.caxs.minos.domain.LmSetlmtT;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * LM_SETLMT_T（提前还款授权）
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
@Mapper
public interface LmSetlmtTDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmSetlmtT]
     * @return LmSetlmtT
     */
    LmSetlmtT selectOneByObject(LmSetlmtT lmSetlmtT);
    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmSetlmtT]
     * @return List<LmSetlmtT>
     */
    List<LmSetlmtT> selectListByObject(LmSetlmtT lmSetlmtT);


    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmSetlmtT]
     */
    void insert(LmSetlmtT lmSetlmtT);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmSetlmtT]
     */
    void update(LmSetlmtT lmSetlmtT);
    /**
     * @Author fengdetian
     * @Description 主动还款联机扣款查询
     * @Date  2020-09-14 12:34:08
     * @Param [request]
     * @return
     */
    List<LmSetlmtT> queryLmSetlmt(@Param("genGlno") String genGlno,
                         @Param("startDate") String startDate,
                         @Param("endDate") String endDate,
                         @Param("idNo") String idNo,
                         @Param("paymAcctNam") String paymAcctNam,
                         @Param("loanNo") String loanNo);

}
