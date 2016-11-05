/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.service.security;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session监听类
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月8日 下午4:20:52
 */
public class MySessionListener implements HttpSessionListener {
	private static long sessioncount = 0;

	/**
	 * 网站被访问，创建session时执行
	 */
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		sessioncount++;
	}

	/**
	 * session销毁时执行
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		sessioncount--;
	}

	public static long getCount() {
		return sessioncount;
	}
}