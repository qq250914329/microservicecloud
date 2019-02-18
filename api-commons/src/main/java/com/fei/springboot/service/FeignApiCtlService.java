package com.fei.springboot.service;

import com.fei.springboot.config.FeignConfiguration;
import com.fei.springboot.domain.UserVo;
import org.apache.http.HttpRequest;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@FeignClient(value = "API-PROVIDER",  configuration = FeignConfiguration.class)
public interface FeignApiCtlService {
    /**
     * 获取用户的收货地址
     */
    @RequestMapping(value ="/ws/loginIn", method = RequestMethod.POST ,consumes = "application/json")
    public String list(@RequestParam("request")HttpServletRequest request, @RequestParam("name")String name , @RequestParam("pwd")String pwd);

    @RequestMapping(value = "/ws/send2user", method = RequestMethod.POST ,consumes = "application/json")
    public String sendMq2User(@RequestParam("msg") String msg, @RequestParam("userName") String userName);
}
