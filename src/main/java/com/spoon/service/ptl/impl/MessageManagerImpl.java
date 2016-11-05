package com.spoon.service.ptl.impl;

import com.spoon.dao.ptl.IMessageDao;
import com.spoon.entity.ptl.Message;
import com.spoon.service.MyBaseService;
import com.spoon.service.ServiceException;
import com.spoon.service.ptl.IMessageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 留言管理
 * 
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014-5-11 下午08:35:09
 */
@Service("messageManager")
public class MessageManagerImpl extends MyBaseService implements IMessageManager {
	@Autowired
	private IMessageDao messageDao;

	@Override
	@Transactional
	public String save(Message msg) {
		return messageDao.save(msg).toString();
	}

	@Override
	@Transactional
	public void deleteById(String id) throws ServiceException {
		Message msg = messageDao.findById(id);
		if (msg==null)
			throw new ServiceException("删除的消息不存在");
		messageDao.delete(msg);
	}

	@Override
	public List<Message> getAll() {
		return messageDao.getAll(" order by time desc");
	}

	@Override
	public Message findById(String id) {
		return messageDao.findById(id);
	}

	@Override
	@Transactional
	public void update(Message msg) {
		messageDao.update(msg);
	}

}
