package com.spoon.web.acl;

import com.spoon.entity.acl.Role;
import com.spoon.service.ServiceException;
import com.spoon.service.acl.IRoleManager;
import com.spoon.condition.acl.RoleCondition;
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
 * 角色管理请求处理
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月23日 下午10:16:15
 */
@Controller
@RequestMapping(value = "/acl/role")
public class RoleController extends MyBaseController {
	String basedir = "/acl/role";
	@Autowired
	private IRoleManager roleManager;

	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manageGet(HttpSession session, HttpServletRequest req, Model model) {
		RoleCondition cond = (RoleCondition) getCond(session, RoleCondition.class, null);
		cond = cond==null ? new RoleCondition() : cond;
		setPage(model, roleManager.queryPage(cond));
		model.addAttribute("condition", cond);
		setMenu(model, req);
		return basedir+"/manage";
	}

	@RequestMapping(value = "/manage", method = RequestMethod.POST)
	public String managePost(@ModelAttribute("condition") RoleCondition cond, HttpSession session, HttpServletRequest req, Model model) {
		cond = (RoleCondition) getCond(session, RoleCondition.class, cond);
		setPage(model, roleManager.queryPage(cond));
		return basedir+"/result";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addGet(HttpServletRequest req, Model model) {
		model.addAttribute("pojomodel", new Role());
		return basedir+"/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPost(@ModelAttribute("pojomodel") Role role, HttpSession session, HttpServletRequest req, Model model) {
		roleManager.save(role);
		RoleCondition cond = new RoleCondition();
		//cond.setOrder("createtime,desc,else");
		cond = (RoleCondition) getCond(session, cond.getClass(), cond);
		setPage(model, roleManager.queryPage(cond));
		return basedir+"/result";
	}

	@RequestMapping(value = "/mod", method = RequestMethod.GET)
	public String modGet(@RequestParam("id") String id, HttpServletRequest req, Model model) {
		model.addAttribute("pojomodel", roleManager.findById(id));
		return basedir+"/mod";
	}

	@RequestMapping(value = "/mod", method = RequestMethod.POST)
	public String modPost(@ModelAttribute("pojomodel") Role role, HttpSession session, HttpServletRequest req, Model model) {
		roleManager.update(role);
		RoleCondition cond = (RoleCondition) getCond(session, RoleCondition.class, null);
		setPage(model, roleManager.queryPage(cond));
		return basedir+"/result";
	}

	@RequestMapping(value = "/del.do")
	public String del(@RequestParam("id") String id, HttpSession session, HttpServletRequest req, Model model) {
		try {
			roleManager.deleteById(id);
			addError(model, "删除操作成功！");
		} catch (ServiceException e) {
			addError(model, "操作异常："+e.getMessage());
		}
		return managePost(null, session, req, model);
	}
}
