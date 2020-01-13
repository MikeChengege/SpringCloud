package com.stu.springcloud.service;

import com.stu.springcloud.mapper.VideoSubMapper;
import com.stu.springcloud.model.VideoSub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoSubService {
    @Autowired
    VideoSubMapper videoSubMapper;
    public void updateSubTime(VideoSub vs){
        videoSubMapper.updateSubTime(vs);
    }

    public void updateSub(VideoSub vs){
        videoSubMapper.updateSub(vs);
    }
    public void insertVidSub(int id){
        videoSubMapper.insertVidSub(id);
    }
    public List<VideoSub> getSub(){
       return videoSubMapper.getSub();
    }

    public VideoSub getSubById(int id){
       return videoSubMapper.getSubById(id);
    }
}
