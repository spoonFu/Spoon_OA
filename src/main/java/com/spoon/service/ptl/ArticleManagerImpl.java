package com.spoon.service.ptl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spoon.dao.ptl.IArticleDao;
import com.spoon.entity.ptl.Article;
import com.spoon.model.Pagination;
import com.spoon.service.MyBaseService;
import com.spoon.service.ServiceException;
import com.spoon.condition.ptl.ArticleCondition;
import com.spoon.utils.TimeUtils;

/**
 * 网站文章管理
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月2日 下午7:58:26
 */
@Service("articleManager")
public class ArticleManagerImpl extends MyBaseService implements IArticleManager {
	@Autowired
	private IArticleDao articleDao;

	@Override
	public Article findById(String id) {
		return articleDao.findById(id);
	}

	@Override
	@Transactional
	public String save(Article article) {
		article.setCreatetime(TimeUtils.currentString());
		article.setId(getUUId());
		return articleDao.save(article).toString();
	}

	@Override
	@Transactional
	public void update(Article article) {
		articleDao.update(article);
	}

	@Override
	public List<Article> getAll() {
		return articleDao.getAll();
	}

	@Override
	@Transactional
	public void deleteById(String id) throws ServiceException {
		Article article = findById(id);
		if (article==null)
			throw new ServiceException("要被删除的文章不存在!");
		articleDao.delete(article);
	}

	@Override
	public List<Article> findByCond(ArticleCondition cond) {
		return articleDao.findByCond(cond);
	}

	@Override
	public List<Article> findTitles(ArticleCondition cond) {
		return articleDao.findTitles(cond);
	}

	@Override
	@Transactional
	public void updCount(String id) {
		articleDao.updCount(id);
	}

	@Override
	public Pagination queryPage(ArticleCondition cond) {
		return articleDao.queryPage(cond);
	}
}
