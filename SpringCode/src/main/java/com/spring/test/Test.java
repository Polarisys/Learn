package com.spring.test;

import com.spring.config.BeanFactory;
import com.spring.service.TestServiceImpl;

/**
 * @anthor Tolaris
 * @date 2020/8/14 - 21:15
 */
public class Test {

    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory("spring.xml");
        TestServiceImpl service = (TestServiceImpl) beanFactory.getBean("service");
        service.find();
    }
}
