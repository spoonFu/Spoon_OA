package com.spoon.entity.ptl;

import com.spoon.entity.MyBaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Calendar;
import java.util.Date;

/**
 * 客户留言
 *
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014-5-11 下午08:22:56
 */
@Entity
@Table(name="ptl_message")
public class Message extends MyBaseEntity {
    private static final long serialVersionUID = 1L;
    private String name;
    private String phone;
    private String email;
    private String message;
    /** 是否已读 */
    private boolean haveread = false;
    private String ip;
    private String position;
    private String createtime;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isHaveread() {
        return this.haveread;
    }

    public void setHaveread(boolean haveread) {
        this.haveread = haveread;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String toString() {
        return "name=" + this.name + ";email=" + this.email + ";message=" + this.message;
    }
}
