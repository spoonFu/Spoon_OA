package com.spoon.web.acl;

import com.spoon.entity.acl.User;
import com.spoon.service.ServiceException;
import com.spoon.service.acl.IRoleManager;
import com.spoon.service.acl.IUserManager;
import com.spoon.condition.acl.UserCondition;
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
 * 用户controller
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月23日 下午10:16:04
 */
@Controller
@RequestMapping(value = "/acl/user")
public class UserController extends MyBaseController {
    String basedir = "/acl/user";
    @Autowired
    private IUserManager userManager;
    @Autowired
    private IRoleManager roleManager;

    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public String manageGet(HttpSession session, HttpServletRequest req, Model model) {
        UserCondition cond = (UserCondition) getCond(session, UserCondition.class, null);
        cond = cond == null ? new UserCondition() : cond;
        setPage(model, userManager.queryPage(cond));
        model.addAttribute("condition", cond);
        setMenu(model, req);
        return basedir + "/manage";
    }

    @RequestMapping(value = "/manage", method = RequestMethod.POST)
    public String managePost(@ModelAttribute("condition") UserCondition cond, HttpSession session, HttpServletRequest req, Model model) {
        cond = (UserCondition) getCond(session, UserCondition.class, cond);
        setPage(model, userManager.queryPage(cond));
        return basedir + "/result";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGet(HttpServletRequest req, Model model) {
        model.addAttribute("pojomodel", new User());
        model.addAttribute("rolemap", roleManager.findRoleMap());
        return basedir + "/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(@ModelAttribute("pojomodel") User user, HttpSession session, HttpServletRequest req, Model model) {
        User entity = userManager.save(user);
        addSysLog(req, "添加用户信息:" + entity);
        UserCondition cond = new UserCondition();
        cond.setOrder("createtime,desc,else");
        cond = (UserCondition) getCond(session, cond.getClass(), cond);
        setPage(model, userManager.queryPage(cond));
        return basedir + "/result";
    }

    @RequestMapping(value = "/mod", method = RequestMethod.GET)
    public String modGet(@RequestParam("id") String id, HttpServletRequest req, Model model) {
        model.addAttribute("pojomodel", userManager.findById(id));
        return basedir + "/mod";
    }

    @RequestMapping(value = "/mod", method = RequestMethod.POST)
    public String modPost(@ModelAttribute("pojomodel") User user, HttpSession session, HttpServletRequest req, Model model) {
        User entity = userManager.update(user);
        addSysLog(req, "修改用户信息:" + entity);
        UserCondition cond = (UserCondition) getCond(session, UserCondition.class, null);
        setPage(model, userManager.queryPage(cond));
        return basedir + "/result";
    }

    @RequestMapping(value = "/del.do")
    public String del(@RequestParam("id") String id, HttpSession session, HttpServletRequest req, Model model) {
        try {
            User user = userManager.deleteById(id);
            addSuccess(model, "删除操作成功！");
            addSysLog(req, "删除用户信息:" + user);
        } catch (ServiceException e) {
            addError(model, "操作异常：" + e.getMessage());
        }
        return managePost(null, session, req, model);
    }

    @RequestMapping(value = "/conf.do", method = RequestMethod.GET)
    public String confGet(@RequestParam("id") String id, HttpServletRequest req, Model model) {
        model.addAttribute("pojomodel", userManager.findById(id, true));
        model.addAttribute("rolemap", roleManager.findRoleMap());
        return basedir + "/conf";
    }

    @RequestMapping(value = "/conf.do", method = RequestMethod.POST)
    public String confPost(@ModelAttribute("pojomodel") User user, HttpServletRequest req, Model model) {
        userManager.conf(user);
        return basedir + "/result";
    }
}
