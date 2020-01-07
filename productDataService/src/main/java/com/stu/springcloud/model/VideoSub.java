package com.stu.springcloud.model;

public class VideoSub {
    private int id;
    private int video_id;
    private int video_hot;
    private float video_score;
    private String video_playtype;
    private String video_updatetiem;
    private String video_backtime;
    private String video_videotype;
    private String video_duration;

    public void setId(int id) {
        this.id = id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public void setVideo_hot(int video_hot) {
        this.video_hot = video_hot;
    }

    public void setVideo_score(float video_score) {
        this.video_score = video_score;
    }

    public int getId() {
        return id;
    }

    public String getVideo_duration() {
        return video_duration;
    }

    public void setVideo_duration(String video_duration) {
        this.video_duration = video_duration;
    }

    public int getVideo_id() {
        return video_id;
    }

    public int getVideo_hot() {
        return video_hot;
    }

    public float getVideo_score() {
        return video_score;
    }

    public String getVideo_playtype() {
        return video_playtype;
    }

    public void setVideo_playtype(String video_playtype) {
        this.video_playtype = video_playtype;
    }

    public String getVideo_updatetiem() {
        return video_updatetiem;
    }

    public void setVideo_updatetiem(String video_updatetiem) {
        this.video_updatetiem = video_updatetiem;
    }

    public String getVideo_backtime() {
        return video_backtime;
    }

    public void setVideo_backtime(String video_backtime) {
        this.video_backtime = video_backtime;
    }

    public String getVideo_videotype() {
        return video_videotype;
    }

    public void setVideo_videotype(String video_videotype) {
        this.video_videotype = video_videotype;
    }
}
