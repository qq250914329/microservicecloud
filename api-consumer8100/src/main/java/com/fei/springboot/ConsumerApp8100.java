package com.fei.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.fei.springboot"})
@ComponentScan("com.fei.springboot")
public class ConsumerApp8100
{
	public static void main(String[] args)
	{
		SpringApplication.run(ConsumerApp8100.class, args);
	}
}
