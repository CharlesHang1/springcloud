package com.hang.rule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class MySelfRule {

	
	  //用随机算法代替轮询
	  @Bean 
	  public IRule myRule()
	  { 
		 // return new RandomRule(); 
		  return new RandomRule_ZY();
	  }
	  
	 
}
