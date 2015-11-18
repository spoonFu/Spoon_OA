package com.spoon.dao.acl;

import java.util.List;

import com.spoon.dao.IMyBaseDao;
import com.spoon.entity.acl.Role;
import com.spoon.entity.acl.RoleResource;

/**
 * 类说明
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月5日 下午8:52:42
 */
public interface IRoleResourceDao extends IMyBaseDao<RoleResource> {

	List<Role> listRole(String resourceId);

}
