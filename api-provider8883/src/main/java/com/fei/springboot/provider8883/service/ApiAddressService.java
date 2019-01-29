package com.fei.springboot.provider8883.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.provider8883.dao.ApiAddressMapper;
import com.fei.springboot.domain.AddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiAddressService {
    @Autowired
    private ApiAddressMapper addressDao;

    @ReadDataSource
    public AddressVo queryObject(Integer id) {
        return addressDao.queryObject(id);
    }

    @ReadDataSource
    public List<AddressVo> queryList(Map<String, Object> map) {
        return addressDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return addressDao.queryTotal(map);
    }

    @WriteDataSource
    public void save(AddressVo address) {
        addressDao.save(address);
    }

    @WriteDataSource
    public void update(AddressVo address) {
        addressDao.update(address);
    }

    @WriteDataSource
    public void delete(Integer id) {
        addressDao.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        addressDao.deleteBatch(ids);
    }

}
