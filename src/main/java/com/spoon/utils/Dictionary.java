/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.utils;

import com.spoon.entity.sys.BaseData;
import com.spoon.service.sys.IBaseDataManager;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库基础数据缓存
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
public class Dictionary {
    @Autowired
    private IBaseDataManager baseDataManager;
    private String commonDictName = "common";
    private Map<String, Map<String, String>> dictData;

    @PostConstruct
    private void init() {
        this.dictData = new HashMap();
        List<BaseData> list = this.baseDataManager.findByGid(this.commonDictName, true);
        addDictData(list);
    }

    private void addDictData(List<BaseData> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        for (BaseData data : list) {
            String dictName = data.getGid();
            Map<String, String> dict = (Map) this.dictData.get(dictName);
            dict = dict == null ? new HashMap() : dict;
            dict.put(data.getName(), data.getValue());
            this.dictData.put(dictName, dict);
        }
    }

    public String get(String dictName, String key) {
        Map<String, String> dict = (Map) this.dictData.get(dictName);
        if (dict == null) {
            List<BaseData> list = baseDataManager.findByGid(dictName, false);
            addDictData(list);
            dict = (Map) this.dictData.get(dictName);
        }
        if (dict == null) {
            return "{no dict}";
        }
        String val = (String) dict.get(key);

        val = val == null ? "{no prop}" : val;
        return val;
    }
}
