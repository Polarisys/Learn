package com.web.shiro.service;

import com.web.shiro.mapper.UserMapper;
import com.web.shiro.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @anthor Tolaris
 * @date 2020/4/7 - 20:28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }
}
