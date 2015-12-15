/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.dao.adm;

import com.spoon.condition.adm.CheckworkCondition;
import com.spoon.dao.IMyBaseDao;
import com.spoon.entity.adm.Checkwork;
import com.spoon.model.Pagination;

import java.util.List;

/**
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/12/5
 */
public interface ICheckworkDao extends IMyBaseDao<Checkwork> {

    /**
     * 分页查询
     *
     * @param cond 条件
     * @return
     */
    Pagination queryPage(CheckworkCondition cond);

    /**
     * 根据条件查询列表
     *
     * @param cond 条件
     * @return 结果集
     */
    List<Checkwork> findByCond(CheckworkCondition cond);
}
