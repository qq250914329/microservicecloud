package com.fei.springboot.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.dao.ApiAdMapper;
import com.fei.springboot.domain.AdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiAdService {
    @Autowired
    private ApiAdMapper adDao;

    @ReadDataSource
    public AdVo queryObject(Integer id) {
        return adDao.queryObject(id);
    }

    @ReadDataSource
    public List<AdVo> queryList(Map<String, Object> map) {
        return this.adDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return adDao.queryTotal(map);
    }

    @WriteDataSource
    public void save(AdVo brand) {
        adDao.save(brand);
    }

    @WriteDataSource
    public void update(AdVo brand) {
        adDao.update(brand);
    }

    @WriteDataSource
    public void delete(Integer id) {
        adDao.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        adDao.deleteBatch(ids);
    }

}
