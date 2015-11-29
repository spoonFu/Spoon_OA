/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.dao.msg;

import com.spoon.condition.msg.ImCondition;
import com.spoon.dao.IMyBaseDao;
import com.spoon.entity.msg.Im;

import java.util.List;

/**
 * 即时消息
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
public interface IImDao extends IMyBaseDao<Im> {
    List<Im> findByCond(ImCondition cond);

    /**
     * 将消息设为已读
     *
     * @param paramImCondition
     */
    void readMsgByCond(ImCondition cond);
}
