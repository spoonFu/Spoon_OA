/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.web.adm;

import com.spoon.condition.adm.CheckworkCondition;
import com.spoon.dict.CommonDict;
import com.spoon.dict.SessionProps;
import com.spoon.entity.adm.Checkwork;
import com.spoon.service.adm.ICheckworkManager;
import com.spoon.utils.TimeUtils;
import com.spoon.web.MyBaseController;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 签到请求处理
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/12/6
 */
@Controller
public class CheckworkController extends MyBaseController {
    private final String basedir = "/adm/checkwork";
    @Resource
    private ICheckworkManager checkworkManager;

    @RequestMapping(value = "/adm/checkwork/sign", method = RequestMethod.GET)
    public String signGet(HttpSession session, HttpServletRequest req, Model model) {
        CheckworkCondition cond = new CheckworkCondition();
        cond.setDate(TimeUtils.currentDateStr());
        cond.setUserId(session.getAttribute(SessionProps.LOGIN_USERID).toString());
        List<Checkwork> list = checkworkManager.findByCond(cond);
        Checkwork cw = null;
        String time = TimeUtils.currentTimeStr();
        if (CollectionUtils.isEmpty(list)) {
            cw = new Checkwork();
            cw.setUser(getCurrentUser());
            cw.setSignIn(time);
            cw.setSignInIp(req.getRemoteHost());
            cw.setDate(TimeUtils.currentDateStr());
            checkworkManager.save(cw);
        } else {
            cw = list.get(0);
            cw.setSignOutIp(req.getRemoteHost());
            cw.setSignOut(time);
            checkworkManager.update(cw);
        }
        String ip = req.getRemoteHost();
        model.addAttribute("returnStr", time+ CommonDict.SEPERATOR+ip);
        return note;
    }

    @RequestMapping(value = "/adm/checkwork/manage", method = RequestMethod.GET)
    public String manageGet(HttpSession session, HttpServletRequest req, Model model) {
        CheckworkCondition cond = new CheckworkCondition();
        cond.setUserId(session.getAttribute(SessionProps.LOGIN_USERID).toString());
        cond.setDate(TimeUtils.toMonthStr());
        // 设置每月最大天数，防止翻页
        cond.setRowSize(32);
        setPage(model, checkworkManager.queryPage(cond));
        return basedir + "/manage";
    }

    @RequestMapping(value = "/adm/checkwork/manage", method = RequestMethod.POST)
    public String managePost() {
        return basedir + "/result";
    }
}
