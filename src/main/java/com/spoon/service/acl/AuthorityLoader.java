package com.spoon.service.acl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.spoon.dao.acl.IResourceDao;
import com.spoon.dao.acl.IRoleResourceDao;
import com.spoon.entity.acl.Resource;
import com.spoon.entity.acl.Role;
import com.spoon.service.MyBaseService;

/**
 * 权限初始化
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月5日 下午8:51:34
 */
@Service("authorityLoader")
public class AuthorityLoader extends MyBaseService implements IAuthorityLoader {
	@Autowired
	private IRoleResourceDao roleResourceDao;
	@Autowired
	private IResourceDao resourceDao;

	@Override
	public Map<String, Collection<ConfigAttribute>> loadResourceAuthority() {
		List<Resource> resources = resourceDao.getAll();
		Map<String, Collection<ConfigAttribute>> urlMap = new ConcurrentHashMap<String, Collection<ConfigAttribute>>();
		for (Resource resource : resources) {
			List<Role> roles = roleResourceDao.listRole(resource.getId());
			if (CollectionUtils.isEmpty(roles))
				continue;
			Collection<ConfigAttribute> cas = new ArrayList<ConfigAttribute>();
			for (Role role : roles) {
				// 资源对应的角色权限
				ConfigAttribute ca = new SecurityConfig(role.getAuthority());
				cas.add(ca);
			}
			urlMap.put(resource.getUrl(), cas);
		}
		return urlMap;
	}

	@Override
	public Map<String, String> loadJSPAuthorities() {
		List<Resource> resources = resourceDao.getAll();
		Map<String, String> jspAuthorities = new ConcurrentHashMap<String, String>();
		for (Resource resource : resources) {
			List<Role> roles = roleResourceDao.listRole(resource.getId());
			if (CollectionUtils.isEmpty(roles))
				continue;
			List<String> rolenames = new ArrayList<String>();
			for (Role role : roles) {
				// 资源对应的角色权限
				rolenames.add(role.getName());
			}
			jspAuthorities.put(resource.getName(), StringUtils.join(rolenames, ","));
		}
		return jspAuthorities;
	}
}
