package com.caxs.minos.dao;

import com.caxs.minos.domain.IntfZhxtTransInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface IntfZhxtTransInfoDao {
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
     int insert(IntfZhxtTransInfo record);
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     IntfZhxtTransInfo selectByPrimaryKey(@Param("applSeq") Long applSeq);
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     List<IntfZhxtTransInfo> selectAll();
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     IntfZhxtTransInfo selectByLoanNo(@Param("loanNo") String loanNo);
     /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmFeeTx]
     * @return List<LmFeeTx>
     */
     int updateByPrimaryKey(IntfZhxtTransInfo record);
}