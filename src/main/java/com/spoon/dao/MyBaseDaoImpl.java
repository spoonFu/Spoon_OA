package com.spoon.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.ObjectUtils;

import com.spoon.entity.MyBaseEntity;
import com.spoon.model.Pagination;
import com.spoon.condition.MyBaseCondition;

/**
 * dao实现基类
 *
 * @author:FuShaoxing
 * @date:2012-10-25 下午04:02:46
 * @version:1.0
 */
public abstract class MyBaseDaoImpl<T extends MyBaseEntity> implements IMyBaseDao<T> {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    protected Class<T> clazz;
    private static String COUNT_STR = "select count(id) ";

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    public MyBaseDaoImpl() {
        Class<T> parameterizedClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        if (parameterizedClass == null) {
            throw new IllegalArgumentException("The BseEntity must be appointed!");
        }
        this.clazz = parameterizedClass;
    }

    /**
     * 事务必须是开启的(Required)，否则获取不到
     * @return
     */
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 获取新创建的Session，不在事务中，需要手动关闭
     * @return
     */
    public Session getNewSession() {
        return sessionFactory.openSession();
    }

    /**
     * 根据id获取实体
     * @param id
     * @return
     */
    public T findById(Serializable id) {
        Session session = getNewSession();
        Object o = session.get(clazz, id);
        session.close();
        return (T) o;
    }

    /**
     * 根据属性名和值查询对象，将返回查到的第一个对象。不存在时则返回null
     * @param propertyName
     * @param value
     * @return
     */
    public T findByProperty(String propertyName, Object value) {
        if (StringUtils.isEmpty(propertyName)) {
            logger.warn("propertyName must specified.");
            return null;
        }
        String hql = "from " + clazz.getName() + " where " + propertyName + "=?";
        Session session = getNewSession();
        Object o = session.createQuery(hql).setParameter(0, value).setMaxResults(1).uniqueResult();
        session.close();
        return (T) o;
    }

    /**
     * 根据属性名和值查询对象列表
     * @param propertyName
     * @param value
     * @return
     */
    public List<T> findsByProperty(String propertyName, Object value) {
        if (StringUtils.isEmpty(propertyName)) {
            logger.warn("propertyName must specified.");
            return null;
        }
        String hql = "from " + clazz.getName() + " where " + propertyName + "=?";
        Session session = getNewSession();
        List<T> list = session.createQuery(hql).setParameter(0, value).list();
        session.close();
        return list;
    }

    /**
     * 查询集合
     * @param hql
     * @return
     */
    @Override
    public List<?> queryList(String hql) {
        return queryList(hql, null);
    }

    /**
     * 查询集合
     * @param hql
     * @param value 参数
     * @return
     */
    @Override
    public List<?> queryList(String hql, Object value) {
        return queryList(hql, new Object[]{value});
    }

    /**
     * 查询集合
     * @param hql
     * @param values 参数
     * @return
     */
    @Override
    public List<?> queryList(String hql, Object[] values) {
        Session session = getNewSession();
        List<?> list = setParams(session.createQuery(hql), values).list();
        session.close();
        return list;
    }

    /**
     * 为查询设置参数
     * @param query
     * @param params 参数数组
     */
    protected Query setParams(Query query, Object[] params) {
        if (params == null) {
            return query;
        }
        for (int i = 0; i < params.length; i++) {
            if (params[i] instanceof Date) {
                query.setTimestamp(i, (Date) params[i]);
            } else {
                query.setParameter(i, params[i]);
            }
        }
        return query;
    }


    @Override
    public Serializable save(T entity) {
        if (entity == null) {
            return null;
        }
        return getSession().save(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        if (entity == null) {
            return;
        }
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void update(T entity) {
        if (entity == null) {
            return;
        }
        getSession().update(entity);
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    /**
     * 获取全部对象
     * @return
     */
    @Override
    public List<T> getAll() {
        return getAll("");
    }

    /**
     * 根据排序语句获取对象列表
     * @param orderSql 排序语句
     * @return
     */
    @Override
    public List<T> getAll(String orderSql) {
        if (clazz == null) {
            return new ArrayList<T>();
        }
        String hql = "from " + clazz.getName() + " " + orderSql;
        Session session = getNewSession();
        List<?> list = session.createQuery(hql).list();
        session.close();
        return (List<T>) list;
    }


    /**
     * 查询size，可用select count语句，亦可用查询list的语句
     * @param hql 查询语句
     * @param paramValues 参数数组
     * @return
     */
    public long querySize(String hql, Object[] paramValues) {
        List<?> list = queryList(hql, paramValues);
        // 如果结果数大于1，则一定不是用count语句查询的
        if (list.size() > 1) {
            return list.size();
        }
        // 有可能是用count语句查询的
        Object obj = list.get(0);
        if (obj instanceof Long) {
            return ((Long) list.get(0));
        }
        return 1;
    }

    /**
     * 查询size，可用select count语句，亦可用查询list的语句
     * @param hql 查询语句
     * @param paramValue 参数
     * @return
     */
    public long querySize(String hql, Object paramValue) {
        return querySize(hql, new Object[]{paramValue});
    }

    /**
     * 查询size，可用select count语句，亦可用查询list的语句
     * @param hql 查询语句
     * @return
     */
    public long querySize(String hql) {
        return querySize(hql, (Object[]) null);
    }

    /**
     * 分页查询的对象结果集
     * @param hql 查询语句
     * @param paramValues 参数数组
     * @param start
     * @param limit
     * @return
     */
    protected List<?> pageList(String hql, Object[] paramValues, int start, int limit) {
        Session session = getNewSession();
        Query q = setParams(session.createQuery(hql), paramValues);
        if (start >= 0) {
            q.setFirstResult(start);
        }
        if (limit > 0) {
            q.setMaxResults(limit);
        }
        return q.list();
    }

    /**
     * 分页查询的对象结果集
     * @param hql 查询语句
     * @param paramValue 参数
     * @param start
     * @param limit
     * @return
     */
    protected List<?> pageList(String hql, Object paramValue, int start, int limit) {
        return pageList(hql, new Object[]{paramValue}, start, limit);
    }

    /**
     * 分页查询的对象结果集
     * @param hql 查询语句
     * @param start
     * @param limit
     * @return
     */
    protected List<?> pageList(String hql, int start, int limit) {
        return pageList(hql, (Object[]) null, start, limit);
    }

    /**
     * 分页查询
     * @param hql 查询语句
     * @param params 参数数组
     * @param cond
     * @return
     */
    public Pagination queryPage(String hql, Object[] params, MyBaseCondition cond) {
        return queryPage(hql, COUNT_STR + hql, params, cond);
    }

    /**
     * 分页查询
     * @param hql 查询语句
     * @param countHql 查询count语句
     * @param params 参数数组
     * @param cond
     * @return
     */
    public Pagination queryPage(String hql, String countHql, Object[] params, MyBaseCondition cond) {
        int pageNum = cond.getPageNum();
        int limit = cond.getRowSize();
        long totalCount = querySize(countHql, params);
        int start = (pageNum - 1) * limit;
        if (start > totalCount) {
            start = (int) totalCount - (int) totalCount % limit;
        } else if (start == totalCount) {
            start = (int) totalCount - limit;
        } else if (start < 0) {
            start = 0;
        }
        /** 加入排序语句 **/
        if (StringUtils.isNotEmpty(cond.getOrderSql())) {
            hql += cond.getOrderSql();
        }
        long pagesize = totalCount / limit;
        Pagination pagination = new Pagination();
        pagination.setStartNum(start);
        pagination.setRowSize(limit);
        pagination.setTotalCount(totalCount);
        pagination.setResult(pageList(hql, params, start, limit));
        pagination.setPageNum(pageNum);
        pagination.setPageSize(new Long(totalCount % limit != 0 ? pagesize + 1 : pagesize).intValue());
        return pagination;
    }

    /**
     * 执行更新语句
     * @param hql
     * @return
     */
    public int executeHql(String hql) {
        return getSession().createQuery(hql).executeUpdate();
    }

    /**
     * 执行更新语句
     * @param hql
     * @param param
     * @return
     */
    public int executeHql(String hql, Object param) {
        return executeHql(hql, new Object[]{param});
    }

    /**
     * 执行更新语句
     * @param hql
     * @param params
     * @return
     */
    public int executeHql(String hql, Object[] params) {
        Query q = getSession().createQuery(hql);
        return setParams(q, params).executeUpdate();
    }
}
