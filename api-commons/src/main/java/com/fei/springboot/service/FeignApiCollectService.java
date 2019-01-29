package com.fei.springboot.service;

import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.UserVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "API-PROVIDER")
public interface FeignApiCollectService {
    /**
     * 获取用户收藏
     */
    @PostMapping("/api/collect/list")
    public Object list(@RequestBody UserVo loginUser,@RequestParam("type_id") Integer typeId);

    /**
     * 获取用户收藏
     */
    @PostMapping("/api/collect/addordelete")
    public Object addordelete(@RequestBody UserVo loginUser);
}
