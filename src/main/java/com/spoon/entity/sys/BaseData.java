/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.entity.sys;

import com.spoon.entity.MyBaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 基础数据
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
@Entity
@Table(name = "sys_basedata")
public class BaseData extends MyBaseEntity {
    private String name;
    private String value;
    private String sign;
    private String gid;
    private BaseData parent;
    private String desc;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getGid() {
        return this.gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    @ManyToOne
    @JoinColumn(name = "par_id")
    public BaseData getParent() {
        return this.parent;
    }

    public void setParent(BaseData parent) {
        this.parent = parent;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
