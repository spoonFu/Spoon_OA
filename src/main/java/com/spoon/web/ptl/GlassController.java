/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.web.ptl;

import com.spoon.condition.ptl.GlassCondition;
import com.spoon.service.ptl.IGlassManager;
import com.spoon.web.MyBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 眼镜管理页请求处理
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
@Controller
@RequestMapping("/ptl/glass")
public class GlassController extends MyBaseController {
    String basedir = "/ptl/glass";
    @Resource
    private IGlassManager glassManager;

    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public String manageGet(HttpSession session, HttpServletRequest req, Model model) {
        GlassCondition cond = (GlassCondition) getCond(session, GlassCondition.class, null);
        if (cond == null) {
            cond = (GlassCondition) getCond(session, GlassCondition.class, new GlassCondition());
        }
        setPage(model, this.glassManager.queryPage(cond));
        model.addAttribute("condition", cond);
        setMenu(model, req);
        return this.basedir + "/manage";
    }

    @RequestMapping(value = "/manage", method = RequestMethod.POST)
    public String managePost(@ModelAttribute("condition") GlassCondition cond, HttpSession session, HttpServletRequest req, Model model) {
        cond = (GlassCondition) getCond(session, GlassCondition.class, cond);
        setPage(model, this.glassManager.queryPage(cond));
        return this.basedir + "/result";
    }
}
