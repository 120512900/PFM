package com.example.pfm.service;

import com.example.pfm.entity.Account;
import com.example.pfm.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public BigDecimal getAmount(int id){
        Account account = accountMapper.selectByPrimaryKey(id);
        return account.getAmount();
    }
    public void putAmount(BigDecimal amount){
       accountMapper.update(amount);
    }

}
