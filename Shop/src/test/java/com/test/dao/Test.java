package com.test.dao;

import com.web.shop.dao.ItemDao;
import com.web.shop.dao.UserDao;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @anthor sily
 * @date 2019/12/28 - 19:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-dao.xml")
public class Test {
    @Resource
    private ItemDao itemDao;

    @Resource
    private UserDao userDao;

    @org.junit.Test
    public void test(){
        //Item item = itemDao.queryById(562379);
        //List<Item> item = itemDao.queryAll(1,5);
        //List<Item> item = itemDao.querySome("三星");
        //User item = userDao.queryUser("zhangsan","e10adc3949ba59abbe56e057f20f883e");
        //System.out.println(item);


    }
}
