package com.fei.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.*;
import com.fei.springboot.service.FeignApiCartService;
import com.fei.springboot.cfgbeans.ApiBaseAction;
import com.fei.springboot.util.J2CacheUtils;
import com.qiniu.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者: @author Harmon <br>
 * 时间: 2017-08-11 08:32<br>
 * 描述: ApiIndexController <br>
 */
@Api(tags = "购物车")
@RestController
@RequestMapping("/api/cart")
public class ApiCartController extends ApiBaseAction {
    @Autowired
    FeignApiCartService service;
    /**
     * 获取购物车中的数据
     */
    @ApiOperation(value = "获取购物车中的数据")
    @PostMapping("getCart")
    public Object getCart(@LoginUser UserVo loginUser) {
        return service.getCart(loginUser);
    }

    /**
     * 获取购物车信息，所有对购物车的增删改操作，都要重新返回购物车的信息
     */
    @ApiOperation(value = "获取购物车信息")
    @PostMapping("index")
    public Object index(@LoginUser UserVo loginUser) {
        return service.index(loginUser);
    }


    /**
     * 添加商品到购物车
     */
    @ApiOperation(value = "添加商品到购物车")
    @PostMapping("add")
    public Object add(@LoginUser UserVo loginUser) {
        return service.add(loginUser,getJsonRequest());
    }

    /**
     * 减少商品到购物车
     */
    @ApiOperation(value = "减少商品到购物车")
    @PostMapping("minus")
    public Object minus(@LoginUser UserVo loginUser) {
        return service.minus(loginUser,getJsonRequest());
    }

    /**
     * 更新指定的购物车信息
     */
    @ApiOperation(value = "更新指定的购物车信息")
    @PostMapping("update")
    public Object update(@LoginUser UserVo loginUser) {
        return service.update(loginUser,getJsonRequest());
    }

    /**
     * 是否选择商品，如果已经选择，则取消选择，批量操作
     */
    @ApiOperation(value = "是否选择商品")
    @PostMapping("checked")
    public Object checked(@LoginUser UserVo loginUser) {
        return service.checked(loginUser,getJsonRequest());
    }

    //删除选中的购物车商品，批量删除
    @ApiOperation(value = "删除商品")
    @PostMapping("delete")
    public Object delete(@LoginUser UserVo loginUser) {
        return service.delete(loginUser,getJsonRequest());
    }

    //  获取购物车商品的总件件数
    @ApiOperation(value = "获取购物车商品的总件件数")
    @PostMapping("goodscount")
    public Object goodscount(@LoginUser UserVo loginUser) {
        return service.goodscount(loginUser);
    }

    /**
     * 订单提交前的检验和填写相关订单信息
     */
    @ApiOperation(value = "订单提交前的检验和填写相关订单信息")
    @PostMapping("checkout")
    public Object checkout(@LoginUser UserVo loginUser, Integer couponId, @RequestParam(defaultValue = "cart") String type) {
        return service.checkout(loginUser,couponId,type);
    }

    /**
     * 选择优惠券列表
     */
    @ApiOperation(value = "选择优惠券列表")
    @PostMapping("checkedCouponList")
    public Object checkedCouponList(@LoginUser UserVo loginUser) {
        return service.checkedCouponList(loginUser);
    }
}
