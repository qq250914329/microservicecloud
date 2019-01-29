package com.fei.springboot.service;

import com.fei.springboot.util.R;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "API-PROVIDER")
public interface FeignApiRegisterService {
    @PostMapping("/api/register/register")
    public R register(@RequestParam("mobile") String mobile, @RequestParam("password") String password);
}
