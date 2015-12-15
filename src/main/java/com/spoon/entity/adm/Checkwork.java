/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.entity.adm;

import com.spoon.entity.MyBaseEntity;
import com.spoon.entity.acl.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 员工签到签退表
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/12/5
 */
@Entity
@Table(name = "adm_checkwork")
public class Checkwork extends MyBaseEntity {
    private User user;
    private String signIn;
    private String signInIp;
    private String signOut;
    private String signOutIp;

    @JoinColumn(name = "sign_in_ip")
    public String getSignInIp() {
        return signInIp;
    }

    public void setSignInIp(String signInIp) {
        this.signInIp = signInIp;
    }

    @JoinColumn(name = "sign_out_ip")
    public String getSignOutIp() {
        return signOutIp;
    }

    public void setSignOutIp(String signOutIp) {
        this.signOutIp = signOutIp;
    }

    private String date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @JoinColumn(name = "sign_in")
    public String getSignIn() {
        return signIn;
    }

    public void setSignIn(String signIn) {
        this.signIn = signIn;
    }

    @JoinColumn(name = "sign_out")
    public String getSignOut() {
        return signOut;
    }

    public void setSignOut(String signOut) {
        this.signOut = signOut;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
