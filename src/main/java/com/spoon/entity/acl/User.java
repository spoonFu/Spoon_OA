package com.spoon.entity.acl;

import com.spoon.entity.MyBaseEntity;
import com.spoon.utils.TimeUtils;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户
 *
 * @Author FuShaoxing(xinyu2010@126.com)
 * @Data 2015-11-28
 */
@Entity
@Table(name = "acl_user")
public class User extends MyBaseEntity implements UserDetails {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String name;
    private String icon;
    private boolean male;
    private String phone;
    private String email;
    private String lastlogin;
    private String createtime;
    private String deadline;
    private boolean locked = false;
    private boolean enabled = true;
    private Dept dept;
    private Collection<GrantedAuthority> authorities;
    private String[] roleIds;
    private List<Role> roles;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    public Dept getDept() {
        return this.dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Transient
    public String[] getRoleIds() {
        return this.roleIds;
    }

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }

    @Transient
    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLocked() {
        return this.locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public boolean isMale() {
        return this.male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastlogin() {
        return this.lastlogin;
    }

    public void setLastlogin(String lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDeadline() {
        return this.deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String toString() {
        return "username��" + this.name + ",userstatus��" + this.enabled;
    }

    @Transient
    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getUsername() {
        return this.username;
    }

    @Transient
    public boolean isAccountNonExpired() {
        if (this.deadline == null) {
            return true;
        }
        return new Date().before(TimeUtils.getCalendar(this.deadline).getTime());
    }

    @Transient
    public boolean isAccountNonLocked() {
        return !this.locked;
    }

    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public User() {
    }

    public User(String id) {
        this.id = id;
    }

    public User(String id, String name, String icon) {
        this.id = id;
        this.name = name;
        this.icon = icon;
    }
}
