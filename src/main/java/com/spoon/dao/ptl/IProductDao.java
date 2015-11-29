/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.dao.ptl;

import com.spoon.condition.ptl.ProductCondition;
import com.spoon.dao.IMyBaseDao;
import com.spoon.entity.ptl.Product;
import com.spoon.model.Pagination;

import java.util.List;

/**
 * 产品
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
public interface IProductDao extends IMyBaseDao<Product> {
    /**
     * 条件查询
     *
     * @param cond 条件
     * @return
     */
    public abstract List<Product> findByCond(ProductCondition cond);

    public abstract Pagination queryPage(ProductCondition cond);

    /**
     * 浏览数量+1
     *
     * @param count
     */
    public abstract void updCount(String count);
}
