package com.fei.springboot.websocket6663.util;

/**
 * Created by Administrator on 2019/1/2.
 */
public class Games {
    //请求类型
    public String messageType;
    //信息
    public String message;
    //状态
    public String status;

    public String num;
    //积分
    public String candy;

    public String[] dataFactory(){
        String[] strings = new String[]{"",""};
        return strings;
    }
}
