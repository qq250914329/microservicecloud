package com.fei.springboot.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.dao.ApiTopicMapper;
import com.fei.springboot.domain.TopicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiTopicService {
    @Autowired
    private ApiTopicMapper topicDao;

    @ReadDataSource
    public TopicVo queryObject(Integer id) {
        return topicDao.queryObject(id);
    }

    @ReadDataSource
    public List<TopicVo> queryList(Map<String, Object> map) {
        return topicDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return topicDao.queryTotal(map);
    }

    @WriteDataSource
    public void save(TopicVo topic) {
        topicDao.save(topic);
    }

    @WriteDataSource
    public void update(TopicVo topic) {
        topicDao.update(topic);
    }

    @WriteDataSource
    public void delete(Integer id) {
        topicDao.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        topicDao.deleteBatch(ids);
    }

}
