package com.web.shop.enums;

/**
 * @anthor sily
 * @date 2020/1/13 - 13:46
 */
public enum AddStateEnum {
    SUCCESS(1, "添加成功"), NO_NUMBER(0, "库存不足"), NUMBER_ERROR(-1, "数量错误"), INNER_ERROR(-2, "系统异常");

    private int state;

    private String stateInfo;

    AddStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

}
