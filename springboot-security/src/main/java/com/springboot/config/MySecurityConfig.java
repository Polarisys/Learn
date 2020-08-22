package com.springboot.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @anthor sily
 * @date 2020/2/5 - 10:56
 */
@EnableWebSecurity
public class MySecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        http.formLogin();

        http.logout().logoutSuccessUrl("/");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP2")
                .and().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2","VIP3")
                .and().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("wangwu").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP3");
    }


}
