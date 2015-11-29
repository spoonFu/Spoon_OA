/*
 * Copyright (c) 2015 by FuShaoxing. All right reserved.
 */

package com.spoon.entity.ptl;

import com.spoon.entity.MyBaseEntity;
import com.spoon.entity.acl.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 产品
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015/11/28
 */
@Entity
@Table(name = "ptl_product")
public class Product extends MyBaseEntity {
    private static final long serialVersionUID = 1L;
    private String name;
    private String pics;
    private String cover;
    private String desc;
    private String type;
    private String tags;
    private String createtime;
    private Integer viewcount = Integer.valueOf(0);
    private User author;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return this.cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getPics() {
        return this.pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public Integer getViewcount() {
        return this.viewcount;
    }

    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    @ManyToOne
    @JoinColumn(name = "author")
    public User getAuthor() {
        return this.author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}