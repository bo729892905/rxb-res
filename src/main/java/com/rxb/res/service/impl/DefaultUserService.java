package com.rxb.res.service.impl;

import com.rxb.res.dao.UserDao;
import com.rxb.res.entity.User;
import com.rxb.res.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class DefaultUserService implements UserService {

	@Resource
	private UserDao userDao;
	
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

}
