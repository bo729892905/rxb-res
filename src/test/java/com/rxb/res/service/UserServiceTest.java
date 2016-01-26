package com.rxb.res.service;

import com.rxb.res.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by rxb on 2016/1/26.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application.spring.xml")
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testInsertUser() throws Exception {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setRealName("测试");
        user.setGender(0);
        user.setMobilePhone("123456");
        user.setEmail("123@qq.com");
        user.setSalt("123");
        user.setRegisterDate(new Date());

        userService.insertUser(user);
    }

    @Test
    public void testGetUserList() throws Exception {
        List<User> userList = userService.getUserList();
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }
}