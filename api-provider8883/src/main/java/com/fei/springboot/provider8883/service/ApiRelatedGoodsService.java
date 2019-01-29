package com.fei.springboot.provider8883.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.provider8883.dao.ApiRelatedGoodsMapper;
import com.fei.springboot.domain.RelatedGoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiRelatedGoodsService {
    @Autowired
    private ApiRelatedGoodsMapper relatedGoodsDao;

    @ReadDataSource
    public RelatedGoodsVo queryObject(Integer id) {
        return relatedGoodsDao.queryObject(id);
    }

    @ReadDataSource
    public List<RelatedGoodsVo> queryList(Map<String, Object> map) {
        return relatedGoodsDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return relatedGoodsDao.queryTotal(map);
    }
    @ReadDataSource
    public int queryhasPicTotal(Map<String, Object> map) {
        return relatedGoodsDao.queryTotal(map);
    }
    @WriteDataSource
    public int save(RelatedGoodsVo comment) {
        return relatedGoodsDao.save(comment);
    }

    @WriteDataSource
    public void update(RelatedGoodsVo comment) {
        relatedGoodsDao.update(comment);
    }

    @WriteDataSource
    public void delete(Integer id) {
        relatedGoodsDao.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        relatedGoodsDao.deleteBatch(ids);
    }

}
