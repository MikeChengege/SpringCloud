package com.stu.springcloud.service;

import com.stu.springcloud.mapper.VideoInfoMapper;
import com.stu.springcloud.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoInfoService {
    @Autowired
    VideoInfoMapper videoInfoMapper;
    public List<Video> getVideoInfo(){
        return videoInfoMapper.getBothAll();
    }
    public List<Video> getMostseeInfoAll(){
        return videoInfoMapper.getMostseeInfoAll();
    }
    public List<Video> getRankBothAll(){
        return videoInfoMapper.getRankBothAll();
    }
}
