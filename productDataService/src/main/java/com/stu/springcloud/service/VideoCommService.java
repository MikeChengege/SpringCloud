package com.stu.springcloud.service;


import com.stu.springcloud.mapper.VideoCommMapper;
import com.stu.springcloud.model.VideoComm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoCommService {

    @Autowired
    VideoCommMapper videoCommMapper;
    public List<VideoComm> getCommAndPeo(int id){
        return videoCommMapper.getCommAndPeo(id);
    }
    public List<VideoComm> getAllComm(){
        return videoCommMapper.getAll();
    }
    public void insertComm(VideoComm vic){
        videoCommMapper.insertComm(vic);
    }
    public void updateHadLike(VideoComm vic){
        videoCommMapper.updateHadLike(vic);
    }
    public void updVideocomm(VideoComm vic){
        videoCommMapper.updVideocomm(vic);
    }

    public void delVideocomm(int id){
        videoCommMapper.delVideocomm(id);
    }
    public VideoComm getCommById(int id){
        return videoCommMapper.getById(id);
    }
}
