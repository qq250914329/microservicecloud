package com.fei.springboot.websocket6662.web.rest;

import com.fei.springboot.websocket6662.config.websocket.Constance;
import com.fei.springboot.websocket6662.service.UserService;
import com.fei.springboot.websocket6662.web.dto.Message;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class PointMessageResource3 {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Autowired
	private UserService userService;

	@MessageMapping("/sendToUser")
	public void point2point3(Message message, SimpMessageHeaderAccessor headerAccessor) {
		String userId = userService.getSessionId(message.getTo());
		System.out.println(Constance.queue_pre+userId);
		amqpTemplate.convertAndSend("", Constance.queue_pre+userId, message.getMessage());
	}

	@MessageMapping("/gobangToUser")
	public void gobang(Message message, SimpMessageHeaderAccessor headerAccessor) {
		String userId = userService.getSessionId(message.getTo());
		System.out.println(Constance.gobang+userId);
		amqpTemplate.convertAndSend("", Constance.gobang+userId, message.getMessage());
	}

	@MessageMapping("/pointHarf")
	public void pointHarf(Message message, SimpMessageHeaderAccessor headerAccessor) {
		String userId = userService.getSessionId(message.getTo());
		System.out.println(Constance.pointHarf+userId);
		amqpTemplate.convertAndSend("", Constance.pointHarf+userId, message.getMessage());
	}

	@MessageMapping("/biggest")
	public void biggest(Message message, SimpMessageHeaderAccessor headerAccessor) {
		String userId = userService.getSessionId(message.getTo());
		System.out.println(Constance.biggest+userId);
		amqpTemplate.convertAndSend("", Constance.biggest+userId, message.getMessage());
	}

	@MessageMapping("/AirPlan")
	public void AirPlan(Message message, SimpMessageHeaderAccessor headerAccessor) {
		String userId = userService.getSessionId(message.getTo());
		System.out.println(Constance.AirPlan+userId);
		amqpTemplate.convertAndSend("", Constance.AirPlan+userId, message.getMessage());
	}

	@MessageMapping("/sixDice")
	public void sixDice(Message message, SimpMessageHeaderAccessor headerAccessor) {
		String userId = userService.getSessionId(message.getTo());
		System.out.println(Constance.sixDice+userId);
		amqpTemplate.convertAndSend("", Constance.sixDice+userId, message.getMessage());
	}

	@MessageMapping("/guessNum")
	public void guessNum(Message message, SimpMessageHeaderAccessor headerAccessor) {
		String userId = userService.getSessionId(message.getTo());
		System.out.println(Constance.guessNum+userId);
		amqpTemplate.convertAndSend("", Constance.guessNum+userId, message.getMessage());
	}

	@MessageMapping("/billiards")
	public void billiards(Message message, SimpMessageHeaderAccessor headerAccessor) {
		String userId = userService.getSessionId(message.getTo());
		System.out.println(Constance.billiards+userId);
		amqpTemplate.convertAndSend("", Constance.billiards+userId, message.getMessage());
	}

	@MessageMapping("/message")
	public void handleSubscribe(String msg) {
		System.out.println("客户端发来消息：" + msg);
		// TODO: 处理收到的消息
	}
}
