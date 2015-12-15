/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.condition.adm;

import com.spoon.condition.MyBaseCondition;

/**
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/12/5
 */
public class CheckworkCondition extends MyBaseCondition {
    /** 日期-年月 */
    private String date;
    /** 用户 */
    private String userId;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
