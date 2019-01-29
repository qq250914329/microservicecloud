package com.fei.springboot.websocket6661.web.rest;

import com.fei.springboot.websocket6661.config.websocket.Constance;
import com.fei.springboot.websocket6661.service.UserService;
import com.fei.springboot.websocket6661.web.dto.Message;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GroupMessageResource {	
	
	@Autowired
	private AmqpTemplate amqpTemplate;

	@Autowired
	private UserService userService;
	
	@MessageMapping("/sendToAll")
    public void say(Message message) throws Exception {
		List<String> users = userService.listSessionIds();
		for(String user:users){
			System.out.println(Constance.queue_pre+user);
			amqpTemplate.convertAndSend("", Constance.queue_pre+user, message.getMessage());
		}
    }
}
