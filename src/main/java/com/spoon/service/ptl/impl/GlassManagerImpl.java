/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.service.ptl.impl;

import com.spoon.condition.ptl.GlassCondition;
import com.spoon.dao.ptl.IGlassDao;
import com.spoon.entity.ptl.Glass;
import com.spoon.model.Pagination;
import com.spoon.service.MyBaseService;
import com.spoon.service.ptl.IGlassManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 眼镜管理
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
@Service("glassManager")
public class GlassManagerImpl extends MyBaseService implements IGlassManager {
    @Autowired
    private IGlassDao glassDao;

    @Override
    public Glass findById(String id) {
        return (Glass) this.glassDao.findById(id);
    }

    @Override
    public List<Glass> getAll() {
        return this.glassDao.getAll();
    }

    @Override
    @Transactional
    public Glass save(Glass glass) {
        String id = this.glassDao.save(glass).toString();
        return findById(id);
    }

    @Override
    public List<Glass> findByCond(GlassCondition cond) {
        return this.glassDao.findByCond(cond);
    }

    @Override
    public Pagination queryPage(GlassCondition cond) {
        return this.glassDao.queryPage(cond);
    }
}
