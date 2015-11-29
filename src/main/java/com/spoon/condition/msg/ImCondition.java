/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.condition.msg;

import com.spoon.condition.MyBaseCondition;
import com.spoon.entity.acl.User;

/**
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
public class ImCondition extends MyBaseCondition {
    private User fromUser;
    private User toUser;
    private Boolean haveread;

    public User getFromUser() {
        return this.fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return this.toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public Boolean getHaveread() {
        return this.haveread;
    }

    public void setHaveread(Boolean haveread) {
        this.haveread = haveread;
    }
}
