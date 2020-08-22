package com.web.shop.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @anthor sily
 * @date 2019/12/28 - 15:39
 */
public class Item {
    private long id;//商品ID
    private String title;//商品标题
    private String sellPoint;//商品卖点
    private long price;//商品价格
    private int number;//商品数量
    private long cid;//所属类别
    private int status;//商品状态 1-正常 2-下架 3-删除
    private Date created;//创建时间
    private Date updated;//更新时间

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", sellPoint='" + sellPoint + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", cid=" + cid +
                ", status=" + status +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getStatus() {
        if (status == 1) {
            return "正常";
        } else if (status == 2) {
            return "下架";
        } else {
            return "删除";
        }
    }
        public void setStatus ( int status){
            this.status = status;
        }

        public String getCreated () {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String DateCreated = sdf.format(created);
            return DateCreated;
        }

        public void setCreated (Date created){
            this.created = created;
        }

        public Date getUpdated () {
            return updated;
        }

        public void setUpdated (Date updated){
            this.updated = updated;
        }


    }
