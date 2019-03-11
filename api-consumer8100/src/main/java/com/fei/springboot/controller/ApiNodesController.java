package com.fei.springboot.controller;

import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.cfgbeans.ApiBaseAction;
import com.fei.springboot.domain.UserVo;
import com.fei.springboot.service.FeignApiNodesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 作者: @author Harmon <br>
 * 时间: 2017-08-11 08:32<br>
 * 描述: ApiIndexController <br>
 */
@Api(tags = "笔记")
@RestController
@RequestMapping("/api/nodes")
public class ApiNodesController extends ApiBaseAction{
    @Autowired
    FeignApiNodesService service;
    /**
     * 获取用户的笔记
     */
    @ApiOperation(value = "首页")
    @IgnoreAuth
    @PostMapping(value = "index")
    public Object list(@LoginUser UserVo loginUser) {
        return service.list(loginUser);
    }

    @ApiOperation(value = "首页")
    @IgnoreAuth
    @PostMapping(value = "changelist")
    public Object changelist(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             @RequestParam(value = "type") Integer type) {
        return service.changeList(page,size,type);
    }
    /**
     * 获取笔记的详情
     */
    @ApiOperation(value = "笔记详情", response = Map.class)
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "收获地址ID", required = true, dataType = "Integer")})
    @PostMapping("detail")
    public Object detail(Integer id, @LoginUser UserVo loginUser) {
        return service.detail(id,loginUser);
    }

    /**
     * 添加或更新笔记
     */
    @ApiOperation(value = "添加或更新收货笔记", response = Map.class)
    @PostMapping("save")
    public Object save(@LoginUser UserVo loginUser) {
        return service.save(loginUser,getJsonRequest());
    }

    /**
     * 删除指定的笔记
     */
    @ApiOperation(value = "删除指定的笔记", response = Map.class)
    @PostMapping("delete")
    public Object delete(@LoginUser UserVo loginUser) {
        return service.delete(loginUser,getJsonRequest());
    }
}