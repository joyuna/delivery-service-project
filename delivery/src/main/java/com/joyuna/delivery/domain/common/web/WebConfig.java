package com.joyuna.delivery.domain.common.web;

import com.joyuna.delivery.domain.common.web.interceptor.LogInterceptor;
import com.joyuna.delivery.domain.common.web.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error", "/swagger-ui/**", "/swagger-resources/**", "/api-docs/**");


        registry.addInterceptor(new LoginCheckInterceptor())
                .order(2)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/members", "/login", "/logout", "/css/**", "/*.ico", "/error", "/swagger-ui/**", "/swagger-resources/**", "/api-docs/**");
    }
}
