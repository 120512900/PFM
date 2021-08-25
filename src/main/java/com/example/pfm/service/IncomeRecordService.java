package com.example.pfm.service;

import com.example.pfm.entity.IncomeRecord;
import com.example.pfm.entity.IncomeRecordExample;
import com.example.pfm.entity.SpendCategory;
import com.example.pfm.mapper.IncomeRecordMapper;
import com.example.pfm.mapper.IncomeRecordMapper;
import com.example.pfm.mapper.IncomeRecordMapperCust;
import com.example.pfm.req.IncomeRecordReq;
import com.example.pfm.req.IncomeReq;
import com.example.pfm.req.PageReq;
import com.example.pfm.resp.IncomeOfCategoryResp;
import com.example.pfm.resp.PageResp;
import com.example.pfm.util.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class IncomeRecordService {

    @Autowired
    private IncomeRecordMapper incomeRecordMapper;

    @Autowired
    private IncomeRecordMapperCust incomeRecordMapperCust;

   /* public List<IncomeRecord> list(){
        return incomeRecordMapper.selectByExample(null);
    }*/
   public PageResp<IncomeRecord> list(IncomeRecordReq req) throws ParseException {
       IncomeRecordExample incomeRecordExample = new IncomeRecordExample();
       IncomeRecordExample.Criteria criteria = incomeRecordExample.createCriteria();
       if (!ObjectUtils.isEmpty(req.getDate())) {

           java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-01");
           java.util.Date firstDay=req.getDate();
          // System.out.println("the month first day is "+format.format(firstDay));
           firstDay = format.parse(format.format(firstDay)) ;
          // System.out.println("the month first day is "+firstDay);
            Date aDay= new Date(firstDay.toString());
           System.out.println("the month first day is "+aDay);
///////////////
          firstDay.setMonth(firstDay.getMonth()+1);
          firstDay.setDate(0);
           System.out.println("the month first day is "+firstDay);



           criteria.andDateBetween(aDay,firstDay);
                   //.andEmailEqualTo(req.getEmail());
       }
       PageHelper.startPage(req.getPage(), req.getSize());
       List<IncomeRecord> incomeRecordList = incomeRecordMapper.selectByExample(incomeRecordExample);

       PageInfo<IncomeRecord> pageInfo = new PageInfo<>(incomeRecordList);


       // List<UserResp> respList = new ArrayList<>();
       // for (User user : userList) {
       //     // UserResp userResp = new UserResp();
       //     // BeanUtils.copyProperties(user, userResp);
       //     // 对象复制
       //     UserResp userResp = CopyUtil.copy(user, UserResp.class);
       //
       //     respList.add(userResp);
       // }

       // 列表复制
       List<IncomeRecord> list = CopyUtil.copyList(incomeRecordList, IncomeRecord.class);

       PageResp<IncomeRecord> pageResp = new PageResp();
       pageResp.setTotal(pageInfo.getTotal());
       pageResp.setList(list);

       return pageResp;
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

    public BigDecimal getIncome(Date date)  {
        IncomeRecordExample incomeRecordExample = new IncomeRecordExample();
        IncomeRecordExample.Criteria criteria = incomeRecordExample.createCriteria();
        if (!ObjectUtils.isEmpty(date)) {

            java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-01");
            java.util.Date firstDay=date;
            // System.out.println("the month first day is "+format.format(firstDay));
            try {
                firstDay = format.parse(format.format(firstDay)) ;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // System.out.println("the month first day is "+firstDay);
            Date aDay= new Date(firstDay.toString());
            System.out.println("the month first day is "+aDay);
///////////////
            firstDay.setMonth(firstDay.getMonth()+1);
            firstDay.setDate(0);
            System.out.println("the month first day is "+firstDay);



            criteria.andDateBetween(aDay,firstDay);
            //.andEmailEqualTo(req.getEmail());
        }

        List<IncomeRecord> incomeRecordList = incomeRecordMapper.selectByExample(incomeRecordExample);
        List<IncomeRecord> list = CopyUtil.copyList(incomeRecordList, IncomeRecord.class);

        BigDecimal ans = new BigDecimal("0.00");
        for(IncomeRecord incomeRecord:list){
            ans=ans.add(incomeRecord.getAmount());
        }
        return ans;
    }

    public List<IncomeOfCategoryResp> listCategory(IncomeReq req) {

System.out.println(req.getDate());
         return incomeRecordMapperCust.selectIncome(req.getDate());
    }
}
