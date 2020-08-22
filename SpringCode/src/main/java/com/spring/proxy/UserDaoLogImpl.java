package com.spring.proxy;

/**
 * @anthor Tolaris
 * @date 2020/8/18 - 16:12
 */
public class UserDaoLogImpl extends UserDaoImpl {
    @Override
    public void query() {
        System.out.println("log");
        super.query();
    }
}
