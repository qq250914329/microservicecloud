package com.fei.springboot.websocket6662.web.dto;

public class Message {
	private String gameFlag;
	private String from;
	private String to;
	private String userId;
	private String msgType;//0为查询玩家，1游戏双方确认，2为游戏初始数据，3为游戏中，4为游戏结束判定输赢
	private String message;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGameFlag() {
		return gameFlag;
	}

	public void setGameFlag(String gameFlag) {
		this.gameFlag = gameFlag;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "玩家："+userId+" 游戏： "+gameFlag+" 消息类型："+msgType+"  来自："+from+"  到："+to+" 消息："+message;
	}
}
