/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.dao.impl;

import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.dao.acl.IUserRoleDao;
import com.spoon.entity.acl.Role;
import com.spoon.entity.acl.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户-角色
 *
 * @author:FuShaoxing
 * @date:2012-10-29 上午09:03:14
 */
@Repository("userRoleDao")
public class UserRoleDaoImpl extends MyBaseDaoImpl<UserRole> implements IUserRoleDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> listRoleByUserId(String userId) {
        String hql = "select a.role from " + clazz.getName() + " a where a.user.id=?";
        return (List<Role>) queryList(hql, userId);
    }

    @Override
    public void deleteByUserId(String id) {
        String hql = "delete from " + clazz + " where user.id=?";
        executeHql(hql, id);
    }
}
