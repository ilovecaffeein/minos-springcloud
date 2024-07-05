package com.caxs.minos.dao;

import com.caxs.minos.domain.LmNotify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface LmNotifyDao {
    int deleteByPrimaryKey(String seqNo);

    int insert(LmNotify record);

    LmNotify selectByPrimaryKey(String seqNo);

    List<LmNotify> selectAll();

    int updateByPrimaryKey(LmNotify record);

    List<LmNotify> selectByLmNotify(@Param("instuCde")  String instuCde, @Param("noteBussTyp")  String noteBussTyp);
}