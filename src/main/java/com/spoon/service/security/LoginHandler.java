package com.spoon.service.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.util.WebUtils;

import com.spoon.entity.acl.User;
import com.spoon.entity.sys.SystemLog;
import com.spoon.model.SessionProps;
import com.spoon.entity.sys.enums.LogType;
import com.spoon.service.acl.IUserManager;
import com.spoon.service.sys.ISystemLogManager;
import com.spoon.utils.TimeUtils;

/**
 * 登陆成功后记录登陆者ip、时间等信息
 * 
 * @author:FuShaoxing
 * @date:2012-10-29 下午01:11:19
 * @version:1.0
 */
@Service("loginHandler")
public class LoginHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	@Autowired
	private ISystemLogManager systemLogManager;
	@Autowired
	private IUserManager userManager;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	@Transactional
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		setAlwaysUseDefaultTargetUrl(true);
		setDefaultTargetUrl("/manage.service");
		String loginIp = request.getRemoteAddr();
		if ("0:0:0:0:0:0:0:1".equals(loginIp))
			loginIp = "127.0.0.1";
		SystemLog log = new SystemLog();
		log.setIp(loginIp);
		log.setTime(TimeUtils.currentString());

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		if (username==null) {
			throw new ServletException(username+"用户不存在!");
		}
		User user = userManager.findUserByLoginName(username);
		if (user==null) {
			throw new ServletException(username+"用户名或密码错误！");
		}
		setSessionProperties(request, user);

		log.setUser(user);
		log.setInfo("用户登陆成功");
		log.setType(LogType.SYSTEM);
		userManager.updateLastLogin(user.getId(), new Date());
		systemLogManager.save(log);
		logger.info("用户登陆成功："+user);
		super.onAuthenticationSuccess(request, response, authentication);
	}

	private void setSessionProperties(HttpServletRequest request, User loginUser) {
		Assert.notNull(loginUser);
		String ip = request.getRemoteHost();
		if ("0:0:0:0:0:0:0:1".equals(ip))
			ip = "127.0.0.1";
		WebUtils.setSessionAttribute(request, SessionProps.LOGIN_IP, ip);
		WebUtils.setSessionAttribute(request, SessionProps.LOGIN_TIME, TimeUtils.toTimeStr());
		WebUtils.setSessionAttribute(request, SessionProps.LOGIN_USER, loginUser);
		WebUtils.setSessionAttribute(request, SessionProps.LOGIN_NAME, loginUser.getName());
		logger.info("Set session attributes after login:{}", loginUser);
	}
}
