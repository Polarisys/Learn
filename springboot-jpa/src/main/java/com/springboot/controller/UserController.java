package com.springboot.controller;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @anthor sily
 * @date 2020/2/1 - 11:03
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user = userRepository.findById(id).get();
        return  user;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User user1 = userRepository.save(user);
        return user1;
    }
}
