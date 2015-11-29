package com.spoon.dao.sys.impl;

import com.spoon.dao.sys.ISystemLogDao;
import org.springframework.stereotype.Repository;

import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.entity.sys.SystemLog;

/**
 * 系统日志
 *
 * @author:FuShaoxing
 * @date:2012-10-29 下午01:28:06
 * @version:1.0
 */
@Repository("systemLogDao")
public class SystemLogDaoImpl extends MyBaseDaoImpl<SystemLog> implements ISystemLogDao {

}
