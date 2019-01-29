package com.fei.springboot.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.dao.ApiGoodsSpecificationMapper;
import com.fei.springboot.domain.GoodsSpecificationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiGoodsSpecificationService {
    @Autowired
    private ApiGoodsSpecificationMapper goodsDao;

    @ReadDataSource
    public GoodsSpecificationVo queryObject(Integer id) {
        return goodsDao.queryObject(id);
    }

    @ReadDataSource
    public List<GoodsSpecificationVo> queryList(Map<String, Object> map) {
        return goodsDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return goodsDao.queryTotal(map);
    }

    @WriteDataSource
    public void save(GoodsSpecificationVo goods) {
        goodsDao.save(goods);
    }

    @WriteDataSource
    public void update(GoodsSpecificationVo goods) {
        goodsDao.update(goods);
    }

    @WriteDataSource
    public void delete(Integer id) {
        goodsDao.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        goodsDao.deleteBatch(ids);
    }

}
