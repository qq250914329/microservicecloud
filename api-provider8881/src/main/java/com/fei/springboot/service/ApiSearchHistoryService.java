package com.fei.springboot.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.dao.ApiSearchHistoryMapper;
import com.fei.springboot.domain.SearchHistoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiSearchHistoryService {
    @Autowired
    private ApiSearchHistoryMapper searchHistoryDao;

    @ReadDataSource
    public SearchHistoryVo queryObject(Integer id) {
        return searchHistoryDao.queryObject(id);
    }

    @ReadDataSource
    public List<SearchHistoryVo> queryList(Map<String, Object> map) {
        return searchHistoryDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return searchHistoryDao.queryTotal(map);
    }

    @WriteDataSource
    public void save(SearchHistoryVo region) {
        searchHistoryDao.save(region);
    }

    @WriteDataSource
    public void update(SearchHistoryVo region) {
        searchHistoryDao.update(region);
    }

    @WriteDataSource
    public void delete(Integer id) {
        searchHistoryDao.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        searchHistoryDao.deleteBatch(ids);
    }
    @WriteDataSource
    public void deleteByUserId(Long userId) {
        searchHistoryDao.deleteByUserId(userId);
    }
}
