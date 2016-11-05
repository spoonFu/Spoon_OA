/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.service.msg;

import com.spoon.condition.msg.ImCondition;
import com.spoon.entity.msg.Im;

import java.util.List;

/**
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
public interface IImManager {
    String save(Im paramIm);

    List<Im> findByCond(ImCondition cond);

    /**
     *
     * @param cond
     */
    void readMsgByCond(ImCondition cond);
}
