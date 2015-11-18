package com.spoon.entity.sys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.spoon.entity.MyBaseEntity;
import com.spoon.entity.acl.User;
import com.spoon.entity.sys.enums.LogType;

/**
 * 记录用户操作的日志
 * 
 * @author:FuShaoxing
 * @date:2012-10-29 下午01:17:43
 * @version:1.0
 */
@Entity
@Table(name = "sys_log")
public class SystemLog extends MyBaseEntity {
	private static final long serialVersionUID = 1L;

	private String ip;
	private String time;
	private User user;
	private String info;
	private LogType type;

	@Column
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Enumerated(EnumType.STRING)
	@Column
	public LogType getType() {
		return type;
	}

	public void setType(LogType type) {
		this.type = type;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
