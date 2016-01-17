package com.rxb.res.dao;

import org.springframework.stereotype.Component;

import com.rxb.res.entity.User;

@Component
public interface UserDao {

	/**
	 * 新建用户
	 * @param user
	 * @return
     */
	int insertUser(User user);

}
