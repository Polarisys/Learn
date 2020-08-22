package com.web.shop.service;

import com.web.shop.dto.AddExecution;
import com.web.shop.entity.Admin;
import com.web.shop.entity.Item;
import com.web.shop.entity.User;

import java.util.List;

/**
 * @anthor sily
 * @date 2019/12/28 - 20:28
 */
public interface ShopService {

    //根据ID查询商品
    Item getById(long id);

    //根据每页的记录和数据筛选数据
    List<Item> queryAll(int pageNumber, int recordNumber);

    //根据标题查询商品
    List<Item> querySome(String title);

    //向数据库中验证输入的账号是否正确
    User validateUser(String username, String password);

    //向数据库中验证输入的管理员账号是否正确
    Admin validateAdmin(String adminId,String adminPassword);

    AddExecution addToCar(long id,String username,int number);

}
