package com.fei.springboot.websocket6661.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UserService {
	
	private static final String WSUSERS = "ws-users";
	
	@Autowired
	private RedisTemplate redisTemplate;

	//固定ws-users的栈堆，作为登录用户唯一标识和通道
	public void addUser(String name,String sessionId){
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(WSUSERS);
		boundHashOperations.put(name, sessionId);
	}
	public void deleteUser(String name){
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(WSUSERS);
		boundHashOperations.delete(name);
	}
	public String getSessionId(String name){
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(WSUSERS);
		return boundHashOperations.get(name);
	}
	public List<String> listSessionIds(){
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(WSUSERS);
		List<String> values = new ArrayList<String>();
		for(String key:boundHashOperations.keys()){
			System.out.println(key);
			values.add(boundHashOperations.get(key));
		}
		return values;
	}
	public String getUserById(String sessionId){
		BoundHashOperations<String, String, String> boundHashOperations = redisTemplate.boundHashOps(WSUSERS);
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

	//根据用户监听的queue进行绑定，同一queue的用户在一个内存栈中（BoundSetOperations）
	public void addSetUserQueue(String sessionId,String queue){
		BoundSetOperations<String, String> boundSetOperations = redisTemplate.boundSetOps(queue);
		boundSetOperations.add(sessionId);
	}

	public void delSetUserQueue(String sessionId,String queue){
		BoundSetOperations<String, String> boundSetOperations = redisTemplate.boundSetOps(queue);
		boundSetOperations.remove(sessionId);
	}

	public String setRandomQueue(String sessionId,String queue){
		BoundSetOperations<String, String> boundSetOperations = redisTemplate.boundSetOps(queue);
		//随机获取一个值，返回获取的值并在内存中删除该数据
		Object getId = boundSetOperations.pop();
		String rtnId = "";
		if(null !=getId){
			if(sessionId.equals(getId.toString())){
				addSetUserQueue(getId.toString(),queue);
			}else{
				rtnId = getId.toString();
				boundSetOperations.remove(getId);
				return rtnId;
			}
		}
		return null;
	}

}
