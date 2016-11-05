/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.dao.msg.impl;

import com.spoon.condition.msg.ImCondition;
import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.dao.msg.IImDao;
import com.spoon.entity.msg.Im;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 即时消息
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
@Repository("imDao")
public class ImDaoImpl extends MyBaseDaoImpl<Im> implements IImDao {
    @Override
    public List<Im> findByCond(ImCondition cond) {
        StringBuffer hql = new StringBuffer("from " + this.clazz.getName() + " where 1=1");
        List<Object> params = new ArrayList();
        if (cond.getFromUser() != null) {
            hql.append(" and fromUser.id=?");
            params.add(cond.getFromUser().getId());
        }
        if (cond.getToUser() != null) {
            hql.append(" and toUser.id=?");
            params.add(cond.getToUser().getId());
        }
        if (cond.getHaveread() != null) {
            hql.append(" and haveread=?");
            params.add(cond.getHaveread());
        }
        if ((cond.getFromUser() == null) && (cond.getToUser() == null)) {
            return new ArrayList();
        }
        hql.append(" order by createtime");
        return (List<Im>) queryList(hql.toString(), params.toArray());
    }

    @Override
    public void readMsgByCond(ImCondition cond) {
        StringBuffer hql = new StringBuffer("update " + this.clazz.getName() + " set haveread=true where 1=1 ");
        List<String> params = new ArrayList();
        if (cond.getFromUser() != null) {
            hql.append(" and fromUser.id=?");
            params.add(cond.getFromUser().getId());
        }
        if (cond.getToUser() != null) {
            hql.append(" and toUser.id=?");
            params.add(cond.getToUser().getId());
        }
        if ((cond.getFromUser() == null) && (cond.getToUser() == null)) {
            return;
        }
        Query q = getSession().createQuery(hql.toString());
        for (int i = 0; i < params.size(); i++) {
            q.setString(i, (String) params.get(i));
        }
        q.executeUpdate();
    }
}