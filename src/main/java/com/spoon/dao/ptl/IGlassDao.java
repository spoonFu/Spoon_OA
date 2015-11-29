/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.dao.ptl;

import com.spoon.condition.ptl.GlassCondition;
import com.spoon.dao.IMyBaseDao;
import com.spoon.entity.ptl.Glass;
import com.spoon.model.Pagination;

import java.util.List;

/**
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
public interface IGlassDao extends IMyBaseDao<Glass> {
    public abstract List<Glass> findByCond(GlassCondition cond);

    public abstract Pagination queryPage(GlassCondition cond);
}
