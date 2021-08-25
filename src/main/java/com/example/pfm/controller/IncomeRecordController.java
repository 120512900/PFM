package com.example.pfm.controller;

import com.example.pfm.entity.IncomeRecord;
import com.example.pfm.mapper.IncomeRecordMapper;
import com.example.pfm.req.AddIncomeRecordReq;
import com.example.pfm.req.IncomeRecordReq;
import com.example.pfm.req.IncomeReq;
import com.example.pfm.req.PageReq;
import com.example.pfm.resp.CommonResp;
import com.example.pfm.resp.IncomeOfCategoryResp;
import com.example.pfm.resp.PageResp;
import com.example.pfm.service.IncomeRecordService;
import com.example.pfm.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/incomeRecord")
public class IncomeRecordController {

    @Autowired
    private IncomeRecordService incomeRecordService;

    /*@GetMapping("/list")
    public List<IncomeRecord> list() {
        return incomeRecordService.list();
    }*/

    @GetMapping("/list")
    public CommonResp list(@Valid IncomeRecordReq req) {
        CommonResp<PageResp<IncomeRecord>> resp = new CommonResp<>();
        PageResp<IncomeRecord> list = null;
        try {
            list = incomeRecordService.list(req);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        resp.setContent(list);
        return resp;
    }

    @GetMapping("/listCategory")
    public CommonResp listCategory(@Valid IncomeReq req) {
        CommonResp<List> resp = new CommonResp<>();
        List<IncomeOfCategoryResp> list = incomeRecordService.listCategory(req);

        resp.setContent(list);
        return resp;
    }

    @GetMapping("/income")
    public BigDecimal getIncome(@Valid IncomeReq req) {

        return incomeRecordService.getIncome(req.getDate());
    }

  /*  @RequestMapping(value = "/post", method = RequestMethod.POST)
    public boolean add(String name) {
            IncomeRecord incomeRecord = new IncomeRecord();
            incomeRecord.setName(name);
            boolean flag = incomeRecordService.add(incomeRecord);
            return flag;
        }
    }*/

    @RequestMapping(value = "/post-json", method = RequestMethod.POST)
    public boolean add1( @RequestBody AddIncomeRecordReq incomeRecordReq) {
        IncomeRecord incomeRecord = CopyUtil.copy(incomeRecordReq,IncomeRecord.class);
        boolean flag = incomeRecordService.add(incomeRecord);
        return flag;
    }

    //修改
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public boolean update ( @RequestBody IncomeRecord incomeRecord){

        boolean flag = incomeRecordService.update(incomeRecord);
        return flag;

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete (@PathVariable int id){
        boolean flag = incomeRecordService.delete(id);
        return flag;


    }

}
