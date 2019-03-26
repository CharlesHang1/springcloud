package com.hang.springcloud.service;

import java.util.List;

import com.hang.springcloud.entity.Dept;

public interface DeptService {
	public Boolean addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();
}
