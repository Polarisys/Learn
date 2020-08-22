package com.web.shiro.mapper;

import com.web.shiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @anthor Tolaris
 * @date 2020/4/7 - 17:28
 */
@Repository
@Mapper
public interface UserMapper {

    User queryUserByName(String username);
}
