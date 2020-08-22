package com.springboot.entity;

import javax.persistence.*;

/**
 * @anthor sily
 * @date 2020/2/1 - 10:33
 */
//使用JPA注解配置映射关系
@Entity //告诉JPA这是一个实体类
@Table(name = "user")
public class User {

    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;

    @Column(name = "name")//这是和数据表对应的一个列
    private String name;

    @Column
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
