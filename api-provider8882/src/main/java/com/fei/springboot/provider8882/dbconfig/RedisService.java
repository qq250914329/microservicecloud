package com.fei.springboot.provider8882.dbconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RedisService {
	@Autowired
	private RedisTemplate redisTemplate;

	//固定ws-users的栈堆，作为登录用户唯一标识和通道
	public void addUser(String name,String sessionId){
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps("");
		boundHashOperations.put(name, sessionId);
	}
	public void deleteUser(String name){
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps("");
		boundHashOperations.delete(name);
	}
	public String getSessionId(String name){
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps("");
		return boundHashOperations.get(name);
	}
	public List<String> listSessionIds(){
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps("");
		List<String> values = new ArrayList<String>();
		for(String key:boundHashOperations.keys()){
			System.out.println(key);
			values.add(boundHashOperations.get(key));
		}
		return values;
	}
	public String getUserById(String sessionId){
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps("");
		for(String val:boundHashOperations.values()){
			if(sessionId.equals(val)){
				return val;
			}
		}
		return null;
	}


	//根据用户监听的queue进行绑定，同一queue的用户在一个内存栈中（BoundHashOperations）
	public void addUserQueue(String name,String queue,String sessionId){
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(queue);
		boundHashOperations.put(name, sessionId);
	}
	public void deleteUserQueue(String name,String queue){
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(queue);
		boundHashOperations.delete(name);
	}
	public String getSessionIdQueue(String name,String queue){
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(queue);
		return boundHashOperations.get(name);
	}
	public Map listSessionIdsQueue(String queue){
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(queue);
		Map userSession = boundHashOperations.entries();
		return userSession;
	}

}
