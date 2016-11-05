/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.base.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

/**
 * 实体类
 * 
 * @author:FuShaoxing
 * @date:2012-10-25 上午09:17:24
 * @version:1.0
 */
@MappedSuperclass
public class MyBaseEntity implements Serializable {
	private static final long serialVersionUID = -4680910961330952935L;

	protected String id;

	@Id
	/**定义了一种uuid的自定义主键生成策略，命名为generator**/
	@GenericGenerator(name = "generator", strategy = "uuid")
	/**jpa使用generator来生成主键**/
	@GeneratedValue(generator = "generator")
	public String getId() {
		if (id == null)
			return UUID.randomUUID().toString().replace("-", "");
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
