package com.bangil.toy_sns.service;



import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.bangil.toy_sns.domain.Account;

import java.util.HashMap;


public interface AccountService {
    public void insertAccount(Account user);
    public List<Account> findAll();
    public ArrayList<HashMap<String, Object>> findAllByMap();
}
