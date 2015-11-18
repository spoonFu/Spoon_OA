package com.spoon.dao.acl;

import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.entity.acl.User;
import com.spoon.model.Pagination;
import com.spoon.condition.acl.UserCondition;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author:FuShaoxing
 * @date:2012-10-26 下午01:09:50
 * @version:1.0
 */
@Repository("userDao")
public class UserDaoImpl extends MyBaseDaoImpl<User> implements IUserDao {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public User findUserByLoginName(String loginName) {
		return findByProperty("username", loginName);
	}

	@Override
	public void updateLastLogin(String id, Date date) {
		String sql = "update "+clazz.getName()+" set lastlogin=? where id=?";
		getSession().createQuery(sql).setString(0, sdf.format(date)).setString(1, id).executeUpdate();
	}

	@Override
	public Pagination queryPage(UserCondition cond) {
		StringBuffer hql = new StringBuffer(" from "+clazz.getName()+" where 1=1");
		Pagination page = queryPage(hql.toString(), new Object[] {}, cond);
		return page;
	}

}
