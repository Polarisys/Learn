package com.spring.proxy;

/**
 * @anthor Tolaris
 * @date 2020/8/18 - 16:11
 */
public class Test {

    public static void main(String[] args) {
//        UserDaoImpl userDao = new UserDaoLogAndTimeImpl();
//        userDao.query();

        UserDaoLog userDaoLog = new UserDaoLog(new UserDaoImpl());
        userDaoLog.query();
    }
}
