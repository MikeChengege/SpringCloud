package com.stu.springcloud.modle;

public class VideoComm {
    private int id;
    private int video_id;
    private int user_id;
    private String comt_time;
    private int comt_liked;
    private int comt_dislike;
    private int comt_exam;
    private String comt_content;
    private  User user;

    public int getId() {
        return id;
    }

    public int getVideo_id() {
        return video_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getComt_time() {
        return comt_time;
    }

    public int getComt_liked() {
        return comt_liked;
    }

    public int getComt_dislike() {
        return comt_dislike;
    }

    public int getComt_exam() {
        return comt_exam;
    }

    public String getComt_content() {
        return comt_content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setComt_time(String comt_time) {
        this.comt_time = comt_time;
    }

    public void setComt_liked(int comt_liked) {
        this.comt_liked = comt_liked;
    }

    public void setComt_dislike(int comt_dislike) {
        this.comt_dislike = comt_dislike;
    }

    public void setComt_exam(int comt_exam) {
        this.comt_exam = comt_exam;
    }

    public void setComt_content(String comt_content) {
        this.comt_content = comt_content;
    }

    @Override
    public String toString() {
        return "VideoComm{" +
                "id=" + id +
                ", video_id=" + video_id +
                ", user_id=" + user_id +
                ", comt_time=" + comt_time +
                ", comt_liked=" + comt_liked +
                ", comt_dislike=" + comt_dislike +
                ", comt_exam=" + comt_exam +
                ", comt_content='" + comt_content + '\'' +
                ", user=" + user +
                '}';
    }
}
