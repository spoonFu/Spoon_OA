/*
 * Copyright (c) 2016 by FuShaoxing. All right reserved.
 */

package com.spoon.acl.service.impl;

import com.spoon.model.acl.DeptModel;
import com.spoon.service.MyBaseService;
import com.spoon.service.acl.IDeptManager;
import org.springframework.stereotype.Service;

/**
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2016/4/20
 */
@Service("deptManager")
public class DeptManagerImpl extends MyBaseService implements IDeptManager{

    @Override
    public DeptModel getTreeByDeptId(String id) {
        return null;
    }
}
