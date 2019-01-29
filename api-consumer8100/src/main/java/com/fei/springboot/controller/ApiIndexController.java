package com.fei.springboot.controller;

import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.domain.*;
import com.fei.springboot.service.FeignApiIndexService;
import com.fei.springboot.cfgbeans.ApiBaseAction;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者: @author Harmon <br>
 * 时间: 2017-08-11 08:32<br>
 * 描述: ApiIndexController <br>
 */
@Api(tags = "首页接口文档")
@RestController
@RequestMapping("/api/index")
public class ApiIndexController extends ApiBaseAction {
    @Autowired
    public FeignApiIndexService apiIndexService;
    /**
     * 测试
     */
    @IgnoreAuth
    @PostMapping(value = "test")
    public Object test() {
        return toResponsMsgSuccess("请求成功yyy");
    }

    /**
     * app首页
     */
    @ApiOperation(value = "首页")
    @IgnoreAuth
    @PostMapping(value = "index")
    public Object index() {
        return apiIndexService.index();
    }


    /**
     * app首页
     */
    @ApiOperation(value = "新商品信息")
    @IgnoreAuth
    @PostMapping(value = "newGoods")
    public Object newGoods() {
        return apiIndexService.newGoods();
    }

    @ApiOperation(value = "新热门商品信息")
    @IgnoreAuth
    @PostMapping(value = "hotGoods")
    public Object hotGoods() {
        return apiIndexService.hotGoods();
    }

    @ApiOperation(value = "topic")
    @IgnoreAuth
    @PostMapping(value = "topic")
    public Object topic() {
        return apiIndexService.topic();
    }

    @ApiOperation(value = "brand")
    @IgnoreAuth
    @PostMapping(value = "brand")
    public Object brand() {
        return apiIndexService.banner();
    }

    @ApiOperation(value = "category")
    @IgnoreAuth
    @PostMapping(value = "category")
    public Object category() {
        return apiIndexService.category();
    }

    @ApiOperation(value = "banner")
    @IgnoreAuth
    @PostMapping(value = "banner")
    public Object banner() {
        return apiIndexService.banner();
    }

    @ApiOperation(value = "channel")
    @IgnoreAuth
    @PostMapping(value = "channel")
    public Object channel() {
        return apiIndexService.channel();
    }
}