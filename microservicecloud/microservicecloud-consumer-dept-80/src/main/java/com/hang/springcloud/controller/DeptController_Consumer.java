package com.hang.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hang.springcloud.entity.Dept;

@RestController
public class DeptController_Consumer {
	
	//public static final String PROVIDER_URL_PREFIX = "http://localhost:8001";
	public static final String PROVIDER_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="consumer/dept/add",method=RequestMethod.GET)
	public Boolean add(Dept dept) {
		System.out.println("test");
		return restTemplate.postForObject(PROVIDER_URL_PREFIX+"/dept/add", dept, Boolean.class);
	}
	
	
	@RequestMapping(value="consumer/dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable Long id) {
		return restTemplate.getForObject(PROVIDER_URL_PREFIX+"/dept/get/"+id, Dept.class);
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="consumer/dept/list",method=RequestMethod.GET)
	public List<Dept> list() {
		return restTemplate.getForObject(PROVIDER_URL_PREFIX+"/dept/list", List.class);
		
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="consumer/dept/discovery",method=RequestMethod.GET)
	public Object discovery() {
		return restTemplate.getForObject(PROVIDER_URL_PREFIX+"/dept/discovery", Object.class);
		
	}
}
