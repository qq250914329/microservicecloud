package com.fei.springboot.provider8883.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.domain.NodesVo;
import com.fei.springboot.provider8883.dao.ApiNodesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Service实现类
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2019-02-26 09:49:13
 */
@Service
public class ApiNodesService {
    @Autowired
    private ApiNodesMapper nodesDao;

    @ReadDataSource
    public NodesVo queryObject(Integer id) {
        return nodesDao.queryObject(id);
    }

    @ReadDataSource
    public List<NodesVo> queryList(Map<String, Object> map) {
        return nodesDao.queryList(map);
    }

    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return nodesDao.queryTotal(map);
    }

    @WriteDataSource
    public int save(NodesVo nodes) {
        return nodesDao.save(nodes);
    }

    @WriteDataSource
    public int update(NodesVo nodes) {
        return nodesDao.update(nodes);
    }

    @WriteDataSource
    public int delete(Integer id) {
        return nodesDao.delete(id);
    }

    @WriteDataSource
    public int deleteBatch(Integer[] ids) {
        return nodesDao.deleteBatch(ids);
    }
}
