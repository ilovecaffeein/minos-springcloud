package com.caxs.minos.dao;

import com.caxs.minos.domain.LmLnRepcLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LmLnRepcLogDao {
    int deleteByPrimaryKey(@Param("loanNo") String loanNo, @Param("repcDt") String repcDt);

    int insert(LmLnRepcLog record);

    LmLnRepcLog selectByPrimaryKey(@Param("loanNo") String loanNo, @Param("repcDt") String repcDt);

    List<LmLnRepcLog> selectAll();

    int updateByPrimaryKey(LmLnRepcLog record);
}