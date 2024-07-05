package com.caxs.minos.dao;

import com.caxs.minos.domain.LmAcctInfoT;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 存储还款账号，包括户名、证件类型、证件号等等信息。
 * @author cpffee
 * @email
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmAcctInfoTDao {
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAcctInfo]
     * @return List<LmAcctInfo>
     */
    int deleteByPrimaryKey(@Param("genGlNo") String genGlNo, @Param("loanNo") String loanNo, @Param("acctBankCde") String acctBankCde, @Param("acctBchCde") String acctBchCde, @Param("loanAcctTyp") String loanAcctTyp, @Param("acctNo") String acctNo);
    /**
     * @Author coffee
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAcctInfo]
     */
    int insert(LmAcctInfoT record);
    /**
     * @Author coffee
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAcctInfo]
     */
    int insertlist(List<LmAcctInfoT> record);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAcctInfo]
     * @return List<LmAcctInfo>
     */
    LmAcctInfoT selectByPrimaryKey(@Param("genGlNo") String genGlNo, @Param("loanNo") String loanNo, @Param("acctBankCde") String acctBankCde, @Param("acctBchCde") String acctBchCde, @Param("loanAcctTyp") String loanAcctTyp, @Param("acctNo") String acctNo);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAcctInfo]
     * @return List<LmAcctInfo>
     */
    List<LmAcctInfoT> selectAll();
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAcctInfo]
     * @return List<LmAcctInfo>
     */
    List<LmAcctInfoT> selectListByObject(LmAcctInfoT lmAcctInfo);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmAcctInfo]
     * @return List<LmAcctInfo>
     */
    int updateByPrimaryKey(LmAcctInfoT record);
}