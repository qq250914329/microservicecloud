package com.fei.springboot.service;

import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "API-PROVIDER")
public interface FeignApiCouponService {
    /**
     * 获取优惠券列表
     */
    @ApiOperation(value = "获取优惠券列表")
    @PostMapping("/api/coupon/list")
    public Object list(@RequestBody UserVo loginUser);

    /**
     * 根据商品获取可用优惠券列表
     */
    @ApiOperation(value = "根据商品获取可用优惠券列表")
    @PostMapping("/api/coupon/listByGoods")
    public Object listByGoods(@RequestParam("cart") String type, @RequestBody UserVo loginUser);

    /**
     * 兑换优惠券
     */
    @ApiOperation(value = "领券优惠券")
    @PostMapping("/api/coupon/exchange")
    public Object exchange(@RequestBody UserVo loginUser);

    /**
     * 　　填写手机号码，领券
     */
    @ApiOperation(value = "领券优惠券")
    @PostMapping("/api/coupon/newuser")
    public Object newuser(@RequestBody UserVo loginUser);

    /**
     * 　　转发领取红包
     */
    @ApiOperation(value = "转发领取红包")
    @PostMapping("/api/coupon/transActivit")
    public Object transActivit(@RequestBody UserVo loginUser, @RequestParam("sourceKey")String sourceKey, @RequestParam("referrer")Long referrer);
}
