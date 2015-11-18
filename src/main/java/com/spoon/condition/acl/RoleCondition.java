package com.spoon.condition.acl;

import com.spoon.condition.MyBaseCondition;

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
