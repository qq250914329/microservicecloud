package com.fei.springcloud.service;

import com.fei.springcloud.annotation.IgnoreAuth;
import com.fei.springcloud.config.FeignConfiguration;
import com.fei.springcloud.domain.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(value = "API-PROVIDER",  configuration = FeignConfiguration.class)
public interface FeignApiCommentService {
    /**
     * 发表评论
     */
    @ApiOperation(value = "发表评论")
    @RequestMapping(value = "/api/comment/post", method = RequestMethod.POST ,consumes = "application/json")
    public Object post(@RequestBody UserVo loginUser,@RequestParam("stringParam")String stringParam);

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
