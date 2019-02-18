package com.fei.springboot.provider8882.controller;

import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.domain.RegionVo;
import com.fei.springboot.domain.SysRegionEntity;
import com.fei.springboot.provider8882.service.SysRegionService;
import com.fei.springboot.provider8882.util.ApiBaseAction;
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
    SysRegionService sysRegionService;

    @ApiOperation(value = "地区列表")
    @IgnoreAuth
    @PostMapping("list")
    public Object list(Integer parentId) {
        if(null == RegionCacheUtil.sysRegionEntityList || RegionCacheUtil.sysRegionEntityList.size() < 1){
            RegionCacheUtil.sysRegionEntityList = sysRegionService.queryList(new HashMap<String, Object>());
        }
        List<SysRegionEntity> regionEntityList = RegionCacheUtil.getChildrenByParentId(parentId);
        List<RegionVo> regionVoList = new ArrayList<RegionVo>();
        if (null != regionEntityList && regionEntityList.size() > 0) {
            for (SysRegionEntity sysRegionEntity : regionEntityList) {
                regionVoList.add(new RegionVo(sysRegionEntity));
            }
        }
        return toResponsSuccess(regionVoList);
    }

    @IgnoreAuth
    @PostMapping("provinceList")
    public Object provinceList() {
        if(null == RegionCacheUtil.sysRegionEntityList || RegionCacheUtil.sysRegionEntityList.size() < 1){
            RegionCacheUtil.sysRegionEntityList = sysRegionService.queryList(new HashMap<String, Object>());
        }
        List<SysRegionEntity> regionEntityList = RegionCacheUtil.getAllProvice();
        List<RegionVo> regionVoList = new ArrayList<RegionVo>();
        if (null != regionEntityList && regionEntityList.size() > 0) {
            for (SysRegionEntity sysRegionEntity : regionEntityList) {
                regionVoList.add(new RegionVo(sysRegionEntity));
            }
        }
        return toResponsSuccess(regionVoList);
    }

    @IgnoreAuth
    @PostMapping("cityList")
    public Object provinceList(String proviceName) {
        if(null == RegionCacheUtil.sysRegionEntityList || RegionCacheUtil.sysRegionEntityList.size() < 1){
            RegionCacheUtil.sysRegionEntityList = sysRegionService.queryList(new HashMap<String, Object>());
        }
        List<SysRegionEntity> regionEntityList = RegionCacheUtil.getChildrenCity(proviceName);
        List<RegionVo> regionVoList = new ArrayList<RegionVo>();
        if (null != regionEntityList && regionEntityList.size() > 0) {
            for (SysRegionEntity sysRegionEntity : regionEntityList) {
                regionVoList.add(new RegionVo(sysRegionEntity));
            }
        }
        return toResponsSuccess(regionVoList);
    }

    @IgnoreAuth
    @PostMapping("distinctList")
    public Object distinctList(String proviceName, String cityName) {
        if(null == RegionCacheUtil.sysRegionEntityList || RegionCacheUtil.sysRegionEntityList.size() < 1){
            RegionCacheUtil.sysRegionEntityList = sysRegionService.queryList(new HashMap<String, Object>());
        }
        List<SysRegionEntity> regionEntityList = RegionCacheUtil.getChildrenDistrict(proviceName, cityName);
        List<RegionVo> regionVoList = new ArrayList<RegionVo>();
        if (null != regionEntityList && regionEntityList.size() > 0) {
            for (SysRegionEntity sysRegionEntity : regionEntityList) {
                regionVoList.add(new RegionVo(sysRegionEntity));
            }
        }
        return toResponsSuccess(regionVoList);
    }

    @IgnoreAuth
    @PostMapping("info")
    public Object info(Integer regionId) {
        if(null == RegionCacheUtil.sysRegionEntityList || RegionCacheUtil.sysRegionEntityList.size() < 1){
            RegionCacheUtil.sysRegionEntityList = sysRegionService.queryList(new HashMap<String, Object>());
        }
        SysRegionEntity regionEntity = RegionCacheUtil.getAreaByAreaId(regionId);
        return toResponsSuccess(new RegionVo(regionEntity));
    }

    @IgnoreAuth
    @PostMapping("regionIdsByNames")
    public Object regionIdsByNames(String provinceName, String cityName, String districtName) {
        if(null == RegionCacheUtil.sysRegionEntityList || RegionCacheUtil.sysRegionEntityList.size() < 1){
            RegionCacheUtil.sysRegionEntityList = sysRegionService.queryList(new HashMap<String, Object>());
        }
        Map<String, Integer> resultObj = new HashMap<String, Integer>();
        Integer provinceId = 0;
        Integer cityId = 0;
        Integer districtId = 0;
        if (null != provinceName) {
            provinceId = RegionCacheUtil.getProvinceIdByName(provinceName);
        }
        if (null != provinceId && !StringUtils.isNullOrEmpty(cityName)) {
            cityId = RegionCacheUtil.getCityIdByName(provinceId, cityName);
        }
        if (null != provinceId && null != cityId && !StringUtils.isNullOrEmpty(districtName)) {
            districtId = RegionCacheUtil.getDistrictIdByName(provinceId, cityId, districtName);
        }
        resultObj.put("provinceId", provinceId);
        resultObj.put("cityId", cityId);
        resultObj.put("districtId", districtId);
        return toResponsSuccess(resultObj);
    }
}