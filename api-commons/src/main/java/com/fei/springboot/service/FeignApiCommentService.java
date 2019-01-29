package com.fei.springboot.service;

import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "API-PROVIDER")
public interface FeignApiCommentService {
    /**
     * 发表评论
     */
    @ApiOperation(value = "发表评论")
    @PostMapping("/api/comment/post")
    public Object post(@RequestBody UserVo loginUser);

    /**
     */
    @ApiOperation(value = "评论数量")
    @PostMapping("/api/comment/count")
    public Object count(@RequestParam("typeId") Integer typeId,@RequestParam("valueId") Integer valueId);

    /**
     * @param typeId
     * @param valueId
     * @param showType 选择评论的类型 0 全部， 1 只显示图片
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "选择评论类型")
    @IgnoreAuth
    @PostMapping("/api/comment/list")
    public Object list(@RequestParam("typeId")Integer typeId,@RequestParam("valueId") Integer valueId, @RequestParam("showType")Integer showType,
                       @RequestParam("page") Integer page, @RequestParam("size") Integer size,
                       @RequestParam("sort")String sort,@RequestParam("order") String order);
}
