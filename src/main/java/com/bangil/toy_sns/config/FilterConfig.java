package com.bangil.toy_sns.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bangil.toy_sns.filter.LoginFilter;
import com.bangil.toy_sns.service.authentication.AuthenticationService;

@Configuration
public class FilterConfig {

    @Autowired
    private AuthenticationService authenticationService;

    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilterRegistrationBean() {
        FilterRegistrationBean<LoginFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoginFilter(authenticationService));
        registrationBean.addUrlPatterns("/test/*"); // 필터를 적용할 URL 패턴 설정
        return registrationBean;
    }
}
