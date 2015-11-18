package com.spoon.service.acl;

import com.spoon.entity.acl.User;
import com.spoon.model.Pagination;
import com.spoon.service.ServiceException;
import com.spoon.condition.acl.UserCondition;

import java.util.Date;

/**
 * 用户
 * @author:FuShaoxing
 * @date:2012-10-29 下午01:53:04
 * @version:1.0
 */
public interface IUserManager {
	public User findById(String id);

	/**
	 * 是否将角色信息查询出来
	 * @param id
	 * @param flag
	 * @return
	 */
	public User findById(String id, boolean flag);

	public User save(User user);

	public User update(User user);

	public User findUserByLoginName(String loginName);

	public User deleteById(String id) throws ServiceException;

	public User conf(User user);

	public void updateLastLogin(String id, Date date);

	/**
	 * 分页查询
	 * @param cond
	 * @param page
	 * @return
	 */
	public Pagination queryPage(UserCondition cond);
}
