package com.caxs.minos.dao;

import com.caxs.minos.domain.LmLoan;
import com.caxs.minos.domain.trans.BatchJobContextTrans;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * 主要用于存放与借据相关的信息，包括期限、放款日期、生效日期、到期日、以及利率类型、利息罚息计算规则等等。
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmLoanDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return LmLoan
     */
    LmLoan selectOneByObject(LmLoan lmLoan);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    List<LmLoan> selectListByObject(LmLoan lmLoan);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     */
    void insert(LmLoan lmLoan);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     */
    void update(LmLoan lmLoan);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    List<LmLoan> fndBchInLoanNo();

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    List<LmLoan> searchRepayDataByJobContext(@Param("threadCntStr") String threadCntStr ,
                                             @Param("buzDate") String buzDate,@Param("atpySeqNo") String atpySeqNo);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    void updatePageFlagRepayByThdCnt(BatchJobContextTrans batchJobContextTrans);

    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    void executeUpdatePrcsPageDtInd(@Param("threadCntStr") String threadCntStr);

    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    List<LmLoan> findLoanInfoToKnotInstOrRollingPlot(@Param("threadCntStr") String threadCntStr);

    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    List<LmLoan> findBySetlForNormInt(@Param("threadCntStr") String threadCntStr , @Param("buzDate") String buzDate);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    void updatePageFlagRepayByThdCnt(@Param("threadCntStr") String threadCntStr , @Param("buzDate") String buzDate);
    /**
     * @Author coffee
     * @Description 根据扣款日和借据状态更新借据的当前应扣款日
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    void updateLmLoanByPsDueDtandLoanSts(String buzDate);
    /**
     * @Author coffee
     * @Description 根据扣款日和借据状态更新借据的当前应扣款日
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    List<LmLoan> findLmLoanByPsDueDtandLoanSts(String buzDate);
    /**
     * @Author coffee
     * @Description 根据下次同步利率日期nextSynRateDt查找借据信息
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    List<LmLoan> findLmLoanByNextSynRateDt(@Param("bchCde") String bchCde, @Param("buzDate")  String buzDate);
    /**
     * @Author coffee
     * @Description 更新正常状态且指定下次同步方式表利率日期的借据的分页标志为N
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    void updatePageIndByNextSynRateDt(String buzDate);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    List<LmLoan> newFindShapeTrans(String buzDate);
    /**
     * @Author coffee
     * @Description 更新页标志，用于形态转移
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    void updateShapeTransPageFlag(@Param("bchCde") String bchCde, @Param("buzDate")  String buzDate);
    /**
     * @Author coffee
     * @Description 更新借据的逾期标志
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    void updateLoanOdInd(@Param("bchCde") String bchCde, @Param("buzDate")  String buzDate);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    List<LmLoan> findByForIntAcc(String buzDate);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    List<LmLoan> findByForIntAccCntStr(@Param("threadCntStr") String threadCntStr , @Param("buzDate") String buzDate);
    /**
     * @Author coffee
     * @Description 更新借据的逾期标志
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    void updateForFindAccrualThdCnt(@Param("threadCntStr") String threadCntStr , @Param("buzDate") String buzDate);
    /**
     * @Author coffee
     * @Description 更新借据的逾期标志
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    void updateForFindAccrual(String buzDate);
    /**
     * @Author coffee
     * @Description 根据贷款状态及逾期标志更新借据的分页标志
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    void updateForOverdueAccrual(@Param("bchCde") String bchCde, @Param("loanDevInd") String loanDevInd,
                                 @Param("loanOdInd") String loanOdInd);
    /**
     * 根据机构号查询借据分页对象
     * @param buzDate
     * @param bchCde
     * @param loanDevInd
     * @param loanOdInd
     * @return
     */
     List<LmLoan> findForOverdueAccrual(@Param("bchCde") String bchCde,@Param("buzDate") String buzDate,
                                        @Param("loanDevInd") String loanDevInd,@Param("loanOdInd") String loanOdInd);

    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return LmLoan
     */
    LmLoan findByLoanNo(@Param("loanNo") String loanNo );
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    void deleteByObject(String loanNo, String txLogSeq );
    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    void updatePageFlagLoanRepayByThdCnt(@Param("threadCntStr") String threadCntStr , @Param("buzDate") String buzDate);
    /**
     * @Author coffee
     * @Description 根据下次同步利率日期nextSynRateDt查找借据信息
     * @Date  2020-09-14 12:34:09
     * @Param [lmLoan]
     * @return List<LmLoan>
     */
    List<LmLoan> findLmLoanInterByNextSynRateDt(String buzDate);
}
