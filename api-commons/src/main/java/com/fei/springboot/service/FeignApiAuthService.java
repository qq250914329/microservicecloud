package com.fei.springboot.service;

import com.alibaba.fastjson.JSONObject;
import com.fei.springboot.config.FeignConfiguration;
import com.fei.springboot.util.R;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "API-PROVIDER",  configuration = FeignConfiguration.class)
public interface FeignApiAuthService {
    /**
     * 登录
     */
    @RequestMapping(value = "/api/auth/login", method = RequestMethod.POST ,consumes = "application/json")
    public R login(@RequestParam("mobile")String mobile,@RequestParam("password") String password);

    /**
     * 登录
     */
    @RequestMapping(value = "/api/auth/login_by_weixin", method = RequestMethod.POST ,consumes = "application/json")
    public Object loginByWeixin(@RequestParam("stringParam")String stringParam);
}
