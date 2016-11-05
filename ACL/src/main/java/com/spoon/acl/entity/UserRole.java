/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.entity;

import com.spoon.entity.MyBaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 用户-角色
 * @author:FuShaoxing
 * @date:2012-10-25 上午09:24:45
 * @version:1.0
 */
@Entity
@Table(name = "acl_user_role")
public class UserRole extends MyBaseEntity {
	private static final long serialVersionUID = 1L;

	private User user;
	private Role role;

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "role_id")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		String id = "数据id:"+this.getId();
		String s = "用户-角色:"+user.getName()+"-"+role.getName();
		return id+";"+s;
	}
}
