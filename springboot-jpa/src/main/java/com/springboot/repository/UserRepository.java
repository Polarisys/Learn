package com.springboot.repository;

import com.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @anthor sily
 * @date 2020/2/1 - 10:39
 */
public interface UserRepository extends JpaRepository<User,Integer> {

}
