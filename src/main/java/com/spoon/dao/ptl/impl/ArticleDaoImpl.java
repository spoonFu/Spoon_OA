package com.spoon.dao.ptl.impl;

import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.dao.ptl.IArticleDao;
import com.spoon.entity.ptl.Article;
import com.spoon.model.Pagination;
import com.spoon.service.MyOrder;
import com.spoon.condition.ptl.ArticleCondition;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章DAO
 *
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月2日 下午7:55:43
 */
@Repository("articleDao")
public class ArticleDaoImpl extends MyBaseDaoImpl<Article> implements IArticleDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Article> findByCond(ArticleCondition cond) {
        List<Object> params = new ArrayList<Object>();
        StringBuffer hql = new StringBuffer(" from " + clazz.getName() + " where 1=1");
        if (StringUtils.isNotEmpty(cond.getNavid())) {
            params.add(cond.getNavid());
            hql.append(" and nav.id=?");
        }
        return (List<Article>) queryList(hql.toString(), params.toArray());
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Article> findTitles(ArticleCondition cond) {
        List<Object> params = new ArrayList();
        StringBuffer hql = new StringBuffer("select new " + this.clazz.getName() + "(id,nav,title,createtime,viewcount,visible) from " + this.clazz.getName() + " where 1=1");
        if (StringUtils.isNotEmpty(cond.getNavid())) {
            params.add(cond.getNavid());
            hql.append(" and nav.id=?");
        }
        if (cond.getVisible() != null) {
            params.add(cond.getVisible());
            hql.append(" and visible=?");
        }
        hql.append(" order by createtime desc");
        return (List<Article>) queryList(hql.toString(), params.toArray());
    }

    @Override
    public void updCount(String id) {
        String hql = "update " + clazz.getName() + " set viewcount=viewcount+1 where id=?";
        this.getSession().createQuery(hql).setString(0, id).executeUpdate();
    }

    @Override
    public Pagination queryPage(ArticleCondition cond) {
        StringBuffer hql = new StringBuffer(" from " + clazz.getName() + " where 1=1");
        List<Object> params = new ArrayList<Object>();
        if (StringUtils.isNotEmpty(cond.getNavid())) {
            params.add(cond.getNavid());
            hql.append(" and nav.id=?");
        }
        if (cond.getVisible() != null) {
            params.add(cond.getVisible());
            hql.append(" and visible=?");
        }
        if (!cond.containOrder("createtime"))
            cond.addOrder(new MyOrder("createtime", false, false), false);
        Pagination page = queryPage(hql.toString(), params.toArray(), cond);
        return page;
    }
}
