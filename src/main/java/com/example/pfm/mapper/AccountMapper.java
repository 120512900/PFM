package com.example.pfm.mapper;

import com.example.pfm.entity.Account;

import java.math.BigDecimal;
import java.util.List;

import com.example.pfm.entity.IncomeCategory;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    Account selectByPrimaryKey(Integer id);
    void  update(BigDecimal amount);

}