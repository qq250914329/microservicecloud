package com.fei.springboot.dao;

import com.fei.springboot.domain.OrderVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-11 09:16:46
 */
@Mapper
public interface ApiOrderMapper extends BaseDao<OrderVo> {
	
}
