package com.fei.springboot.service;

import com.fei.springboot.annotation.IgnoreAuth;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "API-PROVIDER")
public interface FeignApiHelpssueService {
    /**
     * 查看帮助类型列表
     */
    @RequestMapping("/api/helpissue/typeList")
    @IgnoreAuth
    public Object typeList();

    /**
     * 查看问题列表
     */
    @RequestMapping("/api/helpissue/issueList")
    @IgnoreAuth
    public Object issueList(@RequestParam("type_id") Long type_id);
}
