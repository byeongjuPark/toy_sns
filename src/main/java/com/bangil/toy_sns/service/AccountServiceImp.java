package com.bangil.toy_sns.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.bangil.toy_sns.domain.Account;
import com.bangil.toy_sns.mapper.AccountMapper;



@Service

public class AccountServiceImp implements AccountService{
    private final AccountMapper accountMapper;

    public AccountServiceImp(AccountMapper accountMapper){
        this.accountMapper= accountMapper;
    }


    @Override
    public List<Account> findAll() {
        return accountMapper.findAll();
    }
    
    @Override
    public ArrayList<HashMap<String, Object>> findAllByMap(){
        return accountMapper.findAllByMap();
    }
    
}
