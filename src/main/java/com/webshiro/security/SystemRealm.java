package com.webshiro.security;

import com.sun.java.swing.plaf.windows.resources.windows;
import com.webshiro.dao.UserMapper;
import com.webshiro.entity.Permission;
import com.webshiro.entity.Role;
import com.webshiro.entity.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/2/11 0011.
 */
@Service
public class SystemRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String princial = (String) principalCollection.getPrimaryPrincipal();
        User userRole = userMapper.findRolesByUserName(princial);
        User userMapperPermission = userMapper.findPermissionsByUserName(princial);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for(Role role:userRole.getRoles()){
            info.addRole(role.getRoleName());
        }
        for(Permission permission:userMapperPermission.getPermissions()){
            info.addStringPermission(permission.getPermission());
        }

        //添加用户权限
       // info.addStringPermission("user");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        User user = userMapper.findUserByUsername(userName);
        if(user==null){
            throw new AuthenticationException("无账号");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userName,user.getPassword(), ByteSource.Util.bytes(userName+user.getSalt()),this.getName());
        return info;
    }


}
