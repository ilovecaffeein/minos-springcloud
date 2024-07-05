package com.caxs.minos.dao;

import com.caxs.minos.domain.LmPmShd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 每月应还的还款计划，包括本金、利息、贴息等。
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:08
 */
@Mapper
public interface LmPmShdDao {
    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return LmPmShd
     */
    LmPmShd selectOneByObject(LmPmShd lmPmShd);
    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    List<LmPmShd> selectListByObject(LmPmShd lmPmShd);
    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     */
    void insert(LmPmShd lmPmShd);
    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     */
    void insertList(List<LmPmShd> lmPmShdList);
    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     */
    void update(LmPmShd lmPmShd);
    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     */
    void updateList(List<LmPmShd> lmPmShdList);
    /**
     * @Description: 查询指定借据的小于等于当前业务日志的最大期号
     * @param loanNo 借据号
     * @Date: 2020/8/17 16:15
     * @Author: zhuruilong
     * @Return java.util.List<com.caxs.minos.domain.LmPmShdDomain>
     * @Throws
     */
    List<LmPmShd>  findByLoanNoBeforePsDueDtWithoutSetl(@Param("loanNo") String loanNo, @Param("psDueDt") String psDueDt);
    /**
     * @Description: 查询指定借据的小于等于当前业务日志的最大期号
     * @param loanNo 借据号
     * @Date: 2020/8/17 16:15
     * @Author: zhuruilong
     * @Return java.util.List<com.caxs.minos.domain.LmPmShdDomain>
     * @Throws
     */
    LmPmShd findMaxPerdNoBeforePsDueDt(@Param("loanNo") String loanNo, @Param("psDueDt") String psDueDt);
    /**
     * @Description: 删除当前借据号对应的所有还款计划
      * @param loanNo
     * @Date: 2020/10/13 10:48
     * @Author: zhuruilong
     * @Return void
     * @Throws
     */
    void deleteAll(@Param("loanNo") String loanNo);
    /**
     * @Description: 删除还款计划表以后的数据
     * @Date: 2020/8/17 16:15
     * @Author: coffee
     * @Throws
     */
    void deleteOneByObject(@Param("loanNo")  String loanNo,@Param("psPerdNo")  Integer psPerdNo);
    /**
     * @Description: 删除还款计划表以后的数据
     * @Date: 2020/8/17 16:15
     * @Author: coffee
     * @Throws
     */
    void deleteAfterPerdNo(@Param("loanNo")  String loanNo,@Param("psPerdNo")  Integer psPerdNo);
    /**
     * @Description: 查找U最大期次
     * @param loanNo 借据号
     * @Date: 2020/8/17 16:15
     * @Author: zhuruilong
     * @Return java.util.List<com.caxs.minos.domain.LmPmShdDomain>
     * @Throws
     */
    LmPmShd findLastPerdNo(@Param("loanNo") String loanNo);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    List<LmPmShd> findAll(@Param("loanNo") String loanNo , @Param("psDueDt") String psDueDt, @Param("setlInd") String setlInd);
    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    List<LmPmShd> findShapePsGenProdTrans(@Param("loanNo") String loanNo , @Param("buzDate") String buzDate);
    /**
     * @Author coffee
     * @Description 查询大于当前业务日期的最近的一期还款计划
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    LmPmShd findMinPsDueDtAfterBuz(@Param("loanNo") String loanNo, @Param("psDueDt") String psDueDt);
    /**
     * 寻找最后一期还款计划表
     * @param loanNO
     * @return
     */
     LmPmShd getLastPmShd(String loanNO);
    /**
     * @Author coffee
     * @Description 返回指定日期的还款计划
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    List<LmPmShd> findByPsDueDt(@Param("loanNo") String loanNo , @Param("buzDate") String buzDate);
    /**
     * @Author coffee
     * @Description 返回指定日期的还款计划
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    List<LmPmShd> findOneTimePay(@Param("loanNo") String loanNo);
    /**
     * @Author coffee
     * @Description 返回指定日期的还款计划
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    List<LmPmShd> findShapeTrans(@Param("loanNo") String loanNo , @Param("psDueDt") String psDueDt,@Param("buzDate") String buzDate);
    /**
     * @Author coffee
     * @Description 查询大于等于当前业务日期且非主动还款的最小期的还款计划
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    LmPmShd findMinPsDueDtAfterEqualBuz(@Param("loanNo") String loanNo , @Param("psDueDt") String psDueDt );
    /**
     * @Author coffee
     * @Description 滚积数和结息根据借据号和到期日查询
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    List<LmPmShd> findShapPmShdStat(@Param("loanNo") String loanNo , @Param("psDueDt") String psDueDt);
    /**
     * @Author coffee
     * @Description 查询指定期号的未结清的利息状态为正常的还款计划
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    LmPmShd findCurPayTerm(@Param("loanNo") String loanNo , @Param("psPerdNo") int psPerdNo ,@Param("intState") String intState );
    /**
     * @Author coffee
     * @Description 查询指定结清状态的，大于当前业务日期的非0期还款计划
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    List<LmPmShd>  findLmPmShdAfterPsDueDt(@Param("loanNo") String loanNo,@Param("psDueDt") String psDueDt );
    /**
     * @Author coffee
     * @Description 查询指定借据的小于等于当前业务日志的最大期号
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    LmPmShd findMaxPerdNoBefore(@Param("loanNo") String loanNo , @Param("psDueDt") String psDueDt);

    /**
     * @Author coffee
     * @Description 查询指定结清状态的，小于等于当前业务日期且非0期，且未还本息大于0的还款计划
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    List<LmPmShd>  findAllNotReturnForOdInt(@Param("loanNo") String loanNo,@Param("psDueDt") String psDueDt );

    /**
     * @Description: 通过借据号查询所有还款计划
     * @param loanNo
     * @Date: 2020/10/13 10:45
     * @Author: zhuruilong
     * @Return java.util.List<com.caxs.minos.domain.LmPmShd>
     * @Throws
     */
    List<LmPmShd> findByLoanNo(@Param("loanNo") String loanNo);

    List<LmPmShd> findByLoanNoBeforePsDueDt(@Param("loanNo") String loanNo, @Param("psDueDt") String psDueDt);
    /**
     * @Description: 根据借据号查询到期日后还款计划表信息
     * @param loanNo 借据号
     * @Date: 2020/8/17 16:15
     * @Author: zhuruilong
     * @Return java.util.List<com.caxs.minos.domain.LmPmShdDomain>
     * @Throws
     */
    List<LmPmShd>  findByLoanNoAfterAllPsDueDt(@Param("loanNo") String loanNo, @Param("psDueDt") String psDueDt);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    void deleteByObject(@Param("loanNo") String loanNo, @Param("txLogSeq") String txLogSeq );
    /**
     * @Description: 根据借据号,时间查找小于等于当前时间的最近一期还款计划
     * @param loanNo 借据号
     * @Date: 2020/8/17 16:15
     * @Author: zhuruilong
     * @Return java.util.List<com.caxs.minos.domain.LmPmShdDomain>
     * @Throws
     */
    LmPmShd  findByLoanNoLastPsDueDt(@Param("loanNo") String loanNo, @Param("psDueDt") String psDueDt);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    List<LmPmShd> findByLoanNoNotSetl(@Param("loanNo") String loanNo, @Param("psDueDt") String psDueDt);
    /**
     * @Description: 删除当前借据号对应的所有还款计划
     * @param loanNo
     * @Date: 2020/10/13 10:48
     * @Author: zhuruilong
     * @Return void
     * @Throws
     */
    void deleteAfterPsDueDt(@Param("loanNo") String loanNo,@Param("psDueDt") String psDueDt);
    /**
     * @Description: 查询指定借据的小于等于当前业务日志的最大期号
     * @param loanNo 借据号
     * @Date: 2020/8/17 16:15
     * @Author: zhuruilong
     * @Return java.util.List<com.caxs.minos.domain.LmPmShdDomain>
     * @Throws
     */
    LmPmShd findMaxPerdNoAlterPsDueDt(@Param("loanNo") String loanNo, @Param("psDueDt") String psDueDt);
    /**
     * @Description: 查询指定借据的小于等于当前业务日志的最大期号
     * @param loanNo 借据号
     * @Date: 2020/8/17 16:15
     * @Author: zhuruilong
     * @Return java.util.List<com.caxs.minos.domain.LmPmShdDomain>
     * @Throws
     */
    List<LmPmShd> findByLoanNoBeforePsDueDtAll(@Param("loanNo") String loanNo, @Param("psDueDt") String psDueDt);
}
