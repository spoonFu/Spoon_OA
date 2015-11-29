package com.spoon.web.ptl;

import com.spoon.condition.ptl.ArticleCondition;
import com.spoon.entity.ptl.Article;
import com.spoon.service.ServiceException;
import com.spoon.service.ptl.IArticleManager;
import com.spoon.service.ptl.INavigationManager;
import com.spoon.web.MyBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 网站管理
 *
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月9日 上午11:19:49
 */
@Controller
@RequestMapping(value = "/ptl/article")
public class ArticleController extends MyBaseController {
    String basedir = "/ptl/article";
    @Autowired
    private IArticleManager articleManager;
    @Autowired
    private INavigationManager navigationManager;

    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public String manageGet(HttpSession session, HttpServletRequest req, Model model) {
        ArticleCondition cond = (ArticleCondition) getCond(session, ArticleCondition.class, null);
        if (cond == null) {
            cond = (ArticleCondition) getCond(session, ArticleCondition.class, new ArticleCondition());
        }
        setPage(model, articleManager.queryPage(cond));
        model.addAttribute("condition", cond);
        model.addAttribute("navs", navigationManager.findAll());
        setMenu(model, req);
        return basedir + "/manage";
    }

    @RequestMapping(value = "/manage", method = RequestMethod.POST)
    public String managePost(@ModelAttribute("condition") ArticleCondition cond, HttpSession session, HttpServletRequest req, Model model) {
        cond = (ArticleCondition) getCond(session, ArticleCondition.class, cond);
        setPage(model, articleManager.queryPage(cond));
        return basedir + "/result";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGet(HttpServletRequest req, Model model) {
        model.addAttribute("pojomodel", new Article());
        model.addAttribute("navs", navigationManager.findAll());
        return basedir + "/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(@ModelAttribute("pojomodel") Article article, HttpSession session, HttpServletRequest req, Model model) {
        article.setAuthor(getCurrentUser());
        articleManager.save(article);
        ArticleCondition cond = new ArticleCondition();
        cond.setOrder("createtime,desc,else");
        cond = (ArticleCondition) getCond(session, cond.getClass(), cond);
        setPage(model, articleManager.queryPage(cond));
        return basedir + "/result";
    }

    @RequestMapping(value = "/mod", method = RequestMethod.GET)
    public String modGet(@RequestParam("id") String id, HttpServletRequest req, Model model) {
        model.addAttribute("pojomodel", articleManager.findById(id));
        model.addAttribute("navs", navigationManager.findAll());
        return basedir + "/mod";
    }

    @RequestMapping(value = "/mod", method = RequestMethod.POST)
    public String modPost(@ModelAttribute("pojomodel") Article article, HttpSession session, HttpServletRequest req, Model model) {
        articleManager.update(article);
        ArticleCondition cond = (ArticleCondition) getCond(session, ArticleCondition.class, null);
        setPage(model, articleManager.queryPage(cond));
        return basedir + "/result";
    }

    @RequestMapping(value = "/del.do")
    public String del(@RequestParam("id") String id, HttpSession session, HttpServletRequest req, Model model) {
        try {
            articleManager.deleteById(id);
            addError(model, "删除操作成功！");
        } catch (ServiceException e) {
            addError(model, "操作异常：" + e.getMessage());
        }
        return managePost(null, session, req, model);
    }
}
