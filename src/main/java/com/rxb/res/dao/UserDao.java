package com.rxb.res.dao;

import com.rxb.res.entity.User;
import org.apache.ibatis.annotations.Param;
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

	/**
	 * 根据用户名获取用户
	 * @param username
     * @return
     */
	User getUserByUsername(String username);

	/**
	 * 给用户添加角色
	 * @param userId
	 * @param roleIdList
     * @return
     */
	int setRolesToUser(@Param("userId") String userId, @Param("roleIdList") List<String> roleIdList);
}
