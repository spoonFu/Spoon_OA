package com.spoon.dao.ptl.impl;

import com.spoon.dao.ptl.INavigationDao;
import org.springframework.stereotype.Repository;

import com.spoon.dao.MyBaseDaoImpl;
import com.spoon.entity.ptl.Navigation;

/**
 * 导航 DAO
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年12月28日 下午2:47:44
 */
@Repository("navigationDao")
public class NavigationDaoImpl extends MyBaseDaoImpl<Navigation> implements INavigationDao {

}
