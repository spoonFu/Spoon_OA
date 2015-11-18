package com.spoon.service.ptl;

import java.util.List;

import com.spoon.entity.ptl.Navigation;

/**
 * 菜单管理
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年12月28日 下午2:51:21
 */
public interface INavigationManager {
	public List<Navigation> findAll();
}
