package com.spoon.service.acl.impl;

import com.spoon.dao.acl.IResourceDao;
import com.spoon.entity.acl.Resource;
import com.spoon.service.MyBaseService;
import com.spoon.service.acl.IResourceManager;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类说明
 *
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月9日 下午6:40:59
 */
@Service("resourceManager")
public class ResourceManagerImpl extends MyBaseService implements IResourceManager {
    @Autowired
    private IResourceDao resourceDao;
    /** 缓存资源 */
    private Map<String, Resource> urlMap;

    @PostConstruct
    public void init() {
        urlMap = new ConcurrentHashMap<String, Resource>();
        List<Resource> res = this.getAll();
        for (Resource rs : res) {
            if (!StringUtils.isEmpty(rs.getUrl())) {
                this.urlMap.put(rs.getUrl(), rs);
            }
        }
        logger.info("将url资源加载至内存");
    }

    @Override
    public List<Resource> getAll() {
        return resourceDao.getAll();
    }

    @Override
    public Resource findByUrl(String url) {
        Set<String> keys = urlMap.keySet();
        for (String key : keys) {
            if (url.contains(key)) {
                return urlMap.get(key);
            }
        }
        return null;
    }

    @Override
    public List<Resource> findMenuByUserId(String userId) {
        List<Resource> menuList = this.resourceDao.findMenuByUserId(userId);
        List<Resource> retList = new ArrayList();

        Map<String, Resource> tempMap = new ConcurrentHashMap();
        for (Resource re : menuList) {
            tempMap.put(re.getCode(), re);
            if (re.getCode().length() == 3) {
                retList.add(re);
            } else {
                String parCode = re.getCode().substring(0, re.getCode().length() - 3);
                Resource parRe = (Resource) tempMap.get(parCode);
                if (parRe == null) {
                    break;
                }
                List<Resource> children = parRe.getChildren();
                children = children == null ? new ArrayList() : children;
                children.add(re);
                parRe.setChildren(children);
            }
        }
        menuList.clear();
        tempMap.clear();
        return retList;
    }

    @Override
    public List<Resource> findMenuLinkByCode(String code) {
        return this.resourceDao.findMenuLinkByCode(code);
    }
}
