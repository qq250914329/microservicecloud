package com.fei.springboot.service;

import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.config.FeignConfiguration;
import com.fei.springboot.domain.UserVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "API-PROVIDER",  configuration = FeignConfiguration.class)
public interface FeignApiFeedbackService {
    @RequestMapping(value = "/api/feedback/save", method = RequestMethod.POST ,consumes = "application/json")
    public Object save(@RequestBody UserVo loginUser,@RequestParam("stringParam")String stringParam);
}
