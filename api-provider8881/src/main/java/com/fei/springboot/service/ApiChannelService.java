package com.fei.springboot.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.dao.ApiChannelMapper;
import com.fei.springboot.domain.ChannelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiChannelService {
    @Autowired
    private ApiChannelMapper channelDao;

    @ReadDataSource
    public ChannelVo queryObject(Integer id) {
        return channelDao.queryObject(id);
    }

    @ReadDataSource
    public List<ChannelVo> queryList(Map<String, Object> map) {
        return this.channelDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return channelDao.queryTotal(map);
    }

    @WriteDataSource
    public void save(ChannelVo order) {
        channelDao.save(order);
    }

    @WriteDataSource
    public void update(ChannelVo order) {
        channelDao.update(order);
    }

    @WriteDataSource
    public void delete(Integer id) {
        channelDao.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        channelDao.deleteBatch(ids);
    }

}
