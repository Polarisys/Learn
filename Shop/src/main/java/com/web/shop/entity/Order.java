package com.web.shop.entity;

import java.util.Date;

/**
 * @anthor sily
 * @date 2019/12/28 - 15:45
 */
public class Order {
    private String orderId;//订单Id
    private int status;//订单状态
    private Date createTime;//订单创建时间
    private Date paymentTime;//订单付款时间
    private String shippingCode;//物流单号
    private long userId;//用户Id

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", paymentTime=" + paymentTime +
                ", shippingCode='" + shippingCode + '\'' +
                ", userId=" + userId +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
