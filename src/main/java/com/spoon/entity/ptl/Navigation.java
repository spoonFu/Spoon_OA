package com.spoon.entity.ptl;

import com.spoon.entity.MyBaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * 类说明
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年12月28日 下午2:42:12
 */
@Entity
@Table(name = "cont_navigation")
public class Navigation extends MyBaseEntity {
    private static final long serialVersionUID = 6706526455267075443L;

    private String name;
    private String url;
    private String code;

    private List<Navigation> navs;

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "level_code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Transient
    public List<Navigation> getNavs() {
        return navs;
    }

    public void setNavs(List<Navigation> navs) {
        this.navs = navs;
    }

    public Navigation() {
    }

    public Navigation(String id) {
        this.id = id;
    }
}
