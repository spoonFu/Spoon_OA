/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.base.dao;

import com.spoon.condition.MyBaseCondition;
import com.spoon.entity.MyBaseEntity;
import com.spoon.model.Pagination;

import java.io.Serializable;
import java.util.List;

/**
 * dao接口基类
 *
 * @author:FuShaoxing
 * @date:2012-10-25 下午04:02:34
 * @version:1.0
 */
public interface IMyBaseDao<T extends MyBaseEntity> {
    public Serializable save(final T entity);

    public void saveOrUpdate(final T entity);

    public void update(final T entity);

    public void delete(final T entity);

    public List<T> getAll();

    public List<T> getAll(String orderSql);

    public T findById(Serializable id);

    public T findByProperty(String property, Object value);

    public List<T> findsByProperty(String propertyName, Object value);

    public List<?> queryList(String hql);

    public List<?> queryList(String hql, Object value);

    public List<?> queryList(String hql, Object[] values);

    public abstract List<T> queryNamedList(String paramString);

    public abstract List<T> queryNamedList(String paramString, Object paramObject);

    public abstract List<T> queryNamedList(String paramString, Object[] paramArrayOfObject);

    public Pagination queryPage(String hql, Object[] params, MyBaseCondition cond);

    public Pagination queryPage(String hql, String countHql, Object[] paramValues, MyBaseCondition cond);
}
