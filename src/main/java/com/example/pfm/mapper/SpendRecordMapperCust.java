package com.example.pfm.mapper;

import com.example.pfm.resp.IncomeOfCategoryResp;
import com.example.pfm.resp.SpendOfCategoryResp;

import java.util.Date;
import java.util.List;

public interface SpendRecordMapperCust {
    List<SpendOfCategoryResp> selectIncome(Date date);
}