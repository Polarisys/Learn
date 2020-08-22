package com.web.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @anthor Tolaris
 * @date 2020/4/7 - 15:59
 */
@Configuration
public class ShiroConfig {


    //创建ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(
            @Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //添加shiro的内置过滤器
        /*
            anno：无需认证就可以访问
            authc：必须认证了才可以访问
            user：必须拥有记住我的功能才可以用
            perms：拥有对某个资源的权限才能访问
            role：拥有某得角色的权限才能访问
         */

        //拦截
        Map<String, String> filterMap = new LinkedHashMap<>();

        //授权
        filterMap.put("/user/add", "perms[user:add]");
        filterMap.put("/user/update", "perms[user:update]");

        filterMap.put("/user/*", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        //设置登录的请求
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        //设置未授权的请求
        shiroFilterFactoryBean.setUnauthorizedUrl("/noauth");
        return shiroFilterFactoryBean;
    }

    //创建DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(
            @Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建realm对象
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }


    //整合ShiroDialect：用来整合shiro和thymeleaf
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
