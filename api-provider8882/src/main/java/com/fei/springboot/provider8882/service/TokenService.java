package com.fei.springboot.provider8882.service;

import com.fei.springboot.annotation.ReadDataSource;
import com.fei.springboot.annotation.WriteDataSource;
import com.fei.springboot.domain.TokenEntity;
import com.fei.springboot.provider8882.dao.ApiTokenMapper;
import com.fei.springboot.util.CharUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class TokenService {
    @Autowired
    private ApiTokenMapper tokenDao;
    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    public TokenEntity queryByUserId(Long userId) {
        return tokenDao.queryByUserId(userId);
    }
    @ReadDataSource
    public TokenEntity queryByToken(String token) {
        return tokenDao.queryByToken(token);
    }
    @WriteDataSource
    public void save(TokenEntity token) {
        tokenDao.save(token);
    }
    @WriteDataSource
    public void update(TokenEntity token) {
        tokenDao.update(token);
    }

    public Map<String, Object> createToken(long userId) {
        //生成一个token
        String token = CharUtil.getRandomString(32);
        //当前时间
        Date now = new Date();

        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        TokenEntity tokenEntity = queryByUserId(userId);
        if (tokenEntity == null) {
            tokenEntity = new TokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            save(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            update(tokenEntity);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", EXPIRE);

        return map;
    }
}
