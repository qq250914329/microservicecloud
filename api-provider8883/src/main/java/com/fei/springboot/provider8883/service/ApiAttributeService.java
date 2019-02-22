package com.fei.springboot.provider8883.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.domain.AttributeVo;
import com.fei.springboot.provider8883.dao.ApiAttributeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiAttributeService {
    @Autowired
    private ApiAttributeMapper attributeMapper;

    @ReadDataSource
    public AttributeVo queryObject(Integer id) {
        return attributeMapper.queryObject(id);
    }

    @ReadDataSource
    public List<AttributeVo> queryList(Map<String, Object> map) {
        return attributeMapper.queryList(map);
    }
    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return attributeMapper.queryTotal(map);
    }

    @WriteDataSource
    public void save(AttributeVo goods) {
        attributeMapper.save(goods);
    }

    @WriteDataSource
    public void update(AttributeVo goods) {
        attributeMapper.update(goods);
    }

    @WriteDataSource
    public void delete(Integer id) {
        attributeMapper.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        attributeMapper.deleteBatch(ids);
    }

}
