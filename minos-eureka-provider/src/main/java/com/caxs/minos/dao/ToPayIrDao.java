package com.caxs.minos.dao;

import com.caxs.minos.domain.ToPayIr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * TO_PAY_IR(扣款文件表流水)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-09-14 12:34:09
 */
@Mapper
public interface ToPayIrDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [toPayIr]
     * @return ToPayIr
     */
    ToPayIr selectOneByObject(ToPayIr toPayIr);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [toPayIr]
     * @return List<ToPayIr>
     */
    List<ToPayIr> selectListByObject(ToPayIr toPayIr);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-09-14 12:34:09
     * @Param [toPayIr]
     */
    void insert(ToPayIr toPayIr);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [toPayIr]
     */
    void update(ToPayIr toPayIr);
    /**
     * @Author coffee
     * @Description 查询扣款状态
     * @Date  2020-09-14 12:34:09
     * @Param requestParam
     */
    List<ToPayIr>  findByBuzDate(@Param("buzDt") String buzDt, @Param("pkgSts") String pkgSts,  @Param("atpySeqNo") String atpySeqNo);

    /**
     * @Author coffee
     * @Description 查询扣款状态
     * @Date  2020-09-14 12:34:09
     * @Param requestParam
     */
    List<ToPayIr>  findByToPayIrPkgSts(@Param("buzDt") String buzDt, @Param("pkgSts") String pkgSts);

    /**
     * @Author coffee
     * @Description 更新方法。
     * @Date  2020-09-14 12:34:09
     * @Param [toPayIr]
     */
    void updateByBuzDt(@Param("buzDt") String buzDt, @Param("pkgSts") String pkgSts,  @Param("atpySeqNo") String atpySeqNo);

}
