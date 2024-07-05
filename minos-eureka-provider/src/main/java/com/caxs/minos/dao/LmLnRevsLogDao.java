package com.caxs.minos.dao;

import com.caxs.minos.domain.LmLnRevsLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LmLnRevsLogDao {
    int deleteByPrimaryKey(Long txLogSeq);

    int insert(LmLnRevsLog record);

    LmLnRevsLog selectByPrimaryKey(Long txLogSeq);

    List<LmLnRevsLog> selectAll();

    int updateByPrimaryKey(LmLnRevsLog record);
}