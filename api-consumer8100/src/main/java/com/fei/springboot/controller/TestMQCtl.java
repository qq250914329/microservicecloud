package com.fei.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.fei.springboot.service.FeignApiCtlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by huangrongyou@yixin.im on 2018/7/9.
 */
@Controller
@RequestMapping(value = "/ws")
public class TestMQCtl {
    private  static final Logger log = LoggerFactory.getLogger(TestMQCtl.class);
//    @Autowired
//    private SimpMessagingTemplate template;
    // 实现spring websocket需要引入AmqpTemplate类
    @Autowired
FeignApiCtlService apiCtlService;
    @RequestMapping(value = "loginIn", method = RequestMethod.POST)
    public String login(HttpServletRequest request, @RequestParam(required=true) String name, String pwd){
        return apiCtlService.list(request,name,pwd);
    }
    /**
     * 向执行用户发送请求
     * @param msg
     * @param name
     * @return
     */
    @RequestMapping(value = "send2user")
    @ResponseBody
    public String sendMq2User(String msg, String name){
        // 根据用户名称获取用户对应的session id值
        return apiCtlService.sendMq2User(msg,name);
    }

}
