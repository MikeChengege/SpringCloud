package com.stu.springcloud.service;


import com.stu.springcloud.mapper.VideoInfoMapper;
import com.stu.springcloud.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvInfoService {
    @Autowired
    VideoInfoMapper videoInfoMapper;
    public List<Video> getVideoByType(int videoType){
        return videoInfoMapper.getVideoByType(videoType);
    }
}
