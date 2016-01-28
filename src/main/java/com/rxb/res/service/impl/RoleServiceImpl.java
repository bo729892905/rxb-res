package com.rxb.res.service.impl;

import com.rxb.res.dao.RoleDao;
import com.rxb.res.entity.Role;
import com.rxb.res.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色业务层操作实现类
 * Created by rxb on 2016/1/28.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    @Transactional
    @Override
    public int insertRole(Role role) {
        return roleDao.insertRole(role);
    }

    @Override
    public List<Role> getRoleByUserId(String userId) {
        return roleDao.getRoleByUserId(userId);
    }
}
