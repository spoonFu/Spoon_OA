package com.spoon.service.acl;

import com.spoon.condition.acl.RoleCondition;
import com.spoon.entity.acl.Role;
import com.spoon.entity.acl.User;
import com.spoon.model.Pagination;
import com.spoon.service.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * 
 * @version 1.0
 * @author 付韶兴
 * @update 2012-12-12 上午10:09:42
 */
public interface IRoleManager {
	public List<Role> findRoleByUser(User user);

	public Role findById(String id);

	public Role save(Role role);

	public void update(Role role);

	public void deleteById(String id) throws ServiceException;

	/**
	 * 将所有角色按部门分类
	 * @return
	 */
	public Map<String, List<Role>> findRoleMap();

	/**
	 * 分页查询
	 * @param cond
	 * @param page
	 * @return
	 */
	public Pagination queryPage(RoleCondition cond);
}
