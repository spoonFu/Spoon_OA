/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.dao.impl;

import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.dao.acl.IDeptDao;
import com.spoon.entity.acl.Dept;
import org.springframework.stereotype.Repository;

/**
 * 机构DAO
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2016/4/20
 */
@Repository("deptDao")
public class DeptDaoImpl extends MyBaseDaoImpl<Dept> implements IDeptDao {
}
