package com.stu.springcloud.modle;

public class UserAdv {
    private int id;
    private int user_id;
    private String username;
    private String advtext;
    private String advtime;
    private int advtype;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getAdvtext() {
        return advtext;
    }


    public int getAdvtype() {
        return advtype;
    }

    public void setAdvtype(int advtype) {
        this.advtype = advtype;
    }

    public void setAdvtext(String advtext) {
        this.advtext = advtext;
    }

    public String getAdvtime() {
        return advtime;
    }

    public void setAdvtime(String advtime) {
        this.advtime = advtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
