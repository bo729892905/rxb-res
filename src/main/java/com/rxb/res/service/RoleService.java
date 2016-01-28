package com.rxb.res.service;

import com.rxb.res.entity.Role;

import java.util.List;

/**
 * 角色业务层操作
 * Created by rxb on 2016/1/28.
 */
public interface RoleService {
    /**
     * 新增用户
     * @param role
     * @return
     */
    int insertRole(Role role);

    /**
     * 根据用户查询角色
     * @param userId
     * @return
     */
    List<Role> getRoleByUserId(String userId);

    /**
     * 给角色设置权限
     * @param roleId
     * @param perIdList
     * @return
     */
    int setPermissionsToRole(String roleId, List<String> perIdList);
}
