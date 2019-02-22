package com.fei.springboot.provider8883.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.domain.HelpIssueVo;
import com.fei.springboot.provider8883.dao.ApiHelpIssueMapper;
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
public class ApiHelpIssueService {
    @Autowired
    private ApiHelpIssueMapper helpIssueDao;
    @ReadDataSource
    public HelpIssueVo queryObject(Integer id) {
        return helpIssueDao.queryObject(id);
    }
    @ReadDataSource
    public List<HelpIssueVo> queryList(Map<String, Object> map) {
        return helpIssueDao.queryList(map);
    }
    @ReadDataSource
    public int queryTotal(Map<String, Object> map) {
        return helpIssueDao.queryTotal(map);
    }
    @WriteDataSource
    public int save(HelpIssueVo helpIssue) {
        return helpIssueDao.save(helpIssue);
    }
    @WriteDataSource
    public int update(HelpIssueVo helpIssue) {
        return helpIssueDao.update(helpIssue);
    }
    @WriteDataSource
    public int delete(Integer id) {
        return helpIssueDao.delete(id);
    }
    @WriteDataSource
    public int deleteBatch(Integer[] ids) {
        return helpIssueDao.deleteBatch(ids);
    }
}
