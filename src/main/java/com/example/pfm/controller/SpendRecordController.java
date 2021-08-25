package com.example.pfm.controller;

import com.example.pfm.entity.IncomeRecord;
import com.example.pfm.entity.SpendRecord;
import com.example.pfm.mapper.SpendRecordMapper;
import com.example.pfm.req.*;
import com.example.pfm.resp.CommonResp;
import com.example.pfm.resp.PageResp;
import com.example.pfm.service.SpendRecordService;
import com.example.pfm.util.CopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/spendRecord")
public class SpendRecordController {

    @Autowired
    private SpendRecordService spendRecordService;

   /* @GetMapping("/list")
    public List<SpendRecord> list() {
        return spendRecordService.list();
    }*/

  /*  @RequestMapping(value = "/post", method = RequestMethod.POST)
    public boolean add(String name) {
            SpendRecord spendRecord = new SpendRecord();
            spendRecord.setName(name);
            boolean flag = spendRecordService.add(spendRecord);
            return flag;
        }
    }*/

    @GetMapping("/list")
    public CommonResp list(@Valid ListSpendRecordReq req) {
        CommonResp<PageResp<SpendRecord>> resp = new CommonResp<>();
        PageResp<SpendRecord> list = null;
        try {
            list = spendRecordService.list(req);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        resp.setContent(list);
        return resp;
    }

    @GetMapping("/spend")
    public BigDecimal getSpend(@Valid SpendReq req) {

        return spendRecordService.getSpend(req.getDate());
    }

    @RequestMapping(value = "/post-json", method = RequestMethod.POST)
    public boolean add1( @RequestBody SpendRecordReq spendRecordReq) {
        SpendRecord spendRecord = CopyUtil.copy(spendRecordReq,SpendRecord.class);
        boolean flag = spendRecordService.add(spendRecord);
        return flag;
    }

    //修改
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public boolean update ( @RequestBody SpendRecord spendRecord){

        boolean flag = spendRecordService.update(spendRecord);
        return flag;

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean delete (@PathVariable int id){
        boolean flag = spendRecordService.delete(id);
        return flag;


    }
}
