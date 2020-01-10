package com.stu.springcloud.service;

import com.stu.springcloud.mapper.VideoSubMapper;
import com.stu.springcloud.model.VideoSub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoSubService {
    @Autowired
    VideoSubMapper videoSubMapper;
    public void updateSubTime(VideoSub vs){
        videoSubMapper.updateSubTime(vs);
    }
    public void insertVidSub(int id){
        videoSubMapper.insertVidSub(id);
    }
}
