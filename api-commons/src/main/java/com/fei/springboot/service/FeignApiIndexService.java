package com.fei.springboot.service;

import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.domain.AddressVo;
import com.fei.springboot.domain.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "API-PROVIDER")
public interface FeignApiIndexService {

    /**
     * 测试
     */
    @PostMapping(value = "api/index/test")
    public Object test();

    @PostMapping(value = "api/index/index")
    public Object index();

    @PostMapping(value = "api/index/newGoods")
    public Object newGoods();


    @PostMapping(value = "api/index/hotGoods")
    public Object hotGoods();

    @PostMapping(value = "api/index/topic")
    public Object topic();

    @PostMapping(value = "api/index/brand")
    public Object brand();

    @PostMapping(value = "api/index/category")
    public Object category();

    @PostMapping(value = "api/index/banner")
    public Object banner();

    @PostMapping(value = "api/index/channel")
    public Object channel();
}
