package com.fei.springboot.provider8883.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.provider8883.dao.ApiFeedbackMapper;
import com.fei.springboot.domain.FeedbackVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiFeedbackService {
    @Autowired
    private ApiFeedbackMapper feedbackMapper;

    @ReadDataSource
    public FeedbackVo queryObject(Integer id) {
        return feedbackMapper.queryObject(id);
    }

    @ReadDataSource
    public List<FeedbackVo> queryList(Map<String, Object> map) {
        return feedbackMapper.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return feedbackMapper.queryTotal(map);
    }

    @WriteDataSource
    public void save(FeedbackVo feedbackVo) {
        feedbackMapper.save(feedbackVo);
    }

    @WriteDataSource
    public void update(FeedbackVo feedbackVo) {
        feedbackMapper.update(feedbackVo);
    }

    @WriteDataSource
    public void delete(Integer id) {
        feedbackMapper.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        feedbackMapper.deleteBatch(ids);
    }

}
