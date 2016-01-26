package com.rxb.res.dao;

import com.rxb.res.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

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
