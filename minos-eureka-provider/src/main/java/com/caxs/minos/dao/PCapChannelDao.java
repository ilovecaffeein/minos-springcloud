package com.caxs.minos.dao;

import com.caxs.minos.domain.PCapChannel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * P_CAP_CHANNEL(资金渠道管理)
 * @author fengdetian
 * @email 123@qq.com
 * @date 2020-10-20 16:43:44
 */
@Mapper
public interface PCapChannelDao {

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-10-20 16:43:44
     * @Param [pCapChannel]
     * @return PCapChannel
     */
    PCapChannel selectOneByObject(PCapChannel pCapChannel);

    /**
     * @Author fengdetian
     * @Description 通用查询方法。
     * @Date  2020-10-20 16:43:44
     * @Param [pCapChannel]
     * @return List<PCapChannel>
     */
    List<PCapChannel> selectListByObject(PCapChannel pCapChannel);

    /**
     * @Author fengdetian
     * @Description 新增方法。
     * @Date  2020-10-20 16:43:44
     * @Param [pCapChannel]
     */
    void insert(PCapChannel pCapChannel);

    /**
     * @Author fengdetian
     * @Description 更新方法。
     * @Date  2020-10-20 16:43:44
     * @Param [pCapChannel]
     */
    void update(PCapChannel pCapChannel);
    /**
     * @Author coffee
     * @Description 通用查询方法。
     * @Date  2020-09-14 12:34:09
     * @Param [lmSbsyLog]
     * @return List<LmSbsyLog>
     */
    PCapChannel findCapCde(@Param("trstCapCde") String trstCapCde, @Param("sts") String sts);
}
