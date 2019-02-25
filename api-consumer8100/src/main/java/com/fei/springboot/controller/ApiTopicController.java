package com.fei.springboot.controller;

import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.TopicVo;
import com.fei.springboot.domain.UserVo;
import com.fei.springboot.service.FeignApiTopicService;
import com.fei.springboot.cfgbeans.ApiBaseAction;
import com.fei.springboot.util.ApiPageUtils;
import com.fei.springboot.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者: @author Harmon <br>
 * 时间: 2017-08-11 08:32<br>
 * 描述: ApiIndexController <br>
 */
@RestController
@RequestMapping("/api/topic")
public class ApiTopicController extends ApiBaseAction {
    @Autowired
    private FeignApiTopicService topicService;

    /**
     */
    @IgnoreAuth
    @PostMapping("list")
    public Object list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                       @RequestParam(value = "size", defaultValue = "10") Integer size,
                       @RequestParam(value = "type", defaultValue = "10") Integer type) {
        return topicService.list(page,size,type);
    }

    /**
     */
    @IgnoreAuth
    @PostMapping("detail")
    public Object detail(@LoginUser UserVo loginUser, Integer id) {
        return topicService.detail(loginUser,id);
    }

    /**
     */
    @IgnoreAuth
    @PostMapping("related")
    public Object related(@LoginUser UserVo loginUser, Integer id) {
        return topicService.related(loginUser,id);
    }
}