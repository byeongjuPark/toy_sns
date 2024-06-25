package com.bangil.toy_sns.controller.authentication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bangil.toy_sns.domain.Account;
import com.bangil.toy_sns.service.AccountService;
import com.bangil.toy_sns.service.authentication.AuthenticationService;
import com.bangil.toy_sns.util.JwtProvider;

import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/api")
public class AuthenticationApiController {

    
    
    private AuthenticationService authenticationService;
    private AccountService accountService;

    @Autowired
    public AuthenticationApiController(AuthenticationService authenticationService, AccountService accountService) {
        this.authenticationService = authenticationService;
        this.accountService = accountService;
    }

    @PostMapping(value = "/login")
    public Map<String, Object> loginApi(String id, String pw, HttpSession session) {
        Map<String, Object> result = new HashMap<String, Object>();

        JwtProvider jwtProvider = new JwtProvider();

        boolean loginJudge = authenticationService.loginJudge(id, pw);

        if(loginJudge){
            String token = jwtProvider.create(id);
            session.setAttribute("token", "bearer " + token);
            result.put("code", "su");
            //result.put("token", token);
        } else {
            result.put("code", "fa");
        }
        return result;
    }

    @PostMapping(value = "/duplicateCheck")
    public Map<String, Object> duplicateCheck(String id) {
        Map<String, Object> result = new HashMap<String, Object>();
        
        List<Account> resultUser = authenticationService.findById(id);

        if(resultUser.size() == 0){
            result.put("code", "su");
        } else {
            result.put("code", "fa");
        }
        return result;
    }

    @PostMapping(value = "/register")
    public Map<String, Object> register(String id, String pw, String gener) {
        Map<String, Object> result = new HashMap<String, Object>();

        Account user = new Account();
        user.setId(id);
        user.setPw(pw);
        user.setSex(gener);

        // 회원 가입 인서트 서비스
        // 서비스 로직에서는 pw암호화 포함
        accountService.insertAccount(user);
        
        return result;
    }

    
}

