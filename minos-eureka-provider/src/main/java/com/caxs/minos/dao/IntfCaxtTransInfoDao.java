package com.caxs.minos.dao;

import com.caxs.minos.domain.IntfCaxtTransInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface IntfCaxtTransInfoDao {
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     int deleteByPrimaryKey(@Param("applSeq") Long applSeq);
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     int insert(IntfCaxtTransInfo record);
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     IntfCaxtTransInfo selectByPrimaryKey(@Param("applSeq") Long applSeq);
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     IntfCaxtTransInfo selectByLoanNo(@Param("loanNo") String loanNo);
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     List<IntfCaxtTransInfo> selectAll();
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     int updateByPrimaryKey(IntfCaxtTransInfo record);
}