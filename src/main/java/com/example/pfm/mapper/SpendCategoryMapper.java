package com.example.pfm.mapper;

import com.example.pfm.entity.SpendCategory;
import com.example.pfm.entity.SpendCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpendCategoryMapper {
    long countByExample(SpendCategoryExample example);

    int deleteByExample(SpendCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SpendCategory record);

    int insertSelective(SpendCategory record);

    List<SpendCategory> selectByExample(SpendCategoryExample example);

    SpendCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SpendCategory record, @Param("example") SpendCategoryExample example);

    int updateByExample(@Param("record") SpendCategory record, @Param("example") SpendCategoryExample example);

    int updateByPrimaryKeySelective(SpendCategory record);

    int updateByPrimaryKey(SpendCategory record);
}