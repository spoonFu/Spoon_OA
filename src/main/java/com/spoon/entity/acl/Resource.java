package com.spoon.entity.acl;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.spoon.entity.MyBaseEntity;

/**
 * 资源菜单实体类
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月5日 下午8:58:54
 */
@Entity
@Table(name = "acl_resource")
public class Resource extends MyBaseEntity {
	private static final long serialVersionUID = 6121272524500533861L;
	/** 资源名称 **/
	private String name;
	/** 访问链接 **/
	private String url;
	/** 同级菜单中的顺序 **/
	private Integer order;
	/** 上级菜单id **/
	private String menuid;
	/** 描述 **/
	private String desc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
