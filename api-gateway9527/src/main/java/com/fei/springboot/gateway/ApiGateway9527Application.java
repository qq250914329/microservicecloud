package com.fei.springboot.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ApiGateway9527Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateway9527Application.class, args);
	}

}

