package com.test.service;

import com.web.shop.entity.Item;
import com.web.shop.service.ShopService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @anthor sily
 * @date 2019/12/28 - 20:45
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*.xml")
public class Test01 {
    @Resource
    private ShopService shopService;

    @Test
    public void test(){
        //Item item = shopService.getById(635906);
        List<Item> item = shopService.querySome("苹果");
        System.out.println(item);
    }

}
