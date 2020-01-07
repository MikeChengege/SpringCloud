package com.stu.springcloud.model;

public class Video {
    private int id;
    private String video_address;
    private int video_type;
    private String video_pic;
    private String video_descript;
    private String video_peop;
    private String video_time;
    private String video_title;
    private int video_hadvisit;

    private int video_exam;
    private int video_like;
    private int video_dislike;
    private int video_comment;
    private int video_download;
    private VideoSub lvs;

    public int getId() {
        return id;
    }

    public String getVideo_address() {
        return video_address;
    }

    public int getVideo_type() {
        return video_type;
    }

    public String getVideo_pic() {
        return video_pic;
    }

    public String getVideo_descript() {
        return video_descript;
    }

    public String getVideo_peop() {
        return video_peop;
    }

    public String getVideo_time() {
        return video_time;
    }

    public int getVideo_like() {
        return video_like;
    }

    public int getVideo_dislike() {
        return video_dislike;
    }

    public int getVideo_comment() {
        return video_comment;
    }

    public int getVideo_download() {
        return video_download;
    }

    public String getVideo_title() {
        return video_title;
    }

    public int getVideo_hadvisit() {
        return video_hadvisit;
    }

    public VideoSub getLvs() {
        return lvs;
    }

    public int getVideo_exam() {
        return video_exam;
    }

    public void setVideo_exam(int video_exam) {
        this.video_exam = video_exam;
    }

    public void setLvs(VideoSub lvs) {
        this.lvs = lvs;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVideo_address(String video_address) {
        this.video_address = video_address;
    }

    public void setVideo_type(int video_type) {
        this.video_type = video_type;
    }

    public void setVideo_pic(String video_pic) {
        this.video_pic = video_pic;
    }

    public void setVideo_descript(String video_descript) {
        this.video_descript = video_descript;
    }

    public void setVideo_peop(String video_peop) {
        this.video_peop = video_peop;
    }

    public void setVideo_time(String video_time) {
        this.video_time = video_time;
    }

    public void setVideo_like(int video_like) {
        this.video_like = video_like;
    }

    public void setVideo_dislike(int video_dislike) {
        this.video_dislike = video_dislike;
    }

    public void setVideo_comment(int video_comment) {
        this.video_comment = video_comment;
    }

    public void setVideo_download(int video_download) {
        this.video_download = video_download;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public void setVideo_hadvisit(int video_hadvisit) {
        this.video_hadvisit = video_hadvisit;
    }
}
