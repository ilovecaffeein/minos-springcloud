package com.caxs.minos.dao;


import com.caxs.minos.domain.LmTdclCfg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 交易撤销配置LM_TDCL_CFG
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface LmTdclCfgDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmTfclCfg]
     * @return LmTdclCfg
     */
    LmTdclCfg selectOneByObject(LmTdclCfg lmTfclCfg);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmTfclCfg]
     * @return List<LmTdclCfg>
     */
    List<LmTdclCfg> selectListByObject(LmTdclCfg lmTfclCfg);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmTfclCfg]
     */
    void insert(LmTdclCfg lmTfclCfg);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmTfclCfg]
     */
    void update(LmTdclCfg lmTfclCfg);
}
