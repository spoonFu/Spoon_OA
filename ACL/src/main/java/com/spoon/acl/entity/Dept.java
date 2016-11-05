/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.entity;

import com.spoon.entity.MyBaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 部门实体
 *
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年12月7日 下午8:11:35
 */
@Entity
@Table(name = "acl_dept")
public class Dept extends MyBaseEntity {
    private static final long serialVersionUID = 5650986835795776899L;
    /** 部门名称 */
    private String name;
    /** 部门描述 */
    private String desc;
    /** 部门层次码 */
    private String code;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
