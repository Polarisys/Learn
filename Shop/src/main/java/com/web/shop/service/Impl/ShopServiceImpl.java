package com.web.shop.service.Impl;

import com.web.shop.dao.AdminDao;
import com.web.shop.dao.ItemDao;
import com.web.shop.dao.UserDao;
import com.web.shop.dto.AddExecution;
import com.web.shop.entity.Admin;
import com.web.shop.entity.Item;
import com.web.shop.entity.User;
import com.web.shop.exception.ErrorNumberException;
import com.web.shop.exception.NoNumberException;
import com.web.shop.service.ShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @anthor sily
 * @date 2019/12/28 - 20:28
 */
@Service
public class ShopServiceImpl implements ShopService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ItemDao itemDao;

    @Resource
    private UserDao userDao;

    @Resource
    private AdminDao adminDao;

    @Override
    public Item getById(long id) {
        return itemDao.queryById(id);
    }

    @Override
    public List<Item> queryAll(int pageNumber, int recordNumber) {
        int startNumber = (pageNumber - 1) * recordNumber + 1;
        return itemDao.queryAll(startNumber, recordNumber);
    }


    @Override
    public List<Item> querySome(String title) {
        return itemDao.querySome(title);
    }

    @Override
    public User validateUser(String username, String password) {
        return userDao.queryUser(username, password);
    }

    @Override
    public Admin validateAdmin(String adminId, String adminPassword) {
        return adminDao.queryAdmin(adminId, adminPassword);
    }

    @Override
    @Transactional
    public AddExecution addToCar(long id, String username, int number) {
        try {
            int update = itemDao.reduceNumber(id, number);
            if (update <= 0) {
                throw new NoNumberException("no number");
            } else {
                //执行添加购物车的操作
                return null;
            }
        } catch (ErrorNumberException e1) {
            throw  e1;
        }
    }
}
