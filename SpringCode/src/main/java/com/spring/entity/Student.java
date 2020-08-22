package com.spring.entity;

import com.spring.annotation.Entity;

/**
 * @anthor Tolaris
 * @date 2020/8/6 - 16:35
 */
@Entity("city")
public class Student {

    private String name;
    private String age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
