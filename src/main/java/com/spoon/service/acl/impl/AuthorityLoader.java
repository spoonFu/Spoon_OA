package com.spoon.service.acl.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.spoon.service.acl.IAuthorityLoader;
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
 *
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
        List<Resource> resources = this.resourceDao.getAll();
        Map<String, Collection<ConfigAttribute>> urlMap = new ConcurrentHashMap();
        for (Resource resource : resources) {
            if (!StringUtils.isEmpty(resource.getUrl())) {
                List<Role> roles = this.roleResourceDao.findRoleByResourceId(resource.getId());
                if (!CollectionUtils.isEmpty(roles)) {
                    Collection<ConfigAttribute> cas = new ArrayList();
                    for (Role role : roles) {
                        ConfigAttribute ca = new SecurityConfig(role.getId());
                        cas.add(ca);
                    }
                    urlMap.put(resource.getUrl(), cas);
                }
            }
        }
        return urlMap;
    }

    @Override
    public Map<String, String> loadJSPAuthorities() {
        List<Resource> resources = this.resourceDao.getAll();
        Map<String, String> jspAuthorities = new ConcurrentHashMap();
        for (Resource resource : resources) {
            List<Role> roles = this.roleResourceDao.findRoleByResourceId(resource.getId());
            if (!CollectionUtils.isEmpty(roles)) {
                List<String> rolenames = new ArrayList();
                for (Role role : roles) {
                    rolenames.add(role.getName());
                }
                jspAuthorities.put(resource.getName(), StringUtils.join(rolenames, ","));
            }
        }
        return jspAuthorities;
    }
}
