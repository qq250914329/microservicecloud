package com.fei.springboot.provider8882.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.domain.CollectVo;
import com.fei.springboot.provider8882.dao.ApiCollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiCollectService {
    @Autowired
    private ApiCollectMapper collectDao;

    @ReadDataSource
    public CollectVo queryObject(Integer id) {
        return collectDao.queryObject(id);
    }

    @ReadDataSource
    public List<CollectVo> queryList(Map<String, Object> map) {
        return collectDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return collectDao.queryTotal(map);
    }

    @WriteDataSource
    public int save(CollectVo collect) {
        return collectDao.save(collect);
    }

    @WriteDataSource
    public void update(CollectVo collect) {
        collectDao.update(collect);
    }

    @WriteDataSource
    public int delete(Integer id) {
        return collectDao.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        collectDao.deleteBatch(ids);
    }

}
