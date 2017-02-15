package com.org.common.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.org.entity.system.User;

public class NjqRealm extends AuthorizingRealm{
    Logger logger=LoggerFactory.getLogger(NjqRealm.class);
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("进入授权");
        System.out.println(principals.getPrimaryPrincipal());
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("进入验证");
        /*NjqToken njqToken=(NjqToken) token;
        String username = njqToken.getUsername();
        char[] password=njqToken.getPassword();
        System.out.println(username);
        System.out.println(password.toString());*/
        System.out.println(token.getCredentials().toString());
        User user = new User();
        user.setId(Long.parseLong("1"));
        user.setUserName("chenghang111");
        user.setPassword("1");
        if (user == null) {
            throw new UnknownAccountException();// 没找到帐号
        }
        AuthenticationInfo info= new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),getName());// realm name
        SecurityUtils.getSubject().getSession().setAttribute("user", user);
        return  info;
        
    }

}
