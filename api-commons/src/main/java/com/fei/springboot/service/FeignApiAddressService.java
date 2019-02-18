package com.fei.springboot.service;

import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.config.FeignConfiguration;
import com.fei.springboot.domain.AddressVo;
import com.fei.springboot.domain.UserVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.http.Header;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@FeignClient(value = "API-PROVIDER",  configuration = FeignConfiguration.class)
public interface FeignApiAddressService {
    /**
     * 获取用户的收货地址
     */
    @RequestMapping(value ="/api/address/list", method = RequestMethod.POST ,consumes = "application/json")
    public Object list(UserVo loginUser);

    /**
     * 获取收货地址的详情
     */
    @RequestMapping(value ="/api/address/detail", method = RequestMethod.POST ,consumes = "application/json")
    public Object detail(@RequestParam("id") Integer id, UserVo loginUser);

    /**
     * 添加或更新收货地址
     */
    @RequestMapping(value ="/api/address/save", method = RequestMethod.POST ,consumes = "application/json")
    public Object save(UserVo loginUser,@RequestParam("stringParam")String stringParam);

    /**
     * 删除指定的收货地址
     */
    @RequestMapping(value ="/api/address/delete",  method = RequestMethod.POST ,consumes = "application/json")
    public Object delete(UserVo loginUser,@RequestParam("stringParam")String stringParam);
}
