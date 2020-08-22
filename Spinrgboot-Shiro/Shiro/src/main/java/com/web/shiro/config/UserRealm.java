package com.web.shiro.config;

import com.web.shiro.pojo.User;
import com.web.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @anthor Tolaris
 * @date 2020/4/7 - 16:00
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        //设置当前用户的权限
        info.addStringPermission(currentUser.getPerms());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        //连接数据库
        User user = userService.queryUserByName(userToken.getUsername());
        //用户名认证
        if (user == null) {
            return null;//抛出异常 UnknownAccountException
        }
        //密码认证
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
