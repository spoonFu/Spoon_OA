package com.spoon.service.security;

import com.spoon.service.MyBaseService;
import com.spoon.service.acl.IAuthorityLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * 用户访问资源权限验证
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月5日 下午8:48:34
 */
@Service("mySecurityMetadataSource")
public class MySecurityMetadataSource extends MyBaseService implements FilterInvocationSecurityMetadataSource {
	@Autowired
	private IAuthorityLoader authorityLoader;

	public static Map<String, Collection<ConfigAttribute>> urlMap = null;

	@PostConstruct
	public void loadResourceAuthority() {
		urlMap = authorityLoader.loadResourceAuthority();
		if (CollectionUtils.isEmpty(urlMap))
			logger.warn("resourcemap is null");
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		// 从参数中获取请求的url
		String url = ((FilterInvocation) object).getRequestUrl();
		Set<String> keys = urlMap.keySet();
		for (String key : keys) {
			if (url.contains(key))
				return urlMap.get(key);
		}
		if (url.endsWith(".do"))
			logger.warn("Can`t find authorities of the URL('"+url+"')");
		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
