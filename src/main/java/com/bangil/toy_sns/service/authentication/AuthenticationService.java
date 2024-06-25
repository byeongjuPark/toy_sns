package com.bangil.toy_sns.service.authentication;

import java.util.List;

import com.bangil.toy_sns.domain.Account;

public interface AuthenticationService {
    
    public List<Account> findById(String id);

    public boolean loginJudge(String id, String pw);
}
