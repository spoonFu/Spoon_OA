/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 简单循环标签
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
public class ForTag extends TagSupport {
    private int i = 0;
    private int count;
    private String var;

    public int doStartTag() throws JspException {
        if ((this.count == 0) || (this.var == null)) {
            return SKIP_BODY;
        }
        if (this.i < this.count) {
            this.pageContext.setAttribute(var, Integer.valueOf(++i));
        }
        return EVAL_BODY_INCLUDE;
    }

    public int doAfterBody() throws JspException {
        if (this.i < this.count) {
            this.pageContext.setAttribute(var, Integer.valueOf(++i));
            return EVAL_BODY_AGAIN;
        }
        return SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        release();
        return EVAL_PAGE;
    }

    public void release() {
        this.i = 0;
        this.count = 0;
        this.var = null;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setVar(String var) {
        this.var = var;
    }
}
