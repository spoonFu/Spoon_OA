/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.model.adm;

import com.spoon.entity.adm.Checkwork;
import com.spoon.model.MyBaseModel;
import org.springframework.beans.BeanUtils;

/**
 * 签入签出模型
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/12/9
 */
public class CheckworkModel extends MyBaseModel<Checkwork> {

    /** 签到时间 */
    private String signIn;
    /** 签退时间 */
    private String signOut;
    /** 签到IP */
    private String signInIp;
    /** 签退IP */
    private String signOutIp;

    /** 迟到 */
    private boolean late;
    /** 早退 */
    private boolean early;

    public String getSignIn() {
        return signIn;
    }

    public void setSignIn(String signIn) {
        this.signIn = signIn;
    }

    public String getSignOut() {
        return signOut;
    }

    public void setSignOut(String signOut) {
        this.signOut = signOut;
    }

    public String getSignInIp() {
        return signInIp;
    }

    public void setSignInIp(String signInIp) {
        this.signInIp = signInIp;
    }

    public String getSignOutIp() {
        return signOutIp;
    }

    public void setSignOutIp(String signOutIp) {
        this.signOutIp = signOutIp;
    }

    public boolean isLate() {
        return late;
    }

    public void setLate(boolean late) {
        this.late = late;
    }

    public boolean isEarly() {
        return early;
    }

    public void setEarly(boolean early) {
        this.early = early;
    }

    /**
     * 从实体得到模型
     *
     * @param cw 实体对象
     * @return
     */
    public static CheckworkModel fromEntity(Checkwork cw) {
        CheckworkModel model = new CheckworkModel();
        model.signIn = cw.getSignIn();
        model.signOut = cw.getSignOut();
        model.signInIp = cw.getSignInIp();
        model.signOutIp = cw.getSignOutIp();
        return model;
    }
}
