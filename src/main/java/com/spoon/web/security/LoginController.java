package com.spoon.web.security;

import com.spoon.condition.adm.CheckworkCondition;
import com.spoon.dict.CommonDict;
import com.spoon.dict.SessionProps;
import com.spoon.entity.adm.Checkwork;
import com.spoon.model.adm.CheckworkModel;
import com.spoon.service.adm.ICheckworkManager;
import com.spoon.service.security.MySessionListener;
import com.spoon.service.sys.IBaseDataManager;
import com.spoon.utils.TimeUtils;
import com.spoon.web.MyBaseController;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 登陆处理类
 *
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014-7-15 下午10:04:09
 */
@Controller
public class LoginController extends MyBaseController {
    @Resource
    private IBaseDataManager baseDataManager;
    @Resource
    private ICheckworkManager checkworkManager;

    @RequestMapping(value = "/login.service")
    public String welcome(HttpSession session, HttpServletRequest req, Model model) {
        if (session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION) == null) {
            return "/login";
        }
        // 如果登陆失败，则获取失败具体信息
        // 获取security放入session中的登陆错误对象
        AuthenticationException exception = (AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        String message = exception.getMessage();
        if (exception instanceof UsernameNotFoundException) {
            message = "用户不存在!";
        } else if (exception instanceof BadCredentialsException) {
            message = "账号或密码错误!";
        } else if (exception instanceof LockedException) {
            message = "此账户已被锁定!";
        } else if (exception instanceof AccountExpiredException) {
            message = "此账户已超过使用期限!";
        } else if (exception instanceof DisabledException) {
            message = "此账户不可用!";
        } else if (exception instanceof SessionAuthenticationException && message.contains("Maximum sessions")) {
            message = "此账户在线，禁止重复登录！";
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        model.addAttribute(SessionProps.ERROR_MSG, message);
        return "/login";
    }

    @RequestMapping(value = "/logout.service")
    public String logout(HttpServletRequest req, Model model) {
        return "/login";
    }

    @RequestMapping(value = "/welcome.service")
    public String manage(HttpSession session, HttpServletRequest req, Model model) {
        model.addAttribute(SessionProps.SESSION_COUNT, MySessionListener.getCount());
        String startTime = baseDataManager.findById(CommonDict.CHECK_WORK_START).getValue();
        String endTime = baseDataManager.findById(CommonDict.CHECK_WORK_END).getValue();
        model.addAttribute("StartTime", startTime);
        model.addAttribute("EndTime", endTime);
        CheckworkCondition cond = new CheckworkCondition();
        cond.setUserId(session.getAttribute(SessionProps.LOGIN_USERID).toString());
        cond.setDate(TimeUtils.currentDateStr());
        List<Checkwork> list = checkworkManager.findByCond(cond);
        if (CollectionUtils.isEmpty(list)) {
            return "/index";
        }
        CheckworkModel cwModel = CheckworkModel.fromEntity(list.get(0));
        try {
            if (StringUtils.isNotEmpty(cwModel.getSignIn())) {
                Date start1 = TimeUtils.TIME_FORMAT.parse(startTime);
                Date start2 = TimeUtils.TIME_FORMAT.parse(cwModel.getSignIn());
                cwModel.setLate(start2.compareTo(start1) > -1);
            }
            if (StringUtils.isNotEmpty(cwModel.getSignOut())) {
                Date end1 = TimeUtils.TIME_FORMAT.parse(endTime);
                Date end2 = TimeUtils.TIME_FORMAT.parse(cwModel.getSignOut());
                cwModel.setEarly(end1.compareTo(end2) > -1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.addAttribute("cw", cwModel);
        return "/index";
    }

    @RequestMapping(value = "/noright.service")
    public String noright(HttpServletRequest req, Model model) {
        return "/noright";
    }

}
