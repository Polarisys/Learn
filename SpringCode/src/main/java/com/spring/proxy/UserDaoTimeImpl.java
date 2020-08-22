package com.spring.proxy;

/**
 * @anthor Tolaris
 * @date 2020/8/18 - 16:13
        */
public class UserDaoTimeImpl extends UserDaoImpl {
    @Override
    public void query() {
        System.out.println("time");
        super.query();
    }
}
