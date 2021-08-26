package com.example.pfm.service;

import com.example.pfm.entity.IncomeRecord;
import com.example.pfm.entity.IncomeRecordExample;
import com.example.pfm.entity.SpendRecord;
import com.example.pfm.entity.SpendRecordExample;
import com.example.pfm.mapper.SpendRecordMapper;
import com.example.pfm.mapper.SpendRecordMapper;
import com.example.pfm.mapper.SpendRecordMapperCust;
import com.example.pfm.req.IncomeRecordReq;
import com.example.pfm.req.IncomeReq;
import com.example.pfm.req.ListSpendRecordReq;
import com.example.pfm.req.SpendReq;
import com.example.pfm.resp.IncomeOfCategoryResp;
import com.example.pfm.resp.PageResp;
import com.example.pfm.resp.SpendOfCategoryResp;
import com.example.pfm.util.CopyUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class SpendRecordService {

    @Autowired
    private SpendRecordMapper spendRecordMapper;

    @Autowired
    private SpendRecordMapperCust spendRecordMapperCust;

   /* public List<SpendRecord> list(){
        return spendRecordMapper.selectByExample(null);
    }*/
   public PageResp<SpendRecord> list(ListSpendRecordReq req) throws ParseException {
       SpendRecordExample spendRecordExample = new SpendRecordExample();
       SpendRecordExample.Criteria criteria = spendRecordExample.createCriteria();
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
       List<SpendRecord> spendRecordList = spendRecordMapper.selectByExample(spendRecordExample);

       PageInfo<SpendRecord> pageInfo = new PageInfo<>(spendRecordList);


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
       List<SpendRecord> list = CopyUtil.copyList(spendRecordList, SpendRecord.class);

       PageResp<SpendRecord> pageResp = new PageResp();
       pageResp.setTotal(pageInfo.getTotal());
       pageResp.setList(list);

       return pageResp;
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
    public BigDecimal getSpend(Date date)  {
        SpendRecordExample spendRecordExample = new SpendRecordExample();
        SpendRecordExample.Criteria criteria = spendRecordExample.createCriteria();
        if (!ObjectUtils.isEmpty(date)) {

            java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-01");
            java.util.Date firstDay = date;
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

        List<SpendRecord> spendRecordList = spendRecordMapper.selectByExample(spendRecordExample);
        List<SpendRecord> list = CopyUtil.copyList(spendRecordList, SpendRecord.class);

        BigDecimal ans = new BigDecimal("0.00");
        for(SpendRecord spendRecord:list){
            ans=ans.add(spendRecord.getAmount());
        }
        return ans;
    }

    public List<SpendOfCategoryResp> listCategory(SpendReq req) {

        System.out.println(req.getDate());
        return spendRecordMapperCust.selectIncome(req.getDate());
    }
}
