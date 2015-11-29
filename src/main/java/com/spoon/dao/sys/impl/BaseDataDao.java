/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.dao.sys.impl;

import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.dao.sys.IBaseDataDao;
import com.spoon.entity.sys.BaseData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 基础数据
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
@Repository("baseDataDao")
public class BaseDataDao extends MyBaseDaoImpl<BaseData> implements IBaseDataDao {
    @Override
    public List<BaseData> findByGid(String gid, boolean flag) {
        String param = flag ? gid + ".%" : gid;
        String hql = "from " + this.clazz.getName() + " where gid like ?";
        return (List<BaseData>) queryList(hql, param);
    }
}
