package com.fei.springcloud.provider8883.service;

import com.fei.springcloud.annotation.ReadDataSource;
import com.fei.springcloud.annotation.WriteDataSource;
import com.fei.springcloud.domain.GoodsVo;
import com.fei.springcloud.provider8883.dao.ApiGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiGoodsService {
    @Autowired
    private ApiGoodsMapper goodsDao;

    @ReadDataSource
    public GoodsVo queryObject(Integer id) {
        return goodsDao.queryObject(id);
    }

    @ReadDataSource
    public List<GoodsVo> queryList(Map<String, Object> map) {
        return goodsDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return goodsDao.queryTotal(map);
    }

    @WriteDataSource
    public void save(GoodsVo goods) {
        goodsDao.save(goods);
    }

    @WriteDataSource
    public void update(GoodsVo goods) {
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
    @ReadDataSource
    public List<GoodsVo> queryHotGoodsList(Map<String, Object> map) {
        return goodsDao.queryHotGoodsList(map);
    }
    @ReadDataSource
    public List<GoodsVo> queryCatalogProductList(Map<String, Object> map) {
        return goodsDao.queryCatalogProductList(map);
    }
}
