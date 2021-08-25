package com.example.pfm.mapper;

import com.example.pfm.entity.IncomeCategory;
import com.example.pfm.entity.IncomeCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IncomeCategoryMapper {
    long countByExample(IncomeCategoryExample example);

    int deleteByExample(IncomeCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(IncomeCategory record);

    int insertSelective(IncomeCategory record);

    List<IncomeCategory> selectByExample(IncomeCategoryExample example);

    IncomeCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") IncomeCategory record, @Param("example") IncomeCategoryExample example);

    int updateByExample(@Param("record") IncomeCategory record, @Param("example") IncomeCategoryExample example);

    int updateByPrimaryKeySelective(IncomeCategory record);

    int updateByPrimaryKey(IncomeCategory record);
}