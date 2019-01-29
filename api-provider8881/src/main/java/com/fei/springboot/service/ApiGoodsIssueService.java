package com.fei.springboot.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.dao.ApiGoodsIssueMapper;
import com.fei.springboot.domain.GoodsIssueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiGoodsIssueService {
    @Autowired
    private ApiGoodsIssueMapper goodsIssueDao;

    @ReadDataSource
    public GoodsIssueVo queryObject(Integer id) {
        return goodsIssueDao.queryObject(id);
    }

    @ReadDataSource
    public List<GoodsIssueVo> queryList(Map<String, Object> map) {
        return goodsIssueDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return goodsIssueDao.queryTotal(map);
    }

    @WriteDataSource
    public void save(GoodsIssueVo goods) {
        goodsIssueDao.save(goods);
    }

    @WriteDataSource
    public void update(GoodsIssueVo goods) {
        goodsIssueDao.update(goods);
    }

    @WriteDataSource
    public void delete(Integer id) {
        goodsIssueDao.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        goodsIssueDao.deleteBatch(ids);
    }

}
