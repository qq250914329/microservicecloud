package com.fei.springboot.provider8882.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.domain.OrderGoodsVo;
import com.fei.springboot.provider8882.dao.ApiOrderGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiOrderGoodsService {
    @Autowired
    private ApiOrderGoodsMapper orderGoodsDao;

    @ReadDataSource
    public OrderGoodsVo queryObject(Integer id) {
        return orderGoodsDao.queryObject(id);
    }

    @ReadDataSource
    public List<OrderGoodsVo> queryList(Map<String, Object> map) {
        return orderGoodsDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return orderGoodsDao.queryTotal(map);
    }

    @WriteDataSource
    public void save(OrderGoodsVo order) {
        orderGoodsDao.save(order);
    }

    @WriteDataSource
    public void update(OrderGoodsVo order) {
        orderGoodsDao.update(order);
    }

    @WriteDataSource
    public void delete(Integer id) {
        orderGoodsDao.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        orderGoodsDao.deleteBatch(ids);
    }

}
