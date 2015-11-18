package com.spoon.entity.sys.enums;

/**
 * 日志类型
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年12月8日 下午10:25:24
 */
public enum LogType {
	SYSTEM("系统"), SIMPLE("页面内容");

	private String value;

	public String getValue() {
		return value;
	}

	LogType(String value) {
		this.value = value;
	}
}