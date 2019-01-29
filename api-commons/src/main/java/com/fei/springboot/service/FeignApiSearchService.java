package com.fei.springboot.service;

import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.UserVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "API-PROVIDER")
public interface FeignApiSearchService {
    /**
     * 　　index
     */
    @PostMapping("/api/search/index")
    public Object index(@RequestBody UserVo loginUser);

    /**
     * 　　helper
     */
    @PostMapping("/api/search/helper")
    public Object helper(@RequestBody UserVo loginUser, @RequestParam("keyword") String keyword);

    /**
     * 　　clearhistory
     */
    @PostMapping("/api/search/clearhistory")
    public Object clearhistory(@RequestBody UserVo loginUser);
}
