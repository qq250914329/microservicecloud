package com.fei.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.UserVo;
import com.fei.springboot.service.FeignApiTestService;
import com.fei.springboot.util.R;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static com.netflix.hystrix.HystrixCollapserMetrics.getInstances;

/**
 * API测试接口
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-23 15:47
 */
@Api(tags = "测试接口")
@RestController
@RequestMapping("/api/test")
public class ApiTestController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private FeignApiTestService testService;

    @RequestMapping(value = "/getMicroServices", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public String testController1(){
        StringBuilder sb = new StringBuilder();
        Applications applications = eurekaClient.getApplications();
        eurekaClient.getApplications();
        for(Application application : applications.getRegisteredApplications()) {
            try {
                List<InstanceInfo> instanceInfoList = application.getInstances();
                for(InstanceInfo instance :instanceInfoList){
                    System.out.print(instance.getIPAddr());
                }
            }catch(Exception ex){
                //这里需要注意对于没有使用swagger的服务是无法调用swagger接口的，会抛出异常，需要对异常捕获后继续执行
                ex.printStackTrace();
                continue;
            }
        }
        return sb.toString();
    }

    @Autowired
    private EurekaClient eurekaClient;
    /**
     * 获取用户信息
     */
    @PostMapping("userInfo")
    public R userInfo(@LoginUser UserVo user) {
        return testService.userInfo(user);
    }

    /**
     * 忽略Token验证测试
     */
    @IgnoreAuth
    @PostMapping("notToken")
    public R notToken() {
        return testService.notToken();
    }

    /**
     * 根据手机号查询用户信息接口测试方法
     *
     * @param mobile
     * @return
     */
    @IgnoreAuth
    @PostMapping("userListByMobile")
    public R userList(String mobile) {
        return testService.userList(mobile);
    }
}
