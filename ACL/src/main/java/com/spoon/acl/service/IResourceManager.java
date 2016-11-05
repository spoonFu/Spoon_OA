/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.service;

import com.spoon.entity.acl.Resource;

import java.util.List;

/**
 * 类说明
 *
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月9日 下午6:39:27
 */
public interface IResourceManager {
    List<Resource> getAll();

    /**
     * 根据url查找对应资源对象
     *
     * @param url
     * @return
     */
    Resource findByUrl(String url);

    /**
     * 根据用户id查询导航
     *
     * @param userId 用户id
     * @return
     */
    List<Resource> findMenuByUserId(String userId);

    /**
     * 根据层次码查询导航
     *
     * @param code
     * @return
     */
    List<Resource> findMenuLinkByCode(String code);
}
