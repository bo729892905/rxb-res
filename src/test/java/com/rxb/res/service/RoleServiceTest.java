package com.rxb.res.service;

import com.rxb.res.BaseTest;
import com.rxb.res.entity.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by rxb on 2016/1/28.
 */
public class RoleServiceTest extends BaseTest {
    @Autowired
    private RoleService roleService;

    @Test
    public void testInsertRole() throws Exception {
        Role role = new Role();
        role.setName("管理员");
        role.setCode("admin");
        role.setRemark("管理员，拥护最高权限");

        roleService.insertRole(role);
    }

    @Test
    public void testGetRoleByUserId() throws Exception {

    }
}