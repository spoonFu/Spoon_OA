/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.service.msg.impl;

import com.spoon.condition.msg.ImCondition;
import com.spoon.dao.msg.IImDao;
import com.spoon.entity.msg.Im;
import com.spoon.service.MyBaseService;
import com.spoon.service.msg.IImManager;
import com.spoon.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 即时消息管理
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
@Service("imManager")
public class ImManagerImpl extends MyBaseService implements IImManager {
    @Autowired
    private IImDao imDao;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Throwable.class})
    @Override
    public String save(Im im) {
        im.setCreatetime(TimeUtils.currentDateTimeStr());
        im.setId(getUUId());
        return this.imDao.save(im).toString();
    }

    public List<Im> findByCond(ImCondition cond) {
        return this.imDao.findByCond(cond);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Throwable.class})
    @Override
    public void readMsgByCond(ImCondition cond) {
        this.imDao.readMsgByCond(cond);
    }
}
