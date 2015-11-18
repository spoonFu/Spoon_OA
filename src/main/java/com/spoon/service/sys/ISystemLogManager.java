package com.spoon.service.sys;

import com.spoon.entity.sys.SystemLog;

import java.util.List;

/**
 * 系统日志
 * @author:FuShaoxing
 * @date:2012-10-29 下午01:30:24
 * @version:1.0
 */
public interface ISystemLogManager {
	public void save(SystemLog log);

	public List<SystemLog> getAll();
}
