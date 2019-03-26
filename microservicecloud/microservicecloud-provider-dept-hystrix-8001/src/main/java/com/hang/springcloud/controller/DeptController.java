package com.hang.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hang.springcloud.entity.Dept;
import com.hang.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService service;
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public Boolean add(@RequestBody Dept dept) {
		return service.addDept(dept);
		
	}
	
	
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="processHystrix_get")
	public Dept get(@PathVariable Long id) {
		 Dept dept = service.findById(id);
		 if(dept == null) {
			 throw  new RuntimeException("该ID"+id+"没有对应部门信息");
		 }
		 
		 return dept;
		
	}
	
	
	public Dept processHystrix_get(@PathVariable Long id) {
		Dept dept = new Dept();
		dept.setDeptno(id);
		dept.setDb_source("数据库中不存在");
		dept.setDname("该id找不到部门");
		return dept;
	}
	
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public List<Dept> list() {
		return service.findAll();
		
	}
	
	
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}
}
