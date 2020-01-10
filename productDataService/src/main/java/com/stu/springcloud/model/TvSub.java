package com.stu.springcloud.model;

public class TvSub {
    private int id;
    private int videoid;
    private String drama_series;
    private String video_address;
    private String video_depict;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVideoid() {
        return videoid;
    }

    public void setVideoid(int videoid) {
        this.videoid = videoid;
    }

    public String getDrama_series() {
        return drama_series;
    }

    public void setDrama_series(String drama_series) {
        this.drama_series = drama_series;
    }

    public String getVideo_address() {
        return video_address;
    }

    public void setVideo_address(String video_address) {
        this.video_address = video_address;
    }

    public String getVideo_depict() {
        return video_depict;
    }

    public void setVideo_depict(String video_depict) {
        this.video_depict = video_depict;
    }
}
