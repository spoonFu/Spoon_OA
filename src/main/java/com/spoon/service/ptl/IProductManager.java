/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.service.ptl;

import com.spoon.condition.ptl.ProductCondition;
import com.spoon.entity.ptl.Product;
import com.spoon.model.Pagination;

import java.util.List;

/**
 * 产品
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
public interface IProductManager {
    Product findById(String paramString);

    List<Product> getAll();

    List<Product> findByCond(ProductCondition paramProductCondition);

    Pagination queryPage(ProductCondition paramProductCondition);

    void updCount(String paramString);
}
