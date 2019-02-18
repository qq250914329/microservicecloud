package com.fei.springboot.service;

import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.config.FeignConfiguration;
import com.fei.springboot.domain.UserVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "API-PROVIDER",  configuration = FeignConfiguration.class)
public interface FeignApiBuyService {
    @RequestMapping(value = "/api/buy/add", method = RequestMethod.POST ,consumes = "application/json")
    public Object addBuy(@RequestBody UserVo loginUser,@RequestParam("stringParam")String stringParam);
}
