package com.spoon.web;

import com.spoon.model.SessionProps;
import com.spoon.service.security.MySessionListener;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登陆处理类
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014-7-15 下午10:04:09
 */
@Controller
public class LoginController extends MyBaseController {

    @RequestMapping(value = "/login.service")
    public String welcome(HttpSession session, HttpServletRequest req, Model model) {
        if (session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION) == null) {
            return "/login";
        }
        // 如果登陆失败，则获取失败具体信息
        // 获取security放入session中的登陆错误对象
        AuthenticationException exception = (AuthenticationException) session
                .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
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
    public String manage(HttpServletRequest req, Model model) {
        model.addAttribute(SessionProps.SESSION_COUNT, MySessionListener.getCount());
        return "/index";
    }

    @RequestMapping(value = "/noright.service")
    public String noright(HttpServletRequest req, Model model) {
        return "/noright";
    }
}
