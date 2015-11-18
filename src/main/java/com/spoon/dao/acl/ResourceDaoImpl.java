package com.spoon.dao.acl;

import org.springframework.stereotype.Repository;

import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.entity.acl.Resource;

/**
 * 类说明
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月5日 下午9:12:30
 */
@Repository("resourceDao")
public class ResourceDaoImpl extends MyBaseDaoImpl<Resource> implements IResourceDao {

}
