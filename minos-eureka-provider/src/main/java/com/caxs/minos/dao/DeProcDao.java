package com.caxs.minos.dao;

import com.caxs.minos.domain.DeProc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 日终操作步骤定义表
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface DeProcDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deProc]
     * @return DeProc
     */
    DeProc selectOneByObject(DeProc deProc);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deProc]
     * @return List<DeProc>
     */
    List<DeProc> selectListByObject(DeProc deProc);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deProc]
     */
    void insert(DeProc deProc);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deProc]
     */
    void update(DeProc deProc);

    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deProc]
     * @return List<DeProc>
     */
    List<DeProc> findAllForRun(@Param("execInd") String execInd, @Param("jobSts")  String jobSts, @Param("prcsDt")  String prcsDt, @Param("eodFlag")  String eodFlag);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [deProc]
     * @return List<DeProc>
     */
    List<DeProc> findAllForRuning(@Param("execInd") String execInd,@Param("jobSts") String jobSts, @Param("prcsDt") String prcsDt,@Param("eodFlag")  String eodFlag,@Param("mtdDtlSeq") String mtdDtlSeq);
}
