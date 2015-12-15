/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.service.adm;

import com.spoon.condition.adm.CheckworkCondition;
import com.spoon.entity.adm.Checkwork;
import com.spoon.model.Pagination;

import java.util.List;

/**
 * 员工签入签出管理
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/12/5
 */
public interface ICheckworkManager {

    /**
     * 根据ID查询
     *
     * @param id 主键
     * @return
     */
    Checkwork findById(String id);

    /**
     * 分页查询
     *
     * @param cond 条件
     * @return 结果集合
     */
    Pagination queryPage(CheckworkCondition cond);

    /**
     * 根据条件查询
     *
     * @param cond 条件
     * @return
     */
    List<Checkwork> findByCond(CheckworkCondition cond);

    /**
     * 插入一条签入签出信息
     *
     * @param checkwork 签入签出信息
     * @return 插入之后的主键
     */
    String save(Checkwork checkwork);

    /**
     * 更新
     *
     * @param checkwork 要更新的实体
     */
    void update(Checkwork checkwork);
}
