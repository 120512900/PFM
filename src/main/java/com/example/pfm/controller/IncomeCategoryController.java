package com.example.pfm.controller;

import com.example.pfm.entity.IncomeCategory;
import com.example.pfm.mapper.IncomeCategoryMapper;
import com.example.pfm.req.IncomeCategoryReq;
import com.example.pfm.service.IncomeCategoryService;
import com.example.pfm.util.CopyUtil;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incomeCategory")
public class IncomeCategoryController {

    @Autowired
    private IncomeCategoryService incomeCategoryService;

    @GetMapping("/list")
    public List<IncomeCategory> list() {
        return incomeCategoryService.list();
    }

  /*  @RequestMapping(value = "/post", method = RequestMethod.POST)
    public boolean add(String name) {
            IncomeCategory incomeCategory = new IncomeCategory();
            incomeCategory.setName(name);
            boolean flag = incomeCategoryService.add(incomeCategory);
            return flag;
        }
    }*/

    @RequestMapping(value = "/post-json", method = RequestMethod.POST)
    public boolean add1( @RequestBody IncomeCategoryReq incomeCategoryReq) {
        IncomeCategory incomeCategory = CopyUtil.copy(incomeCategoryReq,IncomeCategory.class);
            boolean flag = incomeCategoryService.add(incomeCategory);
            return flag;
    }

    //修改
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public boolean update ( @RequestBody IncomeCategory incomeCategory){

                boolean flag = incomeCategoryService.update(incomeCategory);
                return flag;

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete (@PathVariable int id){
            boolean flag = incomeCategoryService.delete(id);
            return flag;


    }

}
