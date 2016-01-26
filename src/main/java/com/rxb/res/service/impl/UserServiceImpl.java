package com.rxb.res.service.impl;

import com.rxb.res.dao.UserDao;
import com.rxb.res.entity.User;
import com.rxb.res.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Transactional
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

	public List<User> getUserList() {
		return userDao.getUserList();
	}

}
