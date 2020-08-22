package com.web.shop.dao;

import com.web.shop.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @anthor sily
 * @date 2019/12/28 - 19:05
 */
public interface UserDao {

    //向数据库中验证输入的账号是否正确
    User queryUser(@Param("username") String username,@Param("password") String password);
}
