package com.spoon.dao.acl.impl;

import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.dao.acl.IUserDao;
import com.spoon.entity.acl.User;
import com.spoon.model.Pagination;
import com.spoon.condition.acl.UserCondition;
import com.spoon.utils.TimeUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author:FuShaoxing
 * @date:2012-10-26 下午01:09:50
 * @version:1.0
 */
@Repository("userDao")
public class UserDaoImpl extends MyBaseDaoImpl<User> implements IUserDao {
    @Override
    public User findUserByLoginName(String loginName) {
        return (User) findByProperty("username", loginName);
    }

    @Override
    public void updateLastLogin(String id, Date date) {
        String sql = "update " + this.clazz.getName() + " set lastlogin=? where id=?";
        getSession().createQuery(sql).setString(0, TimeUtils.NORMAL_FORMAT.format(date)).setString(1, id).executeUpdate();
    }

    @Override
    public Pagination queryPage(UserCondition cond) {
        StringBuffer hql = new StringBuffer(" from " + this.clazz.getName() + " where 1=1");
        final List<String> params = new ArrayList<String>();
        if(StringUtils.isNotEmpty(cond.getName())){
            params.add("%"+cond.getName()+"%");
            hql.append(" and name like ?");
        }
        Pagination page = queryPage(hql.toString(), params.toArray(), cond);
        return page;
    }

    @Override
    public List<User> listImUsers(String userId) {
        String hql = "select new " + this.clazz.getName() + "(id,name,icon) from " + this.clazz.getName() + " where id<>? and locked=false and enabled=true";
        return (List<User>) queryList(hql, userId);
    }
}
