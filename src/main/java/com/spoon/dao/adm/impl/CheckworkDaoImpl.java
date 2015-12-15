/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.dao.adm.impl;

import com.spoon.condition.adm.CheckworkCondition;
import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.dao.adm.ICheckworkDao;
import com.spoon.entity.adm.Checkwork;
import com.spoon.model.Pagination;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工签入签出管理
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/12/5
 */
@Repository("checkworkDao")
public class CheckworkDaoImpl extends MyBaseDaoImpl<Checkwork> implements ICheckworkDao {

    @Override
    public Pagination queryPage(CheckworkCondition cond) {
        Pagination page = queryPage(defHql, new Object[]{}, cond);
        return page;
    }

    @Override
    public List<Checkwork> findByCond(CheckworkCondition cond) {
        StringBuffer hql = new StringBuffer("from " + clazz.getName() + " where 1=1");
        List<Object> params = new ArrayList<Object>();
        if (StringUtils.isNotEmpty(cond.getUserId())) {
            hql.append(" and user_id=?");
            params.add(cond.getUserId());
        }
        if (StringUtils.isNotEmpty(cond.getDate())) {
            hql.append(" and date like ?");
            params.add(cond.getDate() + "%");
        }
        return (List<Checkwork>) queryList(hql.toString(), params.toArray());
    }
}
