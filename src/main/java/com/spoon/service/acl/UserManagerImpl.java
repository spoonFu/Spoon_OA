package com.spoon.service.acl;

import com.spoon.condition.acl.UserCondition;
import com.spoon.dao.acl.IRoleDao;
import com.spoon.dao.acl.IUserDao;
import com.spoon.dao.acl.IUserRoleDao;
import com.spoon.entity.acl.Role;
import com.spoon.entity.acl.User;
import com.spoon.entity.acl.UserRole;
import com.spoon.model.Pagination;
import com.spoon.service.ServiceException;
import com.spoon.utils.TimeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户
 * @author:FuShaoxing
 * @date:2012-10-29 下午01:54:52
 * @version:1.0
 */
@Service("userManager")
public class UserManagerImpl implements IUserManager {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private IUserDao userDao;
	@Autowired
	private IRoleDao roleDao;
	@Autowired
	private IUserRoleDao userRoleDao;

	@Override
	public User findUserByLoginName(String loginName) {
		return userDao.findUserByLoginName(loginName);
	}

	@Override
	@Transactional
	public User save(User user) {
		/***** 保存用户信息 *****/
		PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
		user.setCreatetime(TimeUtils.currentString());
		String id = userDao.save(user).toString();
		log.info("保存用户信息成功:"+user.getName());
		/******** 保存角色信息 ********/
		String[] roleIds = user.getRoleIds();
		for (String roleId : roleIds) {
			UserRole userRole = new UserRole();
			userRole.setRole(new Role(roleId));
			userRole.setUser(findById(id));
			userRoleDao.save(userRole);
		}
		log.info("保存用户-角色关系信息成功：共"+roleIds.length+"条");
		return findById(id);
	}

	@Override
	public User update(User user) {
		User entity = findById(user.getId());
		BeanUtils.copyProperties(user, entity, new String[] { "id", "username" });
		userDao.update(entity);
		return findById(user.getId());
	}

	@Override
	public void updateLastLogin(String id, Date date) {
		userDao.updateLastLogin(id, date);
	}

	@Override
	public User findById(String id) {
		return findById(id, false);
	}

	@Override
	public Pagination queryPage(UserCondition cond) {
		return userDao.queryPage(cond);
	}

	@Override
	public User deleteById(String id) throws ServiceException {
		if ("admin".equals(id))
			throw new ServiceException("系统管理员不能删除");
		User user = findById(id);
		if (user==null)
			throw new ServiceException("要删除的用户不存在");
		userDao.delete(user);
		return user;
	}

	@Override
	public User conf(User user) {
		userRoleDao.deleteByUserId(user.getId());
		List<Role> roles = new ArrayList<Role>();
		for (String id : user.getRoleIds()) {
			Role role = roleDao.findById(id);
			if (role==null) {
				log.error("所选的角色不存在.");
				continue;
			}
			roles.add(role);
			UserRole userRole = new UserRole();
			userRole.setRole(role);
			userRole.setUser(findById(user.getId()));
			userRoleDao.save(userRole);
		}
		return null;
	}

	@Override
	public User findById(String id, boolean flag) {
		User user = userDao.findById(id);
		if (!flag)
			return user;
		List<Role> roles = userRoleDao.listRoleByUserId(id);
		user.setRoles(roles);
		if (roles.size()==0)
			return user;
		String[] roleIds = new String[roles.size()];
		for (int i = 0; i<roles.size(); i++) {
			roleIds[i] = roles.get(i).getId();
		}
		return user;
	}
}
