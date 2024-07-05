package com.caxs.minos.dao;


import com.caxs.minos.domain.LmAtpyDetl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ${comments}
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmAtpyDetlDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAtpyDetl]
     * @return LmAtpyDetl
     */
    LmAtpyDetl selectOneByObject(LmAtpyDetl lmAtpyDetl);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAtpyDetl]
     * @return List<LmAtpyDetl>
     */
    List<LmAtpyDetl> selectListByObject(LmAtpyDetl lmAtpyDetl);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAtpyDetl]
     */
    void insert(LmAtpyDetl lmAtpyDetl);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAtpyDetl]
     */
    void update(LmAtpyDetl lmAtpyDetl);
    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAtpyDetl]
     */
    void updatePageFlag(LmAtpyDetl lmAtpyDetl);

    /**
     * @Author coffee
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAtpyDetl]
     */
    List<LmAtpyDetl> searchBySeqAndstate(@Param("atpyValDt") String atpyValDt, @Param("atpySeqNo")  String atpySeqNo, @Param("atpySts") String atpySts);
    /**
     * @Author coffee
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAtpyDetl]
     */
    List<LmAtpyDetl> findByLoanNoAndDate(@Param("loanNo")  String loanNo,@Param("atpyValDt") String atpyValDt);
    /**
     * @Author coffee
     * @Description 根据业务日期和扣款日期获取逾期数据
     * @Date  2020-09-14 12:34:09
     * @Param [lmAtpyDetl]
     */
    List<LmAtpyDetl> findBuzDateOverdue(@Param("psDueDt") String psDueDt, @Param("atpyValDt")  String atpyValDt);
    /**
     * @Author coffee
     * @Description 根据业务日期和扣款日期获取逾期数据
     * @Date  2020-09-14 12:34:09
     * @Param [lmAtpyDetl]
     */
    LmAtpyDetl findBySeqAndLoanNo(@Param("loanNo") String loanNo, @Param("atpySeqNo")  String atpySeqNo);
    /**
     * 查询扣款金额大于0，但是没有记账的扣款明细个数
     */
    List<LmAtpyDetl> findCountWithRzError(@Param("atpySeqNo")  String atpySeqNo,boolean isIgnoreZero);
}
