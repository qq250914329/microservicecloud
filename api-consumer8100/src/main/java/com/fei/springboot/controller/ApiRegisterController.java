package com.fei.springboot.controller;

import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.service.FeignApiRegisterService;
import com.fei.springboot.util.Assert;
import com.fei.springboot.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-26 17:27
 */
@Api(tags = "注册")
@RestController
@RequestMapping("/api/register")
public class ApiRegisterController {
    @Autowired
    private FeignApiRegisterService registerService;

    /**
     * 注册
     */
    @ApiOperation(value = "注册")
    @IgnoreAuth
    @PostMapping("register")
    public R register(String mobile, String password) {
        return registerService.register(mobile,password);
    }
}
