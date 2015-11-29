/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.dao.ptl.impl;

import com.spoon.condition.ptl.ProductCondition;
import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.dao.ptl.IProductDao;
import com.spoon.entity.ptl.Product;
import com.spoon.model.Pagination;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
@Repository("productDao")
public class ProductDaoImpl extends MyBaseDaoImpl<Product> implements IProductDao {
    @Override
    public List<Product> findByCond(ProductCondition cond) {
        List<Object> params = new ArrayList();
        StringBuffer hql = new StringBuffer(" from " + this.clazz.getName() + " where 1=1");
        if (StringUtils.isNotEmpty(cond.getLikestr())) {
            params.add("%" + cond.getLikestr() + "%");
            params.add("%" + cond.getLikestr() + "%");
            hql.append(" and (name like ? or tips like ?)");
        }
        return (List<Product>) queryList(hql.toString(), params.toArray());
    }

    @Override
    public Pagination queryPage(ProductCondition cond) {
        List<Object> params = new ArrayList();
        StringBuffer hql = new StringBuffer(" from " + this.clazz.getName() + " where 1=1");
        if (StringUtils.isNotEmpty(cond.getLikestr())) {
            params.add("%" + cond.getLikestr() + "%");
            params.add("%" + cond.getLikestr() + "%");
            hql.append(" and (name like ? or tags like ?)");
        }
        return queryPage(hql.toString(), params.toArray(), cond);
    }

    @Override
    public void updCount(String id) {
        String hql = "update " + this.clazz.getName() + " set viewcount=viewcount+1 where id=?";
        getSession().createQuery(hql).setString(0, id).executeUpdate();
    }
}