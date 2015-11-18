package com.spoon.service.acl;

import java.util.List;

import com.spoon.entity.acl.Resource;

/**
 * 类说明
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月9日 下午6:39:27
 */
public interface IResourceManager {
	public List<Resource> getAll();

	/**
	 * 根据url查找对应资源对象
	 * @param url
	 * @return
	 */
	public Resource findByUrl(String url);
}
