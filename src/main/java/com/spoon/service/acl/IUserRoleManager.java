/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.service.acl;

import com.spoon.entity.acl.Role;

import java.util.List;

/**
 * 用户角色管理
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
public interface IUserRoleManager {
    /**
     * 根据用户id查询角色
     *
     * @param userId
     * @return
     */
    List<Role> listRoleByUserId(String userId);
}
