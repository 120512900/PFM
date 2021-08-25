package com.example.pfm.mapper;

import com.example.pfm.entity.IncomeRecord;
import com.example.pfm.entity.IncomeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IncomeRecordMapper {
    long countByExample(IncomeRecordExample example);

    int deleteByExample(IncomeRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IncomeRecord record);

    int insertSelective(IncomeRecord record);

    List<IncomeRecord> selectByExample(IncomeRecordExample example);

    IncomeRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IncomeRecord record, @Param("example") IncomeRecordExample example);

    int updateByExample(@Param("record") IncomeRecord record, @Param("example") IncomeRecordExample example);

    int updateByPrimaryKeySelective(IncomeRecord record);

    int updateByPrimaryKey(IncomeRecord record);
}