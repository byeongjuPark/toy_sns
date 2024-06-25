package com.bangil.toy_sns.service.authentication;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Override
    public boolean loginJudge(String id, String pw){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        List<Account> user = authenticationMapper.findById(id);

        // 아이디 없으면 false
        if(user.size() == 0){
            return false;
        }
        return encoder.matches(pw, user.get(0).getPw());
    }
    
}
