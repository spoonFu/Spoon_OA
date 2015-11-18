package com.spoon.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 服务基类
 * 
 * @author:FuShaoxing
 * @date:2012-10-25 上午09:13:52
 * @version:1.0
 */
public class MyBaseService {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 获取随机唯一字符串
	 * @return
	 */
	protected String getUUId() {
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "");
	}
}
