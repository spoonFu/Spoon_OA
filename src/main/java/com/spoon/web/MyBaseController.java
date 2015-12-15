package com.spoon.web;

import com.spoon.condition.MyBaseCondition;
import com.spoon.entity.acl.Resource;
import com.spoon.entity.acl.User;
import com.spoon.entity.sys.SystemLog;
import com.spoon.entity.sys.enums.LogType;
import com.spoon.model.Pagination;
import com.spoon.dict.SessionProps;
import com.spoon.service.MyOrder;
import com.spoon.service.acl.IResourceManager;
import com.spoon.service.acl.IUserManager;
import com.spoon.service.sys.ISystemLogManager;
import com.spoon.utils.TimeUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 控制基类
 *
 * @author:FuShaoxing
 * @date:2012-10-25 上午11:30:50
 * @version:1.0
 */
public class MyBaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    protected ISystemLogManager systemLogManager;
    @Autowired
    protected IUserManager userManager;
    @Autowired
    protected IResourceManager resourceManager;
    protected final String note = "/note";

    /** 传往前台的pagination名称 */
    private String pagnname = "pagn";
    /**  */
    private String dictname = "dict";
    /** 定义记录的order个数，多次点击排序时记录排序优先级 */
    private int maxOrderSize = 3;

    /**
     * 获得当前登录用户
     *
     * @return
     */
    protected User getCurrentUser() {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof String) {
            logger.warn("当前没有用户登录！what happened????");
            return null;
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userManager.findUserByLoginName(userDetails.getUsername());
    }

    /**
     * 获取查询条件
     *
     * @param session
     * @param clazz
     * @param page
     * @return
     */
    protected MyBaseCondition getCond(HttpSession session, Class<?> clazz, MyBaseCondition page) {
        // 查询session中上次查询条件
        MyBaseCondition cond = (MyBaseCondition) session.getAttribute(clazz.getSimpleName());
        // 当page为null时，在session中找已存在的查询条件
        if (page == null && cond == null) {
            try {
                cond = (MyBaseCondition) clazz.newInstance();
                session.setAttribute(clazz.getSimpleName(), cond);
            } catch (Exception e) {
                logger.error("查询条件初始化错误:" + e.getMessage());
            }
            return cond;
        } else if (page == null) {
            return cond;
        }
        if (cond != null && page.isPageFlag()) {
            // 当点击页码查询时
            cond.setPageNum(page.getPageNum());
            cond.setRowSize(page.getRowSize());
        } else if (cond != null && StringUtils.isNotEmpty(page.getOrder())) {
            // 当点击标题排序时
            String[] orderStr = page.getOrder().split(",");
            MyOrder order = null;
            if (orderStr.length == 3) {
                order = new MyOrder(orderStr[0], orderStr[1].equals("asc"), orderStr[2].equals("chinese"));
            }
            if (cond.orderSize() == maxOrderSize) {
                cond.peekOrder();
            }
            cond.addOrder(order, true);
            cond.setPageNum(1);
        } else if (cond != null && (cond.getRowSize() != page.getRowSize())) {
            // 选择页面数据量时
            cond.setRowSize(page.getRowSize());
            cond.setPageNum(1);
        } else {
            cond = page;
        }
        session.setAttribute(clazz.getSimpleName(), cond);
        return cond;
    }

    /**
     * 返回页面添加结果消息
     *
     * @param model
     * @param info
     */
    protected void addSuccess(Model model, String info) {
        model.addAttribute("result", "success");
        model.addAttribute("resultMsg", info);
    }

    /**
     * 返回页面添加结果消息
     *
     * @param model
     * @param info
     */
    protected void addError(Model model, String info) {
        model.addAttribute("result", "error");
        model.addAttribute("resultMsg", info);
    }

    /**
     * 分页查询时将查询结果放入session
     *
     * @param model
     * @param page
     */
    protected void setPage(Model model, Pagination page) {
        model.addAttribute(pagnname, page);
    }

    protected void setDict(Model model, String dict) {
        model.addAttribute(this.dictname, dict);
    }

    /**
     * 根据资源设置页面菜单
     *
     * @param model
     * @param req
     */
    protected void setMenu(Model model, HttpServletRequest req) {
        String url = req.getRequestURI();
        Resource resource = resourceManager.findByUrl(url);
        List<Resource> link = resourceManager.findMenuLinkByCode(resource.getCode());
        if (resource == null) {
            logger.warn("未找到'" + url + "'对应资源");
            return;
        }
        model.addAttribute("currentMenu", resource);
        model.addAttribute("breadcrumb", link);
    }

    /**
     * 记录系统日志
     *
     * @param request
     * @param info
     */
    protected void addSysLog(HttpServletRequest request, String info) {
        addLog(request, LogType.SYSTEM, info);
    }

    /**
     * 记录日志
     *
     * @param request
     * @param type
     * @param info
     */
    protected void addLog(HttpServletRequest request, LogType type, String info) {
        User user = (User) WebUtils.getSessionAttribute(request, SessionProps.LOGIN_USER);
        String ip = (String) WebUtils.getSessionAttribute(request, SessionProps.LOGIN_IP);
        SystemLog log = new SystemLog();
        log.setUser(user);
        log.setIp(ip);
        log.setCreatetime(TimeUtils.currentDateTimeStr());
        log.setType(type);
        log.setInfo(info);
        systemLogManager.save(log);
    }
}
