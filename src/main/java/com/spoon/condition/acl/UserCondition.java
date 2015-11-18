package com.spoon.condition.acl;

import com.spoon.condition.MyBaseCondition;

/**
 * 用户查询
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月23日 下午10:19:27
 */
public class UserCondition extends MyBaseCondition {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
