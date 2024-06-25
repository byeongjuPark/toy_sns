package com.bangil.toy_sns.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bangil.toy_sns.domain.Account;
import com.bangil.toy_sns.mapper.AccountMapper;



@Service

public class AccountServiceImp implements AccountService{
    private final AccountMapper accountMapper;

    AccountServiceImp(AccountMapper accountMapper){
        this.accountMapper = accountMapper;
    }


    @Override
    public void insertAccount(Account user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String pw = user.getPw();
        String encodedPw = encoder.encode(pw);

        user.setPw(encodedPw);
        accountMapper.insertAccount(user);
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
