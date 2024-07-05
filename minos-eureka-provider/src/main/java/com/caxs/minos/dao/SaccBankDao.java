package com.caxs.minos.dao;

import com.caxs.minos.domain.SaccBank;

import java.util.List;

public interface SaccBankDao {
    int deleteByPrimaryKey(String accBankCde);

    int insert(SaccBank record);

    SaccBank selectByPrimaryKey(String accBankCde);

    List<SaccBank> selectAll();

    int updateByPrimaryKey(SaccBank record);
}