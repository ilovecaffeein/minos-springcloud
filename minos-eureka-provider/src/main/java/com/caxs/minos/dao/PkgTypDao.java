package com.caxs.minos.dao;

import com.caxs.minos.domain.PkgTyp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PkgTypDao {
    int deleteByPrimaryKey(Long typId);

    int insert(PkgTyp record);

    PkgTyp selectByPrimaryKey(Long typId);

    List<PkgTyp> selectAll();

    int updateByPrimaryKey(PkgTyp record);
}