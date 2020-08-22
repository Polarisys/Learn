package com.web.shop.entity;

/**
 * @anthor sily
 * @date 2019/12/28 - 15:55
 */
public class User {
    private long id;//用户ID
    private String username;//用户姓名
    private String password;//用户密码

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
