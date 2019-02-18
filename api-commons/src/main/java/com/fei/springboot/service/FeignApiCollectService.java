package com.fei.springboot.service;

import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.config.FeignConfiguration;
import com.fei.springboot.domain.UserVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "API-PROVIDER",  configuration = FeignConfiguration.class)
public interface FeignApiCollectService {
    /**
     * 获取用户收藏
     */
    @PostMapping("/api/collect/list")
    public Object list(@RequestBody UserVo loginUser,@RequestParam("type_id") Integer typeId);

    /**
     * 获取用户收藏
     */
    @RequestMapping(value = "/api/collect/addordelete", method = RequestMethod.POST ,consumes = "application/json")
    public Object addordelete(@RequestBody UserVo loginUser,@RequestParam("stringParam")String stringParam);
}
