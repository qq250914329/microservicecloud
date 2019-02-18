package com.fei.springboot.service;

import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.config.FeignConfiguration;
import com.fei.springboot.domain.UserVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "API-PROVIDER",  configuration = FeignConfiguration.class)
public interface FeignApiTopicService {
    @IgnoreAuth
    @PostMapping("/api/topic/list")
    public Object list(@RequestParam("page") Integer page,
                       @RequestParam("size") Integer size);

    /**
     */
    @IgnoreAuth
    @PostMapping("/api/topic/detail")
    public Object detail(@RequestBody UserVo loginUser, @RequestParam("id") Integer id);

    /**
     */
    @IgnoreAuth
    @PostMapping("/api/topic/related")
    public Object related(@RequestBody UserVo loginUser, @RequestParam("id")Integer id);
}
