package com.fei.springboot.provider8883.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.provider8883.dao.ApiFootprintMapper;
import com.fei.springboot.domain.FootprintVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ApiFootprintService {
    @Autowired
    private ApiFootprintMapper footprintDao;

    @ReadDataSource
    public FootprintVo queryObject(Integer id) {
        return footprintDao.queryObject(id);
    }

    @ReadDataSource
    public List<FootprintVo> queryList(Map<String, Object> map) {
        return footprintDao.queryList(map);
    }
    @ReadDataSource
    public List<FootprintVo> queryListFootprint(String userid) {
    	return footprintDao.queryListFootprint(userid);
    }
    @ReadDataSource
    public List<FootprintVo> shareList(Map<String, Object> map) {
        return footprintDao.shareList(map);
    }
    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return footprintDao.queryTotal(map);
    }

    @WriteDataSource
    public void save(FootprintVo footprint) {
        footprintDao.save(footprint);
    }

    @WriteDataSource
    public void update(FootprintVo footprint) {
        footprintDao.update(footprint);
    }

    @WriteDataSource
    public void delete(Integer id) {
        footprintDao.delete(id);
    }
    @WriteDataSource
    public void deleteByParam(Map<String, Object> map) {
        footprintDao.deleteByParam(map);
    }
    @WriteDataSource
    public void deleteBatch(Integer[] ids) {
        footprintDao.deleteBatch(ids);
    }

}
