/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.service;

import com.spoon.condition.acl.RoleCondition;
import com.spoon.entity.acl.Role;
import com.spoon.entity.acl.User;
import com.spoon.model.Pagination;
import com.spoon.service.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * @author 付韶兴
 * @version 1.0
 * @update 2012-12-12 上午10:09:42
 */
public interface IRoleManager {
    List<Role> findRoleByUser(User user);

    Role findById(String id);

    Role save(Role role);

    void update(Role role);

    void deleteById(String id) throws ServiceException;

    /**
     * 将所有角色按部门分类
     *
     * @return
     */
    Map<String, List<Role>> findRoleMap();

    /**
     * 分页查询
     *
     * @param cond
     * @return
     */
    Pagination queryPage(RoleCondition cond);
}
