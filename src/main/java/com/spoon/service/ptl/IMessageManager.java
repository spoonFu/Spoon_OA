package com.spoon.service.ptl;

import com.spoon.entity.ptl.Message;
import com.spoon.service.ServiceException;

import java.util.List;

/**
 * 留言管理
 * 
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014-5-11 下午08:33:56
 */
public interface IMessageManager {
	public Message findById(String id);

	public String save(Message msg);

	public void update(Message msg);

	public List<Message> getAll();

	public void deleteById(String id) throws ServiceException;
}
