package com.example.pfm.mapper;

import com.example.pfm.entity.SpendRecord;
import com.example.pfm.entity.SpendRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpendRecordMapper {
    long countByExample(SpendRecordExample example);

    int deleteByExample(SpendRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SpendRecord record);

    int insertSelective(SpendRecord record);

    List<SpendRecord> selectByExample(SpendRecordExample example);

    SpendRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SpendRecord record, @Param("example") SpendRecordExample example);

    int updateByExample(@Param("record") SpendRecord record, @Param("example") SpendRecordExample example);

    int updateByPrimaryKeySelective(SpendRecord record);

    int updateByPrimaryKey(SpendRecord record);
}