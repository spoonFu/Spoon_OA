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
@Table(name = "cont_message")
public class Message extends MyBaseEntity {
    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    private String message;
    private boolean fresh = false;// 消息是否查看过
    private String ip;
    private String position;
    private Date datetime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFresh() {
        return fresh;
    }

    public void setFresh(boolean fresh) {
        this.fresh = fresh;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getDatetime() {
        if (datetime == null)
            return Calendar.getInstance().getTime();
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "name=" + name + ";email=" + email + ";message=" + message;
    }
}
