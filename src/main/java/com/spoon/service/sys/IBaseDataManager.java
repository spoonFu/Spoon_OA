/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.service.sys;

import com.spoon.entity.sys.BaseData;

import java.util.List;

/**
 * 基础数据
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
public interface IBaseDataManager {
    /**
     * 根据组id查询基础数据
     *
     * @param gid  组id
     * @param flag 是否查询所有
     * @return
     */
    List<BaseData> findByGid(String gid, boolean flag);

    /**
     * 根据主键查询基础数据
     *
     * @param id 主键
     * @return
     */
    BaseData findById(String id);
}
