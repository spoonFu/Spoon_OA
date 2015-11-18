package com.spoon.entity.ptl;

import com.spoon.entity.MyBaseEntity;
import com.spoon.entity.acl.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 类说明
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月2日 下午7:03:42
 */
@Entity
@Table(name = "cont_article")
public class Article extends MyBaseEntity {
    private static final long serialVersionUID = 3918465518669602184L;

    private Navigation nav;
    private String title;
    private String content;
    private User author;
    private String createtime;
    private String titlepic;
    private String minipic;
    private String tags;
    private String sign;
    private String summary;
    private boolean visible = true;
    private Integer viewcount = 0;

    @ManyToOne
    @JoinColumn(name = "navid")
    public Navigation getNav() {
        return nav;
    }

    public void setNav(Navigation nav) {
        this.nav = nav;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "author")
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Integer getViewcount() {
        return viewcount;
    }

    public void setViewcount(Integer viewcount) {
        this.viewcount = viewcount;
    }

    public String getTitlepic() {
        return titlepic;
    }

    public void setTitlepic(String titlepic) {
        this.titlepic = titlepic;
    }

    public String getMinipic() {
        return minipic;
    }

    public void setMinipic(String minipic) {
        this.minipic = minipic;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Article() {
    }

    public Article(String id, Navigation nav, String title, String createtime, String titlepic, String minipic, Integer viewcount, boolean visible) {
        this.id = id;
        this.nav = nav;
        this.title = title;
        this.createtime = createtime;
        this.viewcount = viewcount;
        this.visible = visible;
    }
}
