package com.spoon.dao.acl;

import org.springframework.stereotype.Repository;

import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.entity.acl.Role;
import com.spoon.model.Pagination;
import com.spoon.condition.acl.RoleCondition;

/**
 * 类说明
 * 
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014-3-3 下午09:38:17
 */
@Repository("roleDao")
public class RoleDaoImpl extends MyBaseDaoImpl<Role> implements IRoleDao {

	@Override
	public Pagination queryPage(RoleCondition cond) {
		StringBuffer hql = new StringBuffer(" from "+clazz.getName()+" where 1=1");
		Pagination page = queryPage(hql.toString(), new Object[] {}, cond);
		return page;
	}

}
