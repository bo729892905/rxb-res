package com.rxb.res.service.test;

import com.rxb.res.entity.User;
import com.rxb.res.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application.spring.xml")
public class UserServiceTest{
	
	@Resource
	private UserService userService;
	
	@Test
	@Rollback(false)
	public void insert(){
		User user=new User("test1","123","ase",false);
		int result=userService.insertUser(user);
		System.out.println("result: "+result);
		System.out.println("id: "+user.getId());
	}

}
