package com.fei.springboot.controller;

import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.cfgbeans.ApiBaseAction;
import com.fei.springboot.domain.OrderGoodsVo;
import com.fei.springboot.domain.OrderVo;
import com.fei.springboot.domain.UserVo;
import com.fei.springboot.service.FeignApiPayService;
import com.fei.springboot.util.*;
import com.fei.springboot.util.wechat.WechatRefundApiResult;
import com.fei.springboot.util.wechat.WechatUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;

/**
 * 作者: @author Harmon <br>
 * 时间: 2017-08-11 08:32<br>
 * 描述: ApiIndexController <br>
 */
@Api(tags = "商户支付")
@RestController
@RequestMapping("/api/pay")
public class ApiPayController extends ApiBaseAction {
    private Logger logger = Logger.getLogger(getClass());
    @Autowired
    private FeignApiPayService payService;

    /**
     */
    @ApiOperation(value = "跳转")
    @PostMapping("index")
    public Object index() {
        //
        return payService.index();
    }

    /**
     * 获取支付的请求参数
     */
    @ApiOperation(value = "获取支付的请求参数")
    @PostMapping("prepay")
    public Object payPrepay(@LoginUser UserVo loginUser, Integer orderId) {
        return payService.payPrepay(loginUser,orderId);
    }

    /**
     * 微信查询订单状态
     */
    @ApiOperation(value = "查询订单状态")
    @PostMapping("query")
    public Object orderQuery(@LoginUser UserVo loginUser, Integer orderId) {
        return payService.orderQuery(loginUser,orderId);
    }

    /**
     * 微信订单回调接口
     *
     * @return
     */
    @ApiOperation(value = "微信订单回调接口")
    @RequestMapping(value = "/notify", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void notify(HttpServletRequest request, HttpServletResponse response) {
        payService.notify(request,response);
    }

    /**
     * 订单退款请求
     */
    @ApiOperation(value = "订单退款请求")
    @PostMapping("refund")
    public Object refund(Integer orderId) {
        return payService.refund(orderId);
    }
}