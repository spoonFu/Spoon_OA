package com.spoon.service.sys;

import com.spoon.dao.sys.ISystemLogDao;
import com.spoon.entity.sys.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统日志
 * @author:FuShaoxing
 * @date:2012-10-29 下午01:33:49
 * @version:1.0
 */
@Service("systemLogManager")
public class SystemLogManagerImpl implements ISystemLogManager {
	@Autowired
	private ISystemLogDao systemLogDao;

	@Override
	public void save(SystemLog log) {
		systemLogDao.save(log);
	}

	@Override
	public List<SystemLog> getAll() {
		return systemLogDao.getAll();
	}
}