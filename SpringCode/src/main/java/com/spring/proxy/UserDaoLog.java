package com.spring.proxy;

/**
 * @anthor Tolaris
 * @date 2020/8/18 - 16:16
 */
public class UserDaoLog implements UserDao {

    private UserDao userDao;

    public UserDaoLog(UserDao userDao) {
        this.userDao = userDao;
    }

    public void query() {
        System.out.println("log");
        userDao.query();
    }
}
