/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.dao;

import com.spoon.dao.IMyBaseDao;
import com.spoon.entity.acl.Resource;
import com.spoon.entity.acl.Role;
import com.spoon.entity.acl.RoleResource;

import java.util.List;

/**
 * 类说明
 *
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月5日 下午8:52:42
 */
public interface IRoleResourceDao extends IMyBaseDao<RoleResource> {

    public abstract List<Role> findRoleByResourceId(String paramString);

    public abstract List<Resource> findResourceByRoleId(String paramString);

}
