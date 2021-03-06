package com.fei.springcloud.controller;

import com.fei.springcloud.annotation.IgnoreAuth;
import com.fei.springcloud.annotation.LoginUser;
import com.fei.springcloud.domain.KeywordsVo;
import com.fei.springcloud.domain.SearchHistoryVo;
import com.fei.springcloud.domain.UserVo;
import com.fei.springcloud.service.ApiKeywordsService;
import com.fei.springcloud.service.ApiSearchHistoryService;
import com.fei.springcloud.util.ApiBaseAction;
import com.fei.springcloud.util.Query;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API登录授权
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-23 15:31
 */
@Api(tags = "商品搜索")
@RestController
@RequestMapping("/api/search")
public class ApiSearchController extends ApiBaseAction {
    /**
     * 　　index
     */
    @ApiOperation(value = "搜索商品列表")
    @PostMapping("index")
    public Object index(@LoginUser UserVo loginUser) {
        return toResponsSuccess(resultObj);
    }

    /**
     * 　　helper
     */
    @ApiOperation(value = "搜索商品")
    @ApiImplicitParams({@ApiImplicitParam(name = "keyword", value = "关键字", paramType = "path", required = true)})
    @IgnoreAuth
    @PostMapping("helper")
    public Object helper(@LoginUser UserVo loginUser, String keyword) {
        return toResponsSuccess(keys);
    }

    /**
     * 　　clearhistory
     */
    @PostMapping("clearhistory")
    public Object clearhistory(@LoginUser UserVo loginUser) {
        return toResponsSuccess("");
    }
}
