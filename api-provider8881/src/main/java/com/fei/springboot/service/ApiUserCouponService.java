package com.fei.springboot.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.dao.ApiUserCouponMapper;
import com.fei.springboot.domain.UserCouponVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiUserCouponService {
    @Autowired
    private ApiUserCouponMapper userCouponDao;

    @ReadDataSource
    public UserCouponVo queryObject(Integer id) {
        return userCouponDao.queryObject(id);
    }
    @ReadDataSource
    public UserCouponVo queryByCouponNumber(String couponNumber) {
        return userCouponDao.queryByCouponNumber(couponNumber);
    }
    @ReadDataSource
    public List<UserCouponVo> queryList(Map<String, Object> map) {
        return userCouponDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return userCouponDao.queryTotal(map);
    }

    @WriteDataSource
    public void save(UserCouponVo goods) {
        userCouponDao.save(goods);
    }

    @WriteDataSource
    public void update(UserCouponVo goods) {
        userCouponDao.update(goods);
    }

    @WriteDataSource
    public void delete(Integer id) {
        userCouponDao.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        userCouponDao.deleteBatch(ids);
    }

}
