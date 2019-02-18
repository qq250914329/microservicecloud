package com.fei.springboot.service;

import com.fei.springboot.config.FeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "API-PROVIDER",  configuration = FeignConfiguration.class)
public interface FeignApiCatalogService {
    /**
     * 获取分类栏目数据
     */
    @PostMapping(value = "/api/catalog/index")
    public Object index(@RequestParam("id")Integer id,
                        @RequestParam("page") Integer page,
                        @RequestParam("size") Integer size,
                        @RequestParam("isShow") Integer isShow);

    /**
     */
    @PostMapping(value = "/api/catalog/current")
    public Object current(@RequestParam("id")Integer id);
}
