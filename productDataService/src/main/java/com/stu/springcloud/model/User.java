package com.stu.springcloud.model;

/**
 * Created by mikechen on 2018/9/18.
 */
public class User {
    private int id;
    private String username;
    private String password;
//    private String telephone;
//    private String email;
//    private String regdate;
//    private String photo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
