package com.fei.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.BuyGoodsVo;
import com.fei.springboot.domain.UserVo;
import com.fei.springboot.cfgbeans.ApiBaseAction;
import com.fei.springboot.service.FeignApiBuyService;
import com.fei.springboot.util.J2CacheUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "商品购买")
@RestController
@RequestMapping("/api/buy")
public class ApiBuyController extends ApiBaseAction {
    @Autowired
    FeignApiBuyService service;

    @ApiOperation(value = "商品添加")
    @PostMapping("/add")
    public Object addBuy(@LoginUser UserVo loginUser) {
        service.addBuy(loginUser,getJsonRequest());
        return toResponsMsgSuccess("添加成功");
    }
}
