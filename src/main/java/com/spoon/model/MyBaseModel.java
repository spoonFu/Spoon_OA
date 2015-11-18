package com.spoon.model;

import org.springframework.beans.BeanUtils;

import com.spoon.entity.MyBaseEntity;
import com.spoon.entity.acl.User;
import com.spoon.utils.JsonBinder;

/**
 * model模型基类
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月9日 下午6:10:13
 */
public class MyBaseModel<T extends MyBaseEntity> {
	/** 记录当前用户 **/
	private User currentUser;
	private String id;

	/**
	 * 将对象转化为json字符串
	 * @return
	 */
	public String toJson() {
		JsonBinder binder = JsonBinder.buildNormalBinder();
		binder.setDateFormat("yyyy-MM-dd hh:mm:ss");
		return binder.toJson(this);
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public T createEntity(T entity) {
		BeanUtils.copyProperties(this, entity);
		return entity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
