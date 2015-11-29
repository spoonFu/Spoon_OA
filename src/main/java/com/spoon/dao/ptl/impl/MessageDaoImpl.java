package com.spoon.dao.ptl.impl;

import com.spoon.dao.ptl.IMessageDao;
import org.springframework.stereotype.Repository;

import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.entity.ptl.Message;

/**
 * 类说明
 * 
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014-5-11 下午08:33:02
 */
@Repository("messageDao")
public class MessageDaoImpl extends MyBaseDaoImpl<Message> implements IMessageDao {

}
