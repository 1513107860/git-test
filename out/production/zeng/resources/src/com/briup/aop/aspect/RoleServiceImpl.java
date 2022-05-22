package com.briup.aop.aspect;

import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService{

	@Override
	public void print() throws Exception {
		System.out.println("print方法被调用");
	}
	
}