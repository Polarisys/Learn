package com.spring;

import com.spring.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @anthor Tolaris
 * @date 2020/8/6 - 16:38
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("application.xml");
        Student student = (Student)applicationContext.getBean("student");
        System.out.println(student);
    }
}
