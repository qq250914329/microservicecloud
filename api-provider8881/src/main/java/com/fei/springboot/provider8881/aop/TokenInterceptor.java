package com.fei.springboot.provider8881.aop;

import com.fei.springboot.provider8882.util.AuthorizationInterceptor;
import com.fei.springboot.provider8882.util.LoginUserHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2019/1/7.
 */
@Configuration
public class TokenInterceptor extends WebMvcConfigurerAdapter {
    @Autowired
    AuthorizationInterceptor authorizationInterceptor;
    @Autowired
    LoginUserHandlerMethodArgumentResolver methodArgumentResolver;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor);
    }
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(methodArgumentResolver);
    }
}

