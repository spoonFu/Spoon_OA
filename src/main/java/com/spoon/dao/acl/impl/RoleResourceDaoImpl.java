package com.spoon.dao.acl.impl;

import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.dao.acl.IResourceDao;
import com.spoon.dao.acl.IRoleDao;
import com.spoon.dao.acl.IRoleResourceDao;
import com.spoon.entity.acl.Resource;
import com.spoon.entity.acl.Role;
import com.spoon.entity.acl.RoleResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 角色-资源 对应关系
 *
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月5日 下午9:13:34
 */
@Repository("roleResourceDao")
public class RoleResourceDaoImpl extends MyBaseDaoImpl<RoleResource> implements IRoleResourceDao {
    @Autowired
    private IRoleDao roleDao;
    @Autowired
    private IResourceDao resourceDao;

    @Override
    public List<Role> findRoleByResourceId(String resourceId) {
        Assert.hasText(resourceId);
        String hql = "select a.role from RoleResource a where a.resource.id =?";
        return (List<Role>) queryList(hql, resourceId);
    }

    @Override
    public List<Resource> findResourceByRoleId(String roleId) {
        Assert.hasText(roleId);
        String hql = "select a.resource from RoleResource a where a.role.id =?";
        return (List<Resource>) queryList(hql, roleId);
    }

}
