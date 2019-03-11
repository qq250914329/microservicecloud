package com.fei.springboot.provider8881.dao;


import com.fei.springboot.domain.UserEntity;
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
