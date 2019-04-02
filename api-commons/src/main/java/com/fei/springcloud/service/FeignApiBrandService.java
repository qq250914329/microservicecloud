package com.fei.springcloud.service;

import com.fei.springcloud.config.FeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "API-PROVIDER",  configuration = FeignConfiguration.class)
public interface FeignApiBrandService {
    /**
     * 分页获取品牌
     */
    @RequestMapping(value = "/api/brand/list", method = RequestMethod.POST ,consumes = "application/json")
    public Object list(@RequestParam("page") Integer page,
                       @RequestParam("size") Integer size);

    /**
     * 品牌详情
     */
    @RequestMapping(value = "/api/brand/detail", method = RequestMethod.POST ,consumes = "application/json")
    public Object detail(@RequestParam("id") Integer id);
}
