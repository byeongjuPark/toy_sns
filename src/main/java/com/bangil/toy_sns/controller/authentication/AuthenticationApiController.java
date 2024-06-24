package com.bangil.toy_sns.controller.authentication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bangil.toy_sns.domain.Account;
import com.bangil.toy_sns.service.authentication.AuthenticationService;


@RestController
@RequestMapping("/api")
public class AuthenticationApiController {
    
    private AuthenticationService authenticationService;

    AuthenticationApiController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping(value = "/login")
    public String loginApi(String id, String pw) {
        
        return "su";
    }

    @PostMapping(value = "/duplicateCheck")
    
    public Map<String, Object> duplicateCheck(String id) {
        Map<String, Object> result = new HashMap<String, Object>();

        List<Account> resultUser = authenticationService.findById(id);

        if(resultUser == null){
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
        
        
        return result;
    }

    
}

