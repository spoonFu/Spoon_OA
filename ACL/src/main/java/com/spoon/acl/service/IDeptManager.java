/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.service;

import com.spoon.model.acl.DeptModel;

/**
 * 机构管理类
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2016/4/20
 */
public interface IDeptManager {
    /**
     * 根据机构id获取机构树
     *
     * @param id
     * @return
     */
    DeptModel getTreeByDeptId(String id);
}
