package com.example.pfm.controller;

import com.example.pfm.entity.Account;
import com.example.pfm.mapper.AccountMapper;
import com.example.pfm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/amount",method = RequestMethod.GET)
    public BigDecimal getAmount(){
        return accountService.getAmount(1);
    }

    @RequestMapping(value = "/amount",method = RequestMethod.PUT)
    public void getAmount(Account account){
        accountService.putAmount(account.getAmount());
    }
}
