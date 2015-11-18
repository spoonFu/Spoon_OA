package com.spoon.service.acl;

import com.spoon.dao.acl.IResourceDao;
import com.spoon.entity.acl.Resource;
import com.spoon.service.MyBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类说明
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月9日 下午6:40:59
 */
@Service("resourceManager")
public class ResourceManagerImpl extends MyBaseService implements IResourceManager {
	@Autowired
	private IResourceDao resourceDao;

	private Map<String, Resource> urlMap;

	@PostConstruct
	public void init() {
		urlMap = new ConcurrentHashMap<String, Resource>();
		List<Resource> res = this.getAll();
		for (Resource rs : res) {
			urlMap.put(rs.getUrl(), rs);
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
			if (url.contains(key))
				return urlMap.get(key);
		}
		return null;
	}

}
