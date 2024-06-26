package com.bangil.toy_sns.filter;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.bangil.toy_sns.domain.Account;
import com.bangil.toy_sns.service.AccountService;
import com.bangil.toy_sns.service.authentication.AuthenticationService;
import com.bangil.toy_sns.util.JwtProvider;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginFilter implements Filter {

    AuthenticationService authenticationService;

    @Autowired
    public LoginFilter(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false); // 세션이 없으면 null 반환
        
        if(session == null || session.getAttribute("token") == null){
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }

        JwtProvider jwtProvider = new JwtProvider();
        
        String token = session.getAttribute("token").toString().substring(7);
        String userName = jwtProvider.validate(token); // 유효하지 않은 토큰은 null 반환

        if(userName == null){
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }

        if (session != null) {
            
            List<Account> resultUser = authenticationService.findById(userName);
            if (resultUser.size() == 0) {
                // 알 수 없는 JWT 값 - 로그인 창으로 이동
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
                return;
            } else if(resultUser.size() == 1){
                if(!resultUser.get(0).getId().equals(userName)){
                    httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
                    return;
                } 
                else{
                    // 로그인 검증 완료 후 다음 필터로 전달
                    chain.doFilter(request, response);
                }
                
            }
        }
    }

}
