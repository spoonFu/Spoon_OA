/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.tag;

import com.spoon.utils.Dictionary;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

/**
 * 自定义标签
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
public class DictTag extends RequestContextAwareTag {
    private String dictname;
    private String key;

    protected int doStartTagInternal() throws Exception {
        Dictionary dictionary = (Dictionary) getRequestContext().getWebApplicationContext().getBean("dictionary");
        JspWriter out = pageContext.getOut();
        try {
            out.write(dictionary.get(this.dictname, this.key));
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return EVAL_BODY_INCLUDE;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDictname() {
        return this.dictname;
    }

    public void setDictname(String dictname) {
        this.dictname = dictname;
    }
}
