package com.fei.springboot.service;

import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.UserVo;
import com.fei.springboot.util.R;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "API-PROVIDER")
public interface FeignApiTestService {
    /**
     * 获取用户信息
     */
    @PostMapping("/api/test/userInfo")
    public R userInfo(@RequestBody UserVo user);

    /**
     * 忽略Token验证测试
     */
    @IgnoreAuth
    @PostMapping("/api/test/notToken")
    public R notToken();

    /**
     * 根据手机号查询用户信息接口测试方法
     *
     * @param mobile
     * @return
     */
    @IgnoreAuth
    @PostMapping("/api/test/userListByMobile")
    public R userList(@RequestParam("mobile") String mobile);
}
