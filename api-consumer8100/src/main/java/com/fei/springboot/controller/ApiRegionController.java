package com.fei.springboot.controller;

import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.domain.RegionVo;
import com.fei.springboot.domain.SysRegionEntity;
import com.fei.springboot.service.FeignApiRegionService;
import com.fei.springboot.cfgbeans.ApiBaseAction;
import com.fei.springboot.util.RegionCacheUtil;
import com.fei.springboot.util.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "评论")
@RestController
@RequestMapping("/api/region")
public class ApiRegionController extends ApiBaseAction {

    @Autowired
    FeignApiRegionService regionService;

    @ApiOperation(value = "地区列表")
    @IgnoreAuth
    @PostMapping("list")
    public Object list(Integer parentId) {
        return regionService.list(parentId);
    }

    @IgnoreAuth
    @PostMapping("provinceList")
    public Object provinceList() {
        return regionService.provinceList();
    }

    @IgnoreAuth
    @PostMapping("cityList")
    public Object provinceList(String proviceName) {
        return regionService.provinceList(proviceName);
    }

    @IgnoreAuth
    @PostMapping("distinctList")
    public Object distinctList(String proviceName, String cityName) {
        return regionService.distinctList(proviceName,cityName);
    }

    @IgnoreAuth
    @PostMapping("info")
    public Object info(Integer regionId) {
        return regionService.info(regionId);
    }

    @IgnoreAuth
    @PostMapping("regionIdsByNames")
    public Object regionIdsByNames(String provinceName, String cityName, String districtName) {
        return regionService.regionIdsByNames(provinceName,cityName,districtName);
    }
}