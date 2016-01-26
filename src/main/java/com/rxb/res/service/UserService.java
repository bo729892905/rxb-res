package com.rxb.res.service;

import com.rxb.res.entity.User;

import java.util.List;

public interface UserService {
	/**
	 * 新建用户
	 * @param user
	 * @return
     */
	int insertUser(User user);

	/**
	 * 获取用户列表
	 * @return
	 */
	List<User> getUserList();
}
