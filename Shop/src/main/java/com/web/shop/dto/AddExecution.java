package com.web.shop.dto;

import com.web.shop.enums.AddStateEnum;

/**
 * @anthor sily
 * @date 2020/1/13 - 21:07
 */
public class AddExecution {

    //图书ID
    private long id;

    //结果状态
    private int state;

    //状态标识
    private String stateInfo;

    @Override
    public String toString() {
        return "AddExecution{" +
                "id=" + id +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }

    //加入失败的构造器
    public AddExecution(long id, AddStateEnum addStateEnum) {
        this.id = id;
        this.state = addStateEnum.getState();
        this.stateInfo = addStateEnum.getStateInfo();
    }

    public AddExecution(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
