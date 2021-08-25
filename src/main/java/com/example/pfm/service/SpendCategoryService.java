package com.example.pfm.service;

import com.example.pfm.entity.IncomeCategory;
import com.example.pfm.entity.SpendCategory;
import com.example.pfm.mapper.IncomeCategoryMapper;
import com.example.pfm.mapper.SpendCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SpendCategoryService {

    @Autowired
    private SpendCategoryMapper spendCategoryMapper;

    public List<SpendCategory> list(){
        return spendCategoryMapper.selectByExample(null);
    }

    public BigDecimal getAllBudget(){
        List<SpendCategory> spendCategories=spendCategoryMapper.selectByExample(null);
        BigDecimal ans = new BigDecimal("0.00");
        for(SpendCategory spendCategory:spendCategories){
            ans=ans.add(spendCategory.getBudget());
        }
        return ans;

    }

    public boolean add(SpendCategory spendCategory){
        System.out.println(spendCategory.getName());
        int flag =spendCategoryMapper.insert(spendCategory);
        return flag==1;
    }

    public boolean update(SpendCategory spendCategory){
        int flag =spendCategoryMapper.updateByPrimaryKeySelective(spendCategory);
        return flag==1;
    }

    public boolean delete(int id){
        int flag = spendCategoryMapper.deleteByPrimaryKey(id);
        return flag==1;
    }

}
