package com.fei.springboot;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.fei.springboot"})
@ComponentScan("com.fei.springboot")
public class ConsumerApp8100 implements EmbeddedServletContainerCustomizer
{
	public static void main(String[] args)
	{
		SpringApplication.run(ConsumerApp8100.class, args);
	}

	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
			@Override
			protected void postProcessContext(Context context) {
				SecurityConstraint constraint = new SecurityConstraint();
				constraint.setUserConstraint("CONFIDENTIAL");
				SecurityCollection collection = new SecurityCollection();
				collection.addPattern("/*");
				constraint.addCollection(collection);
				context.addConstraint(constraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(httpConnector());
		return tomcat;
	}

	//配置http转https
	@Bean
	public Connector httpConnector() {
		Connector connector = new Connector(TomcatEmbeddedServletContainerFactory.DEFAULT_PROTOCOL);
		connector.setScheme("http");
		//Connector监听的http的端口号
		connector.setPort(8100);
		connector.setSecure(false);
		//监听到http的端口号后转向到的https的端口号
		connector.setRedirectPort(8100);
		return connector;
	}

	//这里设置默认端口为443，即https的，如果这里不设置，会https和http争夺80端口
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(443);
	}
}
