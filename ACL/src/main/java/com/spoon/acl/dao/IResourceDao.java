/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.dao;


import com.spoon.dao.IMyBaseDao;
import com.spoon.entity.acl.Resource;

import java.util.List;

/**
 * 资源
 *
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月5日 下午9:12:06
 */
public interface IResourceDao extends IMyBaseDao<Resource> {
    /**
     * 根据层次码查询导航
     *
     * @param code 层次码
     * @return
     */
    public abstract List<Resource> findMenuLinkByCode(String code);

    /**
     * 根据用户id查询导航菜单
     *
     * @param userId
     * @return
     */
    public abstract List<Resource> findMenuByUserId(String userId);
}
