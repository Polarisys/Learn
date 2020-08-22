package com.web.shop.entity;

import java.util.Date;

/**
 * @anthor sily
 * @date 2019/12/28 - 15:52
 */
public class OrderShipping {
    private String orderId;//订单ID
    private String receiverName;//收货人全名
    private String receiverState;//省份
    private String receiverCity;//城市
    private String receiverDistrict;//区县
    private String receiverAddress;//收货地址
    private Date created;//创建时间

    @Override
    public String toString() {
        return "OrderShipping{" +
                "orderId='" + orderId + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverState='" + receiverState + '\'' +
                ", receiverCity='" + receiverCity + '\'' +
                ", receiverDistrict='" + receiverDistrict + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", created=" + created +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverState() {
        return receiverState;
    }

    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
