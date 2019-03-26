package com.hang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //使用监控
public class HystrixDashBoard9001_App {

	public static void main(String[] args) {
		SpringApplication.run(HystrixDashBoard9001_App.class, args);

	}

}
