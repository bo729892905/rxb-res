package com.rxb.res.service;

import com.rxb.res.BaseTest;
import com.rxb.res.entity.Permission;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * Created by rxb on 2016/1/28.
 */
public class PermissionServiceTest extends BaseTest {
    @Resource
    private PermissionService permissionService;

    @Test
    public void testInsertPermission() throws Exception {
        Permission permission = new Permission();
        permission.setName("测试");
        permission.setUrl("test");
        permission.setRemark("测试权限");

        permissionService.insertPermission(permission);
    }

    @Test
    public void testGetPermissionByRole() throws Exception {
        String roleId = "c408365aba124e96847d7fdd3fbd249f";
        List<Permission> permissionList = permissionService.getPermissionByRole(roleId);
        for (Permission permission : permissionList) {
            System.out.println(permission.getName() + " " + permission.getUrl());
        }
    }
}