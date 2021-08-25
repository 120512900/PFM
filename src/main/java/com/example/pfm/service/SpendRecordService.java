package com.example.pfm.service;

import com.example.pfm.entity.SpendRecord;
import com.example.pfm.mapper.SpendRecordMapper;
import com.example.pfm.mapper.SpendRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpendRecordService {

    @Autowired
    private SpendRecordMapper spendRecordMapper;

    public List<SpendRecord> list(){
        return spendRecordMapper.selectByExample(null);
    }



    public boolean add(SpendRecord spendRecord){
        int flag =spendRecordMapper.insert(spendRecord);
        return flag==1;
    }

    public boolean update(SpendRecord spendRecord){
        int flag =spendRecordMapper.updateByPrimaryKeySelective(spendRecord);
        return flag==1;
    }

    public boolean delete(int id){
        int flag = spendRecordMapper.deleteByPrimaryKey(id);
        return flag==1;
    }

}
