/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.condition;

import com.spoon.base.condition.MyBaseCondition;

/**
 * 角色查询条件
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年12月6日 下午11:03:28
 */
public class RoleCondition extends MyBaseCondition {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
