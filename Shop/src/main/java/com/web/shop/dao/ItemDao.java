package com.web.shop.dao;

import com.web.shop.entity.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @anthor sily
 * @date 2019/12/28 - 16:02
 */
public interface ItemDao {
    //根据ID查询商品
    Item queryById(long id);

    //根据每页的记录和数据筛选数据
    List<Item> queryAll(@Param("startNumber") int startNumber,@Param("recordNumber") int recordNumber);

    //减少库存的数量，用返回值判断当前库存是否还有商品
    int reduceNumber(long id,int number);

    //根据标题查询商品
    List<Item> querySome(String title);
}
