package com.dayanghome.dayangerp.config;

import com.dayanghome.dayangerp.filter.LoginCheckFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class FilterConfig {

    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }

    @Bean
    public FilterRegistrationBean loginCheckFilter() {
        FilterRegistrationBean loginCheck = new FilterRegistrationBean();
        loginCheck.addUrlPatterns("/api/tob/*");
        loginCheck.setName("loginCheckFilter");
        LoginCheckFilter greetingFilter = new LoginCheckFilter();
        loginCheck.setFilter(greetingFilter);
        loginCheck.setOrder(1);
        return loginCheck;
    }
}
