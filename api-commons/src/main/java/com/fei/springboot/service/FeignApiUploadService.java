package com.fei.springboot.service;

import com.fei.springboot.annotation.IgnoreAuth;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@FeignClient(value = "API-PROVIDER")
public interface FeignApiUploadService {
    @ApiOperation(value = "上传文件")
    @IgnoreAuth
    @PostMapping("/api/upload/upload")
    public Object upload(@RequestParam("file") MultipartFile file);
}
