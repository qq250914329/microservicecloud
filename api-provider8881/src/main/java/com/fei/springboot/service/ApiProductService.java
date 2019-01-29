package com.fei.springboot.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.dao.ApiProductMapper;
import com.fei.springboot.domain.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiProductService {
    @Autowired
    private ApiProductMapper productDao;

    @ReadDataSource
    public ProductVo queryObject(Integer id) {
        return productDao.queryObject(id);
    }

    @ReadDataSource
    public List<ProductVo> queryList(Map<String, Object> map) {
        return productDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return productDao.queryTotal(map);
    }

    @WriteDataSource
    public void save(ProductVo goods) {
        productDao.save(goods);
    }

    @WriteDataSource
    public void update(ProductVo goods) {
        productDao.update(goods);
    }

    @WriteDataSource
    public void delete(Integer id) {
        productDao.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        productDao.deleteBatch(ids);
    }

}
