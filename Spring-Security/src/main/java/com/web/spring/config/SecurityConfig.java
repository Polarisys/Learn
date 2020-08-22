package com.web.spring.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @anthor Tolaris
 * @date 2020/4/7 - 1:26
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人都可以访问，功能页只有对应有权限的人才能访问
        //请求授权的规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //开启默认登录页面
        http.formLogin().loginPage("/toLogin").usernameParameter("username")
                .passwordParameter("password").loginProcessingUrl("/login");

        //开启注销功能，跳到首页
        http.csrf().disable();//关闭csrf功能，登录失败可能存在的问题
        http.logout().logoutSuccessUrl("/");

        //开启记住我功能，cookie默认保存两周，自定义接收前端的参数
        http.rememberMe().rememberMeParameter("remeber");
    }

    //认证
    //密码编码：PasswordEncoder
    //在Spring Security5.0+ 新增了很多加密方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("Tolaris").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1")
                .and()
                .withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2")
                .and()
                .withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2",
                "vip3");
    }
}
