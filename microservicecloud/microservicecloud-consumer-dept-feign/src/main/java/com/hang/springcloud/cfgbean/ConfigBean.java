package com.hang.springcloud.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration //这个类相等于以前的xml配置文件
public class ConfigBean {

	@Bean
	@LoadBalanced //ribbon客户端负载均衡
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	/*
	 * //用随机算法代替轮询
	 * 
	 * @Bean 
	 * public IRule myRule() 
	 * { 
	 * //return new RandomRule(); //随机 return new
	 * RetryRule(); //重试算法
	 *  }
	 */
}
