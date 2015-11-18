package com.spoon.service.acl;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;

/**
 * 权限初始化
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月5日 下午9:11:32
 */
public interface IAuthorityLoader {
	/**
	 * 每个URL和所需的权限
	 * @return
	 */
	public Map<String, Collection<ConfigAttribute>> loadResourceAuthority();

	/**
	 * 页面中链接显示权限
	 * @return
	 */
	public Map<String, String> loadJSPAuthorities();
}
