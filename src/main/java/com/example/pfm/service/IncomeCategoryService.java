package com.example.pfm.service;

import com.example.pfm.entity.IncomeCategory;
import com.example.pfm.mapper.IncomeCategoryMapper;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class IncomeCategoryService {

    @Autowired
    private IncomeCategoryMapper incomeCategoryMapper;

    public List<IncomeCategory> list(){
        return incomeCategoryMapper.selectByExample(null);
    }



    public boolean add(IncomeCategory incomeCategory){
        int flag =incomeCategoryMapper.insert(incomeCategory);
        return flag==1;
    }

    public boolean update(IncomeCategory incomeCategory){
        int flag =incomeCategoryMapper.updateByPrimaryKeySelective(incomeCategory);
        return flag==1;
    }

    public boolean delete(int id){
        int flag = incomeCategoryMapper.deleteByPrimaryKey(id);
        return flag==1;
    }


}
