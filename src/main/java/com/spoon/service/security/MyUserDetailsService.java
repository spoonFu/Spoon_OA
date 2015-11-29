package com.spoon.service.security;

import com.spoon.dao.acl.IUserDao;
import com.spoon.dao.acl.IUserRoleDao;
import com.spoon.entity.acl.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 身份验证
 *
 * @author:FuShaoxing
 * @date:2012-10-25 下午03:56:28
 * @version:1.0
 */
@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IUserRoleDao userRoleDao;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        com.spoon.entity.acl.User user = this.userDao.findUserByLoginName(username);
        if (user == null) {
            throw new UsernameNotFoundException("The user with loginName:" + username + " can`t be found!");
        }
        String password = user.getPassword();
        List<Role> roles = this.userRoleDao.listRoleByUserId(user.getId());
        List<GrantedAuthority> authorities = new ArrayList();
        for (Role role : roles) {
            GrantedAuthority authority = new GrantedAuthorityImpl(role.getId());
            authorities.add(authority);
        }
        return new User(username, password, true, true, true, true, authorities);
    }
}
