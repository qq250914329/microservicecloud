package com.fei.springboot.service;

import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.UserVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "API-PROVIDER")
public interface FeignApiFeedbackService {
    @PostMapping("/api/feedback/save")
    public Object save(@RequestBody UserVo loginUser);
}
