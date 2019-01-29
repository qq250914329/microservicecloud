package com.fei.springboot.service;

import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@FeignClient(value = "API-PROVIDER")
public interface FeignApiPayService {
    /**
     */
    @PostMapping("/api/pay/index")
    public Object index();

    /**
     * 获取支付的请求参数
     */
    @PostMapping("/api/pay/prepay")
    public Object payPrepay(@RequestBody UserVo loginUser, @RequestParam("orderId") Integer orderId);

    /**
     * 微信查询订单状态
     */
    @PostMapping("/api/pay/query")
    public Object orderQuery(@RequestBody UserVo loginUser, @RequestParam("orderId")Integer orderId);

    /**
     * 微信订单回调接口
     *
     * @return
     */
    @RequestMapping("/api/pay/notify")
    @ResponseBody
    public void notify(@RequestParam("request")HttpServletRequest request, @RequestParam("response")HttpServletResponse response);
    /**
     * 订单退款请求
     */
    @PostMapping("/api/pay/refund")
    public Object refund(@RequestParam("orderId")Integer orderId);
}
