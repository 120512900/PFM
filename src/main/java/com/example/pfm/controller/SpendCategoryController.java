package com.example.pfm.controller;

import com.example.pfm.entity.SpendCategory;
import com.example.pfm.mapper.SpendCategoryMapper;
import com.example.pfm.req.SpendCategoryReq;
import com.example.pfm.service.SpendCategoryService;
import com.example.pfm.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/spendCategory")
public class SpendCategoryController {

    @Autowired
    private SpendCategoryService spendCategoryService;

    @GetMapping("/list")
    public List<SpendCategory> list() {
        return spendCategoryService.list();
    }
    @GetMapping("/allBudget")
    public BigDecimal getAllBudget(){

        return spendCategoryService.getAllBudget();

    }

  /*  @RequestMapping(value = "/post", method = RequestMethod.POST)
    public boolean add(String name) {
            SpendCategory spendCategory = new SpendCategory();
            spendCategory.setName(name);
            boolean flag = spendCategoryService.add(spendCategory);
            return flag;
        }
    }*/

    @RequestMapping(value = "/post-json", method = RequestMethod.POST)
    public boolean add1( @RequestBody SpendCategoryReq spendCategoryReq) {
        SpendCategory spendCategory = CopyUtil.copy(spendCategoryReq,SpendCategory.class);
        System.out.println(spendCategory.getName());
        boolean flag = spendCategoryService.add(spendCategory);
        return flag;
    }

    //修改
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public boolean update ( @RequestBody SpendCategory spendCategory){

        boolean flag = spendCategoryService.update(spendCategory);
        return flag;

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete (@PathVariable int id){
        boolean flag = spendCategoryService.delete(id);
        return flag;


    }

}
