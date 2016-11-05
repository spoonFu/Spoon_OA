/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.model;

import com.spoon.entity.acl.Dept;
import com.spoon.model.MyBaseModel;

import java.util.List;

/**
 * 机构模型
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2016/4/20
 */
public class DeptModel extends MyBaseModel<Dept> {

    /** 部门名称 */
    private String name;
    /** 部门描述 */
    private String desc;
    /** 部门层次码 */
    private String code;
    /** 子节点 */
    private List<DeptModel> children;

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

    public List<DeptModel> getChildren() {
        return children;
    }

    public void setChildren(List<DeptModel> children) {
        this.children = children;
    }
}
