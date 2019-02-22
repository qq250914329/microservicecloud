package com.fei.springboot.provider8883.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.domain.CommentPictureVo;
import com.fei.springboot.provider8883.dao.ApiCommentPictureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiCommentPictureService {
    @Autowired
    private ApiCommentPictureMapper commentPictureDao;

    @ReadDataSource
    public CommentPictureVo queryObject(Integer id) {
        return commentPictureDao.queryObject(id);
    }

    @ReadDataSource
    public List<CommentPictureVo> queryList(Map<String, Object> map) {
        return commentPictureDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return commentPictureDao.queryTotal(map);
    }
    @WriteDataSource
    public int save(CommentPictureVo comment) {
        return commentPictureDao.save(comment);
    }

    @WriteDataSource
    public void update(CommentPictureVo comment) {
        commentPictureDao.update(comment);
    }

    @WriteDataSource
    public void delete(Integer id) {
        commentPictureDao.delete(id);
    }

    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        commentPictureDao.deleteBatch(ids);
    }

}
