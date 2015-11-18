package com.spoon.dao.ptl;

import com.spoon.dao.IMyBaseDao;
import com.spoon.entity.ptl.Article;
import com.spoon.model.Pagination;
import com.spoon.condition.ptl.ArticleCondition;

import java.util.List;

/**
 * 
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月2日 下午7:19:32
 */
public interface IArticleDao extends IMyBaseDao<Article> {

	public List<Article> findByCond(ArticleCondition cond);

	public List<Article> findTitles(ArticleCondition cond);

	/**
	 * 分页查询
	 * @param cond
	 * @param page
	 * @return
	 */
	public Pagination queryPage(ArticleCondition cond);

	/**
	 * 将文章的阅读次数+1
	 * @param id
	 */
	public void updCount(String id);
}
