package com.spoon.service.ptl;

import java.util.List;

import com.spoon.entity.ptl.Article;
import com.spoon.model.Pagination;
import com.spoon.service.ServiceException;
import com.spoon.condition.ptl.ArticleCondition;

/**
 * 网站文章管理
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月2日 下午7:56:53
 */
public interface IArticleManager {
	public Article findById(String id);

	public String save(Article article);

	public void update(Article article);

	public List<Article> getAll();

	public void deleteById(String id) throws ServiceException;

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
	 * 将文章阅读数量+1
	 * @param id
	 */
	public void updCount(String id);
}
