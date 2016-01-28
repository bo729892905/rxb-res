package com.rxb.res.service;

import com.rxb.res.BaseTest;
import com.rxb.res.entity.Permission;
import com.rxb.res.entity.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

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
        String userId = "4a1a183057aa4800b7ac3d5aa1b5efc8";
        List<Role> roleList = roleService.getRoleByUserId(userId);
        for (Role role : roleList) {
            System.out.println(role.getName());
        }
    }

    @Test
    public void testSetPermissionsToRole() throws Exception {
        String roleId = "c408365aba124e96847d7fdd3fbd249f";
        List<String> perIdList = Arrays.asList("f11f61a4410a4d7d968614748c6639e5");

        int result = roleService.setPermissionsToRole(roleId, perIdList);
        System.out.println(result);
    }
}