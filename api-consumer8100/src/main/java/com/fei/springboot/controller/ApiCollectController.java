package com.fei.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.CollectVo;
import com.fei.springboot.domain.UserVo;
import com.fei.springboot.service.FeignApiCollectService;
import com.fei.springboot.cfgbeans.ApiBaseAction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者: @author Harmon <br>
 * 时间: 2017-08-11 08:32<br>
 * 描述: ApiIndexController <br>
 */
@Api(tags = "用户收藏")
@RestController
@RequestMapping("/api/collect")
public class ApiCollectController extends ApiBaseAction {
    @Autowired
    private FeignApiCollectService collectService;

    /**
     * 获取用户收藏
     */
    @ApiOperation(value = "获取用户收藏")
    @PostMapping("list")
    public Object list(@LoginUser UserVo loginUser, Integer typeId) {
        return collectService.list(loginUser,typeId);
    }

    /**
     * 获取用户收藏
     */
    @ApiOperation(value = "添加取消收藏")
    @PostMapping("addordelete")
    public Object addordelete(@LoginUser UserVo loginUser) {
        return collectService.addordelete(loginUser,getJsonRequest());
    }
}