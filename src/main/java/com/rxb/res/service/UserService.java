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

	/**
	 * 根据用户名获取用户
	 * @param username
	 * @return
	 */
	User getUserByUsername(String username);

	/**
	 * 给用户设置角色
	 * @param userId
	 * @param roleIdList
     * @return
     */
	int setRolesToUser(String userId, List<String> roleIdList);
}
