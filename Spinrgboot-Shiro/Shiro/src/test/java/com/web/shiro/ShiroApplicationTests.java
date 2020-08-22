package com.web.shiro;

import com.web.shiro.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void contextLoads() {
        System.out.println(userService.queryUserByName("admin"));
    }

}
