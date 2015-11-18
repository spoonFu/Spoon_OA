package com.spoon.entity.acl;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.spoon.entity.MyBaseEntity;

/**
 * 角色
 * 
 * @author:FuShaoxing
 * @date:2012-10-25 上午09:23:28
 * @version:1.0
 */
@Entity
@Table(name = "acl_role")
public class Role extends MyBaseEntity {
	private static final long serialVersionUID = 1L;

	/** 用户角色名称 **/
	private String name;
	/** 所属部门 **/
	private Dept dept;
	/** 角色标识 **/
	private String authority;
	/** 描述 **/
	private String desc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "dept_id")
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Role() {
	}

	public Role(String id) {
		this.id = id;
	}
}
