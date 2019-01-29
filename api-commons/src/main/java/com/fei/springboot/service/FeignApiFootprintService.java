package com.fei.springboot.service;

import com.fei.springboot.annotation.LoginUser;
import com.fei.springboot.domain.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "API-PROVIDER")
public interface FeignApiFootprintService {
    @PostMapping("/api/footprint/delete")
    public Object delete(@RequestBody UserVo loginUser, @RequestParam("footprintId") Integer footprintId);

    /**
     */
    @ApiOperation(value = "获取足迹列表")
    @PostMapping("/api/footprint/list")
    public Object list(@RequestBody UserVo loginUser,
                       @RequestParam("page") Integer page,
                       @RequestParam("size") Integer size);

    /**
     */
    @ApiOperation(value = "分享足迹")
    @PostMapping("/api/footprint/sharelist")
    public Object sharelist(@RequestBody UserVo loginUser,
                            @RequestParam("page") Integer page,
                            @RequestParam("size") Integer size);
}
