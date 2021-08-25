package com.example.pfm.service;

import com.example.pfm.entity.IncomeRecord;
import com.example.pfm.mapper.IncomeRecordMapper;
import com.example.pfm.mapper.IncomeRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeRecordService {

    @Autowired
    private IncomeRecordMapper incomeRecordMapper;

    public List<IncomeRecord> list(){
        return incomeRecordMapper.selectByExample(null);
    }



    public boolean add(IncomeRecord incomeRecord){
        int flag =incomeRecordMapper.insert(incomeRecord);
        return flag==1;
    }

    public boolean update(IncomeRecord incomeRecord){
        int flag =incomeRecordMapper.updateByPrimaryKeySelective(incomeRecord);
        return flag==1;
    }

    public boolean delete(int id){
        int flag = incomeRecordMapper.deleteByPrimaryKey(id);
        return flag==1;
    }

}
