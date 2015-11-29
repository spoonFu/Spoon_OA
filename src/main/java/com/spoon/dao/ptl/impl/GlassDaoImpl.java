/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.dao.ptl.impl;

import com.spoon.condition.ptl.GlassCondition;
import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.dao.ptl.IGlassDao;
import com.spoon.entity.ptl.Glass;
import com.spoon.model.Pagination;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

/**
 * 眼镜
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
@Repository("glassDaoImpl")
public class GlassDaoImpl extends MyBaseDaoImpl<Glass> implements IGlassDao {
    @Override
    public List<Glass> findByCond(GlassCondition cond) {
        List<Object> params = new ArrayList();
        StringBuffer hql = new StringBuffer(" from " + this.clazz.getName() + " where 1=1");
        setCond(cond, params, hql);
        return (List<Glass>) queryList(hql.toString());
    }

    @Override
    public Pagination queryPage(GlassCondition cond) {
        List<Object> params = new ArrayList();
        StringBuffer hql = new StringBuffer(" from " + this.clazz.getName() + " where 1=1");
        setCond(cond, params, hql);
        return queryPage(hql.toString(), params.toArray(), cond);
    }

    private void setCond(GlassCondition cond, List<Object> params, StringBuffer hql) {
        if (cond.getStyle() != null) {
            params.add(cond.getStyle());
            hql.append(" and style=?");
        }
        if (cond.getMaterial() != null) {
            params.add(cond.getMaterial());
            hql.append(" and material=?");
        }
        if (cond.getBrand() != null) {
            params.add(cond.getBrand());
            hql.append(" and brand=?");
        }
        if (cond.getShape() != null) {
            params.add(cond.getShape());
            hql.append(" and shape=?");
        }
        if (StringUtils.isNotEmpty(cond.getColor())) {
            params.add("%" + cond.getColor() + "%");
            hql.append(" and color like ?");
        }
        if (StringUtils.isNotEmpty(cond.getWidth())) {
            params.add("%" + cond.getWidth() + "%");
            hql.append(" and width like ?");
        }
        if ((StringUtils.isNotEmpty(cond.getColumn())) && (StringUtils.isNotEmpty(cond.getOrder()))) {
            hql.append(" order by " + cond.getColumn() + " " + cond.getOrder());
        }
    }
}
