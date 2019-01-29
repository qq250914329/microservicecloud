package com.fei.springboot.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.dao.ApiGoodsGalleryMapper;
import com.fei.springboot.domain.GoodsGalleryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiGoodsGalleryService {
    @Autowired
    private ApiGoodsGalleryMapper goodsGalleryDao;

    @ReadDataSource
    public GoodsGalleryVo queryObject(Integer id) {
        return goodsGalleryDao.queryObject(id);
    }

    @ReadDataSource
    public List<GoodsGalleryVo> queryList(Map<String, Object> map) {
        return goodsGalleryDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return goodsGalleryDao.queryTotal(map);
    }

    @WriteDataSource
    public void save(GoodsGalleryVo goods) {
        goodsGalleryDao.save(goods);
    }

    @WriteDataSource
    public void update(GoodsGalleryVo goods) {
        goodsGalleryDao.update(goods);
    }

    @WriteDataSource
    public void delete(Integer id) {
        goodsGalleryDao.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        goodsGalleryDao.deleteBatch(ids);
    }

}
