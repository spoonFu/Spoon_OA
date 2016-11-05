/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.service.impl;

import com.spoon.dao.acl.IUserRoleDao;
import com.spoon.entity.acl.Role;
import com.spoon.service.MyBaseService;
import com.spoon.service.acl.IUserRoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色关系
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
@Service("userRoleManager")
public class UserRoleManagerImpl extends MyBaseService implements IUserRoleManager {
    @Autowired
    private IUserRoleDao userRoleDao;

    @Override
    public List<Role> listRoleByUserId(String userId) {
        return this.userRoleDao.listRoleByUserId(userId);
    }
}
