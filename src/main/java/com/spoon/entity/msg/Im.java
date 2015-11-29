/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.entity.msg;

import com.spoon.entity.MyBaseEntity;
import com.spoon.entity.acl.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 即时消息
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
public class Im extends MyBaseEntity{
    private User fromUser;
    private User toUser;
    private String message;
    private boolean haveread;
    private String createtime;

    public String getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public boolean isHaveread() {
        return this.haveread;
    }

    public void setHaveread(boolean haveread) {
        this.haveread = haveread;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @ManyToOne
    @JoinColumn(name = "to_user")
    public User getToUser() {
        return this.toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    @ManyToOne
    @JoinColumn(name = "from_user")
    public User getFromUser() {
        return this.fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }
}
