package com.hang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient //eureka客户端
@EnableFeignClients(basePackages= {"com.hang.springcloud"})
@ComponentScan("com.hang.springcloud")
public class ConsumerDeptFeign_App {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ConsumerDeptFeign_App.class, args);
	}

}
