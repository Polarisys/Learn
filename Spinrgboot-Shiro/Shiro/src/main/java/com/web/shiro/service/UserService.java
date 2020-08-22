package com.web.shiro.service;

import com.web.shiro.pojo.User;

/**
 * @anthor Tolaris
 * @date 2020/4/7 - 20:27
 */
public interface UserService {

    User queryUserByName(String username);
}
