package com.rxb.res.dao;

import com.rxb.res.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {

	/**
	 * 新建用户
	 * @param user
	 * @return
     */
	int insertUser(User user);

}
