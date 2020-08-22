package com.pojo;

/**
 * @anthor Tolaris
 * @date 2020/4/5 - 15:09
 */
public class Address {
    private String address;

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
