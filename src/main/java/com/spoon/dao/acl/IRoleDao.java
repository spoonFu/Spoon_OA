package com.spoon.dao.acl;

import com.spoon.dao.IMyBaseDao;
import com.spoon.entity.acl.Role;
import com.spoon.model.Pagination;
import com.spoon.condition.acl.RoleCondition;

/**
 * 角色
 * @author:FuShaoxing
 * @date:2012-10-30 下午01:32:35
 * @version:1.0
 */
public interface IRoleDao extends IMyBaseDao<Role> {
	/**
	 * 分页查询
	 * @param cond
	 * @return
	 */
	Pagination queryPage(RoleCondition cond);

}
