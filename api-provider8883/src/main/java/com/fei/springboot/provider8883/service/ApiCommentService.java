package com.fei.springboot.provider8883.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.provider8883.dao.ApiCommentMapper;
import com.fei.springboot.domain.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiCommentService {
    @Autowired
    private ApiCommentMapper commentDao;

    @ReadDataSource
    public CommentVo queryObject(Integer id) {
        return commentDao.queryObject(id);
    }

    @ReadDataSource
    public List<CommentVo> queryList(Map<String, Object> map) {
        return commentDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return commentDao.queryTotal(map);
    }
    @ReadDataSource
    public int queryhasPicTotal(Map<String, Object> map) {
        return commentDao.queryhasPicTotal(map);
    }
    @WriteDataSource
    public int save(CommentVo comment) {
        return commentDao.save(comment);
    }

    @WriteDataSource
    public void update(CommentVo comment) {
        commentDao.update(comment);
    }

    @WriteDataSource
    public void delete(Integer id) {
        commentDao.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        commentDao.deleteBatch(ids);
    }

}
