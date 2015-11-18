package com.spoon.condition.ptl;

import com.spoon.condition.MyBaseCondition;

/**
 * article查询条件
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月2日 下午8:18:04
 */
public class ArticleCondition extends MyBaseCondition {
	private String navid;
	private Boolean visible;

	public String getNavid() {
		return navid;
	}

	public void setNavid(String navid) {
		this.navid = navid;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

}
