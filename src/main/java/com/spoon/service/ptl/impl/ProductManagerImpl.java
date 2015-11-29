/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.service.ptl.impl;

import com.spoon.condition.ptl.ProductCondition;
import com.spoon.dao.ptl.IProductDao;
import com.spoon.entity.ptl.Product;
import com.spoon.model.Pagination;
import com.spoon.service.MyBaseService;
import com.spoon.service.ptl.IProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品管理
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
@Service("productManager")
public class ProductManagerImpl extends MyBaseService implements IProductManager {
    @Autowired
    private IProductDao productDao;

    public Product findById(String id) {
        return (Product) this.productDao.findById(id);
    }

    public List<Product> getAll() {
        return this.productDao.getAll();
    }

    public List<Product> findByCond(ProductCondition cond) {
        return this.productDao.findByCond(cond);
    }

    public Pagination queryPage(ProductCondition cond) {
        return this.productDao.queryPage(cond);
    }

    public void updCount(String id) {
        this.productDao.updCount(id);
    }
}
