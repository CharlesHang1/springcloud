package com.hang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.hang.rule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient //eureka客户端
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)
public class ConsumerDept8088_App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ConsumerDept8088_App.class, args);
	}

}
