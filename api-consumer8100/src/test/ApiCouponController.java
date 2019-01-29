package com.fei.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.*;
import com.fei.springboot.util.ApiBaseAction;
import com.fei.springboot.util.CharUtil;
import com.fei.springboot.util.J2CacheUtils;
import com.fei.springboot.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * API优惠券管理
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-23 15:31
 */
@Api(tags = "优惠券")
@RestController
@RequestMapping("/api/coupon")
public class ApiCouponController extends ApiBaseAction {
    /**
     * 获取优惠券列表
     */
    @ApiOperation(value = "获取优惠券列表")
    @PostMapping("/list")
    public Object list(@LoginUser UserVo loginUser) {
        return toResponsSuccess(couponVos);
    }

    /**
     * 根据商品获取可用优惠券列表
     */
    @ApiOperation(value = "根据商品获取可用优惠券列表")
    @PostMapping("/listByGoods")
    public Object listByGoods(@RequestParam(defaultValue = "cart") String type, @LoginUser UserVo loginUser) {
        return toResponsSuccess(useCoupons);
    }

    /**
     * 兑换优惠券
     */
    @ApiOperation(value = "领券优惠券")
    @PostMapping("exchange")
    public Object exchange(@LoginUser UserVo loginUser) {
        return toResponsSuccess(userCouponVo);
    }

    /**
     * 　　填写手机号码，领券
     */
    @ApiOperation(value = "领券优惠券")
    @PostMapping("newuser")
    public Object newuser(@LoginUser UserVo loginUser) {
            return toResponsFail("领取失败");
    }

    /**
     * 　　转发领取红包
     */
    @ApiOperation(value = "转发领取红包")
    @PostMapping("transActivit")
    public Object transActivit(@LoginUser UserVo loginUser, String sourceKey, Long referrer) {
            return toResponsFail("领取失败");
    }
}
