package com.spring.service;

import com.spring.dao.TestDao;

/**
 * @anthor Tolaris
 * @date 2020/8/21 - 14:06
 */
public class TestServiceImpl implements TestService {

    private TestDao testDao;


    public void find() {
        System.out.println("testService");
        testDao.query();
    }
}
