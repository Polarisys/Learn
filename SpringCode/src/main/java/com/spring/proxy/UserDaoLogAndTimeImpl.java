package com.spring.proxy;

/**
 * @anthor Tolaris
 * @date 2020/8/18 - 16:14
 */
public class UserDaoLogAndTimeImpl extends UserDaoLogImpl {
    @Override
    public void query() {
        System.out.println("time");
        super.query();
    }
}
