package com.rxb.res.service;

import com.rxb.res.BaseTest;
import com.rxb.res.common.util.EncryptUtil;
import com.rxb.res.entity.User;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by rxb on 2016/1/26.
 */
public class UserServiceTest extends BaseTest {

    @Resource
    private UserService userService;

    @Test
    @Rollback(true)
    public void testInsertUser() throws Exception {
        User user = new User();
        user.setUsername("test1");
        user.setPassword(EncryptUtil.encryptMD5("123456"));
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

    @Test
    public void testGetUserByUsername() throws Exception {
        String username = "test";
        User user = userService.getUserByUsername(username);
        System.out.println(user.toString());
    }

    @Test
    public void testSetRolesToUser() throws Exception {
        String userId = "4a1a183057aa4800b7ac3d5aa1b5efc8";
        List<String> roleListId = Arrays.asList("c408365aba124e96847d7fdd3fbd249f");

        int result = userService.setRolesToUser(userId, roleListId);
        System.out.println(result);
    }
}