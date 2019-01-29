package com.fei.springboot.service;

import com.fei.springboot.annotation.IgnoreAuth;
import com.fei.springboot.domain.RegionVo;
import com.fei.springboot.domain.SysRegionEntity;
import com.fei.springboot.util.RegionCacheUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "API-PROVIDER")
public interface FeignApiRegionService {
    @PostMapping("/api/region/list")
    public Object list(@RequestParam("parentId") Integer parentId);

    @PostMapping("/api/region/provinceList")
    public Object provinceList();

    @PostMapping("/api/region/cityList")
    public Object provinceList(@RequestParam("proviceName")String proviceName);

    @PostMapping("/api/region/distinctList")
    public Object distinctList(@RequestParam("proviceName")String proviceName, @RequestParam("cityName")String cityName);

    @PostMapping("/api/region/info")
    public Object info(@RequestParam("regionId")Integer regionId);

    @PostMapping("/api/region/regionIdsByNames")
    public Object regionIdsByNames(@RequestParam("provinceName")String provinceName, @RequestParam("cityName")String cityName,@RequestParam("districtName") String districtName);
}
