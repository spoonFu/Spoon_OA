package com.spoon.entity.acl;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spoon.entity.MyBaseEntity;
import com.spoon.utils.TimeUtils;

/**
 * 用户
 *
 * @author:FuShaoxing
 * @date:2012-10-25 上午09:21:57
 * @version:1.0
 */
@Entity
@Table(name = "acl_user")
public class User extends MyBaseEntity implements UserDetails {
    private static final long serialVersionUID = 1L;

    /** 登陆名 **/
    private String username;
    /** 密码 **/
    private String password;
    /** 姓名 **/
    private String name;
    /** 性别 **/
    private boolean man;
    /** 生日 **/
    private String birthday;
    /** 电话 **/
    private String phone;
    /** 邮箱 **/
    private String email;
    /** 最后一次登录时间 **/
    private String lastlogin;
    /** 创建时间 **/
    private String createtime;
    /** 截止时间 **/
    private String deadline;
    /** 锁定 **/
    private boolean locked = false;
    /** 可用 **/
    private boolean enabled = true;

    private Collection<GrantedAuthority> authorities;

    /** 角色id **/
    private String[] roleIds;
    /** 角色列表 **/
    private List<Role> roles;

    @Transient
    public String[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String[] roleIds) {
        this.roleIds = roleIds;
    }

    @Transient
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLocked() {
        return locked;
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

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(String lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "username：" + name + ",userstatus：" + enabled;
    }

    @Override
    @Transient
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        // 用户账户是否未过期
        if (deadline == null) return true;
        return new Date().before(TimeUtils.getCalendar(deadline).getTime());
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        // 用户凭证(密码)是否未过期
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
