package com.rxb.res.dao;

import com.rxb.res.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限持久层接口
 * Created by rxb on 2016/1/28.
 */
@Repository
public interface PermissionDao {
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
