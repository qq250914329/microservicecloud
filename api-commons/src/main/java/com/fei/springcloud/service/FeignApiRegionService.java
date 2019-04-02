package com.fei.springcloud.service;

import com.fei.springcloud.config.FeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "API-PROVIDER",  configuration = FeignConfiguration.class)
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
