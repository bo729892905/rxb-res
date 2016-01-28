package com.rxb.res.service.impl;

import com.rxb.res.dao.PermissionDao;
import com.rxb.res.entity.Permission;
import com.rxb.res.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限业务层操作实现类
 * Created by rxb on 2016/1/28.
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionDao permissionDao;

    @Override
    @Transactional
    public int insertPermission(Permission permission) {
        return permissionDao.insertPermission(permission);
    }

    @Override
    public List<Permission> getPermissionByRole(String roleId) {
        return permissionDao.getPermissionByRole(roleId);
    }
}
