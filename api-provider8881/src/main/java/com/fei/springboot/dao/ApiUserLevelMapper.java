package com.fei.springboot.dao;

import com.fei.springboot.domain.UserLevelVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商城_用户级别
 * 
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:16:47
 */
@Mapper
public interface ApiUserLevelMapper extends BaseDao<UserLevelVo> {
	
}
