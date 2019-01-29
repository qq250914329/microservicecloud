package com.fei.springboot.websocket6663.websocket;

import com.alibaba.fastjson.JSONObject;
import com.fei.springboot.websocket6663.redismq.PublishService;
import com.fei.springboot.websocket6663.redismq.SubscribeListener;
import com.fei.springboot.websocket6663.util.GameInfo;
import com.fei.springboot.websocket6663.util.Games;
import com.fei.springboot.websocket6663.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *@ServerEndpoint(value="/websocket")value值必须以/开路
 *备注:@ServerEndpoint注解类不支持使用@Autowire
 *{topic}指：向哪个通道主题里发消息，当前用户id
 *{gameAndMsg}指：真实环境里可以使用当前登录用户信息
 */
@Component
@ServerEndpoint(value="/websocket/{topic}/{gameAndMsg}")
public class WebsocketEndpoint {
	
	/**
	 * 因为@ServerEndpoint不支持注入，所以使用SpringUtils获取IOC实例
	 */
	private StringRedisTemplate redisTampate = SpringUtils.getBean(StringRedisTemplate.class);

	private PublishService publishService = SpringUtils.getBean(PublishService.class);

	private RedisMessageListenerContainer redisMessageListenerContainer = SpringUtils.getBean(RedisMessageListenerContainer.class);

	private static Games game = null;
	//存放该服务器该ws的所有连接。用处：比如向所有连接该ws的用户发送通知消息。
	private static CopyOnWriteArraySet<WebsocketEndpoint> sessions = new CopyOnWriteArraySet<>();
	
	private Session session;
	
	@OnOpen
	public void onOpen(Session session, @PathParam("topic")String topic){
		this.session = session;
		sessions.add(this);
		SubscribeListener subscribeListener = new SubscribeListener();
		subscribeListener.setSession(session);
		subscribeListener.setStringRedisTemplate(redisTampate);
		//设置订阅topic
		System.out.println("玩家进入:"+topic+"  sessionId:"+session.getId());
		redisMessageListenerContainer.addMessageListener(subscribeListener, new ChannelTopic(topic));
	}
	
	@OnClose
	public void onClose(Session session,@PathParam("topic")String topic){
		System.out.println("java websocket:关闭连接");
		sessions.remove(this);
		SubscribeListener subscribeListener = new SubscribeListener();
		subscribeListener.setSession(session);
		subscribeListener.setStringRedisTemplate(redisTampate);
		redisMessageListenerContainer.removeMessageListener(subscribeListener);
		try{
			session.close();
			session = null;
		}catch (Exception e){
			System.out.print("session关闭失败");
		}

	}
	
	@OnMessage
	public void onMessage(String message, @PathParam("topic")String topic, @PathParam("gameAndMsg")String gameId) throws IOException{
		JSONObject game = JSONObject.parseObject(message);
		if(null != game.get("msgType") && "1".equals(game.get("msgType"))){
			message = GameInfo.gameInfo(game);
		}
		System.out.println(session.getId());
		System.out.println("java websocket 收到消息=="+message);
		publishService.publish(game.getString("toUser"), message);
	}
	
	@OnError
	public void onError(Session session, Throwable error){
		error.printStackTrace();
		System.out.println("java websocket 出现错误");
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
}
