package com.fei.springcloud.provider8882.dao;


import com.fei.springcloud.domain.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员Dao
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-08-16 15:02:28
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {

}
