package com.bangil.toy_sns.service.authentication;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bangil.toy_sns.domain.Account;
import com.bangil.toy_sns.mapper.AuthenticationMapper;

@Service
public class AuthenticationServiceImp implements AuthenticationService{

    private AuthenticationMapper authenticationMapper;

    AuthenticationServiceImp(AuthenticationMapper authenticationMapper){
        this.authenticationMapper = authenticationMapper;
    }

    @Override
    public List<Account> findById(String id) {
        return authenticationMapper.findById(id);
    }
    
}
