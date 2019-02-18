package com.fei.springboot.service;

import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.config.FeignConfiguration;
import com.fei.springboot.domain.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "API-PROVIDER",  configuration = FeignConfiguration.class)
public interface FeignApiOrderService {

    @PostMapping("/api/order/index")
    public Object index();

    /**
     * 获取订单列表
     */
    @PostMapping("/api/order/list")
    public Object list(@RequestBody UserVo loginUser,
                       @RequestParam("page") Integer page,
                       @RequestParam("size") Integer size);
    /**
     * 获取订单详情
     */
    @PostMapping("/api/order/detail")
    public Object detail(@RequestParam("orderId")Integer orderId);

    @PostMapping("/api/order/updateSuccess")
    public Object updateSuccess(@RequestParam("orderId")Integer orderId);

    /**
     * 获取订单列表
     */
    @RequestMapping(value = "/api/order/submit", method = RequestMethod.POST ,consumes = "application/json")
    public Object submit(@RequestBody UserVo loginUser,@RequestParam("stringParam")String stringParam);

    /**
     * 获取订单列表
     */
    @PostMapping("/api/order/cancelOrder")
    public Object cancelOrder(@RequestParam("orderId")Integer orderId);

    /**
     * 确认收货
     */
    @PostMapping("/api/order/confirmOrder")
    public Object confirmOrder(@RequestParam("orderId")Integer orderId);
}
