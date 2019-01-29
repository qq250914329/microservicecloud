package com.fei.springboot.provider8882.dao;

import com.fei.springboot.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

	@Insert("insert sys_user(user_id,username) values(#{id},#{userName})")
	void insert(User u);
	
	@Select("select user_id,username from sys_user where user_id=#{id} ")
    User findById(@Param("id") String id);
	
	//注：方法名和要UserMapper.xml中的id一致
	List<User> query(@Param("userName") String userName);
	
}
