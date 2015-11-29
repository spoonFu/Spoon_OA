package com.spoon.entity.acl;

import com.spoon.entity.MyBaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * 资源菜单实体类
 *
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月5日 下午8:58:54
 */
@Entity
@Table(name = "acl_resource")
public class Resource extends MyBaseEntity {
    private static final long serialVersionUID = 6121272524500533861L;
    /** 资源名称 * */
    private String name;
    /** 访问链接 * */
    private String url;
    /** 是否为导航 */
    private Boolean isnav = Boolean.valueOf(false);
    /** 描述 */
    private String desc;
    /** 层次吗 */
    private String code;
    /** 子节点 */
    private List<Resource> children;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getIsnav() {
        return this.isnav;
    }

    public void setIsnav(Boolean isnav) {
        this.isnav = isnav;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Transient
    public List<Resource> getChildren() {
        return this.children;
    }

    public void setChildren(List<Resource> children) {
        this.children = children;
    }
}
