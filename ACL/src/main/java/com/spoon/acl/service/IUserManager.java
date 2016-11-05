/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.service;

import com.spoon.condition.acl.UserCondition;
import com.spoon.entity.acl.User;
import com.spoon.model.Pagination;
import com.spoon.service.ServiceException;

import java.util.Date;
import java.util.List;

/**
 * 用户
 *
 * @author:FuShaoxing
 * @date:2012-10-29 下午01:53:04
 * @version:1.0
 */
public interface IUserManager {
    public User findById(String id);

    /**
     * 是否将角色信息查询出来
     *
     * @param id
     * @param flag
     * @return
     */
    User findById(String id, boolean flag);

    User save(User user);

    User update(User user);

    User findUserByLoginName(String loginName);

    User deleteById(String id) throws ServiceException;

    User conf(User user);

    void updateLastLogin(String id, Date date);

    /**
     * 分页查询
     *
     * @param cond
     * @return
     */
    Pagination queryPage(UserCondition cond);

    /**
     * 查询及时聊天用户
     *
     * @param userId
     * @return
     */
    List<User> listImUsers(String userId);
}
