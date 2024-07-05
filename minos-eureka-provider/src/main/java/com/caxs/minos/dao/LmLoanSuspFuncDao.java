package com.caxs.minos.dao;

import com.caxs.minos.domain.LmLoanSuspFunc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LmLoanSuspFuncDao {
    /**
     * @param record
     * @return
     */
    int insert(LmLoanSuspFunc record);
    /**
     * @param
     * @return
     */
    List<LmLoanSuspFunc> selectAll();
    /**
     * 根据id查询贷款暂停信息
     * @param loanNo
     * @param suspCde
     * @return
     */
    LmLoanSuspFunc findById(@Param("loanNo") String loanNo, @Param("suspCde") String suspCde);
    /**
     * 根据时间查询贷款暂停信息
     * @param suspDt
     * @return
     */
    List<LmLoanSuspFunc> findAllBySuspDt(@Param("suspDt") String suspDt);
}