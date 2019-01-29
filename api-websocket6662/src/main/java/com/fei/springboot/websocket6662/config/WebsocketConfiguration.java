package com.fei.springboot.websocket6662.config;

import com.fei.springboot.websocket6662.config.websocket.Constance;
import com.fei.springboot.websocket6662.config.websocket.User;
import com.fei.springboot.websocket6662.service.UserService;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfiguration implements WebSocketMessageBrokerConfigurer {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RabbitAdmin rabbitAdmin;
	
    /**
     * 注册端点，发布或者订阅消息的时候需要连接此端点
     * addEndpoint websocket的端点，客户端需要注册这个端点进行链接
     * setAllowedOrigins 非必须，*表示允许其他域进行连接，跨域
     * withSockJS 允许客户端利用sockjs进行浏览器兼容性处理
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/socketserver")
                .setAllowedOrigins("*");
    }

    /**
     * 配置消息代理
     * @param registry
     */
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
	    registry.enableStompBrokerRelay("/queue")
			.setRelayHost("127.0.0.1").setClientLogin("guest")
			.setClientPasscode("guest").setSystemLogin("guest").setSystemPasscode("guest")
			.setSystemHeartbeatSendInterval(5000).setSystemHeartbeatReceiveInterval(4000);
	}
  
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
    	registration.interceptors(new ChannelInterceptor() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
                //System.out.println("interceptors-> "+accessor.getCommand());
                if (StompCommand.CONNECT.equals(accessor.getCommand())) {// 创建连接
                	Object raw = message.getHeaders().get(SimpMessageHeaderAccessor.NATIVE_HEADERS);
    	            if (raw instanceof Map) {
    	                Object name = ((Map) raw).get("login");
    	                if (name instanceof LinkedList) {
    	                    // 设置当前访问器的认证用户
    	                	String userName = ((LinkedList) name).get(0).toString();
    	                	System.out.println("regist userName:"+userName);
    	                    accessor.setUser(new User(userName));
    	                    userService.addUser(userName, accessor.getSessionId());
    	                }
    	            }
                }
                if (StompCommand.DISCONNECT.equals(accessor.getCommand())) {// 断开连接
                    try{
                        userService.deleteUser(accessor.getUser().getName());
                        rabbitAdmin.deleteQueue(Constance.queue_pre+userService.getSessionId(accessor.getUser().getName()));
                    }catch (Exception e){

                    }
                }
                return message;
            }
            @Override
            public void postSend(Message<?> message, MessageChannel channel, boolean sent) {}
            @Override
            public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {}
            @Override
            public boolean preReceive(MessageChannel channel) {return false;}
            @Override
            public Message<?> postReceive(Message<?> message, MessageChannel channel) {return null;}
            @Override
            public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {}
        });
    }

    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) {}

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {}

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {}

    @Override
    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {return false;}

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        return rabbitAdmin;
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {}
}