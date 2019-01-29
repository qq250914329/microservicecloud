package com.fei.springboot.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.dao.ApiHelpTypeMapper;
import com.fei.springboot.domain.HelpTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2018-11-07 11:04:20
 */
@Service
public class ApiHelpTypeService {
    @Autowired
    private ApiHelpTypeMapper helpTypeDao;
    @ReadDataSource
    public HelpTypeVo queryObject(Integer id) {
        return helpTypeDao.queryObject(id);
    }
    @ReadDataSource
    public List<HelpTypeVo> queryList(Map<String, Object> map) {
        return helpTypeDao.queryList(map);
    }
    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return helpTypeDao.queryTotal(map);
    }
    @WriteDataSource
    public int save(HelpTypeVo helpType) {
        return helpTypeDao.save(helpType);
    }
    @WriteDataSource
    public int update(HelpTypeVo helpType) {
        return helpTypeDao.update(helpType);
    }
    @WriteDataSource
    public int delete(Integer id) {
        return helpTypeDao.delete(id);
    }
    @WriteDataSource
    public int deleteBatch(Integer[] ids) {
        return helpTypeDao.deleteBatch(ids);
    }
}
