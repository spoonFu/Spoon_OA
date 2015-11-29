/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.service.ptl;

import com.spoon.condition.ptl.GlassCondition;
import com.spoon.entity.ptl.Glass;
import com.spoon.model.Pagination;

import java.util.List;

/**
 * 眼镜
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
public interface IGlassManager {
    Glass findById(String paramString);

    List<Glass> getAll();

    Glass save(Glass paramGlass);

    List<Glass> findByCond(GlassCondition paramGlassCondition);

    Pagination queryPage(GlassCondition paramGlassCondition);
}
