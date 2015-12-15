/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.service.adm.impl;

import com.spoon.condition.adm.CheckworkCondition;
import com.spoon.dao.adm.ICheckworkDao;
import com.spoon.entity.adm.Checkwork;
import com.spoon.model.Pagination;
import com.spoon.service.MyBaseService;
import com.spoon.service.adm.ICheckworkManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 员工签入签出管理
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/12/5
 */
@Service("checkworkManager")
public class CheckworkManagerImpl extends MyBaseService implements ICheckworkManager {
    @Resource
    private ICheckworkDao checkworkDao;

    @Override
    public Checkwork findById(String id) {
        return checkworkDao.findById(id);
    }

    @Override
    public Pagination queryPage(CheckworkCondition cond) {
        return checkworkDao.queryPage(cond);
    }

    @Override
    public List<Checkwork> findByCond(CheckworkCondition cond) {
        return checkworkDao.findByCond(cond);
    }

    @Transactional
    @Override
    public String save(Checkwork checkwork) {
        return checkworkDao.save(checkwork).toString();
    }

    @Transactional
    @Override
    public void update(Checkwork checkwork) {
        checkworkDao.update(checkwork);
    }
}
