package com.fei.springboot.websocket6662.config.websocket;

import java.security.Principal;

public class User implements Principal {
	private String name;

	public User(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}