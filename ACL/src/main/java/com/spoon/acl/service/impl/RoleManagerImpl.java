/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.service.impl;

import com.spoon.condition.acl.RoleCondition;
import com.spoon.dao.acl.IRoleDao;
import com.spoon.dao.acl.IUserRoleDao;
import com.spoon.entity.acl.Role;
import com.spoon.entity.acl.User;
import com.spoon.model.Pagination;
import com.spoon.service.ServiceException;
import com.spoon.service.acl.IRoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 角色服务类
 *
 * @author 付韶兴
 * @update 2012-12-12 上午10:10:21
 */
@Service("roleManager")
public class RoleManagerImpl implements IRoleManager {
    @Autowired
    private IUserRoleDao userRoleDao;
    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findRoleByUser(User user) {
        return userRoleDao.listRoleByUserId(user.getId());
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public Role save(Role role) {
        String id = roleDao.save(role).toString();
        return findById(id);
    }

    @Override
    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    public void deleteById(String id) throws ServiceException {
        roleDao.delete(findById(id));
    }

    @Override
    public Pagination queryPage(RoleCondition cond) {
        return roleDao.queryPage(cond);
    }

    @Override
    public Map<String, List<Role>> findRoleMap() {
        Map<String, List<Role>> rolemap = new ConcurrentHashMap<String, List<Role>>();
        List<Role> roles = roleDao.getAll();
        for (Role role : roles) {
            String deptname = role.getDept().getName();
            List<Role> rs = rolemap.get(deptname);
            rs = rs == null ? new ArrayList<Role>() : rs;
            rs.add(role);
            rolemap.put(deptname, rs);
        }
        return rolemap;
    }

}
