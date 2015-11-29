/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.condition.ptl;

import com.spoon.condition.MyBaseCondition;

/**
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
public class ProductCondition extends MyBaseCondition {
    private String likestr;

    public String getLikestr() {
        return this.likestr;
    }

    public void setLikestr(String likestr) {
        this.likestr = likestr;
    }
}
