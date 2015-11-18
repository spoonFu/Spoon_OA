package com.spoon.dao.acl;

import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.entity.acl.Role;
import com.spoon.entity.acl.RoleResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 角色-资源 对应关系
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月5日 下午9:13:34
 */
@Repository("roleResourceDao")
public class RoleResourceDaoImpl extends MyBaseDaoImpl<RoleResource> implements IRoleResourceDao {
    @Autowired
    private IRoleDao roleDao;
    @Autowired
    private IResourceDao resourceDao;

    @SuppressWarnings("unchecked")
    public List<Role> listRole(String resourceId) {
        Assert.hasText(resourceId);
        String hql = "select a.role from RoleResource a where a.resource.id =?";
        return (List<Role>) super.queryList(hql, resourceId);
    }

}
