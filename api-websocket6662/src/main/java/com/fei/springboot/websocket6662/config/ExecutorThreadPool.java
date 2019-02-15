package com.fei.springboot.websocket6662.config;

import com.alibaba.fastjson.JSON;
import com.fei.springboot.websocket6662.service.UserService;
import com.fei.springboot.websocket6662.web.dto.Message;
import org.springframework.amqp.core.AmqpTemplate;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/1/30.
 */

public class ExecutorThreadPool {
    private ScheduledExecutorService scheduledThreadPool;
    //匹配玩家
    public void findPlayer(String queue, String sessionId, Message message,String fromUser, UserService userService, AmqpTemplate amqpTemplate) {
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Boolean gameInfo = true;
                    long startTime = System.currentTimeMillis();
                    String catcheQueue = queue.substring(0,queue.indexOf("-"));
                    String catcheId = "";
                    while(gameInfo){
                        catcheId = userService.setRandomQueue(sessionId, catcheQueue);
                        long search = System.currentTimeMillis() - startTime;
                        System.out.println("系统匹配时间："+search+"---"+"游戏"+queue+"：玩家"+sessionId+"匹配到"+catcheId);
                        if (null != catcheId && catcheId != "") {
                            gameInfo = false;
                            userService.delSetUserQueue(sessionId,catcheQueue);

                            message.setMessage(fromUser+"_"+search);
                            message.setFrom(sessionId);
                            message.setTo(catcheId);
                            amqpTemplate.convertAndSend("", queue+catcheId, JSON.toJSONString(message));
                            message.setFrom(catcheId);
                            message.setTo(sessionId);
                            amqpTemplate.convertAndSend("", queue+sessionId, JSON.toJSONString(message));
                        }
                        if(System.currentTimeMillis() - startTime >25000){
                            gameInfo = false;
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {

                }
            }
        }, 0, TimeUnit.MICROSECONDS);
    }

    //
    public void playerReady(String queue, String sessionId, Message message,String fromUser, UserService userService, AmqpTemplate amqpTemplate) {
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Boolean gameInfo = true;
                    long startTime = System.currentTimeMillis();
                    String catcheQueue = queue.substring(0,queue.indexOf("-"));
                    while(gameInfo){
                        String catcheId = userService.setRandomQueue(sessionId, catcheQueue);
                        System.out.println("时间："+(System.currentTimeMillis() - startTime)+"---"+"游戏"+queue+"：玩家"+sessionId+"匹配到"+catcheId);
                        if (null != catcheId && catcheId != "") {
                            message.setFrom(sessionId);
                            message.setMessage(sessionId+"*"+catcheId);
                            amqpTemplate.convertAndSend("", queue+catcheId, JSON.toJSONString(message));
                            message.setFrom(catcheId);
                            amqpTemplate.convertAndSend("", queue+sessionId, JSON.toJSONString(message));
                            gameInfo = false;
                        }
                        if(System.currentTimeMillis() - startTime >5000){
                            gameInfo = false;
                        }
                        Thread.sleep(20);
                    }
                } catch (InterruptedException e) {

                }
            }
        }, 0, TimeUnit.MICROSECONDS);
    }

    private static ExecutorThreadPool executorThreadPool = null;

    private ExecutorThreadPool() {
        scheduledThreadPool = Executors.newScheduledThreadPool(8);
    }

    private static synchronized void syncInit() {
        if (executorThreadPool == null) {
            executorThreadPool = new ExecutorThreadPool();
        }
    }

    public static ExecutorThreadPool getInstance() {
        if (executorThreadPool == null) {
                syncInit();
        }
        return executorThreadPool;
    }
}

