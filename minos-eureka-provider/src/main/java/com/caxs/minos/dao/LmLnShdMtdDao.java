package com.caxs.minos.dao;


import com.caxs.minos.domain.LmLnShdMtd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 07.LM_LN_SHD_MTD(还款方式表)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmLnShdMtdDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLnShdMtd]
     * @return LmLnShdMtd
     */
    LmLnShdMtd selectOneByObject(LmLnShdMtd lmLnShdMtd);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLnShdMtd]
     * @return List<LmLnShdMtd>
     */
    List<LmLnShdMtd> selectListByObject(LmLnShdMtd lmLnShdMtd);
    /**
     * @Author coffee
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLnShdMtd]
     */
    void insertList(List<LmLnShdMtd> list);
    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLnShdMtd]
     */
    void insert(LmLnShdMtd lmLnShdMtd);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmLnShdMtd]
     */
    void update(LmLnShdMtd lmLnShdMtd);

    /**
     * @Author coffee
     * @Description 根据起止期号查询指定借据的还款方式信息
     * @Date  2020-09-14 12:34:09
     * @Param [lmLnShdMtd]
     * @return LmLnShdMtd
     */
    LmLnShdMtd findPayingTermNo(@Param("loanNo") String loanNo , @Param("currPayingPerdNo") int currPayingPerdNo);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:08
     * @Param [lmPmShd]
     * @return List<LmPmShd>
     */
    void deleteByObject(@Param("loanNo") String loanNo);
}
