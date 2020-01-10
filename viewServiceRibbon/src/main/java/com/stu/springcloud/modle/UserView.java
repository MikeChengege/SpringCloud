package com.stu.springcloud.modle;

public class UserView {
    private int id;
    private int userid;
    private int videoid;
    private String vistime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getVideoid() {
        return videoid;
    }

    public void setVideoid(int videoid) {
        this.videoid = videoid;
    }

    public String getVistime() {
        return vistime;
    }

    public void setVistime(String vistime) {
        this.vistime = vistime;
    }
}
