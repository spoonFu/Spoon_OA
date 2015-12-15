/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.service.sys.impl;

import com.spoon.dao.sys.IBaseDataDao;
import com.spoon.entity.sys.BaseData;
import com.spoon.service.MyBaseService;
import com.spoon.service.sys.IBaseDataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基础数据
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
@Service("baseDataManager")
public class BaseDataManagerImpl extends MyBaseService implements IBaseDataManager {
    @Autowired
    private IBaseDataDao baseDataDao;

    @Override
    public List<BaseData> findByGid(String gid, boolean flag) {
        return baseDataDao.findByGid(gid, flag);
    }

    @Override
    public BaseData findById(String id) {
        return baseDataDao.findById(id);
    }


}
