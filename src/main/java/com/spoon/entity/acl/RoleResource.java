package com.spoon.entity.acl;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.spoon.entity.MyBaseEntity;

/**
 * 角色-资源 对应关系
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年11月5日 下午8:53:18
 */
@Entity
@Table(name = "acl_role_resource")
public class RoleResource extends MyBaseEntity {
    private static final long serialVersionUID = -5514193278398351227L;

    private Role role;
    private Resource resource;

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToOne
    @JoinColumn(name = "resource_id")
    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
