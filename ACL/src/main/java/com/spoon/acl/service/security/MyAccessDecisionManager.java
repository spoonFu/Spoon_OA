/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.service.security;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 资源访问决策类
 * 
 * @author:FuShaoxing
 * @date:2012-10-30 下午01:08:20
 * @version:1.0
 */
@Service("myAccessDecisionManager")
public class MyAccessDecisionManager implements AccessDecisionManager {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (CollectionUtils.isEmpty(configAttributes)) {
			String url = ((FilterInvocation) object).getRequestUrl();
			logger.info(url+" need no right!");
			return;
		}
		StringBuffer right = new StringBuffer("The current user:"+authentication.getName()+";rights:");
		List<String> ss = new ArrayList<String>();
		for (GrantedAuthority ga : authentication.getAuthorities()) {
			ss.add(ga.getAuthority());
			for (ConfigAttribute ca : configAttributes) {
				if (ga.getAuthority().equals(ca.getAttribute())) {
					logger.info("Pass the AccessDecision!You have the "+ca.getAttribute()+" right!");
					return;
				}
			}
		}
		right.append(StringUtils.join(ss.toArray(), ",")+";");
		logger.info(right.toString());
		throw new AccessDeniedException("You have no right!");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
