package com.spoon.entity.ptl;

import com.spoon.entity.MyBaseEntity;
import com.spoon.entity.acl.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 类说明
 *
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月2日 下午7:03:42
 */
@Entity
@Table(name="ptl_article")
public class Article extends MyBaseEntity {
    private static final long serialVersionUID = 3918465518669602184L;
    private Navigation nav;
    private String title;
    private String content;
    private User author;
    private String tags;
    private String sign;
    private boolean visible = true;
    private Integer viewcount = Integer.valueOf(0);
    private String createtime;

    @ManyToOne
    @JoinColumn(name = "nav_id")
    public Navigation getNav() {
        return this.nav;
    }

    public void setNav(Navigation nav) {
        this.nav = nav;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getAuthor() {
        return this.author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Integer getViewcount() {
        return this.viewcount;
    }

    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getSign() {
        return this.sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Article() {
    }

    public Article(String id, Navigation nav, String title, String createtime, Integer viewcount, boolean visible) {
        this.id = id;
        this.nav = nav;
        this.title = title;
        this.createtime = createtime;
        this.viewcount = viewcount;
        this.visible = visible;
    }
}
