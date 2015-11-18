package com.spoon.dao.acl;

import java.util.Date;

import com.spoon.dao.IMyBaseDao;
import com.spoon.entity.acl.User;
import com.spoon.model.Pagination;
import com.spoon.condition.acl.UserCondition;

/**
 * 用户dao
 * @author:FuShaoxing
 * @date:2012-10-26 上午11:46:11
 * @version:1.0
 */
public interface IUserDao extends IMyBaseDao<User> {
	/**
	 * 根据用户名查找用户
	 * @param loginName
	 * @return
	 */
	public User findUserByLoginName(String loginName);

	/**
	 * 更新用户最近一次登陆时间
	 * @param id
	 * @param date
	 */
	public void updateLastLogin(String id, Date date);

	/**
	 * 分页查询
	 * @param cond
	 * @param page
	 * @return
	 */
	public Pagination queryPage(UserCondition cond);
}