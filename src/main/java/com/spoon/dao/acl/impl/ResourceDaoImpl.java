package com.spoon.dao.acl.impl;

import com.spoon.dao.acl.IResourceDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.entity.acl.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明
 *
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月5日 下午9:12:30
 */
@Repository("resourceDao")
public class ResourceDaoImpl extends MyBaseDaoImpl<Resource> implements IResourceDao {
    @Override
    public List<Resource> findMenuLinkByCode(String code) {
        if ((StringUtils.isEmpty(code)) || (code.length() < 3)) {
            return new ArrayList();
        }
        return queryNamedList("resourceDao.findMenuLinkByCode", code);
    }

    @Override
    public List<Resource> findMenuByUserId(String userId) {
        return queryNamedList("resourceDao.findMenuByUserId", userId);
    }
}
