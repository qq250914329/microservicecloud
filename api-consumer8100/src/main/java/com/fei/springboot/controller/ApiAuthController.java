package com.fei.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.cfgbeans.ApiBaseAction;
import com.fei.springboot.domain.FullUserInfo;
import com.fei.springboot.domain.UserInfo;
import com.fei.springboot.domain.UserVo;
import com.fei.springboot.service.FeignApiAuthService;
import com.fei.springboot.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * API登录授权
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-23 15:31
 */
@Api(tags = "API登录授权接口")
@RestController
@RequestMapping("/api/auth")
public class ApiAuthController extends ApiBaseAction {
    @Autowired
    FeignApiAuthService service;
    /**
     * 登录
     */
    @IgnoreAuth
    @PostMapping("login")
    @ApiOperation(value = "登录接口")
    public R login(String mobile, String password) {
        return service.login(mobile,password);
    }

    /**
     * 登录
     */
    @ApiOperation(value = "登录")
    @IgnoreAuth
    @PostMapping("login_by_weixin")
    public Object loginByWeixin() {
        return service.loginByWeixin(getJsonRequest());
    }
}
