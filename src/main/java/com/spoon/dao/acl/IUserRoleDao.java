package com.spoon.dao.acl;

import com.spoon.dao.IMyBaseDao;
import com.spoon.entity.acl.Role;
import com.spoon.entity.acl.UserRole;

import java.util.List;

/**
 * 用户-角色
 * @author:FuShaoxing
 * @date:2012-10-29 上午08:51:50
 * @version:1.0
 */
public interface IUserRoleDao extends IMyBaseDao<UserRole> {
	/**
	 * 根据用户id获取用户角色
	 * @param userId
	 * @return
	 */
	public List<Role> listRoleByUserId(String userId);

	/**
	 * 根据id删除用户所拥有的角色
	 * @param id
	 */
	public void deleteByUserId(String id);
}
