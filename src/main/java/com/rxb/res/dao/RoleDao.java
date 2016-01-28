package com.rxb.res.dao;

import com.rxb.res.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色持久层接口
 * Created by rxb on 2016/1/28.
 */
@Repository
public interface RoleDao {

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
}
