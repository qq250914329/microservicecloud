package com.fei.springcloud.provider8883.service;

import com.fei.springcloud.annotation.ReadDataSource;
import com.fei.springcloud.annotation.WriteDataSource;
import com.fei.springcloud.domain.KeywordsVo;
import com.fei.springcloud.provider8883.dao.ApiKeywordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiKeywordsService {
    @Autowired
    private ApiKeywordsMapper keywordsDao;

    @ReadDataSource
    public KeywordsVo queryObject(Integer id) {
        return keywordsDao.queryObject(id);
    }

    @ReadDataSource
    public List<KeywordsVo> queryList(Map<String, Object> map) {
        return keywordsDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return keywordsDao.queryTotal(map);
    }

    @WriteDataSource
    public void save(KeywordsVo goods) {
        keywordsDao.save(goods);
    }

    @WriteDataSource
    public void update(KeywordsVo goods) {
        keywordsDao.update(goods);
    }

    @WriteDataSource
    public void delete(Integer id) {
        keywordsDao.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        keywordsDao.deleteBatch(ids);
    }

    public List<Map> hotKeywordList(Map<String, Object> map) {
        return keywordsDao.hotKeywordList(map);
    }
}
