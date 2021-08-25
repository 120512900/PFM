package com.example.pfm.mapper;

import com.example.pfm.entity.Account;
import com.example.pfm.entity.IncomeRecord;
import com.example.pfm.entity.IncomeRecordExample;
import com.example.pfm.resp.IncomeOfCategoryResp;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface IncomeRecordMapperCust {
    List<IncomeOfCategoryResp> selectIncome(Date date);
}