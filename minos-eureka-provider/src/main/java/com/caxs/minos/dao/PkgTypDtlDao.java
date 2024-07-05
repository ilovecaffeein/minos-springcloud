package com.caxs.minos.dao;

import com.caxs.minos.domain.PkgTypDtl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PkgTypDtlDao {
    int deleteByPrimaryKey(@Param("typId") Long typId, @Param("seqNo") Long seqNo);

    int insert(PkgTypDtl record);

    PkgTypDtl selectByPrimaryKey(@Param("typId") Long typId, @Param("seqNo") Long seqNo);

    List<PkgTypDtl> selectAll();

    List<PkgTypDtl>  findByTypId(@Param("typId") Long typId);

    int updateByPrimaryKey(PkgTypDtl record);
}