package com.spoon.service.ptl;

import com.spoon.dao.ptl.INavigationDao;
import com.spoon.entity.ptl.Navigation;
import com.spoon.service.MyBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单管理
 * @author FuShaoxing E-mail: xinyu2010@126.com
 * @version createTime：2014年12月28日 下午2:51:32
 */
@Service("navigationManager")
public class NavigationManagerImpl extends MyBaseService implements INavigationManager {
    @Autowired
    private INavigationDao navigationDao;

    @Override
    public List<Navigation> findAll() {
        return navigationDao.getAll(" order by level_code");
    }

}
