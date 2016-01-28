package com.rxb.res.service;

import com.rxb.res.entity.Permission;

import java.util.List;

/**
 * 权限业务层操作接口
 * Created by rxb on 2016/1/28.
 */
public interface PermissionService {
    /**
     * 新建权限
     * @param permission
     * @return
     */
    int insertPermission(Permission permission);

    /**
     * 根据角色id获取权限
     * @param roleId
     * @return
     */
    List<Permission> getPermissionByRole(String roleId);
}
